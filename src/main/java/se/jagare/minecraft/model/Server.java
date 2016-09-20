package se.jagare.minecraft.model;

import java.util.ArrayList;
import java.util.List;

public class Server {

	private long id;
	private boolean online = false;
	private String description;
	private List<Player> players = new ArrayList<Player>();
	private String version;
	private String favicon;
	private int maxPlayers;
	private int onlinePlayers;
	private String host;
	private int port;

	public Server(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public Server(String desc, String host, int port) {
		this(host, port);
		this.description = desc;

	}

	public String getDescription() {
		return description;
	}

	public String getFavicon() {
		return favicon;
	}

	public String getHost() {
		return host;
	}

	public long getId() {
		return id;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public int getOnlinePlayers() {
		return onlinePlayers;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public int getPort() {
		return port;
	}

	public String getVersion() {
		return version;
	}

	public boolean isOnline() {
		return online;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public void setOnlinePlayers(int onlinePlayers) {
		this.onlinePlayers = onlinePlayers;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setDescription(String description) {
		this.description = description;

	}

}
