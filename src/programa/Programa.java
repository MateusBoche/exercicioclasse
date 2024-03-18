package programa;

import models.Animal;
import models.Cavalo;
import models.Girafa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {


        Programa app = new Programa();
        app.start();
    }

    List<Animal> lista = new ArrayList<>();

    private void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1- cadastrar Cavalo");
            System.out.println("2- cadastrar Girafa");
            System.out.println("3- Listar cavalos");
            System.out.println("4- Listar Girafas");
            System.out.println("5- Listar Animais");
            System.out.println("6- Remover Animais");
            System.out.println("7- Listar animais por contagem");
            int opcao = 0;

            try {
                System.out.println("opcao: ");
                opcao = sc.nextInt();



                switch (opcao) {
                    case 1:
                        System.out.println("Qual o id do cavalo? ");
                        String nome;
                        int id ;
                        int aprovacao = 0;
                        try{
                            id = sc.nextInt();


                            for(Animal animal:lista){
                                if(id == animal.getId()){
                                    aprovacao =1;
                                    if(aprovacao == 1){
                                        break;
                                    }
                                }else {
                                    aprovacao = 0;
                                }
                            }
                            if(aprovacao == 0){
                                sc.nextLine();
                                System.out.println("Qual o nome do cavalo? ");
                                nome = sc.nextLine();
                                cadastrarCavalo(id, nome);
                                break;
                            } else if (aprovacao ==1) {
                                System.out.println("ID ja existe");

                            }
                            break;



                        }catch (Exception exception){
                            System.out.println("Digite um numero inteiro!");
                        }
                        break;



                    case 2:
                        System.out.println("Qual o id da Girafa? ");
                        id = sc.nextInt();
                        aprovacao = 0;
                        for(Animal animal:lista){
                            if(id == animal.getId()){
                                aprovacao =1;
                                if(aprovacao == 1){
                                    break;
                                }
                            }else {
                                aprovacao = 0;
                            }
                        }
                        if(aprovacao == 0){
                            sc.nextLine();
                            System.out.println("Qual o nome da girafa? ");
                            nome = sc.nextLine();
                            cadastrarGirafa(id, nome);
                            break;
                        } else if (aprovacao ==1) {
                            System.out.println("ID ja existe");

                        }
                        break;

                    case 3:
                        System.out.println("Dados dos Cavalos: ");
                        listarCavalo();
                        break;

                    case 4:
                        System.out.println("Dados Girafas: ");
                        listarGirafa();
                        break;

                    case 5:
                        listarAnimais();
                        break;
                    case 6:
                        System.out.println("Digite o id que deseja remover: ");
                        int idRemove = sc.nextInt();
                        removerAnimalPorId(idRemove);
                        break;
                    case 7:
                        exibirQuantidadePorTipo();
                        break;


                }


            }catch (Exception e){
                System.out.println("digite um numero inteiro");
                sc.next();
                continue;

            }



        }

    }


    private void removerAnimalPorId(int idRemove) {
        Animal remover = new Animal() {
        };
        int teste = 2;
        for (Animal animal : lista) {
            if (idRemove == animal.getId()) {
                remover = animal;
                teste = 1;
                break;
            } else {
                teste = 0;
            }

        }
        if (teste == 1) {
            lista.remove(remover);
            System.out.println("animal removido com sucesso");
        } else if (teste == 0) {
            System.out.println("Id não encontrado");

        }


    }


    private void listarAnimais() {
        for (Animal animal : lista) {
            if (animal instanceof Girafa) {
                Girafa girafa = (Girafa) animal;
                System.out.println(girafa.tipo() + " id: " + girafa.getId() + " Nome: " + girafa.getNome());

            } else if (animal instanceof Cavalo) {
                Cavalo cavalo = (Cavalo) animal;
                System.out.println(cavalo.tipo() + " id: " + cavalo.getId() + " Nome: " + cavalo.getNome());


            }

        }

    }

    private void listarGirafa() {
        for (Animal animal : lista) {
            if (animal instanceof Girafa) {
                Girafa girafa = (Girafa) animal;
                System.out.println("id: " + girafa.getId() + " Nome: " + girafa.getNome());

            }

        }
    }

    private void exibirQuantidadePorTipo() {
        int contagemCavalo = 0;
        for (Animal animal : lista) {
            if (animal instanceof Cavalo) {
                contagemCavalo += 1;

            }

        }
        System.out.println("A quantidade de cavalo é " + contagemCavalo + " Cavalos");
        listarCavalo();


        int contagemGirafa = 0;
        for (Animal animal : lista) {
            if (animal instanceof Girafa) {
                contagemGirafa += 1;

            }

        }
        System.out.println("A quantidade de girafas é " + contagemGirafa     + " Girafas");
        listarGirafa();

        int totalAnimais = contagemCavalo + contagemGirafa;
        System.out.println("Totais animais cadastrados: " + totalAnimais);

    }




    private void listarCavalo() {
        for(Animal animal: lista){
            if(animal instanceof Cavalo){
                Cavalo cavalo = (Cavalo) animal;
                System.out.println("id: " + cavalo.getId() +" Nome: "+ cavalo.getNome());

            }

        }
    }


    private void cadastrarCavalo(int id, String nome) {
        Cavalo cavalo = new Cavalo(id,nome);
        lista.add(cavalo);
        System.out.println(cavalo.getNome());
        System.out.println("O cavalo "+ cavalo.getNome() + " foi inserido com sucesso!");

    }
    private void cadastrarGirafa(int id, String nome) {
        Girafa girafa = new Girafa(id,nome);
        lista.add(girafa);
        System.out.println(girafa.getNome());
        System.out.println("A Girafa "+ girafa.getNome() + " foi inserido com sucesso!");

    }
}
