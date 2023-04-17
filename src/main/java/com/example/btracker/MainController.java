package com.example.btracker;

import static com.example.btracker.allClasses.ParsingFieldsAmount.parsingFieldsAmount;

import com.example.btracker.allClasses.GetMonthAndIncome;
import com.example.btracker.allClasses.NewAmountIncome;
import com.example.btracker.exception.CustomException;
//import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
public class MainController {
  private static final String errorIfMinus = " Отрицательный доход !!!";
  private static final String errorIfString = "Ошибка: введено не число";
  private static final String errorReturnMoney = "Нельзя ничего вернуть";


  //  ERROR
@FXML
private Text outputError;

  @FXML
  public TextField inputMonth;
  @FXML
  public Button fixAmount;
  @FXML
  public Text outputIncome;
  @FXML
  public Text enterMonth;
  public int incomeFix;

  @FXML
  private void fixAmountAction() {
    String month = inputMonth.getText();
    if(month.isEmpty()){
      outputError.setText("Field a month is required");
      return;
    }
    GetMonthAndIncome dataMonthAndIncome = new GetMonthAndIncome(month,freezeFixAmount);

    System.out.println("сбор даных из поля в методе fixAmountAction :"
        + dataMonthAndIncome.getMonth()  + " =  " +dataMonthAndIncome.getIncome());
    incomeFix = dataMonthAndIncome.getIncome();
    outputError.setText("");
    freezeFixAmount = 0;
    outputIncome.setText("");
    outputFix.setText("");
    inputMonth.clear();
  }


  //  ПОЛЕ INCOME
  @FXML
  private TextField inputIncomeField;
  @FXML
  public Button buttonIncome;
  @FXML
  private Text outputFix;

  private int income = 0;
  private int freezeFixAmount = 0;
  @FXML
  private void btnIncomeAction() {
    try {
      //  преобразовать введенную строку в число
      int newAmountIncome = parsingFieldsAmount(inputIncomeField.getText());

      if(newAmountIncome<0){
        throw new CustomException(errorIfMinus);
      }else{
      freezeFixAmount += newAmountIncome ;
      income += new NewAmountIncome(newAmountIncome).getIncome() ;
      outputFix.setText(income + " €  ▲");
      outputError.setText("");
      outputIncome.setText(freezeFixAmount + " € ");
      fixAmount.setDisable(false);
      }
    } catch (NumberFormatException e) {
      // вывод сообщения об ошибке, если введенная строка не является числом
      outputError.setText(errorIfString);
    }catch (CustomException e){
      outputError.setText(e.getMessage());
    }

    inputIncomeField.clear();
  }
  @FXML
private void minusIncomeFieldAction(){
    income = 0;
    freezeFixAmount = 0;
    outputError.setText("");
    outputFix.setText("");
    outputIncome.setText("");
  }

  @FXML
    private TextField inputFood;

    @FXML
    private Text outputFood;
    private int budgetFood = 0;
    @FXML
    private void btnFoodAction() {
      try {
        // попытка преобразовать введенную строку в число
        int priceForFood = parsingFieldsAmount(inputFood.getText());
        if(priceForFood<0){
          throw new NumberFormatException();
        }
        budgetFood +=priceForFood;
        income = income - priceForFood;
        outputFix.setText(income + " €  ▼");
        outputFood.setText(budgetFood  + " €  ▲");
        outputError.setText("");
        if(income<0){
          throw new CustomException(errorIfMinus);
        }
      } catch (NumberFormatException e) {
        // вывод сообщения об ошибке, если введенная строка не является числом
        outputError.setText(errorIfString);
      }catch (CustomException e){
        outputError.setText(e.getMessage());
      }
      inputFood.clear();
    }

  @FXML
  private void returnFoodMoneyAction(){

      try {
        int priceForFoodReturn = parsingFieldsAmount(inputFood.getText());

        budgetFood = budgetFood-priceForFoodReturn;
        if(budgetFood<0){
          budgetFood=0;
          throw new CustomException(errorReturnMoney);
        }
        income += priceForFoodReturn;
        outputFix.setText(income + " €  ▲");
        outputFood.setText(budgetFood  + " €  ▼");
        outputError.setText("");

      }catch (NumberFormatException e){
        outputError.setText(errorIfString);
      }catch (CustomException e){
        outputError.setText(e.getMessage());
      }
    inputFood.clear();
  }

  @FXML
  private TextField inputHouse;
  @FXML
  private Text outputHouse;
  private int budgetHouse = 0;
  @FXML
  void btnHouseAction() {
    try {
      // преобразовать введенную строку в число
      int priceForHouse = parsingFieldsAmount(inputHouse.getText());
      if(priceForHouse<0){
        throw new NumberFormatException();
      }else{
        budgetHouse +=priceForHouse;
        income= income - priceForHouse;
        outputFix.setText(income + " €  ▼");
      outputHouse.setText(budgetHouse  + " €  ▲");
      outputError.setText("");
      }
      if(income<0){
        throw new CustomException(errorIfMinus);
      }
    } catch (NumberFormatException e) {
      // вывод сообщения об ошибке, если введенная строка не является числом
      outputError.setText(errorIfString);
    }catch (CustomException e){
      outputError.setText(e.getMessage());
    }
    inputHouse.clear();
  }
  @FXML
  private TextField inputShopping;
  @FXML
  private Text outputShopping;
  private int budgetShopping = 0;
  @FXML
  void btnShoppingAction() {
    try {
      // преобразовать введенную строку в число
      int priceForShopping = parsingFieldsAmount(inputShopping.getText());
      if(priceForShopping<0){
        throw new NumberFormatException();
      }else{
        budgetShopping +=priceForShopping;
        income= income - priceForShopping;
        outputFix.setText(income + " €  ▼");
      outputShopping.setText(budgetShopping  + " €  ▲");
      outputError.setText("");
      }
      if(income<0){
        throw new CustomException(errorIfMinus);
      }
    } catch (NumberFormatException e) {
      // вывод сообщения об ошибке, если введенная строка не является числом
      outputError.setText(errorIfString);
    }catch (CustomException e){
      outputError.setText(e.getMessage());
    }
    inputShopping.clear();
  }
  @FXML
  private TextField inputTransport;
  @FXML
  private Text outputTransport;
  private int budgetTransport = 0;
  @FXML
  void btnTransportAction() {
    try {
      // преобразовать введенную строку в число
      int priceForTransport = parsingFieldsAmount(inputTransport.getText());
      if(priceForTransport<0){
        throw new NumberFormatException();
      }else{
        budgetTransport += priceForTransport;
        income= income - priceForTransport;
        outputFix.setText(income + " €  ▼");
      outputTransport.setText(budgetTransport + " €  ▲");
      outputError.setText("");
      }
      if(income<0){
        throw new CustomException(errorIfMinus);
      }
    } catch (NumberFormatException e) {
      // вывод сообщения об ошибке, если введенная строка не является числом
      outputError.setText(errorIfString);
    }catch (CustomException e){
      outputError.setText(e.getMessage());
    }
    inputTransport.clear();
  }
  @FXML
  private TextField inputEntertainment;
  @FXML
  private Text outputEntertainment;
  private int budgetEntertainment = 0;
  @FXML
  void btnEntertainmentAction() {
    try {
      // преобразовать введенную строку в число
      int priceForEntertainment = parsingFieldsAmount(inputEntertainment.getText());
      if(priceForEntertainment<0){
        throw new NumberFormatException();
      }else{
        budgetEntertainment += priceForEntertainment;
        income = income - priceForEntertainment;
        outputFix.setText(income + " €  ▼");
      outputEntertainment.setText(budgetEntertainment + " €  ▲");
      outputError.setText("");
      }
      if(income<0){
        throw new CustomException(errorIfMinus);
      }
    } catch (NumberFormatException e) {
      // вывод сообщения об ошибке, если введенная строка не является числом
      outputError.setText(errorIfString);
    }catch (CustomException e){
      outputError.setText(e.getMessage());
    }
    inputEntertainment.clear();
  }
  @FXML
  private TextField inputOther;
  @FXML
  private Text outputOther;
  private int budgetOther = 0;
  @FXML
  void btnOtherAction() {
    try {
      // преобразовать введенную строку в число
      int priceForOther = parsingFieldsAmount(inputOther.getText());
      if(priceForOther<0){
        throw new NumberFormatException();
      }else{
        budgetOther += priceForOther;
        income= income - priceForOther;
        outputFix.setText(income + " €  ▼");
      outputOther.setText(budgetOther + " €  ▲");
      outputError.setText("");
      }
      if(income<0){
        throw new CustomException(errorIfMinus);
      }
    } catch (NumberFormatException e) {
      // вывод сообщения об ошибке, если введенная строка не является числом
      outputError.setText(errorIfString);
    }catch (CustomException e){
      outputError.setText(e.getMessage());
    }
    inputOther.clear();
  }
  @FXML
  private void clearAllNotesAction(){
    income = 0;
    freezeFixAmount = 0;
    budgetFood = 0;
    budgetHouse = 0;
    budgetShopping = 0;
    budgetTransport = 0;
    budgetEntertainment = 0;
    budgetOther = 0;
    outputError.setText("");
    outputFix.setText("");
    outputFood.setText("");
    outputHouse.setText("");
    outputShopping.setText("");
    outputTransport.setText("");
    outputEntertainment.setText("");
    outputOther.setText("");
    outputIncome.setText("");
    fixAmount.setDisable(true);
    btnDecember.setStyle("");
  }
  @FXML
  public void returnHouseMoneyAction(ActionEvent actionEvent) {
  }
  @FXML
  public void returnShoppingMoneyAction(ActionEvent actionEvent) {
  }
  @FXML
  public void returnTransportMoneyAction(ActionEvent actionEvent) {
  }
  @FXML
  public void returnEntertaimentMoneyAction(ActionEvent actionEvent) {
  }
  @FXML
  public void returnOtherMoneyAction(ActionEvent actionEvent) {
  }
  @FXML
  public Button btnDecember;
  @FXML
  public Button btnDecemberShow;
  @FXML
  public void btnDecemberAction(ActionEvent actionEvent) {
    btnDecemberShow.setText("Show");
    btnDecemberShow.setVisible(true);
    btnDecember.setStyle("-fx-background-color: #FF8034;");
    outputError.setText("");
//    btnDecember.setVisible(false);
//    btnDecember.setDisable(true);
  }
  @FXML
  public void btnDecemberShowAction(ActionEvent actionEvent) {
//    btnDecemberShow.setStyle("-fx-background-color: #4CAF50;");
    btnDecemberShow.setVisible(false);

//    btnDecember.setDisable(true);
    outputOther.setText(budgetOther+"");
    outputIncome.setText(incomeFix+" € ");
  }
}


