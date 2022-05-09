package com.bragagustavo.github.DesafioJava.enums;


public enum Type {

    ECOMMERCE(0,"Comercio Online"),
    PHYSICAL_STORE(1,"Loja Fisica");

    private int cod;
    private String descricao;

    Type(int id, String descricao) {
        this.cod = id;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Type toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(Type x : Type.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("Id Invalido: " + cod);
    }
}
