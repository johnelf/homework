package com.jinwen;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 9/2/12
 * Time: 1:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddCommentController implements Controller {

    private String Filename = new String();

    public void AddComment(HttpServletRequest request) {

        String fileName = request.getParameter("filename");
        String content = request.getParameter("comment");

        try {
            FileWriter writer = new FileWriter("src/main/webapp/" + fileName + ".txt", true);
            writer.write(content + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AddComment(request);
        Filename = request.getParameter("filename");
        request.setAttribute("filename", Filename);

        return new ModelAndView("/WEB-INF/jsp/comment.jsp");
    }
}
