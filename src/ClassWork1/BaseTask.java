package ClassWork1;

import java.util.Objects;

public abstract class BaseTask{

    protected String title;

    public BaseTask(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseTask baseTask = (BaseTask) o;
        return Objects.equals(title, baseTask.title);
    }



    @Override
    public int hashCode() {
        return Objects.hash(title);
    }


//    @Override
//    public int compareTo(BaseTask other) {
//        return this.title.compareTo(other.title);
//    }

    @Override
    public abstract String toString();
}