package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		if (this.isEmpty())
			return null;
		
		return array[0]; 
	}

	@Override
	public boolean isEmpty() {
		return this.tail == -1;
	}

	@Override
	public boolean isFull() {
		return this.tail == this.array.length - 1;
		
	}

	private void shiftLeft() {
		if (this.isEmpty())
			return;
		
		int aux = 0;
		while (aux != array.length - 1) {
			if (this.array[aux + 1] == null)
				break;
			
			this.array[aux] = this.array[aux + 1];
			this.array[aux + 1] = null;
			aux++;
		}
		
		this.tail--;
		
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (this.isFull())
			throw new QueueOverflowException();
		
		this.tail++;
		this.array[tail] = element;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (this.isEmpty())
			throw new QueueUnderflowException();
		
		T aux = array[0];
		this.shiftLeft();
		
		return aux;
	}


}
