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
	public static ArrayList<String> authors = new ArrayList<String>() {
		{
			add("John Doe");
			add("Max Mustermann");
			add("Mister X");
			add("Maria Musterfrau");
			add("Werner Wearable");
		}
	};

	@SuppressWarnings("serial")
	public static ArrayList<String> treeName = new ArrayList<String>() {
		{
			add("Boing");
			add("Auto");
			add("VW");
			add("Audi");
		}
	};

	@SuppressWarnings("serial")
	public static ArrayList<String> taskName = new ArrayList<String>() {
		{
			add("Eine Inspektion");
			add("Öl Wechseln");
			add("Dinge tun");
			add("Noch mehr Dinge tun");
			add("Schrauben aufschrauben");
		}
	};

	@SuppressWarnings("serial")
	public static ArrayList<String> descriptions = new ArrayList<String>() {
		{
			add("Eine Aufgabenbeschreibung");
			add("Noch eine Beschreibung ohne Sinn");
			add("Lorem Ipsum Beschreiberung der Aufgaberung Lorem Ipsum");
		}
	};

	@SuppressWarnings("serial")
	public static ArrayList<String> booleanTaskName = new ArrayList<String>() {
		{
			add("Funktioniert noch");
			add("Ist kaputt");
			add("Ding aufgeschraubt");
			add("Nippel durch die Lasche gezogen");
		}
	};
	@SuppressWarnings("serial")
	public static ArrayList<String> dateTaskName = new ArrayList<String>() {
		{
			add("Ablaufdatum");
			add("Nächster TÜV");
			add("Geburtsdatum des Fahrers");
		}
	};
	@SuppressWarnings("serial")
	public static ArrayList<String> floatTaskName = new ArrayList<String>() {
		{
			add("Alter der Mondrakete");
			add("Siebenundreißig Sonderzeichen minus Zwei Komma Fünf");
			add("Drei geteilt durch Fünf");
		}
	};

	@SuppressWarnings("serial")
	public static ArrayList<String> integerTaskName = new ArrayList<String>() {
		{
			add("Schneewitchen und die X Zwerge");
			add("Sieben mal Sieben ergibt");
		}
	};

	@SuppressWarnings("serial")
	public static ArrayList<String> listTaskName = new ArrayList<String>() {
		{
			add("Schneewitchen und die X Zwerge");
			add("Sieben mal Sieben ergibt");
		}
	};

	@SuppressWarnings("serial")
	public static ArrayList<String> listOptionValue = new ArrayList<String>() {
		{
			add("Dies ist eine Option");
			add("Und noch eine");
			add("Eine haben wir noch");
		}
	};

	@SuppressWarnings("serial")
	public static ArrayList<String> rangeTaskName = new ArrayList<String>() {
		{
			add("Eine Zahl zwischen zwei Werten");
			add("Zwischen einem Minimum und Maximum");
			add("Achte auf die Stufe!");
		}
	};

	@SuppressWarnings("serial")
	public static ArrayList<String> stringTaskName = new ArrayList<String>() {
		{
			add("Hier ein Kennzeichen bitte");
			add("Name des Kunden angeben");
			add("Fehlerbeschreibung angeben");
		}
	};

	public static Random r = new Random();

	public static InspectionTree generateRandomTree(int depth) {
		int inspectionDepth = (depth - r.nextInt(depth - 1)); // -1 to have at
																// least one
																// task
		int taskDepth = depth - inspectionDepth;
		return generateInspectionTree(inspectionDepth, taskDepth);
	}

	public static InspectionTree generateInspectionTree(int idepth, int tdepth) {
		if (idepth <= 1) {
			InspectionTree inspection = new InspectionTree();
			inspection.setAuthor(authors.get(r.nextInt(authors.size())));
			inspection.setName(treeName.get(r.nextInt(treeName.size())));
			inspection.setData(generateTaskTree(tdepth));
			return inspection;
		} else {
			InspectionTree inspection = new InspectionTree();
			inspection.setAuthor(authors.get(r.nextInt(authors.size())));
			inspection.setName(treeName.get(r.nextInt(treeName.size())));
			for (int i = 0; i <= r.nextInt(3) + 1; i++) {
				inspection.addChild(generateInspectionTree(--idepth, tdepth));
			}
			return inspection;
		}
	}

	public static Task generateTaskTree(int depth) {
		if (depth <= 1) {
			Task task = new Task();
			task.setAuthor(authors.get(r.nextInt(authors.size())));
			task.setDescription(descriptions.get(r.nextInt(descriptions.size())));
			task.setTestExecution(null);
			task.setWeight(r.nextInt(100));
			task.setName(taskName.get(r.nextInt(taskName.size())));
			task.setDate(new Date(
					946771200000L + (Math.abs(r.nextLong()) % (70L * 365 * 24
							* 60 * 60 * 1000))));
			for (int i = 0; i <= r.nextInt(5) + 1; i++) {
				switch(r.nextInt(7)){
				case 0:
					task.addChildren(generateBooleanTask());
					break;
				case 1:
					task.addChildren(generateDateTask());
					break;
				case 2:
					task.addChildren(generateFloatTask());
					break;
				case 3:
					task.addChildren(generateIntegerTask());
					break;
				case 4:
					task.addChildren(generateListTask());
					break;
				case 5:
					task.addChildren(generateRangeTask());
					break;
				case 6:
					task.addChildren(generateStringTask());
					break;
				}
			}
			return task;
		} else {
			Task task = new Task();
			task.setAuthor(authors.get(r.nextInt(treeName.size())));
			task.setDescription(descriptions.get(r.nextInt(descriptions.size())));
			task.setTestExecution(null);
			task.setWeight(r.nextInt(100));
			task.setName(taskName.get(r.nextInt(taskName.size())));
			task.setDate(new Date(
					946771200000L + (Math.abs(r.nextLong()) % (70L * 365 * 24
							* 60 * 60 * 1000))));
			for (int i = 0; i <= r.nextInt(2) + 1; i++) {
				task.addChildren(generateTaskTree(--depth));
			}
			return task;
		}
	}

	public static BooleanTask generateBooleanTask() {
		BooleanTask mytask = new BooleanTask();
		mytask.setName(booleanTaskName.get(r.nextInt(booleanTaskName.size())));
		mytask.setAuthor(authors.get(r.nextInt(authors.size())));
		mytask.setDescription(descriptions.get(r.nextInt(descriptions.size())));
		mytask.setTestExecution(null);
		mytask.setWeight(r.nextInt(100));
		mytask.setDate(new Date(946771200000L + (Math.abs(r.nextLong()) % (70L
				* 365 * 24 * 60 * 60 * 1000))));
		return mytask;
	}

	public static DateTask generateDateTask() {
		DateTask mytask = new DateTask();
		mytask.setName(dateTaskName.get(r.nextInt(dateTaskName.size())));
		mytask.setAuthor(authors.get(r.nextInt(authors.size())));
		mytask.setDescription(descriptions.get(r.nextInt(descriptions.size())));
		mytask.setTestExecution(null);
		mytask.setWeight(r.nextInt(100));
		mytask.setDate(new Date(946771200000L + (Math.abs(r.nextLong()) % (70L
				* 365 * 24 * 60 * 60 * 1000))));
		return mytask;
	}

	public static FloatTask generateFloatTask() {
		FloatTask mytask = new FloatTask();
		mytask.setName(floatTaskName.get(r.nextInt(floatTaskName.size())));
		mytask.setAuthor(authors.get(r.nextInt(authors.size())));
		mytask.setDescription(descriptions.get(r.nextInt(descriptions.size())));
		mytask.setTestExecution(null);
		mytask.setWeight(r.nextInt(100));
		mytask.setDate(new Date(946771200000L + (Math.abs(r.nextLong()) % (70L
				* 365 * 24 * 60 * 60 * 1000))));
		return mytask;
	}

	public static IntegerTask generateIntegerTask() {
		IntegerTask mytask = new IntegerTask();
		mytask.setName(integerTaskName.get(r.nextInt(integerTaskName.size())));
		mytask.setAuthor(authors.get(r.nextInt(authors.size())));
		mytask.setDescription(descriptions.get(r.nextInt(descriptions.size())));
		mytask.setTestExecution(null);
		mytask.setWeight(r.nextInt(100));
		mytask.setDate(new Date(946771200000L + (Math.abs(r.nextLong()) % (70L
				* 365 * 24 * 60 * 60 * 1000))));
		return mytask;
	}

	public static ListTask generateListTask() {
		ListTask mytask = new ListTask();
		mytask.setName(listTaskName.get(r.nextInt(listTaskName.size())));
		for (int i = 0; i < listOptionValue.size(); i++) {
			mytask.addOption(new ListOption(listOptionValue.get(i)));
		}
		mytask.setAuthor(authors.get(r.nextInt(authors.size())));
		mytask.setDescription(descriptions.get(r.nextInt(descriptions.size())));
		mytask.setTestExecution(null);
		mytask.setWeight(r.nextInt(100));
		mytask.setDate(new Date(946771200000L + (Math.abs(r.nextLong()) % (70L
				* 365 * 24 * 60 * 60 * 1000))));
		return mytask;
	}

	public static RangeTask generateRangeTask() {
		RangeTask mytask = new RangeTask();
		mytask.setName(rangeTaskName.get(r.nextInt(rangeTaskName.size())));
		mytask.setStart(r.nextFloat()+0.1f);
		mytask.setStop(mytask.getStart() + r.nextFloat());
		mytask.setStep(0.1f);
		mytask.setAuthor(authors.get(r.nextInt(authors.size())));
		mytask.setDescription(descriptions.get(r.nextInt(descriptions.size())));
		mytask.setTestExecution(null);
		mytask.setWeight(r.nextInt(100));
		mytask.setDate(new Date(946771200000L + (Math.abs(r.nextLong()) % (70L
				* 365 * 24 * 60 * 60 * 1000))));
		return mytask;
	}

	public static StringTask generateStringTask() {
		StringTask mytask = new StringTask();
		mytask.setName(stringTaskName.get(r.nextInt(stringTaskName.size())));
		mytask.setAuthor(authors.get(r.nextInt(authors.size())));
		mytask.setDescription(descriptions.get(r.nextInt(descriptions.size())));
		mytask.setTestExecution(null);
		mytask.setWeight(r.nextInt(100));
		mytask.setDate(new Date(946771200000L + (Math.abs(r.nextLong()) % (70L
				* 365 * 24 * 60 * 60 * 1000))));
		return mytask;
	}

}
