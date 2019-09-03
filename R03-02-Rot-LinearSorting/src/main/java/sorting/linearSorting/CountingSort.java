package sorting.linearSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * Classe que implementa a estratÃ©gia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o mÃ¡ximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

		@Override
		public void sort(Integer[] array, int leftIndex, int rightIndex) {
			
			if (Util.isValid(array, leftIndex, rightIndex)) {

				int maior = this.getMaior(array, leftIndex, rightIndex);
				int[] aux = new int[maior];
				int[] ordenado = new int[array.length];

				// verificando a ocorrência no array original...
				for (int i = leftIndex; i <= rightIndex; i++) {
					aux[array[i]] += 1;
				}
				
				aux[0] += leftIndex;
				
				// preenchendo todos os valores no array auxiliar...
				for (int i = 1; i < aux.length; i++) {
					aux[i] += aux[i - 1];
				}
				
				for (int i = rightIndex; i >= leftIndex; i--) {
					ordenado[aux[array[i]] - 1] = array[i];
					aux[array[i]] -= 1;
				}
				
				// atribuindo os números ordenados no array original...
				for (int i = leftIndex; i <= rightIndex; i++) {
					array[i] = ordenado[i];
				}
			}
			
		}

		// encontrando o maior elemento do array original...
		private int getMaior(Integer[] array, int leftIndex, int rightIndex) {
			int maior = 0;
			for (int i = leftIndex; i <= rightIndex; i++) {
				if (array[i] > maior)
					maior = array[i];
			}

			return ++maior;
		}
}
