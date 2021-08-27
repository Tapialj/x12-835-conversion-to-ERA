package x12835;

import java.util.Comparator;

public class TotalAdjAmt 
{

	private String	key;
	private int		idx;
	private double	total,
					prCodeAmt;
	
	/**
	 * @param idx
	 * @param pKey
	 * @param pAmt
	 * @param prCodeAmt
	 */
	public TotalAdjAmt(int idx, String key, double total, double prCodeAmt) 
	{
		this.idx = idx;
		this.key = key;
		this.total = total;
		this.prCodeAmt = prCodeAmt;
	}
	
	/**
	 * This is to sort the object list in ascending order
	 */
	public static Comparator<TotalAdjAmt> adjAmtKeyComparator = new Comparator<TotalAdjAmt>()
	{
		public int compare(TotalAdjAmt adjAmt1, TotalAdjAmt adjAmt2)
		{
			if(adjAmt1 == null && adjAmt2 == null)
			{
				return 0;
			}
			else if(adjAmt1 == null)
			{
				return 1;
			}
			else if(adjAmt2 == null)
			{
				return -1;
			}
			else
			{
				String key1 = adjAmt1.getKey().toUpperCase();
				String key2 = adjAmt2.getKey().toUpperCase();
			
				return key1.compareTo(key2);
			}
		}
	};
	
	/**
	 * @return the idx
	 */
	public int getIdx() 
	{
		return idx;
	}
	
	/**
	 * @return the pKey
	 */
	public String getKey() 
	{
		return key;
	}
	
	/**
	 * @return the pAmt
	 */
	public double getTotal() 
	{
		return total;
	}
	
	/**
	 * @return the prCodeAmt
	 */
	public double getPrCodeAmt()
	{
		return prCodeAmt;
	}
	
	/**
	 * @param idx the idx to set
	 */
	public void setIdx(int idx) 
	{
		this.idx = idx;
	}
	
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) 
	{
		this.key = key;
	}
	
	/**
	 * @param pAmt the total to set
	 */
	public void setTotal(double total) 
	{
		this.total = total;
	}
	
	/**
	 * @param prCodeAmt the prCodeAmt to set
	 */
	public void setPrCodeAmt(double prCodeAmt)
	{
		this.prCodeAmt = prCodeAmt;
	}
	
}
