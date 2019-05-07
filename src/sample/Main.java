package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.stream.IntStream;

public class Main extends Application {


    private int c = 5;

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane border = new BorderPane();
        primaryStage.setTitle("Hello World");

        GridPane tabla = principal();



        border.setCenter(tabla);



        primaryStage.setScene(new Scene(border, 300, 350));

        primaryStage.show();

    }

    public GridPane principal(){




        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(30);
        grid.setPadding(new Insets(0,10,0,10));



        Button iniciar = new Button("iniciar");
        iniciar.setPrefSize(50,10);
        grid.add(iniciar,1,5);

        Button tirar = new Button("Tirar");
        tirar.setPrefSize(50,10);
        grid.add(tirar,2,5);
         TextField mostar = new TextField();
         grid.add(mostar,1,1);
        TextField mostar2 = new TextField();
        grid.add(mostar2,1,2);
        TextField mostar3 = new TextField();
        grid.add(mostar3,1,3);

        tirar.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent mouseEvent) {

                Random random = new Random();
                IntStream intStream = random.ints(1,1,7);
                Iterator iterator = intStream.iterator();
                IntStream intStream2 = random.ints(1,1,7);
                Iterator iterator1 = intStream2.iterator();
                String n1 = iterator.next().toString();
                String n2 = iterator1.next().toString();
                mostar.setText(n1);
                mostar2.setText(n2);
                int suma = Integer.parseInt(n1) + Integer.parseInt(n2);
                mostar3.setText(String.valueOf(suma));


                if (suma==7){
                    Label label13 = new Label("Ya ganaste");
                    grid.add(label13,1,4);
                    tirar.setVisible(false);


                }
            }
        });

        ProgressBar progresbarn = new ProgressBar(0);
        ProgressIndicator progresindicador = new ProgressIndicator();
        grid.getChildren().addAll(progresbarn, progresindicador);
        Label imprimir = new Label();
        grid.add(imprimir,2,3);


        iniciar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Thread hilo = new Thread();
                hilo.start();
                try{
                    Platform.runLater( new conteo(iniciar,progresbarn, progresindicador,imprimir));
                    hilo.wait(60000);
                    hilo.notifyAll();
                }catch(Exception ex){
                    hilo.stop();
                }
            }
        });



        return grid;

    }


    public static void main(String[] args) {
        launch(args);
    }
}
