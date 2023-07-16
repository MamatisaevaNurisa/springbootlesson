package service;

import dto.UserRequest;
import dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import peaksoft.springBootLesson.entity.Role;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private  final UserRepository userRepository;

    public UserResponse create (UserRequest request){
    User user = new User;
    user.setUsername(request.getUserName());
    user.setLastName(request.getLastName());
    user.setEmail(request.getEmail());
    user.setPassword(request.getPassword());
    user.setRole(request.getRoleName());
   userRepository.save(user);
   return
    }

   public UserResponse mapToResponse(User user) {
        UserResponse userResponse()
               .id(user.getId())
               .username(user.getUsername())
               .lastName(user.getLasdtName())
               .email(user.getEmail())
               .roleName(user.getRole().name())
               .localDate(user.getLocalDate()).build();
   }

   public List<UserResponse> getAll(){
      List <UserResponse> userResponses = new ArrayList<>();
      for (User user: userRepository.findAll()){
          userResponses.add(mapToResponse(user));
      }
      return userResponses;
   }
   public UserResponse getUserById(Long userId){
        User user = userRepository.findById(userId).get();
       user.setUsername(request.getUserName());
       user.setLastname(request.getLastName());
       user.setEmail(request.getEmail());
       user.setPassword(passwordEncoder.encode(request.getPassword()));
       user.setRole(Role.valueOf(request.getRoleName()));
        return mapToResponse(user);
   }
   public UserResponse update (Long userId,UserRequest request){

       User user = userRepository.findById(userId).get();
       user.setUsername(request.getUsername());
       user.setLastName(request.getLastName());
       user.setEmail(request.getEmail());
       user.setPassword(passwordEncoder.encode(request.getPassword()));
       user.setRole(Role.valueOf(request.getRoleName()));
       userRepository.save(user);
       return mapToResponse(user);
   }
   public String delete(Long userId){
    userRepository.deleteById(userId);
    return "Succesfully deleted with id "+userId
    }
}


