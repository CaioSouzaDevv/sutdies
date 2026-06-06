import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDb {

    private Connection conexao;
    private String user = "neondb_owner";
    private String password = "npg_EvOxly18PgId";

    private String url = "jdbc:postgresql://host/banco?sslmode=require&channelBinding=require";

    try
    {
        conexao = DriverManager.getConnection(url, user, password);
        System.out.println("Conexão estabelecida com sucesso");

    }catch(
    Exception e)
    {
        System.out.println("Erro ao conectar: " + e.getMessage());
    }

}

// Banco:
// jdbc:postgresql://ep-twilight-bush-acrhyhm3-pooler.sa-east-1.aws.neon.tech/neondb?user=neondb_owner&password=npg_EvOxly18PgId&sslmode=require&channelBinding=require
