import java.util.HashMap;
public class Authenticate {
    HashMap<String, String> userDatabase = new HashMap<>();

    boolean Check(String enteredUsername, String enteredPassword) {
        userDatabase.put("rhythm", "077");
        userDatabase.put("zayaan", "058");
        userDatabase.put("nilansh", "069");

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