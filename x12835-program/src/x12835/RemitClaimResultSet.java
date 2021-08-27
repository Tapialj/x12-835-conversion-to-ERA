package x12835;

public class RemitClaimResultSet
{

	private String	remitClaimID,
					headerID,
					claimNo,
					patientAcctNoCLP01,
					claimStatusCodeCLP02,
					claimChargeAmtCLP03,
					claimPmtAmtCLP04,
					patResponsibilityAmtCLP05,
					claimFilingCodeCLP06,
					payerControlNoCLP07,
					remitClaimAdjIDCAS,
					patLastNM103,
					patFirstNM104,
					patMiddleNM105,
					patIDCodeQualNM108,
					patIDCodeNM109,
					subscriberLastNM103,
					subscriberFirstNM104,
					subscriberMiddleNM105,
					subscriberIDCodeQualNM108,
					subscriberIDCodeNM109,
					correctedLastNM103,
					correctedFirstNM104,
					correctedMiddleNM105,
					correctedIDCodeQualNM108,
					correctedIDCodeNM109,
					svcProviderLastNM103,
					svcProviderFirstNM104,
					svcProviderMiddleNM105,
					svcProvIDCodeQualNM108,
					svcProvIDCodeNM109,
					crossoverCarrierNameNM103,
					crossoverIDCodeQualNM108,
					crossoverIDCodeNM109,
					priorityPayerNameNM103,
					priorityPayerIDCodeQualNM108,
					priorityPayerIDCodeNM109,
					reimbursementRateMOA01,
					hcpcsPayableAmtMOA02,
					remarkCode1MOA03,
					remarkCode2MOA04,
					remarkCode3MOA05,
					remarkCode4MOA06,
					remarkCode5MOA07,
					esrdPmtAmtMOA08,
					nonpayProfAmtMOA09,
					otherClaimRefIDQualREF01,
					otheClaimIDNoREF02,
					rendProvIDQualREF01,
					rendProvIDNoREF02,
					claimRecDateDTM02,
					claimStartDateDTM02,
					claimEndDateDTM02,
					claimSuppAmtQualAMT01,
					claimSuppAmtAMT02,
					claimSuppQtyQualQTY01,
					claimSuppQtyQTY02,
					remitClaimTimeStamp;
	boolean			hasServiceLine,
					hasClaimAdj;

	/**
	 * @param remitClaimID
	 * @param headerID
	 * @param claimNo
	 * @param patientAcctNoCLP01
	 * @param claimStatusCodeCLP02
	 * @param claimChargeAmtCLP03
	 * @param claimPmtAmtCLP04
	 * @param patResponsibilityAmtCLP05
	 * @param claimFilingCodeCLP06
	 * @param payerControlNoCLP07
	 * @param remitClaimAdjIDCAS
	 * @param patLastNM103
	 * @param patFirstNM104
	 * @param patMiddleNM105
	 * @param patIDCodeQualNM108
	 * @param patIDCodeNM109
	 * @param subscriberLastNM103
	 * @param subscriberFirstNM104
	 * @param subscriberMiddleNM105
	 * @param subscriberIDCodeQualNM108
	 * @param subscriberIDCodeNM109
	 * @param correctedLastNM103
	 * @param correctedFirstNM104
	 * @param correctedMiddleNM105
	 * @param correctedIDCodeQualNM108
	 * @param correctedIDCodeNM109
	 * @param svcProviderLastNM103
	 * @param svcProviderFirstNM104
	 * @param svcProviderMiddleNM105
	 * @param svcProvIDCodeQualNM108
	 * @param svcProvIDCodeNM109
	 * @param crossoverCarrierNameNM103
	 * @param crossoverIDCodeQualNM108
	 * @param crossoverIDCodeNM109
	 * @param priorityPayerNameNM103
	 * @param priorityPayerIDCodeQualNM108
	 * @param priorityPayerIDCodeNM109
	 * @param reimbursementRateMOA01
	 * @param hcpcsPayableAmtMOA02
	 * @param remarkCode1MOA03
	 * @param remarkCode2MOA04
	 * @param remarkCode3MOA05
	 * @param remarkCode4MOA06
	 * @param remarkCode5MOA07
	 * @param esrdPmtAmtMOA08
	 * @param nonpayProfAmtMOA09
	 * @param otherClaimRefIDQualREF01
	 * @param otheClaimIDNoREF02
	 * @param rendProvIDQualREF01
	 * @param rendProvIDNoREF02
	 * @param claimRecDateDTM02
	 * @param claimStartDateDTM02
	 * @param claimEndDateDTM02
	 * @param claimSuppAmtQualAMT01
	 * @param claimSuppAmtAMT02
	 * @param claimSuppQtyQualQTY01
	 * @param claimSuppQtyQTY02
	 * @param remitClaimTimeStamp
	 */
	public RemitClaimResultSet(String remitClaimID, String headerID, String claimNo, String patientAcctNoCLP01, String claimStatusCodeCLP02, String claimChargeAmtCLP03, String claimPmtAmtCLP04, 
			String patResponsibilityAmtCLP05, String claimFilingCodeCLP06, String payerControlNoCLP07, String remitClaimAdjIDCAS, String patLastNM103, String patFirstNM104, String patMiddleNM105, 
			String patIDCodeQualNM108, String patIDCodeNM109, String subscriberLastNM103, String subscriberFirstNM104, String subscriberMiddleNM105, String subscriberIDCodeQualNM108,
			String subscriberIDCodeNM109, String correctedLastNM103, String correctedFirstNM104, String correctedMiddleNM105, String correctedIDCodeQualNM108, String correctedIDCodeNM109,
			String svcProviderLastNM103, String svcProviderFirstNM104, String svcProviderMiddleNM105, String svcProvIDCodeQualNM108, String svcProvIDCodeNM109, String crossoverCarrierNameNM103,
			String crossoverIDCodeQualNM108, String crossoverIDCodeNM109, String priorityPayerNameNM103, String priorityPayerIDCodeQualNM108, String priorityPayerIDCodeNM109, String reimbursementRateMOA01,
			String hcpcsPayableAmtMOA02, String remarkCode1MOA03, String remarkCode2MOA04, String remarkCode3MOA05, String remarkCode4MOA06, String remarkCode5MOA07, String esrdPmtAmtMOA08,
			String nonpayProfAmtMOA09, String otherClaimRefIDQualREF01, String otheClaimIDNoREF02, String rendProvIDQualREF01, String rendProvIDNoREF02, String claimRecDateDTM02, String claimStartDateDTM02,
			String claimEndDateDTM02, String claimSuppAmtQualAMT01, String claimSuppAmtAMT02, String claimSuppQtyQualQTY01, String claimSuppQtyQTY02, String remitClaimTimeStamp, boolean hasServiceLine,
			boolean hasClaimAdj) 
	{
		this.remitClaimID = remitClaimID;
		this.headerID = headerID;
		this.claimNo = claimNo;
		this.patientAcctNoCLP01 = patientAcctNoCLP01;
		this.claimStatusCodeCLP02 = claimStatusCodeCLP02;
		this.claimChargeAmtCLP03 = claimChargeAmtCLP03;
		this.claimPmtAmtCLP04 = claimPmtAmtCLP04;
		this.patResponsibilityAmtCLP05 = patResponsibilityAmtCLP05;
		this.claimFilingCodeCLP06 = claimFilingCodeCLP06;
		this.payerControlNoCLP07 = payerControlNoCLP07;
		this.remitClaimAdjIDCAS = remitClaimAdjIDCAS;
		this.patLastNM103 = patLastNM103;
		this.patFirstNM104 = patFirstNM104;
		this.patMiddleNM105 = patMiddleNM105;
		this.patIDCodeQualNM108 = patIDCodeQualNM108;
		this.patIDCodeNM109 = patIDCodeNM109;
		this.subscriberLastNM103 = subscriberLastNM103;
		this.subscriberFirstNM104 = subscriberFirstNM104;
		this.subscriberMiddleNM105 = subscriberMiddleNM105;
		this.subscriberIDCodeQualNM108 = subscriberIDCodeQualNM108;
		this.subscriberIDCodeNM109 = subscriberIDCodeNM109;
		this.correctedLastNM103 = correctedLastNM103;
		this.correctedFirstNM104 = correctedFirstNM104;
		this.correctedMiddleNM105 = correctedMiddleNM105;
		this.correctedIDCodeQualNM108 = correctedIDCodeQualNM108;
		this.correctedIDCodeNM109 = correctedIDCodeNM109;
		this.svcProviderLastNM103 = svcProviderLastNM103;
		this.svcProviderFirstNM104 = svcProviderFirstNM104;
		this.svcProviderMiddleNM105 = svcProviderMiddleNM105;
		this.svcProvIDCodeQualNM108 = svcProvIDCodeQualNM108;
		this.svcProvIDCodeNM109 = svcProvIDCodeNM109;
		this.crossoverCarrierNameNM103 = crossoverCarrierNameNM103;
		this.crossoverIDCodeQualNM108 = crossoverIDCodeQualNM108;
		this.crossoverIDCodeNM109 = crossoverIDCodeNM109;
		this.priorityPayerNameNM103 = priorityPayerNameNM103;
		this.priorityPayerIDCodeQualNM108 = priorityPayerIDCodeQualNM108;
		this.priorityPayerIDCodeNM109 = priorityPayerIDCodeNM109;
		this.reimbursementRateMOA01 = reimbursementRateMOA01;
		this.hcpcsPayableAmtMOA02 = hcpcsPayableAmtMOA02;
		this.remarkCode1MOA03 = remarkCode1MOA03;
		this.remarkCode2MOA04 = remarkCode2MOA04;
		this.remarkCode3MOA05 = remarkCode3MOA05;
		this.remarkCode4MOA06 = remarkCode4MOA06;
		this.remarkCode5MOA07 = remarkCode5MOA07;
		this.esrdPmtAmtMOA08 = esrdPmtAmtMOA08;
		this.nonpayProfAmtMOA09 = nonpayProfAmtMOA09;
		this.otherClaimRefIDQualREF01 = otherClaimRefIDQualREF01;
		this.otheClaimIDNoREF02 = otheClaimIDNoREF02;
		this.rendProvIDQualREF01 = rendProvIDQualREF01;
		this.rendProvIDNoREF02 = rendProvIDNoREF02;
		this.claimRecDateDTM02 = claimRecDateDTM02;
		this.claimStartDateDTM02 = claimStartDateDTM02;
		this.claimEndDateDTM02 = claimEndDateDTM02;
		this.claimSuppAmtQualAMT01 = claimSuppAmtQualAMT01;
		this.claimSuppAmtAMT02 = claimSuppAmtAMT02;
		this.claimSuppQtyQualQTY01 = claimSuppQtyQualQTY01;
		this.claimSuppQtyQTY02 = claimSuppQtyQTY02;
		this.remitClaimTimeStamp = remitClaimTimeStamp;
		this.hasServiceLine = hasServiceLine;
		this.hasClaimAdj = hasClaimAdj;
	}

	/**
	 * @return the remitClaimID
	 */
	public String getRemitClaimID() {
		return remitClaimID;
	}

	/**
	 * @return the headerID
	 */
	public String getHeaderID() {
		return headerID;
	}

	/**
	 * @return the claimNo
	 */
	public String getClaimNo() {
		return claimNo;
	}

	/**
	 * @return the patientAcctNoCLP01
	 */
	public String getPatientAcctNoCLP01() {
		return patientAcctNoCLP01;
	}

	/**
	 * @return the claimStatusCodeCLP02
	 */
	public String getClaimStatusCodeCLP02() {
		return claimStatusCodeCLP02;
	}

	/**
	 * @return the claimChargeAmtCLP03
	 */
	public String getClaimChargeAmtCLP03() {
		return claimChargeAmtCLP03;
	}

	/**
	 * @return the claimPmtAmtCLP04
	 */
	public String getClaimPmtAmtCLP04() {
		return claimPmtAmtCLP04;
	}

	/**
	 * @return the patResponsibilityAmtCLP05
	 */
	public String getPatResponsibilityAmtCLP05() {
		return patResponsibilityAmtCLP05;
	}

	/**
	 * @return the claimFilingCodeCLP06
	 */
	public String getClaimFilingCodeCLP06() {
		return claimFilingCodeCLP06;
	}

	/**
	 * @return the payerControlNoCLP07
	 */
	public String getPayerControlNoCLP07() {
		return payerControlNoCLP07;
	}

	/**
	 * @return the remitClaimAdjIDCAS
	 */
	public String getRemitClaimAdjIDCAS() {
		return remitClaimAdjIDCAS;
	}

	/**
	 * @return the patLastNM103
	 */
	public String getPatLastNM103() {
		return patLastNM103;
	}

	/**
	 * @return the patFirstNM104
	 */
	public String getPatFirstNM104() {
		return patFirstNM104;
	}

	/**
	 * @return the patMiddleNM105
	 */
	public String getPatMiddleNM105() {
		return patMiddleNM105;
	}

	/**
	 * @return the patIDCodeQualNM108
	 */
	public String getPatIDCodeQualNM108() {
		return patIDCodeQualNM108;
	}

	/**
	 * @return the patIDCodeNM109
	 */
	public String getPatIDCodeNM109() {
		return patIDCodeNM109;
	}

	/**
	 * @return the subscriberLastNM103
	 */
	public String getSubscriberLastNM103() {
		return subscriberLastNM103;
	}

	/**
	 * @return the subscriberFirstNM104
	 */
	public String getSubscriberFirstNM104() {
		return subscriberFirstNM104;
	}

	/**
	 * @return the subscriberMiddleNM105
	 */
	public String getSubscriberMiddleNM105() {
		return subscriberMiddleNM105;
	}

	/**
	 * @return the subscriberIDCodeQualNM108
	 */
	public String getSubscriberIDCodeQualNM108() {
		return subscriberIDCodeQualNM108;
	}

	/**
	 * @return the subscriberIDCodeNM109
	 */
	public String getSubscriberIDCodeNM109() {
		return subscriberIDCodeNM109;
	}

	/**
	 * @return the correctedLastNM103
	 */
	public String getCorrectedLastNM103() {
		return correctedLastNM103;
	}

	/**
	 * @return the correctedFirstNM104
	 */
	public String getCorrectedFirstNM104() {
		return correctedFirstNM104;
	}

	/**
	 * @return the correctedMiddleNM105
	 */
	public String getCorrectedMiddleNM105() {
		return correctedMiddleNM105;
	}

	/**
	 * @return the correctedIDCodeQualNM108
	 */
	public String getCorrectedIDCodeQualNM108() {
		return correctedIDCodeQualNM108;
	}

	/**
	 * @return the correctedIDCodeNM109
	 */
	public String getCorrectedIDCodeNM109() {
		return correctedIDCodeNM109;
	}

	/**
	 * @return the svcProviderLastNM103
	 */
	public String getSvcProviderLastNM103() {
		return svcProviderLastNM103;
	}

	/**
	 * @return the svcProviderFirstNM104
	 */
	public String getSvcProviderFirstNM104() {
		return svcProviderFirstNM104;
	}

	/**
	 * @return the svcProviderMiddleNM105
	 */
	public String getSvcProviderMiddleNM105() {
		return svcProviderMiddleNM105;
	}

	/**
	 * @return the svcProvIDCodeQualNM108
	 */
	public String getSvcProvIDCodeQualNM108() {
		return svcProvIDCodeQualNM108;
	}

	/**
	 * @return the svcProvIDCodeNM109
	 */
	public String getSvcProvIDCodeNM109() {
		return svcProvIDCodeNM109;
	}

	/**
	 * @return the crossoverCarrierNameNM103
	 */
	public String getCrossoverCarrierNameNM103() {
		return crossoverCarrierNameNM103;
	}

	/**
	 * @return the crossoverIDCodeQualNM108
	 */
	public String getCrossoverIDCodeQualNM108() {
		return crossoverIDCodeQualNM108;
	}

	/**
	 * @return the crossoverIDCodeNM109
	 */
	public String getCrossoverIDCodeNM109() {
		return crossoverIDCodeNM109;
	}

	/**
	 * @return the priorityPayerNameNM103
	 */
	public String getPriorityPayerNameNM103() {
		return priorityPayerNameNM103;
	}

	/**
	 * @return the priorityPayerIDCodeQualNM108
	 */
	public String getPriorityPayerIDCodeQualNM108() {
		return priorityPayerIDCodeQualNM108;
	}

	/**
	 * @return the priorityPayerIDCodeNM109
	 */
	public String getPriorityPayerIDCodeNM109() {
		return priorityPayerIDCodeNM109;
	}

	/**
	 * @return the reimbursementRateMOA01
	 */
	public String getReimbursementRateMOA01() {
		return reimbursementRateMOA01;
	}

	/**
	 * @return the hcpcsPayableAmtMOA02
	 */
	public String getHcpcsPayableAmtMOA02() {
		return hcpcsPayableAmtMOA02;
	}

	/**
	 * @return the remarkCode1MOA03
	 */
	public String getRemarkCode1MOA03() {
		return remarkCode1MOA03;
	}

	/**
	 * @return the remarkCode2MOA04
	 */
	public String getRemarkCode2MOA04() {
		return remarkCode2MOA04;
	}

	/**
	 * @return the remarkCode3MOA05
	 */
	public String getRemarkCode3MOA05() {
		return remarkCode3MOA05;
	}

	/**
	 * @return the remarkCode4MOA06
	 */
	public String getRemarkCode4MOA06() {
		return remarkCode4MOA06;
	}

	/**
	 * @return the remarkCode5MOA07
	 */
	public String getRemarkCode5MOA07() {
		return remarkCode5MOA07;
	}

	/**
	 * @return the esrdPmtAmtMOA08
	 */
	public String getEsrdPmtAmtMOA08() {
		return esrdPmtAmtMOA08;
	}

	/**
	 * @return the nonpayProfAmtMOA09
	 */
	public String getNonpayProfAmtMOA09() {
		return nonpayProfAmtMOA09;
	}

	/**
	 * @return the otherClaimRefIDQualREF01
	 */
	public String getOtherClaimRefIDQualREF01() {
		return otherClaimRefIDQualREF01;
	}

	/**
	 * @return the otheClaimIDNoREF02
	 */
	public String getOtheClaimIDNoREF02() {
		return otheClaimIDNoREF02;
	}

	/**
	 * @return the rendProvIDQualREF01
	 */
	public String getRendProvIDQualREF01() {
		return rendProvIDQualREF01;
	}

	/**
	 * @return the rendProvIDNoREF02
	 */
	public String getRendProvIDNoREF02() {
		return rendProvIDNoREF02;
	}

	/**
	 * @return the claimRecDateDTM02
	 */
	public String getClaimRecDateDTM02() {
		return claimRecDateDTM02;
	}

	/**
	 * @return the claimStartDateDTM02
	 */
	public String getClaimStartDateDTM02() {
		return claimStartDateDTM02;
	}

	/**
	 * @return the claimEndDateDTM02
	 */
	public String getClaimEndDateDTM02() {
		return claimEndDateDTM02;
	}

	/**
	 * @return the claimSuppAmtQualAMT01
	 */
	public String getClaimSuppAmtQualAMT01() {
		return claimSuppAmtQualAMT01;
	}

	/**
	 * @return the claimSuppAmtAMT02
	 */
	public String getClaimSuppAmtAMT02() {
		return claimSuppAmtAMT02;
	}

	/**
	 * @return the claimSuppQtyQualQTY01
	 */
	public String getClaimSuppQtyQualQTY01() {
		return claimSuppQtyQualQTY01;
	}

	/**
	 * @return the claimSuppQtyQTY02
	 */
	public String getClaimSuppQtyQTY02() {
		return claimSuppQtyQTY02;
	}

	/**
	 * @return the remitClaimTimeStamp
	 */
	public String getRemitClaimTimeStamp() {
		return remitClaimTimeStamp;
	}

	/**
	 * @return the hasServiceLine
	 */
	public boolean isHasServiceLine() {
		return hasServiceLine;
	}

	/**
	 * @return the hasClaimAdj
	 */
	public boolean isHasClaimAdj() {
		return hasClaimAdj;
	}	
	
	/**
	 * @param remitClaimID the remitClaimID to set
	 */
	public void setRemitClaimID(String remitClaimID) {
		this.remitClaimID = remitClaimID;
	}

	/**
	 * @param headerID the headerID to set
	 */
	public void setHeaderID(String headerID) {
		this.headerID = headerID;
	}

	/**
	 * @param claimNo the claimNo to set
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	/**
	 * @param patientAcctNoCLP01 the patientAcctNoCLP01 to set
	 */
	public void setPatientAcctNoCLP01(String patientAcctNoCLP01) {
		this.patientAcctNoCLP01 = patientAcctNoCLP01;
	}

	/**
	 * @param claimStatusCodeCLP02 the claimStatusCodeCLP02 to set
	 */
	public void setClaimStatusCodeCLP02(String claimStatusCodeCLP02) {
		this.claimStatusCodeCLP02 = claimStatusCodeCLP02;
	}

	/**
	 * @param claimChargeAmtCLP03 the claimChargeAmtCLP03 to set
	 */
	public void setClaimChargeAmtCLP03(String claimChargeAmtCLP03) {
		this.claimChargeAmtCLP03 = claimChargeAmtCLP03;
	}

	/**
	 * @param claimPmtAmtCLP04 the claimPmtAmtCLP04 to set
	 */
	public void setClaimPmtAmtCLP04(String claimPmtAmtCLP04) {
		this.claimPmtAmtCLP04 = claimPmtAmtCLP04;
	}

	/**
	 * @param patResponsibilityAmtCLP05 the patResponsibilityAmtCLP05 to set
	 */
	public void setPatResponsibilityAmtCLP05(String patResponsibilityAmtCLP05) {
		this.patResponsibilityAmtCLP05 = patResponsibilityAmtCLP05;
	}

	/**
	 * @param claimFilingCodeCLP06 the claimFilingCodeCLP06 to set
	 */
	public void setClaimFilingCodeCLP06(String claimFilingCodeCLP06) {
		this.claimFilingCodeCLP06 = claimFilingCodeCLP06;
	}

	/**
	 * @param payerControlNoCLP07 the payerControlNoCLP07 to set
	 */
	public void setPayerControlNoCLP07(String payerControlNoCLP07) {
		this.payerControlNoCLP07 = payerControlNoCLP07;
	}

	/**
	 * @param remitClaimAdjIDCAS the remitClaimAdjIDCAS to set
	 */
	public void setRemitClaimAdjIDCAS(String remitClaimAdjIDCAS) {
		this.remitClaimAdjIDCAS = remitClaimAdjIDCAS;
	}

	/**
	 * @param patLastNM103 the patLastNM103 to set
	 */
	public void setPatLastNM103(String patLastNM103) {
		this.patLastNM103 = patLastNM103;
	}

	/**
	 * @param patFirstNM104 the patFirstNM104 to set
	 */
	public void setPatFirstNM104(String patFirstNM104) {
		this.patFirstNM104 = patFirstNM104;
	}

	/**
	 * @param patMiddleNM105 the patMiddleNM105 to set
	 */
	public void setPatMiddleNM105(String patMiddleNM105) {
		this.patMiddleNM105 = patMiddleNM105;
	}

	/**
	 * @param patIDCodeQualNM108 the patIDCodeQualNM108 to set
	 */
	public void setPatIDCodeQualNM108(String patIDCodeQualNM108) {
		this.patIDCodeQualNM108 = patIDCodeQualNM108;
	}

	/**
	 * @param patIDCodeNM109 the patIDCodeNM109 to set
	 */
	public void setPatIDCodeNM109(String patIDCodeNM109) {
		this.patIDCodeNM109 = patIDCodeNM109;
	}

	/**
	 * @param subscriberLastNM103 the subscriberLastNM103 to set
	 */
	public void setSubscriberLastNM103(String subscriberLastNM103) {
		this.subscriberLastNM103 = subscriberLastNM103;
	}

	/**
	 * @param subscriberFirstNM104 the subscriberFirstNM104 to set
	 */
	public void setSubscriberFirstNM104(String subscriberFirstNM104) {
		this.subscriberFirstNM104 = subscriberFirstNM104;
	}

	/**
	 * @param subscriberMiddleNM105 the subscriberMiddleNM105 to set
	 */
	public void setSubscriberMiddleNM105(String subscriberMiddleNM105) {
		this.subscriberMiddleNM105 = subscriberMiddleNM105;
	}

	/**
	 * @param subscriberIDCodeQualNM108 the subscriberIDCodeQualNM108 to set
	 */
	public void setSubscriberIDCodeQualNM108(String subscriberIDCodeQualNM108) {
		this.subscriberIDCodeQualNM108 = subscriberIDCodeQualNM108;
	}

	/**
	 * @param subscriberIDCodeNM109 the subscriberIDCodeNM109 to set
	 */
	public void setSubscriberIDCodeNM109(String subscriberIDCodeNM109) {
		this.subscriberIDCodeNM109 = subscriberIDCodeNM109;
	}

	/**
	 * @param correctedLastNM103 the correctedLastNM103 to set
	 */
	public void setCorrectedLastNM103(String correctedLastNM103) {
		this.correctedLastNM103 = correctedLastNM103;
	}

	/**
	 * @param correctedFirstNM104 the correctedFirstNM104 to set
	 */
	public void setCorrectedFirstNM104(String correctedFirstNM104) {
		this.correctedFirstNM104 = correctedFirstNM104;
	}

	/**
	 * @param correctedMiddleNM105 the correctedMiddleNM105 to set
	 */
	public void setCorrectedMiddleNM105(String correctedMiddleNM105) {
		this.correctedMiddleNM105 = correctedMiddleNM105;
	}

	/**
	 * @param correctedIDCodeQualNM108 the correctedIDCodeQualNM108 to set
	 */
	public void setCorrectedIDCodeQualNM108(String correctedIDCodeQualNM108) {
		this.correctedIDCodeQualNM108 = correctedIDCodeQualNM108;
	}

	/**
	 * @param correctedIDCodeNM109 the correctedIDCodeNM109 to set
	 */
	public void setCorrectedIDCodeNM109(String correctedIDCodeNM109) {
		this.correctedIDCodeNM109 = correctedIDCodeNM109;
	}

	/**
	 * @param svcProviderLastNM103 the svcProviderLastNM103 to set
	 */
	public void setSvcProviderLastNM103(String svcProviderLastNM103) {
		this.svcProviderLastNM103 = svcProviderLastNM103;
	}

	/**
	 * @param svcProviderFirstNM104 the svcProviderFirstNM104 to set
	 */
	public void setSvcProviderFirstNM104(String svcProviderFirstNM104) {
		this.svcProviderFirstNM104 = svcProviderFirstNM104;
	}

	/**
	 * @param svcProviderMiddleNM105 the svcProviderMiddleNM105 to set
	 */
	public void setSvcProviderMiddleNM105(String svcProviderMiddleNM105) {
		this.svcProviderMiddleNM105 = svcProviderMiddleNM105;
	}

	/**
	 * @param svcProvIDCodeQualNM108 the svcProvIDCodeQualNM108 to set
	 */
	public void setSvcProvIDCodeQualNM108(String svcProvIDCodeQualNM108) {
		this.svcProvIDCodeQualNM108 = svcProvIDCodeQualNM108;
	}

	/**
	 * @param svcProvIDCodeNM109 the svcProvIDCodeNM109 to set
	 */
	public void setSvcProvIDCodeNM109(String svcProvIDCodeNM109) {
		this.svcProvIDCodeNM109 = svcProvIDCodeNM109;
	}

	/**
	 * @param crossoverCarrierNameNM103 the crossoverCarrierNameNM103 to set
	 */
	public void setCrossoverCarrierNameNM103(String crossoverCarrierNameNM103) {
		this.crossoverCarrierNameNM103 = crossoverCarrierNameNM103;
	}

	/**
	 * @param crossoverIDCodeQualNM108 the crossoverIDCodeQualNM108 to set
	 */
	public void setCrossoverIDCodeQualNM108(String crossoverIDCodeQualNM108) {
		this.crossoverIDCodeQualNM108 = crossoverIDCodeQualNM108;
	}

	/**
	 * @param crossoverIDCodeNM109 the crossoverIDCodeNM109 to set
	 */
	public void setCrossoverIDCodeNM109(String crossoverIDCodeNM109) {
		this.crossoverIDCodeNM109 = crossoverIDCodeNM109;
	}

	/**
	 * @param priorityPayerNameNM103 the priorityPayerNameNM103 to set
	 */
	public void setPriorityPayerNameNM103(String priorityPayerNameNM103) {
		this.priorityPayerNameNM103 = priorityPayerNameNM103;
	}

	/**
	 * @param priorityPayerIDCodeQualNM108 the priorityPayerIDCodeQualNM108 to set
	 */
	public void setPriorityPayerIDCodeQualNM108(String priorityPayerIDCodeQualNM108) {
		this.priorityPayerIDCodeQualNM108 = priorityPayerIDCodeQualNM108;
	}

	/**
	 * @param priorityPayerIDCodeNM109 the priorityPayerIDCodeNM109 to set
	 */
	public void setPriorityPayerIDCodeNM109(String priorityPayerIDCodeNM109) {
		this.priorityPayerIDCodeNM109 = priorityPayerIDCodeNM109;
	}

	/**
	 * @param reimbursementRateMOA01 the reimbursementRateMOA01 to set
	 */
	public void setReimbursementRateMOA01(String reimbursementRateMOA01) {
		this.reimbursementRateMOA01 = reimbursementRateMOA01;
	}

	/**
	 * @param hcpcsPayableAmtMOA02 the hcpcsPayableAmtMOA02 to set
	 */
	public void setHcpcsPayableAmtMOA02(String hcpcsPayableAmtMOA02) {
		this.hcpcsPayableAmtMOA02 = hcpcsPayableAmtMOA02;
	}

	/**
	 * @param remarkCode1MOA03 the remarkCode1MOA03 to set
	 */
	public void setRemarkCode1MOA03(String remarkCode1MOA03) {
		this.remarkCode1MOA03 = remarkCode1MOA03;
	}

	/**
	 * @param remarkCode2MOA04 the remarkCode2MOA04 to set
	 */
	public void setRemarkCode2MOA04(String remarkCode2MOA04) {
		this.remarkCode2MOA04 = remarkCode2MOA04;
	}

	/**
	 * @param remarkCode3MOA05 the remarkCode3MOA05 to set
	 */
	public void setRemarkCode3MOA05(String remarkCode3MOA05) {
		this.remarkCode3MOA05 = remarkCode3MOA05;
	}

	/**
	 * @param remarkCode4MOA06 the remarkCode4MOA06 to set
	 */
	public void setRemarkCode4MOA06(String remarkCode4MOA06) {
		this.remarkCode4MOA06 = remarkCode4MOA06;
	}

	/**
	 * @param remarkCode5MOA07 the remarkCode5MOA07 to set
	 */
	public void setRemarkCode5MOA07(String remarkCode5MOA07) {
		this.remarkCode5MOA07 = remarkCode5MOA07;
	}

	/**
	 * @param esrdPmtAmtMOA08 the esrdPmtAmtMOA08 to set
	 */
	public void setEsrdPmtAmtMOA08(String esrdPmtAmtMOA08) {
		this.esrdPmtAmtMOA08 = esrdPmtAmtMOA08;
	}

	/**
	 * @param nonpayProfAmtMOA09 the nonpayProfAmtMOA09 to set
	 */
	public void setNonpayProfAmtMOA09(String nonpayProfAmtMOA09) {
		this.nonpayProfAmtMOA09 = nonpayProfAmtMOA09;
	}

	/**
	 * @param otherClaimRefIDQualREF01 the otherClaimRefIDQualREF01 to set
	 */
	public void setOtherClaimRefIDQualREF01(String otherClaimRefIDQualREF01) {
		this.otherClaimRefIDQualREF01 = otherClaimRefIDQualREF01;
	}

	/**
	 * @param otheClaimIDNoREF02 the otheClaimIDNoREF02 to set
	 */
	public void setOtheClaimIDNoREF02(String otheClaimIDNoREF02) {
		this.otheClaimIDNoREF02 = otheClaimIDNoREF02;
	}

	/**
	 * @param rendProvIDQualREF01 the rendProvIDQualREF01 to set
	 */
	public void setRendProvIDQualREF01(String rendProvIDQualREF01) {
		this.rendProvIDQualREF01 = rendProvIDQualREF01;
	}

	/**
	 * @param rendProvIDNoREF02 the rendProvIDNoREF02 to set
	 */
	public void setRendProvIDNoREF02(String rendProvIDNoREF02) {
		this.rendProvIDNoREF02 = rendProvIDNoREF02;
	}

	/**
	 * @param claimRecDateDTM02 the claimRecDateDTM02 to set
	 */
	public void setClaimRecDateDTM02(String claimRecDateDTM02) {
		this.claimRecDateDTM02 = claimRecDateDTM02;
	}

	/**
	 * @param claimStartDateDTM02 the claimStartDateDTM02 to set
	 */
	public void setClaimStartDateDTM02(String claimStartDateDTM02) {
		this.claimStartDateDTM02 = claimStartDateDTM02;
	}

	/**
	 * @param claimEndDateDTM02 the claimEndDateDTM02 to set
	 */
	public void setClaimEndDateDTM02(String claimEndDateDTM02) {
		this.claimEndDateDTM02 = claimEndDateDTM02;
	}

	/**
	 * @param claimSuppAmtQualAMT01 the claimSuppAmtQualAMT01 to set
	 */
	public void setClaimSuppAmtQualAMT01(String claimSuppAmtQualAMT01) {
		this.claimSuppAmtQualAMT01 = claimSuppAmtQualAMT01;
	}

	/**
	 * @param claimSuppAmtAMT02 the claimSuppAmtAMT02 to set
	 */
	public void setClaimSuppAmtAMT02(String claimSuppAmtAMT02) {
		this.claimSuppAmtAMT02 = claimSuppAmtAMT02;
	}

	/**
	 * @param claimSuppQtyQualQTY01 the claimSuppQtyQualQTY01 to set
	 */
	public void setClaimSuppQtyQualQTY01(String claimSuppQtyQualQTY01) {
		this.claimSuppQtyQualQTY01 = claimSuppQtyQualQTY01;
	}

	/**
	 * @param claimSuppQtyQTY02 the claimSuppQtyQTY02 to set
	 */
	public void setClaimSuppQtyQTY02(String claimSuppQtyQTY02) {
		this.claimSuppQtyQTY02 = claimSuppQtyQTY02;
	}

	/**
	 * @param remitClaimTimeStamp the remitClaimTimeStamp to set
	 */
	public void setRemitClaimTimeStamp(String remitClaimTimeStamp) {
		this.remitClaimTimeStamp = remitClaimTimeStamp;
	}

	/**
	 * @param hasServiceLine the hasServiceLine to set
	 */
	public void setHasServiceLine(boolean hasServiceLine) {
		this.hasServiceLine = hasServiceLine;
	}

	/**
	 * @param hasClaimAdj the hasClaimAdj to set
	 */
	public void setHasClaimAdj(boolean hasClaimAdj) {
		this.hasClaimAdj = hasClaimAdj;
	}

}
