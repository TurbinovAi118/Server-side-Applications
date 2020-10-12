package com.company;


import java.util.HashMap;
import java.util.Map;

public class Main {




    public static void main(String[] args) {

        bankAccount firstBill = new bankAccount(1);

        bankAccount secondBill = new bankAccount(2, true, 100);

        bankAccount thirdBill = new bankAccount(3, false, -500);

        bankAccount fourthBill = new bankAccount(4, true, 1000);

        bankAccount fifthBill = new bankAccount(5);

        fifthBill.changeAmountOfMoney(-250);

        bankAccount[] bills = new bankAccount[5];
        bills[0] = firstBill;
        bills[1] = secondBill;
        bills[2] = thirdBill;
        bills[3] = fourthBill;
        bills[4] = fifthBill;

        HashMap <Integer, Integer> billsMap = new HashMap<>();


        findBills(5, bills);

        sortBills("ASC", bills);

        getTotalBillsMoney(bills);

        getTotalBillsMoneyAdvanced(bills);






    }

    public static void findBills(int num, bankAccount[] bills){

        for (int i = 0; i < bills.length; i++){

            if (bills[i].billId == num){

                bills[i].getInfo();

            }
        }
    }

   public static void sortBills(String sortType, bankAccount[] bills){

       HashMap <Integer, Integer> billsMap = new HashMap<>();
       for (int i = 0; i < bills.length; i++){
           billsMap.put(bills[i].billId, bills[i].getMoneyInfo());
       }

        if (sortType.toLowerCase().equals("asc")){
            billsMap.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).forEach(System.out::println);
        }
        else if (sortType.toLowerCase().equals("desc")){
            billsMap.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue()).forEach(System.out::println);
        }
        else{
            System.out.println("Wrong sort type, try again");
        }
    }

    public static void getTotalBillsMoney (bankAccount[] bills){
        int totalAmount = 0;
        for (int i = 0; i < bills.length; i++){
            totalAmount += bills[i].getMoneyInfo();
        }
        System.out.println("Total money amount: " + totalAmount);
    }

    public static void getTotalBillsMoneyAdvanced(bankAccount[] bills){
        int positiveBalance = 0;
        int negativeBalance = 0;
        for (int i = 0; i < bills.length; i++){
            if (bills[i].getMoneyInfo() > 0){
                positiveBalance += bills[i].getMoneyInfo();
            }
            else {
                negativeBalance += bills[i].getMoneyInfo();
            }
        }
        System.out.println("Available balance is: " + positiveBalance);
        System.out.println("Debt balance is: " + negativeBalance);
    }

}
