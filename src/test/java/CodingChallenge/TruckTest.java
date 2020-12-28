package CodingChallenge;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TruckTest {
    private Truck cut;
    IItem item1;
    IItem item2;

    @Before
    public void before() {
        item1 = mock(IItem.class);
        when(item1.getName()).thenReturn("item1");
        when(item1.getWeightInGramm()).thenReturn(15);
        when(item1.getQuantity()).thenReturn(1);

        IItem item2 = mock(IItem.class);
        when(item2.getName()).thenReturn("item2");
        when(item2.getWeightInGramm()).thenReturn(10);
        when(item2.getQuantity()).thenReturn(1);

        cut = new Truck(100000,87000);
    }
    @Test
    public void getFreeInialCapacity (){
        assertThat(cut.getFreeCapacity(), is(13000));
    }
    @Test
    public void getCapacity (){
        assertThat(cut.getCapacityGramm(), is(100000));
    }

    @Test
    public void initialLoadZero(){
        assertThat(cut.getTotalLoad(), is(0));
    }

    @Test
    public void LoadOneItem(){
        cut.loadItem(item1);
        assertThat(cut.getTotalLoad(), is(15));
    }

    @Test
    public void LoadTwoDifferentItems(){
        cut.loadItem(item1);
        cut.loadItem(item2);
        assertThat(cut.getTotalLoad(), is(25));
    }
}
