package br.com.gustavo.trackingservice.repository;

import br.com.gustavo.trackingservice.entity.Tracking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrackingRepository extends MongoRepository<Tracking,String> {

}