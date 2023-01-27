/**
 * Interface that defines my functions for Standard and VIP accounts
 */
interface bankAccount {
    //methods of functions in classes

    /**
     * Method used to get the name of the account
     * @return String name
     */
    String getName();

    /**
     * Method that sets the string name in the account
     * @param N
     */
    void setName(String N);

    /**
     * Method that gets the balance in the account
     * @return double Balance
     */
    double getBalance();

    /**
     * Method to set the Balance in my account
     * @param B
     */
    void setBalance(double B);

    /**
     * method to get the type of account
     * @return Standard or VIP
     */
    String getAccType();

    /**
     * Method to get the rate for the respective account type
     * @return
     */
    double getRate();
}




