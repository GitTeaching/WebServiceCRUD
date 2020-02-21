package org.soa.ws.tp;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WebServiceCRUD {

	@WebMethod
	public String readCategProduct(String id);
}
