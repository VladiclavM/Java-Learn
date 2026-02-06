package ClassWork1;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n");
    }
}
