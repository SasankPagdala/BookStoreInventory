
package SasankPagadala;


public abstract class Customer implements Comparable<Customer>{
    private String customerName, ProdName, ProdType;
    private double ProdPrice, ProdWant;
    public Customer(){}
    public Customer(String customerName, String ProdName, String ProdType, double ProdPrice, double ProdWant)
    {
        this.customerName = customerName;
        this.ProdName = ProdName;
        this.ProdPrice = ProdPrice;
        this.ProdWant = ProdWant;
        this.ProdType = ProdType;
        
    }
    
     public String getCustomerName()
    {
        return this.customerName;
    }
     
     public String getProdName()
    {
        return this.ProdName;
    }
     public String getProdType()
    {
        return this.ProdType;
    }
     public double getProdPrice()
    {
        return this.ProdPrice;
    }
     
     public double getProdWant()
    {
        return this.ProdWant;
    }
     
}
