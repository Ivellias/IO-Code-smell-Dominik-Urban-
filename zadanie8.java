/*Krotki opis co ma program robic:
Program kontruluje cos pokroju rice-cooker'a (taka maszynka do gotowania roznych rzeczy)
Co sekunde ma sprawdzic czy nasza "kuchenka" jest przegrzana. 
Sluzy do tego metoda isOverHeated() z klasy heatSensor (nie mamy tu implementacji, ale wazne ze zwraca wartosci typu boolean).
Jesli sie tak stanie to program wylaczy zasilanie i wlaczy alarm (odpowiednio powerSupply.turnOff() i alarm.turnOn()).
Poprzez moistureSensor.getMoisture() program sprawdza wilgotnosc i jesli jest mnijesza niz 60 to ustawia temperature na 50 stopni. 
Odbywa sie to rowniez co sekunde.
Po refaktoryzacji ma byc latwo dodac kolejne zadanie wykonywane co sekunde.
Uprzedzajac pytania: for(;;) dziala jak while(1).
*/

class Scheduler extends Thread {
	Alarm alarm;
	HeatSensor heatSensor;
	PowerSupply powerSupply;
	MoistureSensor moistureSensor;
	Heater heater;
	public void run() {
		for (;;) {
			Thread.sleep(1000);
			//check if it is overheated.
			if (heatSensor.isOverHeated()) {
				powerSupply.turnOff();
				alarm.turnOn();
			}
			//check if the rice is cooked.
			if (moistureSensor.getMoisture()<60) {
				heater.setTemperature(50);
			}
		}
	}
}