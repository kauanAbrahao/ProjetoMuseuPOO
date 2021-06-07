package sample;

import controller.AdminController;
import controller.IngressoController;
import controller.VisitanteController;
import entities.Administrador;
import entities.Cidadao;
import entities.Visita;
import entities.Visitante;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.List;

public class Main extends Application {

    VisitanteController visitanteController = new VisitanteController();
    IngressoController ingressoController = new IngressoController();
    AdminController adminController = new AdminController();

    //Primeira tela
    TextField textCpf = new TextField();
    TextField textLoginADM = new TextField();
    TextField textSenha = new TextField();
    TextField textSenhaADM = new TextField();
    Label sistema = new Label("Sistema Zoomuseum");
    Label Visita = new Label("Acesso Visitante");
    Label ADM = new Label("Acesso Administrador");
    Label CPF = new Label("CPF");
    Label LoginADM = new Label("Login");
    Label SenhaADM = new Label("Senha");
    Label Senha = new Label("Senha");
    Button btnCadastrar = new Button("Cadastrar");
    Button btnAcessar = new Button("Acessar");
    Button btnAcessarADM = new Button("Acessar");

    Visitante visitanteDoSistema = new Cidadao();

    //Segunda Tela
        TextField textCpfCadastro = new TextField();
        TextField textEmailCadastro = new TextField();
        TextField textNomeCadastro = new TextField();
        TextField textRgCadastro = new TextField();
        TextField textTelefoneCadastro = new TextField();
        TextField textLoginCadastro = new TextField();
        TextField textSenhaCadastro = new TextField();
        Label CPFCadastro = new Label("CPF");
        Label SenhaCadastro = new Label("Senha");
        Label RG = new Label("RG");
        Label Nome = new Label("Nome");
        Label Login = new Label("Login");
        Label EMail = new Label("E-Mail");
        Label Telefone = new Label("Telefone");
        Button btnCadastrar2 = new Button("Cadastrar");

        Button btnVoltar = new Button("Voltar");

    //Terceira tela
    Label NomeInicio = new Label(textNomeCadastro.getText());
    Button btnConsulta = new Button("Consultar");
    Button btnIngresso = new Button("Comprar Ingresso");

    //Quarta tela
    Label Comprar = new Label("Compra de Ingresso");
    Label ComprarIngresso = new Label("Quantidade de Ingressos");
    TextField textQuantidade = new TextField();
    Label ValorUni = new Label("Preço unitário: 30 R$");
    Label Data = new Label("Data");
    TextField textDataIngresso = new TextField();
    Button btnComprar = new Button("Comprar");
    Button btnVolta = new Button("Voltar");

    //Tela Principal Admin
    Label admPrincipal = new Label("Você está logado como ADM");
    Button btnMudarVisita = new Button("Alterar Visita");
    Label cpfDoCliente = new Label("CPF: ");
    Label dataAtualDaVisita = new Label("Data atual da visita: ");
    Label dataNova = new Label("Nova data: ");
    TextField txtCpfDoCliente = new TextField();
    TextField txtDataAntiga = new TextField();
    TextField txtDataNova = new TextField();

    Button btnRelatorio = new Button("Emitir Relatorio");
    Label relatorio = new Label("Relatório de Visitas: ");
    ListView visitas = new ListView();


    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 600, 400);

        gridPane.add(sistema, 7, 3);
        gridPane.add(Visita, 1, 5);
        gridPane.add(ADM, 9, 5);
        gridPane.add(CPF, 1, 6);
        gridPane.add(LoginADM, 9, 6);
        gridPane.add(textLoginADM, 9, 7);
        gridPane.add(textSenhaADM, 9, 9);
        gridPane.add(Senha, 1, 8);
        gridPane.add(SenhaADM, 9, 8);
        gridPane.add(textCpf, 1, 7);
        gridPane.add(btnAcessar, 1, 10);
        gridPane.add(textSenha, 1, 9);
        gridPane.add(btnCadastrar, 3, 10);
        gridPane.add(btnAcessarADM, 9, 10);

        //Isso é a primeira tela
        btnAcessar.setOnAction((e)-> {
            try {
                this.entityToBoundaryLoginNoSistema
                        (visitanteController.loginVisitante(textCpf.getText(), textSenha.getText()));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        btnCadastrar.setOnAction((e) -> {
            try {
                this.startCadastro(new Stage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        //Acesso do ADM
        btnAcessarADM.setOnAction((e) -> loginNoSistemaADM());

        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public void startCadastro(Stage primaryStage) throws Exception{

        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 400, 400);

        gridPane.add(CPFCadastro, 1, 1);
        gridPane.add(textCpfCadastro, 1, 2);
        gridPane.add(EMail, 5, 1);
        gridPane.add(textEmailCadastro, 5, 2);
        gridPane.add(Nome, 1, 3);
        gridPane.add(textNomeCadastro, 1, 4);
        gridPane.add(RG, 5, 3);
        gridPane.add(textRgCadastro, 5, 4);
        gridPane.add(Login, 1, 5);
        gridPane.add(textLoginCadastro, 1, 6);
        gridPane.add(Senha, 5, 5);
        gridPane.add(textSenhaCadastro, 5, 6);
        gridPane.add(btnCadastrar2, 5, 18);
        gridPane.add(btnVoltar, 1, 18);

        btnCadastrar2.setOnAction((e)->visitanteController.cadastrarVisitante(boundaryToEntityRegistroNoSistema()));
        btnVoltar.setOnAction((e)-> primaryStage.close());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

//    ----------------------------------------------------------------------------------------------------
    public void startInicio(Stage primaryStage) throws Exception{

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Bem vindo, " + visitanteDoSistema.getNome() + " !");
        alert.show();

        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 400, 400);

        gridPane.add(sistema, 5, 1);
        gridPane.add(NomeInicio, 1, 1);
        gridPane.add(btnConsulta, 1, 5);
        gridPane.add(btnIngresso, 9, 5);


        //btnConsulta.setOnAction((e)->visitanteController.cadastrarVisitante(boundaryToEntityRegistroNoSistema()));

        btnIngresso.setOnAction((e)-> {
            try {
                this.startIngresso(new Stage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

//    ------------------------------------------------------------------------------------------------

    public void startIngresso(Stage primaryStage) throws Exception{

        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 400, 400);

        gridPane.add(Comprar, 5, 1);
        gridPane.add(ComprarIngresso, 1, 3);
        gridPane.add(textQuantidade, 1, 5);
        gridPane.add(ValorUni, 6, 5);
        gridPane.add(Data, 1, 8);
        gridPane.add(textDataIngresso, 1, 10);
        gridPane.add(btnComprar, 1, 12);
        gridPane.add(btnVolta, 5, 12);

        btnComprar.setOnAction((e)-> this.boundaryToEntityCompraIngresso(visitanteDoSistema));
        btnVolta.setOnAction((e)-> primaryStage.close());

        primaryStage.setScene(scene);
        primaryStage.show();
    }


//    ----------------------------------------------------------------------------------------------------------

    private void startAdmin(Stage stage) {
        GridPane gridPane = new GridPane();
        Scene scene = new Scene (gridPane, 400, 400);

        admPrincipal.setPadding(new Insets(2, 2, 2, 2));
        txtCpfDoCliente.setPadding(new Insets(5));

        gridPane.add(admPrincipal, 1, 1);
        gridPane.add(cpfDoCliente, 1, 3);
        gridPane.add(txtCpfDoCliente, 1, 5);
        gridPane.add(dataAtualDaVisita, 1, 7);
        gridPane.add(txtDataAntiga, 1, 9);
        gridPane.add(dataNova, 1, 11);
        gridPane.add(txtDataNova, 1, 13);

        gridPane.add(btnMudarVisita, 1, 15);

        gridPane.add(btnRelatorio, 2, 10);
        gridPane.add(relatorio, 2, 12);
        gridPane.add(visitas, 2, 18);

        gridPane.setPadding(new Insets(5));

        btnRelatorio.setOnAction((e) -> buscarRelatorio());

        stage.setScene(scene);
        stage.show();



    }

    //PRODUZIR RELATORIO
    private void buscarRelatorio() {
        List<Visita> listavisitas = adminController.buscarRelatorio();
        ObservableList<String> itens = FXCollections.observableArrayList();
        for (Visita visita: listavisitas){
            itens.add("data: " + visita.getDataref().toString() + " | quantidade: " + visita.getQuantidade());
        }
        visitas.setItems(itens);
    }

//    -----------------------------------------------------------------------------------------------------------

    private void boundaryToEntityCompraIngresso(Visitante visitante) {
        int qtd = Integer.parseInt(textQuantidade.getText());
        boolean resultado = ingressoController.comprarIngresso(visitante, textDataIngresso.getText(), qtd);

        if(resultado){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Parabéns! Sua visita foi marcada com sucesso");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Por favor, reveja os dados para prosseguir.");
            alert.show();
        }

    }


    private void entityToBoundaryLoginNoSistema(Visitante visitante) throws Exception {
        if (visitante != null){
//            mostra na telinha que o login foi sucesso e vai para a próxima tela
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setContentText("Bem vindo, " + visitante.getNome() + " !");
//            alert.show();
            this.visitanteDoSistema = visitante;
            this.startInicio(new Stage());
            //CHAMAR A TELA QUE SERÁ A DE COMPRA DE INGRESSO ETC
//            this.startIngresso(new Stage());

        } else {
            //msotra na telinha que deu ruim e fica na mesma tela.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Usuário ou senha inválidos");
            alert.show();
        }
    }

    private Cidadao boundaryToEntityRegistroNoSistema() {
        try{
            Cidadao visitante = new Cidadao();
            visitante.setCpf(textCpfCadastro.getText());
            visitante.setEmail(textEmailCadastro.getText());
            visitante.setDatanasc(LocalDate.now());
            visitante.setNome(textNomeCadastro.getText());
            visitante.setRg(textRgCadastro.getText());
            visitante.setTelefone(textTelefoneCadastro.getText());
            //Login e senha
            visitante.setLogin(textLoginCadastro.getText());
            visitante.setSenha(textSenhaCadastro.getText());
            return visitante;
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erro! Por favor, verifique as informações inseridas");
            alert.show();
            return null;
        }
    }

    private void loginNoSistemaADM() {
        Administrador admin = adminController.loginNoSistema(textLoginADM.getText(), textSenhaADM.getText());
        if(admin == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Login ou senha incorretos");
            alert.show();
        } else {
            this.startAdmin(new Stage());
        }
    }



    public static void main(String[] args) {
        launch(args);
    }

}
