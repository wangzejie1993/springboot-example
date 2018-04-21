package com.cn.bafang.backstage.manage.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReaderExcel {

    public static final String url = "jdbc:mysql://127.0.0.1:3306/besst?&useUnicode=true&characterEncoding=utf8&useSSL=true";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "root";

    public Connection conn = null;
    public PreparedStatement pst = null;

    public ReaderExcel(String sql) {
        try {
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url, user, password);//获取连接
            pst = conn.prepareStatement(sql);//准备执行语句
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void  main(String args[]) throws Exception {
        File file = new File("/Users/fangba/test/text.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        LinkedList<String> list = new LinkedList<String>();
        LinkedList<String>  result = new LinkedList<>();
        while ((line = reader.readLine()) != null) {
            list.add(line.replace(" ",""));
        }
        for (int i = 0; i<=list.size() - 1; i++) {
            //String tt = readerinner_sn(list.get(i));
            String tt = readerout_sn(list.get(i));
            System.out.println(tt);
           //result.add(readerinner_sn(tt));
        }
        reader.close();
    }




    public static String  readerinner_sn(String str)throws  Exception{
        ResultSet rs = null;
        String sql = "select * from object_ext_battery where inner_sn='"+str+"' and weight=0";
        ReaderExcel re = new ReaderExcel(sql);
        rs = re.pst.executeQuery();
        String  result =null;
        while(rs.next()){
             result = rs.getString("outer_sn");
        }
        re.close();
        return  result;

    }

    public static String readerout_sn(String str)throws  Exception{

        ResultSet rs = null;
        String sql = "select * from object_ext_battery where outer_sn='"+str+"' and weight=0";
        ReaderExcel re = new ReaderExcel(sql);
        rs = re.pst.executeQuery();
        String  result =null;
        while(rs.next()){
            result = rs.getString("inner_sn");
        }
        re.close();
        return  result;
    }

}
