package com.jinwen;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 8/2/12
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class OpenSubjectController implements Controller {

    private ArrayList<String> art = new ArrayList<String>();
    private ArrayList<String> comment = new ArrayList<String>();

    protected void OpenArticle(String Filename)
            throws ServletException, IOException {

        File f = new File("src/main/webapp/" + Filename + ".txt");
        if (f.exists()) {
            System.out.print("文件存在");
        } else {
            System.out.print("文件不存在");
            f.createNewFile();
        }

        BufferedReader reader = new BufferedReader(new FileReader(f));
        String tempString = null;
        boolean flag = false;
        int line = 1;

        tempString = reader.readLine();
        while (tempString != null) {
            if (tempString.startsWith("=")) {
                flag = true;
                tempString = reader.readLine();
                continue;
            }
            if (!flag) {
                art.add(tempString);
            } else {
                comment.add(tempString);
            }

            tempString = reader.readLine();
            line++;
        }

        reader.close();
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        art.clear();
        comment.clear();
        System.out.println(request.getParameter("name"));

        this.OpenArticle(request.getParameter("name"));
        request.setAttribute("name", request.getParameter("name"));
        request.setAttribute("art", art);
        request.setAttribute("comment", comment);

        System.out.println(art.size());
        System.out.println(comment.size());
        return new ModelAndView("/WEB-INF/jsp/article.jsp");
    }
}
