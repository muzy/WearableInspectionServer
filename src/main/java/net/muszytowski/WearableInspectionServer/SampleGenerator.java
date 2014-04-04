package net.muszytowski.WearableInspectionServer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import net.muszytowski.WearableInspectionServer.items.BooleanTask;
import net.muszytowski.WearableInspectionServer.items.DateTask;
import net.muszytowski.WearableInspectionServer.items.FloatTask;
import net.muszytowski.WearableInspectionServer.items.GenericTask;
import net.muszytowski.WearableInspectionServer.items.InspectionTree;
import net.muszytowski.WearableInspectionServer.items.IntegerTask;
import net.muszytowski.WearableInspectionServer.items.ListOption;
import net.muszytowski.WearableInspectionServer.items.ListTask;
import net.muszytowski.WearableInspectionServer.items.RangeTask;
import net.muszytowski.WearableInspectionServer.items.StringTask;
import net.muszytowski.WearableInspectionServer.items.Task;

public class SampleGenerator {

	@SuppressWarnings("serial")
	public static ArrayList<String> authors = new ArrayList<String>(){{
	    add("John Doe");
	    add("Max Mustermann");
	    add("Mister X");
	    add("Maria Musterfrau");
	    add("Werner Wearable");
	}};
	
	@SuppressWarnings("serial")
	public static ArrayList<String> treeName = new ArrayList<String>(){{
	    add("Boing");
	    add("Auto");
	    add("VW");
	    add("Audi");
	}};
	
	@SuppressWarnings("serial")
	public static ArrayList<String> taskName = new ArrayList<String>(){{
	    add("Eine Inspektion");
	    add("Öl Wechseln");
	    add("Dinge tun");
	    add("Noch mehr Dinge tun");
	    add("Schrauben aufschrauben");
	}};
	
	@SuppressWarnings("serial")
	public static ArrayList<String> descriptions = new ArrayList<String>(){{
	    add("Eine Aufgabenbeschreibung");
	    add("Noch eine Beschreibung ohne Sinn");
	    add("Lorem Ipsum Beschreiberung der Aufgaberung Lorem Ipsum");
	}};
	
	@SuppressWarnings("serial")
	public static ArrayList<String> booleanTaskName = new ArrayList<String>(){{
	    add("Funktioniert noch");
	    add("Ist kaputt");
	    add("Ding aufgeschraubt");
	    add("Nippel durch die Lasche gezogen");
	}};
	@SuppressWarnings("serial")
	public static ArrayList<String> dateTaskName = new ArrayList<String>(){{
	    add("Ablaufdatum");
	    add("Nächster TÜV");
	    add("Geburtsdatum des Fahrers");
	}};
	@SuppressWarnings("serial")
	public static ArrayList<String> floatTaskName = new ArrayList<String>(){{
	    add("Alter der Mondrakete");
	    add("Siebenundreißig Sonderzeichen minus Zwei Komma Fünf");
	    add("Drei geteilt durch Fünf");
	}};
	
	@SuppressWarnings("serial")
	public static ArrayList<String> integerTaskName = new ArrayList<String>(){{
	    add("Schneewitchen und die X Zwerge");
	    add("Sieben mal Sieben ergibt");
	}};
	
	@SuppressWarnings("serial")
	public static ArrayList<String> listTaskName = new ArrayList<String>(){{
	    add("Schneewitchen und die X Zwerge");
	    add("Sieben mal Sieben ergibt");
	}};
	
	@SuppressWarnings("serial")
	public static ArrayList<String> listOptionValue = new ArrayList<String>(){{
	    add("Dies ist eine Option");
	    add("Und noch eine");
	    add("Eine haben wir noch");
	}};
	
	@SuppressWarnings("serial")
	public static ArrayList<String> rangeTaskName = new ArrayList<String>(){{
	    add("Eine Zahl zwischen zwei Werten");
	    add("Zwischen einem Minimum und Maximum");
	    add("Achte auf die Stufe!");
	}};
	
	@SuppressWarnings("serial")
	public static ArrayList<String> stringTaskName = new ArrayList<String>(){{
	    add("Hier ein Kennzeichen bitte");
	    add("Name des Kunden angeben");
	    add("Fehlerbeschreibung angeben");
	}};
	
	public static  Random r = new Random();

	public static InspectionTree generateRandomTree(int depth){
		int inspectionDepth = (depth - r.nextInt(depth-1)); // -1 to have at least one task
		System.out.println(inspectionDepth);
		int taskDepth = depth - inspectionDepth;
		System.out.println(taskDepth);
		return generateInspectionTree(inspectionDepth, taskDepth);
	}

	
	public static InspectionTree generateInspectionTree(int idepth,int tdepth){
		if(idepth <= 1){
			InspectionTree inspection = new InspectionTree();
			inspection.setAuthor(authors.get(r.nextInt(authors.size())));
			inspection.setName(treeName.get(r.nextInt(treeName.size())));
			inspection.setData(generateTaskTree(tdepth));
			return inspection;
		}else{
			InspectionTree inspection = new InspectionTree();
			inspection.setAuthor(authors.get(r.nextInt(authors.size())));
			inspection.setName(treeName.get(r.nextInt(treeName.size())));
			for(int i = 0; i <= r.nextInt(3)+1; i++){
				inspection.addChild(generateInspectionTree(--idepth, tdepth));
			}
			return inspection;
		}
	}
	
	public static Task generateTaskTree(int depth){
		if(depth <= 1) {
			Task task = new Task();
			task.setAuthor(authors.get(r.nextInt(authors.size())));
			task.setDescription(descriptions.get(r.nextInt(descriptions.size())));
			task.setIsTestExecution(false);
			task.setWeight(r.nextInt(100));
			task.setName(taskName.get(r.nextInt(taskName.size())));
			task.setDate(new Date(946771200000L + (Math.abs(r.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000))));
			for(int i = 0; i <= r.nextInt(5)+1; i++){
				task.addChildren(generateTask());
			}
			return task;
		}else{
			Task task = new Task();
			task.setAuthor(authors.get(r.nextInt(treeName.size())));
			task.setDescription(descriptions.get(r.nextInt(descriptions.size())));
			task.setIsTestExecution(false);
			task.setWeight(r.nextInt(100));
			task.setName(taskName.get(r.nextInt(taskName.size())));
			task.setDate(new Date(946771200000L + (Math.abs(r.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000))));
			for(int i = 0; i <= r.nextInt(2)+1; i++){
				task.addChildren(generateTaskTree(--depth));
			}
			return task;
		}		
	}
	
	
	public static GenericTask generateTask(){
		GenericTask task = null;

		switch(r.nextInt(7)){
			case 0:
				task = new BooleanTask();
				task.setName(booleanTaskName.get(r.nextInt(booleanTaskName.size())));
				break;
			case 1:
				task = new DateTask();
				task.setName(dateTaskName.get(r.nextInt(dateTaskName.size())));
				break;
			case 2:
				task = new FloatTask();
				task.setName(floatTaskName.get(r.nextInt(floatTaskName.size())));
				break;
			case 3:
				task = new IntegerTask();
				task.setName(integerTaskName.get(r.nextInt(integerTaskName.size())));
				break;
			case 4:
				task = new ListTask();
				task.setName(listTaskName.get(r.nextInt(listTaskName.size())));
				for(int i = 0; i < listOptionValue.size(); i++){
					((ListTask) task).addOption(new ListOption(listOptionValue.get(i)));
				}
				break;
			case 5:
				task = new RangeTask();
				task.setName(rangeTaskName.get(r.nextInt(rangeTaskName.size())));
				((RangeTask) task).setStart(r.nextInt(10));
				((RangeTask) task).setStop(r.nextInt(100)+10);
				((RangeTask) task).setStep(r.nextInt(1)+1);	
				break;
			case 6:
				task = new StringTask();
				task.setName(stringTaskName.get(r.nextInt(stringTaskName.size())));
				break;
			default:
		}
		
		task.setAuthor(authors.get(r.nextInt(authors.size())));
		task.setDescription(descriptions.get(r.nextInt(descriptions.size())));
		task.setIsTestExecution(false);
		task.setWeight(r.nextInt(100));
		task.setDate(new Date(946771200000L + (Math.abs(r.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000))));

		return task;
	}
	
}
