

import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * @author dxy
 * @date 2021/3/24 - 17:58
 */
public class jdbc {

    private static String driver = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;

    static {
        try {
            InputStream resource = jdbc.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(resource);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            Class.forName(driver);
            resource.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static Connection jdbc() throws Exception {
        return DriverManager.getConnection(url, user, password);


    }

    public static void remove(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        resultSet.close();
        statement.close();
        connection.close();

    }

    private static List convertList(ResultSet rs) throws SQLException {
        List list = new ArrayList();
        ResultSetMetaData md = rs.getMetaData();//获取键名
        System.out.println(md);
        int columnCount = md.getColumnCount();//获取行的数量
        System.out.println(columnCount);
        while (rs.next()) {
            Map rowData = new HashMap();//声明Map
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(md.getColumnName(i), rs.getObject(i));//获取键名及值
            }
            list.add(rowData);
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        Connection connection = jdbc.jdbc();
        Statement statement = connection.createStatement();
        connection.setAutoCommit(false);

        String sql = "select * from emp where id = 1001";
        connection.commit();
        ResultSet resultSet = statement.executeQuery(sql);
        List list = jdbc.convertList(resultSet);
        for (Object o : list) {
            System.out.println(o);
        }

    }
}
