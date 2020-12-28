package CodingChallenge;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BackpackAlgorithmTest {
    DynBackpack cut;
    IIterator iterator;
    ITruck truck1;

    @Before
    public void before() {
        IItem itemA = mock(IItem.class);
        when(itemA.getTargetQuantity()).thenReturn(1);
        when(itemA.getName()).thenReturn("ItemA");
        when(itemA.getWeightInGramm()).thenReturn(3);
        when(itemA.getUtility()).thenReturn(30);

        IItem itemB = mock(IItem.class);
        when(itemB.getTargetQuantity()).thenReturn(1);
        when(itemB.getName()).thenReturn("ItemB");
        when(itemB.getWeightInGramm()).thenReturn(4);
        when(itemB.getUtility()).thenReturn(50);

        IItem itemC = mock(IItem.class);
        when(itemC.getTargetQuantity()).thenReturn(1);
        when(itemC.getName()).thenReturn("ItemC");
        when(itemC.getWeightInGramm()).thenReturn(2);
        when(itemC.getUtility()).thenReturn(10);

        IItem itemD = mock(IItem.class);
        when(itemD.getTargetQuantity()).thenReturn(1);
        when(itemD.getName()).thenReturn("ItemD");
        when(itemD.getWeightInGramm()).thenReturn(5);
        when(itemD.getUtility()).thenReturn(50);

        truck1 = mock(ITruck.class);
        when(truck1.getFreeCapacity()).thenReturn(10);

        iterator = mock(IIterator.class);
        when(iterator.next()).thenReturn(itemA, itemB, itemC, itemD);
        when(iterator.maxCount()).thenReturn(4);

        cut = new DynBackpack(new ITruck[]{truck1}, iterator);
    }

    @Test
    public void lectureSample() {
        int[][] resultMatrix = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 30, 30, 30, 30, 30, 30, 30, 30},
                {0, 0, 0, 30, 50, 50, 50, 80, 80, 80, 80},
                {0, 0, 10, 30, 50, 50, 60, 80, 80, 90, 90},
                {0, 0, 10, 30, 50, 50, 60, 80, 80, 100, 100}
        };
        assertThat(cut.calculateMatrix(truck1), is(resultMatrix));
    }

}
