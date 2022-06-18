/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arbolesenearios;

import javax.swing.JOptionPane;

/**
 *
 * @author sala203
 */
public class MainArboles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String opc = " ";
        String dato;
        ArbolEneario tree = new ArbolEneario();
        do {
            opc = JOptionPane.showInputDialog(null, " Escriba el numero de la accion que desea realizar"
                    + "\n1. Iniciar arbol. "
                    + "\n2. Insertar. "
                    + "\n3. Mostrar."
                    + "\n4. Buscar dato"
                    + "\n5. Mostrar raices"
                    + "\n6. Contar hojas"
                    + "\n7. Mostrar hojas "
                    + "\n8. Mostrar grado del arbol "
                    + "\n9. Eliminar dato"
                    + "\n10. Mostrar grado de un dato dado"
                    + "\n11. Mostrar hijos de dato dado"
                    + "\n12. Mostrar hermanos de un dato dado"
                    + "\n13. Mostrar nivel de un dato "
                    + "\n14. Mostrar altura de un arbol"
                    + "\n15. Mostrar padre de un dato dado"
                    + "\n16. Mostrar elementos de un nivel"
                    + "\n20. salir. ", null, 0);
            switch (opc) {
                case "1":
                    tree.setConcatenador("");
                    tree.setGradoArbol(0);
                    tree.setGradoDato(0);
                    tree.setNiveldato(1);
                    tree.setRaiz(new Nodo("x"));
                    tree.insertarDatoAPadre(tree.getRaiz(), "x", "c");
                    tree.insertarDatoAPadre(tree.getRaiz(), "x", "f");
                    tree.insertarDatoAPadre(tree.getRaiz(), "x", "h");
                    tree.insertarDatoAPadre(tree.getRaiz(), "x", "s");
                    tree.insertarDatoAPadre(tree.getRaiz(), "c", "d");
                    tree.insertarDatoAPadre(tree.getRaiz(), "c", "e");
                    tree.insertarDatoAPadre(tree.getRaiz(), "h", "w");
                    tree.insertarDatoAPadre(tree.getRaiz(), "h", "g");
                    tree.insertarDatoAPadre(tree.getRaiz(), "h", "k");
                    tree.insertarDatoAPadre(tree.getRaiz(), "h", "m");
                    tree.insertarDatoAPadre(tree.getRaiz(), "w", "a");
                    tree.insertarDatoAPadre(tree.getRaiz(), "w", "b");
                    tree.insertarDatoAPadre(tree.getRaiz(), "g", "z");
                    break;
                case "2":
                    System.out.println("------Insertando Dato------");
                    if (tree.getRaiz() != null) {
                        tree.insertarDatoAPadre(tree.getRaiz(),
                                JOptionPane.showInputDialog(null, " Escriba el elemento padre", null, 0),
                                JOptionPane.showInputDialog(null, " Escriba el elemento a insertar", null, 0));
                    } else {
                        tree.insertarDato(JOptionPane.showInputDialog(null, "Escriba el elemento a insertar"));
                    }
                    break;
                case "3":
                    System.out.println("------Mostrando Arbol------");
                    tree.mostrarArbol(tree.getRaiz());
                    JOptionPane.showMessageDialog(null, "el arbol\n"+tree.getConcatenador());
                    tree.setConcatenador("");
                    break;
                case "4":
                    System.out.println("------Buscando Dato------");
                    tree.buscarDato(tree.getRaiz(), JOptionPane.showInputDialog(null, "Escriba el dato a buscar"));
                    if (tree.isDato()) {
                        System.out.println("El dato se encuentra en el arbol");
                    } else {
                        System.out.println("El dato no se encuentra en el arbol");
                    }
                    tree.setDato(false);
                    break;
                case "5":
                    System.out.println("------Mostrando Raices------");
                    tree.mostrarRaices(tree.getRaiz());
                    JOptionPane.showMessageDialog(null, "las raices del arbol son \n\n" + tree.getConcatenador());
                    tree.setConcatenador("");
                    break;
                case "6":
                    System.out.println("------Contando Hojas------");
                    tree.contadorHojas(tree.getRaiz());
                    System.out.println("El arbol tiene " + tree.getContadorHojas() + " Hojas");
                    JOptionPane.showMessageDialog(null, "El arbol tiene \n\n" + tree.getContadorHojas());
                    tree.setContadorHojas(0);
                    break;
                case "7":
                    System.out.println("------Mostrando Hojas------");
                    tree.mostrarHojas(tree.getRaiz());
                    JOptionPane.showMessageDialog(null, "Las hojas del arbol son " + tree.getConcatenador());
                    tree.setConcatenador("");
                    break;
                case "8":
                    System.out.println("------Grado del arbol------");
                    tree.gradoArbol(tree.getRaiz());
                    JOptionPane.showMessageDialog(null, "El grado del arbo es " + tree.getGradoArbol());
                    System.out.println("El grado del arbol es " + tree.getGradoArbol() + " .");
                case "9":
                    System.out.println("------Eliminar dato------");
                    Nodo aux = tree.getRaiz();
                    dato = JOptionPane.showInputDialog(null, "Escriba el elemento a eliminar");
                    tree.borrarDato(aux, dato, null);
                    tree.mostrarArbol(tree.getRaiz());
                    tree.setRaiz(aux);
                    JOptionPane.showConfirmDialog(null, "Se elimino el dato " + dato + "\n" + tree.getConcatenador());
                    tree.setConcatenador("");
                    break;
                case "10":
                    System.out.println("------Mostrar grado de dato dado------");
                    dato = JOptionPane.showInputDialog(null, "Escriba el elemento a mostrar grado");
                    tree.mostrarGradoDato(dato, tree.getRaiz());
                    System.out.println("El grado del dato " + dato + " es " + tree.getGradoDato());
                    JOptionPane.showMessageDialog(null, "El grado del dato " + dato + " es " + tree.getGradoDato());
                    tree.setGradoDato(0);
                    break;
                case "11":
                    System.out.println("------Mostrar hijos de dato dado------");
                    dato = JOptionPane.showInputDialog(null, "Escriba el dato Padre, del cual desea mostrar hijos");
                    tree.mostrarHijosDato(dato, tree.getRaiz());
                    JOptionPane.showMessageDialog(null,
                            "Los hijos del dato " + dato + " son\n\n" + tree.getConcatenador());
                    tree.setConcatenador("");
                    break;
                case "12":
                    System.out.println("------Mostrar Hermanos de dato dado------");
                    dato = JOptionPane.showInputDialog(null, "Escriba el dato del cual desea mostrar hermanos");
                    tree.mostrarHermanosDato(dato, tree.getRaiz(), tree.getRaiz());
                    JOptionPane.showMessageDialog(null,
                            "Los hermanos del dato " + dato + " son\n\n" + tree.getConcatenador());
                    break;
                case "13":
                    System.out.println("------Mostrar Nivel de dato dado------");
                    dato = JOptionPane.showInputDialog(null, "Escriba el dato del cual desea mostrar el nivel");
                    tree.mostrarNivelDato(tree.getRaiz(), dato, 1);
                    JOptionPane.showMessageDialog(null, "El nivel del dato " + dato + " es\n\n" + tree.getNiveldato());
                    tree.setNiveldato(0);
                    break;
                case "14":
                    System.out.println("------Mostrar altura del arbol------");
                    tree.alturaArbol(tree.getRaiz());
                    JOptionPane.showMessageDialog(null, "La altura del arbol es \n\n" + tree.getNivelMax());
                    tree.setNivelMax(0);
                    break;
                case "15":
                    System.out.println("------Mostrar padre de dato dado------");
                    dato = JOptionPane.showInputDialog(null, "Escriba el dato del cual desea mostrar padre");
                    tree.mostrarPadreDato(tree.getRaiz(), tree.getRaiz(), dato);
                    JOptionPane.showMessageDialog(null, "El padre de "+dato+ " es "+ tree.getPadreAnt());
                    break;
                case "16":
                    System.out.println("------Mostrar datos de un nivel------");
                    int nivel = Integer.parseInt(JOptionPane.showInputDialog(null, "Escriba el nivel del cual desea mostrar datos"));
                    tree.datosNivel(tree.getRaiz(), nivel);
                    JOptionPane.showMessageDialog(null, "Los datos del nivel "+ nivel + " son \n\n"+ tree.getConcatenador());
                    tree.setConcatenador("");
                    break;
            }
        } while (!opc.equals("20"));
    }

}
