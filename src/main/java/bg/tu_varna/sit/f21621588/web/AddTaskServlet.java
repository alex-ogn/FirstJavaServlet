package bg.tu_varna.sit.f21621588.web;

import bg.tu_varna.sit.f21621588.domain.Task;
import bg.tu_varna.sit.f21621588.models.ResponseBuilder;
import bg.tu_varna.sit.f21621588.models.ResponseMessage;
import bg.tu_varna.sit.f21621588.utilites.HttpWorker;
import bg.tu_varna.sit.f21621588.utilites.XmlWorker;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.JAXBException;
import org.xml.sax.SAXException;

import java.io.IOException;

@WebServlet("/add")
public class AddTaskServlet extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String body = HttpWorker.readBody(req.getReader());

            Task task = new XmlWorker<Task>().readerXML(body);

            getRepository().save(task);

            ResponseMessage message = new ResponseBuilder()
                    .setMessage(task.toString())
                    .build();

            HttpWorker.writeBody(resp.getWriter(), message);

        } catch (JAXBException | SAXException e) {
            resp.setStatus(500);
        }
    }
}
