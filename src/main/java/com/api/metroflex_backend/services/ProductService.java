package com.api.metroflex_backend.services;

import com.api.metroflex_backend.models.ProductModel;
import com.api.metroflex_backend.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    public List<ProductModel> getProducts() {
        return productRepository.findAll();
    }

    public ProductModel saveProduct(ProductModel product) {
        return productRepository.save(product);
    }

    public Optional<ProductModel> getById(Long id) {
        return productRepository.findById(id);
    }

    public ProductModel updateById(ProductModel request, Long id) {
        Optional<ProductModel> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            ProductModel product = optionalProduct.get();

            // Verificar que los campos no sean nulos antes de actualizarlos
            if (request.getName() != null) {
                product.setName(request.getName());
            }
            if (request.getDescription() != null) {
                product.setDescription(request.getDescription());
            }
            // Actualizar el precio solo si el objeto request contiene un precio válido
            if (request.getPrice() > 0) {
                product.setPrice(request.getPrice());
            }

            // Agregar aquí otros campos para actualizar si es necesario

            return productRepository.save(product); // Guardar los cambios en la base de datos
        } else {
            // Manejar el caso en el que no se encuentre el producto con el ID dado
            throw new IllegalArgumentException("Producto no encontrado con el ID proporcionado: " + id);
        }
    }

    public boolean deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}