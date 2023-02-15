public class DVD extends Product 
{
    private String studio;
    //DVDs are for video formats
    //Includes studio field

    public DVD(String title, String author, String studio, double cost) 
    {
        super(title, author, cost);
        this.studio = studio;
        this.id = hash();
    }

    @Override
    public long hash() 
    {
        //Returns generated hash
        long result = 17;
        result = 37 * result + title.hashCode();
        result = 37 * result + author.hashCode();
        result = 37 * result + studio.hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        return "Product: " + title + " || Author: " + author + " || Studio: " + studio + " || with ID: " + id + " || price: " + cost + " || Qty: " + quantity;
    }
        
}
