package ao222vn_assign2;

import java.util.Random;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;


public class RandomPanel extends BorderPane {
	

	public Parent start() {
		
		Button randBtn = new Button("New Random");
		final Text textNr = new Text();
		HBox hBox = new HBox();
		final BorderPane btnLayOut = new BorderPane();
		final BorderPane textLayOut = new BorderPane();
		
		//Button action
		randBtn.setOnAction(event -> {
			Random rand = new Random();
			int randnr = rand.nextInt(100);
			String text = Integer.toString(randnr);
			textNr.setText(text);
		});
		
		
		//Text layout
		Font font = Font.font("PermanentMarker",100 );
		textNr.setFontSmoothingType(FontSmoothingType.LCD);
		textNr.setFont(font);
		
		//Text effect
		DropShadow ds = new DropShadow();
		ds.setOffsetX(5.0f);
		ds.setOffsetY(5.0f);
		ds.setColor(Color.CHARTREUSE);
		textNr.setEffect(ds);
		
		
		
		//Position for the button
		btnLayOut.setLeft(randBtn);
		btnLayOut.setPrefSize(340, 240);
		BorderPane.setAlignment(randBtn, Pos.CENTER);
		btnLayOut.setPadding(new Insets(50, 50, 50, 50));
		
		
		//Position for the text
		textLayOut.setLeft(textNr);
		textLayOut.setPrefSize(340, 240);
		BorderPane.setAlignment(textNr, Pos.CENTER);
		textLayOut.setPadding(new Insets(50, 50, 50, 50));
		
		
	
		hBox.getChildren().addAll(btnLayOut, textLayOut);
	
		
		
		
		//Sets the scene and show
		return hBox;
		
	}
}
