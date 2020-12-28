package CodingChallenge;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SingleItemIteratorTest {
    SingleItemIterator cut;
    IItem item1;

    @Before
    public void before() {
        item1 = mock(IItem.class);
        when(item1.getName()).thenReturn("item1");
        when(item1.getWeightInGramm()).thenReturn(15);
        when(item1.getTargetQuantity()).thenReturn(2);

        IItem[] items = new IItem[]{ item1,item1};
        cut = new SingleItemIterator(items);
    }

    @Test
    public void countOfProduct() {
        for(int i = 0; i < 4; i++){
            assertThat(cut.hasNext(), is(true));
            assertThat(cut.next(), is(item1));
        }
        assertThat(cut.hasNext(), is(false));
    }

    @Test
    public void initialHasNext(){
        assertThat(cut.hasNext(), is(true));
    }

    @Test
    public void maxCount4(){
        assertThat(cut.maxCount(), is(4));
    }
}
