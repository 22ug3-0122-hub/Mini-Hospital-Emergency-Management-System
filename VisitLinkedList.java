package model;

public class VisitLinkedList {
    private VisitNode head;

    public VisitLinkedList() {
        this.head = null;
    }

    // Add a new visit to the linked list
    public void addVisit(String visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        VisitNode newVisit = new VisitNode(visitId, visitDate, doctorName, diagnosis, treatment);
        if (head == null) {
            head = newVisit;
        } else {
            VisitNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newVisit;
        }
        System.out.println("Visit added successfully.");
    }

    // Remove a visit by visitId
    public boolean removeVisit(String visitId) {
        if (head == null) return false;

        if (head.getVisitId().equalsIgnoreCase(visitId)) {
            head = head.next;
            return true;
        }

        VisitNode current = head;
        while (current.next != null && !current.next.getVisitId().equalsIgnoreCase(visitId)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }
        return false;
    }

    // Search for a visit by visitId
    public VisitNode searchVisit(String visitId) {
        VisitNode temp = head;
        while (temp != null) {
            if (temp.getVisitId().equalsIgnoreCase(visitId)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Display all visits
    public void displayVisits() {
        if (head == null) {
            System.out.println("No past visits found.");
            return;
        }
        VisitNode temp = head;
        while (temp != null) {
            System.out.println("  -> " + temp);
            temp = temp.next;
        }
    }
}