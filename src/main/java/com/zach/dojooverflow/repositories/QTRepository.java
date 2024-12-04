package com.zach.dojooverflow.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.zach.dojooverflow.models.*;


@Repository
public interface QTRepository extends CrudRepository<QuestionTag, Long>{

}
