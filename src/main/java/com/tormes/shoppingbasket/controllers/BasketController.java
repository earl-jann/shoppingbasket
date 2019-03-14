package com.tormes.shoppingbasket.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tormes.shoppingbasket.helpers.BasketItem;
import com.tormes.shoppingbasket.repository.ProductRepository;

@Controller
@RequestMapping(value = "basket")
public class BasketController {
	
    @Autowired
    private ProductRepository productRepository;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "basket/index";
	}

    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String getProducts(Model model){
        model.addAttribute("products", productRepository.findAll());
        return "basket";
    }
    
    @RequestMapping(value = "add-to-basket/{id}", method = RequestMethod.GET)
	public String addToBasket(@PathVariable("id") Long id, HttpSession session) {
    	// we store to session
		if (session.getAttribute("basket") == null) {
			List<BasketItem> basketItems = new ArrayList<BasketItem>();
			basketItems.add(new BasketItem(productRepository.findOne(id), 1));
			session.setAttribute("basket", basketItems);
		} else {
			List<BasketItem> basketItems = (List<BasketItem>) session.getAttribute("basket");
			int index = this.exists(id, basketItems);
			if (index == -1) {
				basketItems.add(new BasketItem(productRepository.findOne(id), 1));
			} else {
				int quantity = basketItems.get(index).getQuantity() + 1;
				basketItems.get(index).setQuantity(quantity);
			}
			session.setAttribute("basket", basketItems);
		}
		return "redirect:/basket/index";
	}
    
    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable("id") Long id, HttpSession session) {
		List<BasketItem> basketItems = (List<BasketItem>) session.getAttribute("basket");
		int index = this.exists(id, basketItems);
		basketItems.remove(index);
		session.setAttribute("basket", basketItems);
		return "redirect:/basket/index";
	}

	private int exists(Long id, List<BasketItem> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProduct().getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
    
}
