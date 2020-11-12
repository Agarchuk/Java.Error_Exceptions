package MainTask;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        В университете есть несколько факультетов, в которых учатся студенты, объединенные в группы. У каждого студента есть несколько учебных предметов по которым он получает оценки. Необходимо реализовать иерархию студентов, групп и факультетов.
//
//Посчитать средний балл по всем предметам студента
//Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
//Посчитать средний балл по предмету для всего университета
//Релизовать следующие исключения:
//
//Оценка ниже 0 или выше 10
//Отсутсвие предметов у студента (должен быть хотя бы один)
//Отсутствие студентов в группе
//Отсутствие групп на факультете
//Отсутствие факультетов в университете
        ArrayList<Subject> subjects = addSubjects(new String[]{"history", "art", "biology", "english"});
        ArrayList<Subject> subjects1 = addSubjects(new String[]{"art", "computer science", "economics"});

        ArrayList<Subject> subjects2 = addSubjects(new String[]{"art", "literature", "music"});
        ArrayList<Subject> subjects3 = addSubjects(new String[]{"history","philosophy", "geography"});

        ArrayList<Student> students = addStudents(new String[]{"Anna", "Marina"});
        ArrayList<Student> students1 =addStudents(new String[]{"Marina", "Viktor", "Max"});

        ArrayList<Student> students2 = addStudents(new String[]{"Olga", "Elena", "Alina"});
        ArrayList<Student> students3 = addStudents(new String[]{"Stepan", "Igor", "Alexey"});
        ArrayList<Student> students4 = addStudents(new String[]{"Anna", "Olga"});

//        Group group = new Group("0401", students, subjects);
//        Group group1 = new Group("0402", students1, subjects1);

//        Group group2 = new Group("0301", students2, subjects2);
//        Group group3 = new Group("0302", students3, subjects3);
//        Group group4 = new Group("0303", students4, subjects2);


//        List<Group> groupsofFea = new ArrayList<>();
//        groupsofFea.add(group);
//        groupsofFea.add(group1);

//        List<Group> groupsofFkti = new ArrayList<>();
//        groupsofFkti.add(group2);
//        groupsofFkti.add(group3);
//        groupsofFkti.add(group4);

//        Faculty fea = new Faculty("FEA", groupsofFea);
//        System.out.println(fea);
//        Faculty fkti = new Faculty("FKTI", groupsofFkti);
//        System.out.println(fkti);
//        students.get(0).setMarks();
//        System.out.println(Arrays.toString(students.get(0).getMarks()));
//        System.out.println(students.get(0).averageMark());
////        null
//        System.out.println(Arrays.toString(students.get(1).getMarks()));
//        System.out.println(students.get(1).averageMark());

        //Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
//        System.out.println(group.averageMarkBySubject());
//        System.out.println(group.getStudents());
//        System.out.println(group.getStudents());
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println(fea.averageMarkBySubjectOnFaculty());

        //проверка исключения на наличие предметов у студента
//        ArrayList<Subject> subjectsNull = null;
//        Group groupWithStudentWithoutSubject = new Group("0400", students1, subjectsNull);
//        List<Group> groupsofFea = new ArrayList<>();
//        groupsofFea.add(group);
//        groupsofFea.add(groupWithStudentWithoutSubject);
//        Faculty fea = new Faculty("FEA", groupsofFea);

        //----------------------------------------------------

        //проверка исключения на наличие студентов в группе
//        ArrayList<Student> studentsNull = null;
//        Group groupWithoutStudents = new Group("0400", studentsNull, subjects);
//        List<Group> groupsFea = new ArrayList<>();
//        groupsFea.add(groupWithoutStudents);
//        groupsFea.add(group);
//        Faculty fea = new Faculty(("FEA"), groupsFea);

        //----------------------------------------------------
        //проверка исключения на наличие групп на факультете
//        ArrayList<Group> groupsFea = null;
//        Faculty fea = new Faculty(("FEA"), groupsFea);
//        System.out.println(fea);
        //----------------------------------------------------

        //----------------------------------------------------
        //проверка исключения на наличие групп на факультете
        Faculty fea = null;
        try {
            if(fea == null) throw new FacultyNullException("There is no faculty");
            fea.averageMarkBySubjectOnFaculty();
        } catch (FacultyNullException e){
            System.out.println(e.getMessage());
            fea = addFaculty();
            System.out.println(fea.averageMarkBySubjectOnFaculty());
            System.out.println(fea);
        }
        //----------------------------------------------------
        
    }

    public static Faculty addFaculty() throws GroupNullException, OutOfBoundsOfMarkException, StudentNullException {
        System.out.println("Create faculty");
        System.out.print("Write name of faculty: ");
        Scanner scanner = new Scanner(System.in);
        String nameOfFaculty = scanner.nextLine();
        ArrayList<Group> group = null;
        Faculty faculty = new Faculty(nameOfFaculty, group);
        return faculty;
    }

    public static ArrayList<Student> addStudents(String[] namesOfStudents){
        ArrayList<Student> students = new ArrayList<>();
        for (String name: namesOfStudents){
            students.add(new Student(name));
        }
        return students;
    }

    public static ArrayList<Subject> addSubjects(String[] namesOfSubjects){
        ArrayList<Subject> subjects = new ArrayList<>();
        for (String name: namesOfSubjects){
            subjects.add(new Subject(name));
        }
        return subjects;
    }

    }

