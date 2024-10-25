package vn.edu.iuh.fit.donchung.ledonchung_project_setup_www.repositories.impl;

import jakarta.annotation.Resource;
import vn.edu.iuh.fit.donchung.ledonchung_project_setup_www.entities.Demo;
import vn.edu.iuh.fit.donchung.ledonchung_project_setup_www.repositories.DemoRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DemoDAOImpl implements DemoRepository {

    @Resource(name = "LeDonChungMariaDB")
    DataSource dataSource;
    @Override
    public Demo insert(Demo demo) {
        try {
            Connection connection = dataSource.getConnection();
            String sql = "INSERT INTO demo(name) VALUES(?)";
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, demo.getName());
            int row = statement.executeUpdate();
            if(row > 0){
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()){
                    demo.setId(rs.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return demo;
    }
}
