package ResponseDTO;

import lombok.Data;

@Data
public class ResponseExceptionDTO {
	
	
	private String messageCode;
	private String messageDescription;
	
	
	public ResponseExceptionDTO(String messageCode, String messageDescription) {
		super();
		this.messageCode = messageCode;
		this.messageDescription = messageDescription;
	}
	
	
	

}
