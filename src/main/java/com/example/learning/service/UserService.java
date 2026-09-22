package com.example.learning.service;


import com.example.learning.exception.UserNotFoundException;
import com.example.learning.model.CreateUserRequest;
import com.example.learning.model.User;
import com.example.learning.model.UserResponse;
import com.example.learning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse getUser(Long id) throws UserNotFoundException {

        User savedUser = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        return new UserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }


    public UserResponse getUserByName(String name) throws UserNotFoundException {

        List<User> users = userRepository.findByName(name);
        //getFirst() ->
       // Requirements:If this List is not empty,
        // the implementation in this interface returns the result of calling get(0).
        // Otherwise, it throws NoSuchElementException.
        return new UserResponse(
                users.getFirst().getId(),
                users.getFirst().getName(),
                users.getFirst().getEmail()
        );
    }

    @Transactional
    public UserResponse createUser(CreateUserRequest request) {
        User user = new User(request.name(), request.email());
        User savedUser = userRepository.save(user);
        return new UserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );


    }



    public Page<UserResponse> getUsers(int page, int size) {
        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by("id").ascending()
        );

        return userRepository.findAll(pageable)
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                ));
    }

    //making a business operation succeed or fail as a unit.
    //Imagine one operation saves a user and then performs another database update.
    // If the second step fails, you may want to undo the first save.

    //By default, Spring rolls back for unchecked exceptions (RuntimeException) and Error.
    // Checked exceptions require an explicit rollback rule when you want the same behavior:
    @Transactional
    public void demonstrateRollback(CreateUserRequest request) {
        User user = new User(request.name(), request.email());

        userRepository.saveAndFlush(user);

      //  throw new IllegalStateException("Simulated failure after saving");

        //Next: what happens if you catch the exception inside the transactional method?
        //The transaction normally commits. The method returns successfully,
        // so the proxy doesn’t receive the exception and apply its rollback rule.
        try {
            throw new IllegalStateException("Simulated failure");
        } catch (IllegalStateException exception) {
            System.out.println("Caught: " + exception.getMessage());
           // throw exception; // Now the unchecked exception reaches the proxy, so the transaction rolls back.
        }
    }

    @Transactional
    public void deleteUser(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        userRepository.delete(user);
    }

}

