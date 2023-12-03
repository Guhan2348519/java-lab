// Base class representing an employee
class Employee {
int employeeId;
String employeeName;
String designation;
// Constructor to initialize common attributes
public Employee(int employeeId, String employeeName, String designation) {
this.employeeId = employeeId;
this.employeeName = employeeName;
this.designation = designation;
}

// Default method for calculating bonus (can be overridden in subclasses)
public double calculateBonus() 
{
return 0.0;
}
// Method to display employee information
public void displayEmployeeInfo() {
 System.out.println("Employee ID: " + employeeId);
System.out.println("Employee Name: " + employeeName);
System.out.println("Designation: " + designation);
}
}
// Subclass representing an employee paid hourly
class HourlyEmployee extends Employee {
double hourlyRate;
int hoursWorked;
// Constructor to initialize attributes using super() to invoke the base class constructor
public HourlyEmployee(int employeeId, String employeeName, String designation, double hourlyRate, int hoursWorked) {
super(employeeId, employeeName, designation);
this.hourlyRate = hourlyRate;
this.hoursWorked = hoursWorked;
}
// Method to calculate weekly salary for HourlyEmployee
public double calculateWeeklySalary() 
{
 return hourlyRate * hoursWorked;
}
// Method to calculate annual earnings for HourlyEmployee
public double calculateAnnualEarnings() {
return calculateWeeklySalary() * 52;
 }
// Method to display detailed information for HourlyEmployee
 @Override
public void displayEmployeeInfo() {
super.displayEmployeeInfo();
System.out.println("Hourly Rate: " + hourlyRate);
System.out.println("Hours Worked: " + hoursWorked);
System.out.println("Weekly Salary: " + calculateWeeklySalary());
System.out.println("Annual Earnings: " + calculateAnnualEarnings());
}
}
// Subclass representing an employee paid a fixed salary
class SalariedEmployee extends Employee {
 double monthlySalary;
 // Constructor to initialize attributes using super() to invoke the base class constructor
public SalariedEmployee(int employeeId, String employeeName, String designation, double monthlySalary) {
super(employeeId, employeeName, designation);
 this.monthlySalary = monthlySalary;
  }
 // Method to calculate weekly salary for SalariedEmployee
 public double calculateWeeklySalary() {
return monthlySalary / 4;
}
 // Method to calculate annual earnings for SalariedEmployee
public double calculateAnnualEarnings() {
return monthlySalary * 12;
}
// Method to calculate bonus for SalariedEmployee
 @Override
 public double calculateBonus() {
return calculateAnnualEarnings() * 0.1; // Assume 10% bonus
}
 // Method to display detailed information for SalariedEmployee
 @Override
  public void displayEmployeeInfo() {
super.displayEmployeeInfo();
System.out.println("Monthly Salary: " + monthlySalary);
System.out.println("Weekly Salary: " + calculateWeeklySalary());
System.out.println("Annual Earnings: " + calculateAnnualEarnings());
 System.out.println("Bonus: " + calculateBonus());
}
}
// Subclass representing an executive employee with an additional bonus percentage
class ExecutiveEmployee extends SalariedEmployee {
double bonusPercentage;
// Constructor to initialize attributes using super() to invoke the base class constructor
public ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage) {
super(employeeId, employeeName, designation, monthlySalary);
this.bonusPercentage = bonusPercentage;
}
// Method to calculate bonus for ExecutiveEmployee
@Override
public double calculateBonus() {
 return super.calculateBonus() + (calculateAnnualEarnings() * bonusPercentage / 100);
}
// Method to display detailed information for ExecutiveEmployee
@Override
public void displayEmployeeInfo() {
super.displayEmployeeInfo();
System.out.println("Bonus Percentage: " + bonusPercentage);
System.out.println("Bonus: " + calculateBonus());
}
}
// Test program to demonstrate the functionality
public class EmpPayroll {
public static void main(String[] args) {
 // Instantiate objects of each employee type
HourlyEmployee he = new HourlyEmployee(101, "Badri", "Lecturer", 500, 40);
 SalariedEmployee se = new SalariedEmployee(102, "Sundhar", "Professor", 80000);
 ExecutiveEmployee ee = new ExecutiveEmployee(103, "Guhan", "Dean", 100000, 20);
 // Display detailed information for each employee
he.displayEmployeeInfo();
System.out.println();
se.displayEmployeeInfo();
System.out.println();
ee.displayEmployeeInfo();
 System.out.println();
// Calculate and display the total payroll
double totalPayroll = he.calculateWeeklySalary() + se.calculateWeeklySalary() + ee.calculateWeeklySalary();
System.out.println("Total Payroll: " + totalPayroll);
}
}