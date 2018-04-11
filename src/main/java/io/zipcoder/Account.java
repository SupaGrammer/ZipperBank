package io.zipcoder;

//POJO-JOJO
public abstract class Account {

    public enum Type{CREDIT,CHECKINGS,SAVINGS}
    private long id;
    private String nickName;
    private Integer rewards;
    private double balance;
    private Account customer;
    /**
     * Id: Generated value assigned to the database
     * Type: An enum, when serialized prints out a string (savings,checkings,credit)
     * Nickname: String given upon creation describing the account ("Kieran")
     * Rewards: An integer representing the number of points that account holds
     * Balance: A primitive number data type showing the available amount of money associated with the account
     * Customer: Object linking to the associated account
     */

    public static Account createAccount(Type accountType) {
        switch (accountType){
            //the parts in red are classes that need to be created that extend this class with their own
            //overridden methods to display the account name
            case CREDIT:
                return new CreditAccount();
            case CHECKINGS:
                return new CheckingAccount();
            case SAVINGS:
                return new SavingAccount();
        } throw new IllegalArgumentException("The Bank account type " + accountType + " is not recognized.");
    }

    @Override
    public String toString(){
        return this.nickName + " - " + this.id;
    }

    public Account customer(long id, String nickName, Integer rewards, double balance, Account customer) {
        this.id = id;
        this.nickName = nickName;
        this.rewards = rewards;
        this.balance = balance;
        this.customer = customer;
        return this.customer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getRewards() {
        return rewards;
    }

    public void setRewards(Integer rewards) {
        this.rewards = rewards;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account getCustomer() {
        return customer;
    }

    public void setCustomer(Account customer) {
        this.customer = customer;
    }
}




