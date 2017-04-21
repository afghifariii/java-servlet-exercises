package entity;

import java.util.List;

public class DataMessage {

	private List<Student> data;
	private String message;

	public DataMessage(List<Student> data, String message) {
		super();
		this.data = data;
		this.message = message;
	}
}
