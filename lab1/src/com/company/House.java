package com.company;


public class House {

    public int Id;
    public String apartmentNum;
    public int area; //in m^2
    public int floor;
    public int roomAmount;
    public String street;
    public String buildingType;
    public int lifetime; //in years


    public House (int id, String aN, int ar, int fl, int rA, String st, String bT, int lt) {
        Id = id;
        apartmentNum = aN;
        area = ar;
        floor =fl;
        roomAmount = rA;
        street = st;
        buildingType = bT;
        lifetime = lt;

    }

    void getInfo () {
        System.out.println("House id: " + Id);
        System.out.println("Apartment number is: " +  apartmentNum);
        System.out.println("Area of apartment if: " + area);
        System.out.println("Apartment's floor: " + floor);
        System.out.println("Amount of room in apartment" + roomAmount);
        System.out.println("Street: " + street);
        System.out.println("Type of current building: " + buildingType);
        System.out.println("Lifetime of current building: " + lifetime);
        System.out.println("-----------");
    }

}


