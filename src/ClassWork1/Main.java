package ClassWork1;

public class Main {
    public static void main(String[] args) {

        Task myTask = new Task("Написать код");
        SubTask s1 = new SubTask("Создать классы");
        SubTask s2 = new SubTask("Проверить логику");

        myTask.addSubTask(s1);
        myTask.addSubTask(s2);

        System.out.println(myTask);

        s1.setCompleted(true);
        s2.setCompleted(true);

        if (myTask.checkAndComplete()) {
            System.out.println("Готово! " + myTask);
        }


    }
}

//таск менеджер
//enum class 3 мода new, in progress, done
//автоматом new
//подзачади сделать map или мпссивом или еше как то
//подзачади, если не все под задачи не зделанны флаг "в прогрессе"
//функция для контроля выполнено (если все подзадчи сделаны возращают тру до объект done)
//соблюдать икапсуляцию наследование и по желанию абстрацию