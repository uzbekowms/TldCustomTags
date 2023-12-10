package edu.lab.servlet;

import edu.lab.repository.MenuRepository;
import edu.lab.repository.TableRepository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
