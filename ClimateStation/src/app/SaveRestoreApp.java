package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albert
 */
public class SaveRestoreApp {

    public SaveRestoreApp() {

    }

    public void save(HashMap<String, Athlete> myHashMap) {
        try {

            FileOutputStream fileOutputStream = new FileOutputStream("myMap.whateverExtension");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(myHashMap);
            objectOutputStream.close();
        } catch (FileNotFoundException fne) {

        } catch (IOException io) {

        }

    }

    public void read() {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("myMap.whateverExtension");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            HashMap<String,Athlete> myNewlyReadInMap = (HashMap) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println(myNewlyReadInMap.get("Albert Havnegjerde").getName());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveRestoreApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SaveRestoreApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveRestoreApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
