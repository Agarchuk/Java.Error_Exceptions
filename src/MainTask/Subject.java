package MainTask;

public class Subject {
    private String nameOfSubject = "unknown";

    Subject(String nameOfSubject){
        this.nameOfSubject = nameOfSubject;
    }

    public String getNameOfSubject() {
        return nameOfSubject;
    }

    public void setNameOfSubject(String nameOfSubject) {
        this.nameOfSubject = nameOfSubject;
    }

    @Override
    public String toString() {
        return "Subject: "+ nameOfSubject;
    }
}
