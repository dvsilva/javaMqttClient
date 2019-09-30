package br.com.dvs;

public class Publisher {

	public static void main(String[] args) throws InterruptedException {
		MqttController controller = new MqttController();
		System.out.println("Publicando");
		controller.publish("/danyllo/temperatura", "21");
		
		Thread.sleep(3000);

		System.out.println("Publicando");
		controller.publish("/danyllo/temperatura", "26");
	}

}
