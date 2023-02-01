package com.onion.home.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDAO;
	private ProductService productService;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
        productDAO =  new ProductDAO();
        productService = new ProductService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-------------------------------------------");
		System.out.println("Product Page");

		String uri = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		
		
		String path = "";
		switch (uri) {
		case "list.do":
			try {
				List<ProductDTO> productDTOs = productService.getProductList();
				request.setAttribute("list", productDTOs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			path = "List.jsp";
			break;
			
		case "add.do" :
			path = "Add.jsp";
			break;
			
		case "update.do" :
			path = "Update.jsp";
			break;
			
		case "delete.do" : 
			System.out.println(uri);
			break;
			
		case "detail.do" : 
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(Long.parseLong(request.getParameter("productNum")));
			
			try {
				productDTO = productService.getProductDetail(productDTO);
				request.setAttribute("product", productDTO);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			path = "Detail.jsp";
			break;
			
		default:
			
			break;
		}
		

		RequestDispatcher views = request.getRequestDispatcher("/WEB-INF/views/product/product" + path);
		views.forward(request, response);

		
//		String name = request.getParameter("name");
//		String detail = request.getParameter("detail");
//		
//		System.out.println("-------------------------------------------");
//		System.out.println("Product");
//		System.out.println("Name : " + name);
//		System.out.println("Detail : " + detail);
//		System.out.println("-------------------------------------------");
//		
//		ProductDTO productDTO = new ProductDTO();
//		productDTO.setProductName(name);
//		productDTO.setProductDetail(detail);
//		try {
////			int result = productService.setAddProduct(productDTO, new ArrayList<ProductOptionDTO>());
////			System.out.println(result != 0);
//			
//			List<ProductDTO> productDTOs = productService.getProductList();
//			for (ProductDTO productDTO2 : productDTOs) {
//				System.out.println(productDTO2.getProductName());
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
