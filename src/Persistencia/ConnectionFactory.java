package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    Connection con = null;

    public Connection getConnection() {
        try {

            // Este banco de dados está hospedados no Azure.
            // Caso não queiram usá-lo, basta que alterem as strings.
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://br-cdbr-azure-south-a.cloudapp.net:3306/projeto_integrador",
                    "ba3789dc21d60f", "95f4202b");
            return con;

        } catch (Exception e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
        return con;
    }

    public void close() {
        try {
            if (con != null)
                con.close();
        } catch (Exception e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
    }
}
