package datastructures;

import model.Patient;

public class PatientBST {
    private Patient root;

    public PatientBST() {
        this.root = null;
    }

    // Insert Patient
    public void insert(Patient newPatient) {
        root = insertRecursive(root, newPatient);
    }

    private Patient insertRecursive(Patient current, Patient newPatient) {
        if (current == null) {
            return newPatient;
        }
        if (newPatient.getPatientId() < current.getPatientId()) {
            current.left = insertRecursive(current.left, newPatient);
        } else if (newPatient.getPatientId() > current.getPatientId()) {
            current.right = insertRecursive(current.right, newPatient);
        } else {
            System.out.println("Patient ID already exists!");
        }
        return current;
    }

    // Search Patient
    public Patient search(int patientId) {
        return searchRecursive(root, patientId);
    }

    private Patient searchRecursive(Patient current, int patientId) {
        if (current == null || current.getPatientId() == patientId) {
            return current;
        }
        if (patientId < current.getPatientId()) {
            return searchRecursive(current.left, patientId);
        }
        return searchRecursive(current.right, patientId);
    }

    // Delete Patient
    public void delete(int patientId) {
        root = deleteRecursive(root, patientId);
    }

    private Patient deleteRecursive(Patient current, int patientId) {
        if (current == null) return null;

        if (patientId < current.getPatientId()) {
            current.left = deleteRecursive(current.left, patientId);
        } else if (patientId > current.getPatientId()) {
            current.right = deleteRecursive(current.right, patientId);
        } else {
            // Node with only one child or no child
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;

            // Node with two children: get in-order successor (smallest in right subtree)
            current = findMin(current.right);
            current.right = deleteRecursive(current.right, current.getPatientId());
        }
        return current;
    }

    private Patient findMin(Patient root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // In-Order Traversal (Sorted Display)
    public void displayInOrder() {
        if (root == null) {
            System.out.println("No patient records in the system.");
            return;
        }
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Patient node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.println(node);
            inOrderRecursive(node.right);
        }
    }
}