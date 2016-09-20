package se.jagare.minecraft.service;

import java.net.InetSocketAddress;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.jagare.minecraft.dao.StatusResponse;
import se.jagare.minecraft.model.Server;

public class ServerListPingService {

	private static Logger LOG = LoggerFactory.getLogger(ServerListPingService.class);

	public void init() {

	}

	public Collection<Server> pingServers(Collection<Server> serverList) {
		for (Server server : serverList) {
			ServerPingService query = new ServerPingService(new InetSocketAddress(server.getHost(), server.getPort()));
			StatusResponse status = null;
			try {
				status = query.fetchData();
				LOG.debug("Querying ", status);
				server = populateServer(server, status);
			} catch (Exception e) {
				LOG.error("Error pinging " + server.getHost(), e);
				e.printStackTrace();
			}
		}

		return serverList;

	}

	private Server populateServer(Server pServer, StatusResponse result) {
		pServer.setDescription(result.getDescription().getText());
		pServer.setMaxPlayers(result.getPlayers().getMax());
		pServer.setOnlinePlayers(result.getPlayers().getOnline());
		pServer.setOnline(result.isOnline());

		return pServer;
	}

}
