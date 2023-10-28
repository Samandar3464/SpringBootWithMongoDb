package uz.pdp.javawithmongodb.repository;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.javawithmongodb.dacument.lesson2.Gender;
import uz.pdp.javawithmongodb.dacument.lesson2.Student;

import java.util.List;

@Repository
public class StudentRepositoryWithMongoTem {

    private final MongoTemplate mongoTemplate;

    public StudentRepositoryWithMongoTem(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Student save(Student student) {
        return mongoTemplate.save(student);
    }

    public List<Student> findAll(Integer page, Integer size, String direction, String field) {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), field);
        Pageable pageable = PageRequest.of(page, size ,sort);
        Query query = new Query().with(pageable);
        return mongoTemplate.find(query ,Student.class);
    }

    public Student getById(String id) {
        return mongoTemplate.findById(id, Student.class);
    }

    public List<Student> findByGroupId(String id) {
        Query query = new Query(Criteria.where("group.id").is(id));
        return mongoTemplate.find(query, Student.class);
    }

    public boolean update(Student student) {
        Query query = new Query(Criteria.where("_id").is(student.getId()));
        Update update = new Update();
        update.set("name", student.getName());
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Student.class);
        return updateResult.wasAcknowledged();
    }

    public boolean delete(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        DeleteResult remove = mongoTemplate.remove(query, Student.class);
        return remove.wasAcknowledged();
    }

}
