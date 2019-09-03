package sorting.linearSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {
	

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		if (Util.isValid(array, leftIndex, rightIndex)) {
			
			int max = this.getMaximo(array, leftIndex, rightIndex);
			int min = this.getMinimo(array, leftIndex, rightIndex);
			
			if(min < 0)
				min = Math.abs(min);
			else
				min = -min;
			
			max += min;
			
			int[] aux = new int[max];
			int[] ordenado = new int[array.length];

			// contando as ocorrências...
			for (int i = leftIndex; i <= rightIndex; i++) {
				aux[array[i] + min] += 1;
			}
			
			aux[0] += leftIndex;

			// preenchendo o array auxiliar...
			for (int i = 1; i < aux.length; i++) {
				aux[i] += aux[i - 1];
			}
			

			for (int i = rightIndex; i >= leftIndex; i--) {
				ordenado[aux[array[i] + min] - 1] = array[i];
				aux[array[i] + min] -= 1;
			}
			
			// atribuindo os números ordenados no array original...
			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = ordenado[i];
			}
		}
	}
	
	// encontrando o menor valor do array
	private int getMinimo(Integer[] array, int leftIndex, int rightIndex) {
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < array.length; i++) {
			if (min > array[i])
				min = array[i];
		}
		
		return min;
	}
	
	// encontrando o maior valor do array
	private int getMaximo(Integer[] array, int leftIndex, int rightIndex) {
		int max = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (max < array[i])
				max = array[i];
		}
		
		return ++max;
	}
}
