package org.sample.bdd.tdd.dip;

    public class GameBusiness {

    IGameDataAccess gameDataAccess;

    public GameBusiness(IGameDataAccess gameDataAccess) {
        this.gameDataAccess = gameDataAccess;
    }

    public String playWith(Long id){
       return gameDataAccess.findBy(id);

    }
}
