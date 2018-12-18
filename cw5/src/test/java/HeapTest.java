import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class HeapTest {

    @Test
    public void insert0intoNewHeap_topIs0() {

        Heap heap = new Heap();
        heap.insert(0);

        assertEquals("size should be 1",1,heap.size());
        assertEquals(0,heap.top());
        assertEquals(1,heap.size());
    }

    @Test
    public void insert0AndThen2intoNewHeap_topIs2() {

        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(2);

        assertEquals("size should be 2",2,heap.size());
        assertEquals(2,heap.top());
    }

    @Test
    public void insert0And2And3And5And6intoNewHeap_topIs6() {

        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(2);
        heap.insert(3);
        heap.insert(5);
        heap.insert(6);

        assertEquals(6,heap.top());
    }

    @Test
    public void insert0AndExtractMaxValueEqual0(){
        Heap heap = new Heap();
        heap.insert(0);
        assertEquals(0,heap.extractMax());
        assertEquals(0, heap.size());

    }

    @Test
    public void insert0And1And2AndExtractMaxValueEqual2(){
        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(1);
        heap.insert(2);
        assertEquals(2,heap.extractMax());
        assertEquals(1, heap.top());
        assertEquals(2, heap.size());
    }


    @Test
    public void extractMaxValueFromHeapWithInsert0_2_3_5_6_2_7_8() {
        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(2);
        heap.insert(3);
        heap.insert(5);
        heap.insert(6);
        heap.insert(2);
        heap.insert(7);
        heap.insert(8);

        assertEquals(8, heap.extractMax());
        assertEquals(7, heap.top());
        assertEquals(7, heap.size());

    }

    @Test
    public void extract3MaxValuesFromHeapWithInsert0_2_3_5_6_2_7_8() {
        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(2);
        heap.insert(3);
        heap.insert(5);
        heap.insert(6);
        heap.insert(2);
        heap.insert(7);
        heap.insert(8);

        assertEquals(8, heap.extractMax());
        assertEquals(7, heap.top());
        assertEquals(7, heap.extractMax());
        assertEquals(6, heap.top());
        assertEquals(6, heap.extractMax());
        assertEquals(5, heap.top());
    }

    @Test
    public void insert0AndDeleteMaxValueEqual0(){
        Heap heap = new Heap();
        heap.insert(0);
        heap.deleteMax();
        assertEquals(0, heap.size());

    }

    @Test
    public void insert0And1And2AndDeleteMaxValueEqual2(){
        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(1);
        heap.insert(2);
        heap.deleteMax();
        assertEquals(1, heap.top());
        assertEquals(2, heap.size());
    }


    @Test
    public void delete3MaxValuesFromHeapWithInsert0_2_3_5_6_2_7_8() {
        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(2);
        heap.insert(3);
        heap.insert(5);
        heap.insert(6);
        heap.insert(2);
        heap.insert(7);
        heap.insert(8);

        heap.deleteMax();
        assertEquals(7, heap.top());
        heap.deleteMax();
        assertEquals(6, heap.top());
        heap.deleteMax();
        assertEquals(5, heap.top());
    }

    @Test
    public void insert0AndReplaceWith1() {
        Heap heap = new Heap();
        heap.insert(0);
        heap.replace(2);
        assertEquals(2, heap.top());
    }
    @Test
    public void insert0And1And2AndReplace2With5() {
        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(1);
        heap.insert(2);
        heap.replace(5);
        assertEquals(5, heap.top());
    }

    @Test
    public void makeHeapFromArrayList() {
        ArrayList<Double> list = new ArrayList<>();
        list.add(0.0);
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);
        Heap heap = new Heap();
        heap.heapify(list);
        assertEquals(3.0, (Double) heap.top(),0.001);
        assertEquals(4, heap.size());
    }
    @Test
    public void makeHeapFromLinkedList() {
        LinkedList<Double> list = new LinkedList<>();
        list.add(0.0);
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);
        Heap heap = new Heap();
        heap.heapify(list);
        assertEquals(3.0,heap.top());
        assertEquals(4, heap.size());
    }
    @Test
    public void mergeHeaps(){
        Heap heap1 = new Heap();
        heap1.insert(0);
        heap1.insert(2);
        heap1.insert(3);
        heap1.insert(5);
        heap1.insert(6);
        Heap heap2 = new Heap();
        heap2.insert(1);
        heap2.insert(3);
        heap2.insert(4);
        heap2.insert(6);
        heap2.insert(7);

        Heap heap3 = heap1.merge(heap2);
        assertEquals(7,heap3.top());
        assertEquals(10, heap3.size());
        assertEquals(6,heap1.top());
        assertEquals(5, heap1.size());
        assertEquals(7,heap2.top());
        assertEquals(5, heap2.size());
    }

    @Test
    public void meldHeaps(){
        Heap heap1 = new Heap();
        heap1.insert(0);
        heap1.insert(2);
        heap1.insert(3);
        heap1.insert(5);
        heap1.insert(6);
        Heap heap2 = new Heap();
        heap2.insert(1);
        heap2.insert(3);
        heap2.insert(4);
        heap2.insert(6);
        heap2.insert(7);

        heap1.meld(heap2);
        assertEquals(7,heap1.top());
        assertEquals(10, heap1.size());
    }

}