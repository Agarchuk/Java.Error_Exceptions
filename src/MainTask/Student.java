package MainTask;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Student {
    private String name;
    private String group;
    private List<Subject> subjects;
    private Integer[] marks;

    Student(String name){
        this.name = name;
    }

    public void setGroup(String group){
        this.group = group;
    }

    public String getGroup(){
        return this.group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer[] getMarks() {
        return marks;
    }



    public void setMarks() throws OutOfBoundsOfMarkException {
        System.out.println("Input marks of subjects for student "+ this.name+ " from group "+this.group);
        Scanner scanner = new Scanner(System.in);
        this.marks = new Integer[subjects.size()];
        for (Subject subject: subjects){
            int index = subjects.indexOf(subject);
            System.out.print(subject+": ");
            int inputMark = scanner.nextInt();
            try{
                if (!(inputMark>=0 | inputMark<=10)) throw new OutOfBoundsOfMarkException("Mark must be from 0 to 10", inputMark);
                this.marks[index] = inputMark;
            } catch (OutOfBoundsOfMarkException e){
                System.out.println(e.getMessage());
                this.marks[index] = 0;
            }
        }
    }

//    public void setMark(Subject selectedSubject) throws OutOfBoundsOfMarkException{
//        System.out.println("Input mark of subject:");
//        Scanner scanner = new Scanner(System.in);
//        int index = subjects.indexOf(selectedSubject);
//            System.out.print(selectedSubject+": ");
//            int inputMark = scanner.nextInt();
//            try{
//                if (inputMark<0 |inputMark>10) throw new OutOfBoundsOfMarkException("Mark must be from 0 to 10", inputMark);
//                this.marks[index] = inputMark;
//            } catch (OutOfBoundsOfMarkException e){
//                System.out.println(e.getMessage());
//                this.marks[index] = 0;
//            }
//    }

    public Double averageMark() throws OutOfBoundsOfMarkException {
        double sum = 0;
        while (sum == 0) {
            try {
                if (this.marks == null) throw new NullMarksException("There are no marks");
                for (int i = 0; i < this.marks.length; i++) {
                    sum += this.marks[i];
                }
            } catch (NullMarksException e) {
                System.out.println(e.getMessage());
                setMarks();
            }
        }

        return sum/(this.marks.length);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        StringBuffer sb =  new StringBuffer("Student:\n" +
                "name: " + name + '\n' +
                "group:" + group + '\n' +
                "subjects: " + subjects + "\n"+
                "marks:\n ");
        for(Subject subject: subjects){
            int index = subjects.indexOf(subject);
            String st = subject.getNameOfSubject()+ ": " + marks[index] +"\n";
            sb.append(st);
        }
        return sb.toString();

    }
}
