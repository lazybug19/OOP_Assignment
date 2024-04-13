import java.io.*;
import java.util.*;

// enum for Programme
enum Programme {
    CSIS, EEE, Mechanical, Chemical, Civil, Maths, Biology, Physics, Chemistry, Pharmacy, EcoFin, HSS
}

// student class : a student record
class Student {
    private int ID;
    private String Name;
    private Programme programme;
    private double CGPA;

    // constructor to assign initial values
    public Student(int ID, String Name, Programme programme, double CGPA) {
        this.ID = ID;
        this.Name = Name;
        this.programme = programme;
        this.CGPA = CGPA;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public Programme getProgramme() {
        return programme;
    }

    public double getCGPA() {
        return CGPA;
    }

    // display student record
    public String toString() {
        return ID + " " + Name + " " + programme + " " + String.format("%.2f", CGPA);
    }
}

// custom exception for handling duplicate IDs
class DuplicateIDException extends Exception {
    public DuplicateIDException(String message) {
        super(message);
    }
}

// custom exception for handling non-existent IDs
class NonExistentIDException extends Exception {
    public NonExistentIDException(String message) {
        super(message);
    }
}

// performing operations on Student records
class StudentRecordOps {
    // insert a new student record
    public static void insert(Student[] stud, Student new_stud) throws DuplicateIDException {
        int id = new_stud.getID();
        // checking for duplicate IDs
        for (Student student : stud) {
            if (student != null && student.getID() == id) {
                throw new DuplicateIDException("Duplicate ID " + id);
            }
        }
        // index for insertion
        int i = 0;
        while (i < stud.length && stud[i] != null && stud[i].getID() < id) {
            i++;
        }
        // shifting records to accommodate new record
        for (int j = stud.length - 1; j > i; j--) {
            stud[j] = stud[j - 1];
        }
        stud[i] = new_stud;
        System.out.println("Insert OK id: " + id);
    }

    // deleting a student record
    public static void delete(Student[] stud, int id) throws NonExistentIDException {
        boolean stud_found = false;
        for (int i = 0; i < stud.length; i++) {
            if (stud[i] != null && stud[i].getID() == id) {
                stud_found = true;
                System.out.println("Delete OK id: " + id);
                // shifting records after deletion
                for (int j = i; j < stud.length - 1; j++) {
                    stud[j] = stud[j + 1];
                }
                stud[stud.length - 1] = null;
                break;
            }
        }
        if (!stud_found) {
            throw new NonExistentIDException("Non-existent ID " + id);
        }
    }

    // displaying student record
    public static void display(Student[] stud, int id) throws NonExistentIDException {
        boolean stud_found = false;
        for (Student student : stud) {
            if (student != null && student.getID() == id) {
                stud_found = true;
                System.out.println(student.toString());
                break;
            }
        }
        if (!stud_found) {
            throw new NonExistentIDException("Non-existent ID " + id);
        }
    }

    // display stats
    public static void stats(Student[] stud) {
        int count = 0;
        double totalCGPA = 0;
        for (Student student : stud) {
            if (student != null) {
                count++;
                totalCGPA += student.getCGPA();
            }
        }
        double averageCGPA = (count == 0) ? 0 : totalCGPA / count;
        System.out.println("#records: " + count + "; avg CGPA: " + String.format("%.2f", averageCGPA));
    }

    // saving records to a file
    public static void save(Student[] stud, String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Student student : stud) {
                if (student != null) {
                    writer.println(student.getID() + " " + student.getName() + " " + student.getProgramme() + " "
                            + student.getCGPA());
                }
            }
            System.out.println("Save OK filename: " + filename);
        }
    }

    // dump records
    public static void dump(Student[] stud) throws NonExistentIDException {
        for (Student student : stud) {
            if (student != null) {
                System.out.println(student.toString());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Main <filename>");
            System.exit(1);
        }
        String filename = args[0];
        try (Scanner scanner = new Scanner(new File(filename))) {
            Student[] students = new Student[1000];
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String command = parts[0];
                switch (command) {
                    case "insert":
                        int id = Integer.parseInt(parts[1]);
                        String name = parts[2];
                        Programme programme = Programme.valueOf(parts[3]);
                        double cgpa = Double.parseDouble(parts[4]);
                        Student new_stud = new Student(id, name, programme, cgpa);
                        try {
                            StudentRecordOps.insert(students, new_stud);
                        } catch (DuplicateIDException e) {
                            System.out.println("Exception: " + e.getMessage());
                        }
                        break;
                    case "delete":
                        int delete_id = Integer.parseInt(parts[1]);
                        try {
                            StudentRecordOps.delete(students, delete_id);
                        } catch (NonExistentIDException e) {
                            System.out.println("Exception: " + e.getMessage());
                        }
                        break;
                    case "display":
                        int display_id = Integer.parseInt(parts[1]);
                        try {
                            StudentRecordOps.display(students, display_id);
                        } catch (NonExistentIDException e) {
                            System.out.println("Exception: " + e.getMessage());
                        }
                        break;
                    case "stats":
                        StudentRecordOps.stats(students);
                        break;
                    case "save":
                        String save_filename = parts[1];
                        try {
                            StudentRecordOps.save(students, save_filename);
                        } catch (IOException e) {
                            System.out.println("Exception: " + e.getMessage());
                        }
                        break;
                    case "dump":
                        try {
                            StudentRecordOps.dump(students);
                        } catch (NonExistentIDException e) {
                            System.out.println("Exception: " + e.getMessage());
                        }
                        break;
                    default:
                        if (!line.trim().isEmpty()) {
                            try {
                                throw new IllegalArgumentException("Unrecognized command: " + command);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Exception: " + e.getMessage());
                            }
                        }

                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}