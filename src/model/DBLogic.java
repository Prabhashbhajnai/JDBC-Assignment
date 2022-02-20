package model;
import java.sql.*;

public class DBLogic {
    // Global variable
    Connection CONN;
    Statement ST;
    ResultSet RS;
    DriverManager DM;
    PreparedStatement PSTMT;

    String LOAD_DRIVER = "com.mysql.jdbc.Driver";
    String CONNECTION_STRING = "jdbc:mysql://localhost:3306/erp";

    String DB_USER = "root";
    String DB_PWD = "Prabhash";
    String QUERY;
    int COUNTER;

    public Connection checkConnectionValue() throws ClassNotFoundException, SQLException
    {
        // Register Drive
        Class.forName(LOAD_DRIVER);

        // Create Connection
        CONN = DM.getConnection(CONNECTION_STRING, DB_USER, DB_PWD);
        return CONN;
    }

    public ResultSet exeQuery(String QUERY) throws ClassNotFoundException, SQLException 
    {
        this.QUERY = QUERY;
        DBLogic logic = new DBLogic();
        CONN = logic.checkConnectionValue();

        if (CONN != null)
        {
            // Create Statement
            ST = CONN.createStatement();
            RS = ST.executeQuery(QUERY);
        }
        return RS;
    }

    public int insertData(int EmpID, String FirstName, String LastName, String City, int ProjectID) throws ClassNotFoundException, SQLException
    {
        DBLogic logic = new DBLogic();
        CONN = logic.checkConnectionValue();

        if (CONN != null) 
        {
            QUERY = "INSERT INTO Employee VALUE(?, ?, ?, ?, ?)";
            PSTMT = CONN.prepareStatement(QUERY);

            PSTMT.setInt(1, EmpID);
            PSTMT.setString(2, FirstName);
            PSTMT.setString(3, LastName);
            PSTMT.setString(4, City);
            PSTMT.setInt(5, ProjectID);
            COUNTER = PSTMT.executeUpdate();
            
            if(COUNTER != 0)
            {
                System.out.println("Data Inserted from model section!!");
            }    
        }
        return COUNTER;
    }

    public ResultSet getEmpProjID(int EmpID) throws ClassNotFoundException, SQLException
    {
        DBLogic logic = new DBLogic();
        CONN = logic.checkConnectionValue();

        if(CONN != null)
        {
            QUERY = "SELECT ProjectID FROM Employee " + 
                    "WHERE " + 
                    "EmpID = " + EmpID;
            
            ST = CONN.createStatement();
            RS = ST.executeQuery(QUERY);
        }
        return RS;
    }

    public ResultSet getEmpCity(int EmpID) throws ClassNotFoundException, SQLException
    {
        DBLogic logic = new DBLogic();
        CONN = logic.checkConnectionValue();

        if(CONN != null)
        {
            QUERY = "SELECT City FROM Employee " + 
                    "WHERE " + 
                    "EmpID = " + EmpID;
            
            ST = CONN.createStatement();
            RS = ST.executeQuery(QUERY);
        }
        return RS;
    }

    public ResultSet getEmpName(int ProjectID) throws ClassNotFoundException, SQLException
    {
        DBLogic logic = new DBLogic();
        CONN = logic.checkConnectionValue();

        if(CONN != null)
        {
            QUERY = "SELECT FirstName, LastName FROM Employee " + 
                    "WHERE " + 
                    "ProjectID = " + ProjectID;
            
            ST = CONN.createStatement();
            RS = ST.executeQuery(QUERY);
        }
        return RS;
    }

}
