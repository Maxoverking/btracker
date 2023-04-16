package com.example.btracker;

import static com.example.btracker.allClasses.GetBudget.getBudget;

import com.example.btracker.myException.customException;
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
//  ПОЛЕ MY BUDGET
  @FXML
  private TextField inputField;
  @FXML
  private Text outputText;
  @FXML
  private Text outputError;
  private int budget = 0;
  @FXML
  private void handleButtonAction() {
    try {
      //  преобразовать введенную строку в число
      int myBudget = getBudget(inputField.getText());

      if(myBudget<0){
        throw new customException(errorIfMinus);
      }else{
      budget += myBudget;
      outputText.setText(budget + " € ");
      outputError.setText("");
      }
    } catch (NumberFormatException e) {
      // вывод сообщения об ошибке, если введенная строка не является числом
      outputError.setText(errorIfString);
    }catch (customException e){
      outputError.setText(e.getMessage());
    }

    inputField.clear();
  }
  @FXML
private void minusBudgetFieldAction(){
    budget = 0;
    outputText.setText("");
}

  //  ПОЛЕ FIX AMOUNT
  @FXML
  public TextField inputMount;
  @FXML
  public Button fixAmount;
  @FXML
  public Text outputFixAmount;
  @FXML
  private void fixAmountAction() {

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
        int priceForFood = Integer.parseInt(inputFood.getText());
        if(priceForFood<0){
          throw new NumberFormatException();
        }
        budgetFood +=priceForFood;
        budget = budget - priceForFood;
        outputText.setText(budget + " € "+ "  ▼");
        outputFood.setText(budgetFood  + " € "+ "  ▲");
        outputError.setText("");
        if(budget<0){
          throw new customException(errorIfMinus);
        }
        // вызываем метод из allClasses
      } catch (NumberFormatException e) {
        // вывод сообщения об ошибке, если введенная строка не является числом
        outputError.setText(errorIfString);
      }catch (customException e){
        outputError.setText(e.getMessage());
      }
      inputFood.clear();
    }

  @FXML
  private void returnFoodMoneyAction(){

      try {
        int priceForFoodReturn = Integer.parseInt(inputFood.getText());

        budgetFood = budgetFood-priceForFoodReturn;
        if(budgetFood<0){
          budgetFood=0;
          throw new customException(errorReturnMoney);
        }
        budget += priceForFoodReturn;
        outputText.setText(budget + " € "+ "  ▲");
        outputFood.setText(budgetFood  + " € "+ "  ▼");
        outputError.setText("");

      }catch (NumberFormatException e){
        outputError.setText(errorIfString);
      }catch (customException e){
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
      int priceForHouse = Integer.parseInt(inputHouse.getText());
      if(priceForHouse<0){
        throw new NumberFormatException();
      }else{
        budgetHouse +=priceForHouse;
      budget= budget - priceForHouse;
      outputText.setText(budget + " € "+ "  ▼");
      outputHouse.setText(budgetHouse  + " € "+ "  ▲");
      outputError.setText("");
      }
      if(budget<0){
        throw new customException(errorIfMinus);
      }
    } catch (NumberFormatException e) {
      // вывод сообщения об ошибке, если введенная строка не является числом
      outputError.setText(errorIfString);
    }catch (customException e){
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
      int priceForShopping = Integer.parseInt(inputShopping.getText());
      if(priceForShopping<0){
        throw new NumberFormatException();
      }else{
        budgetShopping +=priceForShopping;
      budget= budget - priceForShopping;
      outputText.setText(budget + " € "+ "  ▼");
      outputShopping.setText(budgetShopping  + " € "+ "  ▲");
      outputError.setText("");
      }
      if(budget<0){
        throw new customException(errorIfMinus);
      }
    } catch (NumberFormatException e) {
      // вывод сообщения об ошибке, если введенная строка не является числом
      outputError.setText(errorIfString);
    }catch (customException e){
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
      int priceForTransport = Integer.parseInt(inputTransport.getText());
      if(priceForTransport<0){
        throw new NumberFormatException();
      }else{
        budgetTransport += priceForTransport;
      budget= budget - priceForTransport;
      outputText.setText(budget + " € "+ "  ▼");
      outputTransport.setText(budgetTransport + " € "+ "  ▲");
      outputError.setText("");
      }
      if(budget<0){
        throw new customException(errorIfMinus);
      }
    } catch (NumberFormatException e) {
      // вывод сообщения об ошибке, если введенная строка не является числом
      outputError.setText(errorIfString);
    }catch (customException e){
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
      int priceForEntertainment = Integer.parseInt(inputEntertainment.getText());
      if(priceForEntertainment<0){
        throw new NumberFormatException();
      }else{
        budgetEntertainment += priceForEntertainment;
      budget= budget - priceForEntertainment;
      outputText.setText(budget + " € "+ "  ▼");
      outputEntertainment.setText(budgetEntertainment + " € "+ "  ▲");
      outputError.setText("");
      }
      if(budget<0){
        throw new customException(errorIfMinus);
      }
    } catch (NumberFormatException e) {
      // вывод сообщения об ошибке, если введенная строка не является числом
      outputError.setText(errorIfString);
    }catch (customException e){
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
      int priceForOther = Integer.parseInt(inputOther.getText());
      if(priceForOther<0){
        throw new NumberFormatException();
      }else{
        budgetOther += priceForOther;
      budget= budget - priceForOther;
      outputText.setText(budget + " € "+ "  ▼");
      outputOther.setText(budgetOther + " € "+ "  ▲");
      outputError.setText("");
      }
      if(budget<0){
        throw new customException(errorIfMinus);
      }
    } catch (NumberFormatException e) {
      // вывод сообщения об ошибке, если введенная строка не является числом
      outputError.setText(errorIfString);
    }catch (customException e){
      outputError.setText(e.getMessage());
    }
    inputOther.clear();
  }
  @FXML
  private void clearBudgetAllNotesAction(){
    budget = 0;
    budgetFood = 0;
    budgetHouse = 0;
    budgetShopping = 0;
    budgetTransport = 0;
    budgetEntertainment = 0;
    budgetOther = 0;
    outputText.setText("");
    outputFood.setText("");
    outputHouse.setText("");
    outputShopping.setText("");
    outputTransport.setText("");
    outputEntertainment.setText("");
    outputOther.setText("");

  }

  public void returnHouseMoneyAction(ActionEvent actionEvent) {
  }

  public void returnShoppingMoneyAction(ActionEvent actionEvent) {
  }

  public void returnTransportMoneyAction(ActionEvent actionEvent) {
  }

  public void returnEntertaimentMoneyAction(ActionEvent actionEvent) {
  }

  public void returnOtherMoneyAction(ActionEvent actionEvent) {
  }
}


