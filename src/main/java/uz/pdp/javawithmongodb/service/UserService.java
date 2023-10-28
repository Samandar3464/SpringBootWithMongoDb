package uz.pdp.javawithmongodb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.javawithmongodb.dacument.lesson1.Users;
import uz.pdp.javawithmongodb.repository.UsersRepository;

@Service
@RequiredArgsConstructor
public class UserService implements Base<Users>{
    private final UsersRepository usersRepository;

    @Override
    public Users create(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public Users get(String id) {
        return null;
    }

    @Override
    public Users update(Users users) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
