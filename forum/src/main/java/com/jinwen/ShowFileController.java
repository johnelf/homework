package com.jinwen;

import com.database.DBOperation;
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

public class ShowFileController implements Controller {

    private ArrayList<String> topics = new ArrayList<String>(0);

    protected void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;

            tempString = reader.readLine();
            while (tempString != null) {
                topics.add(tempString);
                tempString = reader.readLine();
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {

                }
            }
        }
    }

    public void getTopics(){
        topics = DBOperation.getINSTANCE().ExecuteQuerySQL("select name from article", "name");
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getTopics();
        request.setAttribute("topics", topics);

        return new ModelAndView("/WEB-INF/jsp/forum.jsp");
    }
}
