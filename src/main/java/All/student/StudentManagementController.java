package All.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1")
public class StudentManagementController {
    private final static List<Student> STUDENTS = Arrays.asList(
            new Student(1,"Messi"),
            new Student(2,"Ronaldo")
    );

    @GetMapping
    @PreAuthorize("hasAuthority('admin:write')")
    public List<Student> getAll() {
        return STUDENTS;
    }
}
