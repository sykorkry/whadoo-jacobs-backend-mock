package whadoo;

import javax.inject.Inject;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Token {
    private String token;
    private final int expiresIn = 60;

    public Token() {
        this.token = UUID.randomUUID().toString();
        new Thread(new TokenLifeCycle(token)).start();
    }

    public String getToken() {
        return token;
    }

    public int getExpiresIn(){
        return expiresIn;
    }
}


class TokenLifeCycle extends Thread {
    @Inject
    TokenStore tokenStore;

    String token;

    TokenLifeCycle(String token) {
        this.token = token;
    }

    public void run() {
        System.out.println("Token created");
        try {
            for (int i = 0; i < 6; i++) {
                System.out.println("For token " + token + " remains " + (60 - 10 * i));
                TimeUnit.SECONDS.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tokenStore.removeToken(token);
        System.out.println("Token destroyed");

    }
}

