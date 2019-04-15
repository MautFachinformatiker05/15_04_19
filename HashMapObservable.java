package application;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
/*from   www  .  j a  v a  2  s . co  m*/
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;
import persUtils.Stopwatch;

public class HashMapObservable {
	static  Map<String, Long> telNameNr = new HashMap<String, Long>();
	static   ObservableMap<String, Long> observableTelNameNr = FXCollections
			.observableMap(telNameNr);

	private static void fuelleHashMap() {
		for ( int i = 0; i < 60000; i++) {
			String name ="name"+ i;
			System.out.println("Key in Schleife: " +name);
			observableTelNameNr.put(name, i * 5L );

		}
	}

	public static void nachschlagenHashMap(String name) {
		long tel = (long) telNameNr.get(name);
		System.out.println("Telefonnummer von " +name+ ": " +tel);
	}

	public static void timerNachschlagenMap() {

		Stopwatch m = new Stopwatch ();
		m.start();
		for (int j = 0; j < 20000; j++){
			telNameNr.get("name" +j);

		}
		m.stop();

		double time = m.time();

		System.out.printf("Durchsuchen der Hash Map nach einem Key dauert %3.10f Sekunden. \n", time);
	}


	static String [] array = new String [60000];
	static void fuelleArray(){
		for ( int i = 0; i < 60000; i++) {
			String name ="name"+ i;
			array[i] = name;
		}
	}

	public static void timerNachschlagenArray() {
		Stopwatch s = new Stopwatch();

		s.start();
		for (int j = 0; j < 20000; j++){
			String key = "name" +j;
			for (int m = 0; m < array.length; m++){
				if ( array[m].equals(key)){
					s.stop();
				}
			}
		}
		double time = s.time();

		System.out.printf("Durchsuchen des Arrays nach einem Key dauert %3.10f Sekunden.", time);
	}

	public static void main(String[] args) {

		observableTelNameNr.addListener(new MapChangeListener() {
			@Override
			public void onChanged(MapChangeListener.Change change) {
				System.out.println("change! ");
			}
		});

		fuelleHashMap();
		timerNachschlagenMap();

		fuelleArray();
		timerNachschlagenArray();

	}


}