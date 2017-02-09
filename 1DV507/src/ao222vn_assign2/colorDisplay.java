package ao222vn_assign2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class colorDisplay extends Application {
	
	Button btn = new Button();
	TextField redField, greenField, blueField;
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		VBox vBox = new VBox();
		vBox.getChildren().addAll(upperRectangle(), middleRectangle(),
				lowerRectangle());
		
//		Set scenery.
		Scene scene = new Scene(vBox,600, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

/**
 * Sets the layout if the upper panel in a StackPane and also the button action.
 * @return StackPane of the layout of the upper panel.
 */
	public StackPane upperRectangle() {
		
//		Sets the background
		StackPane stack = new StackPane();
		Rectangle background = new Rectangle(599, 140);
		background.setStroke(Color.BLACK);
		background.setFill(Color.DARKBLUE);
		
//		Set the text, font and color.
		final Text colorDisplay = new Text("Color Display");
		colorDisplay.setFont(Font.font("Sans Serif", 50));
		colorDisplay.setFill(Color.AQUA);
		stack.getChildren().addAll(background,colorDisplay );
		
		
//		Button action that change the color of the background and invert the text.
		this.btn.setOnAction(e -> {
			
//			String value from text field to integer.
			int red = Integer.parseInt(this.redField.getText());
			int green = Integer.parseInt(this.greenField.getText());
			int blue = Integer.parseInt(this.blueField.getText());
			
/*			Checks if the combined value of red, green and blue is under 0 (black) or over 765 (white)
 * 			if so, displays error massage in the three text fields. Else update background color. 
 */
			int value = red + green + blue;
			if(0 > value || value > 765) {
				this.redField.setText("Error");
				this.greenField.setText("Error");
				this.blueField.setText("Error");
			}
			else {
				background.setFill(Color.rgb(red, green, blue));
				colorDisplay.setFill(Color.rgb(red, green, blue).invert());
			} 	
		});
		return stack;
	}

/**
 * Sets the layout if the middle panel in a StackPane
 * @return StackPane of the layout of the middle panel.
 */
	public StackPane middleRectangle() {
		
//		Sets the background
		StackPane stack = new StackPane();
		Rectangle background = new Rectangle(599, 140);
		background.setFill(Color.BLUEVIOLET);
		background.setStroke(Color.BLACK);
		
//		Text thats display what to put in the text fields.
		Text redText = new Text("Red");
		Text greenText = new Text("Green");
		Text blueText = new Text("Blue");
		
//		Set the text, font and color.
		redText.setFont(Font.font("Sans Serif", 40));
		redText.setFill(Color.RED);
		greenText.setFont(Font.font("Sans Serif", 40));
		greenText.setFill(Color.GREEN);
		blueText.setFont(Font.font("Sans Serif", 40));
		blueText.setFill(Color.BLUE);
		
//		Creates the text fields.
		this.redField = new TextField();
		redField.setPrefSize(100, 20);
		this.greenField = new TextField();
		greenField.setPrefSize(100, 20);
		this.blueField = new TextField();
		blueField.setPrefSize(100, 20);

//		Sets the layout for texts and text fields.
		HBox textBox = new HBox();
		textBox.setPadding(new Insets(40, 0, 0, 30));
		textBox.setSpacing(100.0f);
		textBox.getChildren().addAll(redText, greenText, blueText);
		HBox fieldBox = new HBox();
		fieldBox.getChildren().addAll(redField, greenField, blueField);
		fieldBox.setPadding(new Insets(0, 0, 0, 30));
		fieldBox.setSpacing(90.0f);
		VBox layOut = new VBox();
		layOut.getChildren().addAll(textBox, fieldBox);
		stack.getChildren().addAll(background, layOut);
		
		return stack;
	}

/**
 * Sets the layout if the lower panel in a StackPane
 * @return StackPane of the layout of the lower panel.
 */
	public StackPane lowerRectangle() {
		
		StackPane stack = new StackPane();
		
//		Sets the background
		Rectangle background = new Rectangle(599, 117);
		background.setStroke(Color.BLACK);
		background.setFill(Color.CHOCOLATE);
		
//		Sets button size and text
		this.btn.setPrefSize(200.0f, 50.0f);
		this.btn.setText("Display Color");

		stack.getChildren().addAll(background,this.btn);
		
		return stack;
	}
}
