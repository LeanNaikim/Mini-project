package co.cstad.view;

import co.cstad.list.*;
import co.cstad.order.*;
import co.cstad.type.Type;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ArrayListApp {

    public static void main(String[] args) {
        System.out.println("\n"+
                " ██████╗███████╗████████╗ █████╗ ██████╗          ██╗ █████╗ ██╗   ██╗ █████╗     \n" +
                "██╔════╝██╔════╝╚══██╔══╝██╔══██╗██╔══██╗         ██║██╔══██╗██║   ██║██╔══██╗    \n" +
                "██║     ███████╗   ██║   ███████║██║  ██║         ██║███████║██║   ██║███████║    \n" +
                "██║     ╚════██║   ██║   ██╔══██║██║  ██║    ██   ██║██╔══██║╚██╗ ██╔╝██╔══██║    \n" +
                "╚██████╗███████║   ██║   ██║  ██║██████╔╝    ╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║    \n" +
                " ╚═════╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═════╝      ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝    \n" );
        System.out.println(" STOCK MANAGEMENT SYSTEM \n");

        List<Type> list = new java.util.ArrayList<>();
        Scanner scan = new Scanner(System.in);

        int currentPage = 1;
        int rowsPerPage = 2;

        list.add(new Type(1,"Jeep 2024", 9900.00,90, LocalDate.now()) );
        list.add(new Type(2,"Mercedes G63 2024", 10000.00,90, LocalDate.now()) );
        list.add(new Type(3,"BMW 2024", 9080.00,90, LocalDate.now()) );
        list.add(new Type(4,"Ford 2024", 9800.00,90, LocalDate.now()) );
        list.add(new Type(5,"Lexus RX 2024", 2000.00,90, LocalDate.now()) );
        list.add(new Type(6,"Tesla 2024", 3200.00,90, LocalDate.now()) );
        list.add(new Type(7,"Rolls royce 2024", 65000.00,90, LocalDate.now()) );
        list.add(new Type(8,"Range rover 2024", 65000.00,90, LocalDate.now()) );
        list.add(new Type(9,"Highlander 2024", 65000.00,90, LocalDate.now()) );
        list.add(new Type(10,"Supercar 2024", 65000.00,90, LocalDate.now()) );

        do {
            Table table = new Table(9,BorderStyle.UNICODE_BOX_DOUBLE_BORDER,ShownBorders.SURROUND);
            table.addCell(" ".repeat(2)+"| *)Display"+" ".repeat(2));
            table.addCell(" ".repeat(2)+"| W)rite"+" ".repeat(2));
            table.addCell(" ".repeat(2)+"| R)ead"+" ".repeat(2));
            table.addCell(" ".repeat(2)+"| U)pdate"+" ".repeat(2));
            table.addCell(" ".repeat(2)+"| D)elete"+" ".repeat(2));
            table.addCell(" ".repeat(2)+"| F)irst"+" ".repeat(2));
            table.addCell(" ".repeat(2)+"| P)revious"+" ".repeat(2));
            table.addCell(" ".repeat(2)+"| N)ext"+" ".repeat(2));
            table.addCell(" ".repeat(2)+"| L)ast"+" ".repeat(2));
            table.addCell(" ".repeat(2)+"| S)earch"+" ".repeat(2));
            table.addCell(" ".repeat(2)+"| G)o to"+" ".repeat(2));
            table.addCell(" ".repeat(2)+"| Se)t row"+" ".repeat(2));
            table.addCell(" ".repeat(2)+"| H)elp"+" ".repeat(2));
            table.addCell(" ".repeat(2)+"| E)xit"+" ".repeat(2));
            System.out.println(table.render());
            System.out.println();
            System.out.print("Command -->\t");
            String options = scan.nextLine();
            switch (options) {
                case "*" ->
                        Display.display(list, currentPage, rowsPerPage);
                case "W", "w" ->
                        Write.Write(list);
                case "R", "r" ->
                        Read.read(list);
                case "S", "s" ->
                        Search.search(list, currentPage, rowsPerPage);
                case "U", "u" -> Update.update(list);
                case "d", "D" ->
                        Delete.delete(list);
                case "F", "f" ->
                        currentPage = First.first(currentPage, rowsPerPage, list);
                case "N", "n" ->
                        currentPage = Next.next(currentPage, rowsPerPage, list);
                case "P", "p" ->
                        currentPage = Previous.previous(currentPage, rowsPerPage, list);
                case "L", "l" ->
                        currentPage = Last.last(currentPage, rowsPerPage, list);
                case "G", "g" -> {
                    Goto.goTo(currentPage, rowsPerPage, list);
                }
                case "Se", "se" ->
                        rowsPerPage = SetRow.setRow( list ,rowsPerPage);
                case "H", "h" ->
                        Help.help();
                case "E", "e" -> {
                    System.out.println("Thank You and Have a nice day \n");
                    System.exit(0);
                }
                default -> {
                    String[] shortCutkey = options.split("#");
                    switch ( shortCutkey[0] ) {
                        case "W", "w" -> {
                            try {
                                Type lastPro = list.get(list.size() - 1);
                                int proID = lastPro.getID() + 1;

                                String[] Short = shortCutkey[1].split("-");

                                if (Short.length != 3) {
                                    System.out.println("Invalid format for adding a product. Use 'w#Name-Price-Quantity'.");
                                    break;
                                }

                                String newName = Short[0];
                                double newUnitPrice = Double.parseDouble(Short[1]);
                                int newQty = Integer.parseInt(Short[2]);

                                Type type = new Type(proID, newName, newUnitPrice, newQty, LocalDate.now());

                                Table tb = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND);
                                tb.addCell(" ID            : " + proID + " ".repeat(10));
                                tb.addCell(" Name          : " + type.getName() + " ".repeat(10));
                                tb.addCell(" Unit price    : " + type.getUnitPrice() + " ".repeat(10));
                                tb.addCell(" Qty           : " + type.getQty() + " ".repeat(10));
                                tb.addCell(" Imported Date : " + LocalDate.now() + " ".repeat(10));
                                System.out.println(tb.render());

                                System.out.print("Are you sure to add this record? [Y/y] or [N/n] : ");
                                String sn = scan.nextLine();
                                switch (sn.toLowerCase()) {
                                    case "Y" -> {
                                        list.add(type);
                                        Table tbl = new Table(1, BorderStyle.DESIGN_CAFE);
                                        tbl.addCell("  Product with ID [" + proID + "] added successfully  ");
                                        System.out.println(tbl.render());
                                    }
                                    case "N" -> {
                                        Table tbl = new Table(1, BorderStyle.DESIGN_CAFE);
                                        tbl.addCell("  Product with ID [" + proID + "] is not added  ");
                                        System.out.println(tbl.render());
                                    }
                                    default -> System.out.println("Invalid response. The product was not added.");
                                }
                            } catch (Exception ca) {
                                System.out.println(ca.getMessage());
                            }
                        }
                        case "R","r" -> {
                            try {
                                int Proi = Integer.parseInt(shortCutkey[1]);
                                boolean isFound = false;
                                for (Type product : list) {
                                    if ( product.getID().equals(Proi) ) {
                                        Table tb = new Table(1,BorderStyle.UNICODE_BOX_DOUBLE_BORDER,ShownBorders.SURROUND);
                                        tb.addCell(" ID            : "+Proi+" ".repeat(10));
                                        tb.addCell(" Name          : "+product.getName()+" ".repeat(10));
                                        tb.addCell(" Unit price    : "+product.getUnitPrice()+" ".repeat(10));
                                        tb.addCell(" Qty           : "+product.getQty()+" ".repeat(10));
                                        tb.addCell(" Imported Date : "+LocalDate.now()+" ".repeat(10));
                                        System.out.println(tb.render());
                                        isFound = true;
                                        break;
                                    }
                                }
                                if (!isFound){
                                    Table tble = new Table(1,BorderStyle.DESIGN_CAFE);
                                    tble.addCell("  Product with ID : "+shortCutkey[1]+" is not found  ");
                                    System.out.println(tble.render());
                                }
                            } catch (Exception ca) {
                                System.out.println(ca.getMessage());
                            }
                        }

                        case "D","d" -> {

                            try {
                                int proi = Integer.parseInt(shortCutkey[1]);
                                boolean isFound = false;
                                for (Type type : list) {
                                    if (type.getID().equals(proi)) {
                                        Table tbl = new Table(1,BorderStyle.UNICODE_BOX_DOUBLE_BORDER,ShownBorders.SURROUND);
                                        tbl.addCell(" ID            : "+proi+" ".repeat(10));
                                        tbl.addCell(" Name          : "+type.getName()+" ".repeat(10));
                                        tbl.addCell(" Unit price    : "+type.getUnitPrice()+" ".repeat(10));
                                        tbl.addCell(" Qty           : "+type.getQty()+" ".repeat(10));
                                        tbl.addCell(" Imported Date : "+LocalDate.now()+" ".repeat(10));
                                        System.out.println(tbl.render());
                                        System.out.print( "Are you sure to add this record? [Y/y] or [N/n] : ");
                                        String op = scan.nextLine();
                                        switch (op) {
                                            case "Y","y" -> {
                                                list.remove(type);
                                                Table tb = new Table(1,BorderStyle.DESIGN_CAFE);
                                                tb.addCell("  Product with ID " + proi + " is deleted  ");
                                                System.out.println(tb.render());
                                            }
                                            case "N","n" -> {
                                                Table tb = new Table(1,BorderStyle.DESIGN_CAFE);
                                                tb.addCell("  Product with ID " + proi + " is removed  ");
                                                System.out.println(tb.render());
                                            }
                                            default -> System.out.println("Invalid options");
                                        }
                                        isFound = true;
                                        break;
                                    }
                                }
                                if (!isFound) {
                                    System.out.println("Invalid options");
                                }
                            } catch (Exception ca) {
                                System.out.println(ca.getMessage());
                            }
                        }
                        default ->
                                System.err.println("Invalid Options");
                    }
                }
            }
        }while (true);
    }
}
