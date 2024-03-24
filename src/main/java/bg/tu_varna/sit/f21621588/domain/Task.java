package bg.tu_varna.sit.f21621588.domain;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.LocalDateTime;

@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class Task {

    private int id;
    private String header;
    private String content;
    private LocalDateTime dadeLine;

    public Task() {
    }

    public Task(int id, String header, String content, LocalDateTime dadeLine) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.dadeLine = dadeLine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDadeLine() {
        return dadeLine;
    }

    public void setDadeLine(LocalDateTime dadeLine) {
        this.dadeLine = dadeLine;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", content='" + content + '\'' +
                ", dadeLine=" + dadeLine +
                '}';
    }
}