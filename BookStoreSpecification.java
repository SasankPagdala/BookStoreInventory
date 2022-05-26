package SasankPagadala;

public interface BookStoreSpecification
{
    // BASED ON THE PARAMETER UPDATE STOCK BY ADDING AMOUNT TO EXISTING PRODCUT QUANTITY
    public int restockProduct(int amount);
    // CALCULATE THE WORTH OF THE CURRENT STOCK
    public double inventoryValue();
}


