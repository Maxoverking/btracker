package com.example.btracker;

import static com.example.btracker.allClasses.GetBudget.getBudget;

import com.example.btracker.myException.customException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
public class MainController {
  @FXML
  private TextField inputField;
  @FXML
  private Text outputText;
  @FXML
  private Text outputError;
  private int budget = 0;
  @FXML
  private void handleButtonAction(ActionEvent event) {
    try {
      //  преобразовать введенную строку в число
      int myBudget = getBudget(inputField.getText());

      if(myBudget<0){
        throw new customException(" Отрицательный баланс!!!");
      }else{
      budget += myBudget;
      outputText.setText("Бюджет : " + budget + " € "+"  ▲");
      outputError.setText("");
      }
    } catch (NumberFormatException e) {
      // вывод сообщения об ошибке, если введенная строка не является числом
      outputError.setText("Ошибка: введено не число");
    }catch (customException e){
      outputError.setText(e.getMessage());
    }

    inputField.clear();
  }
    @FXML
    private TextField inputFood;

    @FXML
    private Text outputFood;
    private int budgetFood = 0;
    @FXML
    void btnFoodAction(ActionEvent event) {
      try {
        // попытка преобразовать введенную строку в число
        int priceForFood = Integer.parseInt(inputFood.getText());
        if(priceForFood<0){
          throw new NumberFormatException();
        }
        budgetFood +=priceForFood;
        budget= budget - priceForFood;
        outputText.setText("Бюджет : " + budget + " € "+ "  ▼");
        outputFood.setText("Бюджет : " + budgetFood  + " € "+ "  ▲");
        outputError.setText("");
        if(budget<0){
          throw new customException(" Отрицательный баланс!!!");
        }
        // вызываем метод из allClasses
      } catch (NumberFormatException e) {
        // вывод сообщения об ошибке, если введенная строка не является числом
        outputError.setText("Ошибка: введено не число");
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
  void btnHouseAction(ActionEvent event) {
    try {
      // преобразовать введенную строку в число
      int priceForHouse = Integer.parseInt(inputHouse.getText());
      if(priceForHouse<0){
        throw new NumberFormatException();
      }else{
        budgetHouse +=priceForHouse;
      budget= budget - priceForHouse;
      outputText.setText("Бюджет : " + budget + " € "+ "  ▼");
      outputHouse.setText("Бюджет : " + budgetHouse  + " € "+ "  ▲");
      outputError.setText("");
      }
      if(budget<0){
        throw new customException(" Отрицательный баланс!!!");
      }
    } catch (NumberFormatException e) {
      // вывод сообщения об ошибке, если введенная строка не является числом
      outputError.setText("Ошибка: введено не число");
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
  void btnShoppingAction(ActionEvent event) {
    try {
      // преобразовать введенную строку в число
      int priceForShopping = Integer.parseInt(inputShopping.getText());
      if(priceForShopping<0){
        throw new NumberFormatException();
      }else{
        budgetShopping +=priceForShopping;
      budget= budget - priceForShopping;
      outputText.setText("Бюджет : " + budget + " € "+ "  ▼");
      outputShopping.setText("Бюджет : " + budgetShopping  + " € "+ "  ▲");
      outputError.setText("");
      }
      if(budget<0){
        throw new customException(" Отрицательный баланс!!!");
      }
    } catch (NumberFormatException e) {
      // вывод сообщения об ошибке, если введенная строка не является числом
      outputError.setText("Ошибка: введено не число");
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
  void btnTransportAction(ActionEvent event) {
    try {
      // преобразовать введенную строку в число
      int priceForTransport = Integer.parseInt(inputTransport.getText());
      if(priceForTransport<0){
        throw new NumberFormatException();
      }else{
        budgetTransport += priceForTransport;
      budget= budget - priceForTransport;
      outputText.setText("Бюджет : " + budget + " € "+ "  ▼");
      outputTransport.setText("Бюджет : " + budgetTransport + " € "+ "  ▲");
      outputError.setText("");
      }
      if(budget<0){
        throw new customException(" Отрицательный баланс!!!");
      }
    } catch (NumberFormatException e) {
      // вывод сообщения об ошибке, если введенная строка не является числом
      outputError.setText("Ошибка: введено не число");
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
  void btnEntertainmentAction(ActionEvent event) {
    try {
      // преобразовать введенную строку в число
      int priceForEntertainment = Integer.parseInt(inputEntertainment.getText());
      if(priceForEntertainment<0){
        throw new NumberFormatException();
      }else{
        budgetEntertainment += priceForEntertainment;
      budget= budget - priceForEntertainment;
      outputText.setText("Бюджет : " + budget + " € "+ "  ▼");
      outputEntertainment.setText("Бюджет : " + budgetEntertainment + " € "+ "  ▲");
      outputError.setText("");
      }
      if(budget<0){
        throw new customException(" Отрицательный баланс!!!");
      }
    } catch (NumberFormatException e) {
      // вывод сообщения об ошибке, если введенная строка не является числом
      outputError.setText("Ошибка: введено не число");
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
  void btnOtherAction(ActionEvent event) {
    try {
      // преобразовать введенную строку в число
      int priceForOther = Integer.parseInt(inputOther.getText());
      if(priceForOther<0){
        throw new NumberFormatException();
      }else{
        budgetOther += priceForOther;
      budget= budget - priceForOther;
      outputText.setText("Бюджет : " + budget + " € "+ "  ▼");
      outputOther.setText("Бюджет : " + budgetOther + " € "+ "  ▲");
      outputError.setText("");
      }
      if(budget<0){
        throw new customException(" Отрицательный баланс!!!");
      }
    } catch (NumberFormatException e) {
      // вывод сообщения об ошибке, если введенная строка не является числом
      outputError.setText("Ошибка: введено не число");
    }catch (customException e){
      outputError.setText(e.getMessage());
    }
    inputOther.clear();
  }

  }


