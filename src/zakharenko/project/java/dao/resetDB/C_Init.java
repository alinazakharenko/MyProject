package zakharenko.project.java.dao.resetDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver: " + e);
        }
    }

    public static void main(String[] args) {
        try (
                Connection connection =
                        DriverManager.getConnection(CN.DB_URL, CN.DB_USER, CN.DB_PASSWORD);
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `zakharenko` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `zakharenko` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zakharenko`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zakharenko`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NULL,\n" +
                    "  `password` VARCHAR(45) NULL,\n" +
                    "  `email` VARCHAR(45) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `zakharenko`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zakharenko`.`books` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(255) NULL,\n" +
                    "  `material` VARCHAR(255) NULL,\n" +
                    "  `parameter` VARCHAR(255) NULL,\n" +
                    "  `client` VARCHAR(255) NULL,\n" +
                    "  `number` INT NULL,\n" +
                    "  `date` DOUBLE NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_books_users1_idx` (`users_id` ASC),\n" +
                    "  CONSTRAINT `fk_books_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `zakharenko`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `zakharenko`.`roles` (`id`, `role`) VALUES (DEFAULT, 'Широкоформатная и интерьерная печать');\n");
            statement.executeUpdate("INSERT INTO `zakharenko`.`roles` (`id`, `role`) VALUES (DEFAULT, 'Полиграфическая продукция');");
            statement.executeUpdate("INSERT INTO `zakharenko`.`roles` (`id`, `role`) VALUES (DEFAULT, 'Наружная реклама');");
            statement.executeUpdate("INSERT INTO `zakharenko`.`roles` (`id`, `role`) VALUES (DEFAULT, 'Офис');");
            statement.executeUpdate("INSERT INTO `zakharenko`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'Елена', 'Андреева', 'and@mail.ru', 4);");
            statement.executeUpdate("INSERT INTO `zakharenko`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'Дима', 'Котов', 'dima123@mail.ru', 2);");
            statement.executeUpdate("INSERT INTO `zakharenko`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'Илья', 'Белов', 'belov39@mail.ru', 3);");
            statement.executeUpdate("INSERT INTO `zakharenko`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'Сергей', 'Толочко', 'tolochko@mail.ru', 1);");
            statement.executeUpdate("INSERT INTO `zakharenko`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'Илья', 'Степанов', 'ilst@mail.ru', 2);");
            statement.executeUpdate("INSERT INTO `zakharenko`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'Денис', 'Федоренко', 'denis89@mail.ru', 3);");
            statement.executeUpdate("INSERT INTO `zakharenko`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'Николай', 'Мороз', 'moroz@mail.ru', 1);");
            statement.executeUpdate("INSERT INTO `zakharenko`.`books` (`id`, `name`, `material`, `parameter`, `client`, `number`, `date`, `users_id`)" +
                    " VALUES (DEFAULT, 'Широкоформатная печать', 'Пленка', '510', 'Космо', 18.06, 2);");
            statement.executeUpdate("INSERT INTO `zakharenko`.`books` (`id`, `name`, `material`, `parameter`, `client`, `number`, `date`, `users_id`)" +
                    " VALUES (DEFAULT, 'Полиграфия', 'Флаеры', '10*15', 'Рублевский', 300, 18.07, 2);");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}