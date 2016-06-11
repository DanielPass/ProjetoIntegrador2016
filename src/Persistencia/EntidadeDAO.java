package Persistencia;

import java.sql.*;
import java.util.List;

/**
 * Created by adson on 11/06/16.
 */
public abstract class EntidadeDAO<T> {

    protected Connection con;
    protected Statement stm;
    protected PreparedStatement stmt;

    public EntidadeDAO() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();
    }

    public abstract boolean cadastrar(T t);
    public abstract T alterar(T t);
    public abstract T excluir(T t);
    public abstract List<T> consultar();
    public abstract T consultar(int id);
    public abstract ResultSet executarSQL(String sql) throws SQLException;
}
