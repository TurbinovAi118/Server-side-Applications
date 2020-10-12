package com.company;


public class bankAccount {

    public int billId = 0;
    private boolean invoiceStatus = true;
    private int amountOfMoney = 0;

    public bankAccount (int bId, boolean invStat, int moneyAmount) {

        billId = bId;
        invoiceStatus = invStat;
        amountOfMoney = moneyAmount;

    }

    public bankAccount (int bId) {

        billId = bId;

    }

    void getInfo () {

        changeInvoiceStatus();
        System.out.println("Bill Id is: " + billId);
        System.out.println("The amount of money in the account: " + amountOfMoney);

        if (invoiceStatus) {
            System.out.println("Invoice status is: unblocked");
        }
        else {
            System.out.println("Invoice status is: blocked");
        }

        System.out.println("---------");
    }

    int getMoneyInfo(){
        return amountOfMoney;
    }

    void refill (int amountOfMoney) {

        this.amountOfMoney = amountOfMoney;

    }

    void changeInvoiceStatus () {

        if (amountOfMoney < 0){
            invoiceStatus = false;
        }
        else if (amountOfMoney >= 0){
            invoiceStatus = true;
        }

    }

    void changeAmountOfMoney (int amountOfMoney) {

        if (amountOfMoney > 0){
            this.amountOfMoney = this.amountOfMoney + amountOfMoney;
        }
        else if (amountOfMoney < 0) {
            this.amountOfMoney = this.amountOfMoney - amountOfMoney;
        }

    }

}
