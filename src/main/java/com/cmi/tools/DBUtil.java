package com.cmi.tools;

import com.cmi.log.LogWriter;

import java.sql.*;

public class DBUtil {
    // 创建一个数据库连接
    public static Connection getConnection(String ip)
    {
        Connection connection = null;
        String USERNAMR = "admin";
        String PASSWORD = "admin";//
        String DRVIER = "oracle.jdbc.OracleDriver";
        String URL = "jdbc:oracle:thin:@"+ip+":1521:orm";
        try {
            Class.forName(DRVIER);
            connection = DriverManager.getConnection(URL, USERNAMR, PASSWORD);
            System.out.println("成功连接数据库");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }


    //关闭资源
    public static void close(Connection connection ) {
        try {
            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(PreparedStatement preparedStatement ) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(ResultSet resultSet ) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Boolean update(String sql,String ip)//修改数据
    {
        Connection connection=DBUtil.getConnection( ip);
        PreparedStatement preparedStatement = null;
        LogWriter.info(DBUtil.class,"执行sql："+sql);
        try {
            preparedStatement=connection.prepareStatement(sql);

            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            LogWriter.error(DBUtil.class,"执行sql 失败："+sql);
            // TODO 自动生成的 catch 块
            e.printStackTrace();
            return false;
        }finally{
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);
        }

    }

    public static Boolean delete(String sql,String ip)//删除数据
    {
        Connection connection=DBUtil.getConnection(ip);
        LogWriter.info(DBUtil.class,"执行sql："+sql);
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=connection.prepareStatement(sql);

            preparedStatement.executeQuery();
            System.out.println("删除成功");
            return true;
        } catch (SQLException e) {
            LogWriter.error(DBUtil.class,"执行sql 失败："+sql);
            // TODO 自动生成的 catch 块
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);
        }

    }


    public static void main(String[] args) {



        DBUtil.update("update TEST  set NAME='abbaa' where id='2'or id='1' or id='3' or id='4'","127.0.0.1:443");
    }
}
