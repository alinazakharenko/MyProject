package zakharenko.project.java.controller;

import zakharenko.project.java.beans.Role;
import zakharenko.project.java.beans.User;
import zakharenko.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

class CmdEditUsers extends Cmd {
    @Override
    Action execute(HttpServletRequest req) throws SQLException {
        Dao dao = Dao.getDao();
        if (Util.isPost(req)) {
            Long id = Util.getLong(req, "id");
            String login = Util.getString(req, "login");
            String email = Util.getString(req, "email");
            String password = Util.getString(req, "password");
            Long rolesId = Util.getLong(req, "roles_id");
            User user = new User(id, login, password, email, rolesId);
            if (req.getParameter("Update") != null) {
                dao.user.update(user);
            } else if (req.getParameter("Delete") != null) {
                dao.user.delete(user);
            }
        }
        List<User> users = dao.user.getAll("");
        req.setAttribute("users", users);
        List<Role> roles = dao.role.getAll("");
        req.setAttribute("roles", roles);
        return null;
    }
}