package address.view;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.swing.JFileChooser;

import address.MainApp;
import address.model.*;

public class SongOverviewController {
    @FXML
    private Label directoryLabel;	
	@FXML
    private TableView<Song> songTable;
    @FXML
    private TableColumn<Song, String> nameColumn;
    @FXML
    private TableColumn<Song, String> artistColumn;
    @FXML
    private TableColumn<Song, String> albumColumn;
    @FXML
    private TableColumn<Song, String> lengthColumn;

    @FXML
    private Label nameLabel;
    @FXML
    private Label artistLabel;
    @FXML
    private Label albumLabel;
    @FXML
    private Label lengthLabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public SongOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the Song table with the two columns.
    	directoryLabel.setText(Directory.loadFromFile());
    	
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        artistColumn.setCellValueFactory(cellData -> cellData.getValue().artistProperty());
        albumColumn.setCellValueFactory(cellData -> cellData.getValue().albumProperty());
        lengthColumn.setCellValueFactory(cellData -> cellData.getValue().lengthProperty());
    }
    
    @FXML
    private void directoryButtonClicked(ActionEvent event) {
        
    	try {
    		String dir = getDirDialog();
            this.directoryLabel.setText(dir);
            Directory.writeToFile(dir);
        } catch(Exception e)  {
    	}
    	
    }
    
    private static String getDirDialog ()	{
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new java.io.File("C:/" ));
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    	String dir;
    	
        //Handle open button action.
        fc.showOpenDialog(null);

        dir= fc.getSelectedFile().getAbsolutePath();
        return (dir);
    }
    
    public void setSongList( ObservableList<Song> songs )
    {
    	
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        //Add list to table
        songTable.setItems(mainApp.getSongData());

        
    }
}