package bg.tu_varna.sit.f21621588.domain;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@XmlRootElement(name = "tasks")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tasks {
    @XmlElement(name = "task")
    private Set<Task> tasks;

    public Tasks() {
    }

    public Tasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public boolean add(Task task) {
        return this.tasks.add(task);
    }

    public void update(Task value) {
        for (Task task : this.tasks) {
            if (task.equals(value)) {
                task = value;
                return;
            }
        }
    }
}