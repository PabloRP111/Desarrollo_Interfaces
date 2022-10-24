package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		String texto="Hola";
		try {

			Button btn = new Button("Click aquí");
			Button btn2 = new Button("Click aquí");
			Button btn3 = new Button("Click aquí");
			
			//STACK PANEL 
			/*
			
			Label lbl = new Label(texto);
			
			
			StackPane panel = new StackPane();
			
			
			panel.setAlignment(btn, Pos.CENTER);
			
			panel.getChildren().addAll(lbl,btn);
			
			btn.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("¡Hola Mundo!");
					panel.setAlignment(lbl, Pos.BOTTOM_CENTER);
				}
			});
			*/
			
			/*
			 //VBox Panel
			VBox panel2 = new VBox(20);
			//También se puede cambiar el VBox(Vertical box), por HBox(Horizontal Box)

			panel2.getChildren().addAll(btn, btn2, btn3);
			
			panel2.setPadding(new Insets(15));
			
			 */
			
			/*
				//VBox
				VBox panelVertical= new VBox(15);
				panelVertical.setPadding(new Insets(15));
				panelVertical.getChildren().addAll(btn,btn2,btn3);
				
				BorderPane panel3 = new BorderPane();
				panel3.setLeft(panelVertical);

			 */
			
			//GridPane
			GridPane panel4 = new GridPane();
			panel4.setVgap(15);
			panel4.setHgap(15);
			panel4.setPadding(new Insets(10));
			//
			
			Scene escena= new Scene(panel4, 400, 300);
			primaryStage.setScene(escena);
			primaryStage.setTitle("JavaFX Introducción");
			primaryStage.getIcons().add(new Image("/images/icon.jpg"));
		
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
