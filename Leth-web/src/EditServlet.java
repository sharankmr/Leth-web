import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Records</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Emp e=EmpDao.getById(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td>Id</td><td><input type='number' name='id' value='"+e.getid()+"'/></td></tr>");  
        out.print("<tr><td>product:</td><td><input type='text' name='product' value='"+e.getproduct()+"'/></td></tr>");  
        out.print("<tr><td>quantity:</td><td><input type='number' name='quantity' value='"+e.getquantity()+"'/></td></tr>");  
        out.print("<tr><td>value:</td><td><input type='number' name='value' value='"+e.getvalue()+"'/></td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}  