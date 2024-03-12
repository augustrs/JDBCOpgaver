import java.sql.*;

public class EmpRepository {

    public void doSomething2(int salary) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_dept", "root", "root123*")) {
            String SQL = "SELECT * from emp where sal > ?"; //SQL STATEMENT AS STRING
            PreparedStatement ps = connection.prepareStatement(SQL); //INITIATE THE STATEMENT ON THE CONNECTION
            ps.setInt(1, salary);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { //WHILE LOOP TO GET ALL RESULTS OUT
                System.out.println("Employee number: " + rs.getInt("empno") + ", Name: " + rs.getString("ename") + ", Salary: " + rs.getInt(6) + "$"); //PRINT OUT ENAME
            }

        }
    }

    public void getAllEmployeeNames() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_dept", "root", "root123*")) {
            String SQL = "SELECT * from emp";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                System.out.println("Employee number: " + rs.getInt("empno") + ", Name: " + rs.getString("ename"));
            }

        }
    }

    public void getAllEmployeeNamesEndsOnS() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_dept", "root", "root123*")) {
            String SQL = "select * from emp where ename LIKE  \"s%\"";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                System.out.println("Employee number: " + rs.getInt("empno") + ", Name: " + rs.getString("ename"));
            }

        }
    }

    public void getSumSalary() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_dept", "root", "root123*")) {
            String SQL = "select sum(sal) from emp";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }

        }
    }

    public void getHighestSsal() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_dept", "root", "root123*")) {
            String SQL = "select * from emp order by sal desc limit 1";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                System.out.println("Employee number: " + rs.getInt("empno") + ", Name: " + rs.getString("ename"));
            }

        }
    }
    public void getHighestAvgSal() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_dept", "root", "root123*")) {
            String SQL = "select * from emp where sal > (select avg(sal) from emp);";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                System.out.println("Employee number: " + rs.getInt("empno") + ", Name: " + rs.getString("ename") +", Salary: " + rs.getInt("sal"));
            }

        }
    }
    public void getEmployeesManager(String name) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_dept", "root", "root123*")) {
            String SQL = "select ename from emp where mgr = (select empno from emp where ename = ?)"; //SQL STATEMENT AS STRING
            PreparedStatement ps = connection.prepareStatement(SQL); //INITIATE THE STATEMENT ON THE CONNECTION
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { //WHILE LOOP TO GET ALL RESULTS OUT
                System.out.println(rs.getString("ename")); //PRINT OUT ENAME
            }

        }
    }
    public void getNumberOfEmps(String name) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_dept", "root", "root123*")) {
            String SQL = "select count(*) from emp where deptno = (select deptno from dept where dname = ?)"; //SQL STATEMENT AS STRING
            PreparedStatement ps = connection.prepareStatement(SQL); //INITIATE THE STATEMENT ON THE CONNECTION
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { //WHILE LOOP TO GET ALL RESULTS OUT
                System.out.println(rs.getInt(1)); //PRINT OUT ENAME
            }

        }
    }

}
