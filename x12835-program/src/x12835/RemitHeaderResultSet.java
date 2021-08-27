package x12835;

public class RemitHeaderResultSet
{

	private String	headerID,
					remitUpdInd, //Never filled in, may just omit
					transControlNoST02,
					transHandlingCodeBPR01,
					totalPmtAmtBPR02,
					creditDebitFlagBPR03,
					pmtMethodCodeBPR04,
					sendAbaNoBPR07,
					sendBankAcctNoBPR09,
					payerIdentifierBPR10, //in database as BRP10
					receiverAbaNoBPR13,
					recBankAcctNoBPR15,
					pmtIssueDateBPR16,
					traceNoTRN02,
					payerIdentifierTRN03,
					productionDateDTTM02,
					payerNameN102,
					payerAddress1N301,
					payerAddress2N302,
					payerCityN401,
					payerStateN402,
					payerZipN403,
					payerRefQualifierREF01, //Never filled in, may just omit
					payerIDREF02, //Never filled in may just omit
					payerConNamePER02,
					payerComNoQualPER03,
					payerComNoPER04,
					payerComNoQualPER05,
					payerComNoPER06,
					payeeNameN102,
					payeeIDQualifierN103,
					payeeIDCodeN104,
					payeeAddress1N301,
					payeeAddress2N302,
					payeeCityN401,
					payeeStateN402,
					payeeZipN403,
					payeeAddIDQualREF01, //Never Filled in, may just omit
					payeeAddIDCodeREF02, //Never Filled in, may just omit,
					remitHeaderTimestamp,
					dateTimeTranslated,
					eobReportStatus,
					eobReportErrorNum,
					eobReportErrorReason,
					eobReportErrorSource,
					eobSubAcctNo,
					eobReportCreateDateTime,
					eobReportRunDateTime;
	boolean			hasProvAdj;

	/**
	 * @param headerID
	 * @param remitUpdInd
	 * @param transControlNoST02
	 * @param transHandlingCodeBPR01
	 * @param totalPmtAmtBPR02
	 * @param creditDebitFlagBPR03
	 * @param pmtMethodCodeBPR04
	 * @param sendAbaNoBPR07
	 * @param sendBankAcctNoBPR09
	 * @param payerIdentifierBPR10
	 * @param receiverAbaNoBPR13
	 * @param recBankAcctNoBPR15
	 * @param pmtIssueDateBPR16
	 * @param traceNoTRN02
	 * @param payerIdentifierTRN03
	 * @param productionDateDTTM02
	 * @param payerNameN102
	 * @param payerAddress1N301
	 * @param payerAddress2N302
	 * @param payerCityN401
	 * @param payerStateN402
	 * @param payerZipN403
	 * @param payerRefQualifierREF01
	 * @param payerIDREF02
	 * @param payerConNamePER02
	 * @param payerComNoQualPER03
	 * @param payerComNoPER04
	 * @param payerComNoQualPER05
	 * @param payerComNoPER06
	 * @param payeeNameN102
	 * @param payeeIDQualifierN103
	 * @param payeeIDCodeN104
	 * @param payeeAddress1N301
	 * @param payeeAddress2N302
	 * @param payeeCityN401
	 * @param payeeStateN402
	 * @param payeeZipN403
	 * @param payeeAddIDQualREF01
	 * @param payeeAddIDCodeREF02
	 * @param remitHeaderTimestamp
	 * @param dateTimeTranslated
	 * @param eobReportStatus
	 * @param eobReportErrorNum
	 * @param eobReportErrorReason
	 * @param eobReportErrorSource
	 * @param eobSubAcctNo
	 * @param eobReportCreateDateTime
	 * @param eobReportRunDateTime
	 */
	public RemitHeaderResultSet(String headerID, String remitUpdInd, String transControlNoST02, String transHandlingCodeBPR01, String totalPmtAmtBPR02,
			String creditDebitFlagBPR03, String pmtMethodCodeBPR04, String sendAbaNoBPR07, String sendBankAcctNoBPR09, String payerIdentifierBPR10,
			String receiverAbaNoBPR13, String recBankAcctNoBPR15, String pmtIssueDateBPR16, String traceNoTRN02, String payerIdentifierTRN03, String productionDateDTTM02,
			String payerNameN102, String payerAddress1N301, String payerAddress2N302, String payerCityN401, String payerStateN402, String payerZipN403,
			String payerRefQualifierREF01, String payerIDREF02, String payerConNamePER02, String payerComNoQualPER03, String payerComNoPER04, String payerComNoQualPER05,
			String payerComNoPER06, String payeeNameN102, String payeeIDQualifierN103, String payeeIDCodeN104, String payeeAddress1N301, String payeeAddress2N302,
			String payeeCityN401, String payeeStateN402, String payeeZipN403, String payeeAddIDQualREF01, String payeeAddIDCodeREF02, String remitHeaderTimestamp,
			String dateTimeTranslated, String eobReportStatus, String eobReportErrorNum, String eobReportErrorReason, String eobReportErrorSource, String eobSubAcctNo, 
			String eobReportCreateDateTime,	String eobReportRunDateTime, boolean hasProvAdj)
	{
		this.headerID = headerID;
		this.remitUpdInd = remitUpdInd;
		this.transControlNoST02 = transControlNoST02;
		this.transHandlingCodeBPR01 = transHandlingCodeBPR01;
		this.totalPmtAmtBPR02 = totalPmtAmtBPR02;
		this.creditDebitFlagBPR03 = creditDebitFlagBPR03;
		this.pmtMethodCodeBPR04 = pmtMethodCodeBPR04;
		this.sendAbaNoBPR07 = sendAbaNoBPR07;
		this.sendBankAcctNoBPR09 = sendBankAcctNoBPR09;
		this.payerIdentifierBPR10 = payerIdentifierBPR10;
		this.receiverAbaNoBPR13 = receiverAbaNoBPR13;
		this.recBankAcctNoBPR15 = recBankAcctNoBPR15;
		this.pmtIssueDateBPR16 = pmtIssueDateBPR16;
		this.traceNoTRN02 = traceNoTRN02;
		this.payerIdentifierTRN03 = payerIdentifierTRN03;
		this.productionDateDTTM02 = productionDateDTTM02;
		this.payerNameN102 = payerNameN102;
		this.payerAddress1N301 = payerAddress1N301;
		this.payerAddress2N302 = payerAddress2N302;
		this.payerCityN401 = payerCityN401;
		this.payerStateN402 = payerStateN402;
		this.payerZipN403 = payerZipN403;
		this.payerRefQualifierREF01 = payerRefQualifierREF01;
		this.payerIDREF02 = payerIDREF02;
		this.payerConNamePER02 = payerConNamePER02;
		this.payerComNoQualPER03 = payerComNoQualPER03;
		this.payerComNoPER04 = payerComNoPER04;
		this.payerComNoQualPER05 = payerComNoQualPER05;
		this.payerComNoPER06 = payerComNoPER06;
		this.payeeNameN102 = payeeNameN102;
		this.payeeIDQualifierN103 = payeeIDQualifierN103;
		this.payeeIDCodeN104 = payeeIDCodeN104;
		this.payeeAddress1N301 = payeeAddress1N301;
		this.payeeAddress2N302 = payeeAddress2N302;
		this.payeeCityN401 = payeeCityN401;
		this.payeeStateN402 = payeeStateN402;
		this.payeeZipN403 = payeeZipN403;
		this.payeeAddIDQualREF01 = payeeAddIDQualREF01;
		this.payeeAddIDCodeREF02 = payeeAddIDCodeREF02;
		this.remitHeaderTimestamp = remitHeaderTimestamp;
		this.dateTimeTranslated = dateTimeTranslated;
		this.eobReportStatus = eobReportStatus;
		this.eobReportErrorNum = eobReportErrorNum;
		this.eobReportErrorReason = eobReportErrorReason;
		this.eobReportErrorSource = eobReportErrorSource;
		this.eobSubAcctNo = eobSubAcctNo;
		this.eobReportCreateDateTime = eobReportCreateDateTime;
		this.eobReportRunDateTime = eobReportRunDateTime;
		this.hasProvAdj = hasProvAdj;
	}

	/**
	 * @return the headerID
	 */
	public String getHeaderID() 
	{
		return headerID;
	}

	/**
	 * @return the remitUpdInd
	 */
	public String getRemitUpdInd() 
	{
		return remitUpdInd;
	}

	/**
	 * @return the transControlNoST02
	 */
	public String getTransControlNoST02() 
	{
		
		return transControlNoST02;
	}

	/**
	 * @return the transHandlingCodeBPR01
	 */
	public String getTransHandlingCodeBPR01() 
	{
		return transHandlingCodeBPR01;
	}

	/**
	 * @return the totalPmtAmtBPR02
	 */
	public String getTotalPmtAmtBPR02() 
	{
		return totalPmtAmtBPR02;
	}

	/**
	 * @return the creditDebitFlagBPR03
	 */
	public String getCreditDebitFlagBPR03() 
	{
		return creditDebitFlagBPR03;
	}

	/**
	 * @return the pmtMethodCodeBPR04
	 */
	public String getPmtMethodCodeBPR04()
	{
		return pmtMethodCodeBPR04;
	}

	/**
	 * @return the sendAbaNoBPR07
	 */
	public String getSendAbaNoBPR07() 
	{
		return sendAbaNoBPR07;
	}

	/**
	 * @return the sendBankAcctNoBPR09
	 */
	public String getSendBankAcctNoBPR09() 
	{
		return sendBankAcctNoBPR09;
	}

	/**
	 * @return the payerIdentifierBPR10
	 */
	public String getPayerIdentifierBPR10() 
	{
		return payerIdentifierBPR10;
	}

	/**
	 * @return the receiverAbaNoBPR13
	 */
	public String getReceiverAbaNoBPR13()
	{
		return receiverAbaNoBPR13;
	}

	/**
	 * @return the recBankAcctNoBPR15
	 */
	public String getRecBankAcctNoBPR15() 
	{
		return recBankAcctNoBPR15;
	}

	/**
	 * @return the pmtIssueDateBPR16
	 */
	public String getPmtIssueDateBPR16() 
	{
		return pmtIssueDateBPR16;
	}

	/**
	 * @return the traceNoTRN02
	 */
	public String getTraceNoTRN02() 
	{
		return traceNoTRN02;
	}

	/**
	 * @return the payerIdentifierTRN03
	 */
	public String getPayerIdentifierTRN03()
	{
		return payerIdentifierTRN03;
	}

	/**
	 * @return the productionDateDTTM02
	 */
	public String getProductionDateDTTM02()
	{
		return productionDateDTTM02;
	}

	/**
	 * @return the payerNameN102
	 */
	public String getPayerNameN102()
	{
		return payerNameN102;
	}

	/**
	 * @return the payerAddress1N301
	 */
	public String getPayerAddress1N301() 
	{
		return payerAddress1N301;
	}

	/**
	 * @return the payerAddress2N302
	 */
	public String getPayerAddress2N302() 
	{
		return payerAddress2N302;
	}

	/**
	 * @return the payerCityN401
	 */
	public String getPayerCityN401() 
	{
		return payerCityN401;
	}

	/**
	 * @return the payerStateN402
	 */
	public String getPayerStateN402() 
	{
		return payerStateN402;
	}

	/**
	 * @return the payerZipN403
	 */
	public String getPayerZipN403()
	{
		return payerZipN403;
	}

	/**
	 * @return the payerRefQualifierREF01
	 */
	public String getPayerRefQualifierREF01() 
	{
		return payerRefQualifierREF01;
	}

	/**
	 * @return the payerIDREF02
	 */
	public String getPayerIDREF02() 
	{
		return payerIDREF02;
	}

	/**
	 * @return the payerConNamePER02
	 */
	public String getPayerConNamePER02() 
	{
		return payerConNamePER02;
	}

	/**
	 * @return the payerComNoQualPER03
	 */
	public String getPayerComNoQualPER03() 
	{
		return payerComNoQualPER03;
	}

	/**
	 * @return the payerComNoPER04
	 */
	public String getPayerComNoPER04() 
	{
		return payerComNoPER04;
	}

	/**
	 * @return the payerComNoQualPER05
	 */
	public String getPayerComNoQualPER05() 
	{
		return payerComNoQualPER05;
	}

	/**
	 * @return the payerComNoPER06
	 */
	public String getPayerComNoPER06() 
	{
		return payerComNoPER06;
	}

	/**
	 * @return the payeeNameN102
	 */
	public String getPayeeNameN102() 
	{
		return payeeNameN102;
	}

	/**
	 * @return the payeeIDQualifierN103
	 */
	public String getPayeeIDQualifierN103() 
	{
		return payeeIDQualifierN103;
	}

	/**
	 * @return the payeeIDCodeN104
	 */
	public String getPayeeIDCodeN104() 
	{
		return payeeIDCodeN104;
	}

	/**
	 * @return the payeeAddress1N301
	 */
	public String getPayeeAddress1N301() 
	{
		return payeeAddress1N301;
	}

	/**
	 * @return the payeeAddress2N302
	 */
	public String getPayeeAddress2N302() 
	{
		return payeeAddress2N302;
	}

	/**
	 * @return the payeeCityN401
	 */
	public String getPayeeCityN401() 
	{
		return payeeCityN401;
	}

	/**
	 * @return the payeeStateN402
	 */
	public String getPayeeStateN402() 
	{
		return payeeStateN402;
	}

	/**
	 * @return the payeeZipN403
	 */
	public String getPayeeZipN403() 
	{
		return payeeZipN403;
	}

	/**
	 * @return the payeeAddIDQualREF01
	 */
	public String getPayeeAddIDQualREF01() 
	{
		return payeeAddIDQualREF01;
	}

	/**
	 * @return the payeeAddIDCodeREF02
	 */
	public String getPayeeAddIDCodeREF02() 
	{
		return payeeAddIDCodeREF02;
	}

	/**
	 * @return the remitHeaderTimestamp
	 */
	public String getRemitHeaderTimestamp() 
	{
		return remitHeaderTimestamp;
	}

	/**
	 * @return the dateTimeTranslated
	 */
	public String getDateTimeTranslated() 
	{
		return dateTimeTranslated;
	}

	/**
	 * @return the eobReportStatus
	 */
	public String getEobReportStatus() 
	{
		return eobReportStatus;
	}

	/**
	 * @return the eobReportErrorNum
	 */
	public String getEobReportErrorNum() 
	{
		return eobReportErrorNum;
	}

	/**
	 * @return the eobReportErrorReason
	 */
	public String getEobReportErrorReason() 
	{
		return eobReportErrorReason;
	}

	/**
	 * @return the eobReportErrorSource
	 */
	public String getEobReportErrorSource() 
	{
		return eobReportErrorSource;
	}

	/**
	 * @return the eobSubAcctNo
	 */
	public String getEobSubAcctNo() 
	{
		return eobSubAcctNo;
	}

	/**
	 * @return the eobReportCreateDateTime
	 */
	public String getEobReportCreateDateTime() 
	{
		return eobReportCreateDateTime;
	}

	/**
	 * @return the eobReportRunDateTime
	 */
	public String getEobReportRunDateTime() 
	{
		return eobReportRunDateTime;
	}
	
	/**
	 * @return the hasProvAdj
	 */
	public boolean isHasProvAdj() 
	{
		return hasProvAdj;
	}

	/**
	 * @param headerID the headerID to set
	 */
	public void setHeaderID(String headerID) 
	{
		this.headerID = headerID;
	}

	/**
	 * @param remitUpdInd the remitUpdInd to set
	 */
	public void setRemitUpdInd(String remitUpdInd) 
	{
		this.remitUpdInd = remitUpdInd;
	}

	/**
	 * @param transControlNoST02 the transControlNoST02 to set
	 */
	public void setTransControlNoST02(String transControlNoST02) 
	{
		this.transControlNoST02 = transControlNoST02;
	}

	/**
	 * @param transHandlingCodeBPR01 the transHandlingCodeBPR01 to set
	 */
	public void setTransHandlingCodeBPR01(String transHandlingCodeBPR01)
	{
		this.transHandlingCodeBPR01 = transHandlingCodeBPR01;
	}

	/**
	 * @param totalPmtAmtBPR02 the totalPmtAmtBPR02 to set
	 */
	public void setTotalPmtAmtBPR02(String totalPmtAmtBPR02) 
	{
		this.totalPmtAmtBPR02 = totalPmtAmtBPR02;
	}

	/**
	 * @param creditDebitFlagBPR03 the creditDebitFlagBPR03 to set
	 */
	public void setCreditDebitFlagBPR03(String creditDebitFlagBPR03)
	{
		this.creditDebitFlagBPR03 = creditDebitFlagBPR03;
	}

	/**
	 * @param pmtMethodCodeBPR04 the pmtMethodCodeBPR04 to set
	 */
	public void setPmtMethodCodeBPR04(String pmtMethodCodeBPR04) 
	{
		this.pmtMethodCodeBPR04 = pmtMethodCodeBPR04;
	}

	/**
	 * @param sendAbaNoBPR07 the sendAbaNoBPR07 to set
	 */
	public void setSendAbaNoBPR07(String sendAbaNoBPR07) 
	{
		this.sendAbaNoBPR07 = sendAbaNoBPR07;
	}

	/**
	 * @param sendBankAcctNoBPR09 the sendBankAcctNoBPR09 to set
	 */
	public void setSendBankAcctNoBPR09(String sendBankAcctNoBPR09) 
	{
		this.sendBankAcctNoBPR09 = sendBankAcctNoBPR09;
	}

	/**
	 * @param payerIdentifierBPR10 the payerIdentifierBPR10 to set
	 */
	public void setPayerIdentifierBPR10(String payerIdentifierBPR10)
	{
		this.payerIdentifierBPR10 = payerIdentifierBPR10;
	}

	/**
	 * @param receiverAbaNoBPR13 the receiverAbaNoBPR13 to set
	 */
	public void setReceiverAbaNoBPR13(String receiverAbaNoBPR13)
	{
		this.receiverAbaNoBPR13 = receiverAbaNoBPR13;
	}

	/**
	 * @param recBankAcctNoBPR15 the recBankAcctNoBPR15 to set
	 */
	public void setRecBankAcctNoBPR15(String recBankAcctNoBPR15) 
	{
		this.recBankAcctNoBPR15 = recBankAcctNoBPR15;
	}

	/**
	 * @param pmtIssueDateBPR16 the pmtIssueDateBPR16 to set
	 */
	public void setPmtIssueDateBPR16(String pmtIssueDateBPR16) 
	{
		this.pmtIssueDateBPR16 = pmtIssueDateBPR16;
	}

	/**
	 * @param traceNoTRN02 the traceNoTRN02 to set
	 */
	public void setTraceNoTRN02(String traceNoTRN02)
	{
		this.traceNoTRN02 = traceNoTRN02;
	}

	/**
	 * @param payerIdentifierTRN03 the payerIdentifierTRN03 to set
	 */
	public void setPayerIdentifierTRN03(String payerIdentifierTRN03) 
	{
		this.payerIdentifierTRN03 = payerIdentifierTRN03;
	}

	/**
	 * @param productionDateDTTM02 the productionDateDTTM02 to set
	 */
	public void setProductionDateDTTM02(String productionDateDTTM02)
	{
		this.productionDateDTTM02 = productionDateDTTM02;
	}

	/**
	 * @param payerNameN102 the payerNameN102 to set
	 */
	public void setPayerNameN102(String payerNameN102) 
	{
		this.payerNameN102 = payerNameN102;
	}

	/**
	 * @param payerAddress1N301 the payerAddress1N301 to set
	 */
	public void setPayerAddress1N301(String payerAddress1N301)
	{
		this.payerAddress1N301 = payerAddress1N301;
	}

	/**
	 * @param payerAddress2N302 the payerAddress2N302 to set
	 */
	public void setPayerAddress2N302(String payerAddress2N302) 
	{
		this.payerAddress2N302 = payerAddress2N302;
	}

	/**
	 * @param payerCityN401 the payerCityN401 to set
	 */
	public void setPayerCityN401(String payerCityN401) 
	{
		this.payerCityN401 = payerCityN401;
	}

	/**
	 * @param payerStateN402 the payerStateN402 to set
	 */
	public void setPayerStateN402(String payerStateN402)
	{
		this.payerStateN402 = payerStateN402;
	}

	/**
	 * @param payerZipN403 the payerZipN403 to set
	 */
	public void setPayerZipN403(String payerZipN403)
	{
		this.payerZipN403 = payerZipN403;
	}

	/**
	 * @param payerRefQualifierREF01 the payerRefQualifierREF01 to set
	 */
	public void setPayerRefQualifierREF01(String payerRefQualifierREF01)
	{
		this.payerRefQualifierREF01 = payerRefQualifierREF01;
	}

	/**
	 * @param payerIDREF02 the payerIDREF02 to set
	 */
	public void setPayerIDREF02(String payerIDREF02)
	{
		this.payerIDREF02 = payerIDREF02;
	}

	/**
	 * @param payerConNamePER02 the payerConNamePER02 to set
	 */
	public void setPayerConNamePER02(String payerConNamePER02) 
	{
		this.payerConNamePER02 = payerConNamePER02;
	}

	/**
	 * @param payerComNoQualPER03 the payerComNoQualPER03 to set
	 */
	public void setPayerComNoQualPER03(String payerComNoQualPER03) 
	{
		this.payerComNoQualPER03 = payerComNoQualPER03;
	}

	/**
	 * @param payerComNoPER04 the payerComNoPER04 to set
	 */
	public void setPayerComNoPER04(String payerComNoPER04) 
	{
		this.payerComNoPER04 = payerComNoPER04;
	}

	/**
	 * @param payerComNoQualPER05 the payerComNoQualPER05 to set
	 */
	public void setPayerComNoQualPER05(String payerComNoQualPER05) 
	{
		this.payerComNoQualPER05 = payerComNoQualPER05;
	}

	/**
	 * @param payerComNoPER06 the payerComNoPER06 to set
	 */
	public void setPayerComNoPER06(String payerComNoPER06) 
	{
		this.payerComNoPER06 = payerComNoPER06;
	}

	/**
	 * @param payeeNameN102 the payeeNameN102 to set
	 */
	public void setPayeeNameN102(String payeeNameN102) 
	{
		this.payeeNameN102 = payeeNameN102;
	}

	/**
	 * @param payeeIDQualifierN103 the payeeIDQualifierN103 to set
	 */
	public void setPayeeIDQualifierN103(String payeeIDQualifierN103)
	{
		this.payeeIDQualifierN103 = payeeIDQualifierN103;
	}

	/**
	 * @param payeeIDCodeN104 the payeeIDCodeN104 to set
	 */
	public void setPayeeIDCodeN104(String payeeIDCodeN104) 
	{
		this.payeeIDCodeN104 = payeeIDCodeN104;
	}

	/**
	 * @param payeeAddress1N301 the payeeAddress1N301 to set
	 */
	public void setPayeeAddress1N301(String payeeAddress1N301)
	{
		this.payeeAddress1N301 = payeeAddress1N301;
	}

	/**
	 * @param payeeAddress2N302 the payeeAddress2N302 to set
	 */
	public void setPayeeAddress2N302(String payeeAddress2N302) 
	{
		this.payeeAddress2N302 = payeeAddress2N302;
	}

	/**
	 * @param payeeCityN401 the payeeCityN401 to set
	 */
	public void setPayeeCityN401(String payeeCityN401) 
	{
		this.payeeCityN401 = payeeCityN401;
	}

	/**
	 * @param payeeStateN402 the payeeStateN402 to set
	 */
	public void setPayeeStateN402(String payeeStateN402)
	{
		this.payeeStateN402 = payeeStateN402;
	}

	/**
	 * @param payeeZipN403 the payeeZipN403 to set
	 */
	public void setPayeeZipN403(String payeeZipN403)
	{
		this.payeeZipN403 = payeeZipN403;
	}

	/**
	 * @param payeeAddIDQualREF01 the payeeAddIDQualREF01 to set
	 */
	public void setPayeeAddIDQualREF01(String payeeAddIDQualREF01)
	{
		this.payeeAddIDQualREF01 = payeeAddIDQualREF01;
	}

	/**
	 * @param payeeAddIDCodeREF02 the payeeAddIDCodeREF02 to set
	 */
	public void setPayeeAddIDCodeREF02(String payeeAddIDCodeREF02) 
	{
		this.payeeAddIDCodeREF02 = payeeAddIDCodeREF02;
	}

	/**
	 * @param remitHeaderTimestamp the remitHeaderTimestamp to set
	 */
	public void setRemitHeaderTimestamp(String remitHeaderTimestamp)
	{
		this.remitHeaderTimestamp = remitHeaderTimestamp;
	}

	/**
	 * @param dateTimeTranslated the dateTimeTranslated to set
	 */
	public void setDateTimeTranslated(String dateTimeTranslated) 
	{
		this.dateTimeTranslated = dateTimeTranslated;
	}

	/**
	 * @param eobReportStatus the eobReportStatus to set
	 */
	public void setEobReportStatus(String eobReportStatus) 
	{
		this.eobReportStatus = eobReportStatus;
	}

	/**
	 * @param eobReportErrorNum the eobReportErrorNum to set
	 */
	public void setEobReportErrorNum(String eobReportErrorNum) 
	{
		this.eobReportErrorNum = eobReportErrorNum;
	}

	/**
	 * @param eobReportErrorReason the eobReportErrorReason to set
	 */
	public void setEobReportErrorReason(String eobReportErrorReason) 
	{
		this.eobReportErrorReason = eobReportErrorReason;
	}

	/**
	 * @param eobReportErrorSource the eobReportErrorSource to set
	 */
	public void setEobReportErrorSource(String eobReportErrorSource) 
	{
		this.eobReportErrorSource = eobReportErrorSource;
	}

	/**
	 * @param eobSubAcctNo the eobSubAcctNo to set
	 */
	public void setEobSubAcctNo(String eobSubAcctNo) {
		this.eobSubAcctNo = eobSubAcctNo;
	}

	/**
	 * @param eobReportCreateDateTime the eobReportCreateDateTime to set
	 */
	public void setEobReportCreateDateTime(String eobReportCreateDateTime) 
	{
		this.eobReportCreateDateTime = eobReportCreateDateTime;
	}

	/**
	 * @param eobReportRunDateTime the eobReportRunDateTime to set
	 */
	public void setEobReportRunDateTime(String eobReportRunDateTime) 
	{
		this.eobReportRunDateTime = eobReportRunDateTime;
	}
	
	/**
	 * @param hasProvAdj the hasProvAdj to set
	 */
	public void setHasProvAdj(boolean hasProvAdj) 
	{
		this.hasProvAdj = hasProvAdj;
	}
	
}
