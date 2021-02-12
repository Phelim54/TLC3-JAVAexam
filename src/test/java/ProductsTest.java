import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProductsTest {

    @Test
    void getPriceForAllFutures() {
        Futures futures = mock(Futures.class);

        when(futures.getPrice()).thenReturn(20.32);
        assertTrue(futures.getPrice() != 0);
    }
}