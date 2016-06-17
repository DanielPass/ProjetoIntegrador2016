package Persistencia;

import Enums.Status;
import Model.Entidades.Aluno;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends EntidadeDAO<Aluno> {


    public AlunoDAO() {
        super();
    }

    @Override
    public boolean cadastrar(Aluno aluno) {

        try {
            String sql = "INSERT INTO projeto_integrador.aluno(id_curso, nome, matricula, email, telefone, periodo, situacao, portador_deficiencia)" +
                    " VALUES (?,?,?,?,?,?,?,?)";

            stmt = con.prepareStatement(sql);
            //TODO: salvar o curso caso esse não exista no banco de dados
            stmt.setInt(1, aluno.getCurso().getId());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getMatricula());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, aluno.getTelefone());
            stmt.setInt(6, aluno.getPeriodo());
            stmt.setString(7, aluno.getStatus().name());
            stmt.setBoolean(8, aluno.isPortadorDeficiencia());
            stmt.executeUpdate();

            con.close();

        } catch (SQLException e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public Aluno alterar(Aluno aluno) {

        try {
            String sql = "UPDATE projeto_integrador.aluno SET " +
                    "id_curso=?, nome=?, matricula=?, email=?, telefone=?, periodo=?, situacao=?, portador_deficiencia=? WHERE matricula=?";
            
            stmt = con.prepareStatement(sql);

            //TODO: salvar o curso caso esse não exista no banco de dados
            stmt.setInt(1, aluno.getCurso().getId());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getMatricula());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, aluno.getTelefone());
            stmt.setInt(6, aluno.getPeriodo());
            stmt.setString(7, aluno.getStatus().name());
            stmt.setBoolean(8, aluno.isPortadorDeficiencia());
            stmt.setString(9, aluno.getMatricula());

            stmt.executeUpdate();

            con.close();

        } catch (SQLException e) {
            System.out.println("Erro na alteracao:" + e.getMessage());
        }

        return aluno;
    }

    @Override
    public Aluno excluir(Aluno aluno) {

        try {

            String sql = "UPDATE projeto_integrador.aluno SET deletado=? WHERE matricula=?";
             
            stmt = con.prepareStatement(sql);
            stmt.setBoolean(1, aluno.isDeletado());
            stmt.setString(2, aluno.getMatricula());
            stmt.executeUpdate();

            con.close();

        } catch (SQLException e) {
            System.out.println("Erro na exclusao:" + e.getMessage());
        }

        return aluno;
    }
        
    @Override
    public List<Aluno> consultar() {

        List<Aluno> alunos = new ArrayList<>();
        
        ResultSet res = null;

        try {

            stm = con.createStatement();
            res = stm.executeQuery("SELECT * FROM projeto_integrador.aluno");

            while (res.next()){
                Aluno aluno = new Aluno();
                aluno.setId(res.getInt("id_aluno"));
                aluno.setNome(res.getString("nome"));
                aluno.setMatricula(res.getString("matricula"));
                aluno.setEmail(res.getString("email"));
                aluno.setTelefone(res.getString("telefone"));
                aluno.setStatus(Status.valueOf(res.getString("situacao")));
                aluno.setPeriodo(res.getInt("periodo"));

                CursoDAO cursoDAO = new CursoDAO();
                aluno.setCurso(cursoDAO.consultar(res.getInt("id_curso")));

                alunos.add(aluno);
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Erro na consulta:" + e.getMessage());
        }

        return alunos;
    }

    @Override
    public Aluno consultar(int id) {
        return null;
    }

    @Override
    public ResultSet executarSQL(String sql) throws SQLException {
        return null;
    }

}
