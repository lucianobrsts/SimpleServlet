package simpleservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/meuServlet")
public class MeuServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<body>");
		writer.write("<h1>");
		writer.write("Primeiro Servlet :) ");
		writer.write(String.format(" Ultimo nome foi %s", req.getSession().getAttribute("ultimoNome")));
		writer.write("</hF1>");
		writer.write("</body>");
		writer.write("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		req.getSession().setAttribute("ultimoNome", nome);
		PrintWriter writer = resp.getWriter();
		writer.write("<html>");
		writer.write("<body>");
		writer.write("<h1>");
		writer.write(String.format("Bom dia %s!", nome));
		writer.write("</hF1>");
		writer.write("</body>");
		writer.write("</html>");
	}
}
