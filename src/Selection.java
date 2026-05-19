import java.util.Comparator;
import java.util.ArrayList;

public class Selection {

    // This class should not be instantiated.
    private Selection() { }

    /**
     * Rearranges the array in ascending order, using a comparator.
     * @param a the array
     * @param comparator the comparator specifying the order
     */
    public static void sort(ArrayList<Song> songs, Comparator<Song> comparator) {
        int n = songs.size();
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(comparator, songs.get(j), songs.get(min))) min = j;
            }
            exch(songs, i, min);
        }
    }


    // is v < w ?
    private static boolean less(Comparator<Song> comparator, Song v, Song w) {
        return comparator.compare(v, w) < 0;
    }


    // exchange a[i] and a[j]
    private static void exch(ArrayList<Song> songs, int i, int j) {
        Song swap = songs.get(i);
        songs.set(i, songs.get(j));
        songs.set(j, swap);
    }
}
