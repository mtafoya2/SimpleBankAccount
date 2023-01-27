/**
 * Standard class that implements the bank account interface
 */
class StandardAccount implements bankAccount{
    /**
     * Holds the name of the account
     */
    private String name = "";
    /**
     * Holds the balance of the account
     */
    private double balance=0;


    public String getName(){
        return name;
    }
    public void setName(String N){
        this.name = N;
    }

    public double getBalance(){
        return balance;
    }
    public void setBalance(double B){
        this.balance = B;
    }

    public String getAccType(){
        return "Standard";
    }

    public double getRate(){
        return 0.005;
    }

}
