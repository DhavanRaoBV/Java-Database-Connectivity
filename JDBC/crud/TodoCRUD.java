package crud;

import java.util.List;
import java.util.Scanner;



import dao.TodoDAO;
import dao.TodoDAOImpl;
import model.Todo;

public class TodoCRUD {
	public static void main(String[] args) {

		TodoDAO dao = new TodoDAOImpl();

		Scanner s = new Scanner(System.in);

		int doFlag = -1;

		do {
			System.out.println("1.Insert\n2.Update\n3.Delete\n4.View All tasks\n5.Search a task");
			int ch = s.nextInt();
			s.nextLine();
			switch (ch) {
			case 1:

				System.out.println("Enter Task ID, Task, Name and Status");
				Todo todo = new Todo(s.nextInt(), s.nextLine()+s.nextLine(),s.nextLine(), s.nextLine());
				
				
				int res = dao.insert(todo);

				System.out.println("Rows inserted=" + res);

				break;

			case 2:
				System.out.println("Enter id of the Task to be updated");
				int id = s.nextInt();
				s.nextLine();
				System.out.println("Enter new Task, Name, Status of the Task to be updated");

				res = dao.update(new Todo(id,s.nextLine(), s.nextLine(), s.nextLine()));

				System.out.println("Rows updated=" + res);
				break;

			case 3:
				System.out.println("Enter id of the Task to be deleted");
				id = s.nextInt();
				s.nextLine();
				res = dao.delete(id);
				System.out.println("Rows deleted=" + res);
				break;

			case 4:

				List<Todo> list = dao.view();

				for (Todo t : list) {
					System.out.println(t);
				}

				break;

			case 5:
				System.out.println("Enter id of the Task to be searched");
				id = s.nextInt();
				s.nextLine();
				todo = dao.view(id);
				System.out.println(todo);
				break;

			default:
				System.out.println("Invalid Input Choice");
			}

			System.out.println("RE RUN ? 1.YES\t2.NO");
			doFlag = s.nextInt();
			s.nextLine();

		} while (doFlag == 1);

	}

}

