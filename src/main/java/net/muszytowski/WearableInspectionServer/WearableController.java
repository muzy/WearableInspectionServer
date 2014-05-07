package net.muszytowski.WearableInspectionServer;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Controller for the WearableInspectionServer.
 * Here the mapping of URLs is done.
 * 
 * @author Sebastian Muszytowski
 *
 */
@Controller
@Transactional
public class WearableController {
	
	private @Autowired TaskRepository taskRepository;
	private @Autowired InspectionTreeRepository inspectionTreeRepository;
	
	/**
	 * Sets an InspectionTree, either by using POST or GET.
	 * This methods are to be called by the configuration application
	 * only. The object mapper parses the JSON string into an 
	 * InspectionTree using UTF-8 encoding.
	 * 
	 * @return
	 * @throws  
	 */
	@RequestMapping(value = "/setInspectionTree",
	         method = RequestMethod.GET)
	public @ResponseBody
	InspectionTree setInspectionTree(
			@RequestParam(value = "InspectionTree", required = true) String inspectionTree) throws Exception {
		InspectionTree tree = new ObjectMapper().readValue(inspectionTree.getBytes("UTF-8"), InspectionTree.class);
		return inspectionTreeRepository.save(tree);
	}
	
	@RequestMapping(value = "/setInspectionTree",
	         method = RequestMethod.POST)
	public @ResponseBody
	InspectionTree setInspectionTreePOST(
			@RequestBody String inspectionTree) throws Exception {
		InspectionTree tree = new ObjectMapper().readValue(inspectionTree.getBytes("UTF-8"), InspectionTree.class);
		return inspectionTreeRepository.save(tree);
	}

	/**
	 * Generates SampleData and stores it internally.
	 * @param depth Depth of the Tree to be generated
	 * @return InspectionTree generated
	 */
	@RequestMapping("/generateSampleData")
	public @ResponseBody
	InspectionTree getInspectionTreeSample(@RequestParam(value = "Depth", required = false) Integer depth) {
		InspectionTree sample = SampleGenerator.generateRandomTree((depth == null)? 7 : depth);
		System.out.println(sample);
		return inspectionTreeRepository.save(sample);
	}
	
	/**
	 * Get the InspectionTree from the ObjectMapper and returns
	 * it in JSON format
	 * @return InspectionTree
	 */
	@RequestMapping("/getInspectionTree")
	public @ResponseBody
	InspectionTree getInspectionTree() {
		List<InspectionTree> result = inspectionTreeRepository.findRoot();
		return (result.isEmpty())?null : result.get(0);
	}
	
	/**
	 * Gets a task by its resourceIdentifier (long) data 
	 * type. To be used by clients to get task template to be
	 * executed.
	 * @param long resourceIdentifier
	 * @return Task
	 */
	@RequestMapping("/getTask")
	public @ResponseBody
	GenericTask getTask(
			@RequestParam(value = "Task", required = true) Long id) {
			return inspectionTreeRepository.findTask(id);
	}
	
	/**
	 * Gets a List of Tasks which were executed before.
	 * Can be specified for root level tasks or abitrary tasks.
	 * @param id resourceIdentifier
	 * @return List of Tasks
	 */
	@RequestMapping("/getTaskExecution")
	public @ResponseBody
	List<GenericTask> getTaskExecution(
			@RequestParam(value = "Task", required = true) Long id) {
		return taskRepository.findAllExecutions(id);
	}
	
	/**
	 * Sets a task. For the desktop application the task is the 
	 * definition how a process is to be executed. For the client
	 * applications it is used to upload executed tests.
	 * 
	 * @param task
	 * @return Task The task just uploaded (for verification)
	 */
	@RequestMapping(value = "/setTask", method = RequestMethod.GET)
	public @ResponseBody
	Task setTask(
			@RequestParam(value = "Task", required = true) String taskString) throws Exception 	{
		Task task = new ObjectMapper().readValue(taskString.getBytes("UTF-8"), Task.class);
		return taskRepository.save(task);
	}
	
	@RequestMapping(value = "/setTask", method = RequestMethod.POST)
	public @ResponseBody
	Task setTaskPOST(
			@RequestBody String taskString) throws Exception {
		Task task = new ObjectMapper().readValue(taskString.getBytes("UTF-8"), Task.class);
		return taskRepository.save(task);
	}
	
	/**
	 * Uploads an attachment to the Server
	 * 
	 * THIS FUNCTION IS NOT YET IMPLEMENTED
	 * 
	 * @param attachment
	 * @return Status
	 */
	@RequestMapping("/uploadAttachment")
	public @ResponseBody
	Status uploadAttachment(
			@RequestParam(value = "Attachment", required = true) Attachment attachment) {
		return null;
	}
	
	

}
