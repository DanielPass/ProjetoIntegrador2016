package Persistencia;

import Model.Entidades.Curso;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by adson on 11/06/16.
 */
public class CursoDAO extends EntidadeDAO<Curso> {

    public CursoDAO(){
        super();
    }

    @Override
    public boolean cadastrar(Curso curso) {
        return false;
    }

    @Override
    public Curso alterar(Curso curso) {
        return null;
    }

    @Override
    public Curso excluir(Curso curso) {
        return null;
    }

    @Override
    public List<Curso> consultar() {
        return null;
    }

    @Override
    public Curso consultar(int id){
        Curso curso = new Curso();

        ResultSet res = null;

        try {

            String sql = "SELECT * FROM curso WHERE codigo_curso="+id;
            stm = con.createStatement();
            res = stm.executeQuery(sql);

            if(res.next()) {
                curso.setId(res.getInt("codigo_curso"));
                curso.setNome(res.getString("nome"));
                curso.setQuantidadePeriodos(res.getInt("periodos"));
                curso.setNomeCoordenador(res.getString("coordenador"));
            }

            con.close();

        } catch (SQLException e) {
            try {
                con.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            System.out.println("Erro na consulta:" + e.getMessage());
        }

        return curso;
    }

    @Override
    public ResultSet executarSQL(String sql) throws SQLException {
        return null;
    }
}
