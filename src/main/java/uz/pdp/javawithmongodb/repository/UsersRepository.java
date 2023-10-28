package uz.pdp.javawithmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import uz.pdp.javawithmongodb.dacument.lesson1.Users;
@EnableMongoRepositories
public interface UsersRepository extends MongoRepository<Users, String> {


}
