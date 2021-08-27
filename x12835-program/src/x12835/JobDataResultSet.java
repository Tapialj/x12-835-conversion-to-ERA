package x12835;

public class JobDataResultSet
{
	
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
					fs1,
					fp1,
					fs2,
					fp2,
					fs3,
					fp3,
					fs4,
					fp4,
					fs5,
					fp5,
					fs6,
					fp6,
					fs7,
					fExt,
					outputFileExistsRule,
					incrementalChar,
					fileErrorMark,
					tempPath,
					tempFileName,
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
					recip,
					fromName,
					fromAddr,
					smtpHost,
					smtpAlt,
					rptCnnTimeout,
					rptCmdTimeout,
					serialNoLookupCmdTimeout,
					cnnTimeout,
					cmdTimeout,
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
					infoMsgOwned;

	/**
	 * 
	 * @param jobName
	 * @param jobType
	 * @param sqlSelect
	 * @param rptSysDsn
	 * @param builtStatusMark
	 * @param dataReportDelimiter
	 * @param provTaxIDMark
	 * @param sub835EnrollmentDataMark
	 * @param subInactiveMark
	 * @param subCancelledMark
	 * @param subCreditHoldMark
	 * @param subClosedMark
	 * @param headerClaimAmtPaidMark
	 * @param webDescription
	 * @param outputPath
	 * @param fs1
	 * @param fp1
	 * @param fs2
	 * @param fp2
	 * @param fs3
	 * @param fp3
	 * @param fs4
	 * @param fp4
	 * @param fs5
	 * @param fp5
	 * @param fs6
	 * @param fp6
	 * @param fs7
	 * @param fExt
	 * @param outputFileExistsRule
	 * @param incrementalChar
	 * @param fileErrorMark
	 * @param tempPath
	 * @param successRecip
	 * @param successFromName
	 * @param successFromAddr
	 * @param someBuiltRecip
	 * @param someBuiltFromName
	 * @param someBuiltFromAddr
	 * @param zeroBuiltRecip
	 * @param zeroBuiltFromName
	 * @param zeroBuiltFromAddr
	 * @param errorRecip
	 * @param errorFromName
	 * @param errorFromAddr
	 * @param errorShowModally
	 * @param warningShowModally
	 * @param infoShowModally
	 * @param recip
	 * @param fromName
	 * @param fromAddr
	 * @param smtpHost
	 * @param smtpAlt
	 * @param rptCnnTimeout
	 * @param rptCmdTimeout
	 * @param serialNoLookupCmdTimeout
	 * @param cnnTimeout
	 * @param cmdTimeout
	 * @param includeColumnHeadings
	 * @param serialNoLookup
	 * @param provTaxIDRollBack
	 * @param sub835EnrollmentRollback
	 * @param sub835EnrollmentDataRollback
	 * @param postSubInactiveRpt
	 * @param postSubCancelledRpt
	 * @param postSubCreditHoldRpt
	 * @param postSubClosedRpt
	 * @param verifyHeaderClaimAmtPaid
	 * @param headerClaimAmtPaidRollback
	 * @param useLeadZero
	 * @param successEnabled
	 * @param someBuiltEnabled
	 * @param zeroBuiltEnabled
	 * @param errorEnabled
	 * @param errorMsgOwned
	 * @param warningMsgOwned
	 * @param infoMsgOwned
	 */
	public JobDataResultSet(String jobName, String jobType, String sqlSelect, String rptSysDsn, String builtStatusMark,
			String dataReportDelimiter, String provTaxIDMark,String sub835EnrollmentMark, String sub835EnrollmentDataMark, String subInactiveMark,
			String subCancelledMark, String subCreditHoldMark, String subClosedMark, String headerClaimAmtPaidMark,
			String webDescription, String outputPath, String fs1, String fp1, String fs2, String fp2, String fs3, String fp3, String fs4,
			String fp4, String fs5, String fp5, String fs6, String fp6, String fs7, String fExt, String outputFileExistsRule,
			String incrementalChar, String fileErrorMark, String tempPath, String tempFileName, String successRecip, String successFromName,
			String successFromAddr, String someBuiltRecip, String someBuiltFromName, String someBuiltFromAddr,
			String zeroBuiltRecip, String zeroBuiltFromName, String zeroBuiltFromAddr, String errorRecip, String errorFromName,
			String errorFromAddr, String errorShowModally, String warningShowModally, String infoShowModally, String recip,
			String fromName, String fromAddr, String smtpHost, String smtpAlt, String rptCnnTimeout, String rptCmdTimeout,
			String serialNoLookupCmdTimeout, String cnnTimeout, String cmdTimeout,String jobEnabled, String includeColumnHeadings, 
			String serialNoLookup, String provTaxIDRollBack, String sub835EnrollmentRollback, String sub835EnrollmentDataRollback, 
			String postSubInactiveRpt, String postSubCancelledRpt, String postSubCreditHoldRpt, String postSubClosedRpt, 
			String verifyHeaderClaimAmtPaid, String headerClaimAmtPaidRollback, String useLeadZero, String successEnabled, String someBuiltEnabled,
			String zeroBuiltEnabled, String errorEnabled, String errorMsgOwned, String warningMsgOwned, String infoMsgOwned) 
	{
		this.jobName = jobName;
		this.jobType = jobType;
		this.sqlSelect = sqlSelect;
		this.rptSysDsn = rptSysDsn;
		this.builtStatusMark = builtStatusMark;
		this.dataReportDelimiter = dataReportDelimiter;
		this.provTaxIDMark = provTaxIDMark;
		this.sub835EnrollmentMark = sub835EnrollmentMark;
		this.sub835EnrollmentDataMark = sub835EnrollmentDataMark;
		this.subInactiveMark = subInactiveMark;
		this.subCancelledMark = subCancelledMark;
		this.subCreditHoldMark = subCreditHoldMark;
		this.subClosedMark = subClosedMark;
		this.headerClaimAmtPaidMark = headerClaimAmtPaidMark;
		this.webDescription = webDescription;
		this.outputPath = outputPath;
		this.fs1 = fs1;
		this.fp1 = fp1;
		this.fs2 = fs2;
		this.fp2 = fp2;
		this.fs3 = fs3;
		this.fp3 = fp3;
		this.fs4 = fs4;
		this.fp4 = fp4;
		this.fs5 = fs5;
		this.fp5 = fp5;
		this.fs6 = fs6;
		this.fp6 = fp6;
		this.fs7 = fs7;
		this.fExt = fExt;
		this.outputFileExistsRule = outputFileExistsRule;
		this.incrementalChar = incrementalChar;
		this.fileErrorMark = fileErrorMark;
		this.tempPath = tempPath;
		this.tempFileName = tempFileName;
		this.successRecip = successRecip;
		this.successFromName = successFromName;
		this.successFromAddr = successFromAddr;
		this.someBuiltRecip = someBuiltRecip;
		this.someBuiltFromName = someBuiltFromName;
		this.someBuiltFromAddr = someBuiltFromAddr;
		this.zeroBuiltRecip = zeroBuiltRecip;
		this.zeroBuiltFromName = zeroBuiltFromName;
		this.zeroBuiltFromAddr = zeroBuiltFromAddr;
		this.errorRecip = errorRecip;
		this.errorFromName = errorFromName;
		this.errorFromAddr = errorFromAddr;
		this.errorShowModally = errorShowModally;
		this.warningShowModally = warningShowModally;
		this.infoShowModally = infoShowModally;
		this.recip = recip;
		this.fromName = fromName;
		this.fromAddr = fromAddr;
		this.smtpHost = smtpHost;
		this.smtpAlt = smtpAlt;
		this.rptCnnTimeout = rptCnnTimeout;
		this.rptCmdTimeout = rptCmdTimeout;
		this.serialNoLookupCmdTimeout = serialNoLookupCmdTimeout;
		this.cnnTimeout = cnnTimeout;
		this.cmdTimeout = cmdTimeout;
		this.jobEnabled = jobEnabled;
		this.includeColumnHeadings = includeColumnHeadings;
		this.serialNoLookup = serialNoLookup;
		this.provTaxIDRollBack = provTaxIDRollBack;
		this.sub835EnrollmentRollback = sub835EnrollmentRollback;
		this.sub835EnrollmentDataRollback = sub835EnrollmentDataRollback;
		this.postSubInactiveRpt = postSubInactiveRpt;
		this.postSubCancelledRpt = postSubCancelledRpt;
		this.postSubCreditHoldRpt = postSubCreditHoldRpt;
		this.postSubClosedRpt = postSubClosedRpt;
		this.verifyHeaderClaimAmtPaid = verifyHeaderClaimAmtPaid;
		this.headerClaimAmtPaidRollback = headerClaimAmtPaidRollback;
		this.useLeadZero = useLeadZero;
		this.successEnabled = successEnabled;
		this.someBuiltEnabled = someBuiltEnabled;
		this.zeroBuiltEnabled = zeroBuiltEnabled;
		this.errorEnabled = errorEnabled;
		this.errorMsgOwned = errorMsgOwned;
		this.warningMsgOwned = warningMsgOwned;
		this.infoMsgOwned = infoMsgOwned;
	}

	/**
	 * @return the jobName
	 */
	public String getJobName() 
	{
		return jobName;
	}

	/**
	 * @return the jobType
	 */
	public String getJobType() 
	{
		return jobType;
	}

	/**
	 * @return the sqlSelect
	 */
	public String getSqlSelect() 
	{
		return sqlSelect;
	}

	/**
	 * @return the rptSysDsn
	 */
	public String getRptSysDsn() 
	{
		return rptSysDsn;
	}

	/**
	 * @return the builtStatusMark
	 */
	public String getBuiltStatusMark() 
	{
		return builtStatusMark;
	}

	/**
	 * @return the dataReportDelimiter
	 */
	public String getDataReportDelimiter() 
	{
		return dataReportDelimiter;
	}

	/**
	 * @return the provTaxIDMark
	 */
	public String getProvTaxIDMark() 
	{
		return provTaxIDMark;
	}

	/**
	 * @return the sub835EnrollmentMark
	 */
	public String getSub835EnrollmentMark() 
	{
		return sub835EnrollmentMark;
	}	
	
	/**
	 * @return the sub835EnrollmentDataMark
	 */
	public String getSub835EnrollmentDataMark() 
	{
		return sub835EnrollmentDataMark;
	}

	/**
	 * @return the subInactiveMark
	 */
	public String getSubInactiveMark() 
	{
		return subInactiveMark;
	}

	/**
	 * @return the subCancelledMark
	 */
	public String getSubCancelledMark() 
	{
		return subCancelledMark;
	}

	/**
	 * @return the subCreditHoldMark
	 */
	public String getSubCreditHoldMark() 
	{
		return subCreditHoldMark;
	}

	/**
	 * @return the subClosedMark
	 */
	public String getSubClosedMark() 
	{
		return subClosedMark;
	}

	/**
	 * @return the headerClaimAmtPaidMark
	 */
	public String getHeaderClaimAmtPaidMark() 
	{
		return headerClaimAmtPaidMark;
	}

	/**
	 * @return the webDescription
	 */
	public String getWebDescription() 
	{
		return webDescription;
	}

	/**
	 * @return the outputPath
	 */
	public String getOutputPath() 
	{
		return outputPath;
	}

	/**
	 * @return the fs1
	 */
	public String getFs1() 
	{
		return fs1;
	}

	/**
	 * @return the fp1
	 */
	public String getFp1() 
	{
		return fp1;
	}

	/**
	 * @return the fs2
	 */
	public String getFs2() 
	{
		return fs2;
	}

	/**
	 * @return the fp2
	 */
	public String getFp2() 
	{
		return fp2;
	}

	/**
	 * @return the fs3
	 */
	public String getFs3() 
	{
		return fs3;
	}

	/**
	 * @return the fp3
	 */
	public String getFp3() 
	{
		return fp3;
	}

	/**
	 * @return the fs4
	 */
	public String getFs4() 
	{
		return fs4;
	}

	/**
	 * @return the fp4
	 */
	public String getFp4() 
	{
		return fp4;
	}

	/**
	 * @return the fs5
	 */
	public String getFs5() 
	{
		return fs5;
	}

	/**
	 * @return the fp5
	 */
	public String getFp5() 
	{
		return fp5;
	}

	/**
	 * @return the fs6
	 */
	public String getFs6() 
	{
		return fs6;
	}

	/**
	 * @return the fp6
	 */
	public String getFp6() 
	{
		return fp6;
	}

	/**
	 * @return the fs7
	 */
	public String getFs7() 
	{
		return fs7;
	}

	/**
	 * @return the fExt
	 */
	public String getfExt() 
	{
		return fExt;
	}

	/**
	 * @return the outputFileExistsRule
	 */
	public String getOutputFileExistsRule() 
	{
		return outputFileExistsRule;
	}

	/**
	 * @return the incrementalChar
	 */
	public String getIncrementalChar() 
	{
		return incrementalChar;
	}

	/**
	 * @return the fileErrorMark
	 */
	public String getFileErrorMark() 
	{
		return fileErrorMark;
	}

	/**
	 * @return the tempPath
	 */
	public String getTempPath()
	{
		return tempPath;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTempFileName()
	{
		return tempFileName;
	}

	/**
	 * @return the successRecip
	 */
	public String getSuccessRecip() 
	{
		return successRecip;
	}

	/**
	 * @return the successFromName
	 */
	public String getSuccessFromName() 
	{
		return successFromName;
	}

	/**
	 * @return the successFromAddr
	 */
	public String getSuccessFromAddr() 
	{
		return successFromAddr;
	}

	/**
	 * @return the someBuiltRecip
	 */
	public String getSomeBuiltRecip()
	{
		return someBuiltRecip;
	}

	/**
	 * @return the someBuiltFromName
	 */
	public String getSomeBuiltFromName() 
	{
		return someBuiltFromName;
	}

	/**
	 * @return the someBuiltFromAddr
	 */
	public String getSomeBuiltFromAddr() 
	{
		return someBuiltFromAddr;
	}

	/**
	 * @return the zeroBuiltRecip
	 */
	public String getZeroBuiltRecip() 
	{
		return zeroBuiltRecip;
	}

	/**
	 * @return the zeroBuiltFromName
	 */
	public String getZeroBuiltFromName() 
	{
		return zeroBuiltFromName;
	}

	/**
	 * @return the zeroBuiltFromAddr
	 */
	public String getZeroBuiltFromAddr() 
	{
		return zeroBuiltFromAddr;
	}

	/**
	 * @return the errorRecip
	 */
	public String getErrorRecip() 
	{
		return errorRecip;
	}

	/**
	 * @return the errorFromName
	 */
	public String getErrorFromName() 
	{
		return errorFromName;
	}

	/**
	 * @return the errorFromAddr
	 */
	public String getErrorFromAddr() 
	{
		return errorFromAddr;
	}

	/**
	 * @return the errorShowModally
	 */
	public String getErrorShowModally() 
	{
		return errorShowModally;
	}

	/**
	 * @return the warningShowModally
	 */
	public String getWarningShowModally() 
	{
		return warningShowModally;
	}

	/**
	 * @return the infoShowModally
	 */
	public String getInfoShowModally() 
	{
		return infoShowModally;
	}

	/**
	 * @return the recip
	 */
	public String getRecip() 
	{
		return recip;
	}

	/**
	 * @return the fromName
	 */
	public String getFromName() 
	{
		return fromName;
	}

	/**
	 * @return the fromAddr
	 */
	public String getFromAddr()
	{
		return fromAddr;
	}

	/**
	 * @return the smtpHost
	 */
	public String getSmtpHost()
	{
		return smtpHost;
	}

	/**
	 * @return the smtpAlt
	 */
	public String getSmtpAlt()
	{
		return smtpAlt;
	}

	/**
	 * @return the rptCnnTimeout
	 */
	public String getRptCnnTimeout() 
	{
		return rptCnnTimeout;
	}

	/**
	 * @return the rptCmdTimeout
	 */
	public String getRptCmdTimeout()
	{
		return rptCmdTimeout;
	}

	/**
	 * @return the serialNoLookupCmdTimeout
	 */
	public String getSerialNoLookupCmdTimeout() 
	{
		return serialNoLookupCmdTimeout;
	}

	/**
	 * @return the cnnTimeout
	 */
	public String getCnnTimeout() 
	{
		return cnnTimeout;
	}

	/**
	 * @return the cmdTimeout
	 */
	public String getCmdTimeout() 
	{
		return cmdTimeout;
	}

	/**
	 * @return the jobEnabled
	 */
	public String getJobEnabled() 
	{
		return jobEnabled;
	}

	/**
	 * @return the includeColumnHeadings
	 */
	public String getIncludeColumnHeadings() 
	{
		return includeColumnHeadings;
	}

	/**
	 * @return the serialNoLookup
	 */
	public String getSerialNoLookup() 
	{
		return serialNoLookup;
	}

	/**
	 * @return the provTaxIDRollBack
	 */
	public String getProvTaxIDRollBack() 
	{
		return provTaxIDRollBack;
	}

	/**
	 * @return the sub835EnrollmentRollback
	 */
	public String getSub835EnrollmentRollback() 
	{
		return sub835EnrollmentRollback;
	}

	/**
	 * @return the sub835EnrollmentDataRollback
	 */
	public String getSub835EnrollmentDataRollback() 
	{
		return sub835EnrollmentDataRollback;
	}

	/**
	 * @return the postSubInactiveRpt
	 */
	public String getPostSubInactiveRpt() 
	{
		return postSubInactiveRpt;
	}

	/**
	 * @return the postSubCancelledRpt
	 */
	public String getPostSubCancelledRpt() 
	{
		return postSubCancelledRpt;
	}

	/**
	 * @return the postSubCreditHoldRpt
	 */
	public String getPostSubCreditHoldRpt() 
	{
		return postSubCreditHoldRpt;
	}

	/**
	 * @return the postSubClosedRpt
	 */
	public String getPostSubClosedRpt() 
	{
		return postSubClosedRpt;
	}

	/**
	 * @return the verifyHeaderClaimAmtPaid
	 */
	public String getVerifyHeaderClaimAmtPaid() 
	{
		return verifyHeaderClaimAmtPaid;
	}

	/**
	 * @return the headerClaimAmtPaidRollback
	 */
	public String getHeaderClaimAmtPaidRollback() 
	{
		return headerClaimAmtPaidRollback;
	}

	/**
	 * @return the useLeadZero
	 */
	public String getUseLeadZero() 
	{
		return useLeadZero;
	}

	/**
	 * @return the successEnabled
	 */
	public String getSuccessEnabled() 
	{
		return successEnabled;
	}

	/**
	 * @return the someBuiltEnabled
	 */
	public String getSomeBuiltEnabled() 
	{
		return someBuiltEnabled;
	}

	/**
	 * @return the zeroBuiltEnabled
	 */
	public String getZeroBuiltEnabled() 
	{
		return zeroBuiltEnabled;
	}

	/**
	 * @return the errorEnabled
	 */
	public String getErrorEnabled() 
	{
		return errorEnabled;
	}

	/**
	 * @return the errorMsgOwned
	 */
	public String getErrorMsgOwned() 
	{
		return errorMsgOwned;
	}

	/**
	 * @return the warningMsgOwned
	 */
	public String getWarningMsgOwned() 
	{
		return warningMsgOwned;
	}

	/**
	 * @return the infoMsgOwned
	 */
	public String getInfoMsgOwned()
	{
		return infoMsgOwned;
	}

	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName)
	{
		this.jobName = jobName;
	}

	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(String jobType) 
	{
		this.jobType = jobType;
	}

	/**
	 * @param sqlSelect the sqlSelect to set
	 */
	public void setSqlSelect(String sqlSelect) 
	{
		this.sqlSelect = sqlSelect;
	}

	/**
	 * @param rptSysDsn the rptSysDsn to set
	 */
	public void setRptSysDsn(String rptSysDsn) 
	{
		this.rptSysDsn = rptSysDsn;
	}

	/**
	 * @param builtStatusMark the builtStatusMark to set
	 */
	public void setBuiltStatusMark(String builtStatusMark) 
	{
		this.builtStatusMark = builtStatusMark;
	}

	/**
	 * @param dataReportDelimiter the dataReportDelimiter to set
	 */
	public void setDataReportDelimiter(String dataReportDelimiter) 
	{
		this.dataReportDelimiter = dataReportDelimiter;
	}

	/**
	 * @param provTaxIDMark the provTaxIDMark to set
	 */
	public void setProvTaxIDMark(String provTaxIDMark) 
	{
		this.provTaxIDMark = provTaxIDMark;
	}
	
	/**
	 * @param sub835EnrollmentMark the sub835EnrollmentMark to set
	 */
	public void setSub835EnrollmentMark(String sub835EnrollmentMark) 
	{
		this.sub835EnrollmentMark = sub835EnrollmentMark;
	}	

	/**
	 * @param sub835EnrollmentDataMark the sub835EnrollmentDataMark to set
	 */
	public void setSub835EnrollmentDataMark(String sub835EnrollmentDataMark) 
	{
		this.sub835EnrollmentDataMark = sub835EnrollmentDataMark;
	}

	/**
	 * @param subInactiveMark the subInactiveMark to set
	 */
	public void setSubInactiveMark(String subInactiveMark)
	{
		this.subInactiveMark = subInactiveMark;
	}

	/**
	 * @param subCancelledMark the subCancelledMark to set
	 */
	public void setSubCancelledMark(String subCancelledMark)
	{
		this.subCancelledMark = subCancelledMark;
	}

	/**
	 * @param subCreditHoldMark the subCreditHoldMark to set
	 */
	public void setSubCreditHoldMark(String subCreditHoldMark) 
	{
		this.subCreditHoldMark = subCreditHoldMark;
	}

	/**
	 * @param subClosedMark the subClosedMark to set
	 */
	public void setSubClosedMark(String subClosedMark)
	{
		this.subClosedMark = subClosedMark;
	}

	/**
	 * @param headerClaimAmtPaidMark the headerClaimAmtPaidMark to set
	 */
	public void setHeaderClaimAmtPaidMark(String headerClaimAmtPaidMark)
	{
		this.headerClaimAmtPaidMark = headerClaimAmtPaidMark;
	}

	/**
	 * @param webDescription the webDescription to set
	 */
	public void setWebDescription(String webDescription) 
	{
		this.webDescription = webDescription;
	}

	/**
	 * @param outputPath the outputPath to set
	 */
	public void setOutputPath(String outputPath) 
	{
		this.outputPath = outputPath;
	}

	/**
	 * @param fs1 the fs1 to set
	 */
	public void setFs1(String fs1) 
	{
		this.fs1 = fs1;
	}

	/**
	 * @param fp1 the fp1 to set
	 */
	public void setFp1(String fp1)
	{
		this.fp1 = fp1;
	}

	/**
	 * @param fs2 the fs2 to set
	 */
	public void setFs2(String fs2) 
	{
		this.fs2 = fs2;
	}

	/**
	 * @param fp2 the fp2 to set
	 */
	public void setFp2(String fp2)
	{
		this.fp2 = fp2;
	}

	/**
	 * @param fs3 the fs3 to set
	 */
	public void setFs3(String fs3) 
	{
		this.fs3 = fs3;
	}

	/**
	 * @param fp3 the fp3 to set
	 */
	public void setFp3(String fp3) 
	{
		this.fp3 = fp3;
	}

	/**
	 * @param fs4 the fs4 to set
	 */
	public void setFs4(String fs4)
	{
		this.fs4 = fs4;
	}

	/**
	 * @param fp4 the fp4 to set
	 */
	public void setFp4(String fp4)
	{
		this.fp4 = fp4;
	}

	/**
	 * @param fs5 the fs5 to set
	 */
	public void setFs5(String fs5) 
	{
		this.fs5 = fs5;
	}

	/**
	 * @param fp5 the fp5 to set
	 */
	public void setFp5(String fp5) 
	{
		this.fp5 = fp5;
	}

	/**
	 * @param fs6 the fs6 to set
	 */
	public void setFs6(String fs6) 
	{
		this.fs6 = fs6;
	}

	/**
	 * @param fp6 the fp6 to set
	 */
	public void setFp6(String fp6) 
	{
		this.fp6 = fp6;
	}

	/**
	 * @param fs7 the fs7 to set
	 */
	public void setFs7(String fs7) 
	{
		this.fs7 = fs7;
	}

	/**
	 * @param fExt the fExt to set
	 */
	public void setfExt(String fExt) 
	{
		this.fExt = fExt;
	}

	/**
	 * @param outputFileExistsRule the outputFileExistsRule to set
	 */
	public void setOutputFileExistsRule(String outputFileExistsRule) 
	{
		this.outputFileExistsRule = outputFileExistsRule;
	}

	/**
	 * @param incrementalChar the incrementalChar to set
	 */
	public void setIncrementalChar(String incrementalChar) 
	{
		this.incrementalChar = incrementalChar;
	}

	/**
	 * @param fileErrorMark the fileErrorMark to set
	 */
	public void setFileErrorMark(String fileErrorMark) 
	{
		this.fileErrorMark = fileErrorMark;
	}

	/**
	 * @param tempPath the tempPath to set
	 */
	public void setTempPath(String tempPath) 
	{
		this.tempPath = tempPath;
	}
	
	/**
	 * 
	 * @param tempFileName
	 */
	public void setTempFileName(String tempFileName)
	{
		this.tempFileName = tempFileName;
	}

	/**
	 * @param successRecip the successRecip to set
	 */
	public void setSuccessRecip(String successRecip) 
	{
		this.successRecip = successRecip;
	}

	/**
	 * @param successFromName the successFromName to set
	 */
	public void setSuccessFromName(String successFromName) 
	{
		this.successFromName = successFromName;
	}

	/**
	 * @param successFromAddr the successFromAddr to set
	 */
	public void setSuccessFromAddr(String successFromAddr) 
	{
		this.successFromAddr = successFromAddr;
	}

	/**
	 * @param someBuiltRecip the someBuiltRecip to set
	 */
	public void setSomeBuiltRecip(String someBuiltRecip) 
	{
		this.someBuiltRecip = someBuiltRecip;
	}

	/**
	 * @param someBuiltFromName the someBuiltFromName to set
	 */
	public void setSomeBuiltFromName(String someBuiltFromName) 
	{
		this.someBuiltFromName = someBuiltFromName;
	}

	/**
	 * @param someBuiltFromAddr the someBuiltFromAddr to set
	 */
	public void setSomeBuiltFromAddr(String someBuiltFromAddr)
	{
		this.someBuiltFromAddr = someBuiltFromAddr;
	}

	/**
	 * @param zeroBuiltRecip the zeroBuiltRecip to set
	 */
	public void setZeroBuiltRecip(String zeroBuiltRecip)
	{
		this.zeroBuiltRecip = zeroBuiltRecip;
	}

	/**
	 * @param zeroBuiltFromName the zeroBuiltFromName to set
	 */
	public void setZeroBuiltFromName(String zeroBuiltFromName) 
	{
		this.zeroBuiltFromName = zeroBuiltFromName;
	}

	/**
	 * @param zeroBuiltFromAddr the zeroBuiltFromAddr to set
	 */
	public void setZeroBuiltFromAddr(String zeroBuiltFromAddr) 
	{
		this.zeroBuiltFromAddr = zeroBuiltFromAddr;
	}

	/**
	 * @param errorRecip the errorRecip to set
	 */
	public void setErrorRecip(String errorRecip)
	{
		this.errorRecip = errorRecip;
	}

	/**
	 * @param errorFromName the errorFromName to set
	 */
	public void setErrorFromName(String errorFromName) 
	{
		this.errorFromName = errorFromName;
	}

	/**
	 * @param errorFromAddr the errorFromAddr to set
	 */
	public void setErrorFromAddr(String errorFromAddr)
	{
		this.errorFromAddr = errorFromAddr;
	}

	/**
	 * @param errorShowModally the errorShowModally to set
	 */
	public void setErrorShowModally(String errorShowModally)
	{
		this.errorShowModally = errorShowModally;
	}

	/**
	 * @param warningShowModally the warningShowModally to set
	 */
	public void setWarningShowModally(String warningShowModally) 
	{
		this.warningShowModally = warningShowModally;
	}

	/**
	 * @param infoShowModally the infoShowModally to set
	 */
	public void setInfoShowModally(String infoShowModally) 
	{
		this.infoShowModally = infoShowModally;
	}

	/**
	 * @param recip the recip to set
	 */
	public void setRecip(String recip)
	{
		this.recip = recip;
	}

	/**
	 * @param fromName the fromName to set
	 */
	public void setFromName(String fromName) 
	{
		this.fromName = fromName;
	}

	/**
	 * @param fromAddr the fromAddr to set
	 */
	public void setFromAddr(String fromAddr)
	{
		this.fromAddr = fromAddr;
	}

	/**
	 * @param smtpHost the smtpHost to set
	 */
	public void setSmtpHost(String smtpHost)
	{
		this.smtpHost = smtpHost;
	}

	/**
	 * @param smtpAlt the smtpAlt to set
	 */
	public void setSmtpAlt(String smtpAlt)
	{
		this.smtpAlt = smtpAlt;
	}

	/**
	 * @param rptCnnTimeout the rptCnnTimeout to set
	 */
	public void setRptCnnTimeout(String rptCnnTimeout) 
	{
		this.rptCnnTimeout = rptCnnTimeout;
	}

	/**
	 * @param rptCmdTimeout the rptCmdTimeout to set
	 */
	public void setRptCmdTimeout(String rptCmdTimeout) 
	{
		this.rptCmdTimeout = rptCmdTimeout;
	}

	/**
	 * @param serialNoLookupCmdTimeout the serialNoLookupCmdTimeout to set
	 */
	public void setSerialNoLookupCmdTimeout(String serialNoLookupCmdTimeout) 
	{
		this.serialNoLookupCmdTimeout = serialNoLookupCmdTimeout;
	}

	/**
	 * @param cnnTimeout the cnnTimeout to set
	 */
	public void setCnnTimeout(String cnnTimeout) 
	{
		this.cnnTimeout = cnnTimeout;
	}

	/**
	 * @param cmdTimeout the cmdTimeout to set
	 */
	public void setCmdTimeout(String cmdTimeout)
	{
		this.cmdTimeout = cmdTimeout;
	}

	/**
	 * @param jobEnabled the jobEnabled to set
	 */
	public void setJobEnabled(String jobEnabled) 
	{
		this.jobEnabled = jobEnabled;
	}

	/**
	 * @param includeColumnHeadings the includeColumnHeadings to set
	 */
	public void setIncludeColumnHeadings(String includeColumnHeadings) 
	{
		this.includeColumnHeadings = includeColumnHeadings;
	}

	/**
	 * @param serialNoLookup the serialNoLookup to set
	 */
	public void setSerialNoLookup(String serialNoLookup)
	{
		this.serialNoLookup = serialNoLookup;
	}

	/**
	 * @param provTaxIDRollBack the provTaxIDRollBack to set
	 */
	public void setProvTaxIDRollBack(String provTaxIDRollBack) 
	{
		this.provTaxIDRollBack = provTaxIDRollBack;
	}

	/**
	 * @param sub835EnrollmentRollback the sub835EnrollmentRollback to set
	 */
	public void setSub835EnrollmentRollback(String sub835EnrollmentRollback) 
	{
		this.sub835EnrollmentRollback = sub835EnrollmentRollback;
	}

	/**
	 * @param sub835EnrollmentDataRollback the sub835EnrollmentDataRollback to set
	 */
	public void setSub835EnrollmentDataRollback(String sub835EnrollmentDataRollback) 
	{
		this.sub835EnrollmentDataRollback = sub835EnrollmentDataRollback;
	}

	/**
	 * @param postSubInactiveRpt the postSubInactiveRpt to set
	 */
	public void setPostSubInactiveRpt(String postSubInactiveRpt) 
	{
		this.postSubInactiveRpt = postSubInactiveRpt;
	}

	/**
	 * @param postSubCancelledRpt the postSubCancelledRpt to set
	 */
	public void setPostSubCancelledRpt(String postSubCancelledRpt) 
	{
		this.postSubCancelledRpt = postSubCancelledRpt;
	}

	/**
	 * @param postSubCreditHoldRpt the postSubCreditHoldRpt to set
	 */
	public void setPostSubCreditHoldRpt(String postSubCreditHoldRpt) 
	{
		this.postSubCreditHoldRpt = postSubCreditHoldRpt;
	}

	/**
	 * @param postSubClosedRpt the postSubClosedRpt to set
	 */
	public void setPostSubClosedRpt(String postSubClosedRpt) 
	{
		this.postSubClosedRpt = postSubClosedRpt;
	}

	/**
	 * @param verifyHeaderClaimAmtPaid the verifyHeaderClaimAmtPaid to set
	 */
	public void setVerifyHeaderClaimAmtPaid(String verifyHeaderClaimAmtPaid) 
	{
		this.verifyHeaderClaimAmtPaid = verifyHeaderClaimAmtPaid;
	}

	/**
	 * @param headerClaimAmtPaidRollback the headerClaimAmtPaidRollback to set
	 */
	public void setHeaderClaimAmtPaidRollback(String headerClaimAmtPaidRollback) 
	{
		this.headerClaimAmtPaidRollback = headerClaimAmtPaidRollback;
	}

	/**
	 * @param useLeadZero the useLeadZero to set
	 */
	public void setUseLeadZero(String useLeadZero)
	{
		this.useLeadZero = useLeadZero;
	}

	/**
	 * @param successEnabled the successEnabled to set
	 */
	public void setSuccessEnabled(String successEnabled)
	{
		this.successEnabled = successEnabled;
	}

	/**
	 * @param someBuiltEnabled the someBuiltEnabled to set
	 */
	public void setSomeBuiltEnabled(String someBuiltEnabled)
	{
		this.someBuiltEnabled = someBuiltEnabled;
	}

	/**
	 * @param zeroBuiltEnabled the zeroBuiltEnabled to set
	 */
	public void setZeroBuiltEnabled(String zeroBuiltEnabled) 
	{
		this.zeroBuiltEnabled = zeroBuiltEnabled;
	}

	/**
	 * @param errorEnabled the errorEnabled to set
	 */
	public void setErrorEnabled(String errorEnabled)
	{
		this.errorEnabled = errorEnabled;
	}

	/**
	 * @param errorMsgOwned the errorMsgOwned to set
	 */
	public void setErrorMsgOwned(String errorMsgOwned) 
	{
		this.errorMsgOwned = errorMsgOwned;
	}

	/**
	 * @param warningMsgOwned the warningMsgOwned to set
	 */
	public void setWarningMsgOwned(String warningMsgOwned) 
	{
		this.warningMsgOwned = warningMsgOwned;
	}

	/**
	 * @param infoMsgOwned the infoMsgOwned to set
	 */
	public void setInfoMsgOwned(String infoMsgOwned) 
	{
		this.infoMsgOwned = infoMsgOwned;
	}	
	
}
