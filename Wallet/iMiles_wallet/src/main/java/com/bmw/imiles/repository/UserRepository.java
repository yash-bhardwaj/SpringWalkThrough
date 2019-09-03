/**
 * 
 */

  package com.bmw.imiles.repository;
  
  import org.springframework.data.repository.CrudRepository;

import com.bmw.imiles.entity.User;
  
 /**
	 * @author avadheshkumar
	 *
	 */
		  public interface UserRepository extends CrudRepository<User, Long> {

			    User findByUsername(String username);
			    User findByEmail(String email);
		  }