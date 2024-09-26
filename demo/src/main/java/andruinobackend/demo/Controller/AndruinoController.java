package andruinobackend.demo.Controller;

import org.springframework.web.bind.annotation.RestController;

import andruinobackend.demo.Model.TempStamp;
import andruinobackend.demo.Service.AndruinoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*")
public class AndruinoController {

    @Autowired
    AndruinoService andruinoService;

    private TempStamp liveTempStamp;

    @PostMapping("/temp")
    public TempStamp SaveTemp(@RequestBody TempStamp tempStamp) {
        System.out.println("from andruino: " + tempStamp.getHumidity() + " " + tempStamp.getTemp());
        if (tempStamp.getTemp() == null) {
            throw new IllegalArgumentException("Temp is required");
        } if (tempStamp.getHumidity() == null) {
            throw new IllegalArgumentException("Humidity is required");
        }
        return andruinoService.saveTemp(tempStamp);
    }

    @GetMapping("/temp")
    public List<TempStamp> getAllTempStamp() {
        return andruinoService.getAllTempStamp();
    }

    @GetMapping("/root")
    public String getRoot() {
        return "Hello World";
    }

    @GetMapping("/live")
    public TempStamp getLive() {
        if (liveTempStamp == null) {
            return null;  
        }
        return liveTempStamp;
    }

    @PostMapping("/live")
    public TempStamp postLive(@RequestBody TempStamp tempStamp) {
        System.out.println("Live data from Arduino: " + tempStamp.getHumidity() + " " + tempStamp.getTemp());
        if (tempStamp.getTemp() == null) {
            throw new IllegalArgumentException("Temp is required");
        }
        if (tempStamp.getHumidity() == null) {
            throw new IllegalArgumentException("Humidity is required");
        }
        liveTempStamp = tempStamp;
        return tempStamp;
    }
    
    
}
