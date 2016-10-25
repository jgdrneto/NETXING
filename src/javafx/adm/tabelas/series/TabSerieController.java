package javafx.adm.tabelas.series;

import java.io.IOException;
import java.util.List;

import javafx.adm.view.cadastrarAtualizar.CadCategoriaDialogController;
import javafx.adm.view.cadastrarAtualizar.CadSerieDialogController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.modelos.ControllerAdm;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import projeto.dao.DAO;

public class TabSerieController extends ControllerAdm {
    @FXML
    private TableView<javafx.modelos.Serie> tb_Serie;

    @FXML
    private TableColumn<javafx.modelos.Serie, String> tb_Serie_Nome;

    private ObservableList<javafx.modelos.Serie> serieData = FXCollections.observableArrayList();

    public TabSerieController() {

        List<projeto.modelos.Serie> series = DAO.ACAO.listar(projeto.modelos.Serie.class);

        for (projeto.modelos.Serie s : series) {

            if (!s.getNome().equals("Sem série")) {
                serieData.add(new javafx.modelos.Serie(s));
            }
        }
    }

    @FXML
    private void duploClique() {

        tb_Serie.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    if (mouseEvent.getClickCount() == 2 && tb_Serie.getSelectionModel().getSelectedIndex() >= 0) {

                        abrirDialogUpdate("CadSerieDialog.fxml", "Editar Série");
                    }
                }
            }
        });
    }

    private void abrirDialogUpdate(String arquivoFXML, String titulo) {
        try {
            // Carrega o arquivo fxml e cria um novo stage para a janela popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(CadCategoriaDialogController.class.getResource(arquivoFXML));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle(titulo);
            dialogStage.setResizable(false);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(super.getStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            CadSerieDialogController controlador = loader.getController();
            controlador.setAdmController(getAdmController());
            controlador.setStage(dialogStage);
            controlador.setSerie(tb_Serie.getSelectionModel().getSelectedItem());

            dialogStage.showAndWait();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        // Tabela videos
        tb_Serie_Nome.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());

        tb_Serie.setItems(serieData);

    }
}
