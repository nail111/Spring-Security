package All.security;

public enum ApplicationUserPermission {
    STUDENT_WRITE("student:write"),
    STUDENT_READ("student:read"),
    ADMIN_WRITE("admin:write"),
    ADMIN_READ("admin:read");


    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
