package co.cstad.order;
import co.cstad.type.Type;

import java.util.List;
import co.cstad.type.Type;
import co.cstad.list.Display;

import static co.cstad.list.Display.display;


import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import org.nocrala.tools.texttablefmt.BorderStyle;
public class Goto {
        public static int goTo(int pageNumber, int rowsPerPage, List<Type> productList) {
            int totalPages = (int) Math.ceil((double) productList.size() / rowsPerPage);
            if (pageNumber < 1 || pageNumber > totalPages) {
                System.out.println("Invalid page number.");
            } else {
                Display displayGoto = new Display();
                displayGoto.display(productList, pageNumber, rowsPerPage);
            }
            return pageNumber;
        }
}
