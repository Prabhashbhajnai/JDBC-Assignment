package view;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import controller.EmployeeRegistration;
import model.DBLogic;
public class UserCLI 
{
    String FirstName, LastName, City;
    int EmpID, ProjectID;
    ResultSet RS;

    // Method to insert data
    public void EmpInfoReg() throws ClassNotFoundException, SQLException
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Employee ID: ");
        EmpID = input.nextInt();
        System.out.println("Enter First Name: ");
        FirstName = input.next();
        System.out.println("Enter Last Name: ");
        LastName = input.next();
        System.out.println("Enter City: ");
        City = input.next();
        System.out.println("Enter Project ID: ");
        ProjectID = input.nextInt();

        EmployeeRegistration reg = new EmployeeRegistration();
        reg.EmpReg(EmpID, FirstName, LastName, City, ProjectID);

        System.out.println("Data inserted successfully from view section!!");
    }

    public void getEmpProjectID() throws ClassNotFoundException, SQLException
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Employee ID: ");
        EmpID = input.nextInt();

        DBLogic db = new DBLogic();
        RS = db.getEmpProjID(EmpID);
        
        if (RS.next()) 
        {
            ProjectID = RS.getInt(1);
            System.out.println("Project ID of Emp-" + EmpID +" is: "+ProjectID);   
        }
    }

    public void getEmpCity() throws ClassNotFoundException, SQLException
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Employee ID: ");
        EmpID = input.nextInt();

        DBLogic db = new DBLogic();
        RS = db.getEmpCity(EmpID);
        
        if (RS.next()) 
        {
            City = RS.getString(1);
            System.out.println("Emp-" + EmpID + " is from " + City);   
        }
    }

    public void getEmpName() throws ClassNotFoundException, SQLException
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Project ID: ");
        ProjectID = input.nextInt();

        DBLogic db = new DBLogic();
        RS = db.getEmpName(ProjectID);
        
        if (RS.next()) 
        {
            FirstName = RS.getString(1);
            LastName = RS.getString(2);
            System.out.println("Employee with Project ID-" + ProjectID + " is " + FirstName + " " + LastName + ".");   
        }
    }

    // main method
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserCLI cli = new UserCLI();

        // get employee name from projectID
        cli.getEmpName();

        /* // get city from empID
        cli.getEmpCity(); */

        /* // get project id from empID
        cli.getEmpProjectID(); */

        /* // insert data
        cli.EmpInfoReg(); */
    }
}
