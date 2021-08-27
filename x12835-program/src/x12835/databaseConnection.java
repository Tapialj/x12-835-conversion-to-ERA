package x12835;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * This class contains constructor, getters, setters, and other methods related to database connectivity
 * @author lewist
 */
public class databaseConnection 
{
	private int		connTimeout,
					cmdTimeout;
	private String	databaseName,
					jdbcServerUrl;
	private Connection	conn;

	/**
	 * This is the constructor for the MSSQL database connection
	 * @param connTimeout The connection timeout
	 * @param cmdTimeout The command timeout
	 * @param jdbcServerUrl The server url set up for the JDBC driver
	 * @param databaseName The database name to be used
	 */
	public databaseConnection(int connTimeout, int cmdTimeout, String jdbcServerUrl, String databaseName) throws SQLTimeoutException, SQLException, ClassNotFoundException
	{
		this.connTimeout = connTimeout;
		this.cmdTimeout = cmdTimeout;
		this.jdbcServerUrl = jdbcServerUrl;		
		this.databaseName = databaseName;
		this.conn = msSQLDatabaseConnect(connTimeout,jdbcServerUrl,databaseName);
	}
	
	/**
	 * This is the constructor for the MySQL database connection
	 * @param connTimeout The connection timeout
	 * @param cmdTimeout The command timeout
	 * @param jdbcServerUrl The server url set up for the JDBC driver
	 * @param databaseName The database name to be used
	 * @param mySQL this is added to overload the contructor to determine which is the mssql and which is the mysql constructor
	 */
	public databaseConnection(int connTimeout, int cmdTimeout, String jdbcServerUrl, String databaseName, String mySQL) throws SQLTimeoutException, SQLException, ClassNotFoundException
	{
		this.connTimeout = connTimeout;
		this.cmdTimeout = cmdTimeout;
		this.jdbcServerUrl = jdbcServerUrl;		
		this.databaseName = databaseName;
		this.conn = mySQLDatabaseConnect(connTimeout,jdbcServerUrl,databaseName);
	}	

	/**
	 * This sets up the MS SQL database connection
	 * @param connTimeout The connection timeout
	 * @param jdbcServerUrl The database server URL to connect to
	 * @param databaseName The database name to be used
	 * @return The database connection for MS SQL
	 * @throws SQLTimeoutException Thrown if a timeout happens, throw a new and catch in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, throw a new and catch in main method for error handling
	 * @throws ClassNotFoundException Thrown if the Class.forName does not exist, throw a new and catch in main method for error handling
	 */
	private Connection msSQLDatabaseConnect(int connTimeout, String jdbcServerUrl, String databaseName) throws SQLTimeoutException, SQLException, ClassNotFoundException
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Properties props = new Properties();
			props.setProperty("user","sa");
			props.setProperty("password","VR75!aeB");
			DriverManager.setLoginTimeout(connTimeout);
			conn = DriverManager.getConnection(jdbcServerUrl + "databaseName=" + databaseName,props);
		}
		catch (SQLTimeoutException t) 
    	{
			throw new SQLTimeoutException("databaseConnection.msSQLDatabaseConnect: " + t.getMessage());
    	}
		catch (SQLException e)
		{
			throw new SQLException("databaseConnection.msSQLDatabaseConnect: " + e.getMessage());
		}
		catch (ClassNotFoundException c)
		{
			throw new ClassNotFoundException("databaseConnection.msSQLDatabaseConnect: " + c.getMessage());
		}
		
		return conn;
	}
	
	/**
	 * This sets up the database connection for MySQL
	 * @param connTimeout The connection timeout
	 * @param jdbcServerUrl The database server URL to connect to
	 * @param databaseName The database name to be used
	 * @return The database connection for MS SQL
	 * @throws SQLTimeoutException Thrown if a timeout happens, throw a new and catch in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, throw a new and catch in main method for error handling
	 * @throws ClassNotFoundException Thrown if the Class.forName does not exist, throw a new and catch in main method for error handling
	 */
	private Connection mySQLDatabaseConnect(int connTimeout, String jdbcServerUrl, String databaseName) throws SQLTimeoutException, SQLException, ClassNotFoundException
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Properties props = new Properties();
			props.setProperty("user","eccs_app");
			props.setProperty("password","ascii");
			DriverManager.setLoginTimeout(connTimeout);
			conn = DriverManager.getConnection(jdbcServerUrl + databaseName,props);
		}
		catch (SQLTimeoutException t) 
    	{
			throw new SQLTimeoutException("databaseConnection.mySQLDatabaseConnect: " + t.getMessage());
    	}
		catch (SQLException e)
		{
			throw new SQLException("databaseConnection.mySQLDatabaseConnect: " + e.getMessage());
		}
		catch (ClassNotFoundException c)
		{
			throw new ClassNotFoundException("databaseConnection.mySQLDatabaseConnect: " + c.getMessage());
		}
		
		return conn;
	}
	
	/**
	 * This closes the connection when done with the database
	 * @throws SQLException Thrown for any possible exception, throw new and catch in main method for error handling
	 */
	public void closeConnection() throws SQLException
	{ 
		try 
		{
			this.conn.close();
		} 
		catch (SQLException e) 
		{
			throw new SQLException("databaseConnection.closeConnection: " + e.getMessage());
		}
	}
	
	/**
	 * This queries the database for the Job Name of the X12 835 job to run
	 * @param sqlQuery The query for the job name
	 * @return A JobDataResultSet object containing all the information for the job
	 * @throws SQLTimeoutException Thrown if a timeout happens, throw a new and catch in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, throw a new and catch in main method for error handling
	 */
	public JobDataResultSet queryJobName(String sqlQuery) throws SQLTimeoutException, SQLException
	{
		Statement stmt = null;
		ResultSet results = null;
		JobDataResultSet jobResultSet = null;
		
		try
		{
			stmt = conn.createStatement();
			stmt.setQueryTimeout(this.cmdTimeout);
			results = stmt.executeQuery(sqlQuery);
			results.next();
				
			jobResultSet = new JobDataResultSet(results.getString("job_name"),results.getString("job_type"),results.getString("sql_select"),results.getString("fp_sys_dsn"),
					results.getString("built_status_mark"),results.getString("data_rpt_delim"),results.getString("prov_tax_id_mark"),results.getString("sub_835_enrollment_mark"),results.getString("sub_835_enrollment_data_mark"),
					results.getString("sub_inactive_mark"),results.getString("sub_cancelled_mark"),results.getString("sub_credit_hold_mark"),results.getString("sub_closed_mark"),
					results.getString("header_claim_amt_paid_mark"),results.getString("web_desc"),results.getString("output_path"),results.getString("fs1"),results.getString("fp1"),
					results.getString("fs2"),results.getString("fp2"),results.getString("fs3"),results.getString("fp3"),results.getString("fs4"),results.getString("fp4"),results.getString("fs5"),
					results.getString("fp5"),results.getString("fs6"),results.getString("fp6"),results.getString("fs7"),results.getString("f_ext"),results.getString("file_exists_output_rule"),
					results.getString("inc_char"),results.getString("file_error_mark"),results.getString("temp_path"),results.getString("temp_filename"),results.getString("em_suc_recip"),results.getString("em_suc_fn"),
					results.getString("em_suc_fa"),results.getString("em_some_recip"),results.getString("em_some_fn"),results.getString("em_some_fa"),results.getString("em_zero_recip"),
					results.getString("em_zero_fn"),results.getString("em_zero_fa"),results.getString("em_err_recip"),results.getString("em_err_fn"),results.getString("em_err_fa"),
					results.getString("em_show_style"),results.getString("wm_show_style"),results.getString("im_show_style"),results.getString("fo_recip"),results.getString("fo_from_name"),
					results.getString("fo_from_addr"),results.getString("fo_smtp_pri"),results.getString("fo_smtp_alt"),results.getString("fp_cn_timeout"),results.getString("fp_cd_timeout"),
					results.getString("serial_no_lookup_cd_timeout"),results.getString("cn_timeout"),results.getString("cd_timeout"),results.getString("job_disabled"),results.getString("include_col_head"),
					results.getString("serial_no_lookup"),results.getString("prov_tax_id_rollback"),results.getString("sub_835_enrollment_rollback"),results.getString("sub_835_enrollment_data_rollback"),
					results.getString("post_sub_inactive_rpt"),results.getString("post_sub_cancelled_rpt"),results.getString("post_sub_credit_hold_rpt"),results.getString("post_sub_closed_rpt"),
					results.getString("verify_header_claim_amt_paid"),results.getString("header_claim_amt_paid_rollback"),results.getString("use_lead_zero"),results.getString("em_suc_enabled"),
					results.getString("em_some_enabled"),results.getString("em_zero_enabled"),results.getString("em_err_enabled"),results.getString("em_owned"),results.getString("wm_owned"),
					results.getString("im_owned"));			
		}
		catch (SQLTimeoutException t) 
    	{
			throw new SQLTimeoutException("databaseConnection.queryJobName: " + t.getMessage());
    	}
		catch (SQLException e)
		{
			throw new SQLException("databaseConnection.queryJobName: " + e.getMessage());
		}
		finally 
    	{
	        try {
	            if (results != null) 
	            {
	            	results.close();
	            }
	            if (stmt != null) 
	            {
	                stmt.close();
	            }
	        } 
	        catch (SQLException e) 
	        {
	        	throw new SQLException("databaseConnection.queryJobName: " + e.getMessage());
	        }
	    }

		return jobResultSet;
	}
	
	/**
	 * This queries the Remittance Header table based off of the query in the x12 835 job
	 * @param sqlHeaderQuery The query to select a header from the x12 835 job
	 * @param eobResult Passed to gather the header count if more than 1 is selected
	 * @return An array list of RemitHeaderResultSet containing all the information from the header(s) selected
	 * @throws SQLTimeoutException Thrown if a timeout happens, throw a new and catch in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, throw a new and catch in main method for error handling
	 */
	public ArrayList<RemitHeaderResultSet> sqlHeaderSelect(String sqlHeaderQuery, EobResult eobResult) throws SQLTimeoutException, SQLException
	{
		int	count = 0;
		RemitHeaderResultSet headerResultSet = null;
		ArrayList<RemitHeaderResultSet> remitHeaderList = new ArrayList<RemitHeaderResultSet>();
		Statement stmt = null;
		ResultSet results = null;
		
		try
		{
			stmt = conn.createStatement();
			stmt.setQueryTimeout(this.cmdTimeout);
			results = stmt.executeQuery(sqlHeaderQuery);
			
			while(results.next())
			{
				headerResultSet = new RemitHeaderResultSet(results.getString("remittance_header_id"),results.getString("remittance_upd_ind"),results.getString("trans_control_no_ST02"),
						results.getString("trans_handling_code_BPR01"),results.getString("total_pmt_amt_BPR02"),results.getString("credit_debit_flag_BPR03"),results.getString("pmt_method_code_BPR04"),
						results.getString("send_aba_no_BPR07"),results.getString("send_bank_acct_no_BPR09"),results.getString("payer_identifier_BRP10"),results.getString("receiver_aba_no_BPR13"),
						results.getString("rec_bank_acct_no_BPR15"),results.getString("pmt_issue_date_BPR16"),results.getString("trace_no_TRN02"),results.getString("payer_identifier_TRN03"),
						results.getString("production_date_DTM02"),results.getString("payer_name_N102"),results.getString("payer_address_1_N301"),results.getString("payer_address_2_N302"),
						results.getString("payer_city_N401"),results.getString("payer_state_N402"),results.getString("payer_zip_N403"),results.getString("payer_ref_qualifier_REF01"),
						results.getString("payer_id_REF02"),results.getString("payer_con_name_PER02"),results.getString("payer_com_no_qual_PER03"),results.getString("payer_com_no_PER04"),
						results.getString("payer_com_no_qual_PER05"),results.getString("payer_com_no_PER06"),results.getString("payee_name_N102"),results.getString("payee_id_qualifier_N103"),
						results.getString("payee_id_code_N104"),results.getString("payee_address_1_N301"),results.getString("payee_address_2_N302"),results.getString("payee_city_N401"),
						results.getString("payee_state_N402"),results.getString("payee_zip_N403"),results.getString("payee_add_id_qual_REF01"),results.getString("payee_add_id_code_REF02"),
						results.getString("remittance_header_timestamp"),results.getString("date_time_translated"),results.getString("eob_report_status"),results.getString("eob_report_error_num"),
						results.getString("eob_report_error_reason"),results.getString("eob_report_error_source"),results.getString("eob_sub_acct_no"),results.getString("eob_report_create_datetime"),
						results.getString("eob_report_run_datetime"),false);
				
				remitHeaderList.add(headerResultSet);
				count++;
			}
			
			eobResult.setEobSelected(count);
	    } 
		catch (SQLTimeoutException t) 
    	{
			throw new SQLTimeoutException("databaseConnection.sqlHeaderSelect: " + t.getMessage());
    	}
		catch (SQLException e)
		{
			throw new SQLException("databaseConnection.sqlHeaderSelect: " + e.getMessage());
		}
		finally 
    	{
	        try {
	            if (results != null) 
	            {
	            	results.close();
	            }
	            if (stmt != null) 
	            {
	                stmt.close();
	            }
	        } 
	        catch (SQLException e) 
	        {
	        	throw new SQLException("databaseConnection.sqlHeaderSelect: " + e.getMessage());
	        }
	    }
		    
		return remitHeaderList;
	}
	
	/**
	 * This queries the provider table and 835 cross reference table for a submitter account number based off of the NPI or tax ID
	 * @param payeeIDN104 The NPI, Group NPI, or tax ID from the header table
	 * @param eobResult Passed to pick up if a submitter account was found, what ID was used, and what the submitter account number is
	 * @throws SQLTimeoutException Thrown if a timeout happens, throw a new and catch in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, throw a new and catch in main method for error handling
	 */
	public void queryProvTaxID(String payeeIDN104, EobResult eobResult) throws SQLTimeoutException, SQLException
	{
		String	queryCrossRef = "select prov_acct_no from era_provider_835_xref with (NOLOCK) where tax_id_no = '" + payeeIDN104 + "'",
				queryProvTaxID = "select top 1 submitter_element from provider with (NOLOCK) where tax_id_no = '" + payeeIDN104 + "' order by prov_status_element asc",
				queryProv835SecID = "select top 1 submitter_element from provider with (NOLOCK) where x12_835_sec_id = '" + payeeIDN104 + "' order by prov_status_element asc",
				queryProvNPI = "select top 1 submitter_element from provider with (NOLOCK) where (NPI = '" + payeeIDN104 + "' or NPI_group = '" + payeeIDN104 + "') order by prov_status_element asc";
		Statement stmt = null;
		ResultSet results = null;

		try
		{
			stmt = conn.createStatement();
			stmt.setQueryTimeout(this.cmdTimeout);
			results = stmt.executeQuery(queryCrossRef);
			
			if (results.isBeforeFirst())
			{
				results.next();
				eobResult.setProvTaxIDFound(true);
				eobResult.setProvTaxID(payeeIDN104);
				eobResult.setSubAcctNo(results.getString("prov_acct_no").trim().substring(0,6));
			}
			else
			{
				results = stmt.executeQuery(queryProvTaxID);
				if (results.isBeforeFirst())
				{
					results.next();
					eobResult.setProvTaxIDFound(true);
					eobResult.setProvTaxID(payeeIDN104);
					eobResult.setSubAcctNo(results.getString("submitter_element").trim());
				}
				else
				{
					results = stmt.executeQuery(queryProv835SecID);
					if (results.isBeforeFirst()) 
					{
						results.next();
						eobResult.setProvTaxIDFound(true);
						eobResult.setProvTaxID(payeeIDN104);
						eobResult.setSubAcctNo(results.getString("submitter_element").trim());
					}
					else
					{
						results = stmt.executeQuery(queryProvNPI);
						if (results.isBeforeFirst()) 
						{
							results.next();
							eobResult.setProvTaxIDFound(true);
							eobResult.setProvTaxID(payeeIDN104);
							eobResult.setSubAcctNo(results.getString("submitter_element").trim());
						}
						else
						{
							eobResult.setProvTaxIDFound(false);
							eobResult.setProvTaxID(payeeIDN104);
							eobResult.setSubAcctNo("Unknown");
						}
					}
				}
			}
	    } 
		catch (SQLTimeoutException t) 
    	{
			throw new SQLTimeoutException("databaseConnection.queryProvTaxID: " + t.getMessage());
    	}
		catch (SQLException e)
		{
			throw new SQLException("databaseConnection.queryProvTaxID: " + e.getMessage());
		}
		finally 
    	{
	        try {
	            if (results != null) 
	            {
	            	results.close();
	            }
	            if (stmt != null) 
	            {
	                stmt.close();
	            }
	        } 
	        catch (SQLException e) 
	        {
	        	throw new SQLException("databaseConnection.queryProvTaxID: " + e.getMessage());
	        }
	    }
	}
	
	/**
	 * Queries submitter table based off of submitter account number to check 835 enrollment status
	 * @param eobResult Passed to pick up the enrollment status and the account status (eg. Closed, Active)
	 * @throws SQLTimeoutException Thrown if a timeout happens, throw a new and catch in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, throw a new and catch in main method for error handling
	 */
	public void sub835EnrollmentLookUp(EobResult eobResult) throws SQLTimeoutException, SQLException
	{
		String queryEnrollment = "select x12_835_rpt_enrollment, sub_status_element from submitter with (NOLOCK) where sub_acct_no = '" + eobResult.getSubAcctNo() + "'";
		Statement stmt = null;
		ResultSet results = null;
		
		try
		{
			stmt = conn.createStatement();
			stmt.setQueryTimeout(this.cmdTimeout);
			results = stmt.executeQuery(queryEnrollment);
			
			if (results.isBeforeFirst())
			{
				results.next();
				eobResult.setEnrolledInService((results.getString("x12_835_rpt_enrollment").trim().equalsIgnoreCase("Y")) ? true : false);
				eobResult.setSubStatus(results.getString("sub_status_element"));
			}
	    } 
		catch (SQLTimeoutException t) 
    	{
			throw new SQLTimeoutException("databaseConnection.sub835EnrollmentLookUp: " + t.getMessage());
    	}
		catch (SQLException e)
		{
			throw new SQLException("databaseConnection.sub835EnrollmentLookUp: " + e.getMessage());
		}
		finally 
    	{
	        try {
	            if (results != null) 
	            {
	            	results.close();
	            }
	            if (stmt != null) 
	            {
	                stmt.close();
	            }
	        } 
	        catch (SQLException e) 
	        {
	        	throw new SQLException("databaseConnection.sub835EnrollmentLookUp: " + e.getMessage());
	        }
	    }
	}
	
	/**
	 * This queries the Remittance claim table based off of the header ID from the header table
	 * @param headerResults The header result set for the header ID needed to query
	 * @param eobResult Passed to pick up the number of claims
	 * @return An ArrayList of RemitClaimResultSet containing the information for each row returned from the claim table
	 * @throws SQLTimeoutException Thrown if a timeout happens, throw a new and catch in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, throw a new and catch in main method for error handling
	 */
	public ArrayList<RemitClaimResultSet> remitClaimQuery(RemitHeaderResultSet headerResults, EobResult eobResult) throws SQLTimeoutException, SQLException
	{
		int		claimCount = 0;
		String 	queryRemitClaim = "select * from remittance_claim where header_id = '" + headerResults.getHeaderID() + "' order by pat_last_nm103 asc, pat_first_nm104 asc, pat_middle_nm105 asc";
		String 	queryRemitClaimCount = "select Count(*) from remittance_claim where header_id = '" + headerResults.getHeaderID() + "'";
		Statement 	stmt = null;
		ResultSet 	results = null,
					count = null;;
		RemitClaimResultSet remitClaimResults = null;
		ArrayList<RemitClaimResultSet> remitClaimList = null;

		try
		{
			stmt = conn.createStatement();
			stmt.setQueryTimeout(this.cmdTimeout);
			count = stmt.executeQuery(queryRemitClaimCount);
			count.next();
			eobResult.setNumberClaims(count.getInt(1));
			claimCount = count.getInt(1);
			remitClaimList = new ArrayList<RemitClaimResultSet>(claimCount);
			
			results = stmt.executeQuery(queryRemitClaim);
			
			while(results.next())
			{	
				remitClaimResults = new RemitClaimResultSet(results.getString("remittance_claim_id"),results.getString("header_id"),results.getString("claim_no"),results.getString("patient_acct_no_CLP01"),
						results.getString("claim_status_code_CLP02"),results.getString("claim_charge_amt_CLP03"),results.getString("claim_pmt_amt_CLP04"),results.getString("pat_responsibility_amt_CLP05"),
						results.getString("claim_filing_code_CLP06"),results.getString("payer_control_no_CLP07"),results.getString("remittance_claim_adj_id_CAS"),results.getString("pat_last_NM103"),
						results.getString("pat_first_NM104"),results.getString("pat_middle_NM105"),results.getString("pat_id_code_qual_NM108"),results.getString("pat_id_code_NM109"),
						results.getString("subscriber_last_NM103"),results.getString("subscriber_first_NM104"),results.getString("subscriber_middle_NM105"),results.getString("subscriber_id_code_qual_NM108"),
						results.getString("subscriber_id_code_NM109"),results.getString("corrected_last_NM103"),results.getString("corrected_first_NM104"),results.getString("corrected_middle_NM105"),
						results.getString("corrected_id_code_qual_NM108"),results.getString("corrected_id_code_NM109"),results.getString("svc_provider_last_NM103"),results.getString("svc_provider_first_NM104"),
						results.getString("svc_provider_middle_NM105"),results.getString("svc_prov_id_code_qual_NM108"),results.getString("svc_prov_id_code_NM109"),results.getString("crossover_carrier_name_NM103"),
						results.getString("crossover_id_code_qual_NM108"),results.getString("crossover_id_code_NM109"),results.getString("priority_payer_name_NM103"),results.getString("priority_pyr_id_cde_qual_NM108"),
						results.getString("priority_pyr_id_cde_NM109"),results.getString("reimbursement_rate_MOA01"),results.getString("hcpcs_payable_amt_MOA02"),results.getString("remark_code_1_MOA03"),
						results.getString("remark_code_2_MOA04"),results.getString("remark_code_3_MOA05"),results.getString("remark_code_4_MOA06"),results.getString("remark_code_5_MOA07"),
						results.getString("esrd_pmt_amt_MOA08"),results.getString("nonpay_prof_amt_MOA09"),results.getString("other_claim_ref_id_qual_REF01"),results.getString("other_claim_id_no_REF02"),
						results.getString("rend_prov_id_qual_REF01"),results.getString("rend_prov_id_no_REF02"),results.getString("claim_rec_date_DTM02"),results.getString("claim_start_date_DTM02"),
						results.getString("claim_end_date_DTM02"),results.getString("claim_supp_amt_qual_AMT01"),results.getString("claim_supp_amt_AMT02"),results.getString("claim_supp_qty_qual_QTY01"),
						results.getString("claim_supp_qty_QTY02"),results.getString("remittance_claim_timestamp"),false,false);
			
				remitClaimList.add(remitClaimResults);
			}
	    } 
		catch (SQLTimeoutException t) 
    	{
			throw new SQLTimeoutException("databaseConnection.remitClaimQuery: " + t.getMessage());
    	}
		catch (SQLException e)
		{
			throw new SQLException("databaseConnection.remitClaimQuery: " + e.getMessage());
		}
		finally 
    	{
	        try {
	            if (results != null) 
	            {
	            	results.close();
	            }
	            if (stmt != null) 
	            {
	                stmt.close();
	            }
	        } 
	        catch (SQLException e) 
	        {
	        	throw new SQLException("databaseConnection.remitClaimQuery: " + e.getMessage());
	        }
	    }
		
		return remitClaimList;
	}
	
	/**
	 * This queries for start and end dates based on query passed
	 * @param dateQuery The query for the start or end date of the claim
	 * @param tableElement Either 'sd' or 'ed' based on either start date or end date
	 * @return The date queried for, either start or end date
	 * @throws SQLTimeoutException Thrown if a timeout happens, throw a new and catch in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, throw a new and catch in main method for error handling
	 */
	public String claimDateQuery(String dateQuery, String tableElement) throws SQLTimeoutException, SQLException
	{
		String date = "";
		Statement stmt = null;
		ResultSet results = null;
	
		try
		{
			stmt = conn.createStatement();
			stmt.setQueryTimeout(this.cmdTimeout);
			results = stmt.executeQuery(dateQuery);
			
			if (results.isBeforeFirst())
			{
				results.next();
				date = results.getString(tableElement).trim();
			}
			else
			{
				date = "";
			}
	    } 
		catch (SQLTimeoutException t) 
    	{
			throw new SQLTimeoutException("databaseConnection.claimDateQuery: " + t.getMessage());
    	}
		catch (SQLException e)
		{
			throw new SQLException("databaseConnection.claimDateQuery: " + e.getMessage());
		}
		finally 
    	{
	        try {
	            if (results != null) 
	            {
	            	results.close();
	            }
	            if (stmt != null) 
	            {
	                stmt.close();
	            }
	        } 
	        catch (SQLException e) 
	        {
	        	throw new SQLException("databaseConnection.claimDateQuery: " + e.getMessage());
	        }
	    }

		return date;
	}
	
	/**
	 * Queries for rendering provider for the specific claim from Remit Claim table
	 * @param remitClaimResults The remitClaimResults object, needed for claim number to query
	 * @return The rendering provider NPI or tax ID, NONE if none found
	 * @throws SQLTimeoutException Thrown if a timeout happens, throw a new and catch in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, throw a new and catch in main method for error handling
	 */
	public String queryRendProvID(RemitClaimResultSet remitClaimResults) throws SQLTimeoutException, SQLException
	{
		String 	rendProvIDQuery = "select top 1 rendering_prov_id_ref02 from remittance_svc_lines where claim_no = '" + remitClaimResults.getClaimNo() + "' and rendering_prov_id_ref02 <> ''",
				rendProvID = "";
		Statement 	stmt = null;
		ResultSet 	results = null;
		
		try
		{
			stmt = conn.createStatement();
			stmt.setQueryTimeout(this.cmdTimeout);
			results = stmt.executeQuery(rendProvIDQuery);
			
			if (results.isBeforeFirst())
			{
				results.next();
				rendProvID = results.getString("rendering_prov_id_ref02").trim();
			}
			else
			{
				if(!remitClaimResults.getSvcProvIDCodeNM109().trim().isEmpty())
				{
					rendProvID = remitClaimResults.getSvcProvIDCodeNM109().trim();
				}
				else
				{
					rendProvID = "NONE";
				}
			}
	    } 
		catch (SQLTimeoutException t) 
    	{
			throw new SQLTimeoutException("databaseConnection.queryRendProvID: " + t.getMessage());
    	}
		catch (SQLException e)
		{
			throw new SQLException("databaseConnection.queryRendProvID: " + e.getMessage());
		}
		finally 
    	{
	        try {
	            if (results != null) 
	            {
	            	results.close();
	            }
	            if (stmt != null) 
	            {
	                stmt.close();
	            }
	        } 
	        catch (SQLException e) 
	        {
	        	throw new SQLException("databaseConnection.queryRendProvID: " + e.getMessage());
	        }
	    }
		
		return rendProvID;
	}
	
	/**
	 * This queries for the service line(s) associated with the specific claim from the claim table
	 * @param claimNo The claim number associated with the service line(s)
	 * @return An ArrayList of RemitServiceLineResultSet containing all information returned from query
	 * @throws SQLTimeoutException Thrown if a timeout happens, throw a new and catch in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, throw a new and catch in main method for error handling
	 */
	public ArrayList<RemitServiceLineResultSet> queryServiceLine(String claimNo) throws SQLTimeoutException, SQLException
	{
		String 	serviceLineQuery = "select * from remittance_svc_lines where claim_no = '" + claimNo + "' order by line_no asc";
		Statement 	stmt = null;
		ResultSet 	results = null;
		RemitServiceLineResultSet serviceLineResults = null;
		ArrayList<RemitServiceLineResultSet> serviceLineList = new ArrayList<RemitServiceLineResultSet>();
		
		try
		{
			stmt = conn.createStatement();
			stmt.setQueryTimeout(this.cmdTimeout);
			results = stmt.executeQuery(serviceLineQuery);
			
			while(results.next())
			{				
				serviceLineResults = new RemitServiceLineResultSet(results.getString("remittance_svc_lines_id"),results.getString("claim_no"),results.getString("line_no"),
						results.getString("procedure_code_SVC01_2"),results.getString("procedure_mod_1_SVC01_3"),results.getString("procedure_mod_2_SVC01_4"),
						results.getString("procedure_mod_3_SVC01_5"),results.getString("procedure_mod_4_SVC01_6"),results.getString("line_charge_SVC02"),
						results.getString("line_pmt_amt_SVC03"),results.getString("nubc_revenue_code_SVC04"),results.getString("line_qty_paid_SVC05"),
						results.getString("line_orig_qty_SVC07"),results.getString("line_service_date_DTM02"),results.getString("line_service_date_start_DTM02"),
						results.getString("line_service_date_end_DTM02"),results.getString("remittance_line_adj_id_CAS"),results.getString("service_id_qual_REF01"),
						results.getString("service_id_REF02"),results.getString("rendering_prov_id_qual_REF01"),results.getString("rendering_prov_id_REF02"),
						results.getString("line_allowed_actual_amt_AMT02"),results.getString("line_supp_qty_qual_QTY01"),results.getString("line_supp_qty_QTY02"),
						results.getString("line_remark_code_qual_LQ01"),results.getString("line_remark_code_LQ02"),results.getString("remittance_svc_lines_timestamp"));
				serviceLineList.add(serviceLineResults);
			}
	    } 
		catch (SQLTimeoutException t) 
    	{
			throw new SQLTimeoutException("databaseConnection.queryServiceLine: " + t.getMessage());
    	}
		catch (SQLException e)
		{
			throw new SQLException("databaseConnection.queryServiceLine: " + e.getMessage());
		}
		finally 
    	{
	        try {
	            if (results != null) 
	            {
	            	results.close();
	            }
	            if (stmt != null) 
	            {
	                stmt.close();
	            }
	        } 
	        catch (SQLException e) 
	        {
	        	throw new SQLException("databaseConnection.queryServiceLine: " + e.getMessage());
	        }
	    }
		
		return serviceLineList;
	}
	
	/**
	 * This queries the service line adj table associated with each service line based on service line number
	 * @param serviceLineResults The serviceLineResults object, used for service line number for query
	 * @return An ArrayList of ServiceLineDetailResultSet containing the adj_codes, rsn_codes, and adj_amts
	 * @throws SQLTimeoutException Thrown if a timeout happens, throw a new and catch in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, throw a new and catch in main method for error handling
	 */
	public ArrayList<ServiceLineDetailResultSet> queryDetailServiceLine(RemitServiceLineResultSet serviceLineResults) throws SQLTimeoutException, SQLException
	{
		String 	svcLineDetail = "select line_adj_code_cas01 as adj_code, line_adj_rsn_code_cas02 as rsn_code, line_adj_amt_cas03 as adj_amt from remittance_svc_line_adj where line_no = '" + serviceLineResults.getLineNo() + "' and line_adj_amt_cas03 is not null " +
						"union " +
						"select line_adj_code_cas01 as adj_code, line_adj_rsn_code_cas05 as rsn_code, line_adj_amt_cas06 as adj_amt from remittance_svc_line_adj where line_no = '" + serviceLineResults.getLineNo() + "' and line_adj_amt_cas06 is not null " +
						"union " +
						"select line_adj_code_cas01 as adj_code, line_adj_rsn_code_cas08 as rsn_code, line_adj_amt_cas09 as adj_amt from remittance_svc_line_adj where line_no = '" + serviceLineResults.getLineNo() + "' and line_adj_amt_cas09 is not null " +
						"union " +
						"select line_adj_code_cas01 as adj_code, line_adj_rsn_code_cas11 as rsn_code, line_adj_amt_cas12 as adj_amt from remittance_svc_line_adj where line_no = '" + serviceLineResults.getLineNo() + "' and line_adj_amt_cas12 is not null " +
						"union " +
						"select line_adj_code_cas01 as adj_code, line_adj_rsn_code_cas14 as rsn_code, line_adj_amt_cas15 as adj_amt from remittance_svc_line_adj where line_no = '" + serviceLineResults.getLineNo() + "' and line_adj_amt_cas15 is not null " +
						"union " +
						"select line_adj_code_cas01 as adj_code, line_adj_rsn_code_cas17 as rsn_code, line_adj_amt_cas18 as adj_amt from remittance_svc_line_adj where line_no = '" + serviceLineResults.getLineNo() + "' and line_adj_amt_cas18 is not null " +
						"order by rsn_code asc";
		Statement 	stmt = null;
		ResultSet 	results = null;
		ServiceLineDetailResultSet lineDetailResults;
		ArrayList<ServiceLineDetailResultSet> lineDetailList = new ArrayList<ServiceLineDetailResultSet>();
		
		try
		{
			stmt = conn.createStatement();
			stmt.setQueryTimeout(this.cmdTimeout);
			results = stmt.executeQuery(svcLineDetail);
			
			while(results.next())
			{
				lineDetailResults = new ServiceLineDetailResultSet(results.getString("adj_code"),results.getString("rsn_code"),results.getString("adj_amt"));
				lineDetailList.add(lineDetailResults);
			}
	    } 
		catch (SQLTimeoutException t) 
    	{
			throw new SQLTimeoutException("databaseConnection.queryDetailServiceLine: " + t.getMessage());
    	}
		catch (SQLException e)
		{
			throw new SQLException("databaseConnection.queryDetailServiceLine: " + e.getMessage());
		}
		finally 
    	{
	        try {
	            if (results != null) 
	            {
	            	results.close();
	            }
	            if (stmt != null) 
	            {
	                stmt.close();
	            }
	        } 
	        catch (SQLException e) 
	        {
	        	throw new SQLException("databaseConnection.queryDetailServiceLine: " + e.getMessage());
	        }
	    }
		
		return lineDetailList;
	}
	
	/**
	 * This queries the claim adj table based on claim number from claim table
	 * @param claimNo The claim number associated between the claim and claim adj table
	 * @return An ArrayList of RemitClaimAdjResultSet containing rsn_codes and adj_amts from the query
	 * @throws SQLTimeoutException Thrown if a timeout happens, throw a new and catch in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, throw a new and catch in main method for error handling
	 */
	public ArrayList<RemitClaimAdjResultSet> queryClaimAdjustment(String claimNo) throws SQLTimeoutException, SQLException
	{
		String 	claimAdjQuery = "select claim_adj_rsn_code_cas02 as rsn_code, claim_adj_amt_cas03 as adj_amt from remittance_claim_adj where claim_no = '" + claimNo + "' and claim_adj_amt_cas03 is not null " + 
						"union " +
						"select claim_adj_rsn_code_cas05 as rsn_code, claim_adj_amt_cas06 as adj_amt from remittance_claim_adj where claim_no = '" + claimNo + "' and claim_adj_amt_cas06 is not null " +
						"union " +
						"select claim_adj_rsn_code_cas08 as rsn_code, claim_adj_amt_cas09 as adj_amt from remittance_claim_adj where claim_no = '" + claimNo + "' and claim_adj_amt_cas09 is not null " + 
						"union " +
						"select claim_adj_rsn_code_cas11 as rsn_code, claim_adj_amt_cas12 as adj_amt from remittance_claim_adj where claim_no = '" + claimNo + "' and claim_adj_amt_cas12 is not null " +
						"union " +
						"select claim_adj_rsn_code_cas14 as rsn_code, claim_adj_amt_cas15 as adj_amt from remittance_claim_adj where claim_no = '" + claimNo + "' and claim_adj_amt_cas15 is not null " +
						"union " +
						"select claim_adj_rsn_code_cas17 as rsn_code, claim_adj_amt_cas18 as adj_amt from remittance_claim_adj where claim_no = '" + claimNo + "' and claim_adj_amt_cas18 is not null " +
						"order by rsn_code asc";
		Statement 	stmt = null;
		ResultSet 	results = null;
		RemitClaimAdjResultSet claimAdjResults = null;
		ArrayList<RemitClaimAdjResultSet> claimAdjList = new ArrayList<RemitClaimAdjResultSet>();
		
		try
		{
			stmt = conn.createStatement();
			stmt.setQueryTimeout(this.cmdTimeout);
			results = stmt.executeQuery(claimAdjQuery);
			
			while(results.next())
			{
				claimAdjResults = new RemitClaimAdjResultSet(results.getString("rsn_code"),results.getDouble("adj_amt"));
				claimAdjList.add(claimAdjResults);
			}
	    } 
		catch (SQLTimeoutException t) 
    	{
			throw new SQLTimeoutException("databaseConnection.queryClaimAdjustment: " + t.getMessage());
    	}
		catch (SQLException e)
		{
			throw new SQLException("databaseConnection.queryClaimAdjustment: " + e.getMessage());
		}
		finally 
    	{
	        try {
	            if (results != null) 
	            {
	            	results.close();
	            }
	            if (stmt != null) 
	            {
	                stmt.close();
	            }
	        } 
	        catch (SQLException e) 
	        {
	        	throw new SQLException("databaseConnection.queryClaimAdjustment: " + e.getMessage());
	        }
	    }
		
		return claimAdjList;
	}
	
	/**
	 * This queries the Prov adj table based on the header ID from the header table
	 * @param remitHeaderID The header ID associated between the prov adj and header table
	 * @return An ArrayList of RemitProvAdjResultSet containing rsn_codes, ref_ids, and adj_amts
	 * @throws SQLTimeoutException Thrown if a timeout happens, throw a new and catch in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, throw a new and catch in main method for error handling
	 */
	public ArrayList<RemitProvAdjResultSet> queryProviderAdj(String remitHeaderID) throws SQLTimeoutException, SQLException
	{
		String 	provAdjQuery = "select adj_reason_code_plb03_1 as rsn_code, adj_ref_id_plb03_2 as ref_id, adj_amt_plb04 as adj_amt from remittance_prov_adj where header_id = '" + remitHeaderID + "' and adj_amt_plb04 is not null " +
						"union " +
						"select adj_reason_code_plb05_1 as rsn_code, adj_ref_id_plb05_2 as ref_id, adj_amt_plb06 as adj_amt from remittance_prov_adj where header_id = '" + remitHeaderID + "' and adj_amt_plb06 is not null " +
						"union " +
						"select adj_reason_code_plb07_1 as rsn_code, adj_ref_id_plb07_2 as ref_id, adj_amt_plb08 as adj_amt from remittance_prov_adj where header_id = '" + remitHeaderID + "' and adj_amt_plb08 is not null " +
						"union " +
						"select adj_reason_code_plb09_1 as rsn_code, adj_ref_id_plb09_2 as ref_id, adj_amt_plb10 as adj_amt from remittance_prov_adj where header_id = '" + remitHeaderID + "' and adj_amt_plb10 is not null " +
						"union " +
						"select adj_reason_code_plb11_1 as rsn_code, adj_ref_id_plb11_2 as ref_id, adj_amt_plb12 as adj_amt from remittance_prov_adj where header_id = '" + remitHeaderID + "'and adj_amt_plb12 is not null " +
						"union " +
						"select adj_reason_code_plb13_1 as rsn_code, adj_ref_id_plb13_2 as ref_id, adj_amt_plb14 as adj_amt from remittance_prov_adj where header_id = '" + remitHeaderID + "' and adj_amt_plb14 is not null " + 
						"order by rsn_code asc";
		Statement 	stmt = null;
		ResultSet 	results = null;
		RemitProvAdjResultSet provAdjResults;
		ArrayList<RemitProvAdjResultSet> provAdjList = new ArrayList<RemitProvAdjResultSet>();

		try
		{
			stmt = conn.createStatement();
			stmt.setQueryTimeout(this.cmdTimeout);
			results = stmt.executeQuery(provAdjQuery);
			
			while(results.next())
			{
				provAdjResults = new RemitProvAdjResultSet(results.getString("rsn_code"),results.getString("ref_id"),results.getDouble("adj_amt"));
				provAdjList.add(provAdjResults);
			}
	    } 
		catch (SQLTimeoutException t) 
    	{
			throw new SQLTimeoutException("databaseConnection.queryProviderAdj: " + t.getMessage());
    	}
		catch (SQLException e)
		{
			throw new SQLException("databaseConnection.queryProviderAdj: " + e.getMessage());
		}
		finally 
    	{
	        try {
	            if (results != null) 
	            {
	            	results.close();
	            }
	            if (stmt != null) 
	            {
	                stmt.close();
	            }
	        } 
	        catch (SQLException e) 
	        {
	        	throw new SQLException("databaseConnection.queryProviderAdj: " + e.getMessage());
	        }
	    }
		
		return provAdjList;
	}
	
	/**
	 * This queries glossary codes for descriptions associated with them
	 * @param type This is for codes that are prov adj codes, else query normal
	 * @param code The code to query for a description
	 * @return The description associated with the code
	 * @throws SQLTimeoutException Thrown if a timeout happens, throw a new and catch in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, throw a new and catch in main method for error handling
	 */
	public String queryCodeGlossary(String type, String code) throws SQLTimeoutException, SQLException
	{
		String	plbProvAdjQuery = "select reason_code, description from remittance_plb_prov_adj_codes where reason_code = '" + code + "'",
				remarkCode411Query = "select code, description from remittance_remark_code_411 where code = '" + code + "'",
				claimAdjRsnCodeQuery = "select code, description from claim_adj_rsn_codes_139 where code = '" + code + "'",
				description = "";
		Statement stmt = null;
		ResultSet results = null;
		
		try
		{
			stmt = conn.createStatement();
			stmt.setQueryTimeout(this.cmdTimeout);
			
			if(type.equalsIgnoreCase("P"))
			{
				results = stmt.executeQuery(plbProvAdjQuery);
				if (results.isBeforeFirst())
				{
					results.next();
					description = results.getString("description").trim() + " ";
				}
			}
			else
			{
				results = stmt.executeQuery(remarkCode411Query);
				if (results.isBeforeFirst())
				{
					results.next();
					description = results.getString("description").trim() + " ";
				}
				else
				{
					results = stmt.executeQuery(claimAdjRsnCodeQuery);
					if (results.isBeforeFirst()) 
					{
						results.next();
						description = results.getString("description").trim() + " ";
					}
				}
			}
		} 
		catch (SQLTimeoutException t) 
    	{
			throw new SQLTimeoutException("databaseConnection.queryCodeGlossary: " + t.getMessage());
    	}
		catch (SQLException e)
		{
			throw new SQLException("databaseConnection.queryCodeGlossary: " + e.getMessage());
		}
		finally 
    	{
	        try {
	            if (results != null) 
	            {
	            	results.close();
	            }
	            if (stmt != null) 
	            {
	                stmt.close();
	            }
	        } 
	        catch (SQLException e) 
	        {
	        	throw new SQLException("databaseConnection.queryCodeGlossary: " + e.getMessage());
	        }
	    }
		
		return description;
	}
	
	/**
	 * This writes the final ERA string to the payback table in MySQL
	 * @param eraString The final ERA string
	 * @param jobName The job name that ran to create this ERA
	 * @param traceNo The check number of the ERA
	 * @param subAcctNo The submitter account number the ERA is for
	 * @param rptCreateTime The create time of the ERA
	 * @throws SQLTimeoutException Thrown if a timeout happens, throw a new and catch in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, throw a new and catch in main method for error handling
	 */
	public void writeToPayback(String eraString,String jobName,String traceNo,String subAcctNo,String rptCreateTime) throws SQLTimeoutException, SQLException
	{
		String 	timeString,
 		dateString,
 		batchTime,
 		batchDate;

		try
		{
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rptCreateTime);
			timeString = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
			dateString = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
			batchTime = new SimpleDateFormat("HH:mm:ss").format(date);
			batchDate = new SimpleDateFormat("yyyyMMdd").format(date);
		}
		catch(ParseException e)
		{
			timeString = "";
			dateString = "";
			batchTime = "";
			batchDate = "";
		}
		
		eraString = eraString.replace("'","''");
		
		String	insertStatement = "INSERT INTO payback(sub_acct_no,post_date,post_time,batch_date,batch_time,rpt_text,job_name,direct_name,web_desc) VALUES('" + subAcctNo + 
				"','" + dateString + "','" + timeString + "','" + batchDate + "','" + batchTime + "','" + eraString + "','" + jobName + "','','" + traceNo + "')";
		Statement stmt = null;
		
		try
		{
			stmt = conn.createStatement();
			stmt.setQueryTimeout(this.cmdTimeout);
			stmt.executeUpdate(insertStatement);
		} 
		catch (SQLTimeoutException t) 
    	{
			throw new SQLTimeoutException("databaseConnection.writeToPayback: " + t.getMessage());
    	}
		catch (SQLException e)
		{
			throw new SQLException("databaseConnection.writeToPayback: " + e.getMessage());
		}
		finally 
    	{
	        try {
	            if (stmt != null) 
	            {
	                stmt.close();
	            }
	        } 
	        catch (SQLException e) 
	        {
	        	throw new SQLException("databaseConnection.writeToPayback: " + e.getMessage());
	        }
	    }
	}
	
	/**
	 * This updates the MS SQL database after the ERA has been created
	 * @param headerResults The header results object with the information to update this table
	 * @throws SQLTimeoutException Thrown if a timeout happens, throw a new and catch in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, throw a new and catch in main method for error handling
	 */
	public void updateMSSqlDatabase(RemitHeaderResultSet headerResults) throws SQLTimeoutException, SQLException
	{
		String errorReason = headerResults.getEobReportErrorReason().trim();
		
		errorReason = errorReason.replace("'","''");
		
		String	updateStatement = "UPDATE remittance_header SET eob_report_status = '" + headerResults.getEobReportStatus() + "', eob_report_error_num = '" + headerResults.getEobReportErrorNum() + 
				"', eob_report_error_reason = '" + errorReason + "', eob_report_error_source = '" + headerResults.getEobReportErrorSource() + 
				"', eob_sub_acct_no = '" + headerResults.getEobSubAcctNo() + "', eob_report_create_datetime = '" + headerResults.getEobReportCreateDateTime() + 
				"', eob_report_run_datetime = '" + headerResults.getEobReportRunDateTime() + "' Where trace_no_TRN02 = '" + headerResults.getTraceNoTRN02() + 
				"' and remittance_header_id = '" + headerResults.getHeaderID() + "'";
		Statement stmt = null;
		
		try
		{
			stmt = conn.createStatement();
			stmt.setQueryTimeout(this.cmdTimeout);
			stmt.executeUpdate(updateStatement);
		} 
		catch (SQLTimeoutException t) 
    	{
			throw new SQLTimeoutException("databaseConnection.updateMSSqlDatabase: " + t.getMessage());
    	}
		catch (SQLException e)
		{
			throw new SQLException("databaseConnection.updateMSSqlDatabase: " + e.getMessage());
		}
		finally 
    	{
	        try {
	            if (stmt != null) 
	            {
	                stmt.close();
	            }
	        } 
	        catch (SQLException e) 
	        {
	        	throw new SQLException("databaseConnection.updateMSSqlDatabase: " + e.getMessage());
	        }
	    }
	}
	
	/**
	 * This writes a log into the database if there was an error at any point in creating the ERA
	 * @param jobResults The x12835 job object containing the information needed to write the log
	 * @param errNum The error number
	 * @param source The error source
	 * @throws SQLTimeoutException Thrown if a timeout happens, throw a new and catch in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, throw a new and catch in main method for error handling
	 */
	public void writeErrLog(X12835Job jobResults, String errNum, String source) throws SQLTimeoutException, SQLException
	{
		String 	errSource,
				errDesc,
				outputRule,
				dateString,
				sqlSelect = jobResults.getSqlSelect();
		int		errFormat = source.indexOf(":");

		dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

		sqlSelect = sqlSelect.replace("'","''");
		
		switch(jobResults.getOutputFileExistsRule())
		{
			case "0":
				outputRule = "Increment FileName";
				break;
			case "1":
				outputRule = "Increment Extension";
				break;
			case "2":
				outputRule = "Overwrite Existing File";
				break;
			default:
				outputRule = "";
				break;
		}
		
		try
		{
			errSource = source.substring(0,errFormat);
		}
		catch(StringIndexOutOfBoundsException s)
		{
			errSource = "";
		}
		
		try
		{
			errDesc = source.substring(errFormat + 1);
			errDesc = errDesc.replace("'","''");
		}
		catch(StringIndexOutOfBoundsException s)
		{
			errDesc = "";
		}
		
		String	logInsert = "INSERT INTO x12_835_msg_log(app_name,app_ver,app_uid,app_ws,job_name,job_type,log_activity,sql_select,cn_timeout,cd_timeout,fox_pro_sys_dsn,fp_cn_timeout,"
				+ "fp_cd_timeout,built_status_mark,serial_no_lookup,serial_timeout,prov_tax_id_rollback,prov_tax_id_mark,sub_835_enrollment_rollback,sub_835_enrollment_mark,"
				+ "post_sub_cancelled_rpt,sub_cancelled_mark,post_sub_inactive_rpt,sub_inactive_mark,post_sub_credit_hold_rpt,sub_credit_hold_mark,post_sub_closed_rpt,sub_closed_mark,no_claims_rollback,"
				+ "no_claims_mark,no_svc_lines_rollback,no_svc_lines_mark,verify_header_claim_amt_paid,header_claim_amt_paid_rollback,header_claim_amt_paid_mark,output_rule,file_err_mark,output_path,"
				+ "filename_mask,temp_output,eobs_selected,eobs_built,eobs_not_built,sub_acct_no,sub_status,prov_tax_id,header_id,eob_result,eob_status,eob_datetime,output_status,target_output,"
				+ "actual_output,claim_count,err_no,err_desc,err_source,prog_version,create_date_time,create_uid,create_workstation) "
				+ "VALUES('" + jobResults.getAppName() + "','" + jobResults.getVersion() + "','" + jobResults.getUserID() + "','" + jobResults.getWorkstation() 
				+ "','" + jobResults.getJobName() + "','" + jobResults.getJobType() + "','Process Spool','" + sqlSelect + "','" + jobResults.getCnnTimeout() 
				+ "','" + jobResults.getCmdTimeout() + "','" + jobResults.getRptSysDsn() + "','" + jobResults.getRptCnnTimeout() + "','" + jobResults.getRptCmdTimeout() 
				+ "','" + jobResults.getBuiltStatusMark() + "','" + (jobResults.isSerialNoLookup() ? "Yes" : "No") + "','" + jobResults.getSerialNoLookupCmdTimeout() 
				+ "','" + (jobResults.isProvTaxIDRollBack() ? "Yes" : "No") + "','" + jobResults.getProvTaxIDMark() + "','" + (jobResults.isSub835EnrollmentRollback() ? "Yes" : "No") 
				+ "','" + jobResults.getSub835EnrollmentMark() + "','" + (jobResults.isPostSubCancelledRpt() ? "Yes" : "No") + "','" + jobResults.getSubCancelledMark() 
				+ "','" + (jobResults.isPostSubInactiveRpt() ? "Yes" : "No") + "','" + jobResults.getSubInactiveMark() + "','" + (jobResults.isPostSubCreditHoldRpt() ? "Yes" : "No") 
				+ "','" + jobResults.getSubCreditHoldMark() + "','" + (jobResults.isPostSubClosedRpt() ? "Yes" : "No") + "','" + jobResults.getSubClosedMark() 
				+ "','N/A','N/A','N/A','N/A','" + (jobResults.isVerifyHeaderClaimAmtPaid() ? "Yes" : "No") + "','N/A','N/A','" + outputRule + "','N/A','" + jobResults.getOutputPath() 
				+ "','" + jobResults.getOutputFileName() + "','" + jobResults.getTempPath() + "','" + jobResults.getRemitSelected() + "','" + jobResults.getRemitBuilt() 
				+ "','" + (jobResults.getRemitSelected() - jobResults.getRemitBuilt()) + "','N/A','N/A','N/A','0','N/A','N/A','N/A','N/A','N/A','N/A','0','" + errNum + "','" + errDesc 
				+ "','" + errSource + "','EClaims X12 835 JAVA Version " + jobResults.getVersion() + "','" + dateString + "','" + jobResults.getUserID() + "','" + jobResults.getWorkstation() + "')";
		
		Statement stmt = null;
		
		try
		{
			stmt = conn.createStatement();
			stmt.setQueryTimeout(this.cmdTimeout);
			stmt.executeUpdate(logInsert);
		} 
		catch (SQLTimeoutException t) 
    	{
			throw new SQLTimeoutException("databaseConnection.writeErrLog: " + t.getMessage());
    	}
		catch (SQLException e)
		{
			throw new SQLException("databaseConnection.writeErrLog: " + e.getMessage());
		}
		finally 
    	{
	        try {
	            if (stmt != null) 
	            {
	                stmt.close();
	            }
	        } 
	        catch (SQLException e) 
	        {
	        	throw new SQLException("databaseConnection.writeErrLog: " + e.getMessage());
	        }
	    }
	}
	
	/**
	 * This writes a log to the database if the ERA was created successfully
	 * @param jobResults The x12835 object containing information needed to write log
	 * @param eobResult The eobResult object containing information needed to write success log
	 * @throws SQLTimeoutException Thrown if a timeout happens, throw a new and catch in main method for error handling
	 * @throws SQLException Thrown for other possible exceptions, throw a new and catch in main method for error handling
	 */
	public void writeLog(X12835Job jobResults, EobResult eobResult) throws SQLTimeoutException, SQLException
	{
		String 	outputRule,
				dateString,
				outStatus = eobResult.getOutStatus(),
				sqlSelect = jobResults.getSqlSelect(),
				eobTarget = eobResult.getTarget(),
				eobActual = eobResult.getActual();
		
		dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		
		sqlSelect = sqlSelect.replace("'","''");
		outStatus = outStatus.replace("'","''");
		eobTarget = eobTarget.replace("'","''");
		eobActual = eobActual.replace("'","''");
		
		switch(jobResults.getOutputFileExistsRule())
		{
			case "0":
				outputRule = "Increment FileName";
				break;
			case "1":
				outputRule = "Increment Extension";
				break;
			case "2":
				outputRule = "Overwrite Existing File";
				break;
			default:
				outputRule = "";
				break;
		}
		
		String	logInsert = "INSERT INTO x12_835_msg_log(app_name,app_ver,app_uid,app_ws,job_name,job_type,log_activity,sql_select,cn_timeout,cd_timeout,fox_pro_sys_dsn,fp_cn_timeout,"
				+ "fp_cd_timeout,built_status_mark,serial_no_lookup,serial_timeout,prov_tax_id_rollback,prov_tax_id_mark,sub_835_enrollment_rollback,sub_835_enrollment_mark,"
				+ "post_sub_cancelled_rpt,sub_cancelled_mark,post_sub_inactive_rpt,sub_inactive_mark,post_sub_credit_hold_rpt,sub_credit_hold_mark,post_sub_closed_rpt,sub_closed_mark,no_claims_rollback,"
				+ "no_claims_mark,no_svc_lines_rollback,no_svc_lines_mark,verify_header_claim_amt_paid,header_claim_amt_paid_rollback,header_claim_amt_paid_mark,output_rule,file_err_mark,output_path,"
				+ "filename_mask,temp_output,eobs_selected,eobs_built,eobs_not_built,sub_acct_no,sub_status,prov_tax_id,header_id,eob_result,eob_status,eob_datetime,output_status,target_output,"
				+ "actual_output,claim_count,prog_version,create_date_time,create_uid,create_workstation) "
				+ "VALUES('" + jobResults.getAppName() + "','" + jobResults.getVersion() + "','" + jobResults.getUserID() + "','" + jobResults.getWorkstation() 
				+ "','" + jobResults.getJobName() + "','" + jobResults.getJobType() + "','Process Spool','" + sqlSelect + "','" + jobResults.getCnnTimeout() 
				+ "','" + jobResults.getCmdTimeout() + "','" + jobResults.getRptSysDsn() + "','" + jobResults.getRptCnnTimeout() + "','" + jobResults.getRptCmdTimeout() 
				+ "','" + jobResults.getBuiltStatusMark() + "','" + (jobResults.isSerialNoLookup() ? "Yes" : "No") + "','" + jobResults.getSerialNoLookupCmdTimeout() 
				+ "','" + (jobResults.isProvTaxIDRollBack() ? "Yes" : "No") + "','" + jobResults.getProvTaxIDMark() + "','" + (jobResults.isSub835EnrollmentRollback() ? "Yes" : "No") 
				+ "','" + jobResults.getSub835EnrollmentMark() + "','" + (jobResults.isPostSubCancelledRpt() ? "Yes" : "No") + "','" + jobResults.getSubCancelledMark() 
				+ "','" + (jobResults.isPostSubInactiveRpt() ? "Yes" : "No") + "','" + jobResults.getSubInactiveMark() + "','" + (jobResults.isPostSubCreditHoldRpt() ? "Yes" : "No") 
				+ "','" + jobResults.getSubCreditHoldMark() + "','" + (jobResults.isPostSubClosedRpt() ? "Yes" : "No") + "','" + jobResults.getSubClosedMark() 
				+ "','N/A','N/A','N/A','N/A','" + (jobResults.isVerifyHeaderClaimAmtPaid() ? "Yes" : "No") + "','N/A','N/A','" + outputRule + "','N/A','" + jobResults.getOutputPath() 
				+ "','" + jobResults.getOutputFileName() + "','" + jobResults.getTempPath() + "','" + jobResults.getRemitSelected() + "','" + jobResults.getRemitBuilt() 
				+ "','" + (jobResults.getRemitSelected() - jobResults.getRemitBuilt()) + "','" + eobResult.getSubAcctNo() + "','" + eobResult.getSubStatus() + "','" + eobResult.getProvTaxID() 
				+ "','" + eobResult.getHeaderID() + "','" + eobResult.getResult() + "','" + eobResult.getStatus() + "','" + eobResult.getDateTime() + "','" + outStatus 
				+ "','" + eobTarget	+ "','" + eobActual + "','" + eobResult.getNumberClaims() + "','EClaims X12 835 JAVA Version " + jobResults.getVersion() 
				+ "','" + dateString + "','" + jobResults.getUserID() + "','" + jobResults.getWorkstation() + "')";
		
		Statement stmt = null;
		
		try
		{
			stmt = conn.createStatement();
			stmt.setQueryTimeout(this.cmdTimeout);
			stmt.executeUpdate(logInsert);
		} 
		catch (SQLTimeoutException t) 
    	{
			throw new SQLTimeoutException("databaseConnection.writeLog: " + t.getMessage());
    	}
		catch (SQLException e)
		{
			throw new SQLException("databaseConnection.writeLog: " + e.getMessage() + " SQL statement: " + logInsert);
		}
		finally 
    	{
	        try {
	            if (stmt != null) 
	            {
	                stmt.close();
	            }
	        } 
	        catch (SQLException e) 
	        {
	        	throw new SQLException("databaseConnection.writeLog: " + e.getMessage());
	        }
	    }
	}
	
	/**
	 * This returns the connection timeout
	 * @return The connection timeout
	 */
	public int getConnTimeout()
	{
		return connTimeout;
	}
	
	/**
	 * This returns the command timeout
	 * @return The command timeout
	 */
	public int getCmdTimeout()
	{
		return cmdTimeout;
	}
	
	/**
	 * This returns the JDBC server URL
	 * @return The server URL set up for the JDBC Driver
	 */
	public String getJdbcServerUrl()
	{
		return jdbcServerUrl;
	}
	
	/**
	 * This returns the database name used
	 * @return The database name
	 */
	public String getDatabaseName()
	{
		return databaseName;
	}
	
	/**
	 * This returns the connection
	 * @return The connection
	 */
	public Connection getConn()
	{
		return conn;
	}
	
	/**
	 * This sets the connection timeout
	 * @param connTimeout The connection timeout
	 */
	public void setConnTimeout(int connTimeout)
	{
		this.connTimeout = connTimeout;
	}
	
	/**
	 * This sets the command timeout
	 * @param cmdTimeout The command Timeout
	 */
	public void setCmdTimeout(int cmdTimeout)
	{
		this.cmdTimeout = cmdTimeout;
	}
	
	/**
	 * This sets the JDBC Server URL
	 * @param jdbcServerUrl The server URL set up for the JDBC Driver
	 */
	public void setJdbcServerUrl(String jdbcServerUrl)
	{
		this.jdbcServerUrl = jdbcServerUrl;
	}
	
	/**
	 * This sets the database name
	 * @param databaseName The database name
	 */
	public void setDatabaseName(String databaseName)
	{
		this.databaseName = databaseName;
	}
	
	public void setConn(Connection conn)
	{
		this.conn = conn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "databaseConnection [connTimeout=" + connTimeout
				+ ", cmdTimeout=" + cmdTimeout + ", databaseName="
				+ databaseName + ", jdbcServerUrl=" + jdbcServerUrl + ", conn="
				+ conn + "]";
	}
	
}
