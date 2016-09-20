package se.jagare.minecraft.service;

import java.net.InetSocketAddress;

import com.google.gson.Gson;

import se.jagare.minecraft.StatusResponseFactory;
import se.jagare.minecraft.dao.StatusResponse;
import se.jagare.minecraft.dao.StatusResponseImpl;
import se.jagare.minecraft.exception.MinecraftServerException;
import se.jagare.minecraft.message.HandshakeMessage;
import se.jagare.minecraft.message.PingMessage;
import se.jagare.minecraft.message.PingResponseMessage;
import se.jagare.minecraft.message.StatusRequestMessage;
import se.jagare.minecraft.message.StatusResponseMessage;
import se.jagare.minecraft.processor.MinecraftMessageProcessor;

/**
 * 
 */
public class ServerPingService {

	private InetSocketAddress host;
	private int timeout = 7000;
	private Gson gson = new Gson();

	private MinecraftMessageProcessor processor;

	public ServerPingService(InetSocketAddress host) {
		processor = new MinecraftMessageProcessor(host);
		this.host = host;
	}

	void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	int getTimeout() {
		return this.timeout;
	}

	public StatusResponse fetchData() throws MinecraftServerException {

		StatusResponse response = new StatusResponseImpl();
		try {
			processor.initialize();
			processor.sendMessage(new HandshakeMessage(host));

			// Write Request
			processor.sendMessage(new StatusRequestMessage());

			String json = (String) processor.recieveMessage(StatusResponseMessage.class);

			long now = System.currentTimeMillis();
			processor.sendMessage(new PingMessage(now));

			long pingtime = (long) processor.recieveMessage(PingResponseMessage.class);

			response = StatusResponseFactory.createServerResponse(json);

			response.setTime((int) (now - pingtime));
			response.setOnline(true);

		} catch (Exception e) {
			throw new MinecraftServerException("Could not get server status.", e);
		} finally {
			processor.close();
		}

		return response;
	}

	public static void main(String[] args) {
		ServerPingService query = new ServerPingService(new InetSocketAddress("access.jagare-lilja.se", 25565));
		// ServerPingService query = new ServerPingService(new
		// InetSocketAddress("play.vcprison.com", 25565));

		StatusResponse status = null;
		try {
			status = query.fetchData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (status.isOnline())
			System.out.println(status.toString());
		else
			System.out.println("Offline");

	}
}
