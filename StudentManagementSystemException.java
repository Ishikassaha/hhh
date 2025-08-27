
import java.util.Scanner; 
 
 class StudentNotFoundException extends Exception {
	 public StudentNotFoundException(String message) {
 super(message);
 }
}


interface StudentOperations { 
void addStudent(int roll, String name, int age); 
void viewStudents(); 
void searchStudent(int roll)throws StudentNotFoundException;
void deleteStudent(int roll)throws StudentNotFoundException;
} 

class Student { 
int roll; 
String name; 
int age; 
Student(int roll, String name, int age) { 
this.roll = roll; 
this.name = name; 
this.age = age; 
} 
} 
// Implementation class using Array 
class StudentManager implements StudentOperations { 
private Student[] students; 
    private int count; 
 
    StudentManager(int size) { 
        students = new Student[size]; 
        count = 0; 
    } 
 
    // Add student 
    public void addStudent(int roll, String name, int age) { 
        if (count < students.length) { 
            students[count] = new Student(roll, name, age); 
            count++; 
            System.out.println("   Student added successfully!"); 
        } else { 
            System.out.println("  Student list is full!"); 
        } 
    } 
 
    // View all students 
    public void viewStudents() { 
        if (count == 0) { 
            System.out.println("  No students available!"); 
            return; 
        } 
        System.out.println("\n--- Student Records ---"); 
        for (int i = 0; i < count; i++) { 
            System.out.println(students[i].roll + " | " + 
                               students[i].name + " | " + 
                               students[i].age); 
        } 
    } 
 
    // Search student by roll number 
    public void searchStudent(int roll) throws StudentNotFoundException { 
        for (int i = 0; i < count; i++) { 
            if (students[i].roll == roll) { 
                System.out.println("   Found: " + students[i].roll + " | " + 
                                   students[i].name + " | " + 
                                   students[i].age); 
                return; 
            } 
        } 
		throw new StudentNotFoundException("Student with ID " + roll + " not found!");
        
    } 
 
    // Delete student by roll number 
    public void deleteStudent(int roll)  throws StudentNotFoundException{ 
        for (int i = 0; i < count; i++) { 
            if (students[i].roll == roll) { 
                // Shift elements left 
                for (int j = i; j < count - 1; j++) { 
                    students[j] = students[j + 1]; 
                } 
                students[count - 1] = null; 
                count--; 
                System.out.println("   Student deleted successfully!"); 
                return; 
            } 
        }
        throw new StudentNotFoundException("Cannot delete. Student with ID " + roll + " not found!");		
        
    } 
} 
 
// Main class with menu 
public class StudentManagementSystemException { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        StudentManager manager = new StudentManager(10); 
 
        while (true) { 
            System.out.println("\n=== Student Management System ==="); 
            System.out.println("1. Add Student"); 
            System.out.println("2. View Students"); 
            System.out.println("3. Search Student"); 
            System.out.println("4. Delete Student"); 
            System.out.println("5. Exit"); 
            System.out.print("Enter choice: "); 
            int choice = sc.nextInt(); 
 
            switch (choice) { 
                case 1: 
                    System.out.print("Enter Roll No: "); 
                    int roll = sc.nextInt(); 
                    sc.nextLine(); // consume newline 
                    System.out.print("Enter Name: "); 
                    String name = sc.nextLine(); 
                    System.out.print("Enter Age: "); 
                    int age = sc.nextInt(); 
                    manager.addStudent(roll, name, age); 
                    break; 
                case 2: 
                    manager.viewStudents(); 
                    break; 
                case 3: 
                    System.out.print("Enter Roll No to Search: "); 
                    int sRoll = sc.nextInt(); 
					try{
                    manager.searchStudent(sRoll); 
					}
					 catch (StudentNotFoundException e) {
                         System.out.println(" Error: " + e.getMessage());
					 }
                    break; 
                case 4: 
                    System.out.print("Enter Roll No to Delete: "); 
                    int dRoll = sc.nextInt(); 
					try{
                    manager.deleteStudent(dRoll); 
					}
					catch (StudentNotFoundException e) {
                         System.out.println(" Error: " + e.getMessage());
					 }
                    break; 
                case 5: 
                    System.out.println("          Exiting Program. Goodbye!"); 
                    sc.close(); 
                    return; 
                default: 
                    System.out.println("  Invalid choice! Try again."); 
            } 
        } 
    } 
} 
 
   