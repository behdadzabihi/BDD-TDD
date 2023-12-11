package org.sample.bdd.tdd.dip;
import java.util.HashMap;
import java.util.Map;
public class GameDataAccess implements IGameDataAccess {


    private final Map<Long,String> data=new HashMap<>();

    public GameDataAccess() {
        data.put(1L,"PUBG");
        data.put(2L,"CALL OF DUTY");
        data.put(3L,"GTA");
    }


    public String findBy(Long id){
        return data.get(id);
    }
}
