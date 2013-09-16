package org.glassfish.web;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderb
 * Date: 9/16/13
 */
@RequestScoped
public class DBService {

    @Resource(name = "jdbc/securityDatasource")
    private javax.sql.DataSource dsc;

    public List<User> getUsersList() throws SQLException {

        List<User> list = new LinkedList();

        Connection conn = dsc.getConnection();
        Statement st = conn.createStatement();
        ResultSet resultSet = st.executeQuery("select * from users");

        while (resultSet.next()) {
            String userid = resultSet.getString("userid");
            String password = resultSet.getString("password");
            User user = new User();
            user.setUserid(userid);
            user.setPassword(password);

            list.add(user);
        }
        resultSet.close();
        conn.close();

        return list;
    }

}
