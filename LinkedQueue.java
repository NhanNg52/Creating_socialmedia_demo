//HUU NGUYEN CIS22C

package finalProject;

import java.util.EmptyStackException;

public final class LinkedQueue<T> implements QueueInterface<T>
	{
		private Node firstNode;
		private Node lastNode;
		
		public LinkedQueue() {
			firstNode = null;
			lastNode= null;
		}

		@Override
		public void enqueue(T newEntry) {
			Node newNode = new Node(newEntry, null);
			if(isEmpty())
				firstNode = newNode;
			else
				lastNode.setNextNode(newNode);
			lastNode= newNode;
			
		}

		@Override
		public T dequeue() {
			T front = getFront();
			assert firstNode != null;
			firstNode.setData(null);
			firstNode = firstNode.getNextNode();
			
			if(firstNode == null)
				lastNode=null;
			return front;
		}

		@Override
		public T getFront() {
			if(isEmpty())
				throw new EmptyStackException();
			else
				return (T) firstNode.getData();
		}

		@Override
		public boolean isEmpty() {
			return (firstNode==null)&&(lastNode==null);
			
		}

		@Override
		public void clear() {
			firstNode=null;
			lastNode=null;
			
		}

	}
	
	class Node<T>
	{
		private T data;
		private Node next;
		
		 Node(T dataPortion) {
			this(dataPortion, null);
		}
		
		 Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}
		
		 T getData() {
			return data;
		}
		
		void setData(T newData) {
			data = newData;
		}
		
		Node getNextNode() {
			return next;
		}
		
		void setNextNode(Node nextNode) {
			next = nextNode;
		}
	}

 // end Linkedqueue


