/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolesenearios;


/**
 *
 * @author sala203
 */
public class ArbolEneario {

    private Nodo raiz;

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void insertarDatoAPadre(Nodo raiz, String DatoPadre, String DatoInsertar) {
        Nodo p = raiz;
        // nos sirve para recorrer la lista de nodos principal
        while (p != null) {
            // es un dato
            if (!p.isSw()) {
                // encontro al dato padre
                if (p.getDato().equals(DatoPadre)) {
                    // controlaremos un switche para saber si el padre existe
                    // es una raiz de un subarbol
                    if (p == raiz) {
                        Nodo temp = p;
                        Nodo ant = new Nodo();
                        while (temp != null) {
                            ant = temp;
                            // ubicamos el final de la lista
                            temp = temp.getLiga();
                        }
                        Nodo x = new Nodo(DatoInsertar);
                        ant.setLiga(x);
                        // break;
                    } // es una hoja
                    else {
                        Nodo x = new Nodo(DatoInsertar);
                        Nodo nRaiz = new Nodo(p.getDato());
                        nRaiz.setLiga(x);
                        p.setLigalista(nRaiz);
                        p.setSw(true);
                    }
                }
            }
            // en caso de que se encuentre el switche true, se procede a ir a la otra lista
            else {
                System.out.println("Hola estoy entrando recursivamente a un nodo lista");
                insertarDatoAPadre(p.getLigalista(), DatoPadre, DatoInsertar);

            }
            System.out.println("Hola estoy avanzando en la recursividad");
            p = p.getLiga();
        }
    }

    public void insertarDato(String Dato) {
        raiz = new Nodo(Dato);
    }

    private String concatenador = "";
    public void setConcatenador(String concatenador) {
        this.concatenador = concatenador;
    }
    public String getConcatenador() {
        return concatenador;
    }
    public void mostrarArbol(Nodo raiz) {
        Nodo p = raiz;
        while (p != null) {
            if (!p.isSw()) {
                // System.out.println(p.getDato());
                concatenador+=p.getDato();
            } else {
                mostrarArbol(p.getLigalista());
            }
            p = p.getLiga();
        }
    }

    private boolean isDato = false;

    public void setDato(boolean isDato) {
        this.isDato = isDato;
    }

    public boolean isDato() {
        return isDato;
    }

    public void buscarDato(Nodo raiz, String dato) {
        Nodo p = raiz;
        if (p != null) {
            if (!p.isSw()) {
                if (p.getDato().equals(dato)) {
                    setDato(true);
                }
            } else {
                buscarDato(p.getLigalista(), dato);
            }
            buscarDato(p.getLiga(), dato);
        }
    }

    public void mostrarRaices(Nodo raiz) {
        Nodo p = raiz;
        while (p != null) {
            if (!p.isSw()) {
                if (p.equals(raiz)) {
                    System.out.println(p.getDato());
                    concatenador+=p.getDato();
                }
            } else {
                mostrarRaices(p.getLigalista());
            }
            p = p.getLiga();
        }
    }

    private int contadorH = 0;

    public int getContadorHojas() {
        return contadorH;
    }

    public void setContadorHojas(int contadorHojas) {
        this.contadorH = contadorHojas;
    }

    public void contadorHojas(Nodo raiz) {
        Nodo p = raiz;
        while (p != null) {
            if (!p.isSw()) {
                if (!p.equals(raiz)) {
                    setContadorHojas(this.contadorH + 1);
                    
                }
            } else {
                contadorHojas(p.getLigalista());
            }
            p = p.getLiga();
        }
    }

    public void mostrarHojas(Nodo raiz) {
        Nodo p = raiz;
        while (p != null) {
            if (!p.isSw()) {
                if (!p.equals(raiz)) {
                    System.out.println(p.getDato());
                    concatenador+=p.getDato();
                }
            } else {
                mostrarHojas(p.getLigalista());
            }
            p = p.getLiga();
        }
    }

    private int gradoA = 0;

    public void setGradoArbol(int gradoArbol) {
        this.gradoA = gradoArbol;
    }

    public int getGradoArbol() {
        return gradoA;
    }

    public void gradoArbol(Nodo raiz) {
        int contadorA = 0;
        Nodo p = raiz;
        while (p != null) {
            if (!p.isSw()) {
                if (!p.equals(raiz)) {
                    contadorA++;
                }
            } else {
                //para almacenar el estado anterior
                contadorA++;
                setGradoArbol(contadorA);
                gradoArbol(p.getLigalista());
            }
            p = p.getLiga();
        }
        if (contadorA > gradoA) {
            setGradoArbol(contadorA);
        }
        
    }

    public void borrarDato(Nodo raiz, String DatoBorrar, Nodo padreAnterior) {
        if(padreAnterior == null && raiz.getDato().equals(DatoBorrar)){
            // raiz.setDato("");
            this.setRaiz(raiz.getLiga());
        }else{
            Nodo p = raiz;
            while (p != null) {
                if (!p.isSw()) {
                    if (p.getDato().equals(DatoBorrar)) {
                        if (p == raiz) {
                            if(padreAnterior==null){
                                
                            }
                            else{
                                raiz = raiz.getLiga();
                                padreAnterior.setLigalista(raiz);
                            }
                        } else {
                            Nodo temp = raiz;
                            Nodo ant = raiz;
                            while (temp != p) {
                                ant = temp;
                                temp = temp.getLiga();
                            }
                            ant.setLiga(temp.getLiga());
                        }
                    }
                } else {
                    borrarDato(p.getLigalista(), DatoBorrar, p);
                }
                p = p.getLiga();
            }
        }
    }

    private int gradoDato = 0;

    public int getGradoDato() {
        return gradoDato;
    }

    public void setGradoDato(int gradoDato) {
        this.gradoDato = gradoDato;
    }

    public void mostrarGradoDato(String dato, Nodo raiz) {
        Nodo p = raiz;
        while (p != null) {
            if (!p.isSw()) {
                if (p.getDato().equals(dato)) {
                    if (p == raiz) {
                        Nodo aux = p.getLiga();
                        while (aux != null) {
                            this.setGradoDato(getGradoDato() + 1);
                            aux = aux.getLiga();
                        }
                    } else {
                        this.setGradoDato(0);
                    }
                }
            } else {
                System.out.println("Hola estoy entrando recursivamente a un nodo lista");
                mostrarGradoDato(dato, p.getLigalista());
            }
            System.out.println("Hola estoy avanzando en la recursividad");
            p = p.getLiga();
        }
    }

    public void mostrarHijosDato(String dato, Nodo raiz) {
        Nodo p = raiz;
        while (p != null) {
            if (!p.isSw()) {
                if (p.getDato().equals(dato)) {
                    if (p == raiz) {
                        Nodo aux = p.getLiga();
                        while (aux != null) {
                            if (!aux.isSw()) {
                                System.out.println(aux.getDato());
                                concatenador+=aux.getDato();
                            } else {
                                Nodo interno = aux.getLigalista();
                                System.out.println(interno.getDato());
                                concatenador+=interno.getDato();
                            }
                            aux = aux.getLiga();
                        }
                    } else {
                        System.out.println("No tiene hijos");
                        concatenador="No tiene";
                    }
                }
            } else {
                System.out.println("Hola estoy entrando recursivamente a un nodo lista");
                mostrarHijosDato(dato, p.getLigalista());
            }
            System.out.println("Hola estoy avanzando en la recursividad");
            p = p.getLiga();
        }
    }

    public void mostrarHermanosDato(String dato, Nodo raiz, Nodo padreAnterior) {
        // if (!padreAnterior.equals(raiz) && !raiz.getDato().equals(dato)) {
            
        // }
        // si la raiz que entra es igual al padre anterior que es como entra la primera vez, y el dato contenido por la raiz es el que se busca entonces se procede a decir que la raiz no tiene 
        if(raiz.equals(padreAnterior) && dato.equals(raiz.getDato())){
            System.out.println("La raiz no tiene hermanos");
            concatenador+="No tiene";
        }
        else{
            Nodo p = raiz;
            while (p != null) {
                //si es un dato
                if (!p.isSw()) {
                    // en caso de que el dato sea el que necesitamos, entonces
                    if (p.getDato().equals(dato)) {
                        // teniendo la raiz anterior simplemente en el caso de encontrar hijo vamos a
                        // mostrar los hijos de este padre
                        // en el caso de que sea una raiz simplemente tenemos en cuenta a la raiz
                        // anterior
                        if (p == raiz) {
                            //se vuelve a la raiz
                            Nodo q = padreAnterior.getLiga();
                            // mostramos todos los datos que no sean el parcero
                            while (q != null) {
                                if (!q.isSw() && !q.getDato().equals(dato)) {
                                    concatenador+=q.getDato();
                                    System.out.println(q.getDato());
                                } else {
                                    //esto con el fin de entrar y tomar el primer elemento de las listas liga
                                    if (!q.getLigalista().getDato().equals(dato)) {
                                        System.out.println(q.getDato());
                                        concatenador+=q.getLigalista().getDato();
                                    }
                                }
                                q = q.getLiga();
                            }
                        }
                        // si no es la raiz simplemente leemos todos los datos diferentes a raiz y dato
                        else {
                            Nodo q = raiz.getLiga();
                            while (q != null) {
                                if (!q.getDato().equals(dato)) {
                                    System.out.println(q.getDato());
                                    concatenador+=q.getDato();
                                }
                                q = q.getLiga();
                            }
                        }
                    }
                } else {
                    mostrarHermanosDato(dato, p.getLigalista(), raiz);
                }
                p = p.getLiga();
            }
        }
    }

    private int niveldato = 1;
    public int getNiveldato() {
        return niveldato;
    }
    public void setNiveldato(int niveldato) {
        this.niveldato = niveldato;
    }
    public void mostrarNivelDato(Nodo raiz, String dato, int nivelDato){
        Nodo p = raiz;
        while (p!=null) {
            if(!p.isSw()){
                if(p.getDato().equals(dato)){
                    if(p==raiz){
                        this.setNiveldato(nivelDato);
                        break;
                    }
                    else{
                        nivelDato+=1;
                        this.setNiveldato(nivelDato);
                        break;
                    }
                }
            }
            else{
                mostrarNivelDato(p.getLigalista(), dato, nivelDato+1);
            }
            p=p.getLiga();
        }
    }

    private int nivelMax = 0;
    public int getNivelMax() {
        return nivelMax;
    }
    public void setNivelMax(int nivelMax) {
        this.nivelMax = nivelMax;
    }
    public void alturaArbol(Nodo raiz){
        Nodo p = raiz;
        while (p!=null) {
            if(!p.isSw()){
                //es un dato entonces procedemos a calcula el nivel del dato
                this.mostrarNivelDato(this.getRaiz(), p.getDato(), 1);
                if(this.getNiveldato()>this.getNivelMax()){
                    this.setNivelMax(this.getNiveldato());
                    this.setNiveldato(1);
                }
            }else{
                alturaArbol(p.getLigalista());
            }
            p=p.getLiga();
        }
    }


    private String padreAnt;
    public void setPadreAnt(String padreAnt) {
        this.padreAnt = padreAnt;
    }public String getPadreAnt() {
        return padreAnt;
    }
    public void mostrarPadreDato(Nodo raiz, Nodo padreAnterior, String dato){
        if(padreAnterior.equals(raiz) && raiz.getDato().equals(dato)){
            setPadreAnt("La raiz no puede tener padre");
        }else{
            Nodo p = raiz;
            while(p!=null){
                if(p.isSw()){
                    mostrarPadreDato(p.getLigalista(), raiz, dato);
                }else{
                    if(p.getDato().equals(dato)){
                        if(p!=raiz){
                            this.setPadreAnt(raiz.getDato());
                        }else{
                            this.setPadreAnt(padreAnterior.getDato());
                        }
                    }
                }
                p=p.getLiga();
            }
        }
    }

    public void datosNivel(Nodo raiz, int nivel){
        Nodo p = raiz;
        while (p!=null) {
            if(!p.isSw()){
                this.mostrarNivelDato(this.getRaiz(), p.getDato(), 1);
                if(this.getNiveldato()==nivel){
                    concatenador+=p.getDato();
                    // setConcatenador("");
                }
            }else{
                datosNivel(p.getLigalista(), nivel);
            }
            p = p.getLiga();
        }
    }
}
