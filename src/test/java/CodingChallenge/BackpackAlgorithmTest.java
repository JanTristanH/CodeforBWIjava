package CodingChallenge;

import CodingChallenge.impl.DynBackpack;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class BackpackAlgorithmTest {
    DynBackpack cut;
    IIterator iterator;
    ITruck truck1;
    IItem itemA = mock(IItem.class);
    IItem itemB = mock(IItem.class);
    IItem itemC = mock(IItem.class);
    IItem itemD = mock(IItem.class);
    IItemStorage iStorage;

    @Before
    public void before() {

        when(itemA.getTargetQuantity()).thenReturn(1);
        when(itemA.getName()).thenReturn("ItemA");
        when(itemA.getWeightInGramm()).thenReturn(3);
        when(itemA.getUtility()).thenReturn(30);


        when(itemB.getTargetQuantity()).thenReturn(1);
        when(itemB.getName()).thenReturn("ItemB");
        when(itemB.getWeightInGramm()).thenReturn(4);
        when(itemB.getUtility()).thenReturn(50);


        when(itemC.getTargetQuantity()).thenReturn(1);
        when(itemC.getName()).thenReturn("ItemC");
        when(itemC.getWeightInGramm()).thenReturn(2);
        when(itemC.getUtility()).thenReturn(10);


        when(itemD.getTargetQuantity()).thenReturn(1);
        when(itemD.getName()).thenReturn("ItemD");
        when(itemD.getWeightInGramm()).thenReturn(5);
        when(itemD.getUtility()).thenReturn(50);

        truck1 = mock(ITruck.class);
        when(truck1.getFreeCapacity()).thenReturn(10);

        iterator = mock(IIterator.class);
        when(iterator.next()).thenReturn(itemA, itemB, itemC, itemD);
        when(iterator.maxCount()).thenReturn(4);
        when(iterator.convertConcurrentIndexToItem(0)).thenReturn(itemA);
        when(iterator.convertConcurrentIndexToItem(1)).thenReturn(itemB);
        when(iterator.convertConcurrentIndexToItem(2)).thenReturn(itemC);
        when(iterator.convertConcurrentIndexToItem(3)).thenReturn(itemD);

        iStorage = mock(IItemStorage.class);
        ArrayList<IItem> al = new ArrayList<>();
        al.add(itemA);
        al.add(itemB);
        al.add(itemC);
        al.add(itemD);

        when(iStorage.getAllItems()).thenReturn(al);

        cut = new DynBackpack(new ITruck[]{truck1}, iStorage);
    }

    @Test
    public void lectureSample() {
        int[][] resultMatrix = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 30, 30, 30, 30, 30, 30, 30, 30},
                {0, 0, 0, 30, 50, 50, 50, 80, 80, 80, 80},
                {0, 0, 10, 30, 50, 50, 60, 80, 80, 90, 90},
                {0, 0, 10, 30, 50, 50, 60, 80, 80, 100, 100}
        };
        assertThat(cut.calculateMatrix(truck1,iterator), is(resultMatrix));
    }

    @Test
    public void backTrackAfterCalculation() {
        int[][] resultMatrix = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 30, 30, 30, 30, 30, 30, 30, 30},
                {0, 0, 0, 30, 50, 50, 50, 80, 80, 80, 80},
                {0, 0, 10, 30, 50, 50, 60, 80, 80, 90, 90},
                {0, 0, 10, 30, 50, 50, 60, 80, 80, 100, 100}
        };
        cut.calculateMatrix(truck1,iterator);

       // assertThat(cut.backtrackMatrixToIndex(resultMatrix,iterator,truck1), hasItems(itemD, itemB));
        cut.backtrackMatrixToIndex(resultMatrix,iterator,truck1);
        verify(truck1).loadItem(itemD);
        verify(truck1).loadItem(itemB);

        verify(iStorage).unLoadItem(itemD);
        verify(iStorage).unLoadItem(itemB);
    }

}
