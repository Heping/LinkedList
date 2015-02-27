package com.peace.linkedList;

public class SinglyLinkedList {
	Node start;
	int size;

	public SinglyLinkedList() {
		start = null;
		size = 0;
	}

	// insertAtLast
	public void add(String data) {
		insertAtLast(data);
	}

	public void insertAtLast(String data) {
		if (size == 0) {
			start = new Node();
			start.next = null;
			start.data = data;
		} else {
			Node currentNode = getNodeAt(size - 1);
			Node newNode = new Node();
			newNode.data = data;
			newNode.next = null;
			currentNode.next = newNode;
		}
		size++;
	}

	public void insertAtFirst(String data) {
		if (size == 0) {
			start = new Node();
			start.next = null;
			start.data = data;
		} else {
			Node newNode = new Node();
			newNode.data = data;
			newNode.next = start;
			start = newNode;
		}
		size++;
	}

	public Node getNodeAt(int nodePos) throws ArrayIndexOutOfBoundsException {
		if (nodePos >= size || nodePos < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Node temp = start; // Move pointer to front
		int counter = 0;
		for (; counter < nodePos; counter++) {
			temp = temp.next;
		}
		return temp;
	}

	public void insertAt(int position, String data) {
		if (position == 0) {
			insertAtFirst(data);
		} else if (position == size - 1) {
			insertAtLast(data);
		} else {
			Node tempNode = getNodeAt(position - 1);
			Node newNode = new Node();
			newNode.data = data;
			newNode.next = tempNode.next;
			tempNode.next = newNode;
			size++;
		}
	}

	public Node getFirst() {
		return getNodeAt(0);
	}

	public Node getLast() {
		return getNodeAt(size - 1);
	}

	public String removeAtFirst() {
		if (size == 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		String data = start.data;
		start = start.next;
		size--;
		return data;
	}

	public String removeAtLast() {
		if (size == 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Node tempNode = getNodeAt(size - 2);
		String data = tempNode.next.data;
		tempNode.next = null;
		size--;
		return data;
	}

	public String removeAt(int position) {
		if (position == 0) {
			return removeAtFirst();
		} else if (position == size - 1) {
			return removeAtLast();
		} else {
			Node tempNode = getNodeAt(position - 1);
			String data = tempNode.next.data;
			tempNode.next = tempNode.next.next;
			size--;
			return data;
		}
	}

	public int size() {
		return size;
	}

	public String toString() {
		if (size == 0) {
			return "";
		} else {
			StringBuilder output = new StringBuilder();
			Node tempNode = start;
			while (tempNode.next != null) {
				output.append(tempNode.data).append(", ");
				tempNode = tempNode.next;
			}
			output.append(tempNode.data);
			return output.toString();
		}
	}

	public void reverseList(SinglyLinkedList sourceList) {
		if (sourceList.size <= 1) {
			return;
		}
		Node nearNode = sourceList.start;
		Node midNode, farNode;

		midNode = nearNode.next;
		farNode = midNode.next;

		nearNode.next = null;

		while (farNode != null) {
			midNode.next = nearNode;

			nearNode = midNode;
			midNode = farNode;
			farNode = farNode.next;
		}
		midNode.next = nearNode;
		sourceList.start = midNode;
	}

//	public int indexOf(String s) {
//		int index = 0;
//		if (size == 0) {
//			return -1;
//		} else {
//			for (int i = 0; i < size; i++) {
//				Node element = getNodeAt(i);
//				if (element.data.equals(s)) {
//					//removeAt(i);
//					System.out.println("During finding, index: " + i);
//					index = i;
//				}
//			}
//		}
//		return index;
//	}
	
	public int indexOf(String s){
		   Node temp = start; //start at the beginning of the list
		   int i = 0; //create a counter field that isn't local to a loop

		  //while we haven't found the elem we are looking for, keep looking
		   for(; !(temp.data).equals(s) && temp != null; i++)
			  temp = temp.next;
		   if(i == size()) return -1; //if the elem wasn't found, return -1
		   return i;   //otherwise, return the index
			
		}

	public Node findHead(String s) {
		Node temp = start;
		if ((temp.data).equals(s)) {
			return start.next;
		} else {
			return start;
		}
	}
	
//	public Node findHead(String s) {
//		Node temp = start;
//		int i = 0;
//		for (; !(temp.data).equals(s) && temp != null; i++)
//			temp = temp.next;
//
//		if (i == 0) {
//			return start.next;
//		} else if (i == size()) {
//			return null;
//		} else {
//			return start;
//		}
//
//	}
	public static void main(String[] args) {
		SinglyLinkedList sampleList = new SinglyLinkedList();
		int[] s = { 5, 3, 8, 9, 1, 7, 4, 2 };
		for (int i = 0; i < s.length; i++) {
			sampleList.add("" + s[i]);
		}
		System.out.println("List contains: " + sampleList);
		//sampleList.reverseList(sampleList);
		//System.out.println("After reversal, List contains: " + sampleList);
		
		Node temp = sampleList.findHead("7");
		System.out.println("Result: "+ temp.data);
	}
}