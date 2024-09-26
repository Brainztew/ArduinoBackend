package andruinobackend.demo.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import andruinobackend.demo.Model.TempStamp;
import andruinobackend.demo.Repository.TempStampRepository;

@Service
public class AndruinoService {

    @Autowired
    TempStampRepository tempStampRepository;

    public TempStamp saveTemp(TempStamp tempStamp) {
        ZonedDateTime currentDateTime = ZonedDateTime.now(ZoneId.of("Europe/Stockholm")).plusHours(2);
        Date date = Date.from(currentDateTime.toInstant());
        tempStamp.setTempDate(date);
        return tempStampRepository.save(tempStamp);
    }

    public List<TempStamp> getAllTempStamp() {
        return tempStampRepository.findAll();
    }

    public TempStamp fetchLive() {
        TempStamp liveTempStamp = new TempStamp();
        liveTempStamp.setTemp("25.0");
        liveTempStamp.setHumidity("50.0");
        return liveTempStamp;
    }
    
}
