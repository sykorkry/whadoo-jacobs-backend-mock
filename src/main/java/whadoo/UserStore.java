package whadoo;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserStore {
    private Map<String, User> userStore = new HashMap();

    public boolean contains(String userName) {
        return userStore.containsKey(userName);
    }

    public User get(String userName) {
        if (userStore.containsKey(userName)) {
            return userStore.get(userName);
        }
        return null;
    }

    public void put(String userName, Integer eventId) {
        if (userStore.containsKey(userName)) {
            userStore.get(userName).addEventId(eventId);
        } else {
            User newUser = new User(userName);
            newUser.addEventId(eventId);
            userStore.put(userName, newUser);

        }
    }
}
