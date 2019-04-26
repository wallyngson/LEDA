package adt.linkedList;

import javax.lang.model.element.Element;

public class RecursiveDoubleLinkedListImpl<T> extends RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
	}

	public RecursiveDoubleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next,
			RecursiveDoubleLinkedListImpl<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	@Override
	public void insert(T element) {

		if (element == null)
			return;

		if (this.isEmpty()) {
			this.setData(element);
			this.setNext(new RecursiveDoubleLinkedListImpl<T>());
			this.setPrevious(new RecursiveDoubleLinkedListImpl<T>());

		} else {
			if (this.getNext().isEmpty()) {
				this.next.setData(element);
				this.next.setNext(new RecursiveDoubleLinkedListImpl<T>());
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);

			} else {
				this.getNext().insert(element);
			}

		}

	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			RecursiveDoubleLinkedListImpl<T> second = new RecursiveDoubleLinkedListImpl<T>(this.getData(),
					this.getNext(), this.getPrevious());

			this.setData(element);
			this.setPrevious(new RecursiveDoubleLinkedListImpl<T>());
			this.setNext(second);
			second.setPrevious(this);

		}

	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			this.setData(this.next.getData());
			this.setNext(this.next.getNext());
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			if (this.getNext().isEmpty()) {
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
			} else {
				((DoubleLinkedList<T>) this.getNext()).removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}
}
