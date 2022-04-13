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



    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
