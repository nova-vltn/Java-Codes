import java.util.Scanner;
class STUDREC {
    String studname;
    String studno;
    String studcrsyr;
    float GWA;
    STUDREC next;
    STUDREC prev;
}

public class Doubly {
    private static STUDREC HEAD = null;
    private static STUDREC TAIL = null;
    private static final Scanner scanner = new Scanner(System.in);

    private static final String rs = "\033[0m";
    private static final String red = "\033[0;31m";
    private static final String green = "\033[0;32m";
    private static final String yellow = "\033[0;33m";
    private static final String blue = "\033[0;34m";
    private static final String purp = "\033[0;35m";
    private static final String cyan = "\033[0;36m";

    public static void main(String[] args) {
        int choice;
        while (true) {
            MainMenu();
            System.out.print(purp + "Enter your choice: " + rs);
            choice = scanner.nextInt();
            System.out.println(purp + "\n--------------------------------------------------------------\n" + rs);
            scanner.nextLine();

            switch (choice) {
                case 1:
                    CreateDLL();
                    break;
                case 2:
                    TravHead();
                    System.out.println(green + "\n---------------------------------------------------------------------------------------------------------\n" + rs);
                    System.out.println(green + "Press Enter to return to main menu..." + rs);
                    System.out.println(green + "\n---------------------------------------------------------------------------------------------------------\n" + rs);
                    scanner.nextLine();
                    break;
                case 3:
                    TravTail();
                    System.out.println(green + "\n---------------------------------------------------------------------------------------------------------\n" + rs);
                    System.out.println(green + "Press Enter to return to main menu..." + rs);
                    System.out.println(green + "\n---------------------------------------------------------------------------------------------------------\n" + rs);
                    scanner.nextLine();
                    break;
                case 4:
                    AddHead();
                    break;
                case 5:
                    AddTail();
                    break;
                case 6:
                    AddBef();
                    break;
                case 7:
                    AddAft();
                    break;
                case 8:
                    DelHead();
                    break;
                case 9:
                    DelTail();
                    break;
                case 10:
                    DelVal();
                    break;
                case 11:
                    DelBef();
                    break;
                case 12:
                    DelAft();
                    break;
                case 13:
                    System.exit(0);
                default:
                    System.out.println(red + "Invalid Choice!"+ rs);
                    scanner.nextLine();
                    break;
            }
        }
    }

    public static void MainMenu() {
        System.out.println(purp + "\n------------------------  MAIN MENU  -------------------------\n" + rs);
        System.out.println(yellow + " [1] Create a Student Record"+ rs);
        System.out.println(yellow +" [2] Traverse Student Record (HEAD - from top to bottom)"+ rs);
        System.out.println(yellow + " [3] Traverse Student Record (TAIL - from bottom to top)" + rs);
        System.out.println(blue + " [4] Adding/Insertion of Node in Student Record (at the head)" + rs);
        System.out.println(blue + " [5] Adding/Insertion of Node in Student Record (at the tail)" + rs);
        System.out.println(blue + " [6] Adding/Insertion of Node in Student Record (Before a Value)" + rs);
        System.out.println(blue + " [7] Adding/Insertion of Node in Student Record (After a Value)"+ rs);
        System.out.println(red + " [8] Deletion of Node at the Head" + rs);
        System.out.println(red + " [9] Deletion of Node at the Tail" + rs );
        System.out.println(red + " [10] Deletion of Node by Value" + rs);
        System.out.println(red + " [11] Deletion of Node Before a Node" + rs);
        System.out.println(red + " [12] Deletion of Node After a Node" + rs);
        System.out.println(cyan + " [13] Exit" + rs);
        System.out.println(purp + "\n--------------------------------------------------------------\n" + rs);
    }

    public static void CreateDLL() {
        STUDREC NewNode;
        char Resp;
        int ctr = 1;
        NewNode = new STUDREC();
        HEAD = NewNode;
        TAIL = NewNode;
        HEAD.prev = null;
        System.out.println(yellow + "\n------------------  CREATING A STUDENT RECORD  ------------------\n" + rs);
        do {
            System.out.print(cyan + "Student #" + ctr + " Number\t\t: " + rs);
            NewNode.studno = scanner.nextLine();

            System.out.print(cyan + "Student #" + ctr + " Name\t\t\t: " + rs);
            NewNode.studname = scanner.nextLine();

            System.out.print(cyan + "Course and Year\t\t\t: " + rs);
            NewNode.studcrsyr = scanner.nextLine();

            System.out.print(cyan + "GWA\t\t\t\t\t\t: " + rs);
            NewNode.GWA = scanner.nextFloat();
            scanner.nextLine();

            System.out.println(purp + "\n------------------------------------------------------------------\n" + rs);
            System.out.print(purp + "Add another record? [Y/N]: " + rs);
            Resp = scanner.nextLine().toUpperCase().charAt(0);
            System.out.println(purp + "\n------------------------------------------------------------------\n" + rs);

            if (Resp == 'Y') {
                ctr++;
                NewNode.next = new STUDREC();
                NewNode.next.prev = NewNode;
                NewNode = NewNode.next;
                TAIL = NewNode;
            }
        } while (Resp == 'Y');
        TAIL.next = null;
        NewNode = null;
    }

    public static void TravHead() {
        STUDREC TravNode;
        int ctr = 1;
        TravNode = HEAD;
        System.out.println(yellow + "\n------------------------------- STUDENT RECORD (HEAD - from top to bottom) ------------------------------\n" + rs);
        if (TravNode == null) {
            System.out.printf(red + "%37s Student Record is empty!\n" + rs,"");
        } else {
            System.out.printf(blue + "%-10s%-30s%-30s%-30s%-30s\n" + rs, "No.", "Student No.", "Student Name", "Course & Year", "GWA");
            while (TravNode != null) {
                System.out.printf(red + "%-10d%-30s%-30s%-30s%.2f\n\n" + rs, ctr, TravNode.studno, TravNode.studname, TravNode.studcrsyr, TravNode.GWA);
                TravNode = TravNode.next;
                ctr++;
            }
        }
        System.out.println(yellow + "\n-----------------------------------------------------------------------------------------------------------\n" + rs);
    }

    public static void TravTail() {
        STUDREC TravNode;
        int ctr = 1;
        TravNode = TAIL;
        System.out.println(yellow + "\n------------------------------- STUDENT RECORD (TAIL - from bottom to top) ------------------------------\n" + rs);
        if (TravNode == null) {
            System.out.printf(red + "%37s Student Record is empty!\n" + rs, "");
        } else {
            System.out.printf(blue + "%-10s%-30s%-30s%-30s%-30s\n" + rs, "No.", "Student No.", "Student Name", "Course & Year", "GWA");
            while (TravNode != null) {
                System.out.printf(red + "%-10d%-30s%-30s%-30s%.2f\n\n" + rs, ctr, TravNode.studno, TravNode.studname, TravNode.studcrsyr, TravNode.GWA);
                TravNode = TravNode.prev;
                ctr++;
            }
        }
        System.out.println(yellow + "\n-----------------------------------------------------------------------------------------------------------\n" + rs);
    }

    public static void AddHead() {
        STUDREC NewRec = new STUDREC();
        System.out.println(blue + "\n---------------  ADD RECORD AT THE HEAD  ---------------\n" + rs);
        if (HEAD == null) {
            System.out.printf(red + "%15s Student Record is empty!\n" + rs,"");
            System.out.println(blue + "\n--------------------------------------------------------\n" + rs);
            System.out.println(green + "Press Enter to return to main menu..." + rs);
            System.out.println(green + "\n-------------------------------------------------------\n\n" + rs);
            scanner.nextLine();
            return;
        }
        System.out.print(cyan + "Student Number\t\t: " + rs);
        NewRec.studno = scanner.nextLine();

        System.out.print(cyan + "\nStudent Name\t\t: " + rs);
        NewRec.studname = scanner.nextLine();

        System.out.print(cyan + "\nCourse & Year\t\t: " + rs);
        NewRec.studcrsyr = scanner.nextLine();

        System.out.print(cyan + "\nGWA\t\t\t\t\t: " + rs);
        NewRec.GWA = scanner.nextFloat();
        scanner.nextLine();

        NewRec.prev = null;
        NewRec.next = null;
        if (HEAD == null) {
            HEAD = TAIL = NewRec;
        } else {
            NewRec.next = HEAD;
            HEAD.prev = NewRec;
            HEAD = NewRec;
        }
        NewRec = null;
        System.out.println(yellow + "\n-------------------------------------------------------\n" + rs);
        System.out.println(yellow + "Record successfully added at the head!");
        System.out.println(yellow + "\n-------------------------------------------------------\n"+ rs);
        System.out.println(green + "\n--------------------------------------------------------\n" + rs);
        System.out.println(green + "Press Enter to return to main menu...");
        System.out.println(green + "\n-------------------------------------------------------\n"+ rs);
        scanner.nextLine();
    }

    public static void AddTail() {
        STUDREC NewRec = new STUDREC();
        System.out.println(blue + "\n---------------  ADD RECORD AT THE END  ---------------\n" + rs);
        if (HEAD == null) {
            System.out.printf(red + "%15s Student Record is empty!\n" + rs,"");
            System.out.println(blue + "\n--------------------------------------------------------\n" + rs);
            System.out.println(green + "Press Enter to return to main menu..." + rs);
            System.out.println(green + "\n-------------------------------------------------------\n\n" + rs);
            scanner.nextLine();
            return;
        }
        System.out.print(cyan + "Student Number\t\t: " + rs);
        NewRec.studno = scanner.nextLine();

        System.out.print(cyan + "\nStudent Name\t\t: " + rs);
        NewRec.studname = scanner.nextLine();

        System.out.print(cyan + "\nCourse & Year\t\t: " + rs);
        NewRec.studcrsyr = scanner.nextLine();

        System.out.print(cyan + "\nGWA\t\t\t\t\t: " + rs);
        NewRec.GWA = scanner.nextFloat();
        scanner.nextLine();

        NewRec.prev = null;
        NewRec.next = null;
        if (TAIL == null) {
            HEAD = TAIL = NewRec;
        } else {
            NewRec.prev = TAIL;
            TAIL.next = NewRec;
            TAIL = NewRec;
        }
        NewRec = null;
        System.out.println(yellow + "\n-------------------------------------------------------\n" + rs);
        System.out.println(yellow + "Record successfully added at the tail!" + rs);
        System.out.println(yellow + "\n-------------------------------------------------------\n" + rs);
        System.out.println(green + "\n--------------------------------------------------------\n" + rs);
        System.out.println(green + "Press Enter to return to main menu..." + rs);
        System.out.println(green + "\n--------------------------------------------------------\n\n" + rs);
        scanner.nextLine();
    }

    public static void AddBef(){
        STUDREC NewRec= new STUDREC();
        STUDREC Current=HEAD;
        int Flag=0;
        System.out.println(blue + "\n-----------------------------  ADD RECORD BEFORE A VALUE  ------------------------------\n" + rs);
        if(Current==null) {
            System.out.printf(red + "%30sStudent Record is empty!\n" + rs,"");
            System.out.println(blue + "\n----------------------------------------------------------------------------------------\n" + rs);
            System.out.println(green + "\n----------------------------------------------------------------------------------------\n" + rs);
            System.out.println(green +"Press any key to return to main menu..." + rs);
            System.out.println(green + "\n----------------------------------------------------------------------------------------\n\n" + rs);
            scanner.nextLine();
            return;
        }
        System.out.print(yellow + "Enter the Student Number before which you want to add the new record: " + rs);
        String find = scanner.nextLine();

        while(Flag==0 && Current!=null) {
            if(Current.studno.equals(find)) {
                Flag=1;
            } else{
                Current=Current.next;
            }
        }
        if(Flag==0) {
            System.out.println(red + "The Value where the NewNode will be inserted before does not exist." + rs);
            System.out.println(green + "\n--------------------------------------------------------\n" + rs);
            System.out.println(green + "Press Enter to return to main menu..." + rs);
            System.out.println(green + "\n--------------------------------------------------------\n\n" + rs);
            return;
        }
        System.out.println(blue + "\n---------------------------  INSERT RECORD BEFORE A VALUE  -----------------------------\n" + rs);
        System.out.print(cyan + "Student Number\t\t: " + rs);
        NewRec.studno = scanner.nextLine();

        System.out.print(cyan + "\nStudent Name\t\t: " + rs);
        NewRec.studname = scanner.nextLine();

        System.out.print(cyan + "\nCourse & Year\t\t: " + rs);
        NewRec.studcrsyr = scanner.nextLine();

        System.out.print(cyan + "\nGWA\t\t\t\t\t: " + rs);
        NewRec.GWA = scanner.nextFloat();
        scanner.nextLine();
        System.out.println(blue + "\n----------------------------------------------------------------------------------------" + rs);

        NewRec.prev=null;
        NewRec.next=null;
        if(Current==HEAD){
            NewRec.next=HEAD;
            HEAD.prev=NewRec;
            HEAD=NewRec;
        } else{
            NewRec.next=Current;
            NewRec.prev=Current.prev;
            Current.prev.next=NewRec;
            Current.prev=NewRec;
        }
        Current=NewRec=null;
        System.out.println(yellow + "\n----------------------------------------------------------------------------------------\n" + rs);
        System.out.println(yellow + "Record successfully added before the specified value!" + rs);
        System.out.println(yellow + "\n----------------------------------------------------------------------------------------\n" + rs);
        System.out.println(green + "----------------------------------------------------------------------------------------\n" + rs);
        System.out.println(green + "Press Enter to return to main menu..." + rs);
        System.out.println(green + "\n----------------------------------------------------------------------------------------\n\n" + rs);
        scanner.nextLine();
    }
    public static void AddAft(){
        STUDREC NewRec= new STUDREC();
        STUDREC Current=HEAD;
        int Flag=0;
        System.out.println(blue + "\n-----------------------------  ADD RECORD AFTER A VALUE  ------------------------------\n" + rs);
        if(Current==null) {
            System.out.printf(red + "%30sStudent Record is empty!\n" + rs,"");
            System.out.println(blue + "\n----------------------------------------------------------------------------------------\n" + rs);
            System.out.println(green + "----------------------------------------------------------------------------------------\n" + rs);
            System.out.println(green +"Press any key to return to main menu..." + rs);
            System.out.println(green + "\n----------------------------------------------------------------------------------------\n\n" + rs);
            scanner.nextLine();
            return;
        }
        System.out.print(yellow + "Enter the Student Number before which you want to add the new record: " + rs);
        String find = scanner.nextLine();

        while(Flag==0 && Current!=null) {
            if(Current.studno.equals(find)) {
                Flag=1;
            } else{
                Current=Current.next;
            }
        }
        if(Flag==0) {
            System.out.println(red + "The Value where the NewNode will be inserted before does not exist." + rs);
            System.out.println(green + "\n--------------------------------------------------------\n" + rs);
            System.out.println(green + "Press Enter to return to main menu..." + rs);
            System.out.println(green + "\n--------------------------------------------------------\n\n" + rs);
            return;
        }
        System.out.println("\n---------------------------  INSERT RECORD AFTER A VALUE  -----------------------------\n");
        System.out.print(cyan + "Student Number\t\t: " + rs);
        NewRec.studno = scanner.nextLine();

        System.out.print(cyan + "\nStudent Name\t\t: " + rs);
        NewRec.studname = scanner.nextLine();

        System.out.print(cyan + "\nCourse & Year\t\t: " + rs);
        NewRec.studcrsyr = scanner.nextLine();

        System.out.print(cyan + "\nGWA\t\t\t\t\t: " + rs);
        NewRec.GWA = scanner.nextFloat();
        scanner.nextLine();
        System.out.println(blue + "\n----------------------------------------------------------------------------------------" + rs);
        NewRec.prev = Current;
        NewRec.next = Current.next;

        if (Current.next != null) {
            Current.next.prev = NewRec;
        } else {
            TAIL = NewRec;
        }
        Current.next = NewRec;
        System.out.println(yellow + "\n----------------------------------------------------------------------------------------\n" + rs);
        System.out.println(yellow + "Record successfully added after the specified value!" + rs);
        System.out.println(yellow + "\n----------------------------------------------------------------------------------------\n" + rs);
        System.out.println(green + "\n----------------------------------------------------------------------------------------\n" + rs);
        System.out.println(green + "Press Enter to return to main menu..." + rs);
        System.out.println(green + "\n----------------------------------------------------------------------------------------\n\n" + rs);
        scanner.nextLine();
    }

    public static void DelHead() {
        STUDREC DelNode;
        DelNode = HEAD;
        if (DelNode == null) {
            System.out.println(purp + "--------------------------------------------------------------" + rs);
            System.out.println(purp + "Student Record is empty!"+ rs);
            System.out.println(purp + "--------------------------------------------------------------" + rs);
            System.out.println(green + "--------------------------------------------------------------" + rs);
            System.out.println(green + "Press Enter to return to main menu..." + rs);
            System.out.println(green + "--------------------------------------------------------------" + rs);
            scanner.nextLine();
            return;
        }

        if (DelNode.next == null) {
            HEAD = TAIL = null;
        } else {
            HEAD = HEAD.next;
            HEAD.prev = null;
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println(red + "Node at the head deleted successfully!" + rs);
        System.out.println("--------------------------------------------------------------");
        System.out.println(green + "--------------------------------------------------------------" + rs);
        System.out.println(green + "Press Enter to return to main menu..." + rs);
        System.out.println(green + "--------------------------------------------------------------" + rs);
        scanner.nextLine();
    }

    public static void DelTail() {
        STUDREC DelNode;
        DelNode = TAIL;
        if (DelNode == null) {
            System.out.println(purp + "--------------------------------------------------------------" + rs);
            System.out.println(purp + "Student Record is empty!"+ rs);
            System.out.println(purp + "--------------------------------------------------------------" + rs);
            System.out.println(green + "--------------------------------------------------------------" + rs);
            System.out.println(green + "Press Enter to return to main menu..." + rs);
            System.out.println(green + "--------------------------------------------------------------" + rs);
            scanner.nextLine();
            return;
        }

        if (DelNode.prev == null) {
            HEAD = TAIL = null;
        } else {
            TAIL = TAIL.prev;
            TAIL.next = null;
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println(red + "Node at the tail deleted successfully!" + rs);
        System.out.println(green + "--------------------------------------------------------------" + rs);
        System.out.println(green + "Press Enter to return to main menu..." + rs);
        System.out.println(green + "--------------------------------------------------------------" + rs);
        scanner.nextLine();
    }

    public static void DelVal(){
        if (HEAD == null) {
            System.out.println(red + "Student Record is empty!" + rs);
            return;
        }

        System.out.print(red + "Enter Student No. to delete: " + rs);
        String value = scanner.nextLine();

        STUDREC current = HEAD;
        while (current != null && !current.studno.equals(value)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println(red + "Student No. " + value + " not found!" + rs);
            return;
        }

        if (current == HEAD) {
            HEAD = current.next;
            if (HEAD != null) {
                HEAD.prev = null;
            } else {
                TAIL = null;
            }
        } else if (current == TAIL) {
            TAIL = current.prev;
            if (TAIL != null) {
                TAIL.next = null;
            } else {
                HEAD = null;
            }
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        System.out.println(red + "Record before the given value has been deleted successfully!" + rs);
    }

    public static void DelBef(){
        if (HEAD == null) {
            System.out.println(red + "Student Record is empty!" + rs);
            return;
        }

        System.out.print(red + "Enter Student No. before which you want to delete: " + rs);
        String value = scanner.nextLine();

        STUDREC current = HEAD;
        while (current != null && !current.studno.equals(value)) {
            current = current.next;
        }

        if (current == null || current == HEAD) {
            System.out.println(yellow + "No record found before the given value!" + rs);
            return;
        }

        STUDREC toDelete = current.prev;
        if (toDelete == HEAD) {
            HEAD = current;
            HEAD.prev = null;
        } else {
            toDelete.prev.next = current;
            current.prev = toDelete.prev;
        }
        System.out.println(red + "Record before the given value has been deleted successfully!" + rs);
    }

    public static void DelAft(){
        if (HEAD == null) {
            System.out.println(red + "Student Record is empty!"  + rs);
            return;
        }

        System.out.print(red + "Enter Student No. after which you want to delete: "  + rs);
        String value = scanner.nextLine();

        STUDREC current = HEAD;
        while (current != null && !current.studno.equals(value)) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println(blue + "No record found after the given value!" + rs);
            return;
        }

        STUDREC toDelete = current.next;
        if (toDelete == TAIL) {
            TAIL = current;
            TAIL.next = null;
        } else {
            current.next = toDelete.next;
            toDelete.next.prev = current;
        }
        System.out.println(red + "Record after the given value has been deleted successfully!" + rs);
    }
}