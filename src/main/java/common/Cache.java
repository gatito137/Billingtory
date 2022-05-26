package common;

import java.sql.Connection;

public class Cache {
    private static Connection connector;
    private static int User;
    private static int Permission;

    public Connection getConnector() {
        return connector;
    }

    public void setConnector(Connection connector) {
        this.connector = connector;
    }

    public int getUser() {
        return User;
    }

    public void setUser(int User) {
        this.User = User;
    }

    public int getPermission() {
        return Permission;
    }

    public void setPermission(int Permission) {
        this.Permission = Permission;
    }
}