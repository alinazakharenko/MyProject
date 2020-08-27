package zakharenko.project.java.controller;

import zakharenko.project.java.beans.Book;
import zakharenko.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdIndex extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        List<Book> books = Dao.getDao().book.getAll("");
        req.setAttribute("books", books);
        return null;
    }
}