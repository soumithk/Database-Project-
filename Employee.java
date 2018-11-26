import java.lang.*;

public class Employee{
  String name;
  String contact;
  int salary;
  String type;
  int id;

	public Employee() { }
	public Employee (  String n, String c, int s, String t, int eid){

    name = n;
    contact = c;
    salary = s;
    type = t;
    id = eid;

  }
	public String getName() { return name; }
	public void setName(String s){ name = s; }
  public String getContact() { return contact; }
  public void setContact(String s){ contact = s; }
  public int getSalary() { return salary; }
  public void setSalary(int s){ salary = s; }
  public int getId() { return id; }
  public void setId(int s){ id = s; }
  public String getType() { return type; }
  public void setType(String s){ type = s; }

	public void print(){ System.out.println("Name: " + name + " " + "Salary: " + Integer.toString(salary));}
};
