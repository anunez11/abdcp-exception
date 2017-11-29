package pe.gob.mpfn.cfe.exception;

import java.util.HashMap;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionMapperProvider implements ExceptionMapper<Exception>{

	@Override
	public Response toResponse(Exception e) {
		e.printStackTrace();
		
		HashMap<String, Object> jsonError = new HashMap<>();
		jsonError.put("message", e.getMessage());
		jsonError.put("code", Status.INTERNAL_SERVER_ERROR.getStatusCode());
		return Response.serverError().entity(jsonError).type(MediaType.APPLICATION_JSON).build();
	}
}
