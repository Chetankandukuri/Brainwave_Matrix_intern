import java.util.*;

class HospitalManagementSystem {
    
    static class Patient {
        String name;
        int id;
        String address;
        String phoneNumber;
        List<String> healthRecords';

        Patient(String name, int id, String address, String phoneNumber) {
            this.name = name;
            this.id = id;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.healthRecords = new ArrayList<>();
        }

        void addHealthRecord(String record) {
            healthRecords.add(record);
        }

        void displayHealthRecords() {
            System.out.println("Health Records for " + name);
            for (String record : healthRecords) {
                System.out.println(record);
            }
        }
    }

    static class Appointment {
        int patientId;
        Date date;
        String doctorName;

        Appointment(int patientId, Date date, String doctorName) {
            this.patientId = patientId;
            this.date = date;
            this.doctorName = doctorName;
        }
    }

    static class Billing {
        int patientId;
        double amount;

        Billing(int patientId, double amount) {
            this.patientId = patientId;
            this.amount = amount;
        }
    }

    static class InventoryItem {
        String itemName;
        int quantity;

        InventoryItem(String itemName, int quantity) {
            this.itemName = itemName;
            this.quantity = quantity;
        }
    }

    static class Staff {
        String name;
        int id;
        String position;

        Staff(String name, int id, String position) {
            this.name = name;
            this.id = id;
            this.position = position;
        }
    }

    static class Hospital {
        Map<Integer, Patient> patients = new HashMap<>();
        List<Appointment> appointments = new ArrayList<>();
        List<Billing> billings = new ArrayList<>();
        Map<String, InventoryItem> inventory = new HashMap<>();
        Map<Integer, Staff> staff = new HashMap<>();
        int patientIdCounter = 1;
        int staffIdCounter = 1;

        void registerPatient(String name, String address, String phoneNumber) {
            Patient patient = new Patient(name, patientIdCounter++, address, phoneNumber);
            patients.put(patient.id, patient);
            System.out.println("Patient registered: " + name + " with ID: " + patient.id);
        }

        void scheduleAppointment(int patientId, Date date, String doctorName) {
            if (patients.containsKey(patientId)) {
                appointments.add(new Appointment(patientId, date, doctorName));
                System.out.println("Appointment scheduled for patient ID: " + patientId);
            } else {
                System.out.println("Patient ID not found.");
            }
        }

        void addHealthRecord(int patientId, String record) {
            Patient patient = patients.get(patientId);
            if (patient != null) {
                patient.addHealthRecord(record);
                System.out.println("Health record added for patient ID: " + patientId);
            } else {
                System.out.println("Patient ID not found.");
            }
        }

        void generateBill(int patientId, double amount) {
            if (patients.containsKey(patientId)) {
                billings.add(new Billing(patientId, amount));
                System.out.println("Bill generated for patient ID: " + patientId + " Amount: " + amount);
            } else {
                System.out.println("Patient ID not found.");
            }
        }

        void addInventoryItem(String itemName, int quantity) {
            InventoryItem item = inventory.get(itemName);
            if (item != null) {
                item.quantity += quantity;
            } else {
                inventory.put(itemName, new InventoryItem(itemName, quantity));
            }
            System.out.println("Inventory updated: " + itemName + " Quantity: " + quantity);
        }

        void addStaff(String name, String position) {
            Staff staffMember = new Staff(name, staffIdCounter++, position);
            staff.put(staffMember.id, staffMember);
            System.out.println("Staff added: " + name + " with ID: " + staffMember.id);
        }
    }

    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        // Registering patients
        hospital.registerPatient("John Doe", "123 Street", "555-5555");
        hospital.registerPatient("Jane Smith", "456 Avenue", "555-6666");

        // Scheduling appointments
        hospital.scheduleAppointment(1, new Date(), "Dr. Brown");

        // Adding health records
        hospital.addHealthRecord(1, "Health Record 1 for John Doe");

        // Generating bills
        hospital.generateBill(1, 250.0);

        // Adding inventory items
        hospital.addInventoryItem("Bandages", 100);

        // Adding staff members
        hospital.addStaff("Alice Johnson", "Nurse");

        // Display health records
        hospital.patients.get(1).displayHealthRecords();
    }
}

