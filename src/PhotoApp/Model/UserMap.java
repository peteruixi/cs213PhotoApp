package PhotoApp.Model;

import java.io.*;
import java.util.HashMap;

/**
 *
 */
public class UserMap implements Serializable {

    String dataPath = "resources/persistence/userSerial.ser";
    static final long serialVersionUID = 1L;

    HashMap<String, User> userMap = new HashMap<>();

    /**
     *
     * @return
     * @throws FileNotFoundException
     */
    public HashMap getUserMap() throws IOException {
        loadSerializedFile();
        return userMap;
    }

    /**
     *
     * @throws FileNotFoundException
     */
    public void loadSerializedFile() throws IOException {
        try {
            FileInputStream fileInput = null;
            fileInput = new FileInputStream(dataPath);
            ObjectInputStream mapInput = null;
            mapInput = new ObjectInputStream(fileInput);


            userMap = (HashMap<String, User>) mapInput.readObject();
            mapInput.close();
            fileInput.close();
        }
        catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
            userMap = new HashMap<>();
            saveSerializedFile();
        }

    }

    /**
     *
     * @throws IOException
     */
    public void saveSerializedFile()  {
        ObjectOutputStream mapOutput = null;
        try {
            mapOutput = new ObjectOutputStream(new FileOutputStream(dataPath));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOEXCEPTION file path");

        }
        try {
            mapOutput.writeObject(userMap);
        } catch (IOException e) {
            System.out.println("IOEXCEPTION write");
        }
    }

    public void addUser(User user) throws IOException {
        loadSerializedFile();
        if(userMap.containsKey(user.getUserName())){
            throw new IllegalArgumentException("Username already exists.");
        }
        userMap.put(user.getUserName(),user);
        saveSerializedFile();

    }

}
