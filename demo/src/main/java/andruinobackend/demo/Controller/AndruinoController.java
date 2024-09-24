package andruinobackend.demo.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AndruinoController {

    @PostMapping("/temp")
    public String postMethodName(@RequestBody String entity) {
        System.out.println("from andruino: " + entity);
        return null;
    }

    @GetMapping("/root")
    public String getRoot() {
        return "Hello World";
    }
    
    
}
