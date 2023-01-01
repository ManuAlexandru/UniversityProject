package ro.UniversityProject.ProjectAPI.BLL.UTILS.TokenLogic;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.UserDTO;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MyUserDetails implements UserDetails {

    public long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String role;

    public MyUserDetails(UserDTO user){
        id=user.getId();
        email=user.Email;
        firstName=user.FirstName;
        lastName=user.LastName;
        password=user.Password;
role=user.role;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        return authorities;
    }
public String getRole(){
        return role;
}
public long getId(){
        return id;
}

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
