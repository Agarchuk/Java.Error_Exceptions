package MainTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Group {
    private String numberOfGroup = "unknown";
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Subject> subjects = new ArrayList<>();

    public Group(String numberOfGroup, ArrayList<Student> students, ArrayList<Subject> subjects) throws OutOfBoundsOfMarkException, StudentNullException {
        this.numberOfGroup = numberOfGroup;
        try {
            if (students == null) throw new StudentNullException("There is no student!");
            this.students = students;
        } catch (StudentNullException e){
            System.out.println(e.getMessage());
            addStudent();
            students = this.students;
        }

        try {
            if(subjects == null) throw new SubjectNullException("There is no subject!");
            this.subjects = subjects;
        } catch (SubjectNullException e){
            System.out.println(e.getMessage());
            addSubject();
            subjects = this.subjects;
        }

        for (Student student: students){
            student.setGroup(numberOfGroup);
            student.setSubjects(subjects);
            student.setMarks();
        }
    }
    public Subject addSubject(){
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        Subject subject = null;
        do{
            System.out.println("Add subjects");
            System.out.print("Input name of subject: ");
            String namesOfSubject = scanner.next();
            subject = new Subject(namesOfSubject);
            this.subjects.add(subject);
            System.out.print("Do you want to add one more subject? \n Write 'y' if yes: ");
            answer = scanner.next();
        } while (answer.equals("y"));
        return subject;
    }



    public Student addStudent(){
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        Student student = null;
        do{
            System.out.println("Add student");
            System.out.print("Input name of student: ");
            String namesOfStudent = scanner.next();
            student = new Student(namesOfStudent);
            students.add(student);
            System.out.print("Do you want to add one more student? \n Write 'y' if yes: ");
            answer = scanner.next();
        } while (answer.equals("y"));
        return student;
    }

    public String getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(String numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public Double averageMarkBySubject() throws OutOfBoundsOfMarkException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select subject: ");
        for (Subject subject: subjects){
            int index = subjects.indexOf(subject);
            System.out.println(index+1 +". "+subject);
        }
        System.out.print("Select: ");;
        int indexOfSelectedSubject = scanner.nextInt();
        Subject selectedSubject = subjects.get(indexOfSelectedSubject-1);

        double sum = 0;
        while (sum == 0){
        for(Student student: students){
            for (Subject subject: student.getSubjects()) {
                if (selectedSubject.equals(subject)) {
                    try {
                        if (student.getMarks() == null) throw new NullMarksException("There is no mark");
                        sum += student.getMarks()[subjects.indexOf(subject)];
                    } catch (NullMarksException e) {
                        e.getMessage();
                        student.setMarks();
                    }

                }
            }
            }
        }
        return sum/students.size();
    }

    public static ArrayList<Student> addStudents(String[] namesOfStudents){
        ArrayList<Student> students = new ArrayList<>();
        for (String name: namesOfStudents){
            students.add(new Student(name));
        }
        return students;
    }

    @Override
    public String toString() {
        return "Group:\n" +
                "numberOfGroup:" + numberOfGroup + '\n' +
                "students: " + students + "\n"+
                "subjects: " + subjects + "\n";
    }
}
