package edu.lab.servlet;

import edu.lab.repository.MenuRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {


    private final MenuRepository repository = MenuRepository.getInternal();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("items", repository.getItems());
        req.getRequestDispatcher("profile.jsp").forward(req, resp);
    }
}
