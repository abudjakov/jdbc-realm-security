package org.glassfish.web;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderb
 * Date: 9/16/13
 */

//For test purposes
public class TableListServlet extends HttpServlet {

    @Inject
    DBService dbService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.getLogger("").info("TableListServlet doGet");

        List<User> users = null;
        try {
            users = dbService.getUsersList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("users", users);

        req.getRequestDispatcher("/list/table.jsp").forward(req, resp);
    }
}
