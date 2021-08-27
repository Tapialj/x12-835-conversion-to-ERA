package x12835;

public class RemitServiceLineResultSet
{

	private String	remitSvcLineID,
					claimNo,
					lineNo,
					procedureCodeSVC012,
					procedureMod1SVC013,
					procedureMod2SVC014,
					procedureMod3SVC015,
					proceudreMod4SVC016,
					lineChargeSVC02,
					linePmtAmtSVC03,
					nubcReveneCodeSVC04,
					lineQtyPaidSVC05,
					lineOrigQtySVC07,
					lineServiceDateDTM02,
					lineServiceDateStartDTM02,
					lineServiceDateEndDTM02,
					remitLineAdjIDCAS,
					serviceIDQualREF01,
					serviceIDREF02,
					renderingProvIDQualREF01,
					renderingProvIDREF02,
					lineAllowedActualAmtAMT02,
					lineSuppQtyQualQTY01,
					lineSuppQtyQTY02,
					lineRemarkCodeQualLQ01,
					lineRemarkCodeLQ02,
					remitSvcLinesTimestamp;

	/**
	 * @param remitSvcLineID
	 * @param claimNo
	 * @param lineNo
	 * @param procedureCodeSVC012
	 * @param procedureMod1SVC013
	 * @param procedureMod2SVC014
	 * @param procedureMod3SVC015
	 * @param proceudreMod4SVC016
	 * @param lineChargeSVC02
	 * @param linePmtAmtSVC03
	 * @param nubcReveneCodeSVC04
	 * @param lineQtyPaidSVC05
	 * @param lineOrigQtySVC07
	 * @param lineServiceDateDTM02
	 * @param lineServiceDateStartDTM02
	 * @param lineServiceDateEndDTM02
	 * @param remitLineAdjIDCAS
	 * @param serviceIDQualREF01
	 * @param serviceIDREF02
	 * @param renderingProvIDQualREF01
	 * @param renderingProvIDREF02
	 * @param lineAllowedActualAmtAMT02
	 * @param lineSuppQtyQualQTY01
	 * @param lineSuppQtyQTY02
	 * @param lineRemarkCodeQualLQ01
	 * @param lineRemarkCodeLQ02
	 * @param remitSvcLinesTimestamp
	 */
	public RemitServiceLineResultSet(String remitSvcLineID, String claimNo, String lineNo, String procedureCodeSVC012, String procedureMod1SVC013, String procedureMod2SVC014,
			String procedureMod3SVC015, String proceudreMod4SVC016, String lineChargeSVC02, String linePmtAmtSVC03, String nubcReveneCodeSVC04, String lineQtyPaidSVC05,
			String lineOrigQtySVC07, String lineServiceDateDTM02, String lineServiceDateStartDTM02, String lineServiceDateEndDTM02, String remitLineAdjIDCAS, 
			String serviceIDQualREF01, String serviceIDREF02, String renderingProvIDQualREF01, String renderingProvIDREF02, String lineAllowedActualAmtAMT02, 
			String lineSuppQtyQualQTY01, String lineSuppQtyQTY02, String lineRemarkCodeQualLQ01, String lineRemarkCodeLQ02, String remitSvcLinesTimestamp) 
	{
		this.remitSvcLineID = remitSvcLineID;
		this.claimNo = claimNo;
		this.lineNo = lineNo;
		this.procedureCodeSVC012 = procedureCodeSVC012;
		this.procedureMod1SVC013 = procedureMod1SVC013;
		this.procedureMod2SVC014 = procedureMod2SVC014;
		this.procedureMod3SVC015 = procedureMod3SVC015;
		this.proceudreMod4SVC016 = proceudreMod4SVC016;
		this.lineChargeSVC02 = lineChargeSVC02;
		this.linePmtAmtSVC03 = linePmtAmtSVC03;
		this.nubcReveneCodeSVC04 = nubcReveneCodeSVC04;
		this.lineQtyPaidSVC05 = lineQtyPaidSVC05;
		this.lineOrigQtySVC07 = lineOrigQtySVC07;
		this.lineServiceDateDTM02 = lineServiceDateDTM02;
		this.lineServiceDateStartDTM02 = lineServiceDateStartDTM02;
		this.lineServiceDateEndDTM02 = lineServiceDateEndDTM02;
		this.remitLineAdjIDCAS = remitLineAdjIDCAS;
		this.serviceIDQualREF01 = serviceIDQualREF01;
		this.serviceIDREF02 = serviceIDREF02;
		this.renderingProvIDQualREF01 = renderingProvIDQualREF01;
		this.renderingProvIDREF02 = renderingProvIDREF02;
		this.lineAllowedActualAmtAMT02 = lineAllowedActualAmtAMT02;
		this.lineSuppQtyQualQTY01 = lineSuppQtyQualQTY01;
		this.lineSuppQtyQTY02 = lineSuppQtyQTY02;
		this.lineRemarkCodeQualLQ01 = lineRemarkCodeQualLQ01;
		this.lineRemarkCodeLQ02 = lineRemarkCodeLQ02;
		this.remitSvcLinesTimestamp = remitSvcLinesTimestamp;
	}

	/**
	 * @return the remitSvcLineID
	 */
	public String getRemitSvcLineID() 
	{
		return remitSvcLineID;
	}

	/**
	 * @return the claimNo
	 */
	public String getClaimNo() 
	{
		return claimNo;
	}

	/**
	 * @return the lineNo
	 */
	public String getLineNo() 
	{
		return lineNo;
	}

	/**
	 * @return the procedureCodeSVC012
	 */
	public String getProcedureCodeSVC012() 
	{
		return procedureCodeSVC012;
	}

	/**
	 * @return the procedureMod1SVC013
	 */
	public String getProcedureMod1SVC013()
	{
		return procedureMod1SVC013;
	}

	/**
	 * @return the procedureMod2SVC014
	 */
	public String getProcedureMod2SVC014() 
	{
		return procedureMod2SVC014;
	}

	/**
	 * @return the procedureMod3SVC015
	 */
	public String getProcedureMod3SVC015()
	{
		return procedureMod3SVC015;
	}

	/**
	 * @return the proceudreMod4SVC016
	 */
	public String getProceudreMod4SVC016() 
	{
		return proceudreMod4SVC016;
	}

	/**
	 * @return the lineChargeSVC02
	 */
	public String getLineChargeSVC02() 
	{
		return lineChargeSVC02;
	}

	/**
	 * @return the linePmtAmtSVC03
	 */
	public String getLinePmtAmtSVC03() 
	{
		return linePmtAmtSVC03;
	}

	/**
	 * @return the nubcReveneCodeSVC04
	 */
	public String getNubcReveneCodeSVC04() 
	{
		return nubcReveneCodeSVC04;
	}

	/**
	 * @return the lineQtyPaidSVC05
	 */
	public String getLineQtyPaidSVC05() 
	{
		return lineQtyPaidSVC05;
	}

	/**
	 * @return the lineOrigQtySVC07
	 */
	public String getLineOrigQtySVC07() 
	{
		return lineOrigQtySVC07;
	}

	/**
	 * @return the lineServiceDateDTM02
	 */
	public String getLineServiceDateDTM02() 
	{
		return lineServiceDateDTM02;
	}

	/**
	 * @return the lineServiceDateStartDTM02
	 */
	public String getLineServiceDateStartDTM02() 
	{
		return lineServiceDateStartDTM02;
	}

	/**
	 * @return the lineServiceDateEndDTM02
	 */
	public String getLineServiceDateEndDTM02() 
	{
		return lineServiceDateEndDTM02;
	}

	/**
	 * @return the remitLineAdjIDCAS
	 */
	public String getRemitLineAdjIDCAS() 
	{
		return remitLineAdjIDCAS;
	}

	/**
	 * @return the serviceIDQualREF01
	 */
	public String getServiceIDQualREF01() 
	{
		return serviceIDQualREF01;
	}

	/**
	 * @return the serviceIDREF02
	 */
	public String getServiceIDREF02() 
	{
		return serviceIDREF02;
	}

	/**
	 * @return the renderingProvIDQualREF01
	 */
	public String getRenderingProvIDQualREF01() 
	{
		return renderingProvIDQualREF01;
	}

	/**
	 * @return the renderingProvIDREF02
	 */
	public String getRenderingProvIDREF02() 
	{
		return renderingProvIDREF02;
	}

	/**
	 * @return the lineAllowedActualAmtAMT02
	 */
	public String getLineAllowedActualAmtAMT02() 
	{
		return lineAllowedActualAmtAMT02;
	}

	/**
	 * @return the lineSuppQtyQualQTY01
	 */
	public String getLineSuppQtyQualQTY01()
	{
		return lineSuppQtyQualQTY01;
	}

	/**
	 * @return the lineSuppQtyQTY02
	 */
	public String getLineSuppQtyQTY02() 
	{
		return lineSuppQtyQTY02;
	}

	/**
	 * @return the lineRemarkCodeQualLQ01
	 */
	public String getLineRemarkCodeQualLQ01() 
	{
		return lineRemarkCodeQualLQ01;
	}

	/**
	 * @return the lineRemarkCodeLQ02
	 */
	public String getLineRemarkCodeLQ02()
	{
		return lineRemarkCodeLQ02;
	}

	/**
	 * @return the remitSvcLinesTimestamp
	 */
	public String getRemitSvcLinesTimestamp() 
	{
		return remitSvcLinesTimestamp;
	}

	/**
	 * @param remitSvcLineID the remitSvcLineID to set
	 */
	public void setRemitSvcLineID(String remitSvcLineID) 
	{
		this.remitSvcLineID = remitSvcLineID;
	}

	/**
	 * @param claimNo the claimNo to set
	 */
	public void setClaimNo(String claimNo)
	{
		this.claimNo = claimNo;
	}

	/**
	 * @param lineNo the lineNo to set
	 */
	public void setLineNo(String lineNo) 
	{
		this.lineNo = lineNo;
	}

	/**
	 * @param procedureCodeSVC012 the procedureCodeSVC012 to set
	 */
	public void setProcedureCodeSVC012(String procedureCodeSVC012) 
	{
		this.procedureCodeSVC012 = procedureCodeSVC012;
	}

	/**
	 * @param procedureMod1SVC013 the procedureMod1SVC013 to set
	 */
	public void setProcedureMod1SVC013(String procedureMod1SVC013) 
	{
		this.procedureMod1SVC013 = procedureMod1SVC013;
	}

	/**
	 * @param procedureMod2SVC014 the procedureMod2SVC014 to set
	 */
	public void setProcedureMod2SVC014(String procedureMod2SVC014) 
	{
		this.procedureMod2SVC014 = procedureMod2SVC014;
	}

	/**
	 * @param procedureMod3SVC015 the procedureMod3SVC015 to set
	 */
	public void setProcedureMod3SVC015(String procedureMod3SVC015) 
	{
		this.procedureMod3SVC015 = procedureMod3SVC015;
	}

	/**
	 * @param proceudreMod4SVC016 the proceudreMod4SVC016 to set
	 */
	public void setProceudreMod4SVC016(String proceudreMod4SVC016) 
	{
		this.proceudreMod4SVC016 = proceudreMod4SVC016;
	}

	/**
	 * @param lineChargeSVC02 the lineChargeSVC02 to set
	 */
	public void setLineChargeSVC02(String lineChargeSVC02) 
	{
		this.lineChargeSVC02 = lineChargeSVC02;
	}

	/**
	 * @param linePmtAmtSVC03 the linePmtAmtSVC03 to set
	 */
	public void setLinePmtAmtSVC03(String linePmtAmtSVC03) 
	{
		this.linePmtAmtSVC03 = linePmtAmtSVC03;
	}

	/**
	 * @param nubcReveneCodeSVC04 the nubcReveneCodeSVC04 to set
	 */
	public void setNubcReveneCodeSVC04(String nubcReveneCodeSVC04)
	{
		this.nubcReveneCodeSVC04 = nubcReveneCodeSVC04;
	}

	/**
	 * @param lineQtyPaidSVC05 the lineQtyPaidSVC05 to set
	 */
	public void setLineQtyPaidSVC05(String lineQtyPaidSVC05) 
	{
		this.lineQtyPaidSVC05 = lineQtyPaidSVC05;
	}

	/**
	 * @param lineOrigQtySVC07 the lineOrigQtySVC07 to set
	 */
	public void setLineOrigQtySVC07(String lineOrigQtySVC07) 
	{
		this.lineOrigQtySVC07 = lineOrigQtySVC07;
	}

	/**
	 * @param lineServiceDateDTM02 the lineServiceDateDTM02 to set
	 */
	public void setLineServiceDateDTM02(String lineServiceDateDTM02) 
	{
		this.lineServiceDateDTM02 = lineServiceDateDTM02;
	}

	/**
	 * @param lineServiceDateStartDTM02 the lineServiceDateStartDTM02 to set
	 */
	public void setLineServiceDateStartDTM02(String lineServiceDateStartDTM02)
	{
		this.lineServiceDateStartDTM02 = lineServiceDateStartDTM02;
	}

	/**
	 * @param lineServiceDateEndDTM02 the lineServiceDateEndDTM02 to set
	 */
	public void setLineServiceDateEndDTM02(String lineServiceDateEndDTM02)
	{
		this.lineServiceDateEndDTM02 = lineServiceDateEndDTM02;
	}

	/**
	 * @param remitLineAdjIDCAS the remitLineAdjIDCAS to set
	 */
	public void setRemitLineAdjIDCAS(String remitLineAdjIDCAS)
	{
		this.remitLineAdjIDCAS = remitLineAdjIDCAS;
	}

	/**
	 * @param serviceIDQualREF01 the serviceIDQualREF01 to set
	 */
	public void setServiceIDQualREF01(String serviceIDQualREF01) 
	{
		this.serviceIDQualREF01 = serviceIDQualREF01;
	}

	/**
	 * @param serviceIDREF02 the serviceIDREF02 to set
	 */
	public void setServiceIDREF02(String serviceIDREF02) 
	{
		this.serviceIDREF02 = serviceIDREF02;
	}

	/**
	 * @param renderingProvIDQualREF01 the renderingProvIDQualREF01 to set
	 */
	public void setRenderingProvIDQualREF01(String renderingProvIDQualREF01) 
	{
		this.renderingProvIDQualREF01 = renderingProvIDQualREF01;
	}

	/**
	 * @param renderingProvIDREF02 the renderingProvIDREF02 to set
	 */
	public void setRenderingProvIDREF02(String renderingProvIDREF02) 
	{
		this.renderingProvIDREF02 = renderingProvIDREF02;
	}

	/**
	 * @param lineAllowedActualAmtAMT02 the lineAllowedActualAmtAMT02 to set
	 */
	public void setLineAllowedActualAmtAMT02(String lineAllowedActualAmtAMT02) 
	{
		this.lineAllowedActualAmtAMT02 = lineAllowedActualAmtAMT02;
	}

	/**
	 * @param lineSuppQtyQualQTY01 the lineSuppQtyQualQTY01 to set
	 */
	public void setLineSuppQtyQualQTY01(String lineSuppQtyQualQTY01) 
	{
		this.lineSuppQtyQualQTY01 = lineSuppQtyQualQTY01;
	}

	/**
	 * @param lineSuppQtyQTY02 the lineSuppQtyQTY02 to set
	 */
	public void setLineSuppQtyQTY02(String lineSuppQtyQTY02) 
	{
		this.lineSuppQtyQTY02 = lineSuppQtyQTY02;
	}

	/**
	 * @param lineRemarkCodeQualLQ01 the lineRemarkCodeQualLQ01 to set
	 */
	public void setLineRemarkCodeQualLQ01(String lineRemarkCodeQualLQ01) 
	{
		this.lineRemarkCodeQualLQ01 = lineRemarkCodeQualLQ01;
	}

	/**
	 * @param lineRemarkCodeLQ02 the lineRemarkCodeLQ02 to set
	 */
	public void setLineRemarkCodeLQ02(String lineRemarkCodeLQ02) 
	{
		this.lineRemarkCodeLQ02 = lineRemarkCodeLQ02;
	}

	/**
	 * @param remitSvcLinesTimestamp the remitSvcLinesTimestamp to set
	 */
	public void setRemitSvcLinesTimestamp(String remitSvcLinesTimestamp) 
	{
		this.remitSvcLinesTimestamp = remitSvcLinesTimestamp;
	}
	

	
}
