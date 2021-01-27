package com.jinxiu.demo.kafkatest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class MyProducer {
	public static void main(String[] args) {
		Producer<String,String> p=null;
		try{
			Properties properties = new Properties();
			properties.load(new FileInputStream(new File("producer.properties")));
			
			
			ProducerConfig config = new ProducerConfig(properties);
			
			
			p = new Producer<String, String>(config);
			
			
			int i=0;
			while(true){
				KeyedMessage<String, String> km = new KeyedMessage<String, String>("test-topicttt","this is a sample" + i);
				p.send(km);
				i++;
//				Thread.sleep(2000);
				System.out.println(i);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(p != null){
				p.close();
			}
		}
	}
}
