package co.cstad.order;

import java.util.List;
import co.cstad.type.Type;
import co.cstad.list.Display;

import static co.cstad.list.Display.display;

public class Previous {
    public static int previous(int currentPage, int rowsPerPage, List<Type> productList) {
        if (currentPage > 1) {
            currentPage--;
            Display displayPrivious = new Display();
            displayPrivious.display(productList, currentPage, rowsPerPage);
        } else {
            System.out.println("You are already on the previous page.");
        }
        return currentPage;
    }
}
