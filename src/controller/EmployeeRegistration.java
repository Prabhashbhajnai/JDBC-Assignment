package controller;
import model.DBLogic;
import java.sql.*;

public class EmployeeRegistration 
{
    int Counter = 0;

    public void EmpReg(int EmpID, String FirstName, String LastName, String City, int ProjectID) throws ClassNotFoundException, SQLException
    {
        DBLogic db = new DBLogic();
        Counter = db.insertData(EmpID, FirstName, LastName, City, ProjectID);

        if(Counter != 0)
        {
            System.out.println("Data insterted from controller section");
        }
    }
}
