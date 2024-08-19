package com.testWebClient.testWebClient;

import lombok.Data;
import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;


@Builder
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY) // corrige el error seriabizable
public class ModelBeers {
	
	private  Integer id;
	private  String uid;
	private String brand;
	private String name;
	private String style;
	private String hop;
	private String yeast;
	private String malts;
	private String ibu;
	private String alcohol;
	private String blg;
	private String encritp;
	
	

}



/*
 * {
   "id":520,
   "uid":"fa777249-5292-485e-9a4f-430af53202c7",
   "brand":"Delirium",
   "name":"Delirium Noctorum",
   "style":"Dark Lager",
   "hop":"Chelan",
   "yeast":"2112 - California Lager",
   "malts":"Munich",
   "ibu":"35 IBU",
   "alcohol":"5.0%",
   "blg":"16.6°Blg"
}
 */
