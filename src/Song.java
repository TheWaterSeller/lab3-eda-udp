import java.util.Comparator;

public class Song {
    private int id;
    private String title;
    private String artist;
    private String genre;
    private int year;
    private long plays;

    public Song(int id, String title, String artist, String genre, int year, long plays) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.plays = plays;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public long getPlays() {
        return plays;
    }
    // El laboratorio pide que más adelante la clase SongDataBase pueda ordenar por plays, artist, genre o year. por ende, se dejarán listos los comparadores
    public static Comparator<Song> CompararPlays = new Comparator<Song>() {
        @Override
        public int compare(Song s1, Song s2) {
            return Long.compare(s1.getPlays(), s2.getPlays());
        }
    };

    public static Comparator<Song> CompararArtist = new Comparator<Song>() {
        @Override
        public int compare(Song s1, Song s2) {
            return s1.getArtist().compareTo(s2.getArtist());
        }
    };

    public static Comparator<Song> CompararGenre = new Comparator<Song>() {
        @Override
        public int compare(Song s1, Song s2) {
            return s1.getGenre().compareTo(s2.getGenre());
        }
    };

    public static Comparator<Song> CompararYear = new Comparator<Song>() {
        @Override
        public int compare(Song s1, Song s2) {
            return Integer.compare(s1.getYear(), s2.getYear());
        }
    };

}