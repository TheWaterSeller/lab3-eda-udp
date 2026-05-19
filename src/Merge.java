import java.util.ArrayList;
import java.util.Comparator;

public class Merge {

    // This class should not be instantiated.
    private Merge() { }


    public static void sort(ArrayList<Song> songs, Comparator<Song> comparator) {
        ArrayList<Song> aux = new ArrayList<>(songs);
        
        // Llamamos al sort privado recursivo
        sort(songs, aux, 0, songs.size() - 1, comparator);
    }

    // Fusiona songs[lo .. mid] con songs[mid+1 .. hi] usando aux[lo .. hi]
    private static void merge(ArrayList<Song> songs, ArrayList<Song> aux, int lo, int mid, int hi, Comparator<Song> comparator) {
        
        // 1. Copiar los datos actuales al arreglo auxiliar
        for (int k = lo; k <= hi; k++) {
            aux.set(k, songs.get(k));
        }

        // 2. Fusionar de vuelta a 'songs'
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)                                      songs.set(k, aux.get(j++));
            else if (j > hi)                                       songs.set(k, aux.get(i++));
            else if (less(aux.get(j), aux.get(i), comparator))     songs.set(k, aux.get(j++)); 
            else                                                   songs.set(k, aux.get(i++));
        }
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(ArrayList<Song> songs, ArrayList<Song> aux, int lo, int hi, Comparator<Song> comparator) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(songs, aux, lo, mid, comparator);
        sort(songs, aux, mid + 1, hi, comparator);
        merge(songs, aux, lo, mid, hi, comparator);
    }

   /***************************************************************************
    *  Helper sorting function.
    ***************************************************************************/

    private static boolean less(Song v, Song w, Comparator<Song> comparator) {
        return comparator.compare(v, w) < 0;
    }
}
