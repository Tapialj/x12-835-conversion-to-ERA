package x12835;

public class RemitProvAdjResultSet
{

	private String	rsnCode,
					refID;
	private double	adjAmt;
	
	/**
	 * @param rsnCode
	 * @param refID
	 * @param adjAmt
	 */
	public RemitProvAdjResultSet(String rsnCode, String refID, double adjAmt) 
	{
		this.rsnCode = rsnCode;
		this.refID = refID;
		this.adjAmt = adjAmt;
	}

	/**
	 * @return the rsnCode
	 */
	public String getRsnCode() 
	{
		return rsnCode;
	}

	/**
	 * @return the refID
	 */
	public String getRefID()
	{
		return refID;
	}

	/**
	 * @return the adjAmt
	 */
	public double getAdjAmt() 
	{
		return adjAmt;
	}

	/**
	 * @param rsnCode the rsnCode to set
	 */
	public void setRsnCode(String rsnCode) 
	{
		this.rsnCode = rsnCode;
	}

	/**
	 * @param refID the refID to set
	 */
	public void setRefID(String refID) 
	{
		this.refID = refID;
	}

	/**
	 * @param adjAmt the adjAmt to set
	 */
	public void setAdjAmt(double adjAmt) 
	{
		this.adjAmt = adjAmt;
	}
	
	
}
