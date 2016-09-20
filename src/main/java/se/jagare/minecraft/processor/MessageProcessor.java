package se.jagare.minecraft.processor;

import java.io.IOException;

import se.jagare.minecraft.message.Message;

public interface MessageProcessor {

	public void sendMessage(Message mess) throws IOException;

	public Object recieveMessage(Class<?> clazz) throws IOException;

}
