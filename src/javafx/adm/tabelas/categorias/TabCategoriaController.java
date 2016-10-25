package javafx.adm.tabelas.categorias;

import java.io.IOException;
import java.util.List;

import javafx.adm.view.cadastrarAtualizar.CadCategoriaDialogController;
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

public class TabCategoriaController extends ControllerAdm {
    @FXML
    private TableView<javafx.modelos.Categoria> tb_Categoria;

    @FXML
    private TableColumn<javafx.modelos.Categoria, String> tb_Categoria_Nome;

    private ObservableList<javafx.modelos.Categoria> categoriaData = FXCollections.observableArrayList();

    public TabCategoriaController() {

        List<projeto.modelos.Categoria> categorias = DAO.ACAO.listar(projeto.modelos.Categoria.class);

        for (projeto.modelos.Categoria c : categorias) {
            categoriaData.add(new javafx.modelos.Categoria(c));
        }
    }

    @FXML
    private void duploClique() {

        tb_Categoria.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    if (mouseEvent.getClickCount() == 2 && tb_Categoria.getSelectionModel().getSelectedIndex() >= 0) {

                        abrirDialogUpdate("CadCategoriaDialog.fxml", "Editar Categoria");
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

            CadCategoriaDialogController controlador = loader.getController();
            controlador.setAdmController(getAdmController());
            controlador.setStage(dialogStage);
            controlador.setCategoria(tb_Categoria.getSelectionModel().getSelectedItem());

            dialogStage.showAndWait();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @FXML
    private void initialize() {
        // Tabela videos
        tb_Categoria_Nome.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());

        tb_Categoria.setItems(categoriaData);

    }

}
