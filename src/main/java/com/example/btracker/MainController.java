package com.example.btracker;

import static com.example.btracker.MoneyReturn.moneyReturn;

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

//  static final String errorReturnMoney = "Нельзя ничего вернуть";


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
      int newAmountIncome = Integer.parseInt(inputIncomeField.getText());

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
        int priceForFood = Integer.parseInt(inputFood.getText());
        if(priceForFood<0){
          throw new NumberFormatException();
        }
        budgetFood += priceForFood;
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
        int priceForFoodReturn = Integer.parseInt(inputFood.getText());

        budgetFood = moneyReturn(budgetFood, priceForFoodReturn);

        income += priceForFoodReturn;
        outputFix.setText(income + " €  ▲");
        outputFood.setText(budgetFood  + " €  ▼");
        outputError.setText("");

      } catch (NumberFormatException e) {
        outputError.setText(errorIfString);
      } catch (CustomException e) {
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
      int priceForShopping = Integer.parseInt(inputShopping.getText());
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
      int priceForTransport = Integer.parseInt(inputTransport.getText());
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
      int priceForEntertainment = Integer.parseInt(inputEntertainment.getText());
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
      int priceForOther = Integer.parseInt(inputOther.getText());
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
    btnJanuary.setStyle("");
    btnFebruary.setStyle("");
    btnMarch.setStyle("");
    btnApril.setStyle("");
    btnMay.setStyle("");
    btnJune.setStyle("");
    btnJuly.setStyle("");
    btnAugust.setStyle("");
    btnSeptember.setStyle("");
    btnOctober.setStyle("");
    btnNovember.setStyle("");
  }
  @FXML
  public void returnHouseMoneyAction(ActionEvent actionEvent) {
    try {
      int priceForHouseReturn = Integer.parseInt(inputHouse.getText());

      budgetHouse = moneyReturn(budgetHouse, priceForHouseReturn);

      income += priceForHouseReturn;
      outputFix.setText(income + " € ");
      outputHouse.setText(budgetHouse  + " € ");
      outputError.setText("");

    } catch (NumberFormatException e) {
      outputError.setText(errorIfString);
    } catch (CustomException e) {
      outputError.setText(e.getMessage());
    }
    inputHouse.clear();
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

  @FXML
  public Button btnJanuary;
  @FXML
  public Button btnJanuaryShow;
  @FXML
  public void btnJanuaryAction(ActionEvent actionEvent) {
    btnJanuaryShow.setText("Show");
    btnJanuaryShow.setVisible(true);
    btnJanuary.setStyle("-fx-background-color: #FF8034;");
    outputError.setText("");
  }

  @FXML
  public void btnJanuaryShowAction(ActionEvent actionEvent) {
    btnJanuaryShow.setVisible(false);
    outputOther.setText(budgetOther+"");
    outputIncome.setText(incomeFix+" € ");
  }
  @FXML
  public Button btnFebruary;
  @FXML
  public Button btnFebruaryShow;
  @FXML
  public void btnFebruaryAction(ActionEvent actionEvent) {
    btnFebruaryShow.setText("Show");
    btnFebruaryShow.setVisible(true);
    btnFebruary.setStyle("-fx-background-color: #FF8034;");
    outputError.setText("");
  }

  @FXML
  public void btnFebruaryShowAction(ActionEvent actionEvent) {
    btnFebruaryShow.setVisible(false);
    outputOther.setText(budgetOther+"");
    outputIncome.setText(incomeFix+" € ");
  }
  @FXML
  public Button btnMarch;
  @FXML
  public Button btnMarchShow;
  @FXML
  public void btnMarchAction(ActionEvent actionEvent) {
    btnMarchShow.setText("Show");
    btnMarchShow.setVisible(true);
    btnMarch.setStyle("-fx-background-color: #FF8034;");
    outputError.setText("");
  }

  @FXML
  public void btnMarchShowAction(ActionEvent actionEvent) {
    btnMarchShow.setVisible(false);
    outputOther.setText(budgetOther+"");
    outputIncome.setText(incomeFix+" € ");
  }
  @FXML
  public Button btnApril;
  @FXML
  public Button btnAprilShow;
  @FXML
  public void btnAprilAction(ActionEvent actionEvent) {
    btnAprilShow.setText("Show");
    btnAprilShow.setVisible(true);
    btnApril.setStyle("-fx-background-color: #FF8034;");
    outputError.setText("");
  }

  @FXML
  public void btnAprilShowAction(ActionEvent actionEvent) {
    btnAprilShow.setVisible(false);
    outputOther.setText(budgetOther+"");
    outputIncome.setText(incomeFix+" € ");
  }
  @FXML
  public Button btnMay;
  @FXML
  public Button btnMayShow;
  @FXML
  public void btnMayAction(ActionEvent actionEvent) {
    btnMayShow.setText("Show");
    btnMayShow.setVisible(true);
    btnMay.setStyle("-fx-background-color: #FF8034;");
    outputError.setText("");
  }

  @FXML
  public void btnMayShowAction(ActionEvent actionEvent) {
    btnMayShow.setVisible(false);
    outputOther.setText(budgetOther+"");
    outputIncome.setText(incomeFix+" € ");
  }
  @FXML
  public Button btnJune;
  @FXML
  public Button btnJuneShow;
  @FXML
  public void btnJuneAction(ActionEvent actionEvent) {
    btnJuneShow.setText("Show");
    btnJuneShow.setVisible(true);
    btnJune.setStyle("-fx-background-color: #FF8034;");
    outputError.setText("");
  }

  @FXML
  public void btnJuneShowAction(ActionEvent actionEvent) {
    btnJuneShow.setVisible(false);
    outputOther.setText(budgetOther+"");
    outputIncome.setText(incomeFix+" € ");
  }
  @FXML
  public Button btnJuly;
  @FXML
  public Button btnJulyShow;
  @FXML
  public void btnJulyAction(ActionEvent actionEvent) {
    btnJulyShow.setText("Show");
    btnJulyShow.setVisible(true);
    btnJuly.setStyle("-fx-background-color: #FF8034;");
    outputError.setText("");
  }

  @FXML
  public void btnJulyShowAction(ActionEvent actionEvent) {
    btnJulyShow.setVisible(false);
    outputOther.setText(budgetOther+"");
    outputIncome.setText(incomeFix+" € ");
  }
  @FXML
  public Button btnAugust;
  @FXML
  public Button btnAugustShow;
  @FXML
  public void btnAugustAction(ActionEvent actionEvent) {
    btnAugustShow.setText("Show");
    btnAugustShow.setVisible(true);
    btnAugust.setStyle("-fx-background-color: #FF8034;");
    outputError.setText("");
  }

  @FXML
  public void btnAugustShowAction(ActionEvent actionEvent) {
    btnAugustShow.setVisible(false);
    outputOther.setText(budgetOther+"");
    outputIncome.setText(incomeFix+" € ");
  }
  @FXML
  public Button btnSeptember;
  @FXML
  public Button btnSeptemberShow;
  @FXML
  public void btnSeptemberAction(ActionEvent actionEvent) {
    btnSeptemberShow.setText("Show");
    btnSeptemberShow.setVisible(true);
    btnSeptember.setStyle("-fx-background-color: #FF8034;");
    outputError.setText("");
  }

  @FXML
  public void btnSeptemberShowAction(ActionEvent actionEvent) {
    btnSeptemberShow.setVisible(false);
    outputOther.setText(budgetOther+"");
    outputIncome.setText(incomeFix+" € ");
  }
  @FXML
  public Button btnOctober;
  @FXML
  public Button btnOctoberShow;
  @FXML
  public void btnOctoberAction(ActionEvent actionEvent) {
    btnOctoberShow.setText("Show");
    btnOctoberShow.setVisible(true);
    btnOctober.setStyle("-fx-background-color: #FF8034;");
    outputError.setText("");
  }

  @FXML
  public void btnOctoberShowAction(ActionEvent actionEvent) {
    btnOctoberShow.setVisible(false);
    outputOther.setText(budgetOther+"");
    outputIncome.setText(incomeFix+" € ");
  }
  @FXML
  public Button btnNovember;
  @FXML
  public Button btnNovemberShow;
  @FXML
  public void btnNovemberAction(ActionEvent actionEvent) {
    btnNovemberShow.setText("Show");
    btnNovemberShow.setVisible(true);
    btnNovember.setStyle("-fx-background-color: #FF8034;");
    outputError.setText("");
  }

  @FXML
  public void btnNovemberShowAction(ActionEvent actionEvent) {
    btnNovemberShow.setVisible(false);
    outputOther.setText(budgetOther+"");
    outputIncome.setText(incomeFix+" € ");
  }
}


