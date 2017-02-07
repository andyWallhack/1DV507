package ao222vn_assign2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class OneTwoThree extends Application {

	public static void main (String[] args) {
		
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("OneTwoThree");
		
		
		StackPane stackPane1 = new StackPane();
		StackPane stackPane2 = new StackPane();
		StackPane stackPane3 = new StackPane();
		
		//Creating rectangles with size 680*160
		Rectangle oneRectangle = new Rectangle(680, 160);
		Rectangle twoRectangle = new Rectangle(680, 160);
		Rectangle threeRectangle = new Rectangle(680, 160);
		
		//Sets color
		oneRectangle.setFill(Color.DEEPSKYBLUE);
		twoRectangle.setFill(Color.DARKKHAKI);
		threeRectangle.setFill(Color.DARKMAGENTA);
		
		//Text and fonts
		Text text1 = new Text("One");
		text1.setFont(Font.font("Ultra", 30));
		Text text2 = new Text("Two");
		text2.setFont(Font.font("Ultra", 30));
		Text text3 = new Text("Three");
		text3.setFont(Font.font("Ultra", 30));
		
		//Adding rectangles and text to stack pane
		stackPane1.getChildren().addAll(oneRectangle, text1);
		stackPane2.getChildren().addAll(twoRectangle, text2);
		stackPane3.getChildren().addAll(threeRectangle,text3);
		
		
		//Positions for text one and three
		StackPane.setAlignment(text1, Pos.TOP_LEFT);
		StackPane.setAlignment(text3, Pos.BOTTOM_RIGHT);
	
	
		//Adding stack planes to a Vertical box
		VBox vBox = new VBox();
		vBox.getChildren().addAll(stackPane1, stackPane2, stackPane3);
		Scene scene = new Scene(vBox, 680, 480);
		
		
		//Sets the scene and show
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		
	}

}
