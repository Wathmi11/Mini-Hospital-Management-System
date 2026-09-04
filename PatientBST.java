package hospital;

public class PatientBST {

    
    class Node {

        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {

            this.patient = patient;
            left = null;
            right = null;
        }
    }

    Node root;

    public void insert(Patient patient) {

        root = insertRecursive(root, patient);
    }

    private Node insertRecursive(Node root, Patient patient) {

        if (root == null) {

            return new Node(patient);
        }

        if (patient.patientId < root.patient.patientId) {

            root.left = insertRecursive(root.left, patient);

        }

        else if (patient.patientId > root.patient.patientId) {

            root.right = insertRecursive(root.right, patient);
        }

        return root;
    }


    public Patient search(int patientId) {

        Node current = root;

        while (current != null) {

            if (patientId == current.patient.patientId) {

                return current.patient;
            }

            if (patientId < current.patient.patientId) {

                current = current.left;

            }

            else {

                current = current.right;
            }
        }

        return null;
    }


    public void inOrder() {

        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node root) {

        if (root != null) {

           
            inOrderRecursive(root.left);

            root.patient.displayPatient();

            inOrderRecursive(root.right);
        }
    }


    public void delete(int patientId) {

        root = deleteRecursive(root, patientId);
    }

    private Node deleteRecursive(Node root, int patientId) {

        if (root == null) {

            return null;
        }

      
        if (patientId < root.patient.patientId) {

            root.left = deleteRecursive(
                    root.left,
                    patientId
            );
        }

      
        else if (patientId > root.patient.patientId) {

            root.right = deleteRecursive(
                    root.right,
                    patientId
            );
        }

        else {

            
            if (root.left == null) {

                return root.right;
            }

            
            if (root.right == null) {

                return root.left;
            }

            
            Node successor = findMinimum(root.right);

            root.patient = successor.patient;

            root.right = deleteRecursive(
                    root.right,
                    successor.patient.patientId
            );
        }

        return root;
    }


    
    private Node findMinimum(Node root) {

        while (root.left != null) {

            root = root.left;
        }

        return root;
    }
}