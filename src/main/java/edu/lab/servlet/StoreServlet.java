package edu.lab.servlet;

import edu.lab.repository.MenuRepository;
import edu.lab.repository.TableRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/store")
public class StoreServlet extends HttpServlet {
    private final MenuRepository menuRepository = MenuRepository.getInternal();
    private final TableRepository tableRepository = TableRepository.getInternal();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("items", menuRepository.getItems());

        req.setAttribute("table", tableRepository.getTable());
        req.getRequestDispatcher("store.jsp").forward(req, resp);
    }
}
