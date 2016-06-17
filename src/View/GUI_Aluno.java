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
    private CheckBox    chbDeficiencia;
    private ComboBox<String> cbPeriodo;
    private ComboBox<Status> cbStatus;
    private TableView<String> tvAlunos;

    public GUI_Aluno(Stage stage){
        this.stage = stage;
        init();
    }

    private void init(){
        vbPrincipal = new VBox(10);
        vbPrincipal.setPadding(new Insets(5, 5, 5, 5));
        vbPrincipal.getStyleClass().add("resources/cadastro-aluno.css");

        HBox top = new HBox(10);
//        top.

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


        TableColumn<String, String> cNome = new TableColumn<>("Nome");
        TableColumn<String, String> cMatricula = new TableColumn<>("Matrícula");
        TableColumn<String, String> cCurso = new TableColumn<>("Curso");
        TableColumn<String, String> cPeriodo = new TableColumn<>("Período");
        TableColumn<String, String> cStatus = new TableColumn<>("Situação");
        TableColumn<String, String> cTelefone = new TableColumn<>("Telefone");
        TableColumn<String, CheckBox> cDeficiente = new TableColumn<>("Deficiente");

        tvAlunos = new TableView<>();

        tvAlunos.getColumns().addAll(cNome, cMatricula, cCurso, cPeriodo, cStatus, cTelefone, cDeficiente);

        hbCurso.getChildren().addAll(lblCod, tfCodCurso, lblCurso, tfCurso);
        hbNome.getChildren().addAll(lblMatricula, tfMatricula, lblNome, tfNome);
        hbPeriodo.getChildren().addAll(lblPeriodo, cbPeriodo, lblSituacao, cbStatus, lblCelular, tfTelefone);
        hbEmail.getChildren().addAll(lblEmail, tfEmail);

        vbPrincipal.getChildren().addAll(hbNome, hbCurso, hbPeriodo, hbEmail, tvAlunos);
        Scene scene = new Scene(vbPrincipal, 800, 600);
        stage.setScene(scene);
    }

}
