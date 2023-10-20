package co.cstad.list;

import co.cstad.type.Type;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.Table;
import org.nocrala.tools.texttablefmt.ShownBorders;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Search {
    public static void search(List<Type> products, int currentPage, int rowsPerPage) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Search by Name : ");
        String searchName = scanner.nextLine().toLowerCase();

        List<Type> matchingProducts = new ArrayList<>();

        for (Type type : products) {
            String productName = type.getName().toLowerCase();

            if (productName.contains(searchName)) {
                matchingProducts.add(type);
            }
        }

        int totalPages = (int) Math.ceil((double) matchingProducts.size() / rowsPerPage);
        if (matchingProducts.isEmpty()) {
            System.out.println("No products found containing the name ' " + searchName + " '.");
        } else {
            if (currentPage < 1) {
                currentPage = 1;
            } else if (currentPage > totalPages) {
                currentPage = totalPages;
            }

            Table tableDisplay = getTable(currentPage, rowsPerPage, matchingProducts);

            System.out.println(tableDisplay.render());
            System.out.println("~".repeat(90));

            System.out.println("Page " + currentPage + " of " + totalPages + " ".repeat(40) + "Total matching products: " + matchingProducts.size());
            System.out.println("~".repeat(90));
        }
    }

    private static Table getTable(int currentPage, int rowsPerPage, List<Type> matchingProducts) {
        int startIndex = (currentPage - 1) * rowsPerPage;
        int endIndex = Math.min(startIndex + rowsPerPage, matchingProducts.size());

        Table tableDisplay = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);
        tableDisplay.addCell(" ".repeat(2) + "ID" + " ".repeat(2));
        tableDisplay.addCell(" ".repeat(2) + "Name" + " ".repeat(2));
        tableDisplay.addCell(" ".repeat(2) + "Unit Price" + " ".repeat(2));
        tableDisplay.addCell(" ".repeat(2) + "Qty" + " ".repeat(2));
        tableDisplay.addCell(" ".repeat(2) + "Imported Date" + " ".repeat(2));

        for (int i = startIndex; i < endIndex; i++) {
            Type type = matchingProducts.get(i);
            tableDisplay.addCell(" ".repeat(2) + type.getID().toString());
            tableDisplay.addCell(" ".repeat(2) + type.getName());
            tableDisplay.addCell(" ".repeat(2) + type.getUnitPrice().toString());
            tableDisplay.addCell(" ".repeat(2) + type.getQty().toString());
            tableDisplay.addCell(" ".repeat(2) + type.getImportedData().toString());
        }
        return tableDisplay;
    }
}

