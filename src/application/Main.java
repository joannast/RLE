package application;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			root.setPadding(new Insets(10));
			//odstepy miedzy kolumnami
			root.setHgap(15);
			//odstepy miedzy wierszami
			root.setVgap(5);
			Label et1 = new Label("Zród³o");
			Label et2 = new Label("Wynik operacji");
			Label et3 = new Label("Operacja:");
			Label et4 = new Label("kodowanie");
			Label et5 = new Label("dekodowanie");
			TextField text1 = new TextField();
			TextField text2 = new TextField();
			Button b1 = new Button("Kopiuj");
			Button b2 = new Button("Wykonaj");
			RadioButton r1 = new RadioButton();
			RadioButton r2 = new RadioButton();
			ToggleGroup tgroup =new ToggleGroup(); 
			r1.setToggleGroup(tgroup);
			r2.setToggleGroup(tgroup);
			//dodajemy komponenty do kontenera i ustawiamy polozenie oraz zasieg komponentu
			root.add(et1, 1, 4);
			root.add(text1, 1, 4, 3, 3);
			root.add(et2, 1, 10);
			root.add(text2, 1, 11, 3, 3);
			GridPane.setHalignment(b1, HPos.RIGHT);//ustawiamy pozycje przycisku po praej stronie
			root.add(b1, 2, 7,1,1);
			GridPane.setHalignment(b2, HPos.LEFT);
			root.add(b2, 1, 16,1,1);
			root.add(et3, 6, 4, 2,1);
			root.add(r1, 6, 5);
			root.add(r2, 6, 6);
			root.add(et4, 7, 5);
			root.add(et5, 7, 6);
			
			Kodowanie kod = new Kodowanie();
			Dekodowanie tekst = new Dekodowanie();
			
			b1.setOnAction(
					event-> {
						text1.setText(text2.getText());//wstawiamy ciag znakow z pola wynik opeacji do pola zrodlo
						text2.setText("");//czyscimy pole wynik operacji
					}
				);
			
			b2.setOnAction(
					event->{
						if (r1.isSelected()) {text2.setText(kod.koduj(text1.getText()));;}
					else  {text2.setText(tekst.dekoduj(text1.getText()));;}
					});
			
			Scene scene = new Scene(root,600,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
