package br.com.etec.acapi.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etec.acapi.modelo.Funcionario;
import br.com.etec.acapi.modeloDAO.BancoDAO;

@WebServlet("/ServletImagem")
	public class ServletFoto  extends HttpServlet {
		private static final long serialVersionUID = 1L;
	    
	    public ServletFoto() {
	        super();
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id = request.getParameter("id");
			if (id == null || id.equals("")) {
				return;
			}
			//Cliente cliente = new ClienteDao().buscar();
			BancoDAO dao = new BancoDAO();
			Funcionario funcionario = dao.buscarFuncionarioPorId(Integer.parseInt(id));
			File f = new File(funcionario.getCaminhoImg());
			FileInputStream fis = new FileInputStream(f);
			byte[] arrayImagem = new byte[(int) f.length()];
			fis.read(arrayImagem);
			fis.close();
			
			response.getOutputStream().write(arrayImagem);
		}


	}
	
	
	
	

