package com.zach.dojooverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.zach.dojooverflow.models.*;
import java.util.*;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
	List<Tag> findAll();
	
	String findByContentIgnoreCase(String body);
}
