package ao222vn_assign2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RandomMain extends Application{

	public static void main(String[] args) {
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		RandomPanel rand = new RandomPanel();
		primaryStage.setTitle("Radom Generator");
		rand.start();
		Scene scene = new Scene(rand.start(), 680, 480);
		
		
		//Sets the scene and show
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
