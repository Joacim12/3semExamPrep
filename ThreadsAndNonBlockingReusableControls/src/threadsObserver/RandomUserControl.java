package threadsObserver;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import randomperson.RandomUser;
import randomperson.RandomUserGenerator;

public class RandomUserControl extends Observable {

    public void fetchRandomUser()  {        
        try {
            RandomUser user = RandomUserGenerator.getRandomUser();            
            setChanged();
            notifyObservers(user);
        } catch (InterruptedException ex) {
            Logger.getLogger(RandomUserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
