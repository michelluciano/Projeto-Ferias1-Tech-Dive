package SistemaFuncionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static ArrayList<Colaborador> banco = new ArrayList<>(); // Array banco de dados
    Scanner input = new Scanner(System.in);
    Colaborador auxBanco = null;
    int opcao = 0;
    String auxPesquisa;

    public static void main(String[] args) {
        //populandos banco de dados
        Colaborador colaborador = new Colaborador(1,"Marcos",20,"Masculino","Ativo",1000,10);
        banco.add(colaborador);

        Colaborador colaborador2 = new Colaborador(5,"Jones",20,"Masculino","Inativo",1000,10);
        banco.add(colaborador2);

        LiderTecnico lidertecnico = new LiderTecnico(2,"Michel",21,"Masculino","Ativo",2000,10,200);
        banco.add(lidertecnico);

        GerenteDeDepartamento gerenteDep = new GerenteDeDepartamento(3,"Luciano",22,"Masculino","Ativo",3000,10,30);
        banco.add(gerenteDep);

        GerenteGeral gerenteGeral = new GerenteGeral(4,"Mauricio",24,"Masculino","Ativo",4000,10,40,400);
        banco.add(gerenteGeral);

        // menu principal do sistema
        Main main = new Main();
        main.menuPrincipal();
    }

    private void menuPrincipal() {
        while(true){
            //limparTela();
            System.out.println("\n::          T E C H  D I V E             ::\n");
            System.out.println("\n:: S I S T E M A   F U N C I O N A R I O ::\n");
            System.out.println("Bem-vindo(a) ao sistema. Escolha a opção desejada:");
            System.out.println("1 - Adicionar funcionário");
            System.out.println("2 - Ver detalhes de um funcionário");
            System.out.println("3 - Demitir funcionário");
            System.out.println("4 - Atualizar informações de um funcionário");
            System.out.println("5 - Listar todos os funcionários");
            System.out.println("6 - Listar somente os funcionários trabalhando");
            System.out.println("7 - Listar somente os funcionários demitidos");
            System.out.println("8 - Sair");
            System.out.print("Sua opção: ");
            opcao = input.nextInt(); // lê a opção do usuário
            input.nextLine();

            switch(opcao){
                case 1:
                     // cadastrar um funcionario
                    menuCadastrarFuncionarios();
                    break;
                case 2:
                    //pesquisar
                    System.out.println("Digite o Codigo Identificador do Funcionario ou Nome:");
                    auxPesquisa = input.nextLine();
                    auxBanco = pesquisarFunc(auxPesquisa);
                    if (auxBanco == null) {
                        System.out.println("\nCliente não encontrado.");
                    } else {
                        System.out.println("------------------------------------");
                        System.out.println(" - Id:               \t" + auxBanco.getId());
                        System.out.println(" - Nome:             \t" + auxBanco.getNome());
                        System.out.println(" - Idade:            \t" + auxBanco.getIdade());
                        System.out.println(" - Sexo:             \t" + auxBanco.getSexo());
                        System.out.println(" - Status:           \t" + auxBanco.getStatus());
                        System.out.println(" - Salário Bruto:    \t" + auxBanco.getSalarioBruto());
                        System.out.println(" - Descontos:        \t" + auxBanco.getDescontos());
                        System.out.println(" - Salário Liquido:  \t" + auxBanco.calcularSalario());
                    }

                    break;
                case 3:
                    // demitir funcionario
                    System.out.println("Digite o Codigo Identificador do funcionario a ser atualizado:");
                    auxPesquisa = input.nextLine();
                    auxBanco = pesquisarFunc(auxPesquisa);
                    if (auxBanco == null) {
                        System.out.println("\nFuncionario não encontrado.");
                    } else {
                        System.out.println("------Dados Atuais-----------");
                        System.out.println(" - Id:               \t" + auxBanco.getId());
                        System.out.println(" - Nome:             \t" + auxBanco.getNome());
                        System.out.println(" - Idade:            \t" + auxBanco.getIdade());
                        System.out.println(" - Sexo:             \t" + auxBanco.getSexo());
                        System.out.println(" - Status:           \t" + auxBanco.getStatus());
                        System.out.println(" - Salário Bruto:    \t" + auxBanco.getSalarioBruto());
                        System.out.println(" - Descontos:        \t" + auxBanco.getDescontos());
                        System.out.println("-----------------------------");
                        System.out.println("-----------------------------");
                        System.out.print("\nDeseja DEMITIR o colaborador?"+
                                         "\n1 - para DEMITIR"+
                                         "\n2 - para CANCELAR\n");
                        int opcaoDemi = input.nextInt();
                        if(opcaoDemi == 1) {
                            auxBanco.setStatus("Inativo");
                            System.out.println("-----STATUS ATUALIZADO COM SUCESSO---");

                        }else{
                            System.out.println("-----CANCELADA A ATUALIZAÇÃO---");

                        }
                    }
                    break;
                case 4:
                    //atualizar
                    System.out.println("Digite o Codigo Identificador do funcionario a ser atualizado:");
                    auxPesquisa = input.nextLine();
                    auxBanco = pesquisarFunc(auxPesquisa);
                    if (auxBanco == null) {
                        System.out.println("\nFuncionario não encontrado.");
                    } else {
                        System.out.println("------Dados Atuais-----------");
                        System.out.println(" - Id:               \t" + auxBanco.getId());
                        System.out.println(" - Nome:             \t" + auxBanco.getNome());
                        System.out.println(" - Idade:            \t" + auxBanco.getIdade());
                        System.out.println(" - Sexo:             \t" + auxBanco.getSexo());
                        System.out.println(" - Status:           \t" + auxBanco.getStatus());
                        System.out.println(" - Salário Bruto:    \t" + auxBanco.getSalarioBruto());
                        System.out.println(" - Descontos:        \t" + auxBanco.getDescontos());
                        System.out.println("-----------------------------");
                        System.out.println("---Atualize os novos dados---");
                        System.out.print("\nDigite o nome do colaborador: ");
                        String nome = input.nextLine();
                        System.out.print("Digite a idade do colaborador: ");
                        int idade = input.nextInt();
                        System.out.print("Digite o sexo do colaborador: ");
                        String sexo = input.nextLine();
                        input.nextLine();
                        System.out.println("Digite o salário bruto do colaborador:");
                        double salarioBruto = input.nextDouble();
                        System.out.println("Digite o valor do desconto do colaborador:");
                        double desconto = input.nextDouble();
                        auxBanco.setNome(nome);
                        auxBanco.setIdade(idade);
                        auxBanco.setSexo(sexo);
                        auxBanco.setSalarioBruto(salarioBruto);
                        auxBanco.setDescontos(desconto);
                        System.out.println("-----DADOS ATUALIZADOS COM SUCESSO---");
                    }
                    break;
                case 5:
                    // listar todos
                    System.out.println("-------LISTA DE CLIENTES-------");
                    if (banco.isEmpty()) {
                        System.out.println("Não existem clientes cadastrados.");
                    } else {
                        for (int i = 0; i < banco.size(); i++) {
                            auxBanco = banco.get(i);
                            System.out.println("------------------------------------");
                            System.out.println(" - Id:               \t" + auxBanco.getId());
                            System.out.println(" - Nome:             \t" + auxBanco.getNome());
                            System.out.println(" - Idade:            \t" + auxBanco.getIdade());
                            System.out.println(" - Sexo:             \t" + auxBanco.getSexo());
                            System.out.println(" - Status:           \t" + auxBanco.getStatus());
                            System.out.println(" - Salário Bruto:    \t" + auxBanco.getSalarioBruto());
                            System.out.println(" - Descontos:        \t" + auxBanco.getDescontos());
                            System.out.println(" - Salário Liquido:  \t" + auxBanco.calcularSalario());
                            if (auxBanco instanceof Colaborador){
                                System.out.println(" - Cargo: \t Colaborador");
                            }else if(auxBanco instanceof LiderTecnico){
                                System.out.println(" - Cargo: \t Lider Tecnico");
                            }else if(auxBanco instanceof GerenteDeDepartamento){
                                System.out.println(" - Cargo: \t Gerente De Departamento");
                            }else{
                                System.out.println(" - Cargo: \t Gerente Geral");
                            }
                        }
                    }
                    System.out.println("--------------------------------");
                    break;
                case 6:
                    // lista funcionario trabalhando

                    if (banco.isEmpty()) {
                        System.out.println("Não existem funcionarios cadastrados.");
                    } else {
                        System.out.println("-------LISTA DE FUNCIONARIOS-------");
                        for (int i = 0; i < banco.size(); i++) {
                            if (banco.get(i).getStatus().equals("Ativo")) {
                                auxBanco = banco.get(i);
                                System.out.println("------------------------------------");
                                System.out.println(" - Id:               \t" + auxBanco.getId());
                                System.out.println(" - Nome:             \t" + auxBanco.getNome());
                                System.out.println(" - Idade:            \t" + auxBanco.getIdade());
                                System.out.println(" - Sexo:             \t" + auxBanco.getSexo());
                                System.out.println(" - Status:           \t" + auxBanco.getStatus());
                                System.out.println(" - Salário Bruto:    \t" + auxBanco.getSalarioBruto());
                                System.out.println(" - Descontos:        \t" + auxBanco.getDescontos());
                                System.out.println(" - Salário Liquido:  \t" + auxBanco.calcularSalario());
                                if (auxBanco instanceof Colaborador) {
                                    System.out.println(" - Cargo: \t Colaborador");
                                } else if (auxBanco instanceof LiderTecnico) {
                                    System.out.println(" - Cargo: \t Lider Tecnico");
                                } else if (auxBanco instanceof GerenteDeDepartamento) {
                                    System.out.println(" - Cargo: \t Gerente De Departamento");
                                } else {
                                    System.out.println(" - Cargo: \t Gerente Geral");
                                }
                            }
                        }
                    }
                    break;
                case 7:
                    // chama o menu do cliente
                    // lista funcionario demitidos

                    if (banco.isEmpty()) {
                        System.out.println("Não existem funcionarios cadastrados.");
                    } else {
                        System.out.println("-------LISTA DE FUNCIONARIOS_-------");
                        for (int i = 0; i < banco.size(); i++) {
                            if (banco.get(i).getStatus().equals("Inativo")) {
                                auxBanco = banco.get(i);

                                System.out.println("------------------------------------");
                                System.out.println(" - Id:               \t" + auxBanco.getId());
                                System.out.println(" - Nome:             \t" + auxBanco.getNome());
                                System.out.println(" - Idade:            \t" + auxBanco.getIdade());
                                System.out.println(" - Sexo:             \t" + auxBanco.getSexo());
                                System.out.println(" - Status:           \t" + auxBanco.getStatus());
                                System.out.println(" - Salário Bruto:    \t" + auxBanco.getSalarioBruto());
                                System.out.println(" - Descontos:        \t" + auxBanco.getDescontos());
                                System.out.println(" - Salário Liquido:  \t" + auxBanco.calcularSalario());
                                if (auxBanco instanceof Colaborador) {
                                    System.out.println(" - Cargo: \t Colaborador");
                                } else if (auxBanco instanceof LiderTecnico) {
                                    System.out.println(" - Cargo: \t Lider Tecnico");
                                } else if (auxBanco instanceof GerenteDeDepartamento) {
                                    System.out.println(" - Cargo: \t Gerente De Departamento");
                                } else {
                                    System.out.println(" - Cargo: \t Gerente Geral");
                                }
                            }
                        }
                    }
                    break;
                case 8:
                    System.out.println("\nObrigado por usar o Sistema Tech Dive\n");
                    System.exit(0);
            }
        }
    }// fim menu
    // MENU CADASTRAR FUNCIONARIOS
    public int menuCadastrarFuncionarios() {
        opcao =0;
        System.out.println("=========================================");
        System.out.println("   C A D A S T R O   T E C H D I V E     ");
        System.out.println("=========================================");
        System.out.println("Escolha uma opção abaixo:");
        System.out.println("1 - Cadastrar Colaborador");
        System.out.println("2 - Cadastrar Líder técnico");
        System.out.println("3 - Cadastrar Gerente de departamento");
        System.out.println("4 - Cadastrar Gerente Geral");
        System.out.println("00 - Voltar");
        System.out.println("=========================================");
        opcao = input.nextInt();
        input.nextLine();

        switch (opcao) {
            case 1://cadastrar contas
                System.out.print("\nDigite o nome do colaborador: ");
                String nome = input.nextLine();
                System.out.print("Digite a idade do colaborador: ");
                int idade = input.nextInt();
                System.out.print("Digite o sexo do colaborador: ");
                String sexo = input.nextLine();
                input.nextLine();
                System.out.print("Digite o Status do colaborador: ");
                String status = input.nextLine();
                System.out.println("Digite o salário bruto do colaborador:");
                double salarioBruto = input.nextDouble();
                System.out.println("Digite o valor do desconto do colaborador:");
                double desconto = input.nextDouble();

                Pessoa.contadorPessoas++; //incrementar o contador de contas
                Colaborador col = new Colaborador(Pessoa.contadorPessoas,nome,idade,sexo,status,salarioBruto,desconto);
                banco.add(col); //adiciona no ArrayList
                // e finalmente mostramos uma mensagem de sucesso.
                System.out.println("\nColaborador criado com sucesso!");
                System.out.println(banco);
                break;
            case 2:
                System.out.print("\nDigite o nome do líder técnico: ");
                 nome = input.nextLine();
                System.out.print("Digite a idade do líder técnico: ");
                 idade = input.nextInt();
                System.out.print("Digite o sexo do líder técnico: ");
                 sexo = input.nextLine();
                System.out.print("Digite o Status do líder técnico: ");
                 status = input.nextLine();
                System.out.println("Digite o salário bruto do líder técnico:");
                 salarioBruto = input.nextDouble();
                System.out.println("Digite o valor do desconto do líder técnico:");
                 desconto = input.nextDouble();

                Pessoa.contadorPessoas++; //incrementar o contador de contas
                LiderTecnico lidTec = new LiderTecnico(Pessoa.contadorPessoas,nome,idade,sexo,status,salarioBruto,desconto,200);
                banco.add(lidTec); //adiciona no ArrayList
                // e finalmente mostramos uma mensagem de sucesso.
                System.out.println("\nLider Técnico criado com sucesso!");
                System.out.println(banco);
                break;
            case 3:
                System.out.print("\nDigite o nome do gerente de departamento: ");
                nome = input.nextLine();
                System.out.print("Digite a idade do gerente de departamento: ");
                idade = input.nextInt();
                System.out.print("Digite o sexo do gerente de departamento: ");
                sexo = input.nextLine();
                System.out.print("Digite o Status do gerente de departamento: ");
                status = input.nextLine();
                System.out.println("Digite o salário bruto do gerente de departamento:");
                salarioBruto = input.nextDouble();
                System.out.println("Digite o valor do desconto do gerente de departamento:");
                desconto = input.nextDouble();

                Pessoa.contadorPessoas++; //incrementar o contador de contas
                GerenteDeDepartamento gerDep = new GerenteDeDepartamento(Pessoa.contadorPessoas,nome,idade,sexo,status,salarioBruto,desconto,200);
                banco.add(gerDep); //adiciona no ArrayList
                // e finalmente mostramos uma mensagem de sucesso.
                System.out.println("\ngerente de departamento criado com sucesso!");
                System.out.println(banco);
                break;
            case 4:
                System.out.print("\nDigite o nome do gerente geral: ");
                nome = input.nextLine();
                System.out.print("Digite a idade do gerente geral: ");
                idade = input.nextInt();
                System.out.print("Digite o sexo do gerente geral: ");
                sexo = input.nextLine();
                System.out.print("Digite o Status do gerente geral: ");
                status = input.nextLine();
                System.out.println("Digite o salário bruto do gerente geral:");
                salarioBruto = input.nextDouble();
                System.out.println("Digite o valor do desconto do gerente geral:");
                desconto = input.nextDouble();

                Pessoa.contadorPessoas++; //incrementar o contador de contas
                GerenteGeral gerGel = new GerenteGeral(Pessoa.contadorPessoas,nome,idade,sexo,status,salarioBruto,desconto,40,400);
                banco.add(gerGel); //adiciona no ArrayList
                // e finalmente mostramos uma mensagem de sucesso.
                System.out.println("\ngerente geral criado com sucesso!");
                System.out.println(banco);
                break;
            case 00:
                return 1;
        }
        return 1;
    }

    public Colaborador pesquisarFunc(String pesquisaConta) {
        Colaborador c = null;
        // verifica se a conta existe
        for (int i = 0; i < banco.size(); i++) {
            // pesquisa pelo id
            if (Integer.toString(banco.get(i).getId()).equals(pesquisaConta)) {
                return banco.get(i);
            }
            // pesquisar por nome
            else if (banco.get(i).getNome().contains(pesquisaConta)) {
                return banco.get(i);
            }
        }
        return c;
    }

    private Colaborador pesquisarNrFunc(int idFun) {
        Colaborador c = null;
        // verifica se a conta existe
        for (int i = 0; i < banco.size(); i++) {
            // pesquisa pelo nrConta
            if (banco.get(i).getId() == idFun) {
                return banco.get(i);
            }
        }
        return c;
    }
}
