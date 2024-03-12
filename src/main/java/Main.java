import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        // OPGAVE 1
        System.out.println("OPG 1");

        EmpRepository repository = new EmpRepository();
        repository.getAllEmployeeNames();

        // OPGAVE 2
        System.out.println("OPG 2");

        repository.getAllEmployeeNamesEndsOnS();

        //OPGAVE 3
        System.out.println("OPG 3");

        repository.getSumSalary();

        //OPGAVE 4
        System.out.println("OPG 4");

        repository.getHighestSsal();

        //OPGAVE 5
        System.out.println("OPG 5");
        repository.getHighestAvgSal();

        //OPGAVE 6
        System.out.println("OPG 6");
        repository.getEmployeesManager("king");
        //OPGAVE 7
        System.out.println("OPG 7");
        repository.getNumberOfEmps("Sales");
    }
}
