package com.wm.ECartPGPTeamTen.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * r0m09yu
 */

@Data
@Setter
@Getter
@Document(collection = "promotions")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Promotions {

	@Id
	@MongoId(FieldType.OBJECT_ID)
	private String  _id;
	
	private Integer promotionID;		
	private String promotionDescription;	
	private String promotionType;			
	private String startDate;				
	private String endDate;				
	private String status;					
	private String valueChange;			
	private Integer noOfPromo;				

}
