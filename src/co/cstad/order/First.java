package co.cstad.order;

import java.util.List;
import co.cstad.type.Type;
import co.cstad.list.Display;

import static co.cstad.list.Display.display;

public class First {
    public static int first(int currentPage, int rowsPerPage, List<Type> productList) {
        if (currentPage == 1) {
            System.out.println("You are already on the first page.");
        } else {
            currentPage = 1;
            Display displayFirst = new Display();
            displayFirst.display(productList, currentPage, rowsPerPage);
        }
        return currentPage;
    }
}
