public abstract class Product implements Comparable
{
    protected String title;
    protected String author;
    protected long id;
    protected double cost;
    protected int quantity;
   
    //Constructor
    public Product(String title, String author, double cost) 
    {
        this.title = title;
        this.author = author;
        this.cost = cost;
        this.quantity = 0;
    }

    //Two abstract methods that subclasses must use
    public abstract long hash();

    public abstract Product copy();

    public void compareTo(Product other) //Allows comparison of products by cost
    {
        double difference = this.getCost() - other.getCost();

        if (difference > 0)
            System.out.println(this.getTitle() + " costs more: $" + this.getCost());
        else if (difference < 0)
            System.out.println(other.getTitle() + " costs more: $" + other.getCost());
        else
            System.out.println(this.getTitle() + " and " + other.getTitle() + " have the same cost: $" + this.getCost());
    }
    
    //Prints the product variables
    public abstract String toString();

    //Getters for all the product variables
    //No setters because they don't change, except for quantity
    public String getTitle() 
    {
        return title;
    }

    public long getId() 
    {
        return id;
    }

    public double getCost() 
    {
        return cost;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}