package ClassWork1;

import java.util.ArrayList;
import java.util.List;

public class Archive {
    private static final List<Task> archivedTasks = new ArrayList<>();

    public static void addToArchive(Task task) {
        archivedTasks.add(task);
        System.out.println("[Архив] Задача '" + task.getTitle() + "' заархивирована.");
    }

    public static void showArchive() {
        System.out.println("--- СОДЕРЖИМОЕ АРХИВА ---");
        archivedTasks.forEach(System.out::println);
    }
}
