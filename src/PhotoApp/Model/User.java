package PhotoApp.Model;

import PhotoApp.util.UniqueID;

import java.io.Serializable;

public class User implements Serializable {
    static final long serialVersionUID = 1L;

    private String ID;
    private String userName;
    private String password;

    public User(String uName, String pWord){
        ID = UniqueID.generateUUID();
        this.userName = uName;
        this.password = pWord;
    }
}
