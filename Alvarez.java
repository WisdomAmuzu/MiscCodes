package abccompany;

/**
 *
 * @author Alvarez
 */



// Alvarez.java File
public class Alvarez {

    String empName = "Alverez ";                    // Employees Name
    String empPosition = "Network Adminstrator";    // Employee's Position
    double grossPay = 100000.0;                     // Employee's Gross Salary
    double netPay;                                  // Variable for Employee's Net Salary

    //Method for calculating withholding tax
    public double calcWithholdingTax() {
        double wTax = grossPay * 0.1;               // Withholding Tax = 10% of Gross Pay
        return wTax;

    }
    //for calculation sss contribution
    public double calcSSSContributiion() {         
        double sss = grossPay * 0.0368;             // SSS Contribution = 3.68% of Gross Pay
        return sss;

    }
    // Method for calculating Pag-IBIG
    public double calcPayIBIG() {
        double payIbig = 100.00;                    // Pag-IBIG = 100.0
        return payIbig;
    }

    // Method for calculating PhilHealth
    public double calcPhilHealth() {
        double health = 150.00;                     // PhilHealth = 150.0
        return health;
    }

    // Method for calculating MaxiCare
    public double calcMaxicare() {
        double mCare = grossPay * 0.0133;            // MaxiCare = 1.33%
        return mCare;
    }
    
    // Method for calculating NetPay
    public double calcNetPay() {
        this.netPay  =                               // Net Pay = Gross Pay - MaxiCare - Pay-IBIG - PhilHealth - - SSS Contribution - Withhelding Tax
                grossPay - 
                this.calcMaxicare() - 
                this.calcPayIBIG() - 
                this.calcPhilHealth() - 
                this.calcSSSContributiion() - 
                this.calcWithholdingTax();
        return this.netPay;
    }

}

// ABCCOMPANY.java
package abccompany;

public class ABCCOMPANY {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alvarez alvarez = new Alvarez(); // New Object of The Class
        System.out.println("\t\tALVAREZ TECHNOLOGIES");
        System.out.println("========================================================");
        System.out.println("Employee Name:\t\t\t\t" + alvarez.empName); // Output the Employee's name
        System.out.println("Employee Position:\t\t" + alvarez.empPosition); // Output the Employee's Position
        System.out.println("Gross Pay:\t\t\t\t" + alvarez.grossPay); // Output the Employee's GrossPay
        System.out.println("========================================================");
        System.out.println("Dudections\t\t\t\tAmount   ");
        System.out.println("========================================================");
        double maxiCare = alvarez.calcMaxicare(); // Assign Maxicare value to var maxiCare
        System.out.println("MaxiCare:\t\t\t\t" + maxiCare); // Output value of maxiCare
        double payIBig = alvarez.calcPayIBIG(); // Assign Pay-IBIG to var payIbig
        System.out.println("PagIBIG:\t\t\t\t" + payIBig); // Output value of payIbig
        double philHealth = alvarez.calcPhilHealth(); // Assign PhilHealth to var philHealth
        System.out.println("PhilHealth:\t\t\t\t" + philHealth); // Output value of philHealth
        double sss = alvarez.calcSSSContributiion(); // Assign SSSContribution to var sss
        System.out.println("SSS Contribution:\t\t\t" + sss); // Output value of sss
        double wTax = alvarez.calcWithholdingTax(); // Assign WithholdingTax to var wTax
        System.out.println("Withhelding Tax:\t\t\t" + wTax); // Output value of wTax
        System.out.println("========================================================");
        double deductions = ( // Calculate the total deductions [ MaxiCare + Pay-IBIG + PhilHealth + SSSContribution + Withholding Tax ]
                alvarez.calcMaxicare() + 
                alvarez.calcPayIBIG() + 
                alvarez.calcPhilHealth() + 
                alvarez.calcSSSContributiion() + 
                alvarez.calcWithholdingTax());
        System.out.println("Total Deductions:\t\t\t" + deductions); // Output total decuctions
        System.out.println("========================================================");
        System.out.println("Net Pay:\t\t\t\t" + alvarez.calcNetPay()); // Output Net Pay
    }
    
}
