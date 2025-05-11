package gestion;

public class Session {
    private static AeroportManager manager = new AeroportManager();

    public static AeroportManager getManager() {
        return manager;
    }
}

