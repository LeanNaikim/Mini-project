package co.cstad.list;

import co.cstad.type.Type;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import org.nocrala.tools.texttablefmt.BorderStyle;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Delete {
    public static void delete(List<Type> products) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the ID of the product you want to delete: ");
            Integer proId = Integer.parseInt(scanner.nextLine());
            for (Type type : products) {
                if (type.getID().equals(proId)) {
                    Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND);
                    table.addCell(" ID            : "+type.getID()+" ".repeat(10));
                    table.addCell(" Name          : "+type.getName()+" ".repeat(10));
                    table.addCell(" Unit price    : "+type.getUnitPrice()+" ".repeat(10));
                    table.addCell(" Qty           : "+type.getQty()+" ".repeat(10));
                    table.addCell(" Imported Date : "+ LocalDate.now()+" ".repeat(10));
                    System.out.println(table.render());
                    System.out.print( "Are you sure to add this record? [Y/y] or [N/n] : ");
                    String options = scanner.nextLine();
                    switch (options) {
                        case "Y","y" -> {
                            products.remove(type);
                            System.out.println("Product with ID " + proId + " deleted successfully.");
                            return;
                        }
                        case "N","n" -> {
                            System.out.println("Product is not deleted");
                            return;
                        }
                        default -> System.out.println("Invalid options");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

