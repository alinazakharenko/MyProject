package zakharenko.project.java.dao;

import zakharenko.project.java.beans.User;
import zakharenko.project.java.connection.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DaoUser extends AbstractDao implements InterfaceDAO<User> {

    @Override
    public User read(long id) throws SQLException {
        List<User> all = getAll("where id=" + id);
        if (all.size() > 0)
            return all.get(0);
        else
            return null;
    }

    @Override
    public boolean create(User user) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO " +
                        "`users`(`login`, `password`, `email`, `roles_id`) " +
                        "VALUES ('%s','%s','%s',%d)",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_id());
        long id = executeUpdate(sql);
        if (id > 0) {
            user.setId(id);
            return true;
        } else
            return false;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `users` " +
                        "SET `login`='%s', `password`='%s',`email`='%s'," +
                        "`roles_id`=%d WHERE id=%d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getRoles_id(), user.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = String.format(Locale.US,
                "DELETE FROM `users` WHERE id=%d",
                user.getId());
        return executeUpdate(sql) > 0;
    }

    @Override
    public List<User> getAll(String whereAndOrder) throws SQLException {
        List<User> users = new ArrayList<>();
        try (
                Connection connection = DbConnection.getConnection();
                Statement statement = connection.createStatement()
        ) {
            String sql = String.format(Locale.US, "" +
                            "SELECT `id`, `login`, `password`, `email`, `roles_id` FROM `users` %s",
                    whereAndOrder);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getLong("roles_id")
                );
                users.add(user);
            }
        }
        return users;
    }
}