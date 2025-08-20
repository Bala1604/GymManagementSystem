package model;

public class Payment {
    private int id;
    private int memberId;
    private double amount;

    public Payment(int id, int memberId, double amount) {
        this.id = id;
        this.memberId = memberId;
        this.amount = amount;
    }

    public Payment(int memberId, double amount) {
        this.memberId = memberId;
        this.amount = amount;
    }

    public int getId() {
    	return id;
    	}
    public int getMemberId() { 
    	return memberId; 
    	}
    public double getAmount() {
    	return amount; 
    	}

    @Override
    public String toString() {
        return id + " - MemberID: " + memberId + " | Amount: " + amount;
    }
}
