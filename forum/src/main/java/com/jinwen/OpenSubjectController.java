package com.jinwen;

import com.database.DBOperation;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    protected void OpenArticle(String ArticleName)
            throws ServletException, IOException {
        String sql = "select content from article where name=" + "\'" + ArticleName + "\'";
        art = DBOperation.getINSTANCE().ExecuteQuerySQL(sql, "content");

        sql = "select a.content from comment a,article b where a.name=b.name" +
                " and b.name=" + "\'" + ArticleName + "\'" +
                " order by a.postDate asc";
        comment = DBOperation.getINSTANCE().ExecuteQuerySQL(sql, "content");
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        OpenArticle(request.getParameter("name"));
        request.setAttribute("name", request.getParameter("name"));
        request.setAttribute("art", art);
        request.setAttribute("comment", comment);

        System.out.println(art.get(0));
        System.out.println("art: " + art.size());
        System.out.println(comment.size());
        return new ModelAndView("/WEB-INF/jsp/article.jsp");
    }
}
