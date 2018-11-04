package whadoo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TokenStore {
    List<String> tokenStore = new ArrayList<>();

    public void addToken(String token){
        tokenStore.add(token);
    }

    public void removeToken(String token){
        tokenStore.remove(token);
    }

    public Result getResult(String token){
        boolean result = tokenStore.contains(token);
        if(result == true){
            System.out.println(token + " valid, removing token from store");
            removeToken(token);
        }
        return new Result(result);
    }
}
