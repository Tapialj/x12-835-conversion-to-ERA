package x12835;

public class EobResult 
{

	private String	subAcctNo,
					subStatus,
					provTaxID,
					dateTime,
					status,
					result,
					outStatus,
					target,
					actual,
					headerID;
	private int		numberClaims,
					eobSelected,
					eobBuilt;
	private boolean	provTaxIDFound,
					enrolledInService;
	
	/**
	 * @param subAcctNo
	 * @param subStatus
	 * @param provTaxID
	 * @param dateTime
	 * @param headerID
	 * @param numberClaims
	 * @param status The submitter account activity status e.g. Active or Closed
	 * @param result The result of the process ie Failed or Success
	 * @param outStatus The IO status e.g. Renamed file
	 * @param target Target output filename
	 * @param actual Actual output filename
	 */
	public EobResult(String subAcctNo, String subStatus, String provTaxID, String dateTime, String headerID, int numberClaims, int eobSelected, 
			int eobBuilt, String status, String result, String outStatus, String target, String actual, boolean provTaxIDFound, boolean enrolledInService) 
	{
		this.subAcctNo = subAcctNo;
		this.subStatus = subStatus;
		this.provTaxID = provTaxID;
		this.dateTime = dateTime;
		this.headerID = headerID;
		this.numberClaims = numberClaims;
		this.eobSelected = eobSelected;
		this.eobBuilt = eobBuilt;
		this.status = status;
		this.result = result;
		this.outStatus = outStatus;
		this.target = target;
		this.actual = actual;
		this.provTaxIDFound = provTaxIDFound;
		this.enrolledInService = enrolledInService;
	}

	/**
	 * @return the subAcctNo
	 */
	public String getSubAcctNo() 
	{
		return subAcctNo;
	}

	/**
	 * @return the subStatus
	 */
	public String getSubStatus() 
	{
		return subStatus;
	}

	/**
	 * @return the provTaxID
	 */
	public String getProvTaxID() 
	{
		return provTaxID;
	}

	/**
	 * @return the dateTime
	 */
	public String getDateTime() 
	{
		return dateTime;
	}

	/**
	 * @return the headerID
	 */
	public String getHeaderID() 
	{
		return headerID;
	}

	/**
	 * @return the numberClaims
	 */
	public int getNumberClaims() 
	{
		return numberClaims;
	}
	
	/**
	 * @return the eobSelected
	 */
	public int getEobSelected() 
	{
		return eobSelected;
	}
	
	/**
	 * @return the eobBuilt
	 */
	public int getEobBuilt() 
	{
		return eobBuilt;
	}

	/**
	 * @return the status
	 */
	public String getStatus() 
	{
		return status;
	}

	/**
	 * @return the result
	 */
	public String getResult() 
	{
		return result;
	}

	/**
	 * @return the outStatus
	 */
	public String getOutStatus() 
	{
		return outStatus;
	}

	/**
	 * @return the target
	 */
	public String getTarget() 
	{
		return target;
	}

	/**
	 * @return the actual
	 */
	public String getActual() 
	{
		return actual;
	}
	
	/**
	 * @return
	 */
	public boolean isProvTaxIDFound()
	{
		return provTaxIDFound;
	}
	
	/**
	 * @return
	 */
	public boolean isEnrolledInService()
	{
		return enrolledInService;
	}


	/**
	 * @param subAcctNo the subAcctNo to set
	 */
	public void setSubAcctNo(String subAcctNo)
	{
		this.subAcctNo = subAcctNo;
	}

	/**
	 * @param subStatus the subStatus to set
	 */
	public void setSubStatus(String subStatus)
	{
		this.subStatus = subStatus;
	}

	/**
	 * @param provTaxID the provTaxID to set
	 */
	public void setProvTaxID(String provTaxID)
	{
		this.provTaxID = provTaxID;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(String dateTime) 
	{
		this.dateTime = dateTime;
	}

	/**
	 * @param headerID the headerID to set
	 */
	public void setHeaderID(String headerID) 
	{
		this.headerID = headerID;
	}

	/**
	 * @param numberClaims the numberClaims to set
	 */
	public void setNumberClaims(int numberClaims) 
	{
		this.numberClaims = numberClaims;
	}
	
	/**
	 * @param eobSelected the eobSelected to set
	 */
	public void setEobSelected(int eobSelected) 
	{
		this.eobSelected = eobSelected;
	}
	
	/**
	 * @param eobBuilt the eobBuilt to set
	 */
	public void setEobBuilt(int eobBuilt) 
	{
		this.eobBuilt = eobBuilt;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) 
	{
		this.status = status;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) 
	{
		this.result = result;
	}

	/**
	 * @param outStatus the outStatus to set
	 */
	public void setOutStatus(String outStatus) 
	{
		this.outStatus = outStatus;
	}

	/**
	 * @param target the target to set
	 */
	public void setTarget(String target) 
	{
		this.target = target;
	}

	/**
	 * @param actual the actual to set
	 */
	public void setActual(String actual) 
	{
		this.actual = actual;
	}
	
	public void setProvTaxIDFound(boolean provTaxIDFound)
	{
		this.provTaxIDFound = provTaxIDFound;
	}
	
	public void setEnrolledInService(boolean enrolledInService)
	{
		this.enrolledInService = enrolledInService;
	}

}
