package miTiendita.productos;

public class Producto {
    int clave;
    String descripcion;
    double punit;

    Producto(int clave, String descripcion, double punit)
    {
        this.clave = clave;
        this.descripcion = descripcion;
        this.punit = punit;
    }

    public double getPunit() {
        return punit;
    }

    public String toString()
    {
        return descripcion;
    }

    public int getClave() {
        return clave;
    }

}