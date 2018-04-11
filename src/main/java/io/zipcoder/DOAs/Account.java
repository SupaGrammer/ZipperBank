package io.zipcoder.DOAs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//POJO-JOJO
@Entity
public class Account {



    @Id
    @GeneratedValue
    @Column(name = "ACCOUNT_ID")
    private Long id;
    private enum Type {CREDIT, CHECKINGS, SAVINGS}
    @Column(name = "NICK_NAME")
    private String nickName;
    @Column(name = "REWARDS")
    private Integer rewards;
    @Column(name = "BALANCE")
    private double balance;
    @Column(name = "CUSTOMER")
    private Customer customer;
    /**
     * Id: Generated value assigned to the database
     * Type: An enum, when serialized prints out a string (savings,checkings,credit)
     * Nickname: String given upon creation describing the account ("Kieran")
     * Rewards: An integer representing the number of points that account holds
     * Balance: A primitive number data type showing the available amount of money associated with the account
     * Customer: Object linking to the associated account
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}




