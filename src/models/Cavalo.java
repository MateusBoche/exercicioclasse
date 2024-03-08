package models;

public class Cavalo extends Animal{
    public Cavalo(int id, String nome) {
        setId(id);
        setNome(nome);
    }
    public String tipo(){
        return "Tipo: Cavalo";
    }
}
