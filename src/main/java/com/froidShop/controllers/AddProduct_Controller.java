package com.froidShop.controllers;

import com.froidShop.beans.Product;
import com.froidShop.service.CategoryService;
import com.froidShop.service.ProductService;
import com.froidShop.service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;

@WebServlet(name = "AddProduct_Controller")
public class AddProduct_Controller extends HttpServlet {
    private static final int TAILLE_TAMPON = 10240; // Taille tampon
    private static final String CHEMIN_IMAGES = "D:/Workspace JAVA & J2EE/IdeaProjects/FroidShop-International/web/img/"; // chemin permanent

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "add_product.jsp";
        Product product = new Product();

        try {
            product.setDescription(request.getParameter("description"));
            product.setPrice((Double)Double.parseDouble(request.getParameter("price")));
            product.setQuantity((Integer)Integer.parseInt(request.getParameter("quantity")));
            product.setCategory(request.getParameter("category"));
        }catch (Exception e){
            System.out.println("Exception " + e.getMessage());
        }

        Part imagepart = request.getPart("image");
        // on recupere le nom de l'image
        String nomFichier = getNomFichier(imagepart);
        product.setImage(nomFichier);

        System.out.println(product.toString());
        // add product in the database
        ProductService service = new ServiceImpl();
        String message = service.addProduct(product);

        request.setAttribute("adding", message);

        if (nomFichier != null && !nomFichier.isEmpty()){
            String nomChamp = imagepart.getName();

            // bug I. explorer
            nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1).substring(nomFichier.lastIndexOf('\\') + 1);

            ecrireFichier(imagepart, nomFichier, CHEMIN_IMAGES);

            request.setAttribute(nomChamp, nomFichier);
        }

        request.getRequestDispatcher(page).include(request, response);
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // import category
        String page = "add_product.jsp";
        CategoryService categoryService = new ServiceImpl();
        List listCategory = categoryService.listCategory();

        request.setAttribute("list", listCategory);
        request.getRequestDispatcher(page).forward(request, response);
    }

    private void ecrireFichier(Part part, String nomFichier, String chemin) throws IOException{
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;

        try {
            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

            byte[] tampon = new byte[TAILLE_TAMPON];
            int longueur;
            while ((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
        } finally {
            try {
                sortie.close();
            } catch (IOException ignore) {
            }
            try {
                entree.close();
            } catch (IOException ignore) {
            }
        }
    }

    /*
     * decomposition du nom du fichier
     */
    private static String getNomFichier( Part part ) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    }
}
