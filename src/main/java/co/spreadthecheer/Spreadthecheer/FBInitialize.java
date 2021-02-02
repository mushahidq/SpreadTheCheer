package co.spreadthecheer.Spreadthecheer;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Service
public class FBInitialize {

    @PostConstruct
    public void initialize() {
        try {
            FileInputStream serviceAccount = new FileInputStream("E:\\Projects\\spreadTheCheer\\spreadthecheer\\src\\main\\java\\co\\spreadthecheer\\Spreadthecheer\\db-for-spread-the-cheer-firebase-adminsdk-k1usf-f953d69641.json");
            FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).setDatabaseUrl("https://db-for-spread-the-cheer-default-rtdb.firebaseio.com").build();
            FirebaseApp.initializeApp(options);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
