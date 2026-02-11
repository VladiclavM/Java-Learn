package ClassWork1;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

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
        List<Task> taskList = new ArrayList<>(Arrays.asList(myTask, duplicateTask, new Task("Другая задача")));

        System.out.println("\n--- Демонстрация уникальности ---");
        TaskUtils.checkUniqueness(taskList);

        System.out.println("\n--- Вывод в виде диаграммы ---");

        System.out.println("=======================================================");

        Task anotherTask = new Task("Другая задача");

        TaskUtils.processTaskCompletion(myTask, true, taskList);

        // Сортировка списка задач по статусу с помощью компаратора
        taskList.sort(new TaskStatusComparator());

        // Пример работы переключателя
        TaskUtils.processTaskCompletion(myTask, true, taskList); // Улетит в архив
        TaskUtils.processTaskCompletion(anotherTask, false, taskList);


        //==============================================================
        TaskStatusComparator statusComparator = new TaskStatusComparator();


        taskList.sort(statusComparator);

        System.out.println("\n--- Задачи, отсортированные по статусу ---");
        taskList.forEach(System.out::println);

        Archive.showArchive();


    }
}


//комперебл интрефейс убираем (коментруем) добавляем вместо него делаем косператор с помошь функции компаре и сортировать задачи по статуту new, done, in progress
// в классе utils создать новый метод который уберает сделанную задачу в новый класс архив при этом сделать переключатель между переносом в архив и заменой статуса
