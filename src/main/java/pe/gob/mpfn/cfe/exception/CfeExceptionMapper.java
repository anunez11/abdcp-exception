package pe.gob.mpfn.cfe.exception;

import java.util.HashMap;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CfeExceptionMapper implements ExceptionMapper<CfeException>{

	@Override
	public Response toResponse(CfeException e) {
	//	e.printStackTrace();
		
		HashMap<String, Object> jsonError = new HashMap<>();
		jsonError.put("message", e.getMessage());
		jsonError.put("code", e.getStatus().getStatusCode());
		
		return Response.status(e.getStatus()).entity(jsonError).type(MediaType.APPLICATION_JSON).build();
	}
}
