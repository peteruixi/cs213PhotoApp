package PhotoApp.util;

import java.util.UUID;

public class UniqueID {

    public static String generateUUID(){
        return UUID.randomUUID().toString();
    }
}
