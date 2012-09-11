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
 * Date: 9/2/12
 * Time: 1:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddCommentController implements Controller {

    public void AddComment(HttpServletRequest request) {

        String name = request.getParameter("filename");
        String content = request.getParameter("comment");
        String sql = "insert into comment values(" + "\'" + name + "\'";
        sql += ", \'" + content + "\', " + "\'" + DataFormat.getDate() + "\')";

        DBOperation.getINSTANCE().ExecuteInsertSQL(sql);
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AddComment(request);
        String Filename = request.getParameter("filename");
        request.setAttribute("filename", Filename);

        return new ModelAndView("/WEB-INF/jsp/comment.jsp");
    }
}
