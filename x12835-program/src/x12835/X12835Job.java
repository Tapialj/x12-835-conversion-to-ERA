package x12835;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.text.*;
import java.util.*;

import javax.swing.text.MaskFormatter;

/**
 * This class contains a constructor, getters, setters, and all of the ERA building methods to create the ERA
 * All of the creation of the ERA is done from the methods in this object
 * @author lewist
 */

public class X12835Job 
{
	private final String VERSION = "1.0.0";
	
	private String	jobName,
					jobType,
					sqlSelect,
					rptSysDsn,
					builtStatusMark,
					dataReportDelimiter,
					provTaxIDMark,
					sub835EnrollmentMark,
					sub835EnrollmentDataMark,
					subInactiveMark,
					subCancelledMark,
					subCreditHoldMark,
					subClosedMark,
					headerClaimAmtPaidMark,
					webDescription,
					outputPath,
					outputFileName,
					outputFileExistsRule,
					incrementalChar,
					fileErrorMark,
					tempPath,
					successRecip,
					successFromName,
					successFromAddr,
					someBuiltRecip,
					someBuiltFromName,
					someBuiltFromAddr,
					zeroBuiltRecip,
					zeroBuiltFromName,
					zeroBuiltFromAddr,
					errorRecip,
					errorFromName,
					errorFromAddr,
					errorShowModally,
					warningShowModally,
					infoShowModally,
					appName,
					version,
					userID,
					workstation,
					recip,
					fromName,
					fromAddr,
					smtpHost,
					smtpAlt,
					msgKey,
					rptCreateDateTime,
					rptRunDateTime;
	private int		rptCnnTimeout,
					rptCmdTimeout,
					serialNoLookupCmdTimeout,
					cnnTimeout,
					cmdTimeout,
					remitSelected,
					remitBuilt;
	private boolean	jobFound,
					isReport,
					isReportPost,
					jobEnabled,
					includeColumnHeadings,
					serialNoLookup,
					provTaxIDRollBack,
					sub835EnrollmentRollback,
					sub835EnrollmentDataRollback,
					postSubInactiveRpt,
					postSubCancelledRpt,
					postSubCreditHoldRpt,
					postSubClosedRpt,
					verifyHeaderClaimAmtPaid,
					headerClaimAmtPaidRollback,
					useLeadZero,
					successEnabled,
					someBuiltEnabled,
					zeroBuiltEnabled,
					errorEnabled,
					errorMsgOwned,
					warningMsgOwned,
					infoMsgOwned,
					errEmailSuppress,
					errMsgSuppress,
					wrnMsgSuppress,
					infMsgSuppress;	
	
	/**
	 * The constructor for the X12835Job object
	 * @param jobResultSet The jobResultSet containing the information needed to create this object
	 */
	public X12835Job(JobDataResultSet jobResultSet)
	{
		String	fExt,
				hostName;
		boolean	isReport = false,
				isReportPost = false;
		
		if(!jobResultSet.getfExt().substring(0,1).equalsIgnoreCase("."))
			fExt = "." + jobResultSet.getfExt();
		else
			fExt = jobResultSet.getfExt();
		
		switch (jobResultSet.getJobType())
		{
			case "DATA":
				isReport = false;
				isReportPost = false;
				break;
			
			case "REPORT ONLY":
				isReport = true;
				isReportPost = false;
				break;
				
			case "REPORT":
				isReport = true;
				isReportPost = true;
				break;
		}
		
		try 
		{
			hostName = InetAddress.getLocalHost().getHostName();
		}catch(UnknownHostException e) 
		{
			hostName = "N/A";
		}
		
		this.jobName = jobResultSet.getJobName();
		this.jobType = jobResultSet.getJobType();
		this.sqlSelect = jobResultSet.getSqlSelect();
		this.rptSysDsn = jobResultSet.getRptSysDsn();
		this.builtStatusMark =jobResultSet.getBuiltStatusMark();
		this.dataReportDelimiter = jobResultSet.getDataReportDelimiter();
		this.provTaxIDMark = jobResultSet.getProvTaxIDMark();
		this.sub835EnrollmentMark = jobResultSet.getSub835EnrollmentMark();
		this.sub835EnrollmentDataMark = jobResultSet.getSub835EnrollmentDataMark();
		this.subInactiveMark = jobResultSet.getSubInactiveMark();
		this.subCancelledMark = jobResultSet.getSubCancelledMark();
		this.subCreditHoldMark = jobResultSet.getSubCreditHoldMark();
		this.subClosedMark = jobResultSet.getSubClosedMark();
		this.headerClaimAmtPaidMark = jobResultSet.getHeaderClaimAmtPaidMark();
		this.webDescription = jobResultSet.getWebDescription();
		this.outputPath = jobResultSet.getOutputPath();
		this.outputFileName = jobResultSet.getFs1() + jobResultSet.getFp1() + jobResultSet.getFs2() + jobResultSet.getFp2() + jobResultSet.getFs3() + jobResultSet.getFp3() +
				jobResultSet.getFs4() + jobResultSet.getFp4() + jobResultSet.getFs5() + jobResultSet.getFp5() + jobResultSet.getFs6() + jobResultSet.getFp6() + 
				jobResultSet.getFs7() + fExt;
		this.outputFileExistsRule = jobResultSet.getOutputFileExistsRule();
		this.incrementalChar = jobResultSet.getIncrementalChar();
		this.fileErrorMark = jobResultSet.getFileErrorMark();
		this.tempPath = jobResultSet.getTempPath().trim().toUpperCase() + "\\" + jobResultSet.getTempFileName().trim().toUpperCase();
		this.successRecip = jobResultSet.getSuccessRecip();
		this.successFromName = jobResultSet.getSuccessFromName();
		this.successFromAddr = jobResultSet.getSuccessFromAddr();
		this.someBuiltRecip = jobResultSet.getSomeBuiltRecip();
		this.someBuiltFromName = jobResultSet.getSomeBuiltFromName();
		this.someBuiltFromAddr = jobResultSet.getSomeBuiltFromAddr();
		this.zeroBuiltRecip = jobResultSet.getZeroBuiltRecip();
		this.zeroBuiltFromName = jobResultSet.getZeroBuiltFromName();
		this.zeroBuiltFromAddr = jobResultSet.getZeroBuiltFromAddr();
		this.errorRecip = jobResultSet.getErrorRecip();
		this.errorFromName = jobResultSet.getErrorFromName();
		this.errorFromAddr = jobResultSet.getErrorFromAddr();
		this.errorShowModally = jobResultSet.getErrorShowModally();
		this.warningShowModally = jobResultSet.getWarningShowModally();
		this.infoShowModally = jobResultSet.getInfoShowModally();
		this.appName = "ECX12835";
		this.version = VERSION;
		this.userID = System.getProperty("user.name");
		this.workstation = hostName;
		this.recip = jobResultSet.getRecip();
		this.fromName = jobResultSet.getFromName();
		this.fromAddr = jobResultSet.getFromAddr();
		this.smtpHost = jobResultSet.getSmtpHost();
		this.smtpAlt = jobResultSet.getSmtpAlt();
		this.msgKey = "";
		this.rptCnnTimeout = Integer.parseInt(jobResultSet.getRptCnnTimeout());
		this.rptCmdTimeout = Integer.parseInt(jobResultSet.getRptCmdTimeout());
		this.serialNoLookupCmdTimeout = Integer.parseInt(jobResultSet.getSerialNoLookupCmdTimeout());
		this.cnnTimeout = Integer.parseInt(jobResultSet.getCnnTimeout());
		this.cmdTimeout = Integer.parseInt(jobResultSet.getCmdTimeout());
		this.jobFound = true;
		this.isReport = isReport;
		this.isReportPost = isReportPost;
		this.jobEnabled = (jobResultSet.getJobEnabled().equalsIgnoreCase("N")) ? true : false;
		this.includeColumnHeadings = (jobResultSet.getIncludeColumnHeadings().equalsIgnoreCase("Y")) ? true : false;
		this.serialNoLookup = (jobResultSet.getSerialNoLookup().equalsIgnoreCase("Y")) ? true : false;
		this.provTaxIDRollBack = (jobResultSet.getProvTaxIDRollBack().equalsIgnoreCase("1")) ? true : false;
		this.sub835EnrollmentRollback = (jobResultSet.getSub835EnrollmentRollback().equalsIgnoreCase("1")) ? true : false;
		this.sub835EnrollmentDataRollback = (jobResultSet.getSub835EnrollmentDataRollback().equalsIgnoreCase("1")) ? true : false;
		this.postSubInactiveRpt = (jobResultSet.getPostSubInactiveRpt().equalsIgnoreCase("Y")) ? true : false;
		this.postSubCancelledRpt = (jobResultSet.getPostSubCancelledRpt().equalsIgnoreCase("Y")) ? true : false;
		this.postSubCreditHoldRpt = (jobResultSet.getPostSubCreditHoldRpt().equalsIgnoreCase("Y")) ? true : false;
		this.postSubClosedRpt = (jobResultSet.getPostSubClosedRpt().equalsIgnoreCase("Y")) ? true : false;
		this.verifyHeaderClaimAmtPaid = (jobResultSet.getVerifyHeaderClaimAmtPaid().equalsIgnoreCase("Y")) ? true : false;
		this.headerClaimAmtPaidRollback = (jobResultSet.getHeaderClaimAmtPaidRollback().equalsIgnoreCase("1")) ? true : false;
		this.useLeadZero = (jobResultSet.getUseLeadZero().equalsIgnoreCase("Y")) ? true : false;
		this.successEnabled = (jobResultSet.getSuccessEnabled().equalsIgnoreCase("Y")) ? true : false;
		this.someBuiltEnabled = (jobResultSet.getSomeBuiltEnabled().equalsIgnoreCase("Y")) ? true : false;
		this.zeroBuiltEnabled = (jobResultSet.getZeroBuiltEnabled().equalsIgnoreCase("Y")) ? true : false;
		this.errorEnabled = (jobResultSet.getErrorEnabled().equalsIgnoreCase("Y")) ? true : false;
		this.errorMsgOwned = (jobResultSet.getErrorMsgOwned().equalsIgnoreCase("Y")) ? true : false;
		this.warningMsgOwned = (jobResultSet.getWarningMsgOwned().equalsIgnoreCase("Y")) ? true : false;
		this.infoMsgOwned = (jobResultSet.getInfoMsgOwned().equalsIgnoreCase("Y")) ? true : false;
		this.remitSelected = 0;
		this.remitBuilt = 0;
	}
	
	/**
	 * This is the process spool, called initially to start the whole build of an ERA
	 * @param msSQLConnection
	 * @return An ArrayList of EobResult containing information for logs and emails
	 * @throws SQLTimeoutException Thrown if a timeout happens, caught in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, caught in main method for error handling
	 * @throws ClassNotFoundException Thrown if the Class.forName does not exist, caught in main method for error handling
	 * @throws IOException Thrown if IO exception, caught in main method for error handling
	 */
	public ArrayList<EobResult> processSpool(databaseConnection msSQLConnection) throws SQLTimeoutException, SQLException, ClassNotFoundException, IOException
	{
		RemitHeaderResultSet headerResults;
		ArrayList<RemitHeaderResultSet> remitHeaderList;
		databaseConnection mySQLConnection = null;
		ArrayList<EobResult> eobResultList = null;
		EobResult eobResult = new EobResult("Unknown","Unknown","Not Found","Unknown","0",0,0,0,"Unknown","Unknown","Unknown","Unknown","Unknown",false,false);

		//if the job was found and is enabled
		if(this.jobFound && this.jobEnabled)
		{
			//this is the recordset saved to an object of the remittance_header table
			remitHeaderList = msSQLConnection.sqlHeaderSelect(this.sqlSelect,eobResult);
			eobResultList = new ArrayList<EobResult>();
			this.remitSelected = eobResult.getEobSelected();
			
			if(remitHeaderList.size() > 0)
			{
				for(int i = 0; i < remitHeaderList.size(); i++)
				{
					headerResults = remitHeaderList.get(i);
					eobResult = new EobResult("Unknown","Unknown","Not Found","Unknown","0",0,0,0,"Unknown","Unknown","Unknown","Unknown","Unknown",false,false);
					eobResult.setEobSelected(this.remitSelected);
					
					if(headerResults!= null)
					{
						if(this.isReport && this.isReportPost)
						{
							mySQLConnection = new databaseConnection(this.rptCnnTimeout,this.rptCmdTimeout,"jdbc:mysql://192.168.1.11:3306/","eclaims","mySQL");
						}
							
						headerSpool(headerResults,eobResult,msSQLConnection,mySQLConnection);
						
						//may remove eobbuilt at some point as new way of doing EOB results leaves this unused.
						this.remitBuilt++;
						eobResult.setEobBuilt(this.remitBuilt);
						
						if(this.isReport && this.isReportPost)
						{
							mySQLConnection.closeConnection();
						}
					}
					
					eobResultList.add(eobResult);
				}	
			}
			else
			{
				eobResultList.add(eobResult);
			}
		}
		else if(this.jobFound && !this.jobEnabled)
		{
			//raise error 1000 Job 'name' is Disabled.
		}
		else
		{
			//raise error 2000 job 'name' Not Found.
		}
		
		return eobResultList;
	}
	
	/**
	 * This is the header spool that gets the data for the EobResult object, queries the provider ID (either a tax ID or NPI) to check the 
	 * 835 enrollment status and submitter account status. Then it calls the report loop that starts building the human readable ERA as a string.
	 * Once done, it writes the ERA string to a temp file, scrubs the check number for invalid characters, writes the string to the payback
	 * table in the MySQL database (if the job is set for it), and updates the MS SQL database with new information. The temp file is then renamed 
	 * and moved to the archive, and then a log is written if there was no errors in creating the ERA
	 * @param headerResults The header results object containing the header information to start building the ERA
	 * @param eobResult The Eob result object filled in with basic information for each ERA built
	 * @param msSQLConnection The MS SQL connection used to query the MS SQL database
	 * @param mySQLConnection The My SQL connection used to query the My SQL database
	 * @throws SQLTimeoutException Thrown if a timeout happens, caught in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, caught in main method for error handling
	 * @throws IOException Thrown if IO exception, caught in main method for error handling
	 */
	private void headerSpool(RemitHeaderResultSet headerResults, EobResult eobResult, databaseConnection msSQLConnection, databaseConnection mySQLConnection) throws SQLTimeoutException, SQLException, IOException
	{
		String	eraString,
				newTraceNo,
				errHeader,
				acctErrMsg,
				parsedFileName;
		
		getDateTimeSting();
		msSQLConnection.queryProvTaxID(headerResults.getPayeeIDCodeN104().trim(), eobResult);
		
		if(eobResult.isProvTaxIDFound())
		{
			msSQLConnection.sub835EnrollmentLookUp(eobResult);
			
			if(eobResult.isEnrolledInService())
			{
				//check account status and build a report from there
				switch (eobResult.getSubStatus())
				{
					case "NEW":
					case "ACTIVE":						
						eraString = eobReportLoop(eobResult, headerResults,msSQLConnection);
						writeToTempFile(eraString);
						//in original code they open and write the tempPath in binary for Data reports, will add logic here if we ever do data again
						if(this.isReport && this.isReportPost)
						{
							newTraceNo = scrubTraceNo(headerResults.getTraceNoTRN02().toUpperCase());
							mySQLConnection.writeToPayback(eraString,this.jobName,newTraceNo,eobResult.getSubAcctNo(),this.rptCreateDateTime);
						}
						
						headerResults.setEobReportStatus(this.builtStatusMark);
						headerResults.setEobReportErrorNum("0");
						headerResults.setEobReportErrorReason("");
						headerResults.setEobReportErrorSource("");
						headerResults.setEobSubAcctNo(eobResult.getSubAcctNo());
						headerResults.setEobReportCreateDateTime(this.rptCreateDateTime);
						headerResults.setEobReportRunDateTime(this.rptRunDateTime);
						
						parsedFileName = buildFileName(eobResult,headerResults);
						moveFile(eobResult,parsedFileName);
						
						eobResult.setDateTime(this.rptCreateDateTime);
						eobResult.setHeaderID(headerResults.getHeaderID());
						eobResult.setStatus(this.builtStatusMark);
						eobResult.setResult("Success!");
						
						msSQLConnection.updateMSSqlDatabase(headerResults);
						break;
					
					case "CANCELLED":
						if(this.postSubCancelledRpt)
						{
							errHeader = reportHeader(headerResults);
							acctErrMsg = formatAccountStatus("EOB Payor Report could not be created because your status with us is CANCELLED. Please contact our Sales Department at 1(888) 576-0800 if you wish to reactivate your account with us.");
							writeToTempFile(errHeader + acctErrMsg);
							//in original code they open and write the tempPath in binary for Data reports, will add logic here if we ever do data again
							if(this.isReport && this.isReportPost)
							{
								newTraceNo = scrubTraceNo(headerResults.getTraceNoTRN02().toUpperCase());
								mySQLConnection.writeToPayback(errHeader + acctErrMsg,this.jobName,newTraceNo,eobResult.getSubAcctNo(),this.rptCreateDateTime);
							}
							
							headerResults.setEobReportStatus(this.subCancelledMark);
							headerResults.setEobReportErrorNum("0");
							headerResults.setEobReportErrorReason("");
							headerResults.setEobReportErrorSource("");
							headerResults.setEobSubAcctNo(eobResult.getSubAcctNo());
							headerResults.setEobReportCreateDateTime(this.rptCreateDateTime);
							headerResults.setEobReportRunDateTime(this.rptRunDateTime);
							
							parsedFileName = buildFileName(eobResult,headerResults);
							moveFile(eobResult,parsedFileName);
							
							eobResult.setDateTime(this.rptCreateDateTime);
							eobResult.setHeaderID(headerResults.getHeaderID());
							eobResult.setStatus(this.subCancelledMark);
							eobResult.setResult("Success!");
						}
						else
						{
							headerResults.setEobReportStatus(this.subCancelledMark);
							headerResults.setEobReportErrorNum("9004");
							headerResults.setEobReportErrorReason("Submitter '" + eobResult.getSubAcctNo() + "' Status is 'Cancelled' and Option to 'Build and Post Submitter Status Cancelled in Job' is Unchecked");
							headerResults.setEobReportErrorSource("");
							headerResults.setEobSubAcctNo(eobResult.getSubAcctNo());
							headerResults.setEobReportCreateDateTime(this.rptCreateDateTime);
							headerResults.setEobReportRunDateTime(this.rptRunDateTime);
							
							parsedFileName = buildFileName(eobResult,headerResults);
							moveFile(eobResult,parsedFileName);
							
							eobResult.setDateTime("");
							eobResult.setOutStatus("Error #9004 " + headerResults.getEobReportErrorReason() + ". <X12835Job.headerSpool>");
							eobResult.setHeaderID(headerResults.getHeaderID());
							eobResult.setStatus(this.subCancelledMark);
							eobResult.setResult("Failed!");
						}
						msSQLConnection.updateMSSqlDatabase(headerResults);
						break;
						
					case "INACTIVE":
						if(this.postSubInactiveRpt)
						{
							errHeader = reportHeader(headerResults);
							acctErrMsg = formatAccountStatus("EOB Payor Report could not be created because your status with us is INACTIVE. Please contact our Client Services at 1(626) 549-4517 if you wish to reactivate your account with us.");
							writeToTempFile(errHeader + acctErrMsg);
							//in original code they open and write the tempPath in binary for Data reports, will add logic here if we ever do data again
							if(this.isReport && this.isReportPost)
							{
								newTraceNo = scrubTraceNo(headerResults.getTraceNoTRN02().toUpperCase());
								mySQLConnection.writeToPayback(errHeader + acctErrMsg,this.jobName,newTraceNo,eobResult.getSubAcctNo(),this.rptCreateDateTime);
							}
							
							headerResults.setEobReportStatus(this.subInactiveMark);
							headerResults.setEobReportErrorNum("0");
							headerResults.setEobReportErrorReason("");
							headerResults.setEobReportErrorSource("");
							headerResults.setEobSubAcctNo(eobResult.getSubAcctNo());
							headerResults.setEobReportCreateDateTime(this.rptCreateDateTime);
							headerResults.setEobReportRunDateTime(this.rptRunDateTime);
							
							parsedFileName = buildFileName(eobResult,headerResults);
							moveFile(eobResult,parsedFileName);
							
							eobResult.setDateTime(this.rptCreateDateTime);
							eobResult.setHeaderID(headerResults.getHeaderID());
							eobResult.setStatus(this.subInactiveMark);
							eobResult.setResult("Success!");
						}
						else
						{
							headerResults.setEobReportStatus(this.subInactiveMark);
							headerResults.setEobReportErrorNum("9005");
							headerResults.setEobReportErrorReason("Submitter '" + eobResult.getSubAcctNo() + "' Status is 'Inactive' and Option to 'Build and Post Submitter Status Inactive in Job' is Unchecked");
							headerResults.setEobReportErrorSource("");
							headerResults.setEobSubAcctNo(eobResult.getSubAcctNo());
							headerResults.setEobReportCreateDateTime(this.rptCreateDateTime);
							headerResults.setEobReportRunDateTime(this.rptRunDateTime);
							
							parsedFileName = buildFileName(eobResult,headerResults);
							moveFile(eobResult,parsedFileName);
							
							eobResult.setDateTime("");
							eobResult.setOutStatus("Error #9005 " + headerResults.getEobReportErrorReason() + ". <X12835Job.headerSpool>");
							eobResult.setHeaderID(headerResults.getHeaderID());
							eobResult.setStatus(this.subInactiveMark);
							eobResult.setResult("Failed!");
						}
						msSQLConnection.updateMSSqlDatabase(headerResults);
						break;
						
					case "CREDIT HOLD":
						if(this.postSubCreditHoldRpt)
						{
							errHeader = reportHeader(headerResults);
							acctErrMsg = formatAccountStatus("EOB Payor Report could not be created because your account has been placed on CREDIT-HOLD. Please contact our Accounting Department at 1(888) 576-0800 if you wish to reactivate your account with us.");
							writeToTempFile(errHeader + acctErrMsg);
							//in original code they open and write the tempPath in binary for Data reports, will add logic here if we ever do data again
							if(this.isReport && this.isReportPost)
							{
								newTraceNo = scrubTraceNo(headerResults.getTraceNoTRN02().toUpperCase());
								mySQLConnection.writeToPayback(errHeader + acctErrMsg,this.jobName,newTraceNo,eobResult.getSubAcctNo(),this.rptCreateDateTime);
							}
							
							headerResults.setEobReportStatus(this.subCreditHoldMark);
							headerResults.setEobReportErrorNum("0");
							headerResults.setEobReportErrorReason("");
							headerResults.setEobReportErrorSource("");
							headerResults.setEobSubAcctNo(eobResult.getSubAcctNo());
							headerResults.setEobReportCreateDateTime(this.rptCreateDateTime);
							headerResults.setEobReportRunDateTime(this.rptRunDateTime);
							
							parsedFileName = buildFileName(eobResult,headerResults);
							moveFile(eobResult,parsedFileName);
							
							eobResult.setDateTime(this.rptCreateDateTime);
							eobResult.setHeaderID(headerResults.getHeaderID());
							eobResult.setStatus(this.subCreditHoldMark);
							eobResult.setResult("Success!");
						}
						else
						{
							headerResults.setEobReportStatus(this.subCreditHoldMark);
							headerResults.setEobReportErrorNum("9006");
							headerResults.setEobReportErrorReason("Submitter '" + eobResult.getSubAcctNo() + "' Status is 'Credit Hold' and Option to 'Build and Post Submitter Status Credit Hold in Job' is Unchecked");
							headerResults.setEobReportErrorSource("");
							headerResults.setEobSubAcctNo(eobResult.getSubAcctNo());
							headerResults.setEobReportCreateDateTime(this.rptCreateDateTime);
							headerResults.setEobReportRunDateTime(this.rptRunDateTime);
							
							parsedFileName = buildFileName(eobResult,headerResults);
							moveFile(eobResult,parsedFileName);
							
							eobResult.setDateTime("");
							eobResult.setOutStatus("Error #9006 " + headerResults.getEobReportErrorReason() + ". <X12835Job.headerSpool>");
							eobResult.setHeaderID(headerResults.getHeaderID());
							eobResult.setStatus(this.subInactiveMark);
							eobResult.setResult("Failed!");
						}
						msSQLConnection.updateMSSqlDatabase(headerResults);
						break;
						
					case "CLOSED":
						if(this.postSubClosedRpt)
						{
							errHeader = reportHeader(headerResults);
							acctErrMsg = formatAccountStatus("EOB Payor Report could not be created because your status with us is CLOSED. Please contact our Accounting Department at 1(888) 576-0800 if you wish to reactivate your account with us.");
							writeToTempFile(errHeader + acctErrMsg);
							//in original code they open and write the tempPath in binary for Data reports, will add logic here if we ever do data again
							if(this.isReport && this.isReportPost)
							{
								newTraceNo = scrubTraceNo(headerResults.getTraceNoTRN02().toUpperCase());
								mySQLConnection.writeToPayback(errHeader + acctErrMsg,this.jobName,newTraceNo,eobResult.getSubAcctNo(),this.rptCreateDateTime);
							}
							
							headerResults.setEobReportStatus(this.subClosedMark);
							headerResults.setEobReportErrorNum("0");
							headerResults.setEobReportErrorReason("");
							headerResults.setEobReportErrorSource("");
							headerResults.setEobSubAcctNo(eobResult.getSubAcctNo());
							headerResults.setEobReportCreateDateTime(this.rptCreateDateTime);
							headerResults.setEobReportRunDateTime(this.rptRunDateTime);
							
							parsedFileName = buildFileName(eobResult,headerResults);
							moveFile(eobResult,parsedFileName);
							
							eobResult.setDateTime(this.rptCreateDateTime);
							eobResult.setHeaderID(headerResults.getHeaderID());
							eobResult.setStatus(this.subClosedMark);
							eobResult.setResult("Success!");
						}
						else
						{
							headerResults.setEobReportStatus(this.subClosedMark);
							headerResults.setEobReportErrorNum("9007");
							headerResults.setEobReportErrorReason("Submitter '" + eobResult.getSubAcctNo() + "' Status is 'Closed' and Option to 'Build and Post Submitter Status Closed in Job' is Unchecked");
							headerResults.setEobReportErrorSource("");
							headerResults.setEobSubAcctNo(eobResult.getSubAcctNo());
							headerResults.setEobReportCreateDateTime(this.rptCreateDateTime);
							headerResults.setEobReportRunDateTime(this.rptRunDateTime);
							
							parsedFileName = buildFileName(eobResult,headerResults);
							moveFile(eobResult,parsedFileName);
							
							eobResult.setDateTime("");
							eobResult.setOutStatus("Error #9007 " + headerResults.getEobReportErrorReason() + ". <X12835Job.headerSpool>");
							eobResult.setHeaderID(headerResults.getHeaderID());
							eobResult.setStatus(this.subInactiveMark);
							eobResult.setResult("Failed!");
						}
						msSQLConnection.updateMSSqlDatabase(headerResults);
						break;	
				}
			}
			else
			{
				parsedFileName = buildFileName(eobResult,headerResults);
				moveFile(eobResult,parsedFileName);
				//Submitter is not enrolled, create error in header results				
				headerResults.setEobReportStatus(this.sub835EnrollmentMark);
				headerResults.setEobReportErrorNum("9002");
				headerResults.setEobReportErrorReason("Submitter '" + eobResult.getSubAcctNo() + "' Not Enrolled in X12 835 EOB Report Service");
				headerResults.setEobReportErrorSource("");
				headerResults.setEobSubAcctNo(eobResult.getSubAcctNo());
				headerResults.setEobReportCreateDateTime(this.rptCreateDateTime);
				headerResults.setEobReportRunDateTime(this.rptRunDateTime);
				
				eobResult.setDateTime("");
				eobResult.setOutStatus("Error #9002 " + headerResults.getEobReportErrorReason() + ". <X12835Job.headerSpool>");
				eobResult.setHeaderID(headerResults.getHeaderID());
				eobResult.setStatus(this.subInactiveMark);
				eobResult.setResult("Failed!");

				msSQLConnection.updateMSSqlDatabase(headerResults);
			}
		}
		else
		{
			parsedFileName = buildFileName(eobResult,headerResults);
			moveFile(eobResult,parsedFileName);
			//Provider Tax ID or NPI was not found in any tables or cross references, create an error message for log and msSQLConnection
			headerResults.setEobReportStatus(this.provTaxIDMark);
			headerResults.setEobReportErrorNum("9001");
			headerResults.setEobReportErrorReason("Provider Tax ID '" + eobResult.getProvTaxID() + "' Not Found");
			headerResults.setEobReportErrorSource("");
			headerResults.setEobSubAcctNo(eobResult.getSubAcctNo());
			headerResults.setEobReportCreateDateTime(this.rptCreateDateTime);
			headerResults.setEobReportRunDateTime(this.rptRunDateTime);
			
			eobResult.setDateTime("");
			eobResult.setOutStatus("Error #9001 " + headerResults.getEobReportErrorReason() + ". <X12835Job.headerSpool>");
			eobResult.setHeaderID(headerResults.getHeaderID());
			eobResult.setStatus(this.subInactiveMark);
			eobResult.setResult("Failed!");
			
			msSQLConnection.updateMSSqlDatabase(headerResults);
		}
	}
	
	/**
	 * This formats the message string for inactive, closed, cancelled, and credit hold accounts
	 * @param description The message string to format
	 * @return The formatted message string
	 */
	private String formatAccountStatus(String description)
	{
		int		m = 90,
				u = 0,
				t = 1;
		String	formatDesc = "";
					
		for(int c = 0; c < description.length() - 1 ; c = description.indexOf(" ", c + 1))
		{
			if(c == m + 1)
			{
				if(t == 1)
				{
					formatDesc += description.substring(0, c) + "\r\n";
					t = 2;
				}
				else
				{
					formatDesc += description.substring(0, c) + "\r\n";
				}
				
				description = description.substring(c);
				description = description.trim() + " ";
			}
			else
			{
				if(c > m)
				{
					if(t == 1)
					{
							formatDesc += description.substring(0, u) + "\r\n";
								t = 2;
					}
					else
					{
						formatDesc += description.substring(0, u) + "\r\n";
					}
				
					description = description.substring(u);
					description = description.trim() + " ";
					c = 0;
					u = 0;
				}
				else
				{
					u = c;
				}
			}
		}
								
		if(!description.trim().isEmpty())
		{
			if(t == 1)
			{
				formatDesc += description + "\r\n";
			}
			else
			{
				formatDesc += description + "\r\n";
			}
		}
		
		return formatDesc;
	}
	
	/**
	 * This builds out the final filename based off of the parameters from the job object
	 * @param eobResult This contains some information that may be needed for the file name
	 * @param headerResults This contains some information that may be needed for the file name
	 * @return The final file name to be used for the ERA
	 */
	private String buildFileName(EobResult eobResult, RemitHeaderResultSet headerResults)
	{
		String	preInfoFileName = this.outputFileName,
				parsedFileName,
				timeString,
				dateString,
				subAcctNo = "<Sub Acct No>",
				provTaxID = "<Prov Tax ID No>",
				payeeID = "<Payee ID>",
				paymentIssueDate = "<Payment Issue Date>",
				paymentAmount = "<Payment Amount>",
				payerName = "<Payer Name>",
				traceNo = "<Trace No>",
				date = "<Date YYYYMMDD>",
				time = "<Time HHMMSS>";
		DecimalFormat dollarFormat = new DecimalFormat("###0.00");
		
		try
		{
			timeString = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());
			dateString = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		}
		catch(Exception e)
		{
			timeString = "";
			dateString = "";
		}
		
		parsedFileName = preInfoFileName.replaceAll(subAcctNo,eobResult.getSubAcctNo().trim());
		parsedFileName = parsedFileName.replaceAll(provTaxID,eobResult.getProvTaxID());
		parsedFileName = parsedFileName.replaceAll(payeeID,headerResults.getPayeeIDCodeN104().trim());
		parsedFileName = parsedFileName.replaceAll(paymentIssueDate,headerResults.getPmtIssueDateBPR16());
		parsedFileName = parsedFileName.replaceAll(paymentAmount,dollarFormat.format(Double.parseDouble(headerResults.getTotalPmtAmtBPR02())));
		parsedFileName = parsedFileName.replaceAll(payerName,headerResults.getPayerNameN102());
		parsedFileName = parsedFileName.replaceAll(traceNo,headerResults.getTraceNoTRN02());
		parsedFileName = parsedFileName.replaceAll(date,dateString);
		parsedFileName = parsedFileName.replaceAll(time,timeString);
		
		return parsedFileName;
	}
	
	/**
	 * This renames and moves the temp file to the final output path
	 * @param eobResult Used to save the target and actual save file name and destination
	 * @param parsedFileName The file name to attempt to save as
	 */
	private void moveFile(EobResult eobResult,String parsedFileName)
	{
		String	outPath = this.outputPath,
				renamedFile = "",
				newFileName,
				newFileTemp,
				ioStatus = "New",
				incChar = this.incrementalChar;
		int		inc = 0,
				p;
		File	file,
				tempFile;
		
		switch(this.outputFileExistsRule)
		{
			case "0"://Increment file name
				inc = 0;
				newFileName = parsedFileName;
				newFileTemp = newFileName;
				file = new File(outPath + "\\" + newFileName);
				while(file.exists())
				{
					ioStatus = "Renamed Filename";
					inc++;
					p = newFileTemp.lastIndexOf(".");
					
					if(p != 0)
					{
						if(this.useLeadZero && String.valueOf(inc).length() == 1)
						{
							newFileName = newFileTemp.substring(0,p) + incChar + "0" + inc + newFileTemp.substring(p);
						}
						else
						{
							newFileName = newFileTemp.substring(0,p) + incChar + inc + newFileTemp.substring(p);
						}
					}
					else
					{
						if(this.useLeadZero && String.valueOf(inc).length() == 1)
						{
							newFileName = newFileTemp + incChar + "0" + inc;
						}
						else
						{
							newFileName = newFileTemp + incChar + inc;
						}
					}
					file = new File(outPath + "\\" + newFileName);
				}
				renamedFile = newFileName;
				break;
			case "1"://Increment extension
				inc = 0;
				newFileName = parsedFileName;
				newFileTemp = newFileName;
				file = new File(outPath + "\\" + newFileName);
				while(file.exists())
				{
					ioStatus = "Renamed Extension";
					inc++;
					if(this.useLeadZero && String.valueOf(inc).length() == 1)
					{
						newFileName = newFileTemp + "." + incChar + "0" + inc;
					}
					else
					{
						newFileName = newFileTemp + "." + incChar + inc;
					}
				}
				renamedFile = newFileName;
				break;
			default:
				//raise error to change				
				break;
		}
		
		tempFile = new File(this.tempPath);
		file = new File(outPath + "\\" + renamedFile);
		if(tempFile.exists())
		{
			tempFile.renameTo(file);
		}
		eobResult.setOutStatus(ioStatus);
		eobResult.setTarget(outPath + "\\" + parsedFileName);
		eobResult.setActual(outPath + "\\" + renamedFile);
	}
	
	/**
	 * This removes invalid characters from the trace/check number
	 * @param traceNo The check number
	 * @return The new scrubbed check number
	 */
	private String scrubTraceNo(String traceNo)
	{
		String	newTraceNo;
		
		if(traceNo.isEmpty())
		{
			return "";
		}
		
		newTraceNo = traceNo.replaceAll("[^A-Za-z0-9 ]", "");
		
		newTraceNo = newTraceNo.replaceAll("\\s+", " ");
		
		if(newTraceNo.trim().isEmpty())
		{
			return "";
		}
		else
		{
			return newTraceNo.trim() + ".ERA";
		}
	}
	
	/**
	 * This writes the ERA string to a temp file
	 * @param eraString The complete ERA as a string
	 * @throws IOException Thrown if IO exception, caught in main method for error handling
	 */
	private void writeToTempFile(String eraString) throws IOException
	{
		File file = new File(this.tempPath);
		BufferedWriter tempWriter = null;
		
		try
		{
			if(!file.exists())
			{
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			tempWriter = new BufferedWriter(fw);
			tempWriter.write(eraString);
			tempWriter.close();
		}
		catch(IOException e)
		{
			throw new IOException("X12835Job.writeToTempFile: " + e.getMessage());
		}
	}
	
	/**
	 * This gets two time date stamps one second apart as this is how it was in the original code
	 * for the create date time and the run date time
	 */
	private void getDateTimeSting()
	{
		try
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			this.rptCreateDateTime = dateFormat.format(cal.getTime());
			cal.add(Calendar.SECOND, -1);
			this.rptRunDateTime = dateFormat.format(cal.getTime());
		}
		catch(Exception e)
		{
			this.rptCreateDateTime = "";
			this.rptRunDateTime = "";
		}
	}	
	
	/**
	 * This starts building the ERA section by section. It starts with the ERA Header, followed by the claim and service line loops
	 * until they are finished. Lastly you alter with provider adjustments if there are any, create a summary of the payments,
	 * order and build the glossary codes for the ERA and add the footer.
	 * @param eobResult The EOB result object to be filled in with information as the ERA is built
	 * @param headerResults The header results object containing all information to start building ERA
	 * @param msSQLConnection The MS SQL connection object used for queries
	 * @return The complete ERA as a string
	 * @throws SQLTimeoutException Thrown if a timeout happens, caught in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, caught in main method for error handling
	 */
	private String eobReportLoop(EobResult eobResult, RemitHeaderResultSet headerResults, databaseConnection msSQLConnection) throws SQLTimeoutException, SQLException
	{
		String 	header = "",
				claimAndServiceLineString,
				provAdjString = "",
				paymentSumString = "",
				glossaryString = "",
				footer = "",
				eraString;
		TotalDollarAmounts claimAmounts = new TotalDollarAmounts(0,0,0,0);
		ArrayList<LineRemarkCode> lineCodeList = new ArrayList<LineRemarkCode>();
		
		if(this.isReport)
		{
			header = reportHeader(headerResults);
		}
		
		claimAndServiceLineString = eobClaimLoop(headerResults,eobResult,claimAmounts,lineCodeList,msSQLConnection);
		
		if(this.isReport)
		{
			provAdjString = providerAdjustment(headerResults,lineCodeList,msSQLConnection);
			paymentSumString = paymentSummary(claimAmounts);
			Collections.sort(lineCodeList, LineRemarkCode.lineCodeComparator);
			glossaryString = lineCodeGlossary(lineCodeList,headerResults,msSQLConnection);
			footer = reportFooter();
		}
		
		eraString = header + claimAndServiceLineString + provAdjString + paymentSumString + glossaryString + footer;
		
		return eraString;
	}
	
	/**
	 * This is the footer information to be placed last in the ERA
	 * @return The ERA footer
	 */
	private String reportFooter()
	{
		String footer = "THANK YOU FOR USING ECLAIMS FOR YOUR ELECTRONIC CLAIMS TRANSMISSION\r\n\r\nTHIS REPORT CONTAINS HEALTH CARE INFORMATION.  HANDLE ONLY ACCORDING TO THE APPROPRIATE\r\n" +
						"SECURITY AND PRIVACY PROCEDURES.\r\n\r\n\r\nEClaims X12 835 JAVA Version " + VERSION + "  (c) 2004 EClaims Inc.";
		
		return footer;
	}
	
	/**
	 * This summarized the payment information and organizes it into a string
	 * @param claimAmounts The total dollar amounts for each payment amount
	 * @return The payment information as a string
	 */
	private String paymentSummary(TotalDollarAmounts claimAmounts)
	{
		String 	separator = "____________________________________________________________________________________________________",
				separator2 = "====================================================================================================",
				paymentSumString = "",
				totBilledAmt,
				totAllowedAmt,
				totPaidAmt;
		DecimalFormat dollarFormat = new DecimalFormat("#,###,##0.00");
		
		totBilledAmt = dollarFormat.format(claimAmounts.getTotalBilledAmt());
		totAllowedAmt = dollarFormat.format(claimAmounts.getTotalAllowedAmt());
		totPaidAmt = dollarFormat.format(claimAmounts.getTotalPaidAmt());
		
		paymentSumString += separator + "\r\n\r\n\r\nPAYMENT SUMMARY\r\n" + separator2 + "\r\n\r\n";
		paymentSumString += String.format("%-18s %10s","BILLED AMOUNT  :", totBilledAmt);
		paymentSumString += String.format("%-20s %10s","\r\nALLOWED AMOUNT :", totAllowedAmt);
		paymentSumString += String.format("%-22s %10s","\r\nPAID AMOUNT    :", totPaidAmt + "\r\n");
		
		return paymentSumString;
	}
	
	/**
	 * This builds out the string of all the glossary codes and descriptions and formats for the ERA.
	 * For loop and if statements are to keep the length of the description shorter than 90 characters and wraps
	 * the text if it is longer.
	 * @param lineCodeList An ArrayList of LineRemarkCode for each remark code to be placed in the glossary
	 * @param headerResults Header results object to check if any code is a Provider adjustment code
	 * @param msSQLConnection The MS SQL connection to query for the description
	 * @return The formatted string of glossary codes
	 * @throws SQLTimeoutException Thrown if a timeout happens, caught in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, caught in main method for error handling
	 */
	private String lineCodeGlossary(ArrayList<LineRemarkCode> lineCodeList, RemitHeaderResultSet headerResults, databaseConnection msSQLConnection) throws SQLTimeoutException, SQLException
	{
		int		m = 90,
				//c = 0,
				u = 0,
				t = 1;
		String	separator = "____________________________________________________________________________________________________",
				separator2 = "====================================================================================================",
				glossaryString = "",
				glossaryDetail = "",
				description,
				code;
		boolean	actuallyFound = false;
		LineRemarkCode lineCodes;
		
		glossaryString = separator + "\r\n\r\n\r\n\r\nGLOSSARY\r\n" + separator2 + "\r\n\r\n";
		
		if(lineCodeList.size() > 0)
		{
			for(int i = 0; i < lineCodeList.size(); i++)
			{
				lineCodes = lineCodeList.get(i);
				if(lineCodes != null)
				{	
					actuallyFound = true;
					t = 1;
					glossaryDetail = "";
					description = msSQLConnection.queryCodeGlossary(lineCodes.getpType(), lineCodes.getpCode()) + " ";
					code = (lineCodes.getpType().equalsIgnoreCase("P")) ? lineCodes.getpCode().trim() + "*" : lineCodes.getpCode().trim();
					
					for(int c = 0; c < description.length() - 1 ; c = description.indexOf(" ", c + 1))//(int k = 0; k < description.length(); k++)
					{
						//c = inStr(c + 1, description , " ", 0) binary search case sensitive
						//c = description.indexOf(" ", c + 1);
						if(c == m)
						{
							if(t == 1)
							{
								glossaryDetail += String.format("%-8s %-20s",code, description.substring(0, c) + "\r\n");
								t = 2;
							}
							else
							{
								glossaryDetail += String.format("%-8s %-20s","", description.substring(0, c) + "\r\n");
							}
							description = description.substring(c);
							if(!description.trim().isEmpty())
							{
								description = description.trim() + " ";
							}
							else
							{
								description = description.trim();
							}
							c = 0;
							u = 0;
						}
						else
						{
							if(c > m || c == -1)
							{
								if(t == 1)
								{
									glossaryDetail += String.format("%-8s %-20s",code, description.substring(0, u) + "\r\n");
									t = 2;
								}
								else
								{
									glossaryDetail += String.format("%-8s %-20s","", description.substring(0, u) + "\r\n");
								}
								
								description = description.substring(u);
								if(!description.trim().isEmpty())
								{
									description = description.trim() + " ";
								}
								else
								{
									description = description.trim();
								}
								c = 0;
								u = 0;
							}
							else
							{
								u = c;
							}
						}
					}
					
					
					if(!description.trim().isEmpty())
					{
						if(t == 1)
						{
							glossaryDetail += String.format("%-8s %-20s",code, description + "\r\n");
						}
						else
						{
							glossaryDetail += String.format("%-8s %-20s","", description + "\r\n");
						}
					}
					glossaryString += glossaryDetail + "\r\n";
				}
			}
			
			if(headerResults.isHasProvAdj())
			{
				glossaryString += "\r\n* Provider Adjustment\r\n";
			}
		}
		else
		{
			glossaryString += "NO CODES\r\n\r\n";
		}
		
		if(!actuallyFound)
		{
			glossaryString += "NO CODES\r\n\r\n";
		}
		
		return glossaryString + "\r\n" + separator2 + "\r\n";
	}
	
	/**
	 * This builds Provider Adjustment codes and amounts if there were any, formatted into a string
	 * @param headerResults Header results object for header ID to query off of
	 * @param lineCodeList An ArrayList of LineRemarkCode containing all remark codes, to check for Provider Adj Codes
	 * @param msSQLConnection The MS SQL connection to query prov adj table
	 * @return The provider adjustment formatted into a string
	 * @throws SQLTimeoutException Thrown if a timeout happens, caught in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, caught in main method for error handling
	 */
	private String providerAdjustment(RemitHeaderResultSet headerResults, ArrayList<LineRemarkCode> lineCodeList,databaseConnection msSQLConnection) throws SQLTimeoutException, SQLException
	{
		String	separator = "____________________________________________________________________________________________________",
				separator2 = "====================================================================================================",
				provAdjString = "";
		DecimalFormat dollarFormat = new DecimalFormat("#,###,##0.00");
		RemitProvAdjResultSet provAdjResults;
		ArrayList<RemitProvAdjResultSet> provAdjList;
		
		provAdjList = msSQLConnection.queryProviderAdj(headerResults.getHeaderID());
		
		if(provAdjList.size() > 0)
		{
			headerResults.setHasProvAdj(true);
			provAdjString = separator + "\r\n\r\n\r\n";
			provAdjString += "PROVIDER ADJUSTMENTS\r\n" + separator2 + "\r\n\r\n";
			
			for(int i = 0; i < provAdjList.size(); i++)
			{
				provAdjResults = provAdjList.get(i);
				lineCodeList.add(insertLineCode(provAdjResults.getRsnCode(),"P",lineCodeList));
				
				provAdjString += String.format("%-23s %-36s %-19s %s %10s","PROV ADJ CODE " + (i + 1) + ": " + provAdjResults.getRsnCode(), "FCN: " + provAdjResults.getRefID(), "HIC: ", "AMT: ", dollarFormat.format(provAdjResults.getAdjAmt()) + "\r\n");
			}
		}
		
		return provAdjString;
	}
	
	/**
	 * This is the claim loop, builds all claims into a remit claim list which is used to go into the service line loop per claim
	 * @param headerResults
	 * @param eobResult
	 * @param msSQLConnection
	 */
	/**
	 * 
	 * @param headerResults
	 * @param eobResult
	 * @param claimAmounts
	 * @param lineCodeList
	 * @param msSQLConnection
	 * @return
	 * @throws SQLTimeoutException Thrown if a timeout happens, caught in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, caught in main method for error handling
	 */
	private String eobClaimLoop(RemitHeaderResultSet headerResults, EobResult eobResult, TotalDollarAmounts claimAmounts, ArrayList<LineRemarkCode> lineCodeList, databaseConnection msSQLConnection) throws SQLTimeoutException, SQLException
	{
		//double	claimDollarAmt = 0; this was in the original code but I don't see it used anywhere
		String	claimHeader = "",
				serviceHeaderDetail = "",
				serviceLineTotals = "",
				claimServiceString = "";
		TotalDollarAmounts totalAmounts;
		RemitClaimResultSet remitClaimResults;
		ArrayList<RemitClaimResultSet> remitClaimList;
		ArrayList<TotalAdjAmt> totalAdjList;
		
		//build the list out with for each claim built into a remit claim object
		remitClaimList = msSQLConnection.remitClaimQuery(headerResults,eobResult);
		
		if(remitClaimList.size() > 0)
		{
			//loop for each claim in the list
			for(int i = 0; i < remitClaimList.size(); i++)
			{
				//put the claim into an object and add the total for the final dollar amount total
				remitClaimResults = remitClaimList.get(i);
				totalAdjList = new ArrayList<TotalAdjAmt>();
				totalAmounts = new TotalDollarAmounts(0,0,0,0);
				//claimDollarAmt += Double.parseDouble(remitClaimResults.getClaimPmtAmtCLP04()); this was in the original code but I don't see it used anywhere
				
				//if is a report build out the claim header
				if(this.isReport)
				{
					claimHeader = claimHeader(remitClaimResults,lineCodeList,msSQLConnection);
				}
				
				serviceHeaderDetail = serviceLineLoop(remitClaimResults,lineCodeList,totalAdjList,totalAmounts,msSQLConnection);
				
				claimAdjLoop(remitClaimResults,claimAmounts,lineCodeList,totalAdjList,totalAmounts,msSQLConnection);
				
				if(this.isReport)
				{
					Collections.sort(totalAdjList, TotalAdjAmt.adjAmtKeyComparator);
					serviceLineTotals = serviceLineTotals(totalAmounts,totalAdjList,remitClaimResults);
				}
				
				claimServiceString += claimHeader + serviceHeaderDetail + serviceLineTotals;
			}
		}
		
		return claimServiceString;
	}
	
	/**
	 * This method totals the amounts, pat responsibility and forwarded claim information
	 * @param totalAmounts
	 * @param totalAdjList
	 * @param remitClaimResults
	 * @return
	 */
	private String serviceLineTotals(TotalDollarAmounts totalAmounts, ArrayList<TotalAdjAmt> totalAdjList, RemitClaimResultSet remitClaimResults)
	{
		int		k = 0;
		String	totalBilled,
				totalAllowed,
				totalPaid,
				totAdjAmt,
				key,
				svcLineTotalString = "",
				totalString = "TOTALS",
				separator2 = "----------------------------------------------------------------------------------------------------";
		TotalAdjAmt totalAdjAmt;
		DecimalFormat dollarFormat = new DecimalFormat("#,###,##0.00");
		
		totalBilled = dollarFormat.format(totalAmounts.getTotalBilledAmt());
		totalAllowed = dollarFormat.format(totalAmounts.getTotalAllowedAmt());
		totalPaid = dollarFormat.format(totalAmounts.getTotalPaidAmt());
		svcLineTotalString += separator2 + "\r\n";
		
		if(totalAdjList.size() > 0 && totalAdjList != null)
		{
			for(int i = 0; i < totalAdjList.size(); i++)
			{
				totalAdjAmt = totalAdjList.get(i);
				
				if(totalAdjAmt != null && k ==0)
				{
					totAdjAmt = dollarFormat.format(totalAdjAmt.getTotal());
					key = totalAdjAmt.getKey();
				
					svcLineTotalString += String.format("%-35s %10s %9s %14s %9s %s",totalString,totalBilled,totalAllowed,totalPaid,totAdjAmt,key + "\r\n");
					totalString = "";
					totalBilled = "";
					totalAllowed = "";
					totalPaid = "";
				}
			}
		}
		else
		{
			totAdjAmt = "";
			key = "";
			
			svcLineTotalString += String.format("%-35s %10s %9s %14s %9s %s",totalString,totalBilled,totalAllowed,totalPaid,totAdjAmt,key + "\r\n");
		}
		
		svcLineTotalString += "\r\nTOTAL PAT RESP     : " + dollarFormat.format(totalAmounts.getTotalPRCodeAmt()) + "\r\n";
		
		if(remitClaimResults.getCrossoverCarrierNameNM103() == null || remitClaimResults.getCrossoverCarrierNameNM103().trim().isEmpty())
		{
			svcLineTotalString += "CLAIM INFORMATION FORWARDED TO: -\r\n";
		}
		else
		{
			svcLineTotalString += "CLAIM INFORMATION FORWARDED TO: " + remitClaimResults.getCrossoverCarrierNameNM103().toUpperCase().trim() + "\r\n";
		}
		
		return svcLineTotalString;
	}
	
	/**
	 * 
	 * @param remitClaimResults
	 * @param lineCodeList
	 * @param totalAdjList
	 * @param totalAmounts
	 * @param msSQLConnection
	 */
	private void claimAdjLoop(RemitClaimResultSet remitClaimResults, TotalDollarAmounts claimAmounts, ArrayList<LineRemarkCode> lineCodeList, ArrayList<TotalAdjAmt> totalAdjList, TotalDollarAmounts totalAmounts, databaseConnection msSQLConnection) throws SQLTimeoutException, SQLException
	{
		RemitClaimAdjResultSet claimAdjResults;
		ArrayList<RemitClaimAdjResultSet> claimAdjList;
		
		claimAdjList = msSQLConnection.queryClaimAdjustment(remitClaimResults.getClaimNo());
		
		if(claimAdjList.size() > 0)
		{
			remitClaimResults.setHasClaimAdj(true);
			
			for(int i = 0; i < claimAdjList.size(); i++)
			{
				claimAdjResults = claimAdjList.get(i);
				
				lineCodeList.add(insertLineCode(claimAdjResults.getRsnCode(),"C",lineCodeList));
				
				totalAdjList.add(serviceLineAdjTotals("",claimAdjResults.getRsnCode().trim(),claimAdjResults.getAdjAmt(),totalAdjList,totalAmounts));
			}
		}
		
		if(remitClaimResults.isHasServiceLine() && remitClaimResults.isHasClaimAdj())
		{
			totalAmounts.setTotalBilledAmt(((remitClaimResults.getClaimChargeAmtCLP03() == null || remitClaimResults.getClaimChargeAmtCLP03().isEmpty()) ? 0 : Double.parseDouble(remitClaimResults.getClaimChargeAmtCLP03())));
			totalAmounts.setTotalPaidAmt(((remitClaimResults.getClaimPmtAmtCLP04() == null || remitClaimResults.getClaimPmtAmtCLP04().isEmpty()) ? 0 : Double.parseDouble(remitClaimResults.getClaimPmtAmtCLP04())));
		}
		else if(remitClaimResults.isHasClaimAdj())
		{
			totalAmounts.setTotalBilledAmt(totalAmounts.getTotalBilledAmt() + ((remitClaimResults.getClaimChargeAmtCLP03() == null || remitClaimResults.getClaimChargeAmtCLP03().isEmpty()) ? 0 : Double.parseDouble(remitClaimResults.getClaimChargeAmtCLP03())));
			totalAmounts.setTotalPaidAmt(totalAmounts.getTotalPaidAmt() + ((remitClaimResults.getClaimPmtAmtCLP04() == null || remitClaimResults.getClaimPmtAmtCLP04().isEmpty()) ? 0 : Double.parseDouble(remitClaimResults.getClaimPmtAmtCLP04())));
		}
		
		claimAmounts.setTotalBilledAmt(claimAmounts.getTotalBilledAmt() + totalAmounts.getTotalBilledAmt());
		claimAmounts.setTotalAllowedAmt(claimAmounts.getTotalAllowedAmt() + totalAmounts.getTotalAllowedAmt());
		claimAmounts.setTotalPaidAmt(claimAmounts.getTotalPaidAmt() + totalAmounts.getTotalPaidAmt());
	}	
	
	/**
	 * This is the service line loop, that grabs the service lines and service line details to build out a string
	 * for the service line detail results
	 * @param remitClaimResults
	 * @param lineCodeList
	 * @param msSQLConnection
	 * @return
	 */
	private String serviceLineLoop(RemitClaimResultSet remitClaimResults, ArrayList<LineRemarkCode> lineCodeList, ArrayList<TotalAdjAmt> totalAdjList, TotalDollarAmounts totalAmounts, databaseConnection msSQLConnection) throws SQLTimeoutException, SQLException
	{
		String	serviceLineHeader = "",
				svcDateStart,
				svcDateEnd,
				svcDate,
				svcDateRange,
				procCode,
				procMods,
				lineQtyPd,
				lineCharge,
				allowedAmt,
				lineOrigQty,
				pmtAmt,
				lineRemarkCode,
				adjAmt,
				adjRsnCode,
				lineDetailString = "";
		DecimalFormat dollarFormat = new DecimalFormat("#,###,##0.00");
		RemitServiceLineResultSet serviceLineResults;
		ServiceLineDetailResultSet lineDetailResults;
		ArrayList<RemitServiceLineResultSet> serviceLineList;
		ArrayList<ServiceLineDetailResultSet> lineDetailList;
		
		serviceLineList = msSQLConnection.queryServiceLine(remitClaimResults.getClaimNo());
		
		if(this.isReport)
		{
			//create the service line header
			serviceLineHeader = serviceLineHeader();
		}
		
		if(serviceLineList.size() > 0)
		{
			remitClaimResults.setHasServiceLine(true);
			//loop through each service line in the list
			for(int i = 0; i < serviceLineList.size(); i++)
			{
				serviceLineResults = serviceLineList.get(i);
				
				//populate service date, start and end if located in service line results
				svcDateStart = (serviceLineResults.getLineServiceDateStartDTM02() == null || serviceLineResults.getLineServiceDateStartDTM02().trim().isEmpty()) ? "" : serviceLineResults.getLineServiceDateStartDTM02().trim();
				svcDateEnd = (serviceLineResults.getLineServiceDateEndDTM02() == null || serviceLineResults.getLineServiceDateEndDTM02().trim().isEmpty()) ? "" : serviceLineResults.getLineServiceDateEndDTM02().trim();
				svcDate = (serviceLineResults.getLineServiceDateDTM02() == null || serviceLineResults.getLineServiceDateDTM02().trim().isEmpty()) ? "" : serviceLineResults.getLineServiceDateDTM02().trim();
				
				//if dates are empty retrieve them from the claim results object
				if(svcDateStart.isEmpty() && svcDateStart.isEmpty() && svcDate.isEmpty())
				{
					svcDateStart = (remitClaimResults.getClaimStartDateDTM02() == null || remitClaimResults.getClaimStartDateDTM02().trim().isEmpty()) ? "" : remitClaimResults.getClaimStartDateDTM02().trim();
					svcDateEnd = (remitClaimResults.getClaimEndDateDTM02() == null || remitClaimResults.getClaimEndDateDTM02().trim().isEmpty()) ? "" : remitClaimResults.getClaimEndDateDTM02().trim();
					
					//if start or end is empty replace with the other.
					if(svcDateStart.isEmpty())
					{
						svcDateStart = svcDateEnd;
					}
					
					if(svcDateEnd.isEmpty())
					{
						svcDateEnd = svcDateStart;
					}
				}
				else
				{
					//if they weren't empty but one is set it to the service date
					if(svcDateStart.isEmpty() && !svcDate.isEmpty())
					{
						svcDateStart = svcDate;
						svcDateEnd = svcDate;
					}
					else if (svcDateEnd.isEmpty() && !svcDate.isEmpty())
					{
						svcDateEnd = svcDate;
					}
					else if (svcDateEnd.isEmpty() && svcDate.isEmpty())
					{
						svcDateEnd = svcDateStart;
					}

				}
				
				//build out the date range string
				svcDateRange = svcDateStart.substring(4,6) + "/" + svcDateStart.substring(6,8) + "/" + svcDateStart.substring(2,4) + "-" + svcDateEnd.substring(4,6) + "/" + svcDateEnd.substring(6,8) + "/" + svcDateEnd.substring(2,4);
				
				//get the procedure code and modifiers
				procCode = serviceLineResults.getProcedureCodeSVC012().trim();
				procMods = serviceLineResults.getProcedureMod1SVC013().trim() + serviceLineResults.getProcedureMod2SVC014().trim() + serviceLineResults.getProcedureMod3SVC015().trim() + serviceLineResults.getProceudreMod4SVC016();
				
				//get the line quantity paid
				lineQtyPd = (serviceLineResults.getLineQtyPaidSVC05() == null || serviceLineResults.getLineQtyPaidSVC05().isEmpty()) ? "0" : serviceLineResults.getLineQtyPaidSVC05().trim();
				lineQtyPd = (lineQtyPd.equalsIgnoreCase("0")) ? "" : ((lineQtyPd.length() == 1) ? "0" + lineQtyPd : lineQtyPd);
				
				//total the billed amount and set the line charge locally
				totalAmounts.setTotalBilledAmt(totalAmounts.getTotalBilledAmt() + ((serviceLineResults.getLineChargeSVC02() == null || serviceLineResults.getLineChargeSVC02().isEmpty()) ? 0 : Double.parseDouble(serviceLineResults.getLineChargeSVC02())));
				lineCharge = dollarFormat.format((serviceLineResults.getLineChargeSVC02() == null || serviceLineResults.getLineChargeSVC02().isEmpty()) ? 0 : Double.parseDouble(serviceLineResults.getLineChargeSVC02()));
				
				//total the allowed amount and set the allowed amount locally
				totalAmounts.setTotalAllowedAmt(totalAmounts.getTotalAllowedAmt() + ((serviceLineResults.getLineAllowedActualAmtAMT02() == null || serviceLineResults.getLineAllowedActualAmtAMT02().isEmpty()) ? 0 : Double.parseDouble(serviceLineResults.getLineAllowedActualAmtAMT02())));
				allowedAmt = dollarFormat.format((serviceLineResults.getLineAllowedActualAmtAMT02() == null || serviceLineResults.getLineAllowedActualAmtAMT02().isEmpty()) ? 0 : Double.parseDouble(serviceLineResults.getLineAllowedActualAmtAMT02()));
				
				//set the line original quantity
				lineOrigQty = (serviceLineResults.getLineOrigQtySVC07() == null || serviceLineResults.getLineOrigQtySVC07().isEmpty()) ? "0" : serviceLineResults.getLineOrigQtySVC07().trim();
				lineOrigQty = (lineOrigQty.equalsIgnoreCase("0")) ? "" : ((lineOrigQty.length() == 1) ? "0" + lineOrigQty : lineOrigQty);
				
				//total the paid amount and set the payment amount locally
				totalAmounts.setTotalPaidAmt(totalAmounts.getTotalPaidAmt() + ((serviceLineResults.getLinePmtAmtSVC03() == null || serviceLineResults.getLinePmtAmtSVC03().isEmpty()) ? 0 : Double.parseDouble(serviceLineResults.getLinePmtAmtSVC03())));
				pmtAmt = dollarFormat.format((serviceLineResults.getLinePmtAmtSVC03() == null || serviceLineResults.getLinePmtAmtSVC03().isEmpty()) ? 0 : Double.parseDouble(serviceLineResults.getLinePmtAmtSVC03()));
				
				if(serviceLineResults.getLineRemarkCodeQualLQ01().trim().equalsIgnoreCase("HE"))
				{
					//if the line Remark code is HE insert into the line code list and set code locally
					lineCodeList.add(insertLineCode(serviceLineResults.getLineRemarkCodeLQ02().trim(),"S",lineCodeList));
					lineRemarkCode = serviceLineResults.getLineRemarkCodeLQ02().trim();
				}
				else
				{
					lineRemarkCode = "";
				}
				
				//get the details and adjustment amounts
				lineDetailList = msSQLConnection.queryDetailServiceLine(serviceLineResults);
				
				if(lineDetailList.size() > 0)
				{
					//loop through the detail list if populated
					for(int k = 0; k < lineDetailList.size(); k++)
					{
						lineDetailResults = lineDetailList.get(k);
						
						if(allowedAmt.equalsIgnoreCase("0.00"))
						{
							allowedAmt = "";
						}
						
						//insert line code remarks
						lineCodeList.add(insertLineCode(lineDetailResults.getAdjCode(),"S",lineCodeList));
						lineCodeList.add(insertLineCode(lineDetailResults.getRsnCode(),"S",lineCodeList));
						
						//set the total adjustments and set the adjustment amounts and RSN codes
						totalAdjList.add(serviceLineAdjTotals(lineDetailResults.getAdjCode().trim(),lineDetailResults.getRsnCode().trim(),((lineDetailResults.getAdjAmt() == null || lineDetailResults.getAdjAmt().isEmpty()) ? 0 : Double.parseDouble(lineDetailResults.getAdjAmt())),totalAdjList,totalAmounts));
						adjAmt = dollarFormat.format(Double.parseDouble(lineDetailResults.getAdjAmt()));
						adjRsnCode = lineDetailResults.getAdjCode().trim() + "-" + lineDetailResults.getRsnCode().trim();
						
						//build the string, first one will contain all information, any new ones per line detail list will only contain the adj amt and RSN code
						lineDetailString += String.format("%-17s %-5s %-8s %-3s %9s %10s %-3s %9s %9s %-6s %s",svcDateRange,procCode,procMods,lineOrigQty,lineCharge,allowedAmt + " ",
									lineQtyPd,pmtAmt,adjAmt,adjRsnCode,lineRemarkCode + "\r\n");
						
						//set these variables to empty so they don't repopulate for each loop
						svcDateRange = "";
						procCode = "";
						procMods = "";
						lineCharge = "";
						allowedAmt = "";
						lineQtyPd = "";
						pmtAmt = "";
						lineRemarkCode = "";
					}
				}
				else
				{
					adjAmt = "";
					adjRsnCode = "";
					
					//build string without the the adj amt and RSN code because there were none
					lineDetailString += String.format("%-17s %-5s %-8s %-3s %9s %10s %-3s %9s %9s %-6s %s",svcDateRange,procCode,procMods,lineOrigQty,lineCharge,allowedAmt + " ",
							lineQtyPd,pmtAmt,adjAmt,adjRsnCode,lineRemarkCode + "\r\n");
				}
			}
		}
		else
		{
			//there were no service lines to be included in the ERA
			lineDetailString += "NO SERVICE LINE INFORMATION AVAILABLE FOR THIS CLAIM\r\n";
		}
		
		return serviceLineHeader + lineDetailString;
	}
	
	private TotalAdjAmt serviceLineAdjTotals(String pAdj, String pKey, double pAmt, ArrayList<TotalAdjAmt> totalAdjList,TotalDollarAmounts totalAmounts)
	{
		boolean found = false;
		TotalAdjAmt totalAdjAmt = null;
		
		for(int i = 0; i < totalAdjList.size(); i++)
		{
			totalAdjAmt = totalAdjList.get(i);
			if(totalAdjAmt != null)
			{
				if(totalAdjAmt.getKey().equalsIgnoreCase(pKey))
				{
					found = true;
					totalAdjAmt.setTotal(totalAdjAmt.getTotal() + pAmt);
					break;
				}
			}
		}	
			
		if(!found)
		{
			totalAdjAmt = new TotalAdjAmt(0,pKey,pAmt,0);
		}
		else
		{
			totalAdjAmt = null;
		}
		
		if(pAdj.equalsIgnoreCase("PR"))
		{
			totalAmounts.setTotalPRCodeAmt(totalAmounts.getTotalPRCodeAmt() + pAmt);
		}
		
		return totalAdjAmt;
	}
	
	/**
	 * 
	 * @return
	 */
	private String serviceLineHeader()
	{
		String	separator = "----------------------------------------------------------------------------------------------------",
				serviceLineHeader;
		
		serviceLineHeader = String.format("%-17s %-5s %-10s %-12s %-12s %-13s %-6s %-6s %-6s","SERVICE","PROC","MODS","BILLED","ALLOWED","PAID","ADJ","ADJ","LINE REMARK\r\n");
		serviceLineHeader += String.format("%-17s %-14s %-6s %-9s %-7s %-6s %-9s %-6s %-6s %-3s","DATE","CODE","UNI","AMT","AMT","UNI","AMT","AMT","CODES","CODE\r\n");
		serviceLineHeader += separator + "\r\n";
		
		return serviceLineHeader;
	}
	
	/**
	 * This builds the Claim header string
	 * @param remitClaimResults
	 * @param msSQLConnection
	 * @return
	 */
	private String claimHeader(RemitClaimResultSet remitClaimResults, ArrayList<LineRemarkCode> lineCodeList, databaseConnection msSQLConnection) throws SQLTimeoutException, SQLException
	{
		String 	separator = "____________________________________________________________________________________________________",
				separator2 = "----------------------------------------------------------------------------------------------------",
				claimHeader,
				patName,
				date = "",
				startDate,
				endDate,
				rendProvID,
				remarkCodeString,
				sDateQuery = "select line_service_date_start_dtm02 as sd from remittance_svc_lines where claim_no = '" + remitClaimResults.getClaimNo() + 
							"' and line_service_date_start_dtm02 <> '' and line_service_date_start_dtm02 is not null union select line_service_date_dtm02 as sd from remittance_svc_lines where claim_no = '" + remitClaimResults.getClaimNo() + 
							"' and line_service_date_dtm02 <> '' and line_service_date_dtm02 is not null order by sd asc",
				eDateQuery = "select line_service_date_end_dtm02 as ed from remittance_svc_lines where claim_no = '" + remitClaimResults.getClaimNo() + 
							"' and line_service_date_end_dtm02 <> '' and line_service_date_end_dtm02 is not null union select line_service_date_dtm02 as ed from remittance_svc_lines where claim_no = '" + remitClaimResults.getClaimNo() + 
							"' and line_service_date_dtm02 <> '' and line_service_date_dtm02 is not null order by ed desc";
		boolean	noQuery = false;
		
		claimHeader = separator + "\r\n\r\n";
		
		claimHeader += String.format("%-48s %-20s","PAT ACCOUNT NO     : " + remitClaimResults.getPatientAcctNoCLP01().trim(), "CLAIM ID           : " + remitClaimResults.getPayerControlNoCLP07().trim() + "\r\n");
		
		//Added for one encounter with a NULL claim no
		if(remitClaimResults.getClaimNo() == null || remitClaimResults.getClaimNo().isEmpty())
		{
			noQuery = true;
		}
		
		//if the patient has a middle name build string with middle name
		if(!remitClaimResults.getPatMiddleNM105().trim().isEmpty())
		{
			patName = remitClaimResults.getPatFirstNM104().trim() + " " + remitClaimResults.getPatMiddleNM105().trim() + " " + remitClaimResults.getPatLastNM103().trim();
		}
		else
		{
			patName = remitClaimResults.getPatFirstNM104().trim() + " " + remitClaimResults.getPatLastNM103().trim();
		}
		
		//If there is a received date, create a string for it
		if(!remitClaimResults.getClaimRecDateDTM02().trim().isEmpty())
		{
			date = remitClaimResults.getClaimRecDateDTM02().trim().substring(4,6) + "/" + remitClaimResults.getClaimRecDateDTM02().trim().substring(6,8) + "/" + remitClaimResults.getClaimRecDateDTM02().trim().substring(0,4);
		}
		
		claimHeader += String.format("%-48s %-20s","PAT NAME           : " + patName, "RECEIVED DATE      : " + date + "\r\n");
		
		startDate = remitClaimResults.getClaimStartDateDTM02().trim();
		endDate = remitClaimResults.getClaimEndDateDTM02().trim();
		
		//Check to see if there is a start date, if not query the database to get a start and end date
		if(startDate.isEmpty() || startDate == null)
		{
			if(!noQuery)
			{
				startDate = msSQLConnection.claimDateQuery(sDateQuery,"sd");
				//May need to add if statement here for blank start and end dates due to PayDC ERA
				startDate = startDate.substring(4,6) + "/" + startDate.substring(6,8) + "/" + startDate.substring(0,4);
				
				endDate = msSQLConnection.claimDateQuery(eDateQuery,"ed");
				
				endDate = endDate.substring(4,6) + "/" + endDate.substring(6,8) + "/" + endDate.substring(0,4);
			}
			else
			{
				startDate = "";
				endDate = "";
			}
		}
		else
		{
			startDate = startDate.substring(4,6) + "/" + startDate.substring(6,8) + "/" + startDate.substring(0,4);
			
			if(endDate.isEmpty() || endDate == null)
			{
				endDate = startDate;
			}
			else
			{
				endDate = endDate.substring(4,6) + "/" + endDate.substring(6,8) + "/" + endDate.substring(0,4);
			}
		}
		
		claimHeader += String.format("%-48s %-20s","PAT ID NUMBER      : " + remitClaimResults.getPatIDCodeNM109().trim(), "CLAIM DATE RANGE   : " + startDate + " - " + endDate + "\r\n");
		
		rendProvID = msSQLConnection.queryRendProvID(remitClaimResults);
		
		//Insert the remark codes into the lineCodeList
		lineCodeList.add(insertLineCode(remitClaimResults.getRemarkCode1MOA03().trim(),"R",lineCodeList));
		lineCodeList.add(insertLineCode(remitClaimResults.getRemarkCode2MOA04().trim(),"R",lineCodeList));
		lineCodeList.add(insertLineCode(remitClaimResults.getRemarkCode3MOA05().trim(),"R",lineCodeList));
		lineCodeList.add(insertLineCode(remitClaimResults.getRemarkCode4MOA06().trim(),"R",lineCodeList));
		lineCodeList.add(insertLineCode(remitClaimResults.getRemarkCode5MOA07().trim(),"R",lineCodeList));
		
		remarkCodeString = (remitClaimResults.getRemarkCode1MOA03().trim().equalsIgnoreCase("")) ? "" : remitClaimResults.getRemarkCode1MOA03().trim() + " ";
		remarkCodeString += (remitClaimResults.getRemarkCode2MOA04().trim().equalsIgnoreCase("")) ? "" : remitClaimResults.getRemarkCode2MOA04().trim() + " ";
		remarkCodeString += (remitClaimResults.getRemarkCode3MOA05().trim().equalsIgnoreCase("")) ? "" : remitClaimResults.getRemarkCode3MOA05().trim() + " ";
		remarkCodeString += (remitClaimResults.getRemarkCode4MOA06().trim().equalsIgnoreCase("")) ? "" : remitClaimResults.getRemarkCode4MOA06().trim() + " ";
		remarkCodeString += (remitClaimResults.getRemarkCode5MOA07().trim().equalsIgnoreCase("")) ? "" : remitClaimResults.getRemarkCode5MOA07().trim() + " ";
		
		claimHeader += String.format("%-48s %-20s","RENDERING PROVIDER : " + rendProvID.trim(), "CLAIM REMARK CODES : " + remarkCodeString + "\r\n");
		//if we ever use serial number lookup again logic will go here
		
		claimHeader += separator2 + "\r\n";
		
		return claimHeader;
	}
	
	/**
	 * This searched the lineCode list for a match, if none is found, create a new line remark code object with the new data
	 * @param remarkCode
	 * @param lineCodeList
	 * @return
	 */
	private LineRemarkCode insertLineCode(String remarkCode, String pType, ArrayList<LineRemarkCode> lineCodeList)
	{
		boolean found = false,
				isNumeric;
		String	newKey;
		LineRemarkCode lineRemarkCode = null;
		
		if(remarkCode.isEmpty())
		{
			return null;
		}
		
		for(int i = 0; i < lineCodeList.size(); i++)
		{
			lineRemarkCode = lineCodeList.get(i);
			
			if(lineRemarkCode != null)
			{
				if(lineRemarkCode.getpCode().equalsIgnoreCase(remarkCode) && lineRemarkCode.getpType().equalsIgnoreCase(pType))
				{
					found = true;
					break;
				}
			}
		}
			
		if(!found)
		{
			try
			{
				Integer.parseInt(remarkCode.substring(0,1));
				isNumeric = true;
			}
			catch(NumberFormatException nfe)
			{
				isNumeric = false;
			}
			
			if(isNumeric)
			{
				switch(remarkCode.length())
				{
					case 1:
						newKey = "00" + remarkCode;
						break;
					case 2:
						newKey = "0" + remarkCode;
						break;
					default:
						newKey = remarkCode;
						break;
				}
			}
			else
			{
				switch(remarkCode.length())
				{
					case 2:
						newKey = remarkCode.substring(0,1) + "0" + remarkCode.substring(1,2);
						break;
					default:
						newKey = remarkCode;
						break;
				}
			}
			
			lineRemarkCode = new LineRemarkCode(remarkCode,newKey,pType);
		}
		else
		{
			return null;
		}
		
		return lineRemarkCode;
	}
	
	/**
	 * 
	 */
	private String reportHeader(RemitHeaderResultSet headerResults)
	{
		String 	pageHeader = "THIS REPORT CONTAINS HEALTH CARE INFORMATION.  HANDLE ONLY ACCORDING TO THE APPROPRIATE \r\nSECURITY AND PRIVACY PROCEDURES.\r\n\r\n\r\n",
				payerHeader,
				payeeHeader,
				output = "",
				cityStateZip;
		DecimalFormat dollarFormat = new DecimalFormat("#,##0.00");
		MaskFormatter 	zip,
						phone;
		
		//build out the payer header first
		payerHeader = headerResults.getPayerNameN102().trim() + "\r\n" + headerResults.getPayerAddress1N301().trim() + "\r\n";
		if(!headerResults.getPayerAddress2N302().trim().isEmpty())
		{
			payerHeader += headerResults.getPayerAddress2N302().trim() + "\r\n";
		}
		
		payerHeader += headerResults.getPayerCityN401().trim() + " " + headerResults.getPayerStateN402().trim() + " ";
		
		try 
		{
			zip = new MaskFormatter("#####-####");
			zip.setValueContainsLiteralCharacters(false);
			
	        output = zip.valueToString(headerResults.getPayerZipN403()).trim();
	        if(output.endsWith("-"))
	        {            
	            output=output.substring(0,output.length()-1);
	        }
	        payerHeader += " " + output + "\r\n";
		} 
		catch (ParseException e) 
		{
			output = "";
			payerHeader += " " + output + "\r\n";
		}
		
		if(headerResults.getPayerComNoQualPER03().trim().equalsIgnoreCase("UR") && this.jobName.equalsIgnoreCase("SYSTEMS4PT_DATA_OUTPUT"))
		{
			payerHeader += "\r\n";
		}
		else if(headerResults.getPayerComNoQualPER03().trim().equalsIgnoreCase("TE"))
		{
			try
			{
				phone = new MaskFormatter("(###) ###-####");
				phone.setValueContainsLiteralCharacters(false);
				
				payerHeader += phone.valueToString(headerResults.getPayerComNoPER04().trim());
			}
			catch(ParseException e)
			{
				payerHeader += "";
			}
		}
		
		payerHeader += "\r\n\r\n";
		
		//payeeHeader = String.format("%-48s %-20s",headerResults.getPayeeNameN102().trim(), "PRODUCTION DATE    : " + headerResults.getProductionDateDTTM02().trim().substring(4,6) + "/" + headerResults.getProductionDateDTTM02().trim().substring(6,8) + "/" + headerResults.getProductionDateDTTM02().trim().substring(0,4) + "\r\n");
		if(!headerResults.getProductionDateDTTM02().trim().isEmpty())
		{
			payeeHeader = String.format("%-48s %-20s",headerResults.getPayeeNameN102().trim(), "PRODUCTION DATE    : " + headerResults.getProductionDateDTTM02().trim().substring(4,6) + "/" + headerResults.getProductionDateDTTM02().trim().substring(6,8) + "/" + headerResults.getProductionDateDTTM02().trim().substring(0,4) + "\r\n");
		}
		else
		{
			payeeHeader = String.format("%-48s %-20s",headerResults.getPayeeNameN102().trim(), "PRODUCTION DATE    :\r\n");
		}
		
		payeeHeader += String.format("%-48s %-20s",headerResults.getPayeeAddress1N301(), "PAYMENT ISSUE DATE : " + headerResults.getPmtIssueDateBPR16().trim().substring(4,6) + "/" + headerResults.getPmtIssueDateBPR16().trim().substring(6,8) + "/" + headerResults.getPmtIssueDateBPR16().trim().substring(0,4) + "\r\n");
		
		if(!headerResults.getPayeeAddress2N302().trim().isEmpty())
		{
			payeeHeader += String.format("%-48s %-20s",headerResults.getPayeeAddress2N302().trim(), "PAYMENT AMOUNT     : " + dollarFormat.format(Double.parseDouble(headerResults.getTotalPmtAmtBPR02())) + "\r\n");
			cityStateZip = headerResults.getPayeeCityN401().trim() + " " + headerResults.getPayeeStateN402().trim() + " ";
			
			try 
			{
				zip = new MaskFormatter("#####-####");
				zip.setValueContainsLiteralCharacters(false);
				
		        output = zip.valueToString(headerResults.getPayeeZipN403()).trim();
		        if(output.endsWith("-"))
		        {            
		            output = output.substring(0,output.length()-1);
		        }
		        cityStateZip += " " + output;
			} 
			catch (ParseException e) 
			{
				output = "";
				cityStateZip += " " + output + "\r\n";
			}
			
			payeeHeader += String.format("%-48s %-20s",cityStateZip, "CHECK/EFT NO       : " + headerResults.getTraceNoTRN02().trim());
		}
		else
		{
			cityStateZip =  headerResults.getPayeeCityN401().trim() + " " + headerResults.getPayeeStateN402().trim() + " ";
	
			try 
			{
				zip = new MaskFormatter("#####-####");
				zip.setValueContainsLiteralCharacters(false);
				
		        output = zip.valueToString(headerResults.getPayeeZipN403()).trim();
		        if(output.endsWith("-"))
		        {            
		            output = output.substring(0,output.length()-1);
		        }
		        cityStateZip += " " + output;
			} 
			catch (ParseException e) 
			{
				output = "";
				cityStateZip += " " + output + "\r\n";
			}
			
			payeeHeader += String.format("%-48s %-20s",cityStateZip, "PAYMENT AMOUNT     : " + dollarFormat.format(Double.parseDouble(headerResults.getTotalPmtAmtBPR02())) + "\r\n");
			
			payeeHeader += String.format("%-48s %-20s","","CHECK/EFT NO       : " + headerResults.getTraceNoTRN02().trim());
		}
		
		payeeHeader += "\r\n\r\n\r\n";
		
		return pageHeader + payerHeader + payeeHeader;
	}

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @return the jobType
	 */
	public String getJobType() {
		return jobType;
	}

	/**
	 * @return the sqlSelect
	 */
	public String getSqlSelect() {
		return sqlSelect;
	}

	/**
	 * @return the rptSysDsn
	 */
	public String getRptSysDsn() {
		return rptSysDsn;
	}

	/**
	 * @return the builtStatusMark
	 */
	public String getBuiltStatusMark() {
		return builtStatusMark;
	}

	/**
	 * @return the dataReportDelimiter
	 */
	public String getDataReportDelimiter() {
		return dataReportDelimiter;
	}

	/**
	 * @return the provTaxIDMark
	 */
	public String getProvTaxIDMark() {
		return provTaxIDMark;
	}

	/**
	 * @return the sub835EnrollmentMark
	 */
	public String getSub835EnrollmentMark() {
		return sub835EnrollmentMark;
	}

	/**
	 * @return the sub835EnrollmentDataMark
	 */
	public String getSub835EnrollmentDataMark() {
		return sub835EnrollmentDataMark;
	}

	/**
	 * @return the subInactiveMark
	 */
	public String getSubInactiveMark() {
		return subInactiveMark;
	}

	/**
	 * @return the subCancelledMark
	 */
	public String getSubCancelledMark() {
		return subCancelledMark;
	}

	/**
	 * @return the subCreditHoldMark
	 */
	public String getSubCreditHoldMark() {
		return subCreditHoldMark;
	}

	/**
	 * @return the subClosedMark
	 */
	public String getSubClosedMark() {
		return subClosedMark;
	}

	/**
	 * @return the headerClaimAmtPaidMark
	 */
	public String getHeaderClaimAmtPaidMark() {
		return headerClaimAmtPaidMark;
	}

	/**
	 * @return the webDescription
	 */
	public String getWebDescription() {
		return webDescription;
	}

	/**
	 * @return the outputPath
	 */
	public String getOutputPath() {
		return outputPath;
	}

	/**
	 * @return the outputFileName
	 */
	public String getOutputFileName() {
		return outputFileName;
	}

	/**
	 * @return the outputFileExistsRule
	 */
	public String getOutputFileExistsRule() {
		return outputFileExistsRule;
	}

	/**
	 * @return the incrementalChar
	 */
	public String getIncrementalChar() {
		return incrementalChar;
	}

	/**
	 * @return the fileErrorMark
	 */
	public String getFileErrorMark() {
		return fileErrorMark;
	}

	/**
	 * @return the tempPath
	 */
	public String getTempPath() {
		return tempPath;
	}

	/**
	 * @return the successRecip
	 */
	public String getSuccessRecip() {
		return successRecip;
	}

	/**
	 * @return the successFromName
	 */
	public String getSuccessFromName() {
		return successFromName;
	}

	/**
	 * @return the successFromAddr
	 */
	public String getSuccessFromAddr() {
		return successFromAddr;
	}

	/**
	 * @return the someBuiltRecip
	 */
	public String getSomeBuiltRecip() {
		return someBuiltRecip;
	}

	/**
	 * @return the someBuiltFromName
	 */
	public String getSomeBuiltFromName() {
		return someBuiltFromName;
	}

	/**
	 * @return the someBuiltFromAddr
	 */
	public String getSomeBuiltFromAddr() {
		return someBuiltFromAddr;
	}

	/**
	 * @return the zeroBuiltRecip
	 */
	public String getZeroBuiltRecip() {
		return zeroBuiltRecip;
	}

	/**
	 * @return the zeroBuiltFromName
	 */
	public String getZeroBuiltFromName() {
		return zeroBuiltFromName;
	}

	/**
	 * @return the zeroBuiltFromAddr
	 */
	public String getZeroBuiltFromAddr() {
		return zeroBuiltFromAddr;
	}

	/**
	 * @return the errorRecip
	 */
	public String getErrorRecip() {
		return errorRecip;
	}

	/**
	 * @return the errorFromName
	 */
	public String getErrorFromName() {
		return errorFromName;
	}

	/**
	 * @return the errorFromAddr
	 */
	public String getErrorFromAddr() {
		return errorFromAddr;
	}

	/**
	 * @return the errorShowModally
	 */
	public String getErrorShowModally() {
		return errorShowModally;
	}

	/**
	 * @return the warningShowModally
	 */
	public String getWarningShowModally() {
		return warningShowModally;
	}

	/**
	 * @return the infoShowModally
	 */
	public String getInfoShowModally() {
		return infoShowModally;
	}

	/**
	 * @return the appName
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @return the workstation
	 */
	public String getWorkstation() {
		return workstation;
	}

	/**
	 * @return the recip
	 */
	public String getRecip() {
		return recip;
	}

	/**
	 * @return the fromName
	 */
	public String getFromName() {
		return fromName;
	}

	/**
	 * @return the fromAddr
	 */
	public String getFromAddr() {
		return fromAddr;
	}

	/**
	 * @return the smtpHost
	 */
	public String getSmtpHost() {
		return smtpHost;
	}

	/**
	 * @return the smtpAlt
	 */
	public String getSmtpAlt() {
		return smtpAlt;
	}

	/**
	 * @return the msgKey
	 */
	public String getMsgKey() {
		return msgKey;
	}

	/**
	 * @return the rptCreateDateTime
	 */
	public String getRptCreateDateTime() {
		return rptCreateDateTime;
	}

	/**
	 * @return the rptRunDateTime
	 */
	public String getRptRunDateTime() {
		return rptRunDateTime;
	}

	/**
	 * @return the rptCnnTimeout
	 */
	public int getRptCnnTimeout() {
		return rptCnnTimeout;
	}

	/**
	 * @return the rptCmdTimeout
	 */
	public int getRptCmdTimeout() {
		return rptCmdTimeout;
	}

	/**
	 * @return the serialNoLookupCmdTimeout
	 */
	public int getSerialNoLookupCmdTimeout() {
		return serialNoLookupCmdTimeout;
	}

	/**
	 * @return the cnnTimeout
	 */
	public int getCnnTimeout() {
		return cnnTimeout;
	}

	/**
	 * @return the cmdTimeout
	 */
	public int getCmdTimeout() {
		return cmdTimeout;
	}

	/**
	 * @return the remitSelected
	 */
	public int getRemitSelected() {
		return remitSelected;
	}

	/**
	 * @return the remitBuilt
	 */
	public int getRemitBuilt() {
		return remitBuilt;
	}

	/**
	 * @return the jobFound
	 */
	public boolean isJobFound() {
		return jobFound;
	}

	/**
	 * @return the isReport
	 */
	public boolean isReport() {
		return isReport;
	}

	/**
	 * @return the isReportPost
	 */
	public boolean isReportPost() {
		return isReportPost;
	}

	/**
	 * @return the jobEnabled
	 */
	public boolean isJobEnabled() {
		return jobEnabled;
	}

	/**
	 * @return the includeColumnHeadings
	 */
	public boolean isIncludeColumnHeadings() {
		return includeColumnHeadings;
	}

	/**
	 * @return the serialNoLookup
	 */
	public boolean isSerialNoLookup() {
		return serialNoLookup;
	}

	/**
	 * @return the provTaxIDRollBack
	 */
	public boolean isProvTaxIDRollBack() {
		return provTaxIDRollBack;
	}

	/**
	 * @return the sub835EnrollmentRollback
	 */
	public boolean isSub835EnrollmentRollback() {
		return sub835EnrollmentRollback;
	}

	/**
	 * @return the sub835EnrollmentDataRollback
	 */
	public boolean isSub835EnrollmentDataRollback() {
		return sub835EnrollmentDataRollback;
	}

	/**
	 * @return the postSubInactiveRpt
	 */
	public boolean isPostSubInactiveRpt() {
		return postSubInactiveRpt;
	}

	/**
	 * @return the postSubCancelledRpt
	 */
	public boolean isPostSubCancelledRpt() {
		return postSubCancelledRpt;
	}

	/**
	 * @return the postSubCreditHoldRpt
	 */
	public boolean isPostSubCreditHoldRpt() {
		return postSubCreditHoldRpt;
	}

	/**
	 * @return the postSubClosedRpt
	 */
	public boolean isPostSubClosedRpt() {
		return postSubClosedRpt;
	}

	/**
	 * @return the verifyHeaderClaimAmtPaid
	 */
	public boolean isVerifyHeaderClaimAmtPaid() {
		return verifyHeaderClaimAmtPaid;
	}

	/**
	 * @return the headerClaimAmtPaidRollback
	 */
	public boolean isHeaderClaimAmtPaidRollback() {
		return headerClaimAmtPaidRollback;
	}

	/**
	 * @return the useLeadZero
	 */
	public boolean isUseLeadZero() {
		return useLeadZero;
	}

	/**
	 * @return the successEnabled
	 */
	public boolean isSuccessEnabled() {
		return successEnabled;
	}

	/**
	 * @return the someBuiltEnabled
	 */
	public boolean isSomeBuiltEnabled() {
		return someBuiltEnabled;
	}

	/**
	 * @return the zeroBuiltEnabled
	 */
	public boolean isZeroBuiltEnabled() {
		return zeroBuiltEnabled;
	}

	/**
	 * @return the errorEnabled
	 */
	public boolean isErrorEnabled() {
		return errorEnabled;
	}

	/**
	 * @return the errorMsgOwned
	 */
	public boolean isErrorMsgOwned() {
		return errorMsgOwned;
	}

	/**
	 * @return the warningMsgOwned
	 */
	public boolean isWarningMsgOwned() {
		return warningMsgOwned;
	}

	/**
	 * @return the infoMsgOwned
	 */
	public boolean isInfoMsgOwned() {
		return infoMsgOwned;
	}

	/**
	 * @return the errEmailSuppress
	 */
	public boolean isErrEmailSuppress() {
		return errEmailSuppress;
	}

	/**
	 * @return the errMsgSuppress
	 */
	public boolean isErrMsgSuppress() {
		return errMsgSuppress;
	}

	/**
	 * @return the wrnMsgSuppress
	 */
	public boolean isWrnMsgSuppress() {
		return wrnMsgSuppress;
	}

	/**
	 * @return the infMsgSuppress
	 */
	public boolean isInfMsgSuppress() {
		return infMsgSuppress;
	}

	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	/**
	 * @param sqlSelect the sqlSelect to set
	 */
	public void setSqlSelect(String sqlSelect) {
		this.sqlSelect = sqlSelect;
	}

	/**
	 * @param rptSysDsn the rptSysDsn to set
	 */
	public void setRptSysDsn(String rptSysDsn) {
		this.rptSysDsn = rptSysDsn;
	}

	/**
	 * @param builtStatusMark the builtStatusMark to set
	 */
	public void setBuiltStatusMark(String builtStatusMark) {
		this.builtStatusMark = builtStatusMark;
	}

	/**
	 * @param dataReportDelimiter the dataReportDelimiter to set
	 */
	public void setDataReportDelimiter(String dataReportDelimiter) {
		this.dataReportDelimiter = dataReportDelimiter;
	}

	/**
	 * @param provTaxIDMark the provTaxIDMark to set
	 */
	public void setProvTaxIDMark(String provTaxIDMark) {
		this.provTaxIDMark = provTaxIDMark;
	}

	/**
	 * @param sub835EnrollmentMark the sub835EnrollmentMark to set
	 */
	public void setSub835EnrollmentMark(String sub835EnrollmentMark) {
		this.sub835EnrollmentMark = sub835EnrollmentMark;
	}

	/**
	 * @param sub835EnrollmentDataMark the sub835EnrollmentDataMark to set
	 */
	public void setSub835EnrollmentDataMark(String sub835EnrollmentDataMark) {
		this.sub835EnrollmentDataMark = sub835EnrollmentDataMark;
	}

	/**
	 * @param subInactiveMark the subInactiveMark to set
	 */
	public void setSubInactiveMark(String subInactiveMark) {
		this.subInactiveMark = subInactiveMark;
	}

	/**
	 * @param subCancelledMark the subCancelledMark to set
	 */
	public void setSubCancelledMark(String subCancelledMark) {
		this.subCancelledMark = subCancelledMark;
	}

	/**
	 * @param subCreditHoldMark the subCreditHoldMark to set
	 */
	public void setSubCreditHoldMark(String subCreditHoldMark) {
		this.subCreditHoldMark = subCreditHoldMark;
	}

	/**
	 * @param subClosedMark the subClosedMark to set
	 */
	public void setSubClosedMark(String subClosedMark) {
		this.subClosedMark = subClosedMark;
	}

	/**
	 * @param headerClaimAmtPaidMark the headerClaimAmtPaidMark to set
	 */
	public void setHeaderClaimAmtPaidMark(String headerClaimAmtPaidMark) {
		this.headerClaimAmtPaidMark = headerClaimAmtPaidMark;
	}

	/**
	 * @param webDescription the webDescription to set
	 */
	public void setWebDescription(String webDescription) {
		this.webDescription = webDescription;
	}

	/**
	 * @param outputPath the outputPath to set
	 */
	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	/**
	 * @param outputFileName the outputFileName to set
	 */
	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	/**
	 * @param outputFileExistsRule the outputFileExistsRule to set
	 */
	public void setOutputFileExistsRule(String outputFileExistsRule) {
		this.outputFileExistsRule = outputFileExistsRule;
	}

	/**
	 * @param incrementalChar the incrementalChar to set
	 */
	public void setIncrementalChar(String incrementalChar) {
		this.incrementalChar = incrementalChar;
	}

	/**
	 * @param fileErrorMark the fileErrorMark to set
	 */
	public void setFileErrorMark(String fileErrorMark) {
		this.fileErrorMark = fileErrorMark;
	}

	/**
	 * @param tempPath the tempPath to set
	 */
	public void setTempPath(String tempPath) {
		this.tempPath = tempPath;
	}

	/**
	 * @param successRecip the successRecip to set
	 */
	public void setSuccessRecip(String successRecip) {
		this.successRecip = successRecip;
	}

	/**
	 * @param successFromName the successFromName to set
	 */
	public void setSuccessFromName(String successFromName) {
		this.successFromName = successFromName;
	}

	/**
	 * @param successFromAddr the successFromAddr to set
	 */
	public void setSuccessFromAddr(String successFromAddr) {
		this.successFromAddr = successFromAddr;
	}

	/**
	 * @param someBuiltRecip the someBuiltRecip to set
	 */
	public void setSomeBuiltRecip(String someBuiltRecip) {
		this.someBuiltRecip = someBuiltRecip;
	}

	/**
	 * @param someBuiltFromName the someBuiltFromName to set
	 */
	public void setSomeBuiltFromName(String someBuiltFromName) {
		this.someBuiltFromName = someBuiltFromName;
	}

	/**
	 * @param someBuiltFromAddr the someBuiltFromAddr to set
	 */
	public void setSomeBuiltFromAddr(String someBuiltFromAddr) {
		this.someBuiltFromAddr = someBuiltFromAddr;
	}

	/**
	 * @param zeroBuiltRecip the zeroBuiltRecip to set
	 */
	public void setZeroBuiltRecip(String zeroBuiltRecip) {
		this.zeroBuiltRecip = zeroBuiltRecip;
	}

	/**
	 * @param zeroBuiltFromName the zeroBuiltFromName to set
	 */
	public void setZeroBuiltFromName(String zeroBuiltFromName) {
		this.zeroBuiltFromName = zeroBuiltFromName;
	}

	/**
	 * @param zeroBuiltFromAddr the zeroBuiltFromAddr to set
	 */
	public void setZeroBuiltFromAddr(String zeroBuiltFromAddr) {
		this.zeroBuiltFromAddr = zeroBuiltFromAddr;
	}

	/**
	 * @param errorRecip the errorRecip to set
	 */
	public void setErrorRecip(String errorRecip) {
		this.errorRecip = errorRecip;
	}

	/**
	 * @param errorFromName the errorFromName to set
	 */
	public void setErrorFromName(String errorFromName) {
		this.errorFromName = errorFromName;
	}

	/**
	 * @param errorFromAddr the errorFromAddr to set
	 */
	public void setErrorFromAddr(String errorFromAddr) {
		this.errorFromAddr = errorFromAddr;
	}

	/**
	 * @param errorShowModally the errorShowModally to set
	 */
	public void setErrorShowModally(String errorShowModally) {
		this.errorShowModally = errorShowModally;
	}

	/**
	 * @param warningShowModally the warningShowModally to set
	 */
	public void setWarningShowModally(String warningShowModally) {
		this.warningShowModally = warningShowModally;
	}

	/**
	 * @param infoShowModally the infoShowModally to set
	 */
	public void setInfoShowModally(String infoShowModally) {
		this.infoShowModally = infoShowModally;
	}

	/**
	 * @param appName the appName to set
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @param workstation the workstation to set
	 */
	public void setWorkstation(String workstation) {
		this.workstation = workstation;
	}

	/**
	 * @param recip the recip to set
	 */
	public void setRecip(String recip) {
		this.recip = recip;
	}

	/**
	 * @param fromName the fromName to set
	 */
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	/**
	 * @param fromAddr the fromAddr to set
	 */
	public void setFromAddr(String fromAddr) {
		this.fromAddr = fromAddr;
	}

	/**
	 * @param smtpHost the smtpHost to set
	 */
	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	/**
	 * @param smtpAlt the smtpAlt to set
	 */
	public void setSmtpAlt(String smtpAlt) {
		this.smtpAlt = smtpAlt;
	}

	/**
	 * @param msgKey the msgKey to set
	 */
	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}

	/**
	 * @param rptCreateDateTime the rptCreateDateTime to set
	 */
	public void setRptCreateDateTime(String rptCreateDateTime) {
		this.rptCreateDateTime = rptCreateDateTime;
	}

	/**
	 * @param rptRunDateTime the rptRunDateTime to set
	 */
	public void setRptRunDateTime(String rptRunDateTime) {
		this.rptRunDateTime = rptRunDateTime;
	}

	/**
	 * @param rptCnnTimeout the rptCnnTimeout to set
	 */
	public void setRptCnnTimeout(int rptCnnTimeout) {
		this.rptCnnTimeout = rptCnnTimeout;
	}

	/**
	 * @param rptCmdTimeout the rptCmdTimeout to set
	 */
	public void setRptCmdTimeout(int rptCmdTimeout) {
		this.rptCmdTimeout = rptCmdTimeout;
	}

	/**
	 * @param serialNoLookupCmdTimeout the serialNoLookupCmdTimeout to set
	 */
	public void setSerialNoLookupCmdTimeout(int serialNoLookupCmdTimeout) {
		this.serialNoLookupCmdTimeout = serialNoLookupCmdTimeout;
	}

	/**
	 * @param cnnTimeout the cnnTimeout to set
	 */
	public void setCnnTimeout(int cnnTimeout) {
		this.cnnTimeout = cnnTimeout;
	}

	/**
	 * @param cmdTimeout the cmdTimeout to set
	 */
	public void setCmdTimeout(int cmdTimeout) {
		this.cmdTimeout = cmdTimeout;
	}

	/**
	 * @param remitSelected the remitSelected to set
	 */
	public void setRemitSelected(int remitSelected) {
		this.remitSelected = remitSelected;
	}

	/**
	 * @param remitBuilt the remitBuilt to set
	 */
	public void setRemitBuilt(int remitBuilt) {
		this.remitBuilt = remitBuilt;
	}

	/**
	 * @param jobFound the jobFound to set
	 */
	public void setJobFound(boolean jobFound) {
		this.jobFound = jobFound;
	}

	/**
	 * @param isReport the isReport to set
	 */
	public void setReport(boolean isReport) {
		this.isReport = isReport;
	}

	/**
	 * @param isReportPost the isReportPost to set
	 */
	public void setReportPost(boolean isReportPost) {
		this.isReportPost = isReportPost;
	}

	/**
	 * @param jobEnabled the jobEnabled to set
	 */
	public void setJobEnabled(boolean jobEnabled) {
		this.jobEnabled = jobEnabled;
	}

	/**
	 * @param includeColumnHeadings the includeColumnHeadings to set
	 */
	public void setIncludeColumnHeadings(boolean includeColumnHeadings) {
		this.includeColumnHeadings = includeColumnHeadings;
	}

	/**
	 * @param serialNoLookup the serialNoLookup to set
	 */
	public void setSerialNoLookup(boolean serialNoLookup) {
		this.serialNoLookup = serialNoLookup;
	}

	/**
	 * @param provTaxIDRollBack the provTaxIDRollBack to set
	 */
	public void setProvTaxIDRollBack(boolean provTaxIDRollBack) {
		this.provTaxIDRollBack = provTaxIDRollBack;
	}

	/**
	 * @param sub835EnrollmentRollback the sub835EnrollmentRollback to set
	 */
	public void setSub835EnrollmentRollback(boolean sub835EnrollmentRollback) {
		this.sub835EnrollmentRollback = sub835EnrollmentRollback;
	}

	/**
	 * @param sub835EnrollmentDataRollback the sub835EnrollmentDataRollback to set
	 */
	public void setSub835EnrollmentDataRollback(boolean sub835EnrollmentDataRollback) {
		this.sub835EnrollmentDataRollback = sub835EnrollmentDataRollback;
	}

	/**
	 * @param postSubInactiveRpt the postSubInactiveRpt to set
	 */
	public void setPostSubInactiveRpt(boolean postSubInactiveRpt) {
		this.postSubInactiveRpt = postSubInactiveRpt;
	}

	/**
	 * @param postSubCancelledRpt the postSubCancelledRpt to set
	 */
	public void setPostSubCancelledRpt(boolean postSubCancelledRpt) {
		this.postSubCancelledRpt = postSubCancelledRpt;
	}

	/**
	 * @param postSubCreditHoldRpt the postSubCreditHoldRpt to set
	 */
	public void setPostSubCreditHoldRpt(boolean postSubCreditHoldRpt) {
		this.postSubCreditHoldRpt = postSubCreditHoldRpt;
	}

	/**
	 * @param postSubClosedRpt the postSubClosedRpt to set
	 */
	public void setPostSubClosedRpt(boolean postSubClosedRpt) {
		this.postSubClosedRpt = postSubClosedRpt;
	}

	/**
	 * @param verifyHeaderClaimAmtPaid the verifyHeaderClaimAmtPaid to set
	 */
	public void setVerifyHeaderClaimAmtPaid(boolean verifyHeaderClaimAmtPaid) {
		this.verifyHeaderClaimAmtPaid = verifyHeaderClaimAmtPaid;
	}

	/**
	 * @param headerClaimAmtPaidRollback the headerClaimAmtPaidRollback to set
	 */
	public void setHeaderClaimAmtPaidRollback(boolean headerClaimAmtPaidRollback) {
		this.headerClaimAmtPaidRollback = headerClaimAmtPaidRollback;
	}

	/**
	 * @param useLeadZero the useLeadZero to set
	 */
	public void setUseLeadZero(boolean useLeadZero) {
		this.useLeadZero = useLeadZero;
	}

	/**
	 * @param successEnabled the successEnabled to set
	 */
	public void setSuccessEnabled(boolean successEnabled) {
		this.successEnabled = successEnabled;
	}

	/**
	 * @param someBuiltEnabled the someBuiltEnabled to set
	 */
	public void setSomeBuiltEnabled(boolean someBuiltEnabled) {
		this.someBuiltEnabled = someBuiltEnabled;
	}

	/**
	 * @param zeroBuiltEnabled the zeroBuiltEnabled to set
	 */
	public void setZeroBuiltEnabled(boolean zeroBuiltEnabled) {
		this.zeroBuiltEnabled = zeroBuiltEnabled;
	}

	/**
	 * @param errorEnabled the errorEnabled to set
	 */
	public void setErrorEnabled(boolean errorEnabled) {
		this.errorEnabled = errorEnabled;
	}

	/**
	 * @param errorMsgOwned the errorMsgOwned to set
	 */
	public void setErrorMsgOwned(boolean errorMsgOwned) {
		this.errorMsgOwned = errorMsgOwned;
	}

	/**
	 * @param warningMsgOwned the warningMsgOwned to set
	 */
	public void setWarningMsgOwned(boolean warningMsgOwned) {
		this.warningMsgOwned = warningMsgOwned;
	}

	/**
	 * @param infoMsgOwned the infoMsgOwned to set
	 */
	public void setInfoMsgOwned(boolean infoMsgOwned) {
		this.infoMsgOwned = infoMsgOwned;
	}

	/**
	 * @param errEmailSuppress the errEmailSuppress to set
	 */
	public void setErrEmailSuppress(boolean errEmailSuppress) {
		this.errEmailSuppress = errEmailSuppress;
	}

	/**
	 * @param errMsgSuppress the errMsgSuppress to set
	 */
	public void setErrMsgSuppress(boolean errMsgSuppress) {
		this.errMsgSuppress = errMsgSuppress;
	}

	/**
	 * @param wrnMsgSuppress the wrnMsgSuppress to set
	 */
	public void setWrnMsgSuppress(boolean wrnMsgSuppress) {
		this.wrnMsgSuppress = wrnMsgSuppress;
	}

	/**
	 * @param infMsgSuppress the infMsgSuppress to set
	 */
	public void setInfMsgSuppress(boolean infMsgSuppress) {
		this.infMsgSuppress = infMsgSuppress;
	}
	
}

	
	

