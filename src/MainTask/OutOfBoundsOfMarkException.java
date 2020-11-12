package MainTask;

public class OutOfBoundsOfMarkException extends Exception{
    private int mark;

    public int getMark() {
        return mark;
    }

    public OutOfBoundsOfMarkException(String mess, int mark){
        super(mess);
        this.mark = mark;
    }
}
