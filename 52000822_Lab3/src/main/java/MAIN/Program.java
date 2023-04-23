package MAIN;

import POJO.*;
import DAO.*;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int choose = 1;
        while (choose != 8) {
            System.out.println("\t\t\t\t\t\t\t\t MANUFACTURE PHONE" + "\n" +
                    "**************************************************************************" + "\n" +
                    "**  1. The phone with the highest selling price                         **" + "\n" +
                    "**  2. List of phones sorted by country name, if two phones have the    **" + "\n" +
                    "\tsame country, sort descending by price" + "\n" +
                    "**  3. Phone priced above 50 million VND                                **" + "\n" +
                    "**  4. First phone in the list that meets the criteria: has the color   **" + "\n" +
                    "\t'Pink' and costs over 15 million" + "\n" +
                    "**  5. All manufacturers have more than 100 employees                   **" + "\n" +
                    "**  6. Sum of all employees of the manufactures                         **" + "\n" +
                    "**  7. The last manufacturer in the list of manufacturers that meet     **" + "\n" +
                    "\tthe criteria: based in the US" + "\n" +
                    "**  8. Exit                                                             **" + "\n" +
                    "**************************************************************************");
            ManufactureDAO manufactureDAO = new ManufactureDAO();
            PhoneDAO phoneDAO = new PhoneDAO();
            Scanner sc = new Scanner(System.in);
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    phoneDAO.PhoneHighestSellingPrice();
                    break;
                case 2:
                    phoneDAO.SortedByCountryName();
                    break;
                case 3:
                    phoneDAO.PhoneAbove50M();
                    break;
                case 4:
                    phoneDAO.FirstPhonePinkAndOver15M();
                    break;
                case 5:
                    manufactureDAO.AllManufactureMoreThan100Employee();
                    break;
                case 6:
                    manufactureDAO.SumEmployeeOfAllManufactures();
                    break;
                case 7:
                    manufactureDAO.LastManufactureBaseInTheUS();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
            }
        }
    }
}
