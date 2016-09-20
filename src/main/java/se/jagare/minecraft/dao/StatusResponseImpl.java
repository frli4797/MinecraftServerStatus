package se.jagare.minecraft.dao;

public class StatusResponseImpl implements StatusResponse {

	private boolean online = false;
	private Description description;
	private Players players;
	private Version version;
	private String favicon;
	private int time;
	private int size;

	/*
	 * (non-Javadoc)
	 * 
	 * @see se.jagare.minecraft.dao.IStatusResponse#isOnline()
	 */
	@Override
	public boolean isOnline() {
		return online;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see se.jagare.minecraft.dao.IStatusResponse#setOnline(boolean)
	 */
	@Override
	public void setOnline(boolean online) {
		this.online = online;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see se.jagare.minecraft.dao.IStatusResponse#getDescription()
	 */
	@Override
	public Description getDescription() {
		return description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see se.jagare.minecraft.dao.IStatusResponse#getPlayers()
	 */
	@Override
	public Players getPlayers() {
		return players;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see se.jagare.minecraft.dao.IStatusResponse#getVersion()
	 */
	@Override
	public Version getVersion() {
		return version;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see se.jagare.minecraft.dao.IStatusResponse#getFavicon()
	 */
	@Override
	public String getFavicon() {
		return favicon;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see se.jagare.minecraft.dao.IStatusResponse#getTime()
	 */
	@Override
	public int getTime() {
		return time;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see se.jagare.minecraft.dao.IStatusResponse#setTime(int)
	 */
	@Override
	public void setTime(int time) {
		this.time = time;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see se.jagare.minecraft.dao.IStatusResponse#getSize()
	 */
	@Override
	public int getSize() {
		return size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see se.jagare.minecraft.dao.IStatusResponse#setSize(int)
	 */
	@Override
	public void setSize(int size) {
		this.size = size;
	}

	public class Chat {
		private String text;
		private String translate;

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getTranslate() {
			return translate;
		}

		public void setTranslate(String translate) {
			this.translate = translate;
		}

		public String toString() {
			return this.text;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see se.jagare.minecraft.dao.IStatusResponse#toString()
	 */
	@Override
	public String toString() {
		return "StatusResponse [description=" + description + ", players=" + players + ", version=" + version
				+ ", favicon=" + (favicon == null ? "null" : "available") + ", time=" + time + "]";
	}

}