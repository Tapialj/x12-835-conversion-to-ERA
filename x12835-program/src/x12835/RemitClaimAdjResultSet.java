package x12835;

public class RemitClaimAdjResultSet
{
	
	private String	rsnCode;
	private double	adjAmt;
	
	/**
	 * @param rsnCode
	 * @param adjAmt
	 */
	public RemitClaimAdjResultSet(String rsnCode, double adjAmt) 
	{
		this.rsnCode = rsnCode;
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
	 * @param adjAmt the adjAmt to set
	 */
	public void setAdjAmt(double adjAmt)
	{
		this.adjAmt = adjAmt;
	}

	
	
}
