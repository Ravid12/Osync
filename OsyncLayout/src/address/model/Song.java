package address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Song.
 */

public class Song {

    private final StringProperty name;
    private final StringProperty artist;
    private final StringProperty album;
    private final StringProperty length;
    

    //Default Constructor
    public Song() {
    	this(null, null, null, null);
    }
    
    /**
     * Constructor with some initial data.
     */
    public Song(String name, String artist, String album, String length) {
        this.name = new SimpleStringProperty(name);
        this.artist = new SimpleStringProperty(artist);
        this.album = new SimpleStringProperty(album);
        this.length = new SimpleStringProperty(length);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getArtist() {
        return artist.get();
    }

    public void setArtist(String artist) {
        this.artist.set(artist);
    }

    public StringProperty artistProperty() {
        return artist;
    }

    public String getAlbum() {
        return album.get();
    }

    public void setAlbum(String album) {
        this.album.set(album);
    }

    public StringProperty albumProperty() {
        return album;
    }

    public String getLength() {
        return length.get();
    }

    public void setLength(String length) {
        this.length.set(length);
    }

    public StringProperty lengthProperty() {
		return length;
    }
}