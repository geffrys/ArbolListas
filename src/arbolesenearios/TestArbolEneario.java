package arbolesenearios;

import org.junit.Test;

import junit.framework.TestCase;

public class TestArbolEneario extends TestCase {
    private ArbolEneario arbol = new ArbolEneario();
    public void escenario(){
        arbol.setConcatenador("");
        arbol.setGradoArbol(0);
        arbol.setGradoDato(0);
        arbol.setNiveldato(1);
        arbol.setRaiz(new Nodo("x"));
        arbol.insertarDatoAPadre(arbol.getRaiz(), "x", "c");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "x", "f");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "x", "h");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "x", "s");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "c", "d");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "c", "e");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "h", "w");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "h", "g");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "h", "k");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "h", "m");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "w", "a");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "w", "b");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "g", "z");
    }
    public void escenario2(){
        arbol.setConcatenador("");
        arbol.setGradoDato(0);
        arbol.setGradoArbol(0);
        arbol.setRaiz(new Nodo("x"));
        arbol.insertarDatoAPadre(arbol.getRaiz(), "x", "c");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "x", "f");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "x", "h");
        // arbol.insertarDatoAPadre(arbol.getRaiz(), "x", "s");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "c", "d");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "c", "e");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "h", "w");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "h", "g");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "h", "k");
        // arbol.insertarDatoAPadre(arbol.getRaiz(), "h", "m");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "w", "a");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "w", "b");
        arbol.insertarDatoAPadre(arbol.getRaiz(), "g", "z");
    }

    @Test
    public void testMostrarArbol(){
        escenario();
        arbol.mostrarArbol(arbol.getRaiz());
        System.out.println(arbol.getConcatenador());
        assertEquals("testMostrar", "xcdefhwabgzkms", arbol.getConcatenador());
    }

    // ELIMINACIONES

    @Test
    public void testEliminarHoja(){
        escenario();
        arbol.borrarDato(arbol.getRaiz(), "f", null);
        arbol.mostrarArbol(arbol.getRaiz());
        assertEquals("testEliminarRaiz", "xcdehwabgzkms", arbol.getConcatenador());
    }

    @Test
    public void testEliminarRaiz(){
        escenario();
        arbol.borrarDato(arbol.getRaiz(), "x", null);
        arbol.mostrarArbol(arbol.getRaiz());
        assertEquals("testEliminarRaiz", "cdefhwabgzkms", arbol.getConcatenador());
    }

    // MOSTRAR HERMANOS

    @Test
    public void testMostrarHermanosCasoHoja(){
        escenario();
        arbol.mostrarHermanosDato("c", arbol.getRaiz(), arbol.getRaiz());
        assertEquals("fhs", arbol.getConcatenador());
    }

    @Test
    public void testMostrarHermanosCasoHoja2(){
        escenario();
        arbol.mostrarHermanosDato("d", arbol.getRaiz(), arbol.getRaiz());
        assertEquals("e", arbol.getConcatenador());
    }

    @Test
    public void testMostrarHermanosCasoHoja3(){
        escenario();
        arbol.mostrarHermanosDato("w", arbol.getRaiz(), arbol.getRaiz());
        assertEquals("gkm", arbol.getConcatenador());
    }

    @Test
    public void testMostrarHermanosCasoHoja4(){
        escenario();
        arbol.mostrarHermanosDato("s", arbol.getRaiz(), arbol.getRaiz());
        assertEquals("cfh", arbol.getConcatenador());
    }

    @Test
    public void testMostrarHermanosCasoHoja5(){
        escenario();
        arbol.mostrarHermanosDato("a", arbol.getRaiz(), arbol.getRaiz());
        assertEquals("b", arbol.getConcatenador());
    }

    @Test
    public void testMostrarHermanosCasoHoja6(){
        escenario();
        arbol.mostrarHermanosDato("z", arbol.getRaiz(), arbol.getRaiz());
        assertEquals("", arbol.getConcatenador());
    }

    @Test
    public void testMostrarHermanosCasoRaiz(){
        escenario();
        arbol.mostrarHermanosDato("x", arbol.getRaiz(), arbol.getRaiz());
        assertEquals("No tiene", arbol.getConcatenador());
    }

    // GRADO DEL ARBOL

    @Test
    public void testGradodelArbol(){
        escenario();
        arbol.gradoArbol(arbol.getRaiz());
        assertEquals(4, arbol.getGradoArbol());
    }

    @Test
    public void testGradodelArbol2(){
        escenario2();
        arbol.gradoArbol(arbol.getRaiz());
        assertEquals(3, arbol.getGradoArbol());
    }
    
    // MOSTRAR RAICES

    @Test
    public void testMostrarRaices(){
        escenario();
        arbol.mostrarRaices(arbol.getRaiz());
        assertEquals("xchwg", arbol.getConcatenador());
    }

    // CONTADOR DE HOJAS

    @Test
    public void testContadorHojas(){
        escenario();
        arbol.contadorHojas(arbol.getRaiz());
        assertEquals(9, arbol.getContadorHojas());
    }

    // MOSTRAR HOJAS

    @Test
    public void testMostrarhojas(){
        escenario();
        arbol.mostrarHojas(arbol.getRaiz());
        assertEquals("defabzkms", arbol.getConcatenador());
    }

    // GRADO DE DATO

    @Test
    public void testGradoDato(){
        escenario();
        arbol.mostrarGradoDato("c", arbol.getRaiz());
        assertEquals(2, arbol.getGradoDato());
    }

    @Test
    public void testGradoDato2(){
        escenario();
        arbol.mostrarGradoDato("x", arbol.getRaiz());
        assertEquals(4, arbol.getGradoDato());
    }

    @Test
    public void testGradoDato3(){
        escenario();
        arbol.mostrarGradoDato("g", arbol.getRaiz());
        assertEquals(1, arbol.getGradoDato());
    }

    @Test
    public void testGradoDato4(){
        escenario();
        arbol.mostrarGradoDato("m", arbol.getRaiz());
        assertEquals(0, arbol.getGradoDato());
    }

    // MOSTRAR HIJOS DE DATO DADO

    @Test
    public void testMostrarHijosDato(){
        escenario();
        arbol.mostrarHijosDato("x", arbol.getRaiz());
        assertEquals("cfhs", arbol.getConcatenador());
    }

    @Test
    public void testMostrarHijosDato2(){
        escenario();
        arbol.mostrarHijosDato("f", arbol.getRaiz());
        assertEquals("No tiene", arbol.getConcatenador());
    }

    @Test
    public void testMostrarHijosDato3(){
        escenario();
        arbol.mostrarHijosDato("g", arbol.getRaiz());
        assertEquals("z", arbol.getConcatenador());
    }

    @Test
    public void testMostrarHijosDato4(){
        escenario();
        arbol.mostrarHijosDato("w", arbol.getRaiz());
        assertEquals("ab", arbol.getConcatenador());
    }

    // NIVEL DE DATO

    @Test
    public void testNiveldedatodado(){
        escenario();
        arbol.mostrarNivelDato(arbol.getRaiz(), "x", 1);
        assertEquals(1, arbol.getNiveldato());
    }

    @Test
    public void testNiveldedatodado2(){
        escenario();
        arbol.mostrarNivelDato(arbol.getRaiz(), "c", 1);
        assertEquals(2, arbol.getNiveldato());
    }

    @Test
    public void testNiveldedatodado3(){
        escenario();
        arbol.mostrarNivelDato(arbol.getRaiz(), "z", 1);
        assertEquals(4, arbol.getNiveldato());
    }
    
    // ALTURA DEL ARBOL

    @Test
    public void testNivelArbol(){
        escenario();
        arbol.alturaArbol(arbol.getRaiz());
        assertEquals(4, arbol.getNivelMax());
    }

    // PADRE DE DATO

    @Test
    public void testPadreDato(){
        escenario();
        arbol.mostrarPadreDato(arbol.getRaiz(), arbol.getRaiz(), "x");
        assertEquals("La raiz no puede tener padre", arbol.getPadreAnt());
    }

    @Test
    public void testPadreDato2(){
        escenario();
        arbol.mostrarPadreDato(arbol.getRaiz(), arbol.getRaiz(), "w");
        assertEquals("h", arbol.getPadreAnt());
    }

    @Test
    public void testPadreDato3(){
        escenario();
        arbol.mostrarPadreDato(arbol.getRaiz(), arbol.getRaiz(), "f");
        assertEquals("x", arbol.getPadreAnt());
    }

    @Test
    public void testPadreDato4(){
        escenario();
        arbol.mostrarPadreDato(arbol.getRaiz(), arbol.getRaiz(), "z");
        assertEquals("g", arbol.getPadreAnt());
    }

    @Test
    public void testPadreDato5(){
        escenario();
        arbol.mostrarPadreDato(arbol.getRaiz(), arbol.getRaiz(), "b");
        assertEquals("w", arbol.getPadreAnt());
    }

    // DATOS DE UN NIVEL

    @Test
    public void testDatosNivel(){
        escenario();
        arbol.datosNivel(arbol.getRaiz(), 4);
        assertEquals("abz", arbol.getConcatenador());
    }

    @Test
    public void testDatosNivel2(){
        escenario();
        arbol.datosNivel(arbol.getRaiz(), 3);
        assertEquals("dewgkm", arbol.getConcatenador());
    }

    @Test
    public void testDatosNivel3(){
        escenario();
        arbol.datosNivel(arbol.getRaiz(), 2);
        assertEquals("cfhs", arbol.getConcatenador());
    }

    @Test
    public void testDatosNivel4(){
        escenario();
        arbol.datosNivel(arbol.getRaiz(), 1);
        assertEquals("x", arbol.getConcatenador());
    }

}
