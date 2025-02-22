
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package LopSinhVien;
import java.util.*;
class Student{
    String firstName, lastName, address, className, birthdate;
    double lapTrinh, quanLyDuAn, hocMay, CSDL, phatTrien;

    public Student(String firstName, String lastName, String birthdate, String address, String className,
                   double lapTrinh, double quanLyDuAn, double hocMay, double CSDL, double phatTrien) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.className = className;
        this.lapTrinh = lapTrinh;
        this.quanLyDuAn = quanLyDuAn;
        this.hocMay = hocMay;
        this.CSDL = CSDL;
        this.phatTrien = phatTrien;
    }

    public double getDTB() {
        return (lapTrinh + quanLyDuAn + hocMay + CSDL + phatTrien) / 5;
    }

    public String getRank() {
        double avg =  getDTB();
        if (avg >= 8.5) return "A";
        else if (avg >= 7) return "B";
        else if (avg >= 5.5) return "C";
        else if (avg >= 4) return "D";
        else return "<D";
    }
}
class ClassRoom {
    String classCode;
    List<Student> students;

    public ClassRoom(String classCode) {
        this.classCode = classCode;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void printRankSummary() {
        int countA = 0, countB = 0, countC = 0, countD = 0, countLessD = 0;
        for (Student s : students) {
            switch (s.getRank()) {
                case "A": countA++; break;
                case "B": countB++; break;
                case "C": countC++; break;
                case "D": countD++; break;
                default: countLessD++; break;
            }
        }
        System.out.println("Tổng kết số lượng sinh viên theo rank:");
        System.out.println("A: " + countA);
        System.out.println("B: " + countB);
        System.out.println("C: " + countC);
        System.out.println("D: " + countD);
        System.out.println("<D: " + countLessD);
    }
}
public class btap2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<ClassRoom> classRooms = new ArrayList<>();

        // Tạo lớp học mẫu
        ClassRoom class1 = new ClassRoom("CNTT1");
        class1.addStudent(new Student("Hang", "Nguyen", "2004-03-12", "Nghe An", "CNTT1", 9.0, 8.8, 8.5, 8.9, 9.1));
        class1.addStudent(new Student("Le", "Thanh", "2004-04-03", "Ninh Binh", "CNTT1", 7.5, 7.8, 8.2, 7.7, 7.9));
        class1.addStudent(new Student("Pham", "Linh", "2004-10-10", "Ha Noi", "CNTT1", 6.0, 5.8, 6.5, 6.2, 6.7));
        class1.addStudent(new Student("Nguyen", "Minh", "2004-01-13", "Ha Tinh", "CNTT1", 4.5, 4.8, 5.0, 4.7, 4.9));
        class1.addStudent(new Student("Do", "Khoa", "2004-05-06", "Ha Noi", "CNTT1", 3.5, 3.8, 3.9, 3.7, 3.6));
        classRooms.add(class1);

        //
        ClassRoom class2 = new ClassRoom("CNTT2");
        class2.addStudent(new Student("Hoang", "Lan", "2004-01-04", "Nghe An", "CNTT2", 8.8, 9.0, 8.7, 8.9, 9.2));
        class2.addStudent(new Student("Vu", "Hung", "2004-07-08", "Thai Binh", "CNTT2", 7.0, 7.5, 7.3, 7.4, 7.8));
        class2.addStudent(new Student("Bui", "Nga", "2004-02-18", "Phu Tho", "CNTT2", 6.2, 6.5, 6.0, 6.7, 6.9));
        class2.addStudent(new Student("Pham", "Tuan", "2004-08-27", "Ha Noi", "CNTT2", 5.0, 5.2, 4.9, 5.5, 5.7));
        class2.addStudent(new Student("Tran", "Duy", "2004-09-18", "Hai Duong", "CNTT2", 3.0, 3.5, 3.2, 3.8, 3.6));
        class2.addStudent(new Student("Chu", "Kien", "2004-07-25", "Ha Noi", "CNTT2", 8.0,8.8, 8.9, 8.5, 9.0));
        classRooms.add(class2);

        System.out.println("Danh sách lớp học:");
        for (ClassRoom c : classRooms) {
            System.out.println("- " + c.classCode);
        }

        System.out.print("Nhập mã lớp để xem chi tiết: ");
        String inputClassCode = scanner.nextLine();
        Optional<ClassRoom> selectedClass = classRooms.stream().filter(c -> c.classCode.equals(inputClassCode)).findFirst();

        if (selectedClass.isPresent()) {
            ClassRoom classRoom = selectedClass.get();
            System.out.println("Danh sách sinh viên lớp " + classRoom.classCode + ":");
            for (Student s : classRoom.students) {
                System.out.println(s.firstName + " " + s.lastName + " - Rank: " + s.getRank());
            }
            classRoom.printRankSummary();
        } else {
            System.out.println("Không tìm thấy lớp học!");
        }
    }
}
