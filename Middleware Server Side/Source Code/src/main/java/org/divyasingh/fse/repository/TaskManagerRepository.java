package org.divyasingh.fse.repository;

import org.divyasingh.fse.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TaskManagerRepository extends JpaRepository<Task, Integer>{
	
	@Modifying
	@Query(value="update task t set t.finished = :finished where t.task_id = :taskId", nativeQuery=true)
	void finishTask(@Param("taskId") Integer taskId, @Param("finished") String finished);
}
