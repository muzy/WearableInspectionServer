package net.muszytowski.WearableInspectionServer.repositories;

import java.util.List;

import net.muszytowski.WearableInspectionServer.items.GenericTask;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repository for Task beans
 * @author Sebastian Muszytowski
 */
public interface TaskRepository extends JpaRepository<GenericTask, Long> {
	
	@Query("SELECT t FROM Task t WHERE testExecution = :executionid")
	List<GenericTask> findAllExecutions(@Param("executionid") Long id); 
	
} 
	