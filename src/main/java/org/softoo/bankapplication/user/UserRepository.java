package org.softoo.bankapplication.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT new org.softoo.bankapplication.user.User(u.cnic) FROM User u WHERE u.cnic=:cnic")
	Optional<User> findByIdForReference(@Param("cnic") long cnic);
	
	@Query("SELECT new org.softoo.bankapplication.user.User(u.cnic) FROM User u WHERE u.email=:email")
	Optional<User> findByEmail(@Param("email") String email);
}
