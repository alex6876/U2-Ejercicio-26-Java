public abstract class Impresor {
    String modelo;
    int resolucion;


    public Impresor(String modelo, int resolucion) {
        this.modelo = modelo;
        this.resolucion = resolucion;
    }


    public abstract void imprimirDocumento(String documento);

    public void mostrarEstado(){
        System.out.println("Modelo: " + modelo);
        System.out.println("Resolucion: " + resolucion + " DPI");
    }
}
