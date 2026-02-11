package ClassWork1;

import java.util.ArrayList;
import java.util.List;


public class Task extends BaseTask {

    private Status status = Status.NEW;
    private final List<SubTask> subTasks = new ArrayList<>();


    public Task(String title) {
        super(title);
    }

    public void addSubTask(SubTask sub) {
        subTasks.add(sub);
        checkAndComplete();
    }

    public boolean checkAndComplete() {
        if (subTasks.isEmpty()) {
            this.status = Status.NEW;
            return false;
        }

        boolean allDone = subTasks.stream().allMatch(SubTask::isCompleted);


        this.status = allDone ? Status.DONE : Status.IN_PROGRESS;

        return allDone;
    }

    public Status getStatus() {
        return status;
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    @Override
    public String toString() {
        return String.format("[TASK] %-15s | Статус: %-11s | Подзадач: %d",
                title, status, subTasks.size());
    }
}
