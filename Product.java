package SasankPagadala;

public abstract class Product implements Comparable<Product>
{
    private String productName, publisherName;
    public Product(){}
    public Product(String productName, String publisherName)
    {
        this.productName = productName;
        this.publisherName = publisherName;
    }
    public String getProductName()
    {
        return this.productName;
    }
    public void setProductName(String productName)
    {
        this.productName = productName;
    }
    public String getPublisherName()
    {
        return this.publisherName;
    }
    public void setPublisherName(String publisherName)
    {
        this.publisherName = publisherName;
    }
    
    // DEFINED IN EVERY CLASS THAT EXTENDS PRODUCT CLASS (THIS CLASS)
    public abstract int getTotalItems();
    public abstract void setTotalItems(int items);
    
    
    // DISPLAY METHOD
    public void display()
    {
        System.out.println("Product Name: " + this.productName + "    PublisherName: " + this.publisherName);
    }
    
    // COMPARE TO
    @Override
    public int compareTo(Product o)
    {
        int sRate = this.getTotalItems();
        int oRate = o.getTotalItems();
        if(sRate > oRate)
        {
            return 1;
        }
        else if(sRate < oRate)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}

