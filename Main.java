import datastructures.EmergencyQueue;
import datastructures.PatientBST;
import datastructures.TreatmentStack;
import model.Patient;
import model.TreatmentRecord;
import model.VisitNode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PatientBST bst = new PatientBST();
        EmergencyQueue queue = new EmergencyQueue();
        TreatmentStack stack = new TreatmentStack();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=============================================");
            System.out.println(" MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM ");
            System.out.println("=============================================");
            System.out.println("1. Patient Records (BST Operations)");
            System.out.println("2. Emergency Room Queue Operations");
            System.out.println("3. Treatment History (Stack Operations)");
            System.out.println("4. Manage Patient Visit History (Singly Linked List)");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    handleBSTOperations(bst, scanner);
                    break;
                case 2:
                    handleQueueOperations(bst, queue, scanner);
                    break;
                case 3:
                    handleStackOperations(stack, scanner);
                    break;
                case 4:
                    handleLinkedListOperations(bst, scanner);
                    break;
                case 5:
                    System.out.println("Exiting System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleBSTOperations(PatientBST bst, Scanner scanner) {
        System.out.println("\n--- BST Patient Records Menu ---");
        System.out.println("1. Insert New Patient");
        System.out.println("2. Search Patient by ID");
        System.out.println("3. Delete Patient by ID");
        System.out.println("4. Display All Patients (In-Order Traversal)");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter Patient ID (Integer): ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Patient Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Age: ");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Contact Number: ");
                String contact = scanner.nextLine();
                System.out.print("Enter Medical Condition: ");
                String condition = scanner.nextLine();

                bst.insert(new Patient(id, name, age, contact, condition));
                System.out.println("Patient record added successfully!");
                break;
            case 2:
                System.out.print("Enter Patient ID to Search: ");
                int sId = scanner.nextInt();
                Patient found = bst.search(sId);
                if (found != null) {
                    System.out.println("Patient Found: " + found);
                } else {
                    System.out.println("Patient not found.");
                }
                break;
            case 3:
                System.out.print("Enter Patient ID to Delete: ");
                int dId = scanner.nextInt();
                bst.delete(dId);
                System.out.println("Deletion process executed.");
                break;
            case 4:
                System.out.println("\n--- Patient Records (Sorted by ID) ---");
                bst.displayInOrder();
                break;
        }
    }

    private static void handleQueueOperations(PatientBST bst, EmergencyQueue queue, Scanner scanner) {
        System.out.println("\n--- Emergency Queue Menu ---");
        System.out.println("1. Enqueue Patient (Add to Waiting Queue)");
        System.out.println("2. Dequeue Patient for Treatment");
        System.out.println("3. Display Waiting Emergency Patients");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter Patient ID to Enqueue: ");
                int id = scanner.nextInt();
                Patient p = bst.search(id);
                if (p != null) {
                    queue.enqueue(p);
                } else {
                    System.out.println("Patient not found in main records! Please register patient in BST first.");
                }
                break;
            case 2:
                Patient dequeued = queue.dequeue();
                if (dequeued != null) {
                    System.out.println("Patient called for treatment: " + dequeued.getName());
                }
                break;
            case 3:
                queue.displayQueue();
                break;
        }
    }

    private static void handleStackOperations(TreatmentStack stack, Scanner scanner) {
        System.out.println("\n--- Treatment History Stack Menu ---");
        System.out.println("1. Push Completed Treatment Record");
        System.out.println("2. Pop Most Recent Treatment Record");
        System.out.println("3. Display All Completed Treatment Records");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter Patient ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Patient Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Doctor Name: ");
                String doc = scanner.nextLine();
                System.out.print("Enter Treatment Details: ");
                String details = scanner.nextLine();
                System.out.print("Enter Completion Time/Date: ");
                String time = scanner.nextLine();

                stack.push(new TreatmentRecord(id, name, doc, details, time));
                break;
            case 2:
                TreatmentRecord popped = stack.pop();
                if (popped != null) {
                    System.out.println("Removed Most Recent Record: " + popped);
                }
                break;
            case 3:
                stack.displayStack();
                break;
        }
    }

    private static void handleLinkedListOperations(PatientBST bst, Scanner scanner) {
        System.out.print("Enter Patient ID to manage visit history: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Patient p = bst.search(id);

        if (p == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.println("\n--- Visit History for Patient: " + p.getName() + " ---");
        System.out.println("1. Add New Visit Record");
        System.out.println("2. Remove Visit Record");
        System.out.println("3. Search Visit Record");
        System.out.println("4. Display All Past Visits");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter Visit ID: ");
                String vId = scanner.nextLine();
                System.out.print("Enter Visit Date: ");
                String date = scanner.nextLine();
                System.out.print("Enter Doctor Name: ");
                String doc = scanner.nextLine();
                System.out.print("Enter Diagnosis: ");
                String diag = scanner.nextLine();
                System.out.print("Enter Treatment: ");
                String treat = scanner.nextLine();

                p.getVisitHistory().addVisit(vId, date, doc, diag, treat);
                break;
            case 2:
                System.out.print("Enter Visit ID to Remove: ");
                String rId = scanner.nextLine();
                if (p.getVisitHistory().removeVisit(rId)) {
                    System.out.println("Visit record removed.");
                } else {
                    System.out.println("Visit ID not found.");
                }
                break;
            case 3:
                System.out.print("Enter Visit ID to Search: ");
                String sId = scanner.nextLine();
                VisitNode visit = p.getVisitHistory().searchVisit(sId);
                if (visit != null) {
                    System.out.println("Visit Found: " + visit);
                } else {
                    System.out.println("Visit ID not found.");
                }
                break;
            case 4:
                p.getVisitHistory().displayVisits();
                break;
        }
    }
}