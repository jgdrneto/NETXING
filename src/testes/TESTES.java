package testes;

import java.io.File;
import java.io.IOException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TESTES {

	public static void main(String[] args) {
		String local = "imagens/series/Pokemon.jpg";
		
		File file = new File(local);
		
		System.out.println(file.exists());
		
		System.out.println(file.toURI().toString());
		
		ImageView image = new ImageView(file.toURI().toString());

		
	}
}
