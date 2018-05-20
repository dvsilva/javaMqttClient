package br.com.dvs;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttController implements MqttCallback {

	private static String server = "tcp://iot.eclipse.org:1883";

	public void publish(String topic, String message){
		
		try {
			String clientId = MqttAsyncClient.generateClientId();
	       
			//System.out.println("pub cliid: " + clientId + " - " + topic);
			MqttClient client = new MqttClient(server, clientId);
	        client.connect();
	        
	        MqttMessage mqttMessage = new MqttMessage();
	        mqttMessage.setPayload(message.getBytes());
	        client.publish(topic, mqttMessage);
	        
	        client.disconnect();
	        System.out.println("publish finished");
	    } 
		catch (MqttException e) {
	        e.printStackTrace();
	    }
	}
	
	public void connectionLost(Throwable cause) {
	    // TODO Auto-generated method stub
	}

	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("Rcebida messagem no topico " + topic + ": " + message);
	}

	public void deliveryComplete(IMqttDeliveryToken token) {
	    // TODO Auto-generated method stub
	}
	
	public void subscribe(String topic){
		
		try {
			String clientId = MqttAsyncClient.generateClientId();
			//System.out.println("sub cliid: " + clientId + " - " + topic);
			
			MqttClient client = new MqttClient(server, clientId);
	        client.connect();
	        client.setCallback(this);
	        client.subscribe(topic);
	        
	        System.out.println("subscribe finished");
	    } 
		catch (MqttException e) {
	        e.printStackTrace();
	    }
	}
}