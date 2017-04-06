package java3.aquarium;

import javafx.application.Platform;

/**
 * This class is to make the fishes a thread
 *
 * @author Volan Nnanpalle
 */
public class FishThread extends Thread
{
    //attributes 
    private Fish fish;

    //Expicit Constructor 
    FishThread(Fish fish)
    {
        this.fish=fish;
    }

    /**
     * This is the run method for the thread
     */
    @Override
    public void run()
    {
        //endless loop 
        while(true)
        {

            try
            {
                Thread.sleep(200); //meakes the thread to sleep for 100 millisecond
            }catch(InterruptedException e)
            {
                e.printStackTrace(); //prints the exception
            }
            
            /*
             * This is done because all UI operations must be done on UI thread.
             * It updates the UI in JavaFx Application Thread
             */
            Platform.runLater(new Runnable()
            {
                @Override
                public void run()
                {
                    fish.swim(); //enables the fish to swim 
                }

            });
     
        }
    }
}
