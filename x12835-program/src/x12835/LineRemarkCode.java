package x12835;

import java.util.Comparator;

public class LineRemarkCode 
{

	private String	pCode,
					newKey,
					pType;
	
	public LineRemarkCode(String pCode, String newKey, String pType)
	{
		this.pCode = pCode;
		this.newKey = newKey;
		this.pType = pType;
	}
	
	/**
	 * This sorts the  line codes in ascending order
	 */
	public static Comparator<LineRemarkCode> lineCodeComparator = new Comparator<LineRemarkCode>()
	{
		public int compare(LineRemarkCode lineCode1, LineRemarkCode lineCode2)
		{
			if(lineCode1 == null && lineCode2 == null)
			{
				return 0;
			}
			else if(lineCode1 == null)
			{
				return 1;
			}
			else if(lineCode2 == null)
			{
				return -1;
			}
			else
			{
				String code1 = lineCode1.getNewKey().toUpperCase();
				String code2 = lineCode2.getNewKey().toUpperCase();
			
				return code1.compareTo(code2);
			}
		}
	};

	/**
	 * @return the pCode
	 */
	public String getpCode() 
	{
		return pCode;
	}

	/**
	 * @return the newKey
	 */
	public String getNewKey() 
	{
		return newKey;
	}

	/**
	 * @return the pType
	 */
	public String getpType() 
	{
		return pType;
	}

	/**
	 * @param pCode the pCode to set
	 */
	public void setpCode(String pCode) 
	{
		this.pCode = pCode;
	}

	/**
	 * @param newKey the newKey to set
	 */
	public void setNewKey(String newKey) 
	{
		this.newKey = newKey;
	}

	/**
	 * @param pType the pType to set
	 */
	public void setpType(String pType) 
	{
		this.pType = pType;
	}
	
}
