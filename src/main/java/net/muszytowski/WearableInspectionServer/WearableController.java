package net.muszytowski.WearableInspectionServer;

import java.sql.Date;
import java.util.Collection;

import net.muszytowski.WearableInspectionServer.Items.InspectionTree;
import net.muszytowski.WearableInspectionServer.Items.Task;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WearableController {


    @RequestMapping("/getInspectionTree")
    public @ResponseBody InspectionTree getInspectionTree(){
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
	
}
