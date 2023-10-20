package co.cstad.list;

import co.cstad.type.Type;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.Table;
import java.util.List;
public class Display {
    public static void display(List<Type> products, int currentPage, int rowsPerPage) {
        int startIndex = (currentPage - 1) * rowsPerPage;
        int endIndex = Math.min(startIndex + rowsPerPage, products.size());

        Table tableDisplay = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);
        tableDisplay.addCell(" ".repeat(2) + "ID" + " ".repeat(2));
        tableDisplay.addCell(" ".repeat(2) + "Name" + " ".repeat(2));
        tableDisplay.addCell(" ".repeat(2) + "Unit Price" + " ".repeat(2));
        tableDisplay.addCell(" ".repeat(2) + "Qty" + " ".repeat(2));
        tableDisplay.addCell(" ".repeat(2) + "Imported Date" + " ".repeat(2));

        for (int i = startIndex; i < endIndex; i++) {
            Type type = products.get(i);
            tableDisplay.addCell(" ".repeat(2) + Type.getID().toString());
            tableDisplay.addCell(" ".repeat(2) + type.getName());
            tableDisplay.addCell(" ".repeat(2) + type.getUnitPrice().toString());
            tableDisplay.addCell(" ".repeat(2) + type.getQty().toString());
            tableDisplay.addCell(" ".repeat(2) + type.getImportedData().toString());
        } 

        System.out.println(tableDisplay.render());
        System.out.println("o"+"-".repeat(80)+"o");
        int totalPages = (int) Math.ceil((double) products.size() / rowsPerPage);
        System.out.println("Page " + currentPage + " of " + totalPages + " ".repeat(50) + "Total records : " + products.size());
        System.out.println("o"+"-".repeat(80)+"o");
    }
}
