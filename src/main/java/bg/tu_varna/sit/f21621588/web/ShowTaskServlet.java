package bg.tu_varna.sit.f21621588.web;

import bg.tu_varna.sit.f21621588.domain.Task;
import bg.tu_varna.sit.f21621588.models.ResponseBuilder;
import bg.tu_varna.sit.f21621588.utilites.HttpWorker;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;

@WebServlet("/view")
public class ShowTaskServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Integer id = Integer.valueOf(req.getParameter("id"));

            Task task = getRepository().getById(id);

            HttpWorker.writeBody(resp.getWriter(), task);

        } catch (NumberFormatException e) {
            catchExeption(resp);
        } catch (JAXBException e) {
            resp.setStatus(404);
        }
    }

    private static void catchExeption(HttpServletResponse resp) throws IOException {
        resp.setStatus(400);
        try {
            HttpWorker.writeBody(resp.getWriter(), new ResponseBuilder()
                    .setMessage("Невалиден тип на параметъра id").build());
        } catch (JAXBException ex) {
            throw new RuntimeException(ex);
        }
    }
}