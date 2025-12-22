import util.ConexionDB;
import java.sql.Connection;

public class App {
    public static void main(String[] args) throws Exception {
        try(Connection c = ConexionDB.getConnection()) {
            System.out.println("Conexión Exitosa :D");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
