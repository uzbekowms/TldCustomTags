package edu.lab.servlet;

import edu.lab.repository.MenuRepository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

    private final MenuRepository repository = MenuRepository.getInternal();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("items", repository.getItems());
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
