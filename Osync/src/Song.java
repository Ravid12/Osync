import java.util.Scanner; 


public class Song {
	
	public String name;
	public String artist;
	public String album;
	public int length;
	
	
	public Song (String name, String artist, String album, int number, int length)
	{
		this.name=name;
		this.artist=artist;
		this.album=album;
		this.length=length;
	}
	
	
/*
	public String GetName (String name)
	{
		return name;
	}
	public String GetArtist (String artist)
	{
		return artist;
	}
	public String GetAlbum (String album)
	{
		return album;
	}
*/

	
	public void ChangeName (String name)
	{
		System.out.println("current name: " + name);
		System.out.println("insert new name: ");
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		scan.close();
		this.name=s;
	}
	
	public void ChangeArtist (String artist)
	{
		System.out.println("current artist: " + artist);
		System.out.println("insert new artist: ");
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		scan.close();
		this.artist=s;
	}

	public void ChangeAlbum (String album)
	{
		System.out.println("current album: " + album);
		System.out.println("insert new album: ");
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		scan.close();
		this.album=s;
	}

}
