package CodingChallenge;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SingleItemIteratorTest {
    SingleItemIterator cut;
    IItem item1;
    IItem item2;

    @Before
    public void before() {
        item1 = mock(IItem.class);
        when(item1.getName()).thenReturn("item1");
        when(item1.getWeightInGramm()).thenReturn(15);
        when(item1.getTargetQuantity()).thenReturn(2);
        item2 = mock(IItem.class);
        when(item2.getName()).thenReturn("item2");
        when(item2.getWeightInGramm()).thenReturn(15);
        when(item2.getTargetQuantity()).thenReturn(2);

        IItem[] items = new IItem[]{item1, item2};
        cut = new SingleItemIterator(items);
    }

    private void hasNextAndNext(int limit, IItem item) {
        for (int i = 0; i < limit; i++) {
            assertThat(cut.hasNext(), is(true));
            assertThat(cut.next(), is(item));
        }
    }

    @Test
    public void countOfProduct() {
        hasNextAndNext(2, item1);
        hasNextAndNext(2, item2);
        assertThat(cut.hasNext(), is(false));
    }

    @Test
    public void countOfProductResets() {
        hasNextAndNext(2, item1);
        hasNextAndNext(2, item2);

        cut.reset();
        hasNextAndNext(2, item1);
        hasNextAndNext(2, item2);
        assertThat(cut.hasNext(), is(false));
    }

    @Test
    public void initialHasNext() {
        assertThat(cut.hasNext(), is(true));
    }

    @Test
    public void maxCount4() {
        assertThat(cut.maxCount(), is(4));
    }

    @Test
    public void concurrentIndexToProduct() {
        hasNextAndNext(2, item1);
        hasNextAndNext(2, item2);
        assertThat(cut.convertConcurrentIndexToItem(0),is(item1));
        assertThat(cut.convertConcurrentIndexToItem(1),is(item1));
        assertThat(cut.convertConcurrentIndexToItem(2),is(item2));
        assertThat(cut.convertConcurrentIndexToItem(3),is(item2));
    }
}
