package datastructures;

import model.Patient;

public class EmergencyQueue {
    private class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    public EmergencyQueue() {
        this.front = null;
        this.rear = null;
    }

    // Enqueue
    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);
        if (rear == null) {
            front = rear = newNode;
            System.out.println("Patient " + patient.getName() + " added to emergency queue.");
            return;
        }
        rear.next = newNode;
        rear = newNode;
        System.out.println("Patient " + patient.getName() + " added to emergency queue.");
    }

    // Dequeue
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty! No patients waiting for emergency treatment.");
            return null;
        }
        Patient patient = front.patient;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return patient;
    }

    public boolean isEmpty() {
        return front == null;
    }

    // Display Queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Emergency Queue is currently empty.");
            return;
        }
        System.out.println("=== Emergency Patients Waiting (FIFO Order) ===");
        Node temp = front;
        int position = 1;
        while (temp != null) {
            System.out.println(position + ". " + temp.patient);
            temp = temp.next;
            position++;
        }
    }
}