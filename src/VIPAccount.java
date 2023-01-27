/**
 * Class that implements the bank account interface
 */
class VIPAccount implements bankAccount{
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
        return "VIP";
    }

    public double getRate(){
        return 0.01;
    }
}
