import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Heap <T extends Comparable<T>> {

    private int heapSize = 0;
    private ArrayList<T> tab = new ArrayList<>();
    private Comparator<T> compare = Comparator.naturalOrder();

    public Heap() {}

    public Heap(Comparator<T> tComparator){
        compare=tComparator;
    }


    public void insert(T value) {
        int currentIndex = heapSize;
        int parentIndex = parentIndex(currentIndex);
        tab.add(value);
        while( isChildGreaterThanParent(currentIndex, parentIndex) ) {
            swapElements(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = parentIndex(currentIndex);
        }
        heapSize++;
    }

    public boolean isChildGreaterThanParent(int currentIndex, int parentIndex) {
        return compare.compare(tab.get(currentIndex), tab.get(parentIndex)) > 0;
    }

    public void swapElements(int currentIndex, int parentIndex) {
        T parentValue = parentValue(currentIndex);
        T currentValue = tab.get(currentIndex);
        tab.set(parentIndex, currentValue);
        tab.set(currentIndex, parentValue);
    }

    public T parentValue(int currentIndex) {
        T parentValue = tab.get(parentIndex(currentIndex));
        return parentValue;
    }

    public int parentIndex(int currentIndex) { return (currentIndex - 1 )/2;
    }

    public int size() {
        return heapSize ;
    }

    public T top() {
        return tab.get(0);
    }

    public T extractMax(){
        T result = tab.get(0);
        deleteMax();
        return result;
    }
    public void deleteMax(){
        tab.remove(0);
        heapSize--;
        if(heapSize != 0) {
            int currentIndex = heapSize - 1;
            int parentIndex = parentIndex(currentIndex);
            while (isChildGreaterThanParent(currentIndex, parentIndex)) {
                swapElements(currentIndex, parentIndex);
                currentIndex = parentIndex;
                parentIndex = parentIndex(currentIndex);
            }
        }
    }
    public void replace(T In){
        tab.set(0, In);
    }
    public void heapify(List<T> list){
        for (T x:list
        ) {
            this.insert(x);
        }
    }
    public Heap merge(Heap<T> second){
        Heap resultHeap = new Heap();
        for (int i = 0; i < this.size(); i++) {
            resultHeap.insert(this.tab.get(i));
        }
        for (int i = 0; i < second.size(); i++) {
            resultHeap.insert(second.tab.get(i));
        }
        return resultHeap;
    }
    public void meld(Heap<T> second){
        for (T element : second.tab){
            insert(element);
        }

    }

}