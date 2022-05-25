import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RandomsTest {
    @Mock
    Randoms randoms = Mockito.mock(Randoms.class);

    @Test
    void test() {
        int[] arrayValues = new int[]{1, 2, 7, 6};
        List<Integer> listValues = Arrays.stream(arrayValues).boxed().collect(Collectors.toList());
        for (int item : listValues) {
            Mockito.when(randoms.numberGeneration()).thenReturn(item);
            if (item == 7) {
                break;
            }
        }
        Mockito.verify(randoms, Mockito.times(3));
    }

    @Test
    void test2() {
        int[] arrayValues = new int[]{1, 2, 7, 34, 4, 6};
        List<Integer> listValues = Arrays.stream(arrayValues).boxed().collect(Collectors.toList());
        for (int item : listValues) {
            Mockito.when(randoms.numberGeneration()).thenReturn(item);
            if (item == 6) {
                break;
            }
        }
        Mockito.verify(randoms, Mockito.times(6));
    }

    @Test
    void test3() {
        int[] arrayValues = new int[]{1, 2, 7, 6};
        List<Integer> listValues = Arrays.stream(arrayValues).boxed().collect(Collectors.toList());
        for (int item : listValues) {
            Mockito.when(randoms.numberGeneration()).thenReturn(item);
            if (item == 17) {
                break;
            }
        }
        Mockito.verify(randoms, Mockito.never());
    }
}
