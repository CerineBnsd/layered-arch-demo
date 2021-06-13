package Presentation;

import Business.Queries;
import Business.QueriesBO;
import Business.Transactions;
import Business.TransactionsBO;
import Business.DTO.CustomerTO;
import Business.DTO.FilmTO;
import Business.DTO.GameTO;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public class Controller extends Application {
    //Buttons
    @FXML
    public Button addCustomer;
    @FXML
    public Button addFilm;
    @FXML
    public Button addGame;
    @FXML
    public Button rentItem;
    @FXML
    public Button returnItem;
    @FXML
    public Button addPenalty;
    @FXML
    public Button searchByActor;
    @FXML
    public Button searchAvailableItem;
    @FXML
    public Button searchCustomerAllocations;
    @FXML
    public Button searchCustomerLateAllocations;
    @FXML
    public Button getAllCustomers;
    @FXML
    public Button getAllFilms;
    @FXML
    public Button getAllGames;
    @FXML
    public Button getAllRentedItems;
    @FXML
    public Button confirm;

    //Labels
    @FXML
    public Label queryTitle;
    @FXML
    public Label label1;
    @FXML
    public Label label2;
    @FXML
    public Label label3;
    @FXML
    public Label results;

    //Inputs
    @FXML
    public TextField input1;
    @FXML
    public TextField input2;
    @FXML
    public TextField input3;

    //layouts
    @FXML
    public ListView<String> resultsList;

    ObservableList<String> list= FXCollections.observableArrayList();

    public String activeAction;

    public Transactions transactionsBO;
    public Queries queriesBO;


    public static final CountDownLatch latch = new CountDownLatch(1);
    public static Controller c = null;

    public static Controller waitForLaunch() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return c;
    }
    public static void setC(Controller _c) {
        c = _c;
    }

    public void setTransactionsBO(Transactions transactionsBO) {
        this.transactionsBO = transactionsBO;
    }

    public void setQueriesBO(Queries queriesBO) {
        this.queriesBO = queriesBO;
    }

    public Controller(){
        setC(this);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        this.queriesBO = new QueriesBO("default",entityManager);
        this.transactionsBO = new TransactionsBO(entityManager,this.queriesBO);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));
        Scene scene = new Scene(root, 1000, 800);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("gui.css")).toExternalForm());
        primaryStage.show();
        latch.countDown();
        c.activeAction = "addCustomer";
        editForm("Ajouter un client","Nom du client","Solde du client",null);
        setActions();
    }
    public void setActions(){
        c.addCustomer.setOnAction(event -> {
            c.activeAction = c.addCustomer.getId();
            editForm("Ajouter un client","Nom du client","Solde du client",null);
            c.confirm.setOnAction(e -> c.addNewCustomer());
        });

        c.addFilm.setOnAction(event -> {
            c.activeAction = c.addFilm.getId();
            editForm("Ajouter un film","Nom du film","Prix","Acteur");
            c.confirm.setOnAction(e -> c.addNewFilm());
        });

        c.addGame.setOnAction(event -> {
            c.activeAction = c.addGame.getId();
            editForm("Ajouter un jeu","Nom du jeu","Prix","Plateform");
            c.confirm.setOnAction(e -> c.addNewGame());
        });

        c.rentItem.setOnAction(event -> {
            c.activeAction = c.rentItem.getId();
            editForm("Louer un article","ID de l'article","ID du client","Date de remise");
            c.confirm.setOnAction(e -> {});
        });

        c.returnItem.setOnAction(event -> {
            c.activeAction = c.returnItem.getId();
            editForm( "Remettre un article","ID de l'article",null,null);
            c.confirm.setOnAction(e -> {});
        });

        c.addPenalty.setOnAction(event -> {
            c.activeAction = c.addPenalty.getId();
            editForm( "Ajouter une pénalité","ID du client","La pénalité",null);
            c.confirm.setOnAction(e -> {});
        });

        c.searchByActor.setOnAction(event -> {
            c.activeAction = c.searchByActor.getId();
            editForm("Films d'un acteur","Acteur",null,null);
            c.confirm.setOnAction(e -> c.searchByActor());
        });

        c.searchAvailableItem.setOnAction(event -> {
            c.activeAction = c.searchAvailableItem.getId();
            editForm("Disponibilité d'un article","Nom de l'article",null,null);
            c.confirm.setOnAction(e -> {});
        });

        c.searchCustomerAllocations.setOnAction(event -> {
            c.activeAction = c.searchCustomerAllocations.getId();
            editForm( "Les articles alloué par un client","ID Client",null,null);
            c.confirm.setOnAction(e -> {});
        });

        c.searchCustomerLateAllocations.setOnAction(event -> {
            c.activeAction = c.searchCustomerLateAllocations.getId();
            editForm("Article en retard d'un client","ID Client",null,null);
            c.confirm.setOnAction(e -> {});
        });

        c.getAllCustomers.setOnAction(event -> {
            c.activeAction = c.getAllCustomers.getId();
            editForm("Affichage de tous les clients",null,null,null);
            c.confirm.setOnAction(e -> c.getAllCustomers());
        });

        c.getAllFilms.setOnAction(event -> {
            c.activeAction = c.getAllFilms.getId();
            editForm("Affichage de tous les films",null,null,null);
            c.confirm.setOnAction(e -> c.getAllFilms());
        });

        c.getAllGames.setOnAction(event -> {
            c.activeAction = c.getAllGames.getId();
            editForm("Affichage de tous les jeux",null,null,null);
            c.confirm.setOnAction(e -> c.getAllGames());
        });

        c.getAllRentedItems.setOnAction(event -> {
            c.activeAction = c.getAllRentedItems.getId();
            editForm("Affichage de tous les article loués",null,null,null);
            c.confirm.setOnAction(e -> {});
        });
    }

    public void addNewCustomer(){
        CustomerTO customer = new CustomerTO();
        customer.setFirstName(c.input1.getText());
        customer.setLastName(c.input1.getText());
        customer.setAccountBalance(Double.parseDouble(c.input2.getText()));
        transactionsBO.addNewCustomer(customer);
        displayResult("Client ajouté avec succes",new ArrayList<>());
    }

    public void addNewFilm(){
        FilmTO film = new FilmTO();
        film.setTitle(c.input1.getText());
        film.setRentalPrice(Double.parseDouble(c.input2.getText()));
        film.setActor(c.input3.getText());
        transactionsBO.addNewFilm(film);
        displayResult("Film ajouté avec succes", new ArrayList<>());
    }

    public void addNewGame(){
        GameTO game = new GameTO();
        game.setTitle(c.input1.getText());
        game.setRentalPrice(Double.parseDouble(c.input2.getText()));
        game.setPlatform(c.input3.getText());
        transactionsBO.addNewGame(game);
        displayResult("Jeu ajouté avec succes", new ArrayList<>());
    }
    public void getAllGames(){
        ArrayList<GameTO> games = (ArrayList<GameTO>) queriesBO.getAllGames();
        ArrayList<String> gamesDisplay = new ArrayList<>();
        for (int i=0;i<games.size();i++){
            gamesDisplay.add(i,games.get(i).toString());
        }
        displayResult("Les jeux récupérés avec success", gamesDisplay);
    }
    public void getAllCustomers(){
        ArrayList<CustomerTO> customers = (ArrayList<CustomerTO>) queriesBO.getAllCustomers();
        ArrayList<String> customersDisplay = new ArrayList<>();
        for (int i=0;i<customers.size();i++){
            customersDisplay.add(i,customers.get(i).toString());
        }
        displayResult("Les clients récupérés avec success", customersDisplay);
    }
    public void getAllFilms(){
        ArrayList<FilmTO> films = (ArrayList<FilmTO>) queriesBO.getAllFilms();
        ArrayList<String> filmsDisplay = new ArrayList<>();
        for (int i=0;i<films.size();i++){
            filmsDisplay.add(i,films.get(i).toString());
        }
        displayResult("Les films récupérés avec success", filmsDisplay);
    }

    public void searchByActor(){
        ArrayList<FilmTO> films = (ArrayList<FilmTO>) queriesBO.searchByActor(c.input1.getText());
        ArrayList<String> filmsDisplay = new ArrayList<>();
        for (int i=0;i<films.size();i++){
            filmsDisplay.add(i,films.get(i).toString());
        }
        displayResult("Les films de l'acteur récupérés avec success", filmsDisplay);
    }

    public void editForm(String queryTitle,String label1, String label2, String label3){
        c.results.setText("");
        c.resultsList.getItems().clear();
        c.queryTitle.setText(queryTitle);
        c.label1.setText(label1);
        c.label2.setText(label2);
        c.label3.setText(label3);
        c.input1.setText("");
        c.input2.setText("");
        c.input3.setText("");

        boolean visibility1 = label1 != null;
        boolean visibility2 = label2 != null;
        boolean visibility3 = label3 != null;

        c.label1.setVisible(visibility1);
        c.input1.setVisible(visibility1);
        c.label2.setVisible(visibility2);
        c.input2.setVisible(visibility2);
        c.label3.setVisible(visibility3);
        c.input3.setVisible(visibility3);
        c.resultsList.getItems().clear();
    }

    public void displayResult(String message, ArrayList<String> listItems){
        Platform.runLater(()->{
            Controller.c.results.setText(message);
            Controller.c.resultsList.getItems().clear();
            for (String item : listItems){
                Controller.c.resultsList.getItems().add(item);
            }
        });
    }

    public void start() {
        Application.launch();
    }
}
