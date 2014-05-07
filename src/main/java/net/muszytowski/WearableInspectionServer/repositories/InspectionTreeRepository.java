package net.muszytowski.WearableInspectionServer.repositories;

import java.util.List;

import net.muszytowski.WearableInspectionServer.items.GenericTask;
import net.muszytowski.WearableInspectionServer.items.InspectionTree;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true) 
public interface InspectionTreeRepository extends JpaRepository<InspectionTree, Long> {

	//
	@Query("SELECT i FROM InspectionTree i WHERE i.resourceIdentifier NOT IN (SELECT DISTINCT child.resourceIdentifier FROM InspectionTree i, IN(i.children) child)")
	List<InspectionTree> findRoot();
	
	@Query("SELECT t FROM Task t WHERE resourceIdentifier = :taskId")
	GenericTask findTask(@Param("taskId") long id);
} 
	