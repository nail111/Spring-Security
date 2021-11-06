package All.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static All.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet(STUDENT_WRITE,STUDENT_READ)),
    ADMIN(Sets.newHashSet(ADMIN_READ,ADMIN_WRITE,STUDENT_READ,STUDENT_WRITE));


    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> grantedAuthorities() {
        Set<SimpleGrantedAuthority> simp = getPermissions().stream()
                .map(st -> new SimpleGrantedAuthority(st.getPermission()))
                .collect(Collectors.toSet());

        simp.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return simp;
    }
}
