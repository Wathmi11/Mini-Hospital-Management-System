package hospital;

import java.util.LinkedList;

public class EmergencyQueue {

    private LinkedList<Patient> queue = new LinkedList<>();

    public void enqueue(Patient patient) {

        queue.addLast(patient);

        System.out.println(
                "Patient " + patient.patientId +
                " added to emergency queue."
        );
    }


    public Patient dequeue() {

        if (queue.isEmpty()) {

            System.out.println("Emergency queue is empty.");

            return null;
        }

        Patient patient = queue.removeFirst();

        System.out.println(
                "Patient " + patient.patientId +
                " removed from emergency queue."
        );

        return patient;
    }

    public void displayQueue() {

        if (queue.isEmpty()) {

            System.out.println("Emergency queue is empty.");

            return;
        }

        System.out.println("\n================================");
        System.out.println(" EMERGENCY WAITING QUEUE");
        System.out.println("================================");

        for (Patient patient : queue) {

            System.out.println(
                    "Patient ID: " + patient.patientId +
                    " | Name: " + patient.name
            );
        }
    }
}
