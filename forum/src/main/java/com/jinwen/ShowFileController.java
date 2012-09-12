package com.jinwen;

import com.database.DBOperation;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ShowFileController implements Controller {

    private ArrayList<String> topics = new ArrayList<String>(0);

    public void getTopics(){
        topics = DBOperation.getINSTANCE().ExecuteQuerySQL("select name from article", "name");
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getTopics();
        request.setAttribute("topics", topics);

        return new ModelAndView("/WEB-INF/jsp/forum.jsp");
    }
}
