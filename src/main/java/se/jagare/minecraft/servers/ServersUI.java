package se.jagare.minecraft.servers;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class ServersUI extends UI {

	private Component filter;
	private Component newContact;
	private Navigator navigator;

	@Override
	protected void init(VaadinRequest request) {
		configureComponents();
	}

	private void configureComponents() {
		/*
		 * HorizontalLayout actions = new HorizontalLayout(filter, newContact);
		 * actions.setWidth("100%"); filter.setWidth("100%");
		 * actions.setExpandRatio(filter, 1);
		 */

		// Create a navigator to control the views
		// navigator = new Navigator(this, this);
		// Create and register the views
		// navigator.addView("", new ServerListView());

		VerticalLayout left = new ServerListView();

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
