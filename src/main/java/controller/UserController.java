package controller;

import dto.UserRequest;
import dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
private  final UserService userService;
@GetMapping()
public List <UserResponse> getAll(){
    return userServise.getAll;
}
@GetMapping({"id"})
    public UserResponse getById(@PathVariable("id") Long userId){
    return userService.getUserById(userId);
}
@PostMapping
    public UserResponse create(@RequestBody UserRequest request);
return userService.create(request);
}

}
