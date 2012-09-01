import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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
public class postSubject extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext sc;
        sc = request.getServletContext();
        String temp = null;

        String tmp = request.getParameter("subject");
        temp = request.getParameter("context");


            File f = new File(sc.getRealPath("/") + tmp + ".txt");
            if (f.exists()) {
                System.out.print("文件存在");
            } else {
                System.out.print("文件不存在");
                f.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(f);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
            bw.write(temp);
            bw.flush();
            bw.close();

            response.sendRedirect("success.html");
    }


}
