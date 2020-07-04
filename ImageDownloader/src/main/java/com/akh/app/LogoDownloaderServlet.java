package com.akh.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.akh.bean.LogoInformation;
import com.akh.dao.ImageDAO;

/**
 * @author akhilesh
 *
 */

@Controller
public class LogoDownloaderServlet extends HttpServlet {
	private static List<LogoInformation> logoInfoList;
	private static final long serialVersionUID = 1L;
	@Autowired
	private ImageDAO imageDAO;

	public LogoDownloaderServlet() {
		super();
		System.out.println("Controller ok");
	}
	
	@GetMapping("/start")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get method called.");
		logoInfoList = ImageInfoService.getImageInfoFromDb(imageDAO);
		request.setAttribute("logoInfoList", logoInfoList);
		System.out.println("===================================");
		System.out.println("logoInfoList:  " + logoInfoList);
		System.out.println("===================================");
		javax.servlet.RequestDispatcher dispatcher = request
				.getRequestDispatcher("logoInfoTable.jsp");
		dispatcher.forward(request, response);
	}

}
