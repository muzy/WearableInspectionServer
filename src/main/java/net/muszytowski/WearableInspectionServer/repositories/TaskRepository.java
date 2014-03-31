package net.muszytowski.WearableInspectionServer.repositories;

import net.muszytowski.WearableInspectionServer.items.GenericTask;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<GenericTask, Long> {

} 
	