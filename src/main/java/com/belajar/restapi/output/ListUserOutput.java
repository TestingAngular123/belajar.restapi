package com.belajar.restapi.output;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ListUserOutput {
	private Integer totalRows;
	private ErrorDetail info;
	private List<UserOutput> content;
	
	public ListUserOutput(List<UserOutput> content) {

		this.content = content;
	}
	
	public ListUserOutput( UserOutput content) {
		List<UserOutput> listUserOutput = new ArrayList<UserOutput>();
		listUserOutput.add(content);
		this.content = listUserOutput;
	}

}
