public class ImpresoraTinta extends Impresor{

    int nivelCartucho;

    public ImpresoraTinta(String modelo, int resolucion, int nivelCartucho){
        super(modelo, resolucion);
        this.nivelCartucho = nivelCartucho;
    }

    @Override
    public void imprimirDocumento(String documento) {
        if (nivelCartucho <= 0){
            System.out.println("Error: cartucho de tinta agotado.");
        }else{
            System.out.println("Imprimiendo con tinta: "+ documento);
            nivelCartucho -= 10;

            if(nivelCartucho < 0){
                nivelCartucho = 0;
            }

            System.out.println("Impresion realizada correctamente.");
        }
    }

    @Override
    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("Nivel de cartucho: " + nivelCartucho + "%");
    }
}
