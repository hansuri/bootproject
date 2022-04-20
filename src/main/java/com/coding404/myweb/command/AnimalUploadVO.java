package com.coding404.myweb.command;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnimalUploadVO {

	private Integer UPLOAD_NO;
	private String FILENAME;
	private String FILEPATH;
	private String UUID;
	private LocalDateTime REGDATE;
	private Integer ADMIN_NUM;
	
}
