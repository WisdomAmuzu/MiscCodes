/**
 *
 * @author Sneaky
 */


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Trail Code
public class InsuranceCalculator {
    public static void main(String[] args) {
        String yearTable =
                """
                        ----------------------------------------------
                        |          Year   |       Insurance Due      |
                        ----------------------------------------------
                        |          <=1    |          100             |
                        ----------------------------------------------
                        |          2 to 3 |          300             |
                        ----------------------------------------------
                    	|         4 to 5 |          400              |
                        ----------------------------------------------
                		|          6 to 7 |          500             |
                        ----------------------------------------------
                		|          8 to 9 |          600             |
                        ----------------------------------------------
                		|          >=10   |          1000            |
                        ----------------------------------------------
                        """;
        System.out.print(yearTable);
        System.out.println();
        String insuranceTypeTable =
                """
                        --------------------------------------------------------
                        |          Insurance Type   |          Bonus      	   |
                        --------------------------------------------------------
                        |     Women Compensation    |           20             |
                        --------------------------------------------------------
                        |          Motor            |           40             |
                        --------------------------------------------------------
                        |      General bonds        |           50             |
                        --------------------------------------------------------
                        |          Fire             |           70             |
                        --------------------------------------------------------
                        |Engineering & Construction |           80             |
                        --------------------------------------------------------
                        |          Marine           |           100            |
                        --------------------------------------------------------
                        |          Accident         |           120            |
                        --------------------------------------------------------
                        """;
        System.out.print(insuranceTypeTable);
        System.out.println();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of years: ");
        int numOfYearsContributed = input.nextInt();
        int amountDue = 0;
        if(numOfYearsContributed <= 1) {
            amountDue = 100;
        } else if (numOfYearsContributed == 2 || numOfYearsContributed == 3) {
            amountDue = 300;
        } else if (numOfYearsContributed == 4 || numOfYearsContributed == 5) {
            amountDue = 400;
        } else if (numOfYearsContributed == 6 || numOfYearsContributed == 7) {
            amountDue = 500;
        } else if (numOfYearsContributed == 8 || numOfYearsContributed == 9) {
            amountDue = 600;
        } else amountDue = 1000;

        System.out.print("Enter insurance type: ");
        String insuranceType = input.next();
        switch (insuranceType) {
            case "Women Compensation" -> amountDue += 20;
            case "Motor" -> amountDue += 40;
            case "General bonds" -> amountDue += 50;
            case "Fire" -> amountDue += 70;
            case "Engineering & Construction" -> amountDue += 80;
            case "Marine" -> amountDue += 100;
            case "Accident" -> amountDue += 120;
        }

        System.out.println("Amount due " + amountDue);
        try {
            FileWriter file = new FileWriter("myInsurance.txt", true);
            file.write("Amount Due: " + amountDue);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
