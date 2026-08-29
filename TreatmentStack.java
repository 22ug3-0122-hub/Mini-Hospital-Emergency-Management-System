package datastructures;

import model.TreatmentRecord;

public class TreatmentStack {
    private class Node {
        TreatmentRecord record;
        Node next;

        Node(TreatmentRecord record) {
            this.record = record;
            this.next = null;
        }
    }

    private Node top;

    public TreatmentStack() {
        this.top = null;
    }

    // Push
    public void push(TreatmentRecord record) {
        Node newNode = new Node(record);
        newNode.next = top;
        top = newNode;
        System.out.println("Treatment record stored in stack.");
    }

    // Pop
    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty! No treatment records available to remove.");
            return null;
        }
        TreatmentRecord record = top.record;
        top = top.next;
        return record;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // Display Stack
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Treatment Stack is empty.");
            return;
        }
        System.out.println("=== Completed Treatments (Most Recent First - LIFO) ===");
        Node temp = top;
        while (temp != null) {
            System.out.println("  -> " + temp.record);
            temp = temp.next;
        }
    }
}