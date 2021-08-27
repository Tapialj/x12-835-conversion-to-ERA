package x12835;

public class TotalDollarAmounts 
{

	private double	totalBilledAmt,
					totalAllowedAmt,
					totalPaidAmt,
					totalPRCodeAmt;
	//may add these doubles as well depending on needs totalClaimBilleAmt, totalClaimAllowedAmt, totalClaimPaidAmt;
	//may also add these doubles for service line totals only eg totalSVCBilledAmt ect

	/**
	 * @param totalBilledAmt
	 * @param totalAllowedAmt
	 * @param totalPaidAmt
	 * @param totalPRCodeAmt
	 */
	public TotalDollarAmounts(double totalBilledAmt, double totalAllowedAmt, double totalPaidAmt, double totalPRCodeAmt) 
	{
		this.totalBilledAmt = totalBilledAmt;
		this.totalAllowedAmt = totalAllowedAmt;
		this.totalPaidAmt = totalPaidAmt;
		this.totalPRCodeAmt = totalPRCodeAmt;
	}

	/**
	 * @return the totalBilledAmt
	 */
	public double getTotalBilledAmt() 
	{
		return totalBilledAmt;
	}

	/**
	 * @return the totalAllowedAmt
	 */
	public double getTotalAllowedAmt() 
	{
		return totalAllowedAmt;
	}

	/**
	 * @return the totalPaidAmt
	 */
	public double getTotalPaidAmt() 
	{
		return totalPaidAmt;
	}

	/**
	 * @return the totalPRCodeAmt
	 */
	public double getTotalPRCodeAmt() 
	{
		return totalPRCodeAmt;
	}

	/**
	 * @param totalBilledAmt the totalBilledAmt to set
	 */
	public void setTotalBilledAmt(double totalBilledAmt) 
	{
		this.totalBilledAmt = totalBilledAmt;
	}

	/**
	 * @param totalAllowedAmt the totalAllowedAmt to set
	 */
	public void setTotalAllowedAmt(double totalAllowedAmt) 
	{
		this.totalAllowedAmt = totalAllowedAmt;
	}

	/**
	 * @param totalPaidAmt the totalPaidAmt to set
	 */
	public void setTotalPaidAmt(double totalPaidAmt) 
	{
		this.totalPaidAmt = totalPaidAmt;
	}

	/**
	 * @param totalPRCodeAmt the totalPRCodeAmt to set
	 */
	public void setTotalPRCodeAmt(double totalPRCodeAmt) 
	{
		this.totalPRCodeAmt = totalPRCodeAmt;
	}


}
