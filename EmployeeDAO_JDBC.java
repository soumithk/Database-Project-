import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class EmployeeDAO_JDBC implements EmployeeDAO {
																																																																																																																																																																																																																																															Connection dbConnection;

	public EmployeeDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}

	@Override
	public Employee getEmployeeByKey(int rollNo) {
		// Employee s = new Employee();
		// String sql;
		// Statement stmt = null;
    //
		// try{
		// 	stmt = dbConnection.createStatement();
		// 	sql = "select rollno, name from bank";
		// 	ResultSet rs = stmt.executeQuery(sql);
    //
		// 	//STEP 5: Extract data from result set
		// 	while(rs.next()){
		// 		//Retrieve by column name
		// 		int rollno  = rs.getInt("rollno");
		// 		String name = rs.getString("name");
		// 		s.setRollno(rollno);
		// 		s.setName(name);
		// 		break;
		// 		// Add exception handling here if more than one row is returned
		// 	}
		// } catch (SQLException ex) {
		//     // handle any errors
		//     System.out.println("SQLException: " + ex.getMessage());
		//     System.out.println("SQLState: " + ex.getSQLState());
		//     System.out.println("VendorError: " + ex.getErrorCode());
		// }
		// // Add exception handling when there is no matching record
		// return s;
    return new Employee();
	}

	@Override
	public void addEmployee(Employee emp) {
		PreparedStatement preparedStatement = null;
		String sql;
		sql = "insert into Employee(name, contact, salary, type, employee_id) values (?,?,?,?,?)";

		try {
			preparedStatement = dbConnection.prepareStatement(sql);

			preparedStatement.setString(1, emp.getName());
			preparedStatement.setString(2, emp.getContact());
      preparedStatement.setInt(3, emp.getSalary());
      preparedStatement.setString(4, emp.getType());
        preparedStatement.setInt(5, emp.getId());

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			System.out.println("employee: Roll No " + emp.getId()
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
