package com.jinwen;

import com.database.DBOperation;
import com.dateformat.DataFormat;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 8/1/12
 * Time: 10:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class PostSubjectController implements Controller {

    protected void PostArticle(HttpServletRequest request)
            throws ServletException, IOException {
        String name = request.getParameter("subject");
        String sql = "insert into article values(" + "\'" + name + "\'";
        String content = request.getParameter("context");
        sql += ", \'" + content + "\', " + "\'" + DataFormat.getDate() + "\')";

        DBOperation.getINSTANCE().ExecuteInsertSQL(sql);
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostArticle(request);

        return new ModelAndView("/WEB-INF/jsp/success.jsp");
    }


}
