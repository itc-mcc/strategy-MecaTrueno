package miTiendita.venta;

import miTiendita.descuento.*;
import miTiendita.productos.Producto;
import java.util.*;

public class Venta {
    int diaSemana;
    boolean terceraEdad;
    List<LineaDeDetalle> ld = new ArrayList<LineaDeDetalle>();
    IDesctoStrategy IDescto;

    public Venta(int diaSemana, boolean terceraEdad)
    {
        this.diaSemana = diaSemana;
        this.terceraEdad = terceraEdad;

        addDescto();
    }


    public void addProducto(Producto p, double ctd)
    {
        ld.add(new LineaDeDetalle(p,ctd));
    }

    public void addDescto()
    {
        if(diaSemana==1){
            IDescto = new AdultoMayor();
        }
        if(diaSemana==2){
            IDescto = new SinDescuento();
        }
        if(diaSemana==3){
            IDescto = new MenonitaDescuento();
        }
        if(diaSemana==4){
            IDescto = new FrutaDescuento();
        }
        if(diaSemana==5){
            IDescto = new EmbutidosLacteos();
        }
        if(diaSemana==6){
            IDescto = new SinDescuento();
        }
        if(diaSemana==7){
            IDescto = new AdultoMayor();
        }
    }

    public double getTotal()
    {
        double total = 0;
        for (LineaDeDetalle a :
                this.getLd()) {
            total += (a.getCtd() * a.getP().getPunit());
        }
        return (total- IDescto.getDescto(this)) + .16*(total- IDescto.getDescto(this));
    }

    public List<LineaDeDetalle> getLd() {
        return ld;
    }
}