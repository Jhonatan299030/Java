package escolalura;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Arrays;
import java.util.Date;

public class Principal {
    public static void main(String[] args){
        MongoClient client = new MongoClient();
        Gson parser = new Gson();
        MongoCollection<Document> alunos = client.getDatabase("test").getCollection("alunos");
        System.out.println(alunos.find().first().get("nome"));
        
//        insertTest(alunos);
//        updateTest(alunos,"nome", "Celina Prates", "Celina Regina Salomão Prates");
//        deleteTest(alunos, "nome", "Celina Regina Salomão Prates");
        deleteTest(alunos, "nome", "Celina Regina Salomão Prates", true);
        client.close();
    }

    public static void insertTest(MongoCollection<Document> collection){
        Document novoAluno = new Document("nome", "Celina Prates");
        novoAluno.append("data_nascimento", new Date(2009, 2, 9));
        novoAluno.append("notas", Arrays.asList(10, 9, 8.5));
        novoAluno.append("curso", new Document("nome", "História"));
        novoAluno.append("habilidades",
            Arrays.asList(
                new Document("nome", "ingles").append("nível", "Avançado"),
                new Document("nome", "Espanhol").append("nível", "básico")
            )
        );

        collection.insertOne(novoAluno);
    }

    public  static void updateTest(MongoCollection<Document> collection, String keyF, String valueF, String valueR){
        collection.updateOne(Filters.eq(keyF, valueF), new Document("$set", new Document(keyF, valueR)));
    }
    
    public  static void updateTest(MongoCollection<Document> collection, String keyF, String valueF, String keyR, String valueR){
        collection.updateOne(Filters.eq(keyF, valueF), new Document("$set", new Document(keyR, valueR)));
    }

    public static void deleteTest(MongoCollection<Document> collection, String keyF, String valueF){
        collection.deleteOne(Filters.eq(keyF, valueF));
    }

    public static void deleteTest(MongoCollection<Document> collection, String keyF, String valueF, Boolean many){
        collection.deleteMany(Filters.eq(keyF, valueF));
    }
}