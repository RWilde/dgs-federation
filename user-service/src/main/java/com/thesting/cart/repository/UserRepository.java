package com.thesting.cart.repository;

import com.netflix.dgs.codgen.generated.types.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
