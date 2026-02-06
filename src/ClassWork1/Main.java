package ClassWork1;
import java.util.Arrays;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        Task myTask = new Task("Написать код");
        SubTask s1 = new SubTask("Создать классы");
        SubTask s2 = new SubTask("Проверить логику");

        myTask.addSubTask(s1);
        myTask.addSubTask(s2);

        System.out.println("--- Начальное состояние ---");

        System.out.println(myTask);

        s1.setCompleted(true);
        s2.setCompleted(true);


        if (myTask.checkAndComplete()) {
            System.out.println("\n--- После выполнения всех подзадач ---");
            System.out.println("Готово! " + myTask);
        }

        Task duplicateTask = new Task("Написать код");
        List<Task> taskList = Arrays.asList(myTask, duplicateTask, new Task("Другая задача"));

        System.out.println("\n--- Демонстрация уникальности ---");
        TaskUtils.checkUniqueness(taskList);


        System.out.println("\n--- Вывод в виде диаграммы ---");

        TaskUtils.printTaskTree(myTask);
    }
}


//добавить в классы ту стринг хэш код, пока создаем новый массив создаем новый метод для того что бы доказать что каждая задача уникальна (в нутри utils)
//c помошью комперебл интрефейс и ф формат выводить главную задачу а под ним под задачи ввиде диаграммы