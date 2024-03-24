package bg.tu_varna.sit.f21621588.web;

import bg.tu_varna.sit.f21621588.domain.Task;
import bg.tu_varna.sit.f21621588.domain.Tasks;
import bg.tu_varna.sit.f21621588.utilites.HttpWorker;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;

@WebServlet("/all")
public class ShowAllTasksServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Tasks task = getRepository().all();

            HttpWorker.writeBody(resp.getWriter(), task);
        } catch (JAXBException e) {
            resp.setStatus(400);
        }
    }
}