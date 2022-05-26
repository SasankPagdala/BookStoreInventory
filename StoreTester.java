package SasankPagadala;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.*;

public class StoreTester
{
    
    protected ArrayList<Customer> customerList = new ArrayList<>();
    // ARRAY LIST IS FOR DIFFERENT ITEMS TO PRODUCTS
    ArrayList<Book> bookList = new ArrayList();
    ArrayList<DVDs> dvdList = new ArrayList();
    ArrayList<CDs> cdList = new ArrayList();
    
    // TOTAL AMOUNT OF MONEY THE STORE HAS
    private static double storeBank = 100000.00;
    private static int restockAmount = 0;
    
    // READING FROM CSV CALLED "preData.csv"
    Scanner fileScanner1 = new Scanner(new File("preData.csv"));
    public StoreTester()throws FileNotFoundException, IOException
    {
        // SCANNING THROUGH THE CSV AND READING THE PRODUCTS AND MAKING LISTS
        String line1;
        fileScanner1.nextLine();
        while(fileScanner1.hasNextLine())
        {
            line1 = fileScanner1.nextLine();
            String subStrings[] = line1.split(",");
            if(subStrings[1].startsWith("b"))
            {
                bookList.add(new Book(Double.parseDouble(subStrings[5]), subStrings[2], subStrings[3], Integer.parseInt(subStrings[4]), Integer.parseInt(subStrings[0])));
            }
            else if(subStrings[1].startsWith("d"))
            {
                dvdList.add(new DVDs(Double.parseDouble(subStrings[5]), subStrings[2], subStrings[3], Integer.parseInt(subStrings[4]), Integer.parseInt(subStrings[0])));
            }
            else if(subStrings[1].startsWith("c"))
            {
                cdList.add(new CDs(Double.parseDouble(subStrings[5]), subStrings[2], subStrings[3], Integer.parseInt(subStrings[4]), Integer.parseInt(subStrings[0])));
            }
        }
    }
    
    
//    // ADDING TO THE ORDER
    public void addOrder(int x, int id, int numWant, String customerName, String prodName, double prodPrice)
    {
//        
    }
    
    // MAKING A TEXT FILE BASED ON THE ORDERS/RESTOCKS FROM THE DAY
    public void endOfTheDay()
    {
        try
        {
            FileOutputStream fs = new FileOutputStream("Report.txt");
            PrintWriter outFS = new PrintWriter(fs);
            double totalSoldGain = 0.0;
            
//            // PRINTS THE TOTAL PURCHASES OF THE DAY
            outFS.println("Purchases of the day: ");
            for(int i = 0; i < customerList.size(); i++)
            {
                // PRINTS NAME, ITEM PURCHASED, TYPE OF THE ITEM, PRICE PER ITEM, AMOUNT BOUGHT, TOTAL PRICE OF THE PURCHASE
                outFS.println("Customer Name: " + customerList.get(i).getCustomerName() + "   Purchased: " + customerList.get(i).getProdName() + "   Type: " + customerList.get(i).getProdType() + "   Price Per Copy: $" + customerList.get(i).getProdPrice() + "   Total Copies Purchased: " + customerList.get(i).getProdWant() + "   Total Purchase: $" + (customerList.get(i).getProdPrice()*customerList.get(i).getProdWant()));
            }
            for(int i = 0; i < customerList.size(); i++)
            {
                totalSoldGain += customerList.get(i).getProdPrice()*customerList.get(i).getProdWant();
            }
            // PRINTS PREMIUM MEMBER
            outFS.println("Following Member got the Premium Membership today: ");
            if(customerList.size() != 0)
            {
                outFS.println(customerList.get(0).getCustomerName());
            }
            else if(customerList.size() == 0)
            {
                outFS.println("There Where No Customers Today.");
            }
            // PRINTS THE TOTAL MONEY MADE IN THE DAY
            outFS.println("Total Money Made Today: $" + totalSoldGain);
            // PINTS TOTAL MONEY LOST IN RESTOCKING
            outFS.println("Total Money Paid To Restock Today: $" + restockAmount);
            // PRINTS THE TOTAL PROFIT
            if(totalSoldGain < 0)
            {
                outFS.println("No Profit Was Made Today. Total Loss Of The Day: $" + (totalSoldGain - restockAmount));
            }
            else
            {
                outFS.println("Total Profit Of The Day: $" + (totalSoldGain - restockAmount));
            }
            // TOTAL MONEY IN THE BANK FOR THE STORE (ADDING TO THE OVERALL PROJECT)
            outFS.println("Total Money In The Bank For The Store: $" + storeBank);
            // Closing the Scanners
            outFS.close();
            fs.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Caught FileNotFoundException for output data txt. Try making sure the path is correct.");
        }
        catch (IOException ex)
        {
            System.out.println("Caught IOException when closing output stream. Try again.");
        }
    }
    
    // METHOD FOR PRINTING THE INVENTORY AT THE END OF THE DAY IN A CSV FILE
    public void endOfTheDayInv()
    {
        try
        {
            FileOutputStream fs = new FileOutputStream("EndOfDayInventory.csv");
            PrintWriter outFS = new PrintWriter(fs);
            
            // WRITE THE FORMAT
            outFS.println("productID,type,title,author/artist,numInStock,price");
            // LIST FOR BOOKS
            for(int i = 0; i < bookList.size(); i++)
            {
                outFS.println(bookList.get(i).getID() + "," + "book" + "," + bookList.get(i).getProductName() + "," + bookList.get(i).getPublisherName() + "," + bookList.get(i).getTotalItems() + "," + bookList.get(i).getPrice());
            }
            // LIST FOR THE CDs
            for(int i = 0; i < cdList.size(); i++)
            {
                outFS.println(cdList.get(i).getID() + "," + "cd" + "," + cdList.get(i).getProductName() + "," + cdList.get(i).getPublisherName() + "," + cdList.get(i).getTotalItems() + "," + cdList.get(i).getPrice());
            }
            // LIST FOR THE CDs
            for(int i = 0; i < dvdList.size(); i++)
            {
                outFS.println(dvdList.get(i).getID() + "," + "dvd" + "," + dvdList.get(i).getProductName() + "," + dvdList.get(i).getPublisherName() + "," + dvdList.get(i).getTotalItems() + "," + dvdList.get(i).getPrice());
            }
            // Closing the Scanners
            outFS.close();
            fs.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Caught FileNotFoundException for output data txt. Try making sure the path is correct.");
        }
        catch (IOException ex)
        {
            System.out.println("Caught IOException when closing output stream. Try again.");
        }
    }
    // ITEM GRABBER
    public String bookName(int index)
    {
        return bookList.get(index).getProductName();
    }
    public String cdName(int index)
    {
        return cdList.get(index).getProductName();
    }
    public String dvdName(int index)
    {
        return dvdList.get(index).getProductName();
    }
    // RESTOCKING
    public void bookRestock(int numAdd, int index)
    {
        bookList.get(index).restockProduct(numAdd);
        storeBank -= bookList.get(index).getPrice() * numAdd;
        this.restockAmount += bookList.get(index).getPrice() * numAdd;
    }
    public void cdRestock(int numAdd, int index)
    {
        cdList.get(index).restockProduct(numAdd);
        storeBank -= cdList.get(index).getPrice() * numAdd;
        this.restockAmount += bookList.get(index).getPrice() * numAdd;
    }
    public void dvdRestock(int numAdd, int index)
    {
        dvdList.get(index).restockProduct(numAdd);
        storeBank -= dvdList.get(index).getPrice() * numAdd;
        this.restockAmount += bookList.get(index).getPrice() * numAdd;
    }
    
    // BECAME A PREMIUM MEMBER
    public String becameAPremiumMember(String customerName)
    {
        return(customerName + " became a premium today.");
    }
    
    //  WORTH OF THE INVENTORY
    public void bookInvWorth()
    {
        double totalWorth = 0.0;
        for(int i = 0; i < bookList.size(); i++)
        {
            totalWorth += bookList.get(i).inventoryValue();
        }
        System.out.println("Total Book Inventory is Worth: $" + totalWorth);
    }
    public void cdInvWorth()
    {
        double totalWorth = 0.0;
        for(int i = 0; i < cdList.size(); i++)
        {
            totalWorth += cdList.get(i).inventoryValue();
        }
        System.out.println("Total CDs Inventory is Worth: $" + totalWorth);
    }
    public void dvdInvWorth()
    {
        double totalWorth = 0.0;
        for(int i = 0; i < dvdList.size(); i++)
        {
            totalWorth += dvdList.get(i).inventoryValue();
        }
        System.out.println("Total DVDs Inventory is Worth: $" + totalWorth);
    }
    
    
    // RETURNS TOTAL IN INVENTORY
    public int getTotalBooksInInventory(int index)
    {
        return bookList.get(index).getTotalItems();
    }
    public int getTotalDVDsInInventory(int index)
    {
        return dvdList.get(index).getTotalItems();
    }
    public int getTotalCDsInInventory(int index)
    {
        return cdList.get(index).getTotalItems();
    }
    
    
    // RETURNS PRICE
    public double getBookPrice(int index)
    {
        return bookList.get(index).getPrice();
    }
    public double getDVDPrice(int index)
    {
        return dvdList.get(index).getPrice();
    }
    public double getCDPrice(int index)
    {
        return cdList.get(index).getPrice();
    }
    
    
    // RETURN PRODUCTNAME
    public String getBookName(int index)
    {
        return bookList.get(index).getProductName();
    }
    public String getDVDName(int index)
    {
        return dvdList.get(index).getProductName();
    }
    public String getCDName(int index)
    {
        return cdList.get(index).getProductName();
    }
    
    
    //  RETURNING IDS
    public int returnBookID(int id)
    {
        int currInd = 0;
        for(int j = 0; j < bookList.size(); j++)
        {
            if(bookList.get(j).getID() == id)
            {
                currInd = j;
            }
        }
        return currInd;
    }
    public int returnDVDID(int id)
    {
        int currInd = 0;
        for(int j = 0; j < dvdList.size(); j++)
        {
            if(dvdList.get(j).getID() == id)
            {
                currInd = j;
            }
        }
        return currInd;
    }
    public int returnCDID(int id)
    {
        int currInd = 0;
        for(int j = 0; j < cdList.size(); j++)
        {
            if(cdList.get(j).getID() == id)
            {
                currInd = j;
            }
        }
        return currInd;
    }
    
    public void printBookList()
    {
        // PRINTS THE BOOK LIST IN THE INVENTORY
        for(int i = 0; i < bookList.size(); i++)
        {
            System.out.println(bookList.get(i));
        }
    }
    public void printDVDsList()
    {
        // PRINTS THE DVDs LIST IN THE INVENTORY
        for(int i = 0; i <dvdList.size(); i++)
        {
            System.out.println(dvdList.get(i));
        }
    }
    public void printCDsList()
    {
        // PRINTS THE CDs LIST IN THE INVENTORY
        for(int i = 0; i < cdList.size(); i++)
        {
            System.out.println(cdList.get(i));
        }
    }
}

