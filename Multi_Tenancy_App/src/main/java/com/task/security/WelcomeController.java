package com.task.security;

import com.task.bean.Employee;
import com.task.repo.EmployeeRepository;
import com.task.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class WelcomeController {

    private final AuthenticationManager authenticationManager ;
    private final JwtUtil jwtUtil ;
    private final EmployeeService employeeService ;

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAll() throws SQLException {
        List<Employee> cities = employeeService.getAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getTenantId())
            );
        }catch (Exception e)
        {
            throw new Exception("invalid username / password");
        }
        return jwtUtil.generateToken(authRequest.getName());
    }
}
