package ClassWork1;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ITaskProcessor {
    void checkUniqueness(List<Task> tasks);

    void processTaskCompletion(Task task, boolean toArchive, List<Task> tasks);
}
