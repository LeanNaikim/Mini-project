package co.cstad.list;
import co.cstad.type.Type;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Write {
    public static void Write(List<Type> proList) {
        Type lastProduct = proList.get(proList.size() - 1);
        Integer proID = lastProduct.getID() + 1;

        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("ID: ");
            Integer ID = Integer.parseInt(scan.nextLine());
            System.out.print("Name: ");
            String Name = scan.nextLine();
            System.out.print("UnitPrice: ");
            Double UnitPrice = Double.parseDouble(scan.nextLine());
            System.out.print("Product's Qty: ");
            Integer Qty = Integer.parseInt(scan.nextLine());
            LocalDate getImported = LocalDate.now();
            Type type = new Type(ID ,Name,UnitPrice,Qty,getImported);

            do {
                Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND);
                table.addCell(" ID            : " + ID + " ".repeat(10));
                table.addCell(" Name          : " + Name + " ".repeat(10));
                table.addCell(" UnitPrice    : " + UnitPrice + " ".repeat(10));
                table.addCell(" Qty           : " + Qty + " ".repeat(10));
                table.addCell(" ImportedDate : " + LocalDate.now() + " ".repeat(10));
                System.out.println(table.render());
                System.out.print("Are you sure to add this record? [Y/y] or [N/n] : ");
                String options = scan.nextLine();
                switch (options.toLowerCase()) {
                    case "y", "Y":
                        System.out.println("Product added successfully.");
                        return;
                    case "n" , "N":
                        proList.remove(type);
                        System.out.println("Product is not added");
                        return;
                    default:
                        System.out.println("Invalid options.");
                }
            } while (true);
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
        }
    }
}