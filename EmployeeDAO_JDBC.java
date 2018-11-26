import java.util.ArrayList;
import java.util.*;
import java.sql.*;


public class EmployeeDAO_JDBC implements EmployeeDAO {
																																																																																																																																																																																																																																															Connection dbConnection;

	public EmployeeDAO_JDBC(Connection dbconn){
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee em = new Employee();
		String sql;
		Statement stmt = null;

		try{
			stmt = dbConnection.createStatement();
			sql = "select * from Employee where employee_id=id";
			ResultSet rs = stmt.executeQuery(sql);

			//STEP 5: Extract data from result set
			while(rs.next()){
				//Retrieve by column name
				int eid  = rs.getInt("employee_id");
				String name = rs.getString("name");
        String contact = rs.getString("contact");
        int salary = rs.getInt("salary");
        String type = rs.getString("type");
				em.setId(eid);
				em.setName(name);
        em.setContact(contact);
        em.setType(type);
        em.setSalary(salary);
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
		return em;
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

			System.out.println("employee: Roll No " + Integer.toString(emp.getId())
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

  public ArrayList<Employee> getAllEmployees(){

    Statement stmt = null;
    String sql;
    sql = "select * from Employee";

    ArrayList<Employee> employees = new ArrayList<Employee>();
    Employee em;

    try{

      stmt = dbConnection.createStatement();
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
        em = new Employee();
        //Retrieve by column name
        int id  = rs.getInt("employee_id");
        String name = rs.getString("name");
        String contact = rs.getString("contact");
        int salary = rs.getInt("salary");
        String type = rs.getString("type");
        em.setId(id);
        em.setName(name);
        em.setContact(contact);
        em.setType(type);
        em.setSalary(salary);

        employees.add(em);
        // Add exception handling here if more than one row is returned
        }

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return employees;
  }

  public void getEmployeeTypeStats(){

    ArrayList<Employee> list = getAllEmployees();
    int count = 0;
    System.out.println("Zonal Heads");

    for(Employee e : list){
      if(e.getType().equals("zh")){
        e.print();
        count+=1;
      }
    }


    System.out.println("\nManagers");
    count = 0;

    for(Employee e : list){
      if(e.getType().equals("m")){
        e.print();
        count+=1;
      }
    }

    System.out.println("\nCross Sellers");
    count = 0;

    for(Employee e : list){
      if(e.getType().equals("cs")){
        e.print();
        count+=1;
      }
    }

    System.out.println("\nCustomer Care Agents");
    count = 0;

    for(Employee e : list){
      if(e.getType().equals("cc")){
        e.print();
        count+=1;
      }
    }
  }

}
