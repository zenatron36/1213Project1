public class PaymentType 
{
    //Sketch class to be subclassed into individual payment types
    //This class does not do anything important
    private String creditCardInfo;
    private String moneyOrderInfo;
    private String checkInfo;

    //Generic getters and setters
    public String getCreditCardInfo() 
    {
        return this.creditCardInfo;
    }

    public void setCreditCardInfo(String creditCardInfo) 
    {
        this.creditCardInfo = creditCardInfo;
    }

    public String getMoneyOrderInfo() 
    {
        return this.moneyOrderInfo;
    }

    public void setMoneyOrderInfo(String moneyOrderInfo) 
    {
        this.moneyOrderInfo = moneyOrderInfo;
    }

    public String getCheckInfo() 
    {
        return this.checkInfo;
    }

    public void setCheckInfo(String checkInfo) 
    {
        this.checkInfo = checkInfo;
    }

}
