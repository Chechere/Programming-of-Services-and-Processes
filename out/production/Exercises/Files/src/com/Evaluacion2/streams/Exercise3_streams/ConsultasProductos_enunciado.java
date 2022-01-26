package com.Evaluacion2.streams.Exercise3_streams;

import com.Evaluacion2.streams.Exercise3_streams.utils.Util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsultasProductos_enunciado {
    List<Product> products;

    public ConsultasProductos_enunciado() {
        // Cargamos la lista de productos
        try {
            products = Util.getProducts();
            procesarStreams();
        } catch (Exception e) {
            System.err.println("Error al leer el fichero de productos: " + e.getMessage());
        }
    }

    private void procesarStreams() {
        todosProductos();
        System.out.println();
        consultasSimples();
        System.out.println();
        consultasFiltradas();
        System.out.println();
        consultasOrdenacion();


    }

    private void todosProductos() {
        System.out.println("*** Todos los productos ***");
        products.forEach(product -> System.out.printf("ID: %d; Name: %s; Category: %d; Units: %d; Price/Unit: %.2f€; Supplier: %s.\n", product.getId(), product.getName(), product.getCategory(), product.getUnitsInStock(), product.getUnitPrice(), product.getSupplier()));
    }

    private void consultasSimples() {
        // Consultas Simpples
        // select name from products
        System.out.println("*** Nombre de los productos ***");
        products.stream().map(Product::getName).forEach(System.out::println);
    }

    private void consultasFiltradas() {
        System.out.println("*** Nombre de los productos con unidades en stock mayor de 10 ***");
        products.stream()
                .filter(product -> product.getUnitsInStock() > 10)
                .map(Product::getName)
                .forEach(System.out::println);
    }

    private void consultasOrdenacion() {
        System.out.println("*** Nombre de los productos con unidades en stock mayor de 10 ordenados por unidades en stock ascendente ***");
        products.stream().sorted().forEach(product -> System.out.printf("Name: %s; Units: %d.\n", product.getName(), product.getUnitsInStock()));
        System.out.println();

        System.out.println("*** Nombre de los productos con unidades en stock mayor de 10 ordenados por unidades en stock descedente ***");
        products.stream().sorted((p1, p2) -> p2.compareTo(p1)).forEach(product -> System.out.printf("Name: %s; Units: %d.\n", product.getName(), product.getUnitsInStock()));
        System.out.println();

        System.out.println("*** Nombre de los productos con unidades en stock mayor de 10 ordenados por unidades en stock ascendente - Comparable ***");
        products.stream()
                .filter(product -> product.getUnitsInStock() > 10)
                .sorted(Comparator.comparing(Product::getUnitsInStock))
                .forEach(product -> System.out.printf("Name: %s; Units: %d.\n", product.getName(), product.getUnitsInStock()));
    }


}
