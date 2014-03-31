package net.muszytowski.WearableInspectionServer.repositories;

import net.muszytowski.WearableInspectionServer.items.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

} 
	