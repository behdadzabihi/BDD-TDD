package org.sample.bdd.tdd.dip;



public class ProgramApp {
    public static void main(String[] args) {

        GameBusiness gameBusiness=new GameBusiness(new GameDataAccess());
        String name = gameBusiness.playWith(3L);
        System.out.println("The Game Name Is " + name);

    }
}
