package com.example.pre_examen;

public class ReciboNomina {




    int numRecibo;
    String nombre;
    float horasTrabajadas;
    float horasExtras;
    int puesto;
    float impuestoPor;

    public float getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(float horasExtras) {
        this.horasExtras = horasExtras;
    }

    public int getNumRecibo() {
        return numRecibo;
    }

    public void setNumRecibo(int numRecibo) {
        this.numRecibo = numRecibo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(float horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public float getImpuestoPor() {
        return impuestoPor;
    }

    public void setImpuestoPor(float impuestoPor) {
        this.impuestoPor = impuestoPor;
    }

    public float calcularSubtotal()
    {
        double resultado=0.0;
        double pagoBase=200;
            if(this.getPuesto()==1)
            {
                resultado=pagoBase*this.getHorasTrabajadas()+(pagoBase+(0.2)*2*this.getHorasExtras());
            } else if (this.getPuesto()==2) {
                resultado=pagoBase*this.getHorasTrabajadas()+(pagoBase+(0.5)*2*this.getHorasExtras());

            } else if (this.getPuesto()==3) {
                resultado=pagoBase*this.getHorasTrabajadas()+(pagoBase+(1.0)*2*this.getHorasExtras());

            }
        return (float) resultado;
    }

    public float calcularImpuesto()
    {
        double resultado=0.0;

        resultado=this.calcularSubtotal()*0.16;
        return (float) resultado;
    }

    public float calcularTotalPagar()
    {
        double pagar=0.0;

        pagar=this.calcularSubtotal()-this.calcularImpuesto();

        return (float) pagar;
    }





}
