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

		else
			return 1 + this.getNext().size();

	}

	@Override
	public T search(T element) {
		if (element == null || this.isEmpty())
			return null;

		if (this.getData().equals(element))
			return this.data;

		else
			return this.next.search(element);

	}

	@Override
	public void insert(T element) {
		if (element == null)
			return;

		if (this.isEmpty()) {
			this.data = element;
			this.next = new RecursiveSingleLinkedListImpl<T>();

		} else
			this.next.insert(element);

	}

	@Override
	public void remove(T element) {
		if (element == null || this.isEmpty())
			return;

		if (this.getNext().getData().equals(element)) {
			this.next = this.getNext().getNext();
			// this.getNext().setNext(new RecursiveSingleLinkedListImpl<>());

		} else {
			this.getNext().remove(element);
		}
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[this.size()];

		if (this.isEmpty())
			return array;

		this.toArrayRecursive(array, this, 0);

		return array;
	}

	private void toArrayRecursive(T[] array, RecursiveSingleLinkedListImpl<T> node, int i) {
		if (!node.isEmpty()) {
			array[i] = node.getData();
			this.toArrayRecursive(array, node.getNext(), ++i);
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

}
