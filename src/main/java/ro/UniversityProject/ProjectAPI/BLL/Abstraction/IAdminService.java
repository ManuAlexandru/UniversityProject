package ro.UniversityProject.ProjectAPI.BLL.Abstraction;

import ro.UniversityProject.ProjectAPI.Common.DTOModels.UserDTO;

import java.util.List;

public interface IAdminService {
    List<UserDTO> GetUsers();
}
