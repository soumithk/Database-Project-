import java.lang.*;
import java.util.List;

public interface EmployeeDAO {
	public Employee getEmployeeByKey(int rollNo);
	public void addEmployee(Employee e);
	// public void updateStudent(Student student);
	// public void deleteStudent(Student student);

}
