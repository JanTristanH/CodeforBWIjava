package CodingChallenge;

import CodingChallenge.impl.ItemStorage;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemStorageTest {
    private ItemStorage cut;
    IItem item1;
    IItem item2;

    @Before
    public void before() {
        item1 = mock(IItem.class);
        when(item1.getName()).thenReturn("item1");
        when(item1.getWeightInGramm()).thenReturn(15);
        when(item1.getQuantity()).thenReturn(1);

        item2 = mock(IItem.class);
        when(item2.getName()).thenReturn("item2");
        when(item2.getWeightInGramm()).thenReturn(10);
        when(item2.getQuantity()).thenReturn(1);

        cut = new ItemStorage();
    }

    @Test
    public void LoadOneItem() {
        cut.loadItem(item1);
        assertThat(cut.getTotalLoad(), is(15));
    }

    @Test
    public void LoadTwoDifferentItems() {
        cut.loadItem(item1);
        cut.loadItem(item2);
        assertThat(cut.getTotalLoad(), is(25));
    }

    @Test
    public void removeOneItem() {
        cut.loadItem(item1);
        cut.unLoadItem(item1);
        assertThat(cut.getTotalLoad(), is(0));
    }

    @Test
    public void unloadOneOfTwoItems() {
        cut.loadItem(item1);
        cut.loadItem(item2);
        cut.unLoadItem(item2);
        assertThat(cut.getTotalLoad(), is(15));
    }
}
