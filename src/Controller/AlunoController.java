package Controller;

import Model.Entidades.Aluno;
import Persistencia.AlunoDAO;
import Persistencia.CursoDAO;
import View.GUI_Aluno;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;

/**
 * Created by adson on 16/06/16.
 */
public class AlunoController {

    private GUI_Aluno gui_aluno;

    public AlunoController(GUI_Aluno gui_aluno) {
        this.gui_aluno = gui_aluno;
    }

    public Aluno salvar() {
        Aluno aluno = new Aluno();
        AlunoDAO alunoDAO = new AlunoDAO();

        aluno.setNome(gui_aluno.getTfNome().getText());
        aluno.setEmail(gui_aluno.getTfEmail().getText());
        aluno.setMatricula(gui_aluno.getTfMatricula().getText());
        aluno.setTelefone(gui_aluno.getTfTelefone().getText());
        aluno.setPeriodo(gui_aluno.getCbPeriodo().getSelectionModel().getSelectedIndex() + 1);
        aluno.setStatus(gui_aluno.getCbStatus().getValue());
        aluno.setCurso(new CursoDAO().consultar(Integer.parseInt(gui_aluno.getTfCodCurso().getText())));
        RadioButton selecionado = (RadioButton) gui_aluno.getTgDeficiencia().getSelectedToggle();
        aluno.setPortadorDeficiencia(selecionado.getText().equalsIgnoreCase("Sim"));
        if(gui_aluno.getIdAluno() == 0)
            alunoDAO.cadastrar(aluno);
        else
            alunoDAO.alterar(aluno);

        return aluno;
    }

    public void init() {
        configButtons();

        onChange(gui_aluno.getTfCodCurso().focusedProperty(), new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null) {
                    String txt = gui_aluno.getTfCodCurso().getText();
                    if (txt != null && !txt.equals(""))
                        gui_aluno.getTfCurso().setText(
                                new CursoDAO().consultar(Integer.parseInt(txt))
                                        .getNome()
                        );
                }
            }
        });

        listar();
    }

    private void configButtons() {
        gui_aluno.getSalvar().setOnAction(e -> {
            this.salvar();
            limpar();
            listar();
        });

        gui_aluno.getLimpar().setOnAction(e -> {
            this.limpar();
        });

        gui_aluno.getExcluir().setOnAction(e ->{
            AlunoDAO alunoDAO = new AlunoDAO();
            Aluno aluno = gui_aluno.getTvAlunos().getSelectionModel().getSelectedItem();
            if(aluno != null)
                alunoDAO.excluir(aluno);
            limpar();
            listar();
        });
    }

    private void listar() {
        AlunoDAO alunoDAO = new AlunoDAO();
        TableView tableView = gui_aluno.getTvAlunos();
        ObservableList<Aluno> alunos = alunoDAO.consultar();

        tableView.setItems(alunos);

        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        onChange(tableView.getSelectionModel().selectedItemProperty(), (observable, oldValue, newValue) -> {
            if(newValue != null){
                limpar();
                Aluno aluno = (Aluno) newValue;

                gui_aluno.getTfNome().setText(aluno.getNome());
                gui_aluno.getTfCodCurso().setText(String.valueOf(aluno.getCurso().getId()));
                gui_aluno.getTfCurso().setText(aluno.getCurso().getNome());
                gui_aluno.getTfEmail().setText(aluno.getEmail());
                gui_aluno.getTfMatricula().setText(aluno.getMatricula());
                gui_aluno.getTfTelefone().setText(aluno.getTelefone());
                gui_aluno.getTgDeficiencia().getToggles().forEach(e -> {
                    if(aluno.isPortadorDeficiencia() && ((RadioButton) e).getText().equalsIgnoreCase("Sim")){
                        e.setSelected(aluno.isPortadorDeficiencia());
                    } else if(((RadioButton) e).getText().equalsIgnoreCase("Não")){
                        e.setSelected(true);
                    }
                });
                gui_aluno.getCbPeriodo().getSelectionModel().select(aluno.getPeriodo() - 1);
                gui_aluno.getCbStatus().setValue(aluno.getStatus());

                gui_aluno.setIdAluno(aluno.getId());
                gui_aluno.getExcluir().setDisable(false);
            }
        });
    }

    public void limpar() {
        gui_aluno.getTfCodCurso().setText("");
        gui_aluno.getTfCurso().setText("");
        gui_aluno.getTfEmail().setText("");
        gui_aluno.getTfMatricula().setText("");
        gui_aluno.getTfNome().setText("");
        gui_aluno.getTfTelefone().setText("");
        gui_aluno.getCbPeriodo().setValue("");
        gui_aluno.getTgDeficiencia().getToggles().forEach(e ->{
            if(((RadioButton)e).getText().equals("Não")){
                e.setSelected(true);
            }
        });


        gui_aluno.getExcluir().setDisable(true);
    }

    public <T> void onChange(ObservableValue<T> o, ChangeListener listener) {
        o.addListener(listener);
    }
}
