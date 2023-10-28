package uz.pdp.javawithmongodb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uz.pdp.javawithmongodb.dacument.lesson2.Gender;
import uz.pdp.javawithmongodb.dacument.lesson2.Student;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student , String> {

    @Query("{'group._id' : ?0 }")
    List<Student> findAllByGroId(String id);


    @Query("{'gender' : ?0 }")
    List<Student> findAllByGen(Gender gender);


    Page<Student> findAll(Pageable pageable);

}
