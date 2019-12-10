import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Grafica extends Application {
 
    public static void main(String[] args) {
        launch(args);
    }
     
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Convertitore da gradi a radianti");
       
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10,50,50,50));
        
        HBox horizontalBox = new HBox();
        horizontalBox.setPadding(new Insets(20,20,20,30));
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        
        Label lblGradi = new Label("Gradi");
        TextField txtGradi = new TextField();
        Label lblRadianti = new Label("Radianti");
        TextField txtRadianti = new TextField();  
        
        Button btnCalcola = new Button("Calcola");
       
        gridPane.add(lblGradi, 0, 0);
        gridPane.add(txtGradi, 1, 0);
        gridPane.add(lblRadianti, 0, 1);
        gridPane.add(txtRadianti, 1, 1);
        gridPane.add(btnCalcola, 2, 1);   
                
        Reflection reflection = new Reflection();
        reflection.setFraction(0.7f);
        gridPane.setEffect(reflection);
        
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(3);
        dropShadow.setOffsetY(3);
        
        Text text = new Text("Convertitore da gradi a radianti");
        text.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        text.setEffect(dropShadow);
        
        horizontalBox.getChildren().add(text);
                          
        borderPane.setId("borderPane");
        gridPane.setId("gridPane");
        btnCalcola.setId("button");
        text.setId("text");

        btnCalcola.setOnAction((ActionEvent event) -> {
            event.consume();
            float gradi = Float.parseFloat(txtGradi.getText());
            float radianti = gradi * 3.14f / 180;
            txtRadianti.setText(String.valueOf(radianti));
        });
       
        borderPane.setTop(horizontalBox);
        borderPane.setCenter(gridPane);  
        
     Scene scene = new Scene(borderPane);
     scene.getStylesheets().add(getClass().getClassLoader().getResource("form.css").toExternalForm());
     primaryStage.setScene(scene);
   
     primaryStage.setResizable(false);
     primaryStage.show();
    }
}


