package x12835;

public class ServiceLineDetailResultSet 
{

	private String	adjCode,
					rsnCode,
					adjAmt;

	/**
	 * @param adjCode
	 * @param rsnCode
	 * @param adjAmt
	 */
	public ServiceLineDetailResultSet(String adjCode, String rsnCode, String adjAmt) 
	{
		this.adjCode = adjCode;
		this.rsnCode = rsnCode;
		this.adjAmt = adjAmt;
	}

	/**
	 * @return the adjCode
	 */
	public String getAdjCode() 
	{
		return adjCode;
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
	public String getAdjAmt() 
	{
		return adjAmt;
	}

	/**
	 * @param adjCode the adjCode to set
	 */
	public void setAdjCode(String adjCode)
	{
		this.adjCode = adjCode;
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
	public void setAdjAmt(String adjAmt) 
	{
		this.adjAmt = adjAmt;
	}
	
	
	
}
