package co.cstad.list;

import co.cstad.type.Type;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public  class Update {
    public static void update(List<Type> proList){

        Scanner scan = new Scanner(System.in);
        boolean isFound = false;
        try {
            System.out.println("Enter ID to update : ");
            Integer idToUpdate = Integer.parseInt(scan.nextLine());
            for (Type type : proList) {
                if (Type.getID().equals(idToUpdate)) {
                    Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND);
                    table.addCell(" ID            : "+idToUpdate+" ".repeat(20));
                    table.addCell(" Name          : "+type.getName()+" ".repeat(20));
                    table.addCell(" Unit price    : "+type.getUnitPrice()+" ".repeat(20));
                    table.addCell(" Qty           : "+type.getQty()+" ".repeat(20));
                    table.addCell(" Imported Date : "+ LocalDate.now()+" ".repeat(20));
                    System.out.println(table.render());
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.out.println("Product with ID : "+idToUpdate+" is not found");
            }
            Type productToUpdate = null;

            for (Type type : proList) {
                if (type.getID().equals(idToUpdate)) {
                    productToUpdate = type;
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                System.out.println("Product with ID: " + idToUpdate + " is not found");
                return;
            }
            Type type = productToUpdate;

            System.out.println("What do you want to update?");
            Table tableToUpdate = new Table(5, BorderStyle.UNICODE_ROUND_BOX, ShownBorders.SURROUND);
            tableToUpdate.addCell(" ".repeat(2)+"1. All"+" ".repeat(2));
            tableToUpdate.addCell(" ".repeat(2)+"2. Name"+" ".repeat(2));
            tableToUpdate.addCell(" ".repeat(2)+"3. Quantity"+" ".repeat(2));
            tableToUpdate.addCell(" ".repeat(2)+"4. Price"+" ".repeat(2));
            tableToUpdate.addCell(" ".repeat(2)+"5. Back to menu"+" ".repeat(2));
            System.out.println(tableToUpdate.render());
            try {
                System.out.print("Choose option (1-5) : ");
                int op = Integer.parseInt(scan.nextLine());
                switch (op) {
                    case 1 -> {
                        try {
                            System.out.print("Enter new product name: ");
                            String newProductName = scan.nextLine();
                            System.out.print("Enter new quantity: ");
                            Integer newQuantity = Integer.parseInt(scan.nextLine());
                            System.out.print("Enter new price: ");
                            Double newPrice = Double.parseDouble(scan.nextLine());

                            type.setName(newProductName);
                            type.setQty(newQuantity);
                            type.setUnitPrice(newPrice);

                            Table updatedTable = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND);
                            updatedTable.addCell(" ID            : " + idToUpdate + " ".repeat(10));
                            updatedTable.addCell(" Name          : " + newProductName + " ".repeat(10));
                            updatedTable.addCell(" Unit price    : " + newPrice + " ".repeat(10));
                            updatedTable.addCell(" Qty           : " + newQuantity + " ".repeat(10));
                            updatedTable.addCell(" Imported Date : " + LocalDate.now() + " ".repeat(10));
                            System.out.println(updatedTable.render());

                            System.out.print("Are you sure to add this record? [Y/y] or [N/n] : ");
                            String options = scan.nextLine();
                            switch (options) {
                                case "y", "Y" -> {
                                    proList.add(productToUpdate);
                                    System.out.println("Product added successfully.");
                                }
                                case "n", "N" -> System.out.println("Product is not added");
                                default -> System.out.println("Invalid options.");
                            }
                        } catch (Exception exception) {
                            System.out.println(exception.getMessage());
                        }
                    }


                    case 2 -> {
                        try {
                            System.out.println("Enter new product name : ");
                            String newProductName = scan.nextLine();
                            type.setName(newProductName);
                            Table updatedTable = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND);
                            updatedTable.addCell(" ID            : " + idToUpdate + " ".repeat(10));
                            updatedTable.addCell(" Name          : " + newProductName + " ".repeat(10));
                            updatedTable.addCell(" Unit price    : " + type.getUnitPrice()
                                    + " ".repeat(10));
                            updatedTable.addCell(" Qty           : " + type.getQty() + " ".repeat(10));
                            updatedTable.addCell(" Imported Date : " + LocalDate.now() + " ".repeat(10));
                            System.out.println(updatedTable.render());
                            System.out.print( "Are you sure to add this record? [Y/y] or [N/n] : ");
                            String options = scan.nextLine();
                            switch (options) {
                                case "Y","y" -> {
                                    proList.add(productToUpdate);
                                    System.out.println("Product added successfully.");
                                }
                                case "N","n" -> System.out.println("Product is not added");
                                default -> System.out.println("Invalid options.");
                            }
                        } catch (Exception exception) {
                            System.out.println(exception.getMessage());
                        }
                    }
                    case 3 -> {
                        try {
                            System.out.println("Enter new product Price : ");
                            Double newProductPrice = Double.parseDouble(scan.nextLine());
                            type.setUnitPrice(newProductPrice);
                            Table updatedTable = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND);
                            updatedTable.addCell(" ID            : " + idToUpdate + " ".repeat(10));
                            updatedTable.addCell(" Name          : " + type.getName() + " ".repeat(10));
                            updatedTable.addCell(" Unit price    : " + newProductPrice + " ".repeat(10));
                            updatedTable.addCell(" Qty           : " + type.getQty() + " ".repeat(10));
                            updatedTable.addCell(" Imported Date : " + LocalDate.now() + " ".repeat(10));
                            System.out.println(updatedTable.render());
                            System.out.print( "Are you sure to add this record? [Y/y] or [N/n] : ");
                            String options = scan.nextLine();
                            switch (options) {
                                case "Y","y" -> {
                                    proList.add(productToUpdate);
                                    System.out.println("Product added successfully.");
                                }
                                case "N","n" -> System.out.println("Product is not added");
                                default -> System.out.println("Invalid options.");
                            }
                        } catch (Exception exception) {
                            System.out.println(exception.getMessage());
                        }
                    }
                    case 4 -> {
                        try {
                            System.out.println("Enter new product Price : ");
                            Integer newProductQty = Integer.parseInt(scan.nextLine());
                            type.setQty(newProductQty);
                            Table updatedTable = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND);
                            updatedTable.addCell(" ID            : " + idToUpdate + " ".repeat(10));
                            updatedTable.addCell(" Name          : " + type.getName() + " ".repeat(10));
                            updatedTable.addCell(" Unit price    : " + type.getUnitPrice()+ " ".repeat(10));
                            updatedTable.addCell(" Qty           : " + newProductQty + " ".repeat(10));
                            updatedTable.addCell(" Imported Date : " + LocalDate.now() + " ".repeat(10));
                            System.out.println(updatedTable.render());
                            System.out.print( "Are you sure to add this record? [Y/y] or [N/n] : ");
                            String options = scan.nextLine();
                            switch (options) {
                                case "Y","y" -> {
                                    proList.add(productToUpdate);
                                    System.out.println("Product added successfully.");
                                }
                                case "N","n" -> System.out.println("Product is not added");
                                default -> System.out.println("Invalid options.");
                            }
                        } catch ( Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case 5 -> System.out.println("Back to menu : ");
                    default -> throw new IllegalStateException("Unexpected value: " + op);
                }


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }
    public static void delete(List<Type> productList) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the ID of the product you want to delete: ");
            Integer productId = Integer.parseInt(scanner.nextLine());
            for (Type type : productList) {
                if (Type.getID().equals(productId)) {
                    Table table = new Table(1,BorderStyle.UNICODE_BOX_DOUBLE_BORDER,ShownBorders.SURROUND);
                    table.addCell(" ID            : "+ Type.getID()+" ".repeat(10));
                    table.addCell(" Name          : "+type.getName()+" ".repeat(10));
                    table.addCell(" Unit price    : "+type.getUnitPrice()+" ".repeat(10));
                    table.addCell(" Qty           : "+type.getQty()+" ".repeat(10));
                    table.addCell(" Imported Date : "+LocalDate.now()+" ".repeat(10));
                    System.out.println(table.render());
                    System.out.print( "Are you sure to add this record? [Y/y] or [N/n] : ");
                    String options = scanner.nextLine();
                    switch (options) {
                        case "Y","y" -> {
                            productList.remove(type);
                            System.out.println("Product with ID " + productId + " deleted successfully.");
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
