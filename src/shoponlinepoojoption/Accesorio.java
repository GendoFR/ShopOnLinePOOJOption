package shoponlinepoojoption;

import javax.swing.JOptionPane;

public class Accesorio extends Producto {
    protected double peso;
    protected String metal;

    public Accesorio(double peso, String metal, String desc, double precio, double codigo) {
        super(desc, precio, codigo);
        this.peso = peso;
        this.metal = metal;
    }
    
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }
    
    public void arancelAduanero(){
        this.precio = (this.precio + (this.precio * 0.10));
        JOptionPane.showMessageDialog(null, "arancel duanero: " + precio);
    }

    public void arancelTransporte(){
        this.precio = (this.precio + (this.precio * 0.2));
        JOptionPane.showMessageDialog(null, "arancel transporte: " + precio);
    }

    @Override
    public String toString(){
        return super.toString() + ( "Metal: (" + this.metal + ") Peso: " + this.peso + "g");
    }
    
    @Override
    public double getPrecio() {
        if (this.metal.equalsIgnoreCase("oro")){
            this.setPrecio(this.precio + (17629.64 * this.peso));
        }
        if(this.metal.equalsIgnoreCase("plata")){
            this.setPrecio(this.precio + (208.03 * this.peso));
        }
        if(this.metal.equalsIgnoreCase("acero")){
            this.setPrecio(this.precio + (50.6 * this.peso));
        }
        
        this.arancelAduanero();
        this.arancelTransporte();
        
        return this.precio;
    }
}
