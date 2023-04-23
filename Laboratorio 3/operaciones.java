package com.example.applabs_3scedeo_csnchez_aurriola;

public class Operaciones{
    private int opc,n1,n2;

    public void Operaciones(int opc,int n1, int n2){
        this.opc = opc;
        this.n1 = n1;
        this.n2 = n2;
    }
    public double Sumar(){
        double resp = n1+n2;
        return resp;
    }

    public double Restar(){
        double resp = n1-n2;
        return resp;
    }

    public double Dividir(){
        double resp = n1/n2;
        return resp;
    }

    public double Multiplicar(){
        double resp = n1*n2;
        return resp;
    }
}
