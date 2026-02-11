package ClassWork1;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Comparator;

public class TaskUtils {
    public static void checkUniqueness(List<Task> tasks) {
        Set<Task> uniqueTasks = new HashSet<>(tasks);
        System.out.println("--- Проверка уникальности ---");
        System.out.println("Всего в списке задач: " + tasks.size());
        System.out.println("Уникальных задач (по названию): " + uniqueTasks.size());

        if (tasks.size() == uniqueTasks.size()) {
            System.out.println("Результат: Все задачи уникальны.");
        } else {
            System.out.println("Результат: Найдены дубликаты.");
        }
        System.out.println("-----------------------------");
    }

    public static void printTaskTree(Task task) {
        System.out.println(task.toString());

        task.getSubTasks().stream()
                .sorted(Comparator.comparing(BaseTask::getTitle))
                .forEach(System.out::println);

        System.out.println("\n");
    }

    public static void processTaskCompletion(Task task, boolean toArchive, List<Task> tasks) {

        task.getSubTasks().forEach(s -> s.setCompleted(true));

        if (toArchive) {
            task.checkAndComplete();
            Archive.addToArchive(task);

            if (tasks != null) {
                tasks.remove(task);
            }
            System.out.println("[Инфо] Задача '" + task.getTitle() + "' перемещена в архив.");
        } else {
            task.checkAndComplete();
            System.out.println("[Инфо] Статус задачи '" + task.getTitle() + "' обновлен на DONE.");
        }
    }
}
