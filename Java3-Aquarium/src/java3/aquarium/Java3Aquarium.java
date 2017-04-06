package java3.aquarium;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * This class declares all the fishes and, fish thread, sets the background of
 * the window and start all thread enabling them to work simultaneously which
 * makes the fish to swim
 *
 * @author Volan Nnanpalle
 */
public class Java3Aquarium extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        //create the pane 
        StackPane root=new StackPane();
     

        //create the fish
        Fish fish1=new Fish("file:imageedit_3_8691078998.gif", -350, -300);
        Fish fish2=new Fish("file:animated-shark-image-0027.gif", -350, -100);
        Fish fish3=new Fish("file:20096.gif", -350, 100);
        Fish fish4=new Fish("file:animated-salmon-fish.gif",
            -350, 200);
        Fish fish5=new Fish("file:animated-tropical-fish-5-2.gif", 350, 300);
        Fish fish6=new Fish("file:427841964601203090.jpg", 350, -10);
        Fish fish7=new Fish("file:imageedit_1_8734401747.gif", 350, -185);

        //create the fish thread
        FishThread t1=new FishThread(fish1);
        FishThread t2=new FishThread(fish2);
        FishThread t3=new FishThread(fish3);
        FishThread t4=new FishThread(fish4);
        FishThread t5=new FishThread(fish5);
        FishThread t6=new FishThread(fish6);
        FishThread t7=new FishThread(fish7);

        //closes the threads when the windown is closed 
        t1.setDaemon(true);
        t2.setDaemon(true);
        t3.setDaemon(true);
        t4.setDaemon(true);
        t5.setDaemon(true);
        t6.setDaemon(true);
        t7.setDaemon(true);

        //start the fish thread
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();

        //add the fish to the screen 
        root.getChildren().add(fish1.makeFish());
        root.getChildren().add(fish2.makeFish());
        root.getChildren().add(fish3.makeFish());
        root.getChildren().add(fish4.makeFish());
        root.getChildren().add(fish5.makeFish());
        root.getChildren().add(fish6.makeFish());
        root.getChildren().add(fish7.makeFish());
        //root.getChildren().add(iv);
        //declare a scene and set a pane on it 
        Scene scene=new Scene(root, 800, 700);
        //set the background of the scene 
        scene.getStylesheets().add(getClass().getResource("style.css").
            toExternalForm());
        //name the stage
        primaryStage.setTitle("Fish Tank");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main method to start the application
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}
