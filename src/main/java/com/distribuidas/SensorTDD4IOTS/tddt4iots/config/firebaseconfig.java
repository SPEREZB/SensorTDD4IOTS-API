package com.distribuidas.SensorTDD4IOTS.tddt4iots.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;

@Configuration
public class firebaseconfig {
    @Bean
    public Firestore firestore() throws Exception{
        FileInputStream serviceAccount = new FileInputStream("./sensortdd4iots-firebase-adminsdk-jydbk-10ca9f6037.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://sensortdd4iots-default-rtdb.firebaseio.com/")
                .build();

        FirebaseApp firebaseApp= FirebaseApp.initializeApp(options);
          return FirestoreClient.getFirestore(firebaseApp);
    }
/*
    @Bean
    public FirebaseDatabase firebaseDatabase() throws Exception{
        FileInputStream serviceAccount = new FileInputStream("./sensortdd4iots-firebase-adminsdk-jydbk-10ca9f6037.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://sensortdd4iots-default-rtdb.firebaseio.com/")
                .build();

        FirebaseApp.initializeApp(options);

        return FirebaseDatabase.getInstance();
    }*/
}
