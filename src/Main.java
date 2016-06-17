import Controller.AlunoController;
import View.GUI_Aluno;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by adson on 16/06/16.
 */
public class Main extends Application {

    public static void main(String... args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GUI_Aluno gui_aluno = new GUI_Aluno(primaryStage);

        AlunoController alunoController = new AlunoController(gui_aluno);
        alunoController.init();

        primaryStage.setTitle("Cadastro de aluno");
        primaryStage.show();
    }
}
