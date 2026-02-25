package ClassWork1;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


class NewTask extends Task {
    public NewTask(String title) {
        super(title);
    }

    @Override
    public Status getStatus() {
        return Status.NEW;
    }
}


class UrgentTask extends Task {
    public UrgentTask(String title) {
        super(title);
    }

    @Override
    public Status getStatus() {
        return Status.IN_PROGRESS;
    }
}

public class Main {
    public static void main(String[] args) {
        //  Создаем участников
        Client client = new Client(1, "Заказчик Александр", 2000.0);
        Master master = new Master(2, "Мастер Владислав", 0.0);

        //  Создаем задачи
        Task myTask = new Task("Написать код");
        myTask.addSubTask(new SubTask("Отладить"));


        List<Task> taskList = new ArrayList<>();
        taskList.add(myTask);

        // Создаем менеджер задач (из шага 3)
        TaskManager manager = new TaskManager();

        System.out.println("--- Начало работы ---");
        // Проверяем уникальность через новый менеджер
        manager.checkUniqueness(taskList);

        // Имитируем выполнение и оплату
        double taskPrice = 1500.0;

        System.out.println("\n--- Процесс оплаты ---");
        // Вызываем проверку денег и перевод (то, что просил препод)
        client.payTo(master, taskPrice);

        // Завершаем задачу и отправляем в архив через менеджер
        System.out.println("\n--- Завершение задачи ---");
        manager.processTaskCompletion(myTask, true, taskList);

        //Проверяем итог
        System.out.println("\n--- Итоги дня ---");
        System.out.println("Баланс клиента: " + client.getBalance());
        System.out.println("Баланс мастера: " + master.getBalance());
        Archive.showArchive();
    }



}
//шаг у нас есть мастер и персон если от персон наследуется клиент поля: мастер имя айди мани
//у 1 мастера может быть много задач либо массив либо коллеккция в классе клиент передает инофрмацию