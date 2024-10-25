package vn.edu.iuh.fit.donchung.ledonchung_project_setup_www.controllers;

import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.donchung.ledonchung_project_setup_www.entities.Demo;
import vn.edu.iuh.fit.donchung.ledonchung_project_setup_www.repositories.DemoRepository;
import vn.edu.iuh.fit.donchung.ledonchung_project_setup_www.utils.AppUtils;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/home")
public class HomeController extends HttpServlet {
    @Inject
    private DemoRepository demoRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Demo demo = Demo.builder().name("Le Don Chung").build();
//        demoRepository.insert(demo);
        try(var em = AppUtils.getEntityManager()) {
            em.getTransaction().begin();
            em.persist(demo);
            em.getTransaction().commit();
        }
        req.setAttribute("demo", demo);

        req.getRequestDispatcher("views/home.jsp").forward(req, resp);
    }
}
