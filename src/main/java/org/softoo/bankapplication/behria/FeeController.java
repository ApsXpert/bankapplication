package org.softoo.bankapplication.behria;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.ToString;

@RestController
@RequestMapping("api/v1/feee")
public class FeeController {

	@PostMapping
	public ResponseEntity<FeeResponseDTO> acceptFee(@RequestBody FeeDTO dto) {
		System.out.println("Call received ################");
		System.out.println(dto.toString());
		// 1) bank will check account number against tokenNumber
		// 2) Add the amount in account and transaction table
		FeeResponseDTO dDto = new FeeResponseDTO();
		dDto.setStudentId(dto.getStudentId());
		dDto.setSuccess(true);
		return new ResponseEntity<FeeController.FeeResponseDTO>(dDto, HttpStatus.OK);
	}
	
	@Data
	@ToString
	public static class FeeDTO {
		private String studentId;
		private String tokenNumber;
		private int amount;
	}
	
	@Data
	public static class FeeResponseDTO {
		private String studentId;
		private boolean success;
	}
	
}
