interface Task{
	public void doTask();
}
class CheckIfOverHeated implements Task{
	Alarm alarm;
	HeatSensor heatSensor;
	PowerSupply powerSupply;
	public void doTask(){
		if(heatSensor.isOverHeated()){
			powerSupply.turnOff();
			alarm.turnOn();
		}
	}
}
class CheckMoisture implements Task{
	MoistureSensor moistureSensor;
	Heater heater;
	public void doTask(){
		if(moistureSensor.getMoisture()<60){
			heater.setTemperature(50);
		}
	}
}

class Scheduler extends Thread {
	Task[] tasksList;
	public void addTask(Task task){
		//fukcja dodajaca task do tasksList
	}
	Scheduler(){
		addTask(new CheckIfOverHeated());
		addTask(new CheckMoisture());
	}
	public void run() {
		for (;;) {
			Thread.sleep(1000);
			for(int i=0;i<tasksList.length;i++){
				tasksList[i].doTask();
			}
		}
	}
}