package zakharenko.project.java.controller;

import zakharenko.project.java.beans.Book;
import zakharenko.project.java.beans.User;
import zakharenko.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class CmdCreateBook extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        HttpSession session = req.getSession();
        Object oUser = session.getAttribute("user");
        if (oUser == null)
            return Action.LOGIN;
        User user = (User) oUser;
        if (Util.isPost(req)) {
            String name = Util.getString(req, "name");
            String material = Util.getString(req, "material");
            String parameter = Util.getString(req, "parameter");
            String client = Util.getString(req, "client");
            int number = Util.getInteger(req, "number");
            double date = Util.getDouble(req, "date");
            Book book = new Book(0,
                    name,
                    material, parameter,
                    client, number,
                    date,
                    user.getId());
            Dao.getDao().book.create(book);
            return Action.PROFILE;
        }
        return null;
    }
}