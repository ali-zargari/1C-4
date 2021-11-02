package queues;

import cs1c.SongEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * The class Jukebox manages three objects of type Queue. An instance of the
 * class may read a file which includes the user's requests for the name of a
 * song to be added to a specific playlist. It will then add songs to the three
 * playlists "favorites", "lounge", and "road trip" accordingly.
 *
 * @author Ali Zargari
 * @version 1.0
 */
public class Jukebox {

    private Queue<SongEntry> favoritePL;
    private Queue<SongEntry> roadTripPL;
    private Queue<SongEntry> loungePL;

    public Jukebox(){
        favoritePL = new Queue<SongEntry>("favorites");
        roadTripPL = new Queue<SongEntry>("road trip");
        loungePL = new Queue<SongEntry>("lounge");
    }

    /***
     * reads the test file and then adds songs to one of the three queues in this class
     *
     * @param requestedFile path for the file to be read
     * @param allSongs An array that contains all the song entries.
     */
    public void fillPlaylists(String requestedFile, SongEntry[] allSongs) {
        try {
            Scanner file = new Scanner(new File(requestedFile));


            //the 3 for loops inside this while loop make sure to iterate through the needed playlists.
            while (file.hasNextLine()) {

                //split line into an array separated by any ','
                String[] line = file.nextLine().split(",");

                if (line[0].contains("favorites")) {
                    for (int i = 0; i < allSongs.length; i++) {
                        if (allSongs[i].getTitle().equals(line[1])) {
                            this.favoritePL.enqueue(allSongs[i]);
                            break;
                        }

                    }
                } else if (line[0].contains("road trip")) {
                    for (int i = 0; i < allSongs.length; i++) {
                        if (allSongs[i].getTitle().equals(line[1])) {
                            this.roadTripPL.enqueue(allSongs[i]);
                            break;
                        }
                    }
                } else if (line[0].contains("lounge")) {
                    for (int i = 0; i < allSongs.length; i++) {
                        if (allSongs[i].getTitle().equals(line[1])) {
                            this.loungePL.enqueue(allSongs[i]);
                            break;
                        }
                    }
                }

            }
            file.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found. Check path.");
        }
    }

    /***
     * Accessor method to return the 'favorite' playlist
     * @return favorite playlist queue
     */
    public Queue<SongEntry> getFavoritePL() {

        return favoritePL;
    }

    /***
     * Accessor method to return the 'lounge' playlist
     * @return lounge playlist queue
     */
    public Queue<SongEntry> getLoungePL() {

        return loungePL;
    }

    /***
     * Accessor method to return the 'road trip' playlist
     * @return road trip playlist queue
     */
    public Queue<SongEntry> getRoadTripPL() {

        return roadTripPL;
    }
}
