package com.mart.dagger2sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BasicTest {

    @Test
    public void myTest(){
        // mock creation
        List mockedList = mock(List.class);

        // using mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one");
        mockedList.clear();

        // selective, explicit, highly readable verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }


    @Mock private LinkedList mockedList;

    @Test
    public void myTest2(){
        // you can mock concrete classes, not only interfaces

        // stubbing appears before the actual execution
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(0).equals("first") + "").thenReturn("second");

        // the following prints "first"
        System.out.println(mockedList.get(0));

        // the following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));
    }

    @Test
    public void test3(){
        List a = mock(List.class);
        a.add(0);
        when(a.get(0)).thenReturn(1);
        verify(a, timeout(1)).add(0);
    }
}
