package br.com.dvs;

public class Subscriber {

	public static void main(String[] args) throws InterruptedException {
		MqttController controller = new MqttController();
		System.out.println("Realizando subscribe");
		controller.subscribe("/danyllo/temperatura");
	}

}
