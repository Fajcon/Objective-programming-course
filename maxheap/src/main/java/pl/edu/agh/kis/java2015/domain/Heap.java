package pl.edu.agh.kis.java2015.domain;

import java.util.ArrayList;
import java.util.List;

public class Heap {

	private int heapSize = 0;
	private ArrayList<Double> tab = new ArrayList<>();

	public void insert(double value) {
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
		return tab.get(currentIndex) > tab.get(parentIndex);
	}

	public void swapElements(int currentIndex, int parentIndex) {
		Double parentValue = parentValue(currentIndex);
		Double currentValue = tab.get(currentIndex);
		tab.set(parentIndex, currentValue);
		tab.set(currentIndex, parentValue);
	}

	public Double parentValue(int currentIndex) {
		Double parentValue = tab.get(parentIndex(currentIndex));
		return parentValue;
	}

	public int parentIndex(int currentIndex) { return (currentIndex - 1 )/2;
	}

	public int size() {
		return heapSize ;
	}

	public double top() {
		return tab.get(0);
	}

	public double extractMax(){
		double result = tab.get(0);
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
	public void replace(double In){
		tab.set(0, In);
	}
	public void heapify(List<Double> list){
		for (double x:list
			 ) {
			this.insert(x);
		}
	}
	public Heap merge(Heap second){
		Heap resultHeap = new Heap();
		for (int i = 0; i < this.size(); i++) {
			resultHeap.insert(this.tab.get(i));
		}
		for (int i = 0; i < second.size(); i++) {
			resultHeap.insert(second.tab.get(i));
		}
		return resultHeap;
	}
	public void meld(Heap second){
		for (int i = 0; i < second.size(); i++) {
			this.insert(second.tab.get(i));
		}

	}

}
