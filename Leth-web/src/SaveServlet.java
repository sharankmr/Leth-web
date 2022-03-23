import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/SaveServlet")  
public class SaveServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);
          
        String product=request.getParameter("product");  
        
        
        String squantity=request.getParameter("quantity");  
        int quantity=Integer.parseInt(squantity);
        
        String svalue=request.getParameter("value");  
        int value=Integer.parseInt(svalue);
        
        Emp e=new Emp();  
        e.setid(id);
        e.setproduct(product);  
        e.setquantity(quantity);  
        e.setvalue(value);  
       
          
        int status=EmpDao.save(e);  
        if(status>0){  
            out.print("<html><body><script> alert('Record Saved go back'); </script></body></html>");  
            request.getRequestDispatcher("Index.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}  