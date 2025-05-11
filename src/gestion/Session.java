package gestion;

import auth.LoginService;

public class Session {
    private static AeroportManager manager = new AeroportManager();
    private static LoginService loginService = new LoginService();

    public static AeroportManager getManager() {
        return manager;
    }

    public static LoginService getLoginService() {
        return loginService;
    }
}
