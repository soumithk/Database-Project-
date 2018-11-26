//STEP 1. Import required packages
import java.sql.*;

public class Demo {
	public static void main(String[] args) {
		try{
			DAO_Factory daoFactory = new DAO_Factory();

			daoFactory.activateConnection();
			EmployeeDAO edao = daoFactory.getEmployeeDAO();
			// Employee e1 = new Employee("Nikhil Sai 2","9999999999",11,"cc",8);
			// edao.addEmployee(e1);
			// StudentDAO sdao = daoFactory.getStudentDAO();
			// Student s1 = new Student("soumith",1);
			// sdao.addStudent(s1);
			// Student s = sdao.getStudentByKey(1);
			// s.print();

			edao.getEmployeeTypeStats();

			daoFactory.deactivateConnection();
		}catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
		}
	}//end main
}//end FirstExample
