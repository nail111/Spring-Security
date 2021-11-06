package All.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {

    private final static List<Student> STUDENTS = Arrays.asList(
            new Student(1,"Messi"),
            new Student(2,"Ronaldo")
    );

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('student:write')")
    public Student getStudent(@PathVariable("id") Integer id) {
      return STUDENTS.stream()
                .filter(st -> id.equals(st.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + id + " doesn't exist"));
    }


}
