# Mini Hospital Emergency Management System

An emergency hospital patient management application designed and implemented in Java for **CIT300 - Data Structures and Algorithms** at Sri Lanka Technology Campus (SLTC). 

This system models real-time hospital emergency workflows including patient registration, priority emergency queuing, treatment history tracking, and per-patient medical visit records using fundamental custom data structures without external libraries.

---

## 📌 Project Overview & System Features

The application provides a comprehensive command-line interface (CLI) to manage four core emergency unit operations:

1. **Patient Records Management (Binary Search Tree):** Stores and indexes patient demographic details efficiently using unique Patient IDs as keys.
2. **Emergency Room Priority Queue (FIFO Queue):** Manages real-time patient arrivals waiting for emergency treatment on a first-in, first-out basis.
3. **Completed Treatment History (LIFO Stack):** Logs completed treatments in reverse chronological order to enable rapid retrieval of recent medical actions.
4. **Patient Visit History (Singly Linked List):** Maintains individual, dynamically scalable visit logs for each registered patient.

---

## 🛠️ Data Structures Implementation Breakdown

| Data Structure | Component | Strategic Purpose & Principle | Operations Implemented |
| :--- | :--- | :--- | :--- |
| **Binary Search Tree (BST)** | `PatientBST` | Efficient indexing and retrieval of master patient records. | Insert Patient, Search by ID, Delete Patient, In-Order Traversal (Sorted Output). |
| **Queue** | `EmergencyQueue` | Manages arriving emergency patients adhering strictly to **FIFO** (First-In, First-Out). | Enqueue, Dequeue, Display Queue, Empty Queue Handling. |
| **Stack** | `TreatmentStack` | Tracks treatment completion history adhering strictly to **LIFO** (Last-In, First-Out). | Push Record, Pop Record, Display Stack, Empty Stack Handling. |
| **Singly Linked List** | `VisitLinkedList` | Tracks dynamic past visit entries embedded inside each patient's record. | Add Visit, Remove Visit by ID, Search Visit, Display History. |

---

## 📁 Repository Structure

```text
MiniHospitalSystem/
├── src/
│   ├── model/
│   │   ├── Patient.java             # Main patient entity (contains embedded VisitLinkedList)
│   │   ├── VisitNode.java           # Node model for individual patient visit records
│   │   └── TreatmentRecord.java     # Completed treatment event record
│   ├── datastructures/
│   │   ├── PatientBST.java          # Custom Binary Search Tree implementation
│   │   ├── EmergencyQueue.java      # Custom FIFO Queue implementation
│   │   ├── TreatmentStack.java      # Custom LIFO Stack implementation
│   │   └── VisitLinkedList.java     # Custom Singly Linked List implementation
│   └── Main.java                    # System CLI launcher and controller
└── README.md                        # Documentation
