package hospital;

import java.util.Stack;

public class TreatmentStack {

    private Stack<TreatmentRecord> stack = new Stack<>();

    public void push(TreatmentRecord record) {

        stack.push(record);

        System.out.println(
                "Treatment record added successfully."
        );
    }


    public TreatmentRecord pop() {

        if (stack.isEmpty()) {

            System.out.println(
                    "Treatment stack is empty."
            );

            return null;
        }

        TreatmentRecord record = stack.pop();

        System.out.println(
                "Latest treatment record removed."
        );

        return record;
    }


    public void displayStack() {

        if (stack.isEmpty()) {

            System.out.println(
                    "Treatment stack is empty."
            );

            return;
        }

        System.out.println("\n================================");
        System.out.println(" TREATMENT HISTORY");
        System.out.println("================================");

        for (int i = stack.size() - 1; i >= 0; i--) {

            stack.get(i).displayTreatment();
        }
    }
}

