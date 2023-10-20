package co.cstad.type;

import java.time.LocalDate;
import java.util.Objects;

public class Type {
    private static Integer ID;
    private String Name;
    private Double UnitPrice;
    private Integer Qty;
    private LocalDate ImportedData;

    public Type(Integer ID, String Name, Double UnitPrice, Integer Qty , LocalDate ImportedDate){
        this.ID = ID;
        this.Name = Name;
        this.UnitPrice = UnitPrice;
        this.Qty = Qty;
        this.ImportedData = ImportedDate;
    }

    public static Integer getID() {

        return ID;
    }

    public void setID(Integer ID) {

        this.ID = ID;
    }

    public String getName() {

        return Name;
    }

    public void setName(String name) {

        Name = name;
    }

    public Integer getQty() {

        return Qty;
    }

    public LocalDate getImportedData() {

        return ImportedData;
    }

    public void setImportedData(LocalDate importedData) {

        ImportedData = importedData;
    }

    public void setQty(Integer qty) {

        Qty = qty;
    }

    public Double getUnitPrice() {

        return UnitPrice;
    }

    public void setUnitPrice(Double unitPrice) {

        UnitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Type type = (Type) obj;
        return Objects.equals(ID, type.ID) && Objects.equals(Name, type.Name) && Objects.equals(UnitPrice, type.UnitPrice) && Objects.equals(Qty, type.Qty) && Objects.equals(ImportedData, type.ImportedData);
    }

    @Override
    public String toString() {
        return "Type{" +
                "ID =" + ID +
                ", Name ='" + Name + '\'' +
                ", UnitPrice =" + UnitPrice+
                ", Qty =" + Qty +
                ", ImportedData =" + ImportedData +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID,Name,UnitPrice,Qty,ImportedData);
    }
}
