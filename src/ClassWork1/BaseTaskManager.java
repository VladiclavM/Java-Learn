package ClassWork1;

import java.util.List;

public abstract class BaseTaskManager implements ITaskProcessor {

    // Общий метод для всех менеджеров (например, красивый заголовок в консоли)
    protected void logAction(String message) {
        System.out.println("[МЕНЕДЖЕР ЗАДАЧ]: " + message);
    }
}