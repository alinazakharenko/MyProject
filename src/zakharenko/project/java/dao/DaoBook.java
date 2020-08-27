package zakharenko.project.java.dao;

import zakharenko.project.java.beans.Book;
import zakharenko.project.java.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoBook extends AbstractDao implements InterfaceDAO<Book> {

    @Override
    public Book read(long id) throws SQLException {
            return null;
    }

    @Override
    public boolean create(Book book) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO " +
                        "`books`(`name`, `material`, `parameter`, `client`, `number`, `date`, `users_id`) " +
                        "VALUES ('%s','%s','%s','%s',%d,%f,%d)",
                book.getName(), book.getMaterial(), book.getParameter(), book.getClient(), book.getNumber(), book.getDate(), book.getUsers_id());
        long id = executeUpdate(sql);
        if (id > 0) {
            book.setId(id);
            return true;
        } else
            return false;
    }

    @Override
    public boolean update(Book book) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `books` " +
                        "SET `name`='%s', `material`='%s', `parameter`='%s', `client`='%s', `number`='%d', `date`='%f'," +
                        "`users_id`=%d WHERE id=%d",
                book.getName(), book.getMaterial(), book.getParameter(), book.getClient(), book.getNumber(), book.getDate(), book.getUsers_id(), book.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(Book book) throws SQLException {
        String sql = String.format(Locale.US,
                "DELETE FROM `books` WHERE id=%d",
                book.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public List<Book> getAll(String whereAndOrder) throws SQLException {
        List<Book> books = new ArrayList<>();
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "" +
                            "SELECT `id`, `name`, `material`, `parameter`, `client`, `number`, `date`, `users_id` FROM `books` %s",
                    whereAndOrder);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("material"),
                        resultSet.getString("parameter"),
                        resultSet.getString("client"),
                        resultSet.getInt("number"),
                        resultSet.getDouble("date"),
                        resultSet.getLong("users_id")
                );
                books.add(book);
            }
        }
        return books;
    }
}