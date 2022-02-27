package booking.dto;

import lombok.Data;

@Data
public class ClientDto {
	private Long clientId;
	private String email;
	private String pwd;
	private String firstName;
	private String lastName;
	private String phone;
}
