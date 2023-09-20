package com.api.metroflex_backend.services;

import com.api.metroflex_backend.models.UserModel;
import com.api.metroflex_backend.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll();
    }
    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }
    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }

    public UserModel updateById(UserModel request, Long id) {
        Optional<UserModel> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            UserModel user = optionalUser.get();

            // Verificar que los campos no sean nulos antes de actualizarlos
            if (request.getFirstName() != null) {
                user.setFirstName(request.getFirstName());
            }
            if (request.getLastName() != null) {
                user.setLastName(request.getLastName());
            }
            if (request.getEmail() != null) {
                user.setEmail(request.getEmail());
            }

            return userRepository.save(user); // Guardar los cambios en la base de datos
        } else {
            // Manejar el caso en el que no se encuentre el usuario con el ID dado
            throw new IllegalArgumentException("Usuario no encontrado con el ID proporcionado: " + id);
        }
    }

    public Boolean deleteUser(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

