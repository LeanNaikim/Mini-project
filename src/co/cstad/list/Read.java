package co.cstad.list;

import co.cstad.type.Type;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
public class Read {
    public static void read(List<Type> products) {
        Scanner scan = new Scanner(System.in);
        boolean isFound = false;
        try {
            System.out.print("Read by ID: ");
            int proID = Integer.parseInt(scan.nextLine());
            for (Type type : products) {
                if (type.getID().equals(proID)) {
                    Table table = new Table(1,BorderStyle.UNICODE_BOX_DOUBLE_BORDER,ShownBorders.SURROUND);
                    table.addCell(" ID            : "+type.getID()+" ".repeat(10));
                    table.addCell(" Name          : "+type.getName()+" ".repeat(10));
                    table.addCell(" Unit price    : "+type.getUnitPrice()+" ".repeat(10));
                    table.addCell(" Qty           : "+type.getQty()+" ".repeat(10));
                    table.addCell(" Imported Date : "+LocalDate.now()+" ".repeat(10));
                    System.out.println(table.render());
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                System.out.println("~".repeat(20));
                System.out.println("ID : " + proID + " is not found!");
                System.out.println("~".repeat(20));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
