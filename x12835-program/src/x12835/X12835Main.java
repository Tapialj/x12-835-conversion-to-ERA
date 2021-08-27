package x12835;

import java.io.*;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This program reads in a text file of job names, then gathers that Job information from the database
 * and builds out an ERA based off of the Job query.
 * @author lewist
 *
 */
public class X12835Main 
{
    
	static 
    {
        try 
        {
            System.load("C:\\Windows\\System32\\chilkat.dll");
        }
        catch(UnsatisfiedLinkError e)
        {
          System.err.println("Native code library failed to load.\n" + e);
          System.exit(1);
        }
    }
	
	public static String	jdbcServerUrl = "jdbc:sqlserver://192.168.1.16:1881;", 
							databaseName = "ECCS",
							jdbcMySQLUrl = "jdbc:mysql://192.168.1.11:3306;",
							mySQLDatabaseName = "eclaims";
	public static databaseConnection	msSQLConnection,
										mySQLconnection;
	public static X12835Job				x12835Job;
	public static JobDataResultSet		jobResultSet;
	
	public static void main(String[] args) 
	{
		String 	jobName = "";
		
		try
		{
			Scanner inputFile = openFile(args[0].toString().trim()); //"C:\\Users\\lewist\\Documents\\TestFile.txt"); this is a test file I used for debugging
			//Scanner inputFile = new Scanner(new FileReader(args[0].toString().trim())); this is if we want to remove the openFile method and do it all
			//in the main method.
			
			while(inputFile.hasNext())
			{
				try
				{
					jobName = inputFile.next().toString();
					System.out.print(jobName + "-");
					setUpX12835Job(jobName.trim());
					System.out.println(" Done.");
				}
				catch(SQLTimeoutException t) 
		    	{
					System.out.println(" Finished with error: " + t.getMessage());
					//continue the loop until there are no more job Names
		    	}
				catch(SQLException e)
				{
					System.out.println(" Finished with error: " + e.getMessage());
					//continue the loop until there are no more job Names
				}
				catch(ClassNotFoundException c)
				{
					//will need to end the program and warn the user.
				}
				catch(IOException o)
				{
					System.out.println("Could not write temp file! Error: " + o.getMessage());
				}
				catch(Exception f)
				{
					System.out.println("Fatal error with this job! Era not built!");
					f.printStackTrace();
					File file = new File("\\\\reports01\\payorreports$\\CARRIERREPORTS_T\\For ERA Test\\StackTraceFatal.txt");
					
					try
					{
						if(!file.exists())
						{
							file.createNewFile();
						}
						
						FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
						PrintWriter pw = new PrintWriter(fw);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write("Job Name: " + jobName + "\nDate Time: " + getCurrentTimeStamp() + "\n");
						f.printStackTrace(pw);
						//tempWriter.write(f.toString() + "\n\n");
						bw.write("\r\n\r\n");
						bw.close();
						pw.close();
						fw.close();
					}
					catch(IOException s)
					{
						System.out.println("Could not write to stack trace text file! Error: " + s.getMessage());
					}
				}
			}
			
			inputFile.close();
		}	
		catch(IOException i)
		{
			System.out.print("Master ERA File does not exist!");
		}

	}
	
	/**
	 * Opens a text file to read.
	 * @param FileName The file location and name that is to be read in
	 * @return Scanner of the file to be read
	 * @throws IOException If exception thrown, throw a new exception and catch in main method
	 */
    public static Scanner openFile(String FileName) throws IOException
    {    
	    try
	    {
	    	return  new Scanner(new FileReader(FileName));
	    }
	    catch(IOException e)
	    {
	    	throw new IOException(e.getMessage());
	    }
    }
	
	/**
	 * This method will build an x12835Job object that will contain all the information in the database associated with
	 * that job name.
	 * @param jobName The name of the job in the database
	 */
	public static void setUpX12835Job(String jobName)  throws SQLTimeoutException, SQLException, ClassNotFoundException, IOException
	{
		String 	jobQuery = "select * from x12_835_jobs where job_name = '" + jobName + "'",
				errNum;
		ArrayList<EobResult> eobResultList = null;
		@SuppressWarnings("unused")
		ChilKatEmails ckEmail;
		
		try
		{
			msSQLConnection = new databaseConnection(60,30,jdbcServerUrl,databaseName);
			
			jobResultSet = msSQLConnection.queryJobName(jobQuery);
				
			//initialize with result set object
			x12835Job = new X12835Job(jobResultSet);
				
			msSQLConnection.setCmdTimeout(Integer.parseInt(jobResultSet.getCmdTimeout()));
			msSQLConnection.setConnTimeout(Integer.parseInt(jobResultSet.getCnnTimeout()));
				
			eobResultList = x12835Job.processSpool(msSQLConnection);
			
			msSQLConnection.writeLog(x12835Job,eobResultList.get(0));
			
			if(x12835Job.getRemitSelected() == 0)
			{
				if(x12835Job.isZeroBuiltEnabled())
				{
					ckEmail = new ChilKatEmails(x12835Job,eobResultList,"Zero");
				}
			}
			else if(x12835Job.getRemitSelected() != x12835Job.getRemitBuilt())
			{
				if(x12835Job.isSomeBuiltEnabled())
				{
					ckEmail = new ChilKatEmails(x12835Job,eobResultList,"Some");
				}
			}
			else if(x12835Job.getRemitSelected() == x12835Job.getRemitBuilt())
			{
				if(x12835Job.isSuccessEnabled())
				{
					ckEmail = new ChilKatEmails(x12835Job,eobResultList,"Success");
				}
			}
			//this is the unlock code for the ChilKatMail.dll 1EClaimsMAIL_vATJIN0n6wDC
				
			msSQLConnection.closeConnection();
		}
		catch(SQLTimeoutException t)
		{
			File file = new File(x12835Job.getTempPath());
			
			if(file.exists())
			{
				file.delete();
			}
			
			if(x12835Job.isErrorEnabled())
			{
				ckEmail = new ChilKatEmails(x12835Job,eobResultList,"GenErr","5000",t.getMessage());
			}
			msSQLConnection.writeErrLog(x12835Job,"5000",t.getMessage());
			msSQLConnection.closeConnection();
			throw new SQLTimeoutException(t.getMessage());
		}
		catch(SQLException e)
		{
			File file = new File(x12835Job.getTempPath());
			
			if(file.exists())
			{
				file.delete();
			}
			
			if(e.getMessage().toLowerCase().contains("The query has timed out.".toLowerCase()))
			{
				errNum = "5000";
			}
			else
			{
				errNum = "9999";
			}
			
			if(x12835Job.isErrorEnabled())
			{
				ckEmail = new ChilKatEmails(x12835Job,eobResultList,"GenErr",errNum,e.getMessage());
			}
			msSQLConnection.writeErrLog(x12835Job,errNum,e.getMessage());
			msSQLConnection.closeConnection();
			throw new SQLException(e.getMessage());
		}
	}
	
	/**
	 * Gets the current date time stamp
	 * @return Date time stamp
	 */
	public static String getCurrentTimeStamp() 
	{
	    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}
	
}
