package ro.UniversityProject.ProjectAPI.BLL.UTILS.TokenLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.UniversityProject.ProjectAPI.Common.DTOModels.UserDTO;
import ro.UniversityProject.ProjectAPI.DAL.Abstraction.UserStore;

@Service
public class MyUserdetailService implements UserDetailsService {
@Autowired
UserStore _userStore;

    @Override
   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
UserDTO user=_userStore.findByEmail(email);
if(user ==null)
    throw new UsernameNotFoundException("User not found");
var userDetails=new MyUserDetails(user);
        return  userDetails;
   }
}
