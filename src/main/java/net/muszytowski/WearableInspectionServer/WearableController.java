package net.muszytowski.WearableInspectionServer;

import java.sql.Date;

import javax.annotation.Resource;

import net.muszytowski.WearableInspectionServer.items.Attachment;
import net.muszytowski.WearableInspectionServer.items.InspectionTree;
import net.muszytowski.WearableInspectionServer.items.Status;
import net.muszytowski.WearableInspectionServer.items.Task;
import net.muszytowski.WearableInspectionServer.repositories.TaskRepository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@Transactional
public class WearableController {
	
	private @Autowired TaskRepository taskRepository;
	
	/**
	 * Set InspectionTree
	 * 
	 * @return
	 */
	@RequestMapping("/setInspectionTree")
	public @ResponseBody
	Status setInspectionTree(
			@RequestParam(value = "Insrc/main/java/net/muszytowski/WearableInspectionServer/items/InspectionTree.javaspectionTree", required = true) InspectionTree inspectionTree) {
		return null;
	}

	/**
	 * Get the InspectionTree
	 * 
	 * @return
	 */
	@RequestMapping("/getInspectionTree")
	public @ResponseBody
	InspectionTree getInspectionTree() {
		InspectionTree tree1 = new InspectionTree();
		tree1.setAuthor("muzy");
		tree1.setName("a tree");
		tree1.setParent(null);
		InspectionTree tree2 = new InspectionTree();
		tree2.setAuthor("muzy two");
		tree2.setName("another tree");
		tree2.setParent(tree1);
		tree1.addChild(tree2);
		Task task1 = new Task();
		task1.setAuthor("muzzzzy");
		task1.setDate(new Date(0));
		task1.setDescription("a task");
		task1.setName("foo");
		task1.setWeight(42);
		tree1.setData(task1);
		return tree1;
	}
	
	/**
	 * Gets a task (by ID)
	 * @param long
	 * @return
	 */
	@RequestMapping("/getTask")
	public @ResponseBody
	Task getTask(
			@RequestParam(value = "Task", required = true) Long id) {
		return taskRepository.findOne(id);
	}
	
	/**
	 * Sets a task
	 * @param task
	 * @return
	 */
	@RequestMapping("/setTask")
	public @ResponseBody
	Task setTask(
			@RequestParam(value = "Task", required = true) String taskString) throws Exception {
		Task task = new ObjectMapper().readValue(taskString.getBytes(), Task.class);
		System.out.println("TASK");
		return taskRepository.save(task);
	}
	
	/**
	 * uploads a attachment
	 * @param attachment
	 * @return
	 */
	@RequestMapping("/uploadAttachment")
	public @ResponseBody
	Status uploadAttachment(
			@RequestParam(value = "Attachment", required = true) Attachment attachment) {
		return null;
	}
	
	

}
