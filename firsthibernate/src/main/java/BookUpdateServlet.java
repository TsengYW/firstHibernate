

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.Book;

/**
 * Servlet implementation class BookUpdateServlet
 */
@WebServlet("/BookUpdateServlet")
public class BookUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory sessionFactory=null;
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings hibernate.cfg.xml											
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Book book = new Book();
//		book.setId(2);
//		book.setTitle("Effective Python");
//		book.setAuthor("Joshua Bloch");
//		book.setPrice(32.59f);
		book.setId(1);
		book.setTitle("Ultimate Java Programming");
		book.setAuthor("Nam Ha Minh");
		book.setPrice(19.99f);
		session.update(book);
		session.getTransaction().commit();
		session.close();
		response.getWriter().append("Hibernate Object Updated");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
