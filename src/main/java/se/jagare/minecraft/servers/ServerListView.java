package se.jagare.minecraft.servers;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import se.jagare.minecraft.model.Server;
import se.jagare.minecraft.service.ServerListPingService;

@DesignRoot
public class ServerListView extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Grid serverGrid = new Grid();
	private List<Server> servers = new ArrayList<Server>();
	private ServerListPingService service = new ServerListPingService();
	private Button refreshButton = new Button("Refresh");
	private FormLayout detailsLayout = new FormLayout();

	public ServerListView() {
		initTestData();

		addComponent(refreshButton);
		refreshButton.addClickListener(e -> refreshServers());

		addComponent(serverGrid);
		initiateGrid();
		setExpandRatio(serverGrid, 1);

		addComponent(detailsLayout, 2);
		detailsLayout.setVisible(false);
		// detailsLayout.set

		setSizeFull();
		refreshServers();

	}

	private void initiateGrid() {
		serverGrid.setContainerDataSource(new BeanItemContainer<>(Server.class, servers));
		serverGrid.setColumnOrder("host", "port", "online", "description", "onlinePlayers", "maxPlayers");
		serverGrid.getColumn("port").setMaximumWidth(70).setHeaderCaption("PORT");
		serverGrid.getColumn("online").setMaximumWidth(70).setHeaderCaption("UP");
		serverGrid.getColumn("onlinePlayers").setMaximumWidth(70).setHeaderCaption("ONLINE");
		serverGrid.getColumn("maxPlayers").setMaximumWidth(70).setHeaderCaption("MAX");

		serverGrid.removeColumn("version");
		serverGrid.removeColumn("favicon");
		serverGrid.removeColumn("players");
		serverGrid.removeColumn("id");
		serverGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
		serverGrid.setSizeFull();

		serverGrid.addSelectionListener(e -> showDetails((Server) serverGrid.getSelectedRow()));
	}

	private void showDetails(Server selectedRow) {
		if (selectedRow != null) {
			TextField tf = new TextField("Host");
			tf.setValue(selectedRow.getHost());
			detailsLayout.addComponent(tf);

		}
		detailsLayout.setVisible(selectedRow != null);
	}

	private void initTestData() {
		Server s = new Server("Description", "access.jagare-lilja.se", 25565);
		servers.add(s);
	}

	private void refreshServers() {
		service.pingServers(servers);
		serverGrid.setContainerDataSource(new BeanItemContainer<>(Server.class, servers));
	}

	@Override
	public ServersUI getUI() {
		return (ServersUI) super.getUI();
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}

}
