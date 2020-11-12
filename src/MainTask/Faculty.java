package MainTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Faculty {
    private String nameOfFaculty = "unknown";
    private ArrayList<Group> groups = new ArrayList<>();
    private ArrayList<Subject> subjects = new ArrayList<>();

    public Faculty(String nameOfFaculty, ArrayList<Group> groups) throws GroupNullException, StudentNullException, OutOfBoundsOfMarkException {
        this.nameOfFaculty = nameOfFaculty;
        try {
            if(groups == null) throw  new GroupNullException("There is no group!");
            this.groups = groups;
        } catch (GroupNullException e){
            System.out.println(e.getMessage());
            this.groups.add(addGroup());
            groups = this.groups;
        } finally {
            for (Group group : groups) {
                for (Subject subject : group.getSubjects()) {
                    this.subjects.add(subject);
                }
            }
        }

    }

    public String getNameOfFaculty() {
        return nameOfFaculty;
    }

    public void setNameOfFaculty(String nameOfFaculty) {
        this.nameOfFaculty = nameOfFaculty;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public Double averageMarkBySubjectOnFaculty() throws OutOfBoundsOfMarkException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select subject: ");
        for (Subject subject: this.subjects){
            int index = this.subjects.indexOf(subject);
            System.out.println(index+1 +". "+subject);
        }
        System.out.print("Select: ");;
        int indexOfSelectedSubject = scanner.nextInt();
        Subject selectedSubject = subjects.get(indexOfSelectedSubject-1);

        double sum = 0;
        int size = 0;
        while (sum == 0){
            for (Group group: groups){
                for(Student student: group.getStudents()){
                    for (Subject subject: student.getSubjects()) {
                        if (selectedSubject.getNameOfSubject()==subject.getNameOfSubject()) {
                            try {
                                if (student.getMarks() == null) throw new NullMarksException("There is no mark");
                                sum += student.getMarks()[student.getSubjects().indexOf(subject)];
//                              sum += student.getMarks()[subjects.indexOf(subject)];
                                size++;
                            } catch (NullMarksException e) {
                                e.getMessage();
                                student.setMarks();
                            }

                        }
                    }
                }
            }

        }
        return sum/size;
    }

    public Group addGroup() throws StudentNullException, OutOfBoundsOfMarkException {
        System.out.println("Create group");
        System.out.print("Write name of group: ");
        Scanner scanner = new Scanner(System.in);
        String nameOfGroup = scanner.nextLine();
        ArrayList<Student> students = null;
        ArrayList<Subject> subjects = null;
        Group group = new Group(nameOfGroup, students, subjects);
        System.out.println(group);
        return group;
    }

    @Override
    public String toString() {
        return "Faculty: \n" +
                "nameOfFaculty: " + nameOfFaculty + '\n' +
                "groups: " + groups;
    }
}
