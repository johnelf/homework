import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class showFile extends HttpServlet {

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext sc;
        sc = request.getServletContext();
        String temp = null;


        readFileByLines(sc.getRealPath("/") + "/topics.txt");

                            request.setAttribute("topics", topics);

        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");

        rd.forward(request, response);
    }

}
