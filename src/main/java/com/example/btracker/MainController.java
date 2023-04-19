package com.example.btracker;

import static com.example.btracker.AddMoney.addMoney;
import static com.example.btracker.ReturnMoney.returnMoney;
import static com.example.btracker.collectData.CollectData.collectData;

import static com.example.btracker.correctMonth.CorrectMonth.correctMonth;
import static com.example.btracker.sameOperation.OperationBtnsMonths.showButtonsMonth;
import static com.example.btracker.sameOperation.OutputEarnCalcSpend.calcEarnAndSpendForMonth;
import static com.example.btracker.sameOperation.OperationBtnsMonths.operationWithButtonsMonth;

import com.example.btracker.allClasses.GetMonthAndIncome;
import com.example.btracker.allClasses.NewAmountIncome;
import com.example.btracker.exception.CustomException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MainController {
    // Сохранение всех данных по месяцам в Map budgetByMonth
    public static Map<String, List<Integer>> budgetByMonth = new HashMap<>();
    private static final String errorIfMinus = " Отрицательный доход!";
    private static final String errorIfString = "Ошибка: Вы ввели не число";


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
        String month  = inputMonth.getText();
        GetMonthAndIncome dataMonthAndIncome = new GetMonthAndIncome(month, freezeFixAmount);

        List<Integer> valuesAllCategory = collectData(dataMonthAndIncome.getIncome(),
            budgetFood, budgetHouse,
            budgetShopping, budgetTransport,
            budgetEntertainment,budgetOther);

        incomeFix = dataMonthAndIncome.getIncome();
        budgetByMonth.put(dataMonthAndIncome.getMonth(),valuesAllCategory);

        moveData(month);

        clearAllNotesAction();

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
            correctMonth(inputMonth.getText().toLowerCase());


            //  преобразовать введенную строку в число
            int newAmountIncome = Integer.parseInt(inputIncomeField.getText());

            if (newAmountIncome < 0) {
                throw new CustomException(errorIfMinus);
            } else {
                freezeFixAmount += newAmountIncome;
                income += new NewAmountIncome(newAmountIncome).getIncome();
                outputFix.setText(income + " € ");
                outputError.setText("");
                outputIncome.setText(freezeFixAmount + " € ");
                fixAmount.setDisable(false);
                inputIncomeField.clear();
            }
        } catch (NumberFormatException e) {
            // вывод сообщения об ошибке, если введенная строка не является числом
            outputError.setText(errorIfString);
        } catch (CustomException e) {
            outputError.setText(e.getMessage());
        }

    }

    @FXML
    private void minusIncomeFieldAction() {
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
            budgetFood = addMoney(priceForFood, budgetFood);

//            if (priceForFood < 0) {
//                throw new NumberFormatException();
//            }
//            budgetFood += priceForFood;
            income = income - priceForFood;
            outputFix.setText(income + " € ");
            outputFood.setText(budgetFood + " € ");
            outputError.setText("");
            if (income < 0) {
                throw new CustomException(errorIfMinus);
            }
        } catch (NumberFormatException e) {
            // вывод сообщения об ошибке, если введенная строка не является числом
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
            budgetHouse = addMoney(priceForHouse, budgetHouse);
//            if (priceForHouse < 0) {
//                throw new NumberFormatException();
//            }
            // budgetHouse += priceForHouse;
            income = income - priceForHouse;
            outputFix.setText(income + " € ");
            outputHouse.setText(budgetHouse + " € ");
            outputError.setText("");

            if (income < 0) {
                throw new CustomException(errorIfMinus);
            }
        } catch (NumberFormatException e) {
            // вывод сообщения об ошибке, если введенная строка не является числом
            outputError.setText(errorIfString);
        } catch (CustomException e) {
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
            budgetShopping = addMoney(priceForShopping, budgetShopping);
            income = income - priceForShopping;
            outputFix.setText(income + " € ");
            outputShopping.setText(budgetShopping + " € ");
            outputError.setText("");
            if (income < 0) {
                throw new CustomException(errorIfMinus);
            }
        } catch (NumberFormatException e) {
            // вывод сообщения об ошибке, если введенная строка не является числом
            outputError.setText(errorIfString);
        } catch (CustomException e) {
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
            budgetTransport = addMoney(priceForTransport, budgetTransport);
            income = income - priceForTransport;
            outputFix.setText(income + " € ");
            outputTransport.setText(budgetTransport + " € ");
            outputError.setText("");
            if (income < 0) {
                throw new CustomException(errorIfMinus);
            }
        } catch (NumberFormatException e) {
            // вывод сообщения об ошибке, если введенная строка не является числом
            outputError.setText(errorIfString);
        } catch (CustomException e) {
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
            budgetEntertainment = addMoney(priceForEntertainment, budgetEntertainment);
            income = income - priceForEntertainment;
            outputFix.setText(income + " € ");
            outputEntertainment.setText(budgetEntertainment + " € ");
            outputError.setText("");
            if (income < 0) {
                throw new CustomException(errorIfMinus);
            }
        } catch (NumberFormatException e) {
            // вывод сообщения об ошибке, если введенная строка не является числом
            outputError.setText(errorIfString);
        } catch (CustomException e) {
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
            budgetOther = addMoney(priceForOther, budgetOther);
            income = income - priceForOther;
            outputFix.setText(income + " € ");
            outputOther.setText(budgetOther + " € ");
            outputError.setText("");
            if (income < 0) {
                throw new CustomException(errorIfMinus);
            }
        } catch (NumberFormatException e) {
            // вывод сообщения об ошибке, если введенная строка не является числом
            outputError.setText(errorIfString);
        } catch (CustomException e) {
            outputError.setText(e.getMessage());
        }
        inputOther.clear();
    }

    @FXML
    private void returnFoodMoneyAction() {
        try {
            int priceForFoodReturn = Integer.parseInt(inputFood.getText());
            budgetFood = returnMoney(budgetFood, priceForFoodReturn);
            income += priceForFoodReturn;
            outputFix.setText(income + " € ");
            outputFood.setText(budgetFood + " € ");
            outputError.setText("");
        } catch (NumberFormatException e) {
            outputError.setText(errorIfString);
        } catch (CustomException e) {
            outputError.setText(e.getMessage());
        }
        inputFood.clear();
    }

    @FXML
    public void returnHouseMoneyAction() {
        try {
            int priceForHouseReturn = Integer.parseInt(inputHouse.getText());
            budgetHouse = returnMoney(budgetHouse, priceForHouseReturn);
            income += priceForHouseReturn;
            outputFix.setText(income + " € ");
            outputHouse.setText(budgetHouse + " € ");
            outputError.setText("");

        } catch (NumberFormatException e) {
            outputError.setText(errorIfString);
        } catch (CustomException e) {
            outputError.setText(e.getMessage());
        }
        inputHouse.clear();
    }

    @FXML
    public void returnShoppingMoneyAction() {
        try {
            int priceForShoppingReturn = Integer.parseInt(inputShopping.getText());
            budgetShopping = returnMoney(budgetShopping, priceForShoppingReturn);
            income += priceForShoppingReturn;
            outputFix.setText(income + " € ");
            outputShopping.setText(budgetShopping + " € ");
            outputError.setText("");
        } catch (NumberFormatException e) {
            outputError.setText(errorIfString);
        } catch (CustomException e) {
            outputError.setText(e.getMessage());
        }
        inputShopping.clear();
    }

    @FXML
    public void returnTransportMoneyAction() {
        try {
            int priceForTransportReturn = Integer.parseInt(inputTransport.getText());
            budgetTransport = returnMoney(budgetTransport, priceForTransportReturn);
            income += priceForTransportReturn;
            outputFix.setText(income + " € ");
            outputTransport.setText(budgetTransport + " € ");
            outputError.setText("");
        } catch (NumberFormatException e) {
            outputError.setText(errorIfString);
        } catch (CustomException e) {
            outputError.setText(e.getMessage());
        }
        inputTransport.clear();
    }

    @FXML
    public void returnEntertainmentMoneyAction() {
        try {
            int priceForEntertainmentReturn = Integer.parseInt(inputEntertainment.getText());
            budgetEntertainment = returnMoney(budgetEntertainment, priceForEntertainmentReturn);
            income += priceForEntertainmentReturn;
            outputFix.setText(income + " € ");
            outputEntertainment.setText(budgetEntertainment + " € ");
            outputError.setText("");
        } catch (NumberFormatException e) {
            outputError.setText(errorIfString);
        } catch (CustomException e) {
            outputError.setText(e.getMessage());
        }
        inputEntertainment.clear();
    }

    @FXML
    public void returnOtherMoneyAction() {
        try {
            int priceForOtherReturn = Integer.parseInt(inputOther.getText());
            budgetOther = returnMoney(budgetOther, priceForOtherReturn);
            income += priceForOtherReturn;
            outputFix.setText(income + " € ");
            outputOther.setText(budgetOther + " € ");
            outputError.setText("");
        } catch (NumberFormatException e) {
            outputError.setText(errorIfString);
        } catch (CustomException e) {
            outputError.setText(e.getMessage());
        }
        inputOther.clear();
    }

    @FXML
    public Button btnDecember;
    @FXML
    public Button btnDecemberShow;

    @FXML
    public  void btnDecemberAction() {
        operationWithButtonsMonth(btnDecemberShow, btnDecember, outputError,inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth,btnDecember.getText(),earnDecember,spendDecember);
    }

    @FXML
    public void btnDecemberShowAction() {
        showButtonsMonth(btnDecemberShow,btnDecember);
        outputOther.setText(budgetOther + "");
        outputIncome.setText(incomeFix + " € ");

    }

    @FXML
    public Button btnJanuary;
    @FXML
    public Button btnJanuaryShow;

    @FXML
    public  void btnJanuaryAction() {
        operationWithButtonsMonth(btnJanuaryShow,btnJanuary,outputError,inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth,btnJanuary.getText(),earnJanuary,spendJanuary);
    }

    @FXML
    public void btnJanuaryShowAction() {
        showButtonsMonth(btnJanuaryShow,btnJanuary);
        outputOther.setText(budgetOther + "");
        outputIncome.setText(incomeFix + " € ");
    }

    @FXML
    public Button btnFebruary;
    @FXML
    public Button btnFebruaryShow;

    @FXML
    public void btnFebruaryAction() {
        operationWithButtonsMonth(btnFebruaryShow,btnFebruary,outputError,inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth,btnFebruary.getText(), earnFebruary,spendFebruary);
    }

    @FXML
    public void btnFebruaryShowAction() {
        showButtonsMonth(btnFebruaryShow,btnFebruary);
        outputOther.setText(budgetOther + "");
        outputIncome.setText(incomeFix + " € ");
    }

    @FXML
    public Button btnMarch;
    @FXML
    public Button btnMarchShow;

    @FXML
    public  void btnMarchAction() {
        operationWithButtonsMonth(btnMarchShow,btnMarch,outputError,inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth,btnMarch.getText(), earnMarch,spendMarch);
    }

    @FXML
    public void btnMarchShowAction() {

        showButtonsMonth(btnMarchShow,btnMarch);

        outputOther.setText(budgetOther + "");
        outputIncome.setText(incomeFix + " € ");
    }

    @FXML
    public Button btnApril;
    @FXML
    public Button btnAprilShow;

    @FXML
    public  void btnAprilAction() {
        operationWithButtonsMonth(btnAprilShow,btnApril,outputError,inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth,btnApril.getText(), earnApril,spendApril);
    }

    @FXML
    public void btnAprilShowAction() {
        showButtonsMonth(btnAprilShow,btnApril);
        outputOther.setText(budgetOther + "");
        outputIncome.setText(incomeFix + " € ");
    }

    @FXML
    public Button btnMay;
    @FXML
    public Button btnMayShow;

    @FXML
    public  void btnMayAction() {
        operationWithButtonsMonth(btnMayShow,btnMay,outputError,inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth,btnMay.getText(),earnMay,spendMay);
    }

    @FXML
    public void btnMayShowAction() {

        showButtonsMonth(btnMayShow,btnMay);

        outputOther.setText(budgetOther + "");
        outputIncome.setText(incomeFix + " € ");
    }

    @FXML
    public Button btnJune;
    @FXML
    public Button btnJuneShow;

    @FXML
    public  void btnJuneAction() {
        operationWithButtonsMonth(btnJuneShow,btnJune,outputError,inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth,btnJune.getText(), earnJune,spendJune);
    }

    @FXML
    public void btnJuneShowAction() {

        showButtonsMonth(btnJuneShow,btnJune);
        outputOther.setText(budgetOther + "");
        outputIncome.setText(incomeFix + " € ");
    }

    @FXML
    public Button btnJuly;
    @FXML
    public Button btnJulyShow;

    @FXML
    public void btnJulyAction() {
        operationWithButtonsMonth(btnJulyShow,btnJuly,outputError,inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth,btnJuly.getText() ,earnJuly,spendJuly);
    }

    @FXML
    public void btnJulyShowAction() {

        showButtonsMonth(btnJulyShow,btnJuly);
        outputOther.setText(budgetOther + "");
        outputIncome.setText(incomeFix + " € ");
    }

    @FXML
    public Button btnAugust;
    @FXML
    public Button btnAugustShow;

    @FXML
    public  void btnAugustAction() {
        operationWithButtonsMonth(btnAugustShow,btnAugust,outputError,inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth,btnAugust.getText(), earnAugust,spendAugust);
    }

    @FXML
    public void btnAugustShowAction() {
        showButtonsMonth(btnAugustShow,btnAugust);
        outputOther.setText(budgetOther + "");
        outputIncome.setText(incomeFix + " € ");
    }

    @FXML
    public Button btnSeptember;
    @FXML
    public Button btnSeptemberShow;

    @FXML
    public void btnSeptemberAction() {
        operationWithButtonsMonth(btnSeptemberShow,btnSeptember,outputError,inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnSeptember.getText(), earnSeptember,spendSeptember);
    }

    @FXML
    public void btnSeptemberShowAction() {
        showButtonsMonth(btnSeptemberShow,btnSeptember);
        outputOther.setText(budgetOther + "");
        outputIncome.setText(incomeFix + " € ");
    }

    @FXML
    public Button btnOctober;
    @FXML
    public Button btnOctoberShow;

    @FXML
    public void btnOctoberAction() {
        operationWithButtonsMonth(btnOctoberShow,btnOctober,outputError,inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth,btnOctober.getText(), earnOctober,spendOctober);
    }

    @FXML
    public void btnOctoberShowAction() {
        showButtonsMonth(btnOctoberShow,btnOctober);
        outputOther.setText(budgetOther + "");
        outputIncome.setText(incomeFix + " € ");
    }

    @FXML
    public Button btnNovember;
    @FXML
    public Button btnNovemberShow;

    @FXML
    public void btnNovemberAction() {
        operationWithButtonsMonth(btnNovemberShow,btnNovember,outputError,inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth,btnNovember.getText(), earnNovember,spendNovember);
    }

    @FXML
    public void btnNovemberShowAction() {
        showButtonsMonth(btnNovemberShow,btnNovember);
        outputOther.setText(budgetOther + "");
        outputIncome.setText(incomeFix + " € ");
    }


    @FXML
    public Text earnDecember;
    @FXML
    public Text spendDecember;
    @FXML
    public Text earnJanuary;
    @FXML
    public Text spendJanuary;
    @FXML
    public Text earnFebruary;
    @FXML
    public Text spendFebruary;
    @FXML
    public Text earnMarch;
    @FXML
    public Text spendMarch;
    @FXML
    public Text earnApril;
    @FXML
    public Text spendApril;
    @FXML
    public Text earnMay;
    @FXML
    public Text spendMay;
    @FXML
    public Text earnJune;
    @FXML
    public Text spendJune;
    @FXML
    public Text earnJuly;
    @FXML
    public Text spendJuly;
    @FXML
    public Text earnAugust;
    @FXML
    public Text spendAugust;
    @FXML
    public Text earnSeptember;
    @FXML
    public Text spendSeptember;
    @FXML
    public Text earnOctober;
    @FXML
    public Text spendOctober;
    @FXML
    public Text earnNovember;
    @FXML
    public Text spendNovember;

    @FXML
    private void clearAllNotesAction() {
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
//        btnDecember.setStyle("");
//        btnJanuary.setStyle("");
//        btnFebruary.setStyle("");
//        btnMarch.setStyle("");
//        btnApril.setStyle("");
//        btnMay.setStyle("");
//        btnJune.setStyle("");
//        btnJuly.setStyle("");
//        btnAugust.setStyle("");
//        btnSeptember.setStyle("");
//        btnOctober.setStyle("");
//        btnNovember.setStyle("");
        inputMonth.setText("");
    }

    private void moveData(String month) {
        switch (month) {
            case "january" -> btnJanuaryAction();
            case "february" -> btnFebruaryAction();
            case "march" -> btnMarchAction();
            case "april" -> btnAprilAction();
            case "may" -> btnMayAction();
            case "june" -> btnJuneAction();
            case "july" -> btnJulyAction();
            case "august" -> btnAugustAction();
            case "september" -> btnSeptemberAction();
            case "october" -> btnOctoberAction();
            case "november" -> btnNovemberAction();
            case "december" -> btnDecemberAction();
            default -> throw new CustomException("Месяц введен не корректно");
        }
    }

}

