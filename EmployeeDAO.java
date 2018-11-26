import java.lang.*;
import java.util.*;

public interface EmployeeDAO {
	public Employee getEmployeeById(int id);
	public void addEmployee(Employee e);
  public ArrayList<Employee> getAllEmployees();
  public void getEmployeeTypeStats();
	//public void updateStudent(Student student);
	// public void deleteStudent(Student student);

}
