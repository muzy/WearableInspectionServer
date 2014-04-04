package net.muszytowski.WearableInspectionServer;

import java.util.ArrayList;
import java.util.Random;

import net.muszytowski.WearableInspectionServer.items.InspectionTree;

public class SampleGenerator {

	@SuppressWarnings("serial")
	ArrayList<String> authors = new ArrayList<String>(){{
	    add("John Doe");
	    add("Max Mustermann");
	    add("Mister X");
	    add("Maria Musterfrau");
	    add("Werner Wearable");
	}};
	
	@SuppressWarnings("serial")
	ArrayList<String> treeName = new ArrayList<String>(){{
	    add("Boing");
	    add("Auto");
	    add("VW");
	    add("Audi");
	}};
	
	@SuppressWarnings("serial")
	ArrayList<String> descriptions = new ArrayList<String>(){{
	    add("Eine Aufgabenbeschreibung");
	    add("Noch eine Beschreibung ohne Sinn");
	    add("Lorem Ipsum Beschreiberung der Aufgaberung Lorem Ipsum");
	}};
	
	@SuppressWarnings("serial")
	ArrayList<String> booleanTaskName = new ArrayList<String>(){{
	    add("Funktioniert noch");
	    add("Ist kaputt");
	    add("Ding aufgeschraubt");
	    add("Nippel durch die Lasche gezogen");
	}};
	@SuppressWarnings("serial")
	ArrayList<String> dateTaskName = new ArrayList<String>(){{
	    add("Ablaufdatum");
	    add("Nächster TÜV");
	    add("Geburtsdatum des Fahrers");
	}};
	@SuppressWarnings("serial")
	ArrayList<String> floatTaskName = new ArrayList<String>(){{
	    add("Alter der Mondrakete");
	    add("Siebenundreißig Sonderzeichen minus Zwei Komma Fünf");
	    add("Drei geteilt durch Fünf");
	}};
	
	@SuppressWarnings("serial")
	ArrayList<String> integerTaskName = new ArrayList<String>(){{
	    add("Schneewitchen und die X Zwerge");
	    add("Sieben mal Sieben ergibt");
	}};
	
	@SuppressWarnings("serial")
	ArrayList<String> ListTaskName = new ArrayList<String>(){{
	    add("Schneewitchen und die X Zwerge");
	    add("Sieben mal Sieben ergibt");
	}};
	
	@SuppressWarnings("serial")
	ArrayList<String> ListOptionValue = new ArrayList<String>(){{
	    add("Dies ist eine Option");
	    add("Und noch eine");
	    add("Eine haben wir noch");
	}};
	
	@SuppressWarnings("serial")
	ArrayList<String> rangeTaskName = new ArrayList<String>(){{
	    add("Eine Zahl zwischen zwei Werten");
	    add("Zwischen einem Minimum und Maximum");
	    add("Achte auf die Stufe!");
	}};
	
	@SuppressWarnings("serial")
	ArrayList<String> stringTaskName = new ArrayList<String>(){{
	    add("Hier ein Kennzeichen bitte");
	    add("Name des Kunden angeben");
	    add("Fehlerbeschreibung angeben");
	}};
	
	public static  Random r = new Random();

	public static InspectionTree generateRandomTree(int depth){
		int inspectionDepth = (depth - r.nextInt(depth-1)); // -1 to have at least one task
		int taskDepth = depth - inspectionDepth;
		
		InspectionTree resultTree = new InspectionTree();
		
		for(int i = 0; i<= inspectionDepth; i++){
			
		}
		return null;
	}
	
	
}
