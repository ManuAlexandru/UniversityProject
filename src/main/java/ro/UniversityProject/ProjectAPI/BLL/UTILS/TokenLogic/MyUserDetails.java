package ro.UniversityProject.ProjectAPI.BLL.UTILS.TokenLogic;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.UserDTO;

import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private List<GrantedAuthority> authorities;
    private String role="User";
    public MyUserDetails(UserDTO user){
        email=user.Email;
        firstName=user.FirstName;
        lastName=user.LastName;
        password=user.Password;
       // authorities.add(new SimpleGrantedAuthority("ROLE "+role));
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
