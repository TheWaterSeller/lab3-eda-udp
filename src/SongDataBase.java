import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

class SongDataBase {
    private ArrayList<Song> songs;

    public SongDataBase() {
        songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void ordenarPorAlgoritmo(String algoritmo, String atributo){
        
        Comparator<Song> comparador;
        
        if("artist".equals(atributo)){
            comparador = Comparator.comparing(song -> song.getArtist());
        }else if("genre".equals(atributo)){
            comparador = Comparator.comparing(Song::getGenre);
        }else if("year".equals(atributo)){
            comparador = Comparator.comparingInt(Song::getYear);
        }else{
            comparador = Comparator.comparingLong(Song::getPlays);
        }

        if(algoritmo.equals("mergeSort")){
            Merge.sort(songs, comparador);
        }
        else if(algoritmo.equals("quickSort")){
            Quick.sort(songs, comparador);
        }else if(algoritmo.equals("insertionSort")){
            Insertion.sort(songs, comparador);
        }else if(algoritmo.equals("selectionSort")){
            Selection.sort(songs, comparador);
        }else{
            Collections.sort(songs, comparador);
        }
    }

    public void sequentialSearch(String artist){

    }

    public void binarySearch(String artist){
        
    }
}