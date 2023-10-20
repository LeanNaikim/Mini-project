package co.cstad.order;

import java.util.List;
import co.cstad.type.Type;
import co.cstad.list.Display;

import static co.cstad.list.Display.display;
public class Last {
    public static int last(int currentPage, int rowsPerPage, List<Type> productList) {
        int totalPages = (int) Math.ceil((double) productList.size() / rowsPerPage);
        if (currentPage == totalPages) {
            System.out.println("You are already on the last page.");
        } else {
            currentPage = totalPages;
            display(productList, currentPage, rowsPerPage);
        }
        return currentPage;
    }
}
