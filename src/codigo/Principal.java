/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Charly Ponce
 */
public class Principal {
    public static void main(String[] args) throws Exception {
        String ruta1 = "E:\\Descargas\\AnalizadorLexicosintactico\\src\\codigo\\Lexer.flex";
        String ruta2 = "E:\\Descargas\\AnalizadorLexicosintactico\\src\\codigo\\LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "E:\\Descargas\\AnalizadorLexicosintactico\\src\\codigo\\Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }

    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception {
        File archivo;
        
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        
        java_cup.Main.main(rutaS);

        Path rutaSym = Paths.get("E:\\Descargas\\AnalizadorLexicosintactico\\src\\codigo\\sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("E:\\Descargas\\AnalizadorLexicosintactico\\sym.java"),
                Paths.get("E:\\Descargas\\AnalizadorLexicosintactico\\src\\codigo\\sym.java")
        );

        Path rutaSin = Paths.get("E:\\Descargas\\AnalizadorLexicosintactico\\src\\codigo\\Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("E:\\Descargas\\AnalizadorLexicosintactico\\Sintax.java"),
                Paths.get("E:\\Descargas\\AnalizadorLexicosintactico\\src\\codigo\\Sintax.java")
        );
    }
}
