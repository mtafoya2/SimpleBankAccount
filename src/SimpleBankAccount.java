import java.util.*;

/**
 * Class that runs the program
 */
public class SimpleBankAccount {
    static Scanner read = new Scanner(System.in);
    public static void main(String args[]){
        //Accounts
        /**
         * Hashmap that stores the standard account
         */
        HashMap<String,StandardAccount> standAcc = new HashMap<String, StandardAccount>();
        /**
         * Hashmap that stores the VIP account
         */
        HashMap<String,VIPAccount> vipAcc = new HashMap<String, VIPAccount>();


        //FlAGs and useful variables
        /**
         * variable that ends the infinte while loop if the
         * end of the tasks are reached endFlag = true
         */
        boolean endFlag = false;
        /**
         * variable that chooses for the switch case statement
         */
        int choice = 0;

        while(!endFlag){
            do{
                menu();
                choice = read.nextInt();
                System.out.println("");
                if(choice < 1 || choice>8){
                    System.out.println("wrong choice!!\n");
                }
            }while(choice<1 && choice>8);

            switch(choice){
                case 1:
                    int yourChoice = 0;
                    boolean done = true;
                    do {
                        //Create Account
                        System.out.println("***Creat New Account***");
                        System.out.println("1. Create Standard Account");
                        System.out.println("2. Create VIP Account");
                        System.out.print("Enter your choice: ");
                        yourChoice = read.nextInt();
                        if(yourChoice<1 || yourChoice >2){
                            System.out.println("wrong choice!!\n");
                            done = false;
                        }
                    }while(!done);

                    if(yourChoice == 1)
                    {
                        standAcc = createStanAcc(standAcc);
                        System.out.println("Account Created!!\n");
                    } else if (yourChoice == 2) {
                        vipAcc = createVipAcc(vipAcc);
                        System.out.println("Account Created!!\n");
                    }
                    break;
                case 2:
                    //Display
                    Display(standAcc, vipAcc);
                    break;
                case 3:
                    //Withdraw
                    System.out.println("**Transaction - Withdraw");
                    System.out.print("Enter your name: ");
                    String Name = read.next();
                    System.out.print("Enter amount to withdraw: ");
                    double amount = read.nextDouble();

                    if (!standAcc.containsKey(Name) && !vipAcc.containsKey(Name)) {
                        System.out.println(Name + " does not exist\n");
                        break;
                    }


                    if(standAcc.containsKey(Name)){
                        if(standAcc.get(Name).getBalance() < amount){
                            System.out.println(Name + " Not enough balance \n");
                            break;
                        }
                        System.out.println("Name: " + standAcc.get(Name).getName());
                        double balance = standAcc.get(Name).getBalance();
                        balance = balance  - amount;
                        standAcc.get(Name).setBalance(balance);
                        System.out.println("Balance: " + standAcc.get(Name).getBalance());
                        System.out.println("");
                    }

                    if(vipAcc.containsKey(Name)){
                        if(vipAcc.get(Name).getBalance() < amount){
                            System.out.println(Name + " Not enough balance \n");
                            break;
                        }
                        System.out.println("Name: " + vipAcc.get(Name).getName());
                        double balance = vipAcc.get(Name).getBalance();
                        balance = balance  - amount;
                        vipAcc.get(Name).setBalance(balance);
                        System.out.println("Balance: " + vipAcc.get(Name).getBalance());
                        System.out.println("");
                    }
                    break;
                case 4:
                    //Deposit
                    System.out.println("**Transaction - Deposit");
                    System.out.print("Enter your name: ");
                    Name = read.next();
                    System.out.print("Enter amount to Deposit: ");
                    amount = read.nextDouble();

                    if(standAcc.containsKey(Name)){
                        System.out.println("Name: " + standAcc.get(Name).getName());
                        double balance = standAcc.get(Name).getBalance();
                        balance = balance  + amount;
                        standAcc.get(Name).setBalance(balance);
                        System.out.println("Balance: " + standAcc.get(Name).getBalance());
                        System.out.println("");
                    }

                    if(vipAcc.containsKey(Name)){
                        System.out.println("Name: " + vipAcc.get(Name).getName());
                        double balance = vipAcc.get(Name).getBalance();
                        balance = balance  + amount;
                        vipAcc.get(Name).setBalance(balance);
                        System.out.println("Balance: " + vipAcc.get(Name).getBalance());
                        System.out.println("");
                    }
                    break;
                case 5:
                    //Display All
                    if(!standAcc.isEmpty()){
                        System.out.println("Standard Account Details");
                        System.out.println("**Account Detail**");
                    }
                    for(String key: standAcc.keySet())
                    {
                        System.out.println("Name: " + standAcc.get(key).getName());
                        System.out.println("Account: " + standAcc.get(key).getAccType());
                        System.out.println("Balance: " + standAcc.get(key).getBalance());
                        System.out.println("");
                    }
                    if(!vipAcc.isEmpty()) {
                        System.out.println("VIP Account Details");
                        System.out.println("**Account Detail**");
                    }
                    for(String key: vipAcc.keySet())
                    {
                        System.out.println("Name: " + vipAcc.get(key).getName());
                        System.out.println("Account: " + vipAcc.get(key).getAccType());
                        System.out.println("Balance: " + vipAcc.get(key).getBalance());
                        System.out.println("");
                    }
                    break;
                case 6:
                    //Remove Account
                    System.out.println("**Transaction - remove Account**");
                    System.out.print("Enter your name: ");
                    Name = read.next();
                    if (!standAcc.containsKey(Name) && !vipAcc.containsKey(Name)) {
                        System.out.println(Name + " does not exist\n");
                        break;
                    }
                    if(standAcc.containsKey(Name)){
                        standAcc.remove(Name);
                        System.out.println("Account has been removed!!\n");
                    }
                    if(vipAcc.containsKey(Name)){
                        vipAcc.remove(Name);
                        System.out.println("Account has been removed!!\n");
                    }
                    break;
                case 7:
                    //Calculate Interest
                    double interest = 0;
                    System.out.println("**Transaction - calculate interests**");
                    System.out.print("Enter your name: ");
                    Name = read.next();

                    System.out.print("Enter the number of months: ");
                    int months = read.nextInt();

                    if (!standAcc.containsKey(Name) && !vipAcc.containsKey(Name)) {
                        System.out.println(Name + " does not exist\n");
                        break;
                    }

                    if(months<0 || months>12){
                        System.out.println("Invalid month number");
                        break;
                    }

                    if(standAcc.containsKey(Name)){
                        interest = standAcc.get(Name).getBalance()*standAcc.get(Name).getRate()*months;
                        System.out.println("The expected interest is: " + interest);
                        System.out.println("");
                    }
                    if(vipAcc.containsKey(Name)){
                        interest = vipAcc.get(Name).getBalance()*vipAcc.get(Name).getRate()*months;
                        System.out.println("The expected interest is: " + interest);
                        System.out.println("");
                    }
                    break;
                case 8:
                    System.out.println("Thanks for banking with us!!");
                    System.exit(0);
                    break;
            }



        }
    }

    /**
     * Method that prints out the menu
     */
    static void menu(){
        System.out.println("*** Menu ***");
        System.out.println("1: Create Account");
        System.out.println("2: Display");
        System.out.println("3: Withdraw");
        System.out.println("4: Deposit");
        System.out.println("5: Display All");
        System.out.println("6: Remove Account");
        System.out.println("7: Calculate Interest");
        System.out.println("8: Exit\n");
        System.out.print("Enter your choice: ");
    }

    //Create a standard account method

    /**
     * Method that creates a standard account and returns the account as a hashmap entry
     * @param account
     * @return account
     */
    static HashMap<String, StandardAccount> createStanAcc(HashMap<String, StandardAccount> account) {
        System.out.print("Enter your Name: ");
        String Name = read.next();
        System.out.print("Starting balance: ");
        double balance = read.nextDouble();
        account.put(Name, new StandardAccount());
        account.get(Name).setName(Name);
        account.get(Name).setBalance(balance);
        return account;
    }

    //Create a VIP account method
    /**
     * Method that creates a VIP account and returns the account as a hashmap entry
     * @param account
     * @return account
     */
    static HashMap<String, VIPAccount> createVipAcc(HashMap<String, VIPAccount> account) {
        System.out.print("Enter your Name: ");
        String Name = read.next();
        System.out.print("Starting balance: ");
        double balance = read.nextDouble();
        account.put(Name, new VIPAccount());
        account.get(Name).setName(Name);
        account.get(Name).setBalance(balance);
        return account;
    }

    /**
     * Method that takes in both standard and VIP accounts and prints out the contents of the accounts
     * @param account1
     * @param account2
     */
    static void Display(HashMap<String, StandardAccount> account1 ,HashMap<String, VIPAccount> account2){
        System.out.print("Enter your name: ");
        String Name = read.next();

        if(!account1.containsKey(Name) && !account2.containsKey(Name) ){
            System.out.println(Name + " does not exist\n");
            return;
        }
        if(account1.containsKey(Name)){
            System.out.println("**Account Details**");
            System.out.println("Name: " + account1.get(Name).getName());
            System.out.println("Account Type: " + account1.get(Name).getAccType());
            System.out.println("Balance: " + account1.get(Name).getBalance());
            System.out.println("");
        }
        if(account2.containsKey(Name)){
            System.out.println("**Account Details**");
            System.out.println("Name: " + account2.get(Name).getName());
            System.out.println("Account Type: " + account2.get(Name).getAccType());
            System.out.println("Balance: " + account2.get(Name).getBalance());
            System.out.println("");
        }
        return;
    }

}
