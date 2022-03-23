import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
			throws ServletException, IOException {  
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();  
		out.println("<button> <a href='Login.html'>Login Page</a> </button>"); 
		out.println("<br>");
		out.println("<br>");
		
		out.println("<h1> Inventory </h1>");  

		List<Emp> list=EmpDao.getAllrecords();  

		out.print("<table id='table' border='1' width='70%'>");  
		out.print("<tr><th>id</th><th>Product</th><th>quantity</th><th>value</th><th>edit</th><th>delete </th></tr>");  
		for(Emp e:list){  
			out.print("<tr><td>"+e.getid()+"</td><td>"+e.getproduct()+"</td><td>"+e.getquantity()+"</td><td>"+e.getvalue()+"</td><td><a href='EditServlet?id="+e.getid()+"'>edit</a></td>  <td><a href='DeleteServlet?id="+e.getid()+"'>delete</a></td></tr>");  
		}  
		out.print("</table>");
		out.println("<br>");out.println("<br>");
		out.println("<button> <a href='Inventory.html'>Add Records </a> </button>");  
		
		out.print("<br>");
		out.print("</br>");
		
		out.print("<span id='val'></span>");
		out.print("<span id='val1'></span>");
		out.print("<script>");
		out.print("var table = document.getElementById('table'), sumVal = 0,sumVal1=0;");
		out.print(" for(var i = 1; i < table.rows.length; i++)");
		out.print(" { sumVal = sumVal + parseInt(table.rows[i].cells[2].innerHTML);");
		out.print("  sumVal1 = sumVal1 + parseInt(table.rows[i].cells[3].innerHTML);}");
		//out.print("document.getElementById('val').innerHTML = 'Total Quantity = ' + sumVal;");
		//out.print("document.getElementById('val1').innerHTML = ' Total Value = ' + sumVal1;");
		out.print(" console.log(sumVal);");
		out.print(" console.log(sumVal1);");
		
		out.print("</script>");
		
		
		
		out.print("<table>");
		out.print("<table border='1' width='30%'>");
		out.print("<h2>TOTAL :</h2><tr><th>Total Quantity</th><th>Total Value</th></tr> <tr> <td id='val'>  <script> document.write(sumVal); </script> </td>  <td id='val1'>  <script> document.write(sumVal1); </script> </td> </tr>");
		out.print("</table>");
		
		 
		
		
		out.close();  
	}  
}  


