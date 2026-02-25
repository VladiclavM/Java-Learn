package ClassWork1;
import java.util.*;
public class TaskManager extends BaseTaskManager {

    @Override
    public void checkUniqueness(List<Task> tasks) {
        logAction("Запуск проверки уникальности...");
        Set<Task> uniqueTasks = new HashSet<>(tasks);
        if (tasks.size() == uniqueTasks.size()) {
            System.out.println("Все задачи уникальны.");
        } else {
            System.out.println("Найдены дубликаты!");
        }
    }

    @Override
    public void processTaskCompletion(Task task, boolean toArchive, List<Task> tasks) {
        logAction("Обработка завершения задачи: " + task.getTitle());

        task.getSubTasks().forEach(s -> s.setCompleted(true));
        task.checkAndComplete();

        if (toArchive) {
            Archive.addToArchive(task);
            if (tasks != null) tasks.remove(task);
            System.out.println("Задача в архиве.");
        }
    }
}
