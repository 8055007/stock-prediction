package StockPrediction;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class Stockmain
 */
@WebServlet("/Stockmain")
public class Stockmain extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Stockmain() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Stock=request.getParameter("Stock");
		PrintWriter out = response.getWriter();
		HttpRequest request1 = HttpRequest.newBuilder()
				.uri(URI.create("https://latest-stock-price.p.rapidapi.com/price?Indices="+Stock))
				.header("X-RapidAPI-Key", "c9f0d6972cmsh3fb86ef3fc7ea15p1a0fdfjsn548016934f3f")
				.header("X-RapidAPI-Host", "latest-stock-price.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response1;
		try {
			response1 = HttpClient.newHttpClient().send(request1, HttpResponse.BodyHandlers.ofString());
			String result=response1.body();
			
			displaystockdata(result, out);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	private void displaystockdata(String result, PrintWriter out) throws JSONException {
		JSONArray jsonArray=new JSONArray(result);
		
		out.println("<html>");
		out.println("<head><title>Stock App</title></head>");
		out.println("<body>");
		
		out.println("<table border=\"1\">");
		out.println("<tr>");
		out.println("<th>symbol</th>");
		out.println("<th>Open</th>");
	    out.println("<th>Day high</th>");
		out.println("<th>Day low</th>");
		out.println("<th>Last Price</th>");
		out.println("<th>previous close</th>");
		out.println("<th>year high</th>");
		out.println("<th>year low</th>");
		out.println("<th>total traded value</th>");
		
	   
		out.println("</tr>");
		
		
		for(int i=0;i<jsonArray.length();i++) { 
			JSONObject Stock= jsonArray.getJSONObject(i);
		
			out.println("<tr>");
			out.println("<td>" + Stock.getString("symbol") + "</td>");
			out.println("<td>" + Stock.getDouble("open") + "</td>");
			out.println("<td>" + Stock.getDouble("dayHigh") + "</td>");
			out.println("<td>" + Stock.getDouble("dayLow") + "</td>");
			out.println("<td>" + Stock.getDouble("lastPrice") + "</td>");
			out.println("<td>" + Stock.getDouble("previousClose") + "</td>");
			out.println("<td>" + Stock.getDouble("yearHigh") + "</td>");
			out.println("<td>" + Stock.getDouble("yearLow") + "</td>");
			out.println("<td>" + Stock.getDouble("totalTradedValue") + "</td>");
		 
			out.println("</tr>");
			
		 
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
