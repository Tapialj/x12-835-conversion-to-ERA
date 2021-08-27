package x12835;

import java.text.*;
import java.util.*;

import com.chilkatsoft.CkEmail;
import com.chilkatsoft.CkMailMan;

public class ChilKatEmails 
{

	private X12835Job x12835Job;
	private ArrayList<EobResult> eobResultList;
	private	String 	emailToSend,
					errNum,
					errMsg;
	
	/**
	 * 
	 * @param x12835Job
	 * @param eobResultList
	 * @param emailToSend
	 */
	public ChilKatEmails(X12835Job x12835Job, ArrayList<EobResult> eobResultList, String emailToSend)
	{
		this.x12835Job = x12835Job;
		this.eobResultList = eobResultList;
		this.emailToSend = emailToSend;
		
		sendEmail();
	}
	
	/**
	 * 
	 * @param x12835Job
	 * @param eobResultList
	 * @param emailToSend
	 * @param errNum
	 * @param errMsg
	 */
	public ChilKatEmails(X12835Job x12835Job, ArrayList<EobResult> eobResultList, String emailToSend, String errNum, String errMsg)
	{
		this.x12835Job = x12835Job;
		this.eobResultList = eobResultList;
		this.emailToSend = emailToSend;
		this.errNum = errNum;
		this.errMsg = errMsg;
		
		sendEmail();
	}

	/**
	 * 
	 */
	private void sendEmail()
	{
		String[] recip;
		CkMailMan mailman = new CkMailMan();
        mailman.UnlockComponent("1EClaimsMAIL_vATJIN0n6wDC");
        mailman.put_SmtpHost(this.x12835Job.getSmtpHost());
        
	    if(!mailman.VerifySmtpConnection())
	    {
	    	mailman.put_SmtpHost(this.x12835Job.getSmtpAlt());
	    }
	       
	    switch(this.emailToSend)
	    {
	    case "Success":
	    	if(!this.x12835Job.getSuccessFromAddr().trim().isEmpty())
	    	{
	    		recip = getRecips(this.emailToSend);
		    	for(int i = 0; i < recip.length; i++)
			    {
			    	buildSuccessEmail(mailman,recip[i]);
			    }
	    	}
	    	break;
	    case "GenErr":
	    	if(!this.x12835Job.getErrorFromAddr().trim().isEmpty())
	    	{
	    		recip = getRecips(this.emailToSend);
		    	for(int i = 0; i < recip.length; i++)
			    {
			    	buildErrorEmail(mailman,recip[i]);
			    }
	    	}
	    	break;
	    case "Zero":
	    	if(!this.x12835Job.getZeroBuiltFromAddr().trim().isEmpty())
	    	{
	    		recip = getRecips(this.emailToSend);
		    	for(int i = 0; i < recip.length; i++)
			    {
		    		buildSuccessEmail(mailman,recip[i]);
			    }
	    	}
	    	break;
	    case "Some":
	    	if(!this.x12835Job.getSomeBuiltFromAddr().trim().isEmpty())
	    	{
	    		recip = getRecips(this.emailToSend);
		    	for(int i = 0; i < recip.length; i++)
			    {
		    		buildSuccessEmail(mailman,recip[i]);
			    }
			}
	    	break;
	    }
       
	}
	
	/**
	 * 
	 * @param toFind
	 * @return
	 */
	private String[] getRecips(String toFind)
	{
		String[] recip;
		
		switch(toFind)
		{
		case "Success":
			recip = this.x12835Job.getSuccessRecip().split(";");
			break;
		case "GenErr":
			recip = this.x12835Job.getErrorRecip().split(";");
			break;
		case "Zero":
			recip = this.x12835Job.getZeroBuiltRecip().split(";");
			break;
		case "Some":
			recip = this.x12835Job.getSomeBuiltRecip().split(";");
			break;
		default:
			recip = null;
			break;
		}

		return recip;
	}
	
	/**
	 * 
	 * @param mailman
	 * @param recip
	 */
	private void buildSuccessEmail(CkMailMan mailman,String recip)
	{
		String 	outputRule,
				dateString,
				body;
		CkEmail email = new CkEmail();
		EobResult eobResult;
		
		try
		{
			DateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy h:mm:ss a");
			Calendar cal = Calendar.getInstance();
			dateString = dateFormat.format(cal.getTime());
		}
		catch(Exception e)
		{
			dateString = "";
		}
		
		switch(this.x12835Job.getOutputFileExistsRule())
		{
			case "0":
				outputRule = "Increment FileName";
				break;
			case "1":
				outputRule = "Increment Extension";
				break;
			case "2":
				outputRule = "Overwrite Existing File";
				break;
			default:
				outputRule = "";
				break;
		}
		
		email.AddTo("",recip);
		
		switch(this.emailToSend)
		{
		case "Success":
			email.put_Subject("EClaims X12 835 Java <Success!>");
		    email.put_FromAddress(this.x12835Job.getSuccessFromAddr());
		    email.put_FromName(this.x12835Job.getSuccessFromName());
			break;
		case "Zero":
			email.put_Subject("EClaims X12 835 Java <Zero Headers Selected>");
		    email.put_FromAddress(this.x12835Job.getZeroBuiltFromAddr());
		    email.put_FromName(this.x12835Job.getZeroBuiltFromName());
			break;
		case "Some":
			email.put_Subject("EClaims X12 835 Java <Some Reports Built>");
		    email.put_FromAddress(this.x12835Job.getSomeBuiltFromAddr());
		    email.put_FromName(this.x12835Job.getSomeBuiltFromName());
			break;
		}

	    body = "EClaims X12 835 Java Version " + this.x12835Job.getVersion() + "\r\n\r\n";
	    body += "Date\\Time        : " + dateString + "\r\n";
	    body += "User ID          : " + this.x12835Job.getUserID() + "\r\n";
	    body += "Workstation      : " + this.x12835Job.getWorkstation() + "\r\n\r\n";
	    body += "App Name         : " + this.x12835Job.getAppName() + "\r\n";
	    body += "App Ver          : " + this.x12835Job.getVersion() + "\r\n";
	    body += "App UID          : " + this.x12835Job.getUserID() + "\r\n";
	    body += "App WS           : " + this.x12835Job.getWorkstation() + "\r\n\r\n";
	    body += "Job Name         : " + this.x12835Job.getJobName() + "\r\n";
	    body += "Job Type         : " + this.x12835Job.getJobType() + "\r\n";
	    body += "Activity         : Process Spool\r\n\r\n";
	    body += "SQL Query        : " + this.x12835Job.getSqlSelect() + "\r\n";
	    body += "Cnn Timeout      : " + this.x12835Job.getCnnTimeout() + "\r\n";
	    body += "Cmd Timeout      : " + this.x12835Job.getCmdTimeout() + "\r\n\r\n";
	    body += "MySQL DSN        : " + this.x12835Job.getRptSysDsn() + "\r\n";
	    body += "Cnn Timeout      : " + this.x12835Job.getRptCnnTimeout() + "\r\n";
	    body += "Cmd Timeout      : " + this.x12835Job.getRptCmdTimeout() + "\r\n\r\n";
	    body += "Built Stat Mark  : " + this.x12835Job.getBuiltStatusMark() + "\r\n\r\n";
	    body += "Serial Lookup    : " + (this.x12835Job.isReport() ? (this.x12835Job.isSerialNoLookup() ? "Yes" : "No") : "N/A") + "\r\n";
	    body += "Serial Timeout   : " + (this.x12835Job.isReport() ? this.x12835Job.getSerialNoLookupCmdTimeout() : "N/A") + "\r\n\r\n";
	    body += "Tax ID Rollback  : " + (this.x12835Job.isProvTaxIDRollBack() ? "Yes" : "No") + "\r\n";
	    body += "Tax ID Mark      : " + (this.x12835Job.isProvTaxIDRollBack() ? "N/A" : this.x12835Job.getProvTaxIDMark()) + "\r\n\r\n";
	    body += "Enrlmnt Rollback : " + (this.x12835Job.isSub835EnrollmentRollback() ? "Yes" : "No") + "\r\n";
	    body += "Enrlmnt Mark     : " + (this.x12835Job.isSub835EnrollmentRollback() ? "N/A" : this.x12835Job.getSub835EnrollmentMark()) + "\r\n\r\n";
	    body += "Inactive Report  : " + (this.x12835Job.isReport() ? (this.x12835Job.isPostSubInactiveRpt() ? "Yes" : "No") : "N/A") + "\r\n";
	    body += "Inactive Mark    : " + this.x12835Job.getSubInactiveMark() + "\r\n\r\n";
	    body += "Cancelled Report : " + (this.x12835Job.isReport() ? (this.x12835Job.isPostSubCancelledRpt() ? "Yes" : "No") : "N/A") + "\r\n";
	    body += "Cancelled Mark   : " + this.x12835Job.getSubCancelledMark() + "\r\n\r\n";
	    body += "Cred Hold Report : " + (this.x12835Job.isReport() ? (this.x12835Job.isPostSubCreditHoldRpt() ? "Yes" : "No") : "N/A") + "\r\n";
	    body += "Cred Hold Mark   : " + this.x12835Job.getSubCreditHoldMark() + "\r\n\r\n";
	    body += "Closed Report    : " + (this.x12835Job.isReport() ? (this.x12835Job.isPostSubClosedRpt() ? "Yes" : "No") : "N/A") + "\r\n";
	    body += "Closed Mark      : " + this.x12835Job.getSubClosedMark() + "\r\n\r\n";
	    body += "Output Rule      : " + outputRule + "\r\n";
	    body += "File Err Mark    : " + ((this.x12835Job.getOutputFileExistsRule().equalsIgnoreCase("3")) ? this.x12835Job.getFileErrorMark() : "N/A") + "\r\n";
	    body += "Output Path      : " + this.x12835Job.getOutputPath() + "\r\n";
	    body += "Filename Mask    : " + this.x12835Job.getOutputFileName() + "\r\n";
	    body += "Temp Output      : " + this.x12835Job.getTempPath() + "\r\n\r\n\r\n";
	    body += "EOB SUMMARY\r\n";
	    body += "======================================================================\r\n";
	    body += "EOBs Selected  : " + this.x12835Job.getRemitSelected() + "\r\n";
	    body += "EOBs Built     : " + this.x12835Job.getRemitBuilt() + "\r\n";
	    body += "EOBs Not Built : " + (this.x12835Job.getRemitSelected() - this.x12835Job.getRemitBuilt()) + "\r\n";
	    body += "======================================================================\r\n\r\n";
	    
	    for(int i = 0; i < (eobResultList == null ? 0 : eobResultList.size()); i++)
	    {
	    	eobResult = eobResultList.get(i);
	    	if(eobResult != null)
	    	{
		    	body += (i + 1) + " of " + eobResultList.size() + "\r\n";
		    	body += "----------------------------------------------------------------------\r\n";
		    	body += "Sub Acct No    : " + eobResult.getSubAcctNo() + "\r\n";
		    	body += "Sub Status     : " + eobResult.getSubStatus() + "\r\n";
		    	body += "Prov Tax ID    : " + eobResult.getProvTaxID() + "\r\n";
		    	body += "Header ID      : " + eobResult.getHeaderID() + "\r\n";
		    	body += "EOB Result     : " + eobResult.getResult() + "\r\n";
		    	body += "EOB Status     : " + eobResult.getStatus() + "\r\n";
		    	body += "EOB Date/Time  : " + eobResult.getDateTime() + "\r\n";
		    	body += "Output Status  : " + eobResult.getOutStatus() + "\r\n";
		    	body += "Target Output  : " + eobResult.getTarget() + "\r\n";
		    	body += "Actual Output  : " + eobResult.getActual() + "\r\n";
		    	body += "Claim Count    : " + eobResult.getNumberClaims() + "\r\n\r\n";
	    	}
	    }
	    	    
	    email.put_Body(body);

	    boolean success = mailman.SendEmail(email);
	    //if not success raise error.
	    if (!success)
	    {
	        //mailman.SaveLastError("lastError.txt");	
	    }
	}
	
	/**
	 * 
	 * @param mailman
	 * @param recip
	 */
	private void buildErrorEmail(CkMailMan mailman,String recip)
	{
		String 	outputRule,
				dateString,
				body,
				errSource,
				errDesc;
		int errFormat = errMsg.indexOf(":");
		CkEmail email = new CkEmail();
		EobResult eobResult;

		try
		{
			DateFormat dateFormat = new SimpleDateFormat("M/dd/yyyy h:mm:ss a");
			Calendar cal = Calendar.getInstance();
			dateString = dateFormat.format(cal.getTime());
		}
		catch(Exception e)
		{
			dateString = "";
		}
		
		try
		{
			errSource = errMsg.substring(0,errFormat);
		}
		catch(StringIndexOutOfBoundsException s)
		{
			errSource = "";
		}
		
		try
		{
			errDesc = errMsg.substring(errFormat + 1);
		}
		catch(StringIndexOutOfBoundsException s)
		{
			errDesc = "";
		}
		
		switch(this.x12835Job.getOutputFileExistsRule())
		{
			case "0":
				outputRule = "Increment FileName";
				break;
			case "1":
				outputRule = "Increment Extension";
				break;
			case "2":
				outputRule = "Overwrite Existing File";
				break;
			default:
				outputRule = "";
				break;
		}
		
		email.AddTo("",recip);
	    email.put_Subject("EClaims X12 835 Java <General Error>");
	        
	    email.put_FromAddress(this.x12835Job.getErrorFromAddr());
	    email.put_FromName(this.x12835Job.getErrorFromName());

	    body = "EClaims X12 835 Java Version " + this.x12835Job.getVersion() + "\r\n\r\n";
	    body += "Date\\Time        : " + dateString + "\r\n";
	    body += "User ID          : " + this.x12835Job.getUserID() + "\r\n";
	    body += "Workstation      : " + this.x12835Job.getWorkstation() + "\r\n\r\n";
	    body += "App Name         : " + this.x12835Job.getAppName() + "\r\n";
	    body += "App Ver          : " + this.x12835Job.getVersion() + "\r\n";
	    body += "App UID          : " + this.x12835Job.getUserID() + "\r\n";
	    body += "App WS           : " + this.x12835Job.getWorkstation() + "\r\n\r\n";
	    body += "Job Name         : " + this.x12835Job.getJobName() + "\r\n";
	    body += "Job Type         : " + this.x12835Job.getJobType() + "\r\n";
	    body += "Activity         : Process Spool\r\n\r\n";
	    body += "Error No         : " + errNum + "\r\n";
	    body += "Error Desc       : " + errDesc + "\r\n";
	    body += "Error Source     : " + errSource + "\r\n\r\n";
	    body += "SQL Query        : " + this.x12835Job.getSqlSelect() + "\r\n";
	    body += "Cnn Timeout      : " + this.x12835Job.getCnnTimeout() + "\r\n";
	    body += "Cmd Timeout      : " + this.x12835Job.getCmdTimeout() + "\r\n\r\n";
	    body += "MySQL DSN        : " + this.x12835Job.getRptSysDsn() + "\r\n";
	    body += "Cnn Timeout      : " + this.x12835Job.getRptCnnTimeout() + "\r\n";
	    body += "Cmd Timeout      : " + this.x12835Job.getRptCmdTimeout() + "\r\n\r\n";
	    body += "Built Stat Mark  : " + this.x12835Job.getBuiltStatusMark() + "\r\n\r\n";
	    body += "Serial Lookup    : " + (this.x12835Job.isReport() ? (this.x12835Job.isSerialNoLookup() ? "Yes" : "No") : "N/A") + "\r\n";
	    body += "Serial Timeout   : " + (this.x12835Job.isReport() ? this.x12835Job.getSerialNoLookupCmdTimeout() : "N/A") + "\r\n\r\n";
	    body += "Tax ID Rollback  : " + (this.x12835Job.isProvTaxIDRollBack() ? "Yes" : "No") + "\r\n";
	    body += "Tax ID Mark      : " + (this.x12835Job.isProvTaxIDRollBack() ? "N/A" : this.x12835Job.getProvTaxIDMark()) + "\r\n\r\n";
	    body += "Enrlmnt Rollback : " + (this.x12835Job.isSub835EnrollmentRollback() ? "Yes" : "No") + "\r\n";
	    body += "Enrlmnt Mark     : " + (this.x12835Job.isSub835EnrollmentRollback() ? "N/A" : this.x12835Job.getSub835EnrollmentMark()) + "\r\n\r\n";
	    body += "Inactive Report  : " + (this.x12835Job.isReport() ? (this.x12835Job.isPostSubInactiveRpt() ? "Yes" : "No") : "N/A") + "\r\n";
	    body += "Inactive Mark    : " + this.x12835Job.getSubInactiveMark() + "\r\n\r\n";
	    body += "Cancelled Report : " + (this.x12835Job.isReport() ? (this.x12835Job.isPostSubCancelledRpt() ? "Yes" : "No") : "N/A") + "\r\n";
	    body += "Cancelled Mark   : " + this.x12835Job.getSubCancelledMark() + "\r\n\r\n";
	    body += "Cred Hold Report : " + (this.x12835Job.isReport() ? (this.x12835Job.isPostSubCreditHoldRpt() ? "Yes" : "No") : "N/A") + "\r\n";
	    body += "Cred Hold Mark   : " + this.x12835Job.getSubCreditHoldMark() + "\r\n\r\n";
	    body += "Closed Report    : " + (this.x12835Job.isReport() ? (this.x12835Job.isPostSubClosedRpt() ? "Yes" : "No") : "N/A") + "\r\n";
	    body += "Closed Mark      : " + this.x12835Job.getSubClosedMark() + "\r\n\r\n";
	    body += "Output Rule      : " + outputRule + "\r\n";
	    body += "File Err Mark    : " + ((this.x12835Job.getOutputFileExistsRule().equalsIgnoreCase("3")) ? this.x12835Job.getFileErrorMark() : "N/A") + "\r\n";
	    body += "Output Path      : " + this.x12835Job.getOutputPath() + "\r\n";
	    body += "Filename Mask    : " + this.x12835Job.getOutputFileName() + "\r\n";
	    body += "Temp Output      : " + this.x12835Job.getTempPath() + "\r\n\r\n\r\n";
	    body += "EOB SUMMARY\r\n";
	    body += "======================================================================\r\n";
	    body += "EOBs Selected  : " + this.x12835Job.getRemitSelected() + "\r\n";
	    body += "EOBs Built     : " + this.x12835Job.getRemitBuilt() + "\r\n";
	    body += "EOBs Not Built : " + (this.x12835Job.getRemitSelected() - this.x12835Job.getRemitBuilt()) + "\r\n";
	    body += "======================================================================\r\n\r\n";
	   
	    for(int i = 0; i < (eobResultList == null ? 0 : eobResultList.size()); i++)
	    {
	    	eobResult = eobResultList.get(i);
	    	if(eobResult != null)
	    	{
		    	body += (i + 1) + " of " + eobResultList.size() + "\r\n";
		    	body += "----------------------------------------------------------------------\r\n";
		    	body += "Sub Acct No    : " + eobResult.getSubAcctNo() + "\r\n";
		    	body += "Sub Status     : " + eobResult.getSubStatus() + "\r\n";
		    	body += "Prov Tax ID    : " + eobResult.getProvTaxID() + "\r\n";
		    	body += "Header ID      : " + eobResult.getHeaderID() + "\r\n";
		    	body += "EOB Result     : " + eobResult.getResult() + "\r\n";
		    	body += "EOB Status     : " + eobResult.getStatus() + "\r\n";
		    	body += "EOB Date/Time  : " + eobResult.getDateTime() + "\r\n";
		    	body += "Output Status  : " + eobResult.getOutStatus() + "\r\n";
		    	body += "Target Output  : " + eobResult.getTarget() + "\r\n";
		    	body += "Actual Output  : " + eobResult.getActual() + "\r\n";
		    	body += "Claim Count    : " + eobResult.getNumberClaims() + "\r\n\r\n";
	    	}
	    }
	    	    
	    email.put_Body(body);

	    boolean success = mailman.SendEmail(email);
	    //if not success raise error.
	    if (!success)
	    {
	        //mailman.SaveLastError("lastError.txt");	
	    }
	}

	/**
	 * @return the x12835Job
	 */
	public X12835Job getX12835Job()
	{
		return x12835Job;
	}

	/**
	 * @return the eobResultList
	 */
	public ArrayList<EobResult> getEobResultList()
	{
		return eobResultList;
	}

	/**
	 * @return the emailToSend
	 */
	public String getEmailToSend()
	{
		return emailToSend;
	}

	/**
	 * @param x12835Job the x12835Job to set
	 */
	public void setX12835Job(X12835Job x12835Job)
	{
		this.x12835Job = x12835Job;
	}

	/**
	 * @param eobResultList the eobResultList to set
	 */
	public void setEobResultList(ArrayList<EobResult> eobResultList) 
	{
		this.eobResultList = eobResultList;
	}

	/**
	 * @param emailToSend the emailToSend to set
	 */
	public void setEmailToSend(String emailToSend) 
	{
		this.emailToSend = emailToSend;
	}
	
}
