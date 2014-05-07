package net.muszytowski.WearableInspectionServer.repositories;

import java.util.List;

import net.muszytowski.WearableInspectionServer.items.GenericTask;
import net.muszytowski.WearableInspectionServer.items.InspectionTree;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Repository for InspectionTree Beans
 * 
 * @author Sebastian Muszytowski
 */
@Transactional(readOnly = true) 
public interface InspectionTreeRepository extends JpaRepository<InspectionTree, Long> {

	// this query selects recursively all objects of the tree by the root node
	// here we have a serious performance issue (\o/ yay) but it works well.
	// the ORM is simply not designed for storing trees like this.....
	@Query("SELECT i FROM InspectionTree i WHERE i.resourceIdentifier NOT IN (SELECT DISTINCT child.resourceIdentifier FROM InspectionTree i, IN(i.children) child)")
	List<InspectionTree> findRoot();
	
	@Query("SELECT t FROM Task t WHERE resourceIdentifier = :taskId")
	GenericTask findTask(@Param("taskId") long id);
} 
	