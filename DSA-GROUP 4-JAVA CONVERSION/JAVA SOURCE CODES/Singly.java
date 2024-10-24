import java.util.Scanner;

class Node {
    String studno;
    String studname;
    String studcrsyr;
    float GWA;
    Node next;

    public Node(String studno, String studname, String studcrsyr, float GWA) {
        this.studno = studno;
        this.studname = studname;
        this.studcrsyr = studcrsyr;
        this.GWA = GWA;
        this.next = null;
    }
}

public class Singly {
    Node start;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Singly srm = new Singly();
        int choice;

        while (true) {
            srm.MainMenu();
            System.out.print("Enter your choice: ");
            choice = srm.scanner.nextInt();
            srm.scanner.nextLine();

            switch (choice) {
                case 1:
                    srm.CreateList();
                    break;
                case 2:
                    srm.DisplayList();
                    break;
                case 3:
                    srm.AddStart();
                    System.out.println("New record is added!");
                    break;
                case 4:
                    srm.AddEnd();
                    System.out.println("New record is added!");
                    break;
                case 5:
                    srm.AddBef();
                    System.out.println("New record is added!");
                    break;
                case 6:
                    srm.AddAft();
                    System.out.println("New record is added!");
                    break;
                case 7:
                    srm.DelStart();
                    System.out.println("Successfully deleted!");
                    break;
                case 8:
                    srm.DelEnd();
                    System.out.println("Successfully deleted!");
                    break;
                case 9:
                    srm.DelVal();
                    break;
                case 10:
                    srm.scanner.close();
                    return;
                default:
                    System.out.println("Invalid Choice!!!");
                    break;
            }
        }
    }

    void MainMenu() {
        System.out.println("\n---------------  MAIN MENU  ---------------");
        System.out.println(" [1] Create a Student Record");
        System.out.println(" [2] Display Student Record");
        System.out.println(" [3] Add a New Record at the Start");
        System.out.println(" [4] Add a New Record at the End");
        System.out.println(" [5] Add/Insert a New Record Before a Data");
        System.out.println(" [6] Add/Insert a New Record After a Data");
        System.out.println(" [7] Deletion of Node at the Start");
        System.out.println(" [8] Deletion of Node at the End");
        System.out.println(" [9] Deletion of Node by Value");
        System.out.println(" [10] Exit");
        System.out.println("-------------------------------------------\n");
    }

    void CreateList() {
        Node temp = null;
        char choice;

        do {
            System.out.println("\n------------------  CREATING A STUDENT RECORD  ------------------\n");
            System.out.print("Student Number: ");
            String studno = scanner.nextLine();
            System.out.print("Student Name: ");
            String studname = scanner.nextLine();
            System.out.print("Course and Year: ");
            String studcrsyr = scanner.nextLine();
            System.out.print("GWA: ");
            float GWA = scanner.nextFloat();
            scanner.nextLine();

            Node newNode = new Node(studno, studname, studcrsyr, GWA);

            if (start == null) {
                start = newNode;
            } else {
                temp.next = newNode;
            }

            temp = newNode;

            System.out.print("Add another record? [Y/N]: ");
            choice = scanner.nextLine().charAt(0);
        } while (Character.toUpperCase(choice) == 'Y');
    }

    void DisplayList() {
        Node current = start;
        int ctr = 1;

        System.out.println("\n--------------------------------------  STUDENT'S GWA REPORT  -------------------------------------------\n");

        if (current == null) {
            System.out.println("\nStudent Record is empty!");
        } else {
            System.out.printf("%-15s%-25s%-25s%-15s\n", "Student No.", "Student Name", "Course & Year", "GWA");

            while (current != null) {
                System.out.printf("%-15s%-25s%-25s%-15.2f\n", current.studno, current.studname, current.studcrsyr, current.GWA);
                current = current.next;
                ctr++;
            }
        }

        System.out.println("---------------------------------------------------------------------------------------------------------\n");
    }

    void AddStart() {
        System.out.println("\n-----------------  ADDING A NEW RECORD AT THE START  -----------------\n");
        System.out.print("Student Number: ");
        String studno = scanner.nextLine();
        System.out.print("Student Name: ");
        String studname = scanner.nextLine();
        System.out.print("Course & Year: ");
        String studcrsyr = scanner.nextLine();
        System.out.print("GWA: ");
        float GWA = scanner.nextFloat();
        scanner.nextLine();

        Node newNode = new Node(studno, studname, studcrsyr, GWA);
        newNode.next = start;
        start = newNode;
    }

    void AddEnd() {
        System.out.println("\n-----------------  ADDING A NEW RECORD AT THE END  -----------------\n");
        System.out.print("Student Number: ");
        String studno = scanner.nextLine();
        System.out.print("Student Name: ");
        String studname = scanner.nextLine();
        System.out.print("Course & Year: ");
        String studcrsyr = scanner.nextLine();
        System.out.print("GWA: ");
        float GWA = scanner.nextFloat();
        scanner.nextLine();

        Node newNode = new Node(studno, studname, studcrsyr, GWA);
        if (start == null) {
            start = newNode;
        } else {
            Node temp = start;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void AddBef() {
        System.out.println("\n-----------------  ADDING A NEW RECORD BEFORE A GIVEN STUDENT RECORD  -----------------\n");

        if (start == null) {
            System.out.println("Student Record is empty!");
            return;
        }

        System.out.print("Enter the Student Number before which you want to add the new record: ");
        String studentNoToFind = scanner.nextLine();

        Node current = start;
        Node prev = null;

        while (current != null && !current.studno.equals(studentNoToFind)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Error: The specified student record not found.");
            return;
        }

        System.out.println("\n-------------------------------  INSERT THE NEW RECORD  --------------------------------");
        System.out.print("Student Number: ");
        String studno = scanner.nextLine();
        System.out.print("Student Name: ");
        String studname = scanner.nextLine();
        System.out.print("Course and Year: ");
        String studcrsyr = scanner.nextLine();
        System.out.print("GWA: ");
        float GWA = scanner.nextFloat();
        scanner.nextLine();

        Node newRecord = new Node(studno, studname, studcrsyr, GWA);
        if (prev == null) {
            newRecord.next = start;
            start = newRecord;
        } else {
            newRecord.next = current;
            prev.next = newRecord;
        }

        System.out.println("New Student Record has been added before the specified Student Number.");
    }

    void AddAft() {
        System.out.println("\n-----------------  ADDING A NEW RECORD AFTER A GIVEN STUDENT RECORD  -----------------\n");

        if (start == null) {
            System.out.println("Student Record is empty!");
            return;
        }

        System.out.print("Enter the Student Number after which you want to add the new record: ");
        String studentNoToFind = scanner.nextLine();

        Node current = start;

        while (current != null && !current.studno.equals(studentNoToFind)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Error: The specified student record not found.");
            return;
        }

        System.out.println("\n-------------------------------  INSERT THE NEW RECORD  --------------------------------");
        System.out.print("Student Number: ");
        String studno = scanner.nextLine();
        System.out.print("Student Name: ");
        String studname = scanner.nextLine();
        System.out.print("Course and Year: ");
        String studcrsyr = scanner.nextLine();
        System.out.print("GWA: ");
        float GWA = scanner.nextFloat();
        scanner.nextLine();

        Node newRecord = new Node(studno, studname, studcrsyr, GWA);
        newRecord.next = current.next;
        current.next = newRecord;

        System.out.println("New Student Record has been added after the specified Student Number.");
    }

    void DelStart() {
        System.out.println("\n-----------------  DELETING THE FIRST RECORD  -----------------\n");

        if (start == null) {
            System.out.println("Student Record is empty!");
            return;
        }

        start = start.next;

        System.out.println("The first student record has been successfully deleted.");
    }

    void DelEnd() {
        System.out.println("\n-----------------  DELETING THE LAST RECORD  -----------------\n");

        if (start == null) {
            System.out.println("Student Record is empty!");
            return;
        }

        if (start.next == null) {
            start = null;
        } else {
            Node current = start;
            Node prev = null;
            while (current.next != null) {
                prev = current;
                current = current.next;
            }
            prev.next = null;
        }

        System.out.println("The last student record has been successfully deleted.");
    }

    void DelVal() {
        System.out.println("\n-----------------  DELETING A RECORD BY VALUE  -----------------\n");

        if (start == null) {
            System.out.println("Student Record is empty!");
            return;
        }

        System.out.print("Enter the Student Number of the record you want to delete: ");
        String studentNoToDelete = scanner.nextLine();

        Node current = start;
        Node prev = null;

        while (current != null && !current.studno.equals(studentNoToDelete)) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Error: The specified student record not found.");
            return;
        }

        if (prev == null) {
            start = start.next;
        } else {
            prev.next = current.next;
        }

        System.out.println("The student record has been successfully deleted.");
    }
}