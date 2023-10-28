package uz.pdp.javawithmongodb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.javawithmongodb.dacument.lesson2.Student;
import uz.pdp.javawithmongodb.repository.StudentRepository;
import uz.pdp.javawithmongodb.repository.StudentRepositoryWithMongoTem;
import uz.pdp.javawithmongodb.service.StudentService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/test/studentWithTemplate")
public class StudentControllerWithMongoTem {

    private final StudentRepositoryWithMongoTem studentRepositoryWithMongoTem;

    @PostMapping("/add")
    public Student saveStudent(@RequestBody Student student) {
        return studentRepositoryWithMongoTem.save(student);
    }

    @PutMapping
    public boolean updateStudent(@RequestBody Student student) {
        return studentRepositoryWithMongoTem.update(student);
    }

    @GetMapping("{id}")
    public Student getUser(@PathVariable(name = "id") String id) {
        return studentRepositoryWithMongoTem.getById(id);
    }

    @DeleteMapping("{id}")
    public boolean deleteUser(@PathVariable(name = "id") String id) {
        return studentRepositoryWithMongoTem.delete(id);
    }

    @GetMapping("/getByGroupId/{id}")
    public List<Student> getByGroupId(@PathVariable String id) {
        return studentRepositoryWithMongoTem.findByGroupId(id);
    }

    @GetMapping("/getAll")
    public List<Student> getAll(
            @RequestParam(defaultValue = "0", name = "page") Integer page,
            @RequestParam(defaultValue = "1", name = "size") Integer size,
            @RequestParam(defaultValue = "asc", name = "direction") String direction,
            @RequestParam(defaultValue = "id", name = "field") String field
    ) {
        return studentRepositoryWithMongoTem.findAll(page, size, direction, field);
    }

}
