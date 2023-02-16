package com.jacaranda.estanco.controller;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jacaranda.estanco.model.Carrito;
import com.jacaranda.estanco.model.Tabaco;
import com.jacaranda.estanco.model.Pedido;
import com.jacaranda.estanco.model.Purchase;
import com.jacaranda.estanco.model.User;
import com.jacaranda.estanco.model.itemCarrito;
import com.jacaranda.estanco.services.CategoryService;
import com.jacaranda.estanco.services.MaterialService;
import com.jacaranda.estanco.services.PedidoService;
import com.jacaranda.estanco.services.PurchaseService;
import com.jacaranda.estanco.services.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class CarritoController {
	
//	private static final String REDIRECT_ITEM = "redirect:/material/list";
//	@Autowired
//	private HttpSession sesion;
//	
//	@Autowired
//	private MaterialService repositoryMaterial;
//	
//	@Autowired
//	private CategoryService repositoryCategory;
//	
//	@Autowired
//	private UserService repositoryUser;
//	
//	@Autowired
//	private PedidoService repositoryPedido;
//	
//	@Autowired
//	private PurchaseService repositoryPurchase;
//	
//	@GetMapping("/carrito/add")
//	public String getElements(Model model, @RequestParam("cant") int cant, @RequestParam("idMaterial") int idArticulo) {
//		Tabaco a=repositoryMaterial.getItem(idArticulo);
//		
//		itemCarrito c=new itemCarrito(a,cant);
//		Carrito carro;
//		if(sesion.getAttribute("carro")==null) {
//			carro=new Carrito();
//			sesion.setAttribute("carro", carro);
//		}else {
//			carro=(Carrito) sesion.getAttribute("carro");
//		}
//		
//		carro.addItemCarrito(c);
//		
//
//		return REDIRECT_ITEM;
//	}
//	
//	@GetMapping("/carrito/list")
//	public String getElements(Model model) {
//		Carrito c=(Carrito)sesion.getAttribute("carro");
//		
//		model.addAttribute("listaItem",c.getListCarrito());
//		
//		Authentication authtentication=(Authentication) SecurityContextHolder.getContext().getAuthentication();
//		
//		User u=repositoryUser.getUser(authtentication.getName());
//
//		model.addAttribute("file",u.getImage());
//		
//		return "carritoCompra";
//		
//
//
//	}
//	
//	@GetMapping("articulo/carrito/comprar")
//	public String comprarCarrito(Principal principal) {
//
//	Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
//	User user = repositoryUser.getUser(principal.getName());
//
//	Carrito c = (Carrito) sesion.getAttribute("carro");
//
//	if(c.getCantidadTotal()!=0) {
//	Pedido pedido=new Pedido(21.0, user, LocalDate.now());
//
//	repositoryPedido.addPedido(pedido);
//
//	for(itemCarrito i: c.getListCarrito()) {
//	Purchase pa= new Purchase(pedido, i.getMaterial(), i.getCantidad());
//	repositoryPurchase.addPurchase(pa);
//	pa.getMaterialCode().setStock(pa.getMaterialCode().getStock()-pa.getQuantity());
//	repositoryMaterial.addItem(pa.getMaterialCode());
//	}
//	}
//
//	return "redirect:/articulo/carrito/vaciar";
//	}
//
//	@GetMapping("articulo/carrito/vaciar")
//	public String vaciarCarrito() {
//
//	Carrito c;
//	if (sesion.getAttribute("carro") == null) {
//	c = new Carrito();
//	sesion.setAttribute("carro", c);
//	} else {
//	c = (Carrito) sesion.getAttribute("carro");
//	c.vaciarLista();
//	}
//
//	return "redirect:/material/list";
//	}

}
