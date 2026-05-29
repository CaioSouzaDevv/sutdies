import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDb {
    

    private Connection conexao;
        private String user = "neondb_owner";
    private String password = "npg_dPy3iHGW1BpX";
    
    private String url = "jdbc:postgresql://ep-purple-water-aqr1iro4-pooler.c-8.us-east-1.aws.neon.tech/neondb?user=" + user + "&password=" + password + "&sslmode=require&channelBinding=require";





}


//Banco: jdbc:postgresql://ep-purple-water-aqr1iro4-pooler.c-8.us-east-1.aws.neon.tech/neondb?user=neondb_owner&password=npg_dPy3iHGW1BpX&sslmode=require&channelBinding=require
