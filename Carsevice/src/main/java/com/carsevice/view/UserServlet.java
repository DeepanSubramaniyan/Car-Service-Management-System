package com.carsevice.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.carservice.dao.Userdao;
import com.carservice.model.User;

/**
 * Servlet implementation class UserServlet
 */

@WebServlet("/")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Userdao userDAO;

    public void init() {
        userDAO = new Userdao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        try {
            List<User> listUser = userDAO.selectAllUsers();
            request.setAttribute("listUser", listUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
            dispatcher.forward(request, response);
        } finally {
            // Close any necessary resources here (if applicable)
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            User existingUser = userDAO.selectUser(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
            request.setAttribute("user", existingUser);
            dispatcher.forward(request, response);
        } finally {
            // Close any necessary resources here (if applicable)
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        try {
            String name = request.getParameter("name");
            String vehiclenumber = request.getParameter("vehicleNumber");
            String vehiclemodel = request.getParameter("vehicleModel");
            String phone = request.getParameter("phone");
            String date = request.getParameter("date");
            String pickUpDate = request.getParameter("pickUpDate");
            String serviceType = request.getParameter("serviceType");
            User newUser = new User(name, vehiclenumber, vehiclemodel, phone, date, pickUpDate, serviceType);
            userDAO.insertUser(newUser);
            response.sendRedirect("list");
        } finally {
            // Close any necessary resources here (if applicable)
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String vehiclenumber = request.getParameter("vehicleNumber");
            String vehiclemodel = request.getParameter("vehicleModel");
            String phone = request.getParameter("phone");
            String date = request.getParameter("date");
            String pickUpDate = request.getParameter("pickUpDate");
            String serviceType = request.getParameter("serviceType");
            User updatedUser = new User(name, vehiclenumber, vehiclemodel, phone, date, pickUpDate, serviceType);
            userDAO.updateUser(updatedUser);
            response.sendRedirect("list");
        } finally {
            // Close any necessary resources here (if applicable)
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            userDAO.deleteUser(id);
            response.sendRedirect("list");
        } finally {
            // Close any necessary resources here (if applicable)
        }
    }
}

