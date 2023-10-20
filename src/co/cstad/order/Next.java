package co.cstad.order;

import java.util.List;
import co.cstad.type.Type;
import co.cstad.list.Display;

import static co.cstad.list.Display.display;

public class Next {
    public static int next(int currentPage, int rowsPerPage, List<Type> productList) {
        int totalPages = (int) Math.ceil((double) productList.size() / rowsPerPage);
        if (currentPage < totalPages) {
            currentPage++;
            Display displayNext = new Display();
            displayNext.display(productList, currentPage, rowsPerPage);
        } else {
            System.out.println("You are already on the next page.");
        }
        return currentPage;
    }
}
