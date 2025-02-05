package academy.itk.service;

public interface UserService {

    String getUser(String username);

    String getModerator(String username);

    String getSuperAdmin(String username);
}
