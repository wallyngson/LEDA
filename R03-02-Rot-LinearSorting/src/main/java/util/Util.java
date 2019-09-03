package util;

/**
 * Class containing useful methods for arrays manipulation.
 */
public class Util {

	/**
	 * Swaps the contents of two positions in an array.
	 *
	 * @param array
	 *            The array to be modified, not null
	 * @param i
	 *            One of the target positions
	 * @param j
	 *            The other target position
	 */
	public static void swap(Object[] array, int i, int j) {
		if (array == null)
			throw new IllegalArgumentException();

		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * It says if a specific number is prime or not.
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPrime(long n) {
		boolean result = true;
		for (int i = 2; i < n; i++) {
			if (n % i == 0){
				result = false;
				break;
			}
		}
		return result;
	}
	
	/**
	 * Verifica se todos os paramêtros passados são corretos.
	 * 
	 * @param array
	 *					Array a ser verificado
	 * @param leftIndex
	 * 					Indice mais a esquerda do array
	 * @param rigthIndex
	 * 					Indice mais a direita do array
	 * @return
	 */
	public static boolean isValid(Integer[] array, int leftIndex, int rigthIndex) {
		
		if (array == null)
			return false;
		else if (leftIndex < 0 || rigthIndex < 0)
			return false;
		else if (leftIndex >= rigthIndex)
			return false;
		else if (rigthIndex >= array.length)
			return false;
		else return true;

	}
}