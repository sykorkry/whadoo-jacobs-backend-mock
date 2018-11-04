package whadoo;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;

    private ArrayList<Integer> eventIdStorage = new ArrayList();

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void addEventId(Integer eventId) {
        eventIdStorage.add(eventId);
    }

    public boolean hasEventId(Integer eventId){
        return eventIdStorage.contains(eventId);
    }
}
