package uz.pdp.javawithmongodb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.javawithmongodb.dacument.lesson2.Student;
import uz.pdp.javawithmongodb.service.StudentService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/test/student/")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("add")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.create(student);
    }

    @PutMapping("update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.update(student);
    }

    @GetMapping("{id}")
    public Student getUser(@PathVariable(name = "id") String id) {
        return studentService.get(id);
    }

    @DeleteMapping("{id}")
    public boolean deleteUser(@PathVariable(name = "id") String id) {
        return studentService.delete(id);
    }

    @GetMapping("/getByGroupId/{id}")
    public List<Student> getByGroupId(@PathVariable String id) {
        return studentService.findAllByGroupId(id);
    }

    @GetMapping("/getByGender/{gender}")
    public List<Student> findAllByGender(@PathVariable String gender) {
        return studentService.findAllByGender(gender);
    }

    @GetMapping("/getAll")
    public List<Student> getAll(
            @RequestParam(defaultValue = "0", name = "page") Integer page,
            @RequestParam(defaultValue = "1", name = "size") Integer size
    ) {
        return studentService.findAll(page, size);
    }

    @GetMapping("/getAllBySort")
    public List<Student> getAllBySort(
            @RequestParam(defaultValue = "asc", name = "direction") String direction,
            @RequestParam(defaultValue = "id", name = "field") String field
    ) {
        return studentService.getAllBySort(direction, field);
    }
}
