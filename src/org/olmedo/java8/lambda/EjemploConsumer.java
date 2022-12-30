package org.olmedo.java8.lambda;

import org.olmedo.java8.lambda.modelo.Usuario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploConsumer {
    public static void main(String[] args) {
        // esto se utiliza mucho en apis propiamente de java como en el api String

        Consumer<Date> consumidor = fecha -> {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(f.format(fecha));
        };// es un consumidor del parametro del metodo
        consumidor.accept(new Date());

        BiConsumer<String, Integer> consumidorBi = (nombre, edad) -> System.out.println(nombre + ", tiene " + edad + " anios!");

        consumidorBi.accept("damian", 31);

        Consumer<String> consumidor2 = System.out::println;
        consumidor2.accept("Hola mundo lambda");

        List<String> nombres = Arrays.asList("andres", "pepe", "lux", "paco");
        nombres.forEach(consumidor2);

        Supplier<Usuario> creaUsuario = Usuario::new;
        Usuario usuario = creaUsuario.get();

        BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre;
        asignarNombre.accept(usuario, "Nicolas");
        System.out.println("Nombre del usuaruo: " + usuario.getNombre());

        Supplier<String> proveedor = () -> "Hola mundo lambda supplier";

        System.out.println(proveedor.get());
    }
}
