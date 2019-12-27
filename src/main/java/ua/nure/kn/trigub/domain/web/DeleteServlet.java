package ua.nure.kn.trigub.domain.web;

import ua.nure.kn.trigub.domain.User;
import ua.nure.kn.trigub.domain.db.DaoFactory;
import ua.nure.kn.trigub.domain.db.DatabaseException;

 import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

 public class DeleteServlet extends EditServlet {

     private static final long serialVersionUID = 1634909037211803672L;

     protected void doOk(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            DaoFactory.getInstance().getUserDao().delete((User) req.getSession().getAttribute("user"));
        } catch (DatabaseException e) {
            req.setAttribute("error", "Error in the database: " + e.getMessage());
            req.getRequestDispatcher("/delete.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("/browse").forward(req, resp);
    }

     protected void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/delete.jsp").forward(req, resp);

     }
}
