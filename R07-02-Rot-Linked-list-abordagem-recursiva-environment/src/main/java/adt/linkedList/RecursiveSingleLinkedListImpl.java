package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {
	}

	public RecursiveSingleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		if (this.isEmpty())
			return 0;

		return 1 + this.next.size();
	}

	@Override
	public T search(T element) {
		if (elementValid(element)) {
			
			if (this.isEmpty())
				return null;
			
			else {
				
				if (this.data.equals(element))
					return this.data;
				
				else return this.next.search(element);
			}
			
		} return null;
	}

	@Override
	public void insert(T element) {
		if (elementValid(element)) {
			if (this.isEmpty()) {
				this.setData(element);
				this.setNext(new RecursiveSingleLinkedListImpl<T>());
			}
			
			else {
				this.next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (elementValid(element)) {
			
			if (!isEmpty()) {
				
				if (this.data.equals(element)) {
					this.setData(this.next.getData());
					this.setNext(this.next.next);
				}
				
				else this.next.remove(element);
				
			}
		}
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[this.size()];
		
		this.createArray(array, new RecursiveSingleLinkedListImpl<T>(this.data, this.next), 0);
		
		return array;
		
	}
	
	private void createArray(T[] arr, RecursiveSingleLinkedListImpl<T> node, int count) {
		if (node.getData() != null) {
			arr[count] = node.getData();
			
			this.createArray(arr, node.getNext(), ++count);
		}
		
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

	private boolean elementValid(T element) {
		return element != null;
	}
}
