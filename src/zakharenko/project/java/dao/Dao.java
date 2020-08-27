package zakharenko.project.java.dao;

import zakharenko.project.java.dao.resetDB.C_Init;

public class Dao {

    private static Dao dao;

    private Dao() {
        role = new DaoRole();
        user = new DaoUser();
        book = new DaoBook();
    }

    public DaoRole role;
    public DaoUser user;
    public DaoBook book;

    public static void reset(){
        C_Init.main(new String[]{});
    }

    public static Dao getDao() {
        if (dao == null)
            synchronized (Dao.class) {
                if (dao == null)
                    dao = new Dao();
            }
        return dao;
    }
}
