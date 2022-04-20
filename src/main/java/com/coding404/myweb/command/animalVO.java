package com.coding404.myweb.command;

import java.time.LocalDateTime;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class animalVO {
	
	private Integer ANIMAL_NUM;
	private String ANIMAL_TYPE;
	private char ANIMAL_SIZE;
	private String ANIMAL_NAME;
	private char ANIMAL_GENDER;
	private Integer ANIMAL_AGE;
	private String ANIMAL_CONTENT;
	private char ANIMAL_DISEASE;
	private String ANIMAL_NEUTRAL;
	private Integer ANIMAL_COST;
	private Integer ANIMAL_TIME;
	
	private Integer ADMIN_NUM;
	private Integer LIST_NUM;
	private String ANIMAL_FILENAME;
	private String ANIMAL_PATH;
	private String ANIMAL_UUID;
	
	private String ANIMAL_DATE;
	
	
}
