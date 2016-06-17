package View;

import Enums.Status;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by daniel on 4/6/2016.
 */
public class GUI_Aluno {

    private Stage stage;

    private VBox        vbPrincipal;
    private TextField   tfNome;
    private TextField   tfMatricula;
    private TextField   tfEmail;
    private TextField   tfTelefone;
    private TextField   tfCurso;
    private TextField   tfCodCurso;
    private ToggleGroup    tgDeficiencia;
    private ComboBox<String> cbPeriodo;
    private ComboBox<Status> cbStatus;
    private TableView<String> tvAlunos;
    private Button salvar;
    private Button excluir;
    private Button limpar;

    public GUI_Aluno(Stage stage){
        this.stage = stage;
        init();
    }

    public VBox getVbPrincipal() {
        return vbPrincipal;
    }

    public TextField getTfNome() {
        return tfNome;
    }

    public TextField getTfMatricula() {
        return tfMatricula;
    }

    public TextField getTfEmail() {
        return tfEmail;
    }

    public TextField getTfTelefone() {
        return tfTelefone;
    }

    public TextField getTfCurso() {
        return tfCurso;
    }

    public TextField getTfCodCurso() {
        return tfCodCurso;
    }

    public ToggleGroup getTgDeficiencia() {
        return tgDeficiencia;
    }

    public ComboBox<String> getCbPeriodo() {
        return cbPeriodo;
    }

    public ComboBox<Status> getCbStatus() {
        return cbStatus;
    }

    public TableView<String> getTvAlunos() {
        return tvAlunos;
    }

    public Button getSalvar() {
        return salvar;
    }

    public Button getExcluir() {
        return excluir;
    }

    public Button getLimpar() {
        return limpar;
    }

    private void init(){
        vbPrincipal = new VBox(10);
        vbPrincipal.setPadding(new Insets(5, 5, 5, 5));
        vbPrincipal.getStylesheets().add("/resources/cadastro-aluno.css");

        HBox top = new HBox(10);
        VBox vbForm = new VBox(10);
        vbForm.setMinWidth(875);
        vbForm.setPadding(new Insets(5, 5, 5, 5));

        VBox buttons = criarBotoes();

        // Nome
        HBox hbNome = new HBox(5);
        Label lblNome = new Label("Nome");
        tfNome = new TextField();
        tfNome.setMinWidth(Region.USE_PREF_SIZE);
        HBox.setHgrow(tfNome, Priority.ALWAYS);

        Label lblMatricula = new Label("Matrícula");
        tfMatricula = new TextField();

        //Curso
        HBox hbCurso = new HBox(5);

        Label lblCod = new Label("Cód. Curso");
        tfCodCurso = new TextField();
        tfCodCurso.setPrefWidth(30);

        Label lblCurso = new Label("Curso");
        tfCurso = new TextField();
        HBox.setHgrow(tfCurso, Priority.ALWAYS);

        //Periodo
        HBox hbPeriodo = new HBox(5);

        Label lblPeriodo = new Label("Período");
        cbPeriodo = new ComboBox<>();
        cbPeriodo.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        Label lblSituacao = new Label("Situação");
        cbStatus = new ComboBox<>();
        cbStatus.getItems().addAll(Status.ATIVO, Status.INATIVO);
        cbStatus.getSelectionModel().select(0);

        Label lblCelular = new Label("Celular");
        tfTelefone = new TextField();

        //E-mail
        HBox hbEmail = new HBox(5);

        Label lblEmail = new Label("E-mail");
        tfEmail = new TextField();
        HBox.setHgrow(tfEmail, Priority.ALWAYS);

        Label lblDef = new Label("Deficiente físico");
        tgDeficiencia = new ToggleGroup();
        RadioButton rNao = new RadioButton("Não");
        rNao.setSelected(true);
        rNao.setToggleGroup(tgDeficiencia);
        RadioButton rSim = new RadioButton("Sim");
        rSim.setToggleGroup(tgDeficiencia);
        HBox toggle = new HBox(5);
        toggle.getChildren().addAll(lblDef, rNao, rSim);

        criarTabela();

        hbCurso.getChildren().addAll(lblCod, tfCodCurso, lblCurso, tfCurso);
        hbNome.getChildren().addAll(lblMatricula, tfMatricula, lblNome, tfNome);
        hbPeriodo.getChildren().addAll(lblPeriodo, cbPeriodo, lblSituacao, cbStatus, lblCelular, tfTelefone, lblDef, toggle);
        hbEmail.getChildren().addAll(lblEmail, tfEmail);

        vbForm.getChildren().addAll(hbNome, hbCurso, hbPeriodo, hbEmail);
        top.getChildren().addAll(vbForm, buttons);
        vbPrincipal.getChildren().addAll(top, tvAlunos);
        Scene scene = new Scene(vbPrincipal, 1000, 650);
        stage.setScene(scene);
    }

    private void criarTabela() {
        TableColumn<String, String> cNome = new TableColumn<>("Nome");
        TableColumn<String, String> cMatricula = new TableColumn<>("Matrícula");
        TableColumn<String, String> cEmail = new TableColumn<>("E-mail");
        TableColumn<String, String> cCurso = new TableColumn<>("Curso");
        TableColumn<String, String> cPeriodo = new TableColumn<>("Período");
        TableColumn<String, String> cStatus = new TableColumn<>("Situação");
        TableColumn<String, String> cTelefone = new TableColumn<>("Telefone");
        TableColumn<String, CheckBox> cDeficiente = new TableColumn<>("Deficiente");

        cNome.setMinWidth(200);
        cCurso.setMinWidth(200);
        cEmail.setMinWidth(200);
        cDeficiente.setMinWidth(85);
        cPeriodo.setMaxWidth(65);

        tvAlunos = new TableView<>();
        tvAlunos.getStyleClass().add(".table-view");
        tvAlunos.getColumns().addAll(cMatricula, cNome, cEmail, cCurso, cPeriodo, cStatus, cTelefone, cDeficiente);
    }

    private VBox criarBotoes() {
        salvar = new Button("Salvar");
        excluir = new Button("Excluir");
        limpar = new Button("Limpar");

        VBox buttons = new VBox(10);
        buttons.setPadding(new Insets(5, 5, 5, 5));
        buttons.getChildren().addAll(salvar, limpar, excluir);
        return buttons;
    }

}
