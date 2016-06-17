package Controller;

import Model.Entidades.Aluno;
import Persistencia.AlunoDAO;
import Persistencia.CursoDAO;
import View.GUI_Aluno;

/**
 * Created by adson on 16/06/16.
 */
public class AlunoController {

    private GUI_Aluno gui_aluno;
    private AlunoDAO alunoDAO = new AlunoDAO();

    public AlunoController(GUI_Aluno gui_aluno){
        this.gui_aluno = gui_aluno;
    }

    public Aluno salvar(){
        Aluno aluno = new Aluno();

        aluno.setNome(gui_aluno.getTfNome().getText());
        aluno.setEmail(gui_aluno.getTfEmail().getText());
        aluno.setMatricula(gui_aluno.getTfMatricula().getText());
        aluno.setTelefone(gui_aluno.getTfTelefone().getText());
        aluno.setPeriodo(gui_aluno.getCbPeriodo().getSelectionModel().getSelectedIndex()+1);
        aluno.setStatus(gui_aluno.getCbStatus().getValue());
        aluno.setCurso(new CursoDAO().consultar(Integer.parseInt(gui_aluno.getTfCodCurso().getText())));
        alunoDAO.cadastrar(aluno);

        return aluno;
    }

    public void init(){
        gui_aluno.getSalvar().setOnAction(e ->{
            this.salvar();
        });
    }

}
