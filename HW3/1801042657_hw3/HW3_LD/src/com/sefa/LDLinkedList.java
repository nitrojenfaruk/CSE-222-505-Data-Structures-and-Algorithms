package com.sefa;

import java.util.AbstractList;

/**
 * 
 * @author Sefa Cicek
 * My own Linked List structure. It has Node class.
 *
 */
public class LDLinkedList extends AbstractList<Object> {
	
	  	private Node head;
	    private Node garbageHead;

	    static class Node {
	        Node next;
	        Object data;

	        Node(Object d) {
	            data = d;
	            next = null;
	        }
	    }

	    @Override
	    public Object get(int index) {
	        if (index < 0)
	            throw new IndexOutOfBoundsException();
	        Node current = head;
	        for (int i = 0; i < index; i++) {
	            current = current.next;
	        }
	        return current.data;
	    }

	    @Override
	    public int size() {
	        Node current = head;
	        int size = 0;
	        while (current != null) {
	            size++;
	            current = current.next;
	        }
	        return size;
	    }

	    @Override
	    public boolean add(Object e) {

	        // If second list (head of list = garbageHead) has node (e), it'll be added by the second list. 
	        if (!(contain(garbageHead, e))) {
	            Node newNode = new Node(e);
	            if (head == null) {
	                head = newNode;
	                return true;
	            } else {
	                Node current = head;
	                while (current.next != null)
	                current = current.next;
	                current.next = newNode;
	                return true;
	            }
	        } else {
	            if(garbageHead.data == e){
	                if (head == null) {
	                    head = garbageHead;
	                } else {
	                    Node current = head;
	                    while (current.next != null)
	                        current = current.next;
	                    current.next = garbageHead;
	                }
	                return true;
	            }
	            else{
	                Node n = garbageHead;
	                while (n.next != null) {
	                    if (n.data == e) {
	                        if (head == null) {
	                            head = n;
	                        } else {
	                            Node current = head;
	                            while (current.next != null)
	                                current = current.next;
	                            current.next = n;
	                        }
	                        return true;
	                    } else
	                        n = n.next;
	                }
	            }

	        }
	        return false;
	    }
	    
	    /**
	     * Check existence of node on the second list.
	     * @param n the second list
	     * @param obj the node to be added to the exist list
	     * @return boolean
	     */
	    public boolean contain(Node n, Object obj) {

	        if (n == null)
	            return false;

	        if (n.data == obj)
	            return true;

	        while (n.next != null) {
	            if (n.data == obj) {
	                return true;
	            } else
	                n = n.next;
	        }

	        return false;
	    }

	    @Override
	    public void add(int index, Object element) {

	        Node newNode = new Node(element);
	        if (index == 0) {
	            newNode.next = head;
	            head = newNode;
	        } else {
	            Node current = head;
	            for (int i = 0; i < index; i++) {
	                current = current.next;
	            }
	            newNode.next = current.next;
	            current.next = newNode;
	        }

	    }

	    @Override
	    public Object set(int index, Object element) {

	        if (index < 0)
	            throw new IndexOutOfBoundsException();

	        Node prev = null;
	        Node current = head;

	        for (int i = 0; i < index; i++) {
	            current = current.next;
	        }
	        prev = current;
	        current.data = element;

	        return prev.data;
	    }

	    @Override
	    public boolean remove(Object o) {

	        if (head.data == o) {
	            head = head.next;
	            return true;
	        } else {
	            Node before = new Node(null);
	            before.next = head;
	            Node current = head;
	            while (current.next != null) {
	                if (current.data == o) {
	                    lazyDeletion(current.data);
	                    before.next = current.next;
	                    return true;
	                }
	                before = before.next;
	                current = current.next;
	            }
	        }
	        return false;
	    }
	    
	    /**
	     * Adding deleted item to the second list for later use.
	     * @param data the node to be added to the second list
	     * @return boolean
	     */
	    private boolean lazyDeletion(Object data) {

	        Node newNode = new Node(data);

	        if (garbageHead == null) {
	            garbageHead = newNode;
	        } else {
	            Node current = head;
	            while (current.next != null)
	                current = current.next;
	            current.next = newNode;
	        }
	        return true;
	    }

}
