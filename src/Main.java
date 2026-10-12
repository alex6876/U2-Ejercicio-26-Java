public class Main {
    public static void main(String[] args) {

        Impresor laser = new ImpresorLaser("HP 1200", 1200, 20);
        Impresor tinta = new ImpresoraTinta("Epson", 600,0);

        System.out.println("--- Impresora Láser ---");
        laser.mostrarEstado();
        laser.imprimirDocumento("Imforme.pdf");
        laser.mostrarEstado();

        System.out.println();

        System.out.println("--- Impresora Tinta ---");
        tinta.mostrarEstado();
        tinta.imprimirDocumento("Imforme ed.fisica.pdf");
        tinta.mostrarEstado();
    }
}