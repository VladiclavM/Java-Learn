package ClassWork1;

public abstract class AbstractTask extends BaseTask{
    protected String priority;

    public AbstractTask(String title, String priority) {
        super(title);
        this.priority = priority;
    }

    public abstract void displayRole();

    public String getPriority() {
        return priority;
    }
}
