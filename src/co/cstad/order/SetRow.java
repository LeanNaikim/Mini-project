package co.cstad.order;

import co.cstad.type.Type;

import java.util.List;
import java.util.Scanner;
public class SetRow {
        public static int setRow(List<Type> products, int rowsPerPage) {
            Scanner scan = new Scanner(System.in);
            try {
                System.out.print("Enter the number of rows you want to display: ");
                int numberOfRows = Integer.parseInt(scan.nextLine());
                if (numberOfRows > 0 && numberOfRows <= products.size()) {
                    System.out.println("~".repeat(40));
                    System.out.println("\tSet Row " + numberOfRows + " Successfully!");
                    System.out.println("~".repeat(40));
                    return numberOfRows;
                } else {
                    System.out.println("Invalid number of rows. Defaulting to " + rowsPerPage);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return rowsPerPage;
        }

}
