import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class bankDAO_JDBC implements bankDAO {
																																																																																																																																																																																																																																															Connection dbConnection;

	public bankDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}

	@Override
	public bank getbankByKey(int rollNo) {
		Bank s = new Bank();
		String sql;
		Statement stmt = null;

		try{
			stmt = dbConnection.createStatement();
			sql = "select rollno, name from bank";
			ResultSet rs = stmt.executeQuery(sql);

			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				int rollno  = rs.getInt("rollno");
				String name = rs.getString("name");
				s.setRollno(rollno);
				s.setName(name);
				break;
				// Add exception handling here if more than one row is returned
			}
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
		return s;
	}

	@Override
	public void addbank(bank bank) {
		PreparedStatement preparedStatement = null;
		String sql;
		sql = "insert into bank(rollno, name) values (?,?)";

		try {
			preparedStatement = dbConnection.prepareStatement(sql);

			preparedStatement.setInt(1, bank.getRollno());
			preparedStatement.setString(2, bank.getName());

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("bank: Roll No " + bank.getRollno()
				+ ", added to the database");
		} catch (SQLException e) {
 			System.out.println(e.getMessage());
 		}

		try{
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {
 			System.out.println(e.getMessage());
 		}
	}
}
