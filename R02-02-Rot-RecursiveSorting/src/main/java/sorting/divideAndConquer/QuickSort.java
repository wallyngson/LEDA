package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex){
		if (array != null && leftIndex < rightIndex) {
			int posicaoPivot = separar(array, leftIndex, rightIndex);

			sort(array, leftIndex, posicaoPivot - 1);
			sort(array, posicaoPivot + 1, rightIndex);
		}
	}

	private int separar(T[] array, int leftIndex, int rightIndex) {
		T pivo = array[leftIndex];
		int i = leftIndex + 1;
		int j = rightIndex;

		while (i <= j) {
			if (array[i].compareTo(pivo) <= 0) 
				i += 1;
			else if (array[j].compareTo(pivo) > 0) 
				j -= 1;
			else {
				Util.swap(array, i, j);
				i += 1;
				j -= 1;
			}
		}

		array[leftIndex] = array[j];
		array[j] = pivo;
		return j;
	}
}
