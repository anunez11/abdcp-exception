package pe.gtdo.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationMapper  implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		StatusType httpStatus=Response.Status.BAD_REQUEST;
		HashMap<String, Object> jsonError = new HashMap<>();
		jsonError.put("message", prepareMessage(exception));
		jsonError.put("code",httpStatus.getStatusCode());
		return Response.status(httpStatus).entity(jsonError).type(MediaType.APPLICATION_JSON).build();		
	}	
	private String prepareMessage(ConstraintViolationException exception) {
	      List<String> msg = new ArrayList<String>();
	      for (ConstraintViolation<?> cv : exception.getConstraintViolations())  msg.add(cv.getMessage());
	      return String.join(",", msg);
	  }
  }