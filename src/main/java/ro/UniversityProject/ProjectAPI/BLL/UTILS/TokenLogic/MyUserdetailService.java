package ro.UniversityProject.ProjectAPI.BLL.UTILS.TokenLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.UserDTO;
import ro.UniversityProject.ProjectAPI.DAL.Abstraction.UserStore;

import java.util.Optional;
@Service
public class MyUserdetailService implements UserDetailsService {
@Autowired
    UserStore _userStore;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
Optional<UserDTO> user=_userStore.findByEmail(email);
user.orElseThrow(()->new UsernameNotFoundException("User not found"));
        return  user.map(MyUserDetails::new).get();
    }
}
