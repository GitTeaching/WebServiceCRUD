package org.soa.ws.tp;

import javax.xml.ws.Endpoint;

public class WebServiceCRUDPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:1234/crud", new WebServiceCRUDImpl());
	}

}
