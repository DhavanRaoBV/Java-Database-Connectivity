package model;

public class Todo {
	private int id;
	private String task;
	private String name;
	private String status;
	
	public Todo() {
		
	}
	
	public Todo(int id, String task, String name, String status) {
		super();
		this.id = id;
		this.task = task;
		this.name = name;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", task=" + task + ", name=" + name + ", status=" + status + "]";
	}
	
	
	
	

}