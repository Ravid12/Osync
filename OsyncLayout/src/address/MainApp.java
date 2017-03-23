package address;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.ID3v1;
import org.farng.mp3.id3.ID3v2_2;

import address.model.*;
import address.view.SongOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Song> songData = FXCollections.observableArrayList();

    
    public MainApp() throws IOException, TagException  {
    	
    	getSongs(Directory.loadFromFile());
    	
    }
    
    

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Osync");

        initRootLayout();

        showSongOverview();
    }

    /**
     * Returns the data as an observable list of Songs. 
     * @return
     */
    public ObservableList<Song> getSongData() {
        return songData;
    }
    
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the Song overview inside the root layout.
     */
    public void showSongOverview() {
        try {
            // Load Song overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SongOverview.fxml"));
            AnchorPane SongOverview = (AnchorPane) loader.load();

            // Set Song overview into the center of root layout.
            rootLayout.setCenter(SongOverview);

            // Give the controller access to the main app.
            SongOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getSongs(String directoryName) throws IOException, TagException {
        File directory = new File(directoryName);
        String fileName;
        String title, artist, album, length;
        
        // get all the files from a directory
        File[] fileList = directory.listFiles();
        for (File file : fileList) {
        	
        	fileName = file.getName();        	
            if (file.isFile() && fileName.endsWith(".mp3")) {
            	
/*TODO: get mp3 file details to add to songData.
	If song Name is blank in OSU folder, use file name instead.
*/
            	
            	MP3File mp3 = new MP3File(file);
            	ID3v1 tag = mp3.getID3v1Tag();
            	
            	title = tag.getTitle();
            	artist = tag.getArtist();
            	album = tag.getAlbum();
            	
                songData.add(new Song(title, artist, album, "12"));
            } else if (file.isDirectory()) {
                getSongs(file.getAbsolutePath());
            }
        }
    }
    
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
