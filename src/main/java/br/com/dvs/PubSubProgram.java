package br.com.dvs;

public class PubSubProgram {

	public static void main(String[] args) throws InterruptedException {
		MqttController controller = new MqttController();
		System.out.println("Realizando subscribe");
		controller.subscribe("/danyllo/temperatura");
		
		System.out.println("Publicando");
		controller.publish("/danyllo/temperatura", "21");
		
		Thread.sleep(3000);

		System.out.println("Publicando");
		controller.publish("/danyllo/temperatura", "26");

	}

}
