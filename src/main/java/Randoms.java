import java.util.Iterator;
import java.util.Random;

public class Randoms extends Thread implements Iterable<Integer> {
    protected Random random = new Random();
    private int min;
    private int max;

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public Integer numberGeneration() {
        return random.nextInt((max - min) + 1) + min;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return numberGeneration() != null;
            }

            @Override
            public Integer next() {
                if (hasNext()) {

                    try {
                        sleep(1000);
                    } catch (Exception ignored) {
                    }

                    return numberGeneration();
                }
                return null;
            }
        };
    }
}