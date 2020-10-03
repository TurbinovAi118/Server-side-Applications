package com.company;

public class Main  {

    public static void main(String[] args){

        House house1 = new House(1, "36-32", 52, 3, 2, "36th Ave, 34th St",  "residential building",  63);

        House house2 = new House(2, "36-18", 41, 1, 1, "35th Ave, 33rd St", "residential building", 67);

        House house3 = new House(3, "36-30", 75, 4, 3, "36th Ave, 34th St", "residential building", 65);

        House house4 = new House(4, "21-15", 41, 2, 1, "33rd Ave, 31rs St", "residential building", 76);

        House house5 = new House(5, "21-25", 53, 5, 2, "28th Ave 25th", "residential building", 81);

        House[] Houses = new House[5];
        Houses[0] = house1;
        Houses[1] = house2;
        Houses[2] = house3;
        Houses[3] = house4;
        Houses[4] = house5;


        System.out.println("Task A");
        for (int i = 0; i < 5; i++){
            if (Houses[i].roomAmount == 1) {
                System.out.println("Apartment num is " + Houses[i].apartmentNum + ", street is: " + Houses[i].street);
            }
        }
        System.out.println("-------");
        System.out.println("Task B");
        for (int i = 0; i < 5; i++){
            if (Houses[i].roomAmount == 1 && 1 < Houses[i].floor && Houses[i].floor < 5) {
                System.out.println("Apartment num is " + Houses[i].apartmentNum + ", street is: " + Houses[i].street);
            }
        }
        System.out.println("-------");
        System.out.println("Task C");
        for (int i = 0; i < 5; i++){
            if (Houses[i].area > 50) {
                System.out.println("Apartment num is " + Houses[i].apartmentNum + ", street is: " + Houses[i].street + ", apartment's area is: " + Houses[i].area);
            }
        }
        System.out.println("-------");


    }
    
}
