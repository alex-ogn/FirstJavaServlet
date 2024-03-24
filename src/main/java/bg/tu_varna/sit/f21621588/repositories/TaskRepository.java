package bg.tu_varna.sit.f21621588.repositories;

import bg.tu_varna.sit.f21621588.domain.Task;
import bg.tu_varna.sit.f21621588.domain.Tasks;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TaskRepository {

    private static TaskRepository instance;
    private Tasks tasks;

    private TaskRepository() {
        this.tasks = new Tasks(new HashSet<>());
    }
    public static TaskRepository getInstance() {
        if (instance == null) {
            instance = new TaskRepository();
        }
        return instance;
    }

    public boolean save(Task task) {
        return tasks.add(task);
    }

    public void update(Task task) {
        tasks.update(task);
    }

    public Tasks all() {
        return this.tasks;
    }

    public Task getById(Integer id) {
        return this.tasks.getTasks()
                .stream()
                .filter(t -> Objects.equals(id, t.getId()))
                .findFirst()
                .orElseGet(null);
    }
}