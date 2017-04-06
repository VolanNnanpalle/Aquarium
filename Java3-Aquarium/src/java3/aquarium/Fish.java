package java3.aquarium;

import java.util.Random;
import javafx.animation.TranslateTransition;
import javafx.geometry.NodeOrientation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class has a method to generate fishes and a method to enable the fish to
 * move through out the window
 *
 * @author Volan Nnanpalle
 */
public class Fish
{

    //attributes 
    private Image fish;
    private double x;
    private double y;
    private ImageView iv;
    private int xSpeed;

    //Default Constructor 
    Fish()
    {
        fish=new Image("file:fish_PNG1151.png");
        x=-350;
        y=300;
        Random rand=new Random();
        xSpeed=rand.nextInt(15)+7;
        iv=new ImageView();
    }

    //Explicit Constructor 
    Fish(String f, double x1, double y1)
    {
        fish=new Image(f);
        x=x1;
        y=y1;
        Random rand=new Random();
        xSpeed=rand.nextInt(15)+7;
        iv=new ImageView();
    }

    /**
     * This method returns x position of the fish
     * @return x the x position of the fish
     */
    public double getX()
    {
        return x;
    }

    /**
     * This method returns the y position of the fish
     * @return y the y position of the fish
     */
    public double getY()
    {
        return y;
    }

    /**
     * This method sets the x value of the fish
     * @param x the x value of the fish
     */
    public void setX(double x)
    {
        this.x=x;
    }

    /**
     * This method sets the y value of the fish
     * @param y the y value of the fish
     */
    public void setY(double y)
    {
        this.y=y;
    }

    /**
     * This method makes a fish image view from the image the user sent . It
     * sets the position, height and width and keeps the quality of the image
     * preserved
     * @return iv the image view of the image passed by the user
     */
    public ImageView makeFish()
    {

        iv.setImage(fish);
        iv.setTranslateX(x);
        iv.setTranslateY(y);
        iv.setFitHeight(150);
        iv.setFitWidth(150);
        iv.setPreserveRatio(true);

        return iv;
    }
    /**
     * This method allows the fish to bounce off the boundaries of the tank
     */
    public void rebound()
    {
         xSpeed=-xSpeed;
    }
   
    /**
     * This method enables the fish to move across the screen within its bounds
     */
    public void swim()
    {

        //if the fish gets to the right border of the pane 
        if(getX()>350)
        {

            //this is to decrement the x position of the fish
            rebound();
            //this enables the fish to change is orientation 
            iv.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        }
        //if the fish gets to the left border of the pane 
        if(getX()<-350)
        {

            //this is to increase the x position of the fish
            rebound();
            //this enables the fish to change is orientation 
            iv.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        }

        //this is increments the x value by the speed to make the fish move
        x+=xSpeed;

        //creates an animantion 
        TranslateTransition t=new TranslateTransition();
        //set the animation on the fish
        t.setNode(iv);
        //set the changing x position on the fish
        t.setToX(getX());
        //play the animation 
        t.play();
    }

}
