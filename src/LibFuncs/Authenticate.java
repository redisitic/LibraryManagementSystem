package LibFuncs;
import java.util.*;
public class Authenticate {
    HashMap<String, String> userDatabase = new HashMap<>();

    public boolean Check(String enteredUsername, String enteredPassword) {
        userDatabase.put("Rhythm", "077");
        userDatabase.put("Minav", "083");
        userDatabase.put("Yashank", "089");

        if (userDatabase.containsKey(enteredUsername)) {
            String storedPassword = userDatabase.get(enteredUsername);
            if (enteredPassword.equals(storedPassword)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}