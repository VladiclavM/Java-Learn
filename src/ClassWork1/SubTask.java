package ClassWork1;

public class SubTask extends BaseTask {
    private boolean isCompleted = false;

    public SubTask(String title) {
        super(title);
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public boolean isCompleted() {
        return isCompleted;
    }


    @Override
    public String toString() {
        String statusMarker = isCompleted ? "[X]" : "[ ]";
        return String.format("   └── %s %-15s (SubTask)", statusMarker, title);
    }
}