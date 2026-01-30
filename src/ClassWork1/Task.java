package ClassWork1;

import java.util.ArrayList;
import java.util.List;

public class Task extends BaseTask{
    Status status = Status.NEW;
    private final List<SubTask> subTasks = new ArrayList<>();

    public Task(String title) {
        super(title);
    }

    public void addSubTask(SubTask sub) {
        subTasks.add(sub);
        updateStatus();
    }

    public boolean checkAndComplete() {
        if (subTasks.isEmpty()) {
            return false;
        }

        boolean allDone = subTasks.stream().allMatch(SubTask::isCompleted);

        if (allDone) {
            this.status = Status.DONE;
            return true;
        } else {
            this.status = Status.IN_PROGRESS;
            return false;
        }
    }

    private void updateStatus() {
        checkAndComplete();
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Задача: " + title + " | Статус: " + status + " | Подзадач: " + subTasks.size();
    }
}
