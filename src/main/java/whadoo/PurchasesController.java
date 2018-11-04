package whadoo;

import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
public class PurchasesController {

    @Inject
    UserStore userStore;

    @Inject
    TokenStore tokenStore;

    private static final int eventIdTest = 42;
    private static final String userNameTest = "krulecp";


    @RequestMapping(value = "/purchases", method = RequestMethod.POST)
    public void addPurchase(
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "eventId") int eventId
    ) {
        System.out.println("Storing " + userName + " at event " + eventId);
        userStore.put(userName, eventId);
    }

    @RequestMapping(value = "/secret", method = RequestMethod.GET)
    public Token getSecret(
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "eventId") int eventId
    ) {
        System.out.println("Checking " + userName + " for event " + eventId);
        if (userStore.contains(userName)) {
            if (userStore.get(userName).hasEventId(eventId)) {
                Token token = new Token();
                tokenStore.addToken(token.getToken());
                System.out.println("Awarding token " + token.getToken());
                return token;
            }
        }
        return null;
    }

    @RequestMapping(value = "/checkToken", method = RequestMethod.GET)
    @CrossOrigin(origins = {"*"})
    public Result checkToken(
            @RequestParam(value = "token") String token
    ) {
        System.out.println("Checking " + token + " for validity");
        Result result = tokenStore.getResult(token);
        return result;
    }
}
