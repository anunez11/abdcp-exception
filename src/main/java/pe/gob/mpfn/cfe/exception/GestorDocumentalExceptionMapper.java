package pe.gob.mpfn.cfe.exception;

import java.util.HashMap;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GestorDocumentalExceptionMapper implements ExceptionMapper<GestorDocumentalException>{

	@Override
	public Response toResponse(GestorDocumentalException e) {
		e.printStackTrace();
		
		HashMap<String, Object> jsonError = new HashMap<>();
		jsonError.put("message", e.getMessage());
		return Response.serverError().entity(jsonError).type(MediaType.APPLICATION_JSON).build();
	}
	

}
