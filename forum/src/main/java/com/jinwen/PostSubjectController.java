package com.jinwen;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 8/1/12
 * Time: 10:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class PostSubjectController implements Controller {

    protected void AppendArticle(String filename, String content){
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(filename, true)));
            out.write(content + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void PostArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tmp = request.getParameter("subject");
        tmp = request.getParameter("context");

        File f = new File("src/main/webapp/" + tmp + ".txt");
        if (f.exists()) {
            System.out.print("文件存在");
        } else {
            System.out.print("文件不存在");
            f.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(f);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
        bw.write(tmp);
        bw.flush();
        bw.close();

        AppendArticle("src/main/webapp/topics.txt", tmp);
    }

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostArticle(request, response);

        return new ModelAndView("/WEB-INF/jsp/success.jsp");
    }


}
