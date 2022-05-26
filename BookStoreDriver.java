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

public class BookStoreDriver
{
    /**
     * @param args the command line arguments
     */
    
    // DEFAULT NAMES IN THE LIST FOR THE ORDERS
    public static void printNameList(ArrayList<String> names)
    {
        for(int i = 0; i < names.size(); i++)
        {
            System.out.println(names.get(i));
        }
    }
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        // ARRAY LIST OF THE OBJECTS
        StoreTester store = new StoreTester();
        // ARRAY LIST OF PEOPLE'S NAMES WHO ARE PREMIUM MEMBERSHIP HOLDER AND ARE REGULAR CUSTOEMRS
        ArrayList<String> premiumCustomerList = new ArrayList<>();
        premiumCustomerList.add("Mango R.");
        premiumCustomerList.add("Sasank P.");
        premiumCustomerList.add("Maggie N.");
        // VAR FOR CUSTOMER'S NAME AND SCANNERERS
        String customerName;
        Scanner cname = new Scanner(System.in);
        Scanner scnr = new Scanner(System.in);
        // FOR THE USER AND HOW MUCH HE WANTS PER ITEM
        int numWant;
        // WELCOME TO STORE MESSAGE
        System.out.println("||***************************||");
        System.out.println("## WELCOME TO SASANKS SASNAPPY BOOK STORE ##");
        System.out.println("||***************************||");
        System.out.println("");
        // ASKING FOR THE USER'S NAME
        System.out.println("Enter you name valued customer: ");
        customerName = cname.nextLine();
        // OPTIONS FOR THE CUSTOMER AT THE STORE
        System.out.println("Please select from the following menu of options, by typing a number:");
        System.out.println("\t 1. Order Products");
        System.out.println("\t 2. Become A Premium Member");
        System.out.println("\t 3. Restock Product");
        System.out.println("\t 4. Inventory Value");
        System.out.println("\t 5. Exit");
        // TAKING AN INPUT FOR WHAT THEY WANT TO DO
        int choice = 0;
        try
        {
            choice = scnr.nextInt();
        }
        catch(InputMismatchException e)
        {
            System.out.println("You entered a String instead of a number!");
        }
        // IF INPUT IS NOT FROM 1-5
        while(!(choice >= 1 && choice <= 5))
        {
            System.out.println("Invalid Input!");
            System.out.println("Please select from the following menu of options, by typing a number:");
            System.out.println("\t 1. Order Products");
            System.out.println("\t 2. Become A Premium Member");
            System.out.println("\t 3. Restock Product");
            System.out.println("\t 4. Inventory Value");
            System.out.println("\t 5. Exit");
            choice = scnr.nextInt();
        }
        
        
        
        // BEGIN THE MAIN CODE HERE --> FOR OPTION FROM THE MENU
        while(choice == 1 || choice == 2 || choice == 3 || choice == 4)
        {
            // FOR ORDERING PRODUCTS WHICH IS OPTION 1 IN THE MENU
            if(choice == 1)
            {
                System.out.println("What kind of product would you like to order?");
                System.out.println("\t 1. Books");
                System.out.println("\t 2. CDs");
                System.out.println("\t 3. DVDs");
                int inputChoice = 0;
                try
                {
                    inputChoice = scnr.nextInt();
                }
                catch(InputMismatchException e)
                {
                    System.out.println("You entered a String instead of a number!");
                }
                // FOR INVALID INPUT FROM THE BUY MENU OF BOOKS, CDS, AND DVDS
                while(inputChoice != 1 && inputChoice != 2 && inputChoice != 3)
                {
                    System.out.println("Invalid Input!");
                    System.out.println("\t 1. Books");
                    System.out.println("\t 2. CDs");
                    System.out.println("\t 3. DVDs");
                    inputChoice = scnr.nextInt();
                }
                // FOR BUYING BOOKS
                if(inputChoice == 1)
                {
                    // PRINTS ALL THE BOOKS
                    store.printBookList();
                    System.out.println("What book would you like to buy?");
                    System.out.println("Enter the ID: ");
                    int idScanner = 0;
                    try
                    {
                        idScanner = scnr.nextInt();
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("You entered a String instead of a number!");
                    }
                    while(!(idScanner >= 1 && idScanner <= 10))
                    {
                        System.out.println("Invalid Input!");
                        System.out.println("What book would you like to buy?");
                        System.out.println("Enter the ID: ");
                        idScanner = scnr.nextInt();
                    }
                    int currInd = store.returnBookID(idScanner);
                    int numStock = store.getTotalBooksInInventory(currInd);
                    System.out.println("Maximum you can buy is: " + numStock);
                    System.out.println("How many of these book would you like to buy?");
                    System.out.println("Enter the amount of book: ");
                    numWant = 0;
                    try
                    {
                        numWant = scnr.nextInt();
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("You entered a String instead of a number!");
                    }
                    while(numWant > numStock || numWant < 0)
                    {
                        System.out.println("You cannot buy " + numWant + " books.");
                        System.out.println("Maximum you can buy is: " + numStock);
                        System.out.println("How many of these book would you like to buy?");
                        System.out.println("Enter the amount of book: ");
                        numWant = scnr.nextInt();
                    }
                    store.addOrder(1, idScanner, numWant, customerName, store.getBookName(currInd), store.getBookPrice(currInd));
                    System.out.println("Your Total for this purchase: ");
                    System.out.println("\t Customer Name: " + customerName);
                    System.out.println("\t Product Type: Book");
                    System.out.println("\t Title: " + store.getBookName(currInd));
                    System.out.println("\t Price Per Book: $" + store.getBookPrice(currInd));
                    System.out.println("\t Price for " + numWant + " Books: $" + numWant*store.getBookPrice(currInd));
                }
                // FOR BUYING CDS
                else if(inputChoice == 2)
                {
                    // PRINTS ALL THE CDs
                    store.printCDsList();
                    System.out.println("What CDs would you like to buy?");
                    System.out.println("Enter the ID: ");
                    int idScanner = 0;
                    try
                    {
                        idScanner = scnr.nextInt();
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("You entered a String instead of a number!");
                    }
                    while(!(idScanner >= 11 && idScanner <= 13))
                    {
                        System.out.println("Invalid Input!");
                        System.out.println("What book would you like to buy?");
                        System.out.println("Enter the ID: ");
                        idScanner = scnr.nextInt();
                    }
                    int currInd = store.returnCDID(idScanner);
                    int numStock = store.getTotalCDsInInventory(currInd);
                    System.out.println("Maximum you can buy is: " + numStock);
                    System.out.println("How many of these CDs would you like to buy?");
                    System.out.println("Enter the amount of CDs: ");
                    numWant = 0;
                    try
                    {
                        numWant = scnr.nextInt();
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("You entered a String instead of a number!");
                    }
                    while(numWant > numStock || numWant < 0)
                    {
                        System.out.println("You cannot buy " + numWant + " books.");
                        System.out.println("Maximum you can buy is: " + numStock);
                        System.out.println("How many of these CDs would you like to buy?");
                        System.out.println("Enter the amount of CDs: ");
                        numWant = scnr.nextInt();
                    }
                    store.addOrder(3, idScanner, numWant, customerName, store.getCDName(currInd), store.getCDPrice(currInd));
                    System.out.println("Your Total for this purchase: ");
                    System.out.println("\t Customer Name: " + customerName);
                    System.out.println("\t Product Type: CD");
                    System.out.println("\t Title: " + store.getCDName(currInd));
                    System.out.println("\t Price Per Book: $" + store.getCDPrice(currInd));
                    System.out.println("\t Price for " + numWant + " CDs: $" + numWant*store.getCDPrice(currInd));
                }
                // FOR BUYING DVDS
                else if(inputChoice == 3)
                {
                    // PRINTS ALL THE DVDs
                    store.printDVDsList();
                    System.out.println("What DVDs would you like to buy?");
                    System.out.println("Enter the ID: ");
                    int idScanner = 0;
                    try
                    {
                        idScanner = scnr.nextInt();
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("You entered a String instead of a number!");
                    }
                    while(!(idScanner >= 14 && idScanner <= 15))
                    {
                        System.out.println("Invalid Input!");
                        System.out.println("What book would you like to buy?");
                        System.out.println("Enter the ID: ");
                        idScanner = scnr.nextInt();
                    }
                    int currInd = store.returnDVDID(idScanner);
                    int numStock = store.getTotalDVDsInInventory(currInd);
                    System.out.println("Maximum you can buy is: " + numStock);
                    System.out.println("How many of these DVDs would you like to buy?");
                    System.out.println("Enter the amount of DVDs: ");
                    numWant = 0;
                    try
                    {
                        numWant = scnr.nextInt();
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("You entered a String instead of a number!");
                    }
                    while(numWant > numStock || numWant < 0)
                    {
                        System.out.println("You cannot buy " + numWant + " books.");
                        System.out.println("Maximum you can buy is: " + numStock);
                        System.out.println("How many of these DVDs would you like to buy?");
                        System.out.println("Enter the amount of DVDs: ");
                        numWant = scnr.nextInt();
                    }
                    store.addOrder(2, idScanner, numWant, customerName, store.getDVDName(currInd), store.getDVDPrice(currInd));
                    System.out.println("Your Total for this purchase: ");
                    System.out.println("\t Customer Name: " + customerName);
                    System.out.println("\t Product Type: DVD");
                    System.out.println("\t Title: " + store.getDVDName(currInd));
                    System.out.println("\t Price Per Book: $" + store.getDVDPrice(currInd));
                    System.out.println("\t Price for " + numWant + " DVDs: $" + numWant*store.getDVDPrice(currInd));
                }
                // AT THE END COME BACK TO THE MAIN MENU
                System.out.println("Back to the Main Menu!");
                System.out.println("Please select from the following menu of options, by typing a number:");
                System.out.println("\t 1. Order Products");
                System.out.println("\t 2. Become A Premium Member");
                System.out.println("\t 3. Restock Product");
                System.out.println("\t 4. Inventory Value");
                System.out.println("\t 5. Exit");
                // TAKING AN INPUT FOR WHAT THEY WANT TO DO
                choice = 0;
                try
                {
                    choice = scnr.nextInt();
                }
                catch(InputMismatchException e)
                {
                    System.out.println("You entered a String instead of a number!");
                }
            }
            
            // FOR BECOMING PREMIUM MEMBERS WHICH IS OPTION 2 IN THE MENU
            else if(choice == 2)
            {
                premiumCustomerList.add(customerName);
                System.out.println("Congratulations! You are now a premium member of the book store!");
                store.becameAPremiumMember(customerName);
                // AT THE END COME BACK TO THE MAIN MENU
                System.out.println("Back to the Main Menu!");
                System.out.println("Please select from the following menu of options, by typing a number:");
                System.out.println("\t 1. Order Products");
                System.out.println("\t 2. Become A Premium Member");
                System.out.println("\t 3. Restock Product");
                System.out.println("\t 4. Inventory Value");
                System.out.println("\t 5. Exit");
                // TAKING AN INPUT FOR WHAT THEY WANT TO DO
                choice = 0;
                try
                {
                    choice = scnr.nextInt();
                }
                catch(InputMismatchException e)
                {
                    System.out.println("You entered a String instead of a number!");
                }
            }
            else if(choice == 3)
            {
                System.out.println("What would you like to restock?");
                System.out.println("\t 1. Books");
                System.out.println("\t 2. CDs");
                System.out.println("\t 3. DVDs");
                int inputChoice = 0;
                try
                {
                    inputChoice = scnr.nextInt();
                }
                catch(InputMismatchException e)
                {
                    System.out.println("You entered a String instead of a number!");
                }
                
                // FOR INVALID INPUT
                while(inputChoice != 1 && inputChoice != 2 && inputChoice != 3)
                {
                    System.out.println("Invalid Input!");
                    System.out.println("What would you like to restock?");
                    System.out.println("\t 1. Books");
                    System.out.println("\t 2. CDs");
                    System.out.println("\t 3. DVDs");
                    inputChoice = scnr.nextInt();
                }
                // FOR RESTOCKING BOOKS
                if(inputChoice == 1)
                {
                    // PRINTS LIST OF BOOKS
                    store.printBookList();
                    System.out.println("What Book would you like to restock?");
                    System.out.println("Enter the ID: ");
                    int idScanner = 0;
                    try
                    {
                        idScanner = scnr.nextInt();
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("You entered a String instead of a number!");
                    }
                    while(!(idScanner >= 1 && idScanner <= 10))
                    {
                        System.out.println("Invalid Input!");
                        System.out.println("What Book would you like to restock?");
                        System.out.println("Enter the ID: ");
                        idScanner = scnr.nextInt();
                    }
                    int currInd = store.returnBookID(idScanner);
                    String itemName = store.bookName(currInd);
                    int numStock = store.getTotalBooksInInventory(currInd);
                    System.out.println("There are total of " + numStock + " " + itemName + " books in the inventory.");
                    System.out.println("How many of these books would like to restock?");
                    System.out.println("Enter the amount of books: ");
                    numWant = 0;
                    try
                    {
                        numWant = scnr.nextInt();
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("You entered a String instead of a number!");
                    }
                    store.bookRestock(numWant, currInd);
                    System.out.println("Total of " + numWant + " books of" + itemName + " where added to the inventory.");
                    numStock = store.getTotalBooksInInventory(currInd);
                    System.out.println("There are total of " + numStock + " " + itemName + " books in the inventory.");
                }
                // FOR RESTOCKING CDS
                else if(choice == 2)
                {
                    // PRINTS LIST OF CDS
                    store.printCDsList();
                    System.out.println("What CDs would you like to restock?");
                    System.out.println("Enter the ID: ");
                    int idScanner = 0;
                    try
                    {
                        idScanner = scnr.nextInt();
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("You entered a String instead of a number!");
                    }
                    while(!(idScanner >= 11 && idScanner <= 13))
                    {
                        System.out.println("Invalid Input!");
                        System.out.println("What CD would you like to restock?");
                        System.out.println("Enter the ID: ");
                        idScanner = scnr.nextInt();
                    }
                    int currInd = store.returnCDID(idScanner);
                    String itemName = store.cdName(currInd);
                    int numStock = store.getTotalCDsInInventory(currInd);
                    System.out.println("There are total of " + numStock + " " + itemName + " CDs in the inventory.");
                    System.out.println("How many of these CDs would like to restock?");
                    System.out.println("Enter the amount of CDs: ");
                    numWant = 0;
                    try
                    {
                        numWant = scnr.nextInt();
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("You entered a String instead of a number!");
                    }
                    store.cdRestock(numWant, currInd);
                    System.out.println("Total of " + numWant + " CDs of" + itemName + " where added to the inventory.");
                    numStock = store.getTotalCDsInInventory(currInd);
                    System.out.println("There are total of " + numStock + " " + itemName + " CDs in the inventory.");
                }
                // FOR RESTOCKING DVDs
                else if(choice == 3)
                {
                    // PRINTS LIST OF DVDs
                    store.printDVDsList();
                    System.out.println("What DVDs would you like to restock?");
                    System.out.println("Enter the ID: ");
                    int idScanner = 0;
                    try
                    {
                        idScanner = scnr.nextInt();
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("You entered a String instead of a number!");
                    }
                    while(!(idScanner >= 14 && idScanner <= 15))
                    {
                        System.out.println("Invalid Input!");
                        System.out.println("What DVDs would you like to restock?");
                        System.out.println("Enter the ID: ");
                        idScanner = scnr.nextInt();
                    }
                    int currInd = store.returnDVDID(idScanner);
                    String itemName = store.dvdName(currInd);
                    int numStock = store.getTotalDVDsInInventory(currInd);
                    System.out.println("There are total of " + numStock + " " + itemName + " DVDs in the inventory.");
                    System.out.println("How many of these DVDs would like to restock?");
                    System.out.println("Enter the amount of DVDs: ");
                    numWant = 0;
                    try
                    {
                        numWant = scnr.nextInt();
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("You entered a String instead of a number!");
                    }
                    store.dvdRestock(numWant, currInd);
                    System.out.println("Total of " + numWant + " DVDs of" + itemName + " where added to the inventory.");
                    numStock = store.getTotalDVDsInInventory(currInd);
                    System.out.println("There are total of " + numStock + " " + itemName + " DVDs in the inventory.");
                }
                // AT THE END COME BACK TO THE MAIN MENU
                System.out.println("Back to the Main Menu!");
                System.out.println("Please select from the following menu of options, by typing a number:");
                System.out.println("\t 1. Order Products");
                System.out.println("\t 2. Become A Premium Member");
                System.out.println("\t 3. Restock Product");
                System.out.println("\t 4. Inventory Value");
                System.out.println("\t 5. Exit");
                // TAKING AN INPUT FOR WHAT THEY WANT TO DO
                choice = 0;
                try
                {
                    choice = scnr.nextInt();
                }
                catch(InputMismatchException e)
                {
                    System.out.println("You entered a String instead of a number!");
                }
            }
            else if(choice == 4)
            {
                System.out.println("Which Product's inventory value would you like to know?");
                System.out.println("\t 1. Books");
                System.out.println("\t 2. CDs");
                System.out.println("\t 3. DVDs");
                int inputChoice = 0;
                try
                {
                    inputChoice = scnr.nextInt();
                }
                catch(InputMismatchException e)
                {
                    System.out.println("You entered a String instead of a number!");
                }
                while(inputChoice != 1 && inputChoice != 2 && inputChoice != 3)
                {
                    System.out.println("Invalid Input!");
                    System.out.println("Which Product's inventory value would you like to know?");
                    System.out.println("\t 1. Books");
                    System.out.println("\t 2. CDs");
                    System.out.println("\t 3. DVDs");
                    inputChoice = scnr.nextInt();
                }
                // FOR CHECKING BOOKS' WORTH
                if(inputChoice == 1)
                {
                    store.bookInvWorth();
                }
                // FOR CHECKING CDS' WORTH
                else if(inputChoice == 2)
                {
                    store.cdInvWorth();
                }
                // FOR CHECKING DVDS' WORTH
                else if(inputChoice == 3)
                {
                    store.dvdInvWorth();
                }
                // AT THE END COME BACK TO THE MAIN MENU
                System.out.println("Back to the Main Menu!");
                System.out.println("Please select from the following menu of options, by typing a number:");
                System.out.println("\t 1. Order Products");
                System.out.println("\t 2. Become A Premium Member");
                System.out.println("\t 3. Restock Product");
                System.out.println("\t 4. Inventory Value");
                System.out.println("\t 5. Exit");
                // TAKING AN INPUT FOR WHAT THEY WANT TO DO
                choice = 0;
                try
                {
                    choice = scnr.nextInt();
                }
                catch(InputMismatchException e)
                {
                    System.out.println("You entered a String instead of a number!");
                }
            }
        }
        
        // IF THE INPUT IS 5 THEN THE CODE SHOULD PRINT EVERYTHING FOR THE DAY
        if(choice == 5)
        {
            System.out.println("End Of The Day Report!");
            store.endOfTheDay();
            store.endOfTheDayInv();
        }
    }
}


