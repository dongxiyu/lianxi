

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

/**
 * @author dxy
 * @date 2021/3/24 - 17:58
 */
public  class c3p0 {

//    private static  String driver = null;
//    private static  String url = null;
//    private static  String user = null;
//    private static  String password = null;
private static DataSource dataSource=null;
    static {
        try {
            dataSource = new ComboPooledDataSource();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static Connection jdbc() throws Exception{
        return dataSource.getConnection();



    }
    public static void remove(Connection connection,Statement statement,ResultSet resultSet) throws SQLException {
        resultSet.close();
        statement.close();
        connection.close();

    }
    private static List convertList(ResultSet rs) throws SQLException{
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
        Connection connection = c3p0.jdbc();
        Statement statement = connection.createStatement();


        String sql="select * from emp where id = 1001";

        ResultSet resultSet = statement.executeQuery(sql);
        List list = c3p0.convertList(resultSet);
        for (Object o : list) {
            System.out.println(o);
        }

    }
}
