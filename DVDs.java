package SasankPagadala;

public class DVDs extends Product implements BookStoreSpecification
{
    private double price;
    private int numWant;
    private int totalInInventory;
    private int id;
    public DVDs(){}
    
    // CONSTRUCTOR FOR PROJECT 3
    public DVDs(double price, String productName, String publisherName, int totalInInventory, int id)
    {
        super(productName, publisherName);
        this.price = price;
        this.totalInInventory = totalInInventory;
        this.id = id;
    }
    public int getID()
    {
        return id;
    }
    public void setID(int id)
    {
        this.id = id;
    }
    public double getPrice()
    {
        return price;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }
    @Override
    public int getTotalItems()
    {
        return totalInInventory;
    }
    @Override
    public void setTotalItems(int dvds)
    {
        if(dvds < 0)
        {
            System.out.println("Invalid Input!");
            System.out.println("You cant set products quantity to less than 0.");
        }
        else
        {
            this.totalInInventory = totalInInventory;
        }
    }
    
    // INTERFACE METHODS
    // BASED ON THE PARAMETER UPDATE STOCK BY ADDING AMOUNT TO EXISTING PRODCUT QUANTITY
    @Override
    public int restockProduct(int amount)
    {
        this.totalInInventory += amount;
        return this.totalInInventory;
    }
    
    // CALCULATE THE WORTH OF THE CURRENT STOCK
    @Override
    public double inventoryValue()
    {
        return (totalInInventory * price);
    }
    
    
    // DISPLAY METHOD FOR SINGULAR CLASS (ITEM/OBJECT)
    @Override
    public void display()
    {
        super.display();
        System.out.println("Price Per DVD: $" + this.price);
        System.out.println("DVDs Ordered: " + this.numWant);
        System.out.println("Total: $" + (this.price * this.numWant));
    }
    
    // DISPLAY FOR INVENTORY
    public void printInv()
    {
        System.out.println("Type Book, Title: " + super.getProductName() + ", Total in Inventory: " + this.totalInInventory + ", Price Per Book: " + this.price + ", ID: " + this.id);
    }
    
    // REDUCE ITEMS
    public void reduceTotalItems(int numWant)
    {
        this.totalInInventory -= numWant;
    }
    
    // OVERRIDE TOSTRING
    @Override
    public String toString()
    {
        return ("Type Book, Title: " + super.getProductName() + ", Total in Inventory: " + this.totalInInventory + ", Price Per Book: " + this.price + ", ID: " + this.id);
    }
}

