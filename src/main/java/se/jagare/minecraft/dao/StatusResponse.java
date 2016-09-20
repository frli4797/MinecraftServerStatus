package se.jagare.minecraft.dao;

public interface StatusResponse {

	boolean isOnline();

	void setOnline(boolean online);

	Description getDescription();

	Players getPlayers();

	Version getVersion();

	String getFavicon();

	int getTime();

	void setTime(int time);

	int getSize();

	void setSize(int size);

	String toString();

}