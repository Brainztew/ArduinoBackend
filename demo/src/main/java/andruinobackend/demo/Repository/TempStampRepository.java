package andruinobackend.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import andruinobackend.demo.Model.TempStamp;

public interface TempStampRepository extends MongoRepository<TempStamp, String> {

    TempStamp findByTemp(String temp);
}
