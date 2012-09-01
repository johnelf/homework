package com.jinwen;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 8/2/12
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class openSubject extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String tmp = request.getParameter("name");

        File f = new File(tmp + ".txt");
        if (f.exists()) {
            System.out.print("文件存在");
        } else {
            System.out.print("文件不存在");
            f.createNewFile();
        }

        BufferedReader reader = null;

            reader = new BufferedReader(new FileReader(f));
            String tempString = null;

            boolean flag = false;
            int line = 1;

            PrintWriter out;
            response.setContentType("text/html; charset=GBK");
            out = response.getWriter();
            out.println("<html><head><title>" + tmp + "</title></head>");
            out.println("<body><h1>");

            tempString = reader.readLine();
            while (tempString != null) {
                if (tempString.startsWith("=")) {
                    flag = true;
                    tempString = reader.readLine();
                    out.print("</h1><br />");
                    continue;
                }
                if (flag == false) {
                    out.print(tempString);
                }
                else{
                    out.print("<p>");
                    out.print(tempString + "<br />");
                }

                tempString = reader.readLine();
                line++;
            }
            reader.close();

        out.println("</h1></body></html>");
        out.close();
    }


}
