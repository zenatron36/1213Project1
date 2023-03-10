import java.util.Scanner;
/*
 * @author pv
 */

public class TestHarness 
{
    public static void main(String[] args) 
    {
        Bookstore store = new Bookstore();
        Scanner sc = new Scanner(System.in);

        //Initializes some test Members
        Member member1 = new Member("Kevin", "Aswani", false);
        Member member2 = new Member("Bob", "Loblaw", true);
        Member member3 = new Member("Georgiy", "Smesharik", false);

        //Adds test Members into memberList
        store.addMember(member1);
        store.addMember(member2);
        store.addMember(member3);

        //Initializes some test Products
        Book book1 = new Book("Fahrenheit 451","Ray Bradbury", 19.99);
        Book book2 = new Book("1984", "George Orwell", 69.99);
        CD cd1 = new CD("Turkish National Anthem", "Nursultan Tuleakbav", "Turkiye", 1.49);
        CD cd2 = new CD("Deer Sounds", "Jim Stuart", "Animal Noises", 134.79);
        DVD dvd1 = new DVD("Shrek 5", "Sharik", "Pixar", 20.99);
        DVD dvd2 = new DVD("Meshok Yablok", "Yuri Frankovich", "Mosfilm", 0.01);

        //Adds 100 of each product into inventory
        store.addIntoInventory(book1, 100);
        store.addIntoInventory(book2, 100);
        store.addIntoInventory(cd1, 100);
        store.addIntoInventory(cd2, 100);
        store.addIntoInventory(dvd1, 100);
        store.addIntoInventory(dvd2, 100);
        
        //Prints out the size of the inventory and all test Members
        System.out.println(store.inventory.size());
        System.out.println(member1.toString());
        System.out.println(member2.toString());
        System.out.println(member3.toString());

        // //Makes some test purchases
        // store.makePurchase(member1, book1, 10, new PaymentType());
        // store.makePurchase(member2, cd1, 10, new PaymentType());
        // store.makePurchase(member3, book1, 10, new PaymentType());

        // //Prints the Members again
        // System.out.println(member1.toString());
        // System.out.println(member2.toString());
        // System.out.println(member3.toString());

        // //Prints the quantities of products
        // System.out.println(book1.getQuantity());
        // System.out.println(cd1.getQuantity());
        // System.out.println(book2.getQuantity());

        // System.out.println(store.transactions.get(0).toString());
        // System.out.println(store.transactions.get(1).toString());
        // System.out.println(store.transactions.get(2).toString());

        /* 
         * Stuff we want the user to do through the console:
         * 
         *      Register a new member
         *      Make a purchase
         *      Look through the transaction list
         *      Add a new product
         *      Update manually stock of existing products
         *      Check how much is left in stock of products
         */

         while (true)
         {
            //Check what the user wants to do
            System.out.println("");
            System.out.println("Select an option by typing a number:");
            System.out.println("\t 1. Register New Member");
            System.out.println("\t 2. View Member List");
            System.out.println("\t 3. Make Purchase");
            System.out.println("\t 4. View Transaction List");
            System.out.println("\t 5. Add New Product");
            System.out.println("\t 6. Add Existing Inventory");
            System.out.println("\t 7. Check Stock");
            System.out.println("\t 8. Exit");

            int num = sc.nextInt();
            sc.nextLine();

            switch (num)
            {
                case 1:
                System.out.println("<<< Registering New Member >>>");
                System.out.println("Enter First Name:");
                String firstName = sc.nextLine();
                System.out.println("Enter Last Name:");
                String lastName = sc.nextLine();
                System.out.println("Premium Member? (Y/N)");
                char letter = sc.next().charAt(0);
                boolean premium = false;
                if (letter == 'Y' || letter == 'y')
                {
                    premium = true;
                }
                Member newMember = new Member(firstName, lastName, premium);
                store.addMember(newMember);

                System.out.println("New Member Registered with Credentials:");
                System.out.println(newMember);
                break;

                case 2:
                System.out.println("<<< Viewing Member List >>>");
                for (Member member : store.memberList)
                {
                    System.out.println(member);
                }
                break;

                case 3:
                System.out.println("<<< Making a Purchase >>>");
                purchaseOptions(store);
                break;

                case 4:
                System.out.println("<<< Viewing Transaction List >>>");
                for (Transaction transaction : store.transactions)
                {
                    System.out.println(transaction);
                }
                break;

                case 5:
                System.out.println("<<< Adding a New Product >>>");
                System.out.println("Enter the title of the product");
                String title = sc.nextLine();
                System.out.println("Enter the author of the product");
                String author = sc.nextLine();
                System.out.println("Enter the cost of the product");
                double newProductCost = sc.nextDouble();
                sc.nextLine();
                System.out.println("What kind of product is it? (CD/DVD/Book)");
                String type = sc.nextLine();
                System.out.println("Enter many units to add");
                int units = sc.nextInt();
                sc.nextLine();

                if ("book".equalsIgnoreCase(type))
                {
                    store.addIntoInventory(new Book(title, author, newProductCost), units);
                }
                else if ("cd".equalsIgnoreCase(type))
                {
                    System.out.println("What is the album for the CD?");
                    String album = sc.nextLine();
                    store.addIntoInventory(new CD(title, author, album, newProductCost), units);
                }
                else if ("dvd".equalsIgnoreCase(type))
                {
                    System.out.println("What is the studio for the DVD?");
                    String studio = sc.nextLine();
                    store.addIntoInventory(new DVD(title, author, studio, newProductCost), units);
                }
                break;

                case 6:
                System.out.println("<<< Adding into Inventory >>>");
                System.out.println("Enter the ID of the product to edit");
                long id = sc.nextLong();
                sc.nextLine();
                System.out.println("Enter the new quantity");
                int quantity = sc.nextInt();
                sc.nextLine();
                for (Product product : store.inventory)
                {
                    if (product.getId() == id)
                    {
                        product.setQuantity(quantity);
                        break;
                    }
                }
                break;

                case 7:
                System.out.println("<<< Checking Stock >>>");
                for (Product product : store.inventory)
                {
                    System.out.println(product);
                }
                break;

                case 8:
                System.exit(0);
                break;
            }
         }
    }

    //Displays the Purhcasing Options
    public static void purchaseOptions(Bookstore store)
    {
        Scanner scan = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();
        //Print what's in stock
        for (Product product : store.inventory)
        {
            System.out.println(product);
        }
        
        while (true)
        {
            System.out.println("");
            System.out.println("Select an option by typing a number:");
            System.out.println("\t 1. Add a Product to cart");
            System.out.println("\t 2. Check Out");
            System.out.println("\t 3. Exit");

            int cartNum = scan.nextInt();
            scan.nextLine();

            switch (cartNum)
            {
                case 1:
                System.out.println("< Adding Items to Cart >");
                System.out.println("Type product ID to add to cart:");
                long itemToAdd = scan.nextLong();
                scan.nextLine();
                System.out.println("Enter the quantity to add to cart:");
                int quantityToBuy = scan.nextInt();
                scan.nextLine();

                for (Product product : store.inventory)
                {
                    //Adds the product to cart if the title matches
                    if (product.getId() == itemToAdd)
                    {
                        cart.addIntoInventory(product, quantityToBuy);
                        break;
                    }
                }
                break;

                case 2:
                System.out.println("< Checking Out >");
                System.out.println("Confirm Items in Cart:");
                for (Product item : cart.contents)
                {
                    System.out.println(item);
                    System.out.println(cart);
                }

                System.out.println("Enter ID of Buyer");
                long id = scan.nextLong();
                scan.nextLine();
                for (Member member : store.memberList)
                {
                    if (member.getId() == id)
                    {
                        System.out.println(member);
                    }
                }

                System.out.println("Enter Payment Type: (feature not implemented)");
                PaymentType pType = new PaymentType();

                System.out.println("Ready to Buy? (Y/N)");
                char ready = scan.nextLine().charAt(0);
                if(ready == 'Y' || ready == 'y')
                {
                    for (Product item : cart.contents)
                    {
                        if (store.makePurchase(store.getMemberByID(id), item, item.getQuantity(), pType) == true)
                        {
                            System.out.println("Successfully purchased " + item.getTitle());
                        }
                        else {System.out.println("Something went wrong!");}
                    }
                }
                else
                {
                    System.out.println("Transaction Cancelled");
                }
                break;

                case 3:
                System.out.println("< Exiting... >");
                return;
            }
        }
    }
}