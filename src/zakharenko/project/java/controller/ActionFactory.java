package zakharenko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class ActionFactory {
    Action defineAction(HttpServletRequest req) {
        String command = req.getParameter("command");
        System.out.println("command=" + command);
        if (command != null && !command.isEmpty())
            return Action.valueOf(command.toUpperCase());
        else
            return Action.INDEX;
    }
}
