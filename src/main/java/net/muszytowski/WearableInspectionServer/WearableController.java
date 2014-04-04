package net.muszytowski.WearableInspectionServer;

import java.util.Date;
import java.util.List;
import java.util.Random;

import net.muszytowski.WearableInspectionServer.items.Attachment;
import net.muszytowski.WearableInspectionServer.items.GenericTask;
import net.muszytowski.WearableInspectionServer.items.InspectionTree;
import net.muszytowski.WearableInspectionServer.items.Status;
import net.muszytowski.WearableInspectionServer.items.Task;
import net.muszytowski.WearableInspectionServer.repositories.InspectionTreeRepository;
import net.muszytowski.WearableInspectionServer.repositories.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
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
	private @Autowired InspectionTreeRepository inspectionTreeRepository;
	
	/**
	 * Set InspectionTree
	 * 
	 * @return
	 * @throws  
	 */
	@RequestMapping("/setInspectionTree")
	public @ResponseBody
	InspectionTree setInspectionTree(
			@RequestParam(value = "InspectionTree", required = true) String inspectionTree) throws Exception {
		InspectionTree tree = new ObjectMapper().readValue(inspectionTree.getBytes(), InspectionTree.class);
		return inspectionTreeRepository.save(tree);
	}

	/**
	 * Get the InspectionTree
	 * 
	 * @return
	 */
	@RequestMapping("/generateSampleData")
	public @ResponseBody
	InspectionTree getInspectionTreeSample(@RequestParam(value = "Depth", required = false) Integer depth) {
		InspectionTree sample = SampleGenerator.generateRandomTree((depth == null)? 7 : depth);
		return inspectionTreeRepository.save(sample);
	}
	
	@RequestMapping("/getInspectionTree")
	public @ResponseBody
	InspectionTree getInspectionTree() {
		List<InspectionTree> result = inspectionTreeRepository.findRoot();
		return (result.isEmpty())?null : result.get(0);
	}
	
	
	/**
	 * Gets a task (by ID)
	 * @param long
	 * @return
	 */
	@RequestMapping("/getTask")
	public @ResponseBody
	GenericTask getTask(
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
			@RequestParam(value = "Task", required = true) String taskString) throws Exception 	{
		Task task = new ObjectMapper().readValue(taskString.getBytes(), Task.class);
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
