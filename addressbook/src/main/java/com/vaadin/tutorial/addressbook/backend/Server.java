package com.vaadin.tutorial.addressbook.backend;

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

	public Server(String desc) {
		this.description = desc;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getDescription() {
		return description;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public String getVersion() {
		return version;
	}

	public String getFavicon() {
		return favicon;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public int getOnlinePlayers() {
		return onlinePlayers;
	}

	public void setOnlinePlayers(int onlinePlayers) {
		this.onlinePlayers = onlinePlayers;
	}

}
