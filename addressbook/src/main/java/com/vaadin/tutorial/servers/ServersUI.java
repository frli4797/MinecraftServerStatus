package com.vaadin.tutorial.servers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.tutorial.addressbook.backend.Server;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ServersUI extends UI {

	private Grid serverList = new Grid();
	private Component filter;
	private Component newContact;
	private List<Server> servers;

	@Override
	protected void init(VaadinRequest request) {
		configureComponents();
		buildLayout();
	}

	private void initTestData() {
		Server s = new Server("Description");
		s.setId(111);
		s.setMaxPlayers(10);
		s.setOnline(true);
		s.setOnlinePlayers(3);
		servers = new ArrayList<Server>();
		servers.add(s);
	}

	private void buildLayout() {
		initTestData();
		serverList.setContainerDataSource(new BeanItemContainer<>(Server.class, servers));
		serverList.setColumnOrder("online", "description", "onlinePlayers", "maxPlayers");
		serverList.removeColumn("version");
		serverList.removeColumn("favicon");
		serverList.removeColumn("players");
		serverList.removeColumn("id");
		serverList.setSelectionMode(Grid.SelectionMode.SINGLE);

	}

	private void configureComponents() {
		/*
		 * HorizontalLayout actions = new HorizontalLayout(filter, newContact);
		 * actions.setWidth("100%"); filter.setWidth("100%");
		 * actions.setExpandRatio(filter, 1);
		 */

		VerticalLayout left = new VerticalLayout(serverList);
		left.setSizeFull();
		serverList.setSizeFull();
		left.setExpandRatio(serverList, 1);

		HorizontalLayout mainLayout = new HorizontalLayout(left);
		mainLayout.setSizeFull();
		mainLayout.setExpandRatio(left, 1);

		// Split and allow resizing
		setContent(mainLayout);
	}

	/*
	 * Deployed as a Servlet or Portlet.
	 *
	 * You can specify additional servlet parameters like the URI and UI class
	 * name and turn on production mode when you have finished developing the
	 * application.
	 */
	@WebServlet(urlPatterns = "/*")
	@VaadinServletConfiguration(ui = ServersUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}

}
