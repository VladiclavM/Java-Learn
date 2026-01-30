package ClassWork1;

public class SubTask extends BaseTask {
    private boolean isCompleted = false;

    public SubTask(String title) {
        super(title);
    }

    public void setCompleted(boolean completed) { isCompleted = completed; }
    public boolean isCompleted() { return isCompleted; }
}
