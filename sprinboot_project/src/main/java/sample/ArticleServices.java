package sample;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.internal.NonNull;
import javafx.concurrent.Task;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ArticleServices {
    public static final String COL_NAME="Articles";

    public String saveArticleDetails(Articles articles) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(articles.getTitle()).set(articles);
        return collectionsApiFuture.get().getUpdateTime().toString(); }

    public Articles getArticlesDetails(String title) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(title);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Articles article = null;
        if(document.exists()) {
           article = document.toObject(Articles.class);
            return article;
        }else {
            return null;
        }}

        public String deleteArticle(String title) {
            Firestore dbFirestore = FirestoreClient.getFirestore();


            ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(title).delete();
            return "Document with Articles ID "+title+" has been deleted";
        }

    }



