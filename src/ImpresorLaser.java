public class ImpresorLaser extends Impresor {

    int niveltoner;

    public ImpresorLaser(String modelo, int resolucion, int niveltoner) {
        super(modelo, resolucion);
        this.niveltoner = niveltoner;
    }

    @Override
    public void imprimirDocumento(String documento) {
        if (niveltoner <= 0) {
            System.out.println("Error: toner agotado");
        }else{
            System.out.println("Imprimiendo con laser: " + documento);
            niveltoner -= 10;

            if(niveltoner < 0) {
                niveltoner = 0;
            }

            System.out.println("Impresion realizada correctamente.");
        }
    }

    @Override
    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("nivel de toner: " + niveltoner + "%");
    }
}
