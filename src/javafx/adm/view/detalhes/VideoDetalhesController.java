package javafx.adm.view.detalhes;

import java.io.File;

import javafx.fxml.FXML;
import javafx.modelos.ControllerAdm;
import javafx.modelos.Video;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VideoDetalhesController extends ControllerAdm{

	@FXML
	private Label nome;
	@FXML
	private Label serie;
	@FXML
	private Label categoria;
	@FXML
	private Label descricao;
	@FXML
	private Label ano;
	@FXML
	private Label diretor;
	@FXML
	private Label atorPrincipal;
	@FXML
	private Label faixaEtaria;
	@FXML
	private Label temporada;
	@FXML	
	private ImageView imagem;
		
	public VideoDetalhesController() {
		
	}

	public void setVideo(Video v) {
		
		this.nome.setText(v.getNome());
		this.serie.setText(v.getSerie());
		this.categoria.setText(v.getCategoria());
		this.descricao.setText(v.getDescricao());
		this.ano.setText(v.getAno().toString());
		this.diretor.setText(v.getDiretor());
		this.atorPrincipal.setText(v.getAtorPrincipal());
		this.faixaEtaria.setText(v.getFaixaEtaria().toString());
		this.temporada.setText(v.getTemporada());
				
		//File file = new File(v.getImagem());
		
		//System.out.println(file.exists());
		
		//imagem = new ImageView(new Image(file.getAbsolutePath()));
		
		imagem.setImage(new Image(new File(v.getImagem()).toURI().toString()));
	}

	@FXML
	private void initialize() {
		
	}
}
