package net.muszytowski.WearableInspectionServer.repositories;

import java.util.List;

import net.muszytowski.WearableInspectionServer.items.GenericTask;
import net.muszytowski.WearableInspectionServer.items.InspectionTree;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends JpaRepository<GenericTask, Long> {
	
	@Query("SELECT t FROM Task t WHERE testExecution = :executionid")
	List<GenericTask> findAllExecutions(@Param("executionid") Long id); 
	
} 
	