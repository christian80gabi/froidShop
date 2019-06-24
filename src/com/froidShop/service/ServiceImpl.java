package com.froidShop.service;

import com.froidShop.beans.*;
import com.froidShop.dao.*;

import java.util.List;

public class ServiceImpl implements AdminService, CustomerService, CategoryService, ProductService, DeviseService, CartService {
    private AdminDao adminDao = new AdminDaoImpl();
    private CustomerDao customerDao = new CustomerDaoImpl();
    private CategoryDao categoryDao = new CategoryDaoImpl();
    private ProductDao productDao = new ProductDaoImpl();
    private DeviseDao deviseDao = new DeviseDaoImpl();
    private CartDao cartDao = new CartDaoImpl();

    /*
    admin services
     */
    @Override
    public boolean loginAdmin(String username, String password) {
        return this.adminDao.login(username, password);
    }

    @Override
    public String addAdmin(Admin admin) {
        return this.adminDao.addAdmin(admin);
    }

    /*
    customer services
     */
    @Override
    public boolean loginCustomer(String mail, String password) {
        return this.customerDao.login(mail, password);
    }

    @Override
    public String registrationCustomer(Customer customer) {
        return this.customerDao.register(customer);
    }

    /*
    category services
     */
    @Override
    public String addCategory(Category category) {
        return categoryDao.addCategory(category);
    }

    @Override
    public List listCategory() {
        return categoryDao.listCategory();
    }

    /*
    product services
     */
    @Override
    public String addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public List listProducts() {
        return productDao.getProducts();
    }

    /*
    Devise services
     */
    @Override
    public Devise getDevise() {
        return deviseDao.getDevise();
    }

    @Override
    public String updateDevise(String description) {
        return deviseDao.updateDevise(description);
    }

    /*
    Cart services
     */
    @Override
    public List<Product> addCart(int id) {
        return cartDao.addCart(id);
    }
}
