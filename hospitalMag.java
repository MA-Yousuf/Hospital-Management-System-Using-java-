import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Patient {
    private int patientID;
    private String name;
    private int age;
    private String gender;
    private String disease;

    public Patient(int patientID, String name, int age, String gender, String disease) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
    }

    // Getters and setters

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}

class Hospital {
    private List<Patient> patients;

    public Hospital() {
        patients = new ArrayList<>();
    }

    // Add a new patient
    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient added successfully.");
    }

    // Search for a patient by ID
    public Patient searchPatient(int patientID) {
        for (Patient patient : patients) {
            if (patient.getPatientID() == patientID) {
                return patient;
            }
        }
        return null;
    }

    // Display all patients
    public void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("Patient List:");
            for (Patient patient : patients) {
                System.out.println("Patient ID: " + patient.getPatientID());
                System.out.println("Name: " + patient.getName());
                System.out.println("Age: " + patient.getAge());
                System.out.println("Gender: " + patient.getGender());
                System.out.println("Disease: " + patient.getDisease());
                System.out.println("--------------------");
            }
        }
    }
}

public class hospitalMag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital();

        while (true) {
            System.out.println("1. Add Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Display All Patients");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int patientID = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter Disease: ");
                    String disease = scanner.nextLine();

                    Patient patient = new Patient(patientID, name, age, gender, disease);
                    hospital.addPatient(patient);
                    break;
                case 2:
                    System.out.print("Enter Patient ID to search: ");
                    int searchID = scanner.nextInt();
                    Patient foundPatient = hospital.searchPatient(searchID);
                    if (foundPatient != null) {
                        System.out.println("Patient Found:");
                        System.out.println("Patient ID: " + foundPatient.getPatientID());
                        System.out.println("Name: " + foundPatient.getName());
                        System.out.println("Age: " + foundPatient.getAge());
                        System.out.println("Gender: " + foundPatient.getGender());
                        System.out.println("Disease: " + foundPatient.getDisease());
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;
                case 3:
                    hospital.displayPatients();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
