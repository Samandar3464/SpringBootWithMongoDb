package uz.pdp.javawithmongodb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.pdp.javawithmongodb.UserNotFound;
import uz.pdp.javawithmongodb.dacument.lesson2.Gender;
import uz.pdp.javawithmongodb.dacument.lesson2.Student;
import uz.pdp.javawithmongodb.repository.StudentRepository;
import uz.pdp.javawithmongodb.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.ClassUtils.isPresent;

@Service
@RequiredArgsConstructor
public class StudentService implements Base<Student> {

    private final StudentRepository studentRepository;

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student get(String id) {
        return studentRepository.findById(id).orElseThrow(() -> new UserNotFound("Student not found"));
    }

    @Override
    public Student update(Student student) {
        Optional<Student> byId = studentRepository.findById(student.getId());
        if (byId.isPresent()) {
            Student student1 = byId.get();
            if (student.getAge() != null) student1.setAge(student.getAge());
            if (student.getName() != null) student1.setName(student.getName());
            if (student.getGender() != null) student1.setGender(student.getGender());
            studentRepository.save(student1);
            // qolgani davom etadi
            return student1;
        }
        throw new UserNotFound("Student not found");
    }

    @Override
    public boolean delete(String id) {
        if (studentRepository.findById(id).isPresent()) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Student> findAllByGroupId(String id) {
        return studentRepository.findAllByGroId(id);
    }
    public List<Student> findAllByGender(String gender) {
        return studentRepository.findAllByGen(Gender.valueOf(gender));
    }

    public List<Student> findAll(Integer page, Integer size) {
        PageRequest of = PageRequest.of(page, size);
        return studentRepository.findAll(of).getContent();
    }

    public List<Student> getAllBySort(String direction, String field) {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), field);
       return studentRepository.findAll(sort);
    }
}
