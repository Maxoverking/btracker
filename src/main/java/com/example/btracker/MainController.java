package com.example.btracker;

import static com.example.btracker.AddMoney.addMoney;
import static com.example.btracker.ReturnMoney.returnMoney;
import static com.example.btracker.allClasses.Income.calculateIncome;
import static com.example.btracker.allClasses.Income.calculateIncomeReturn;
import static com.example.btracker.collectData.CollectData.collectData;
import static com.example.btracker.correctMonth.CorrectMonth.correctMonth;
import static com.example.btracker.sameOperation.OperationBtnAction.showButtonsAction;
import static com.example.btracker.sameOperation.OperationBtnAction.showButtonsMonthAction;
import static com.example.btracker.sameOperation.OperationBtnsMonths.showButtonsMonth;
import static com.example.btracker.sameOperation.OutputEarnCalcSpend.calcEarnAndSpendForMonth;
import static com.example.btracker.sameOperation.OperationBtnsMonths.operationWithButtonsMonth;
import static com.example.btracker.sortingData.AddToField.addToField;
import static com.example.btracker.sortingData.SortingData.convertMap;

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
    private String currentMonth = "";
    public static Map<String, List<String>> budgetByMonth = new HashMap<>();
    public static final String errorIfMinus = " Отрицательный доход!";
    private static final String errorIfString = "Ошибка: Вы ввели не число";

    // Error
    @FXML
    private Text outputError;
    @FXML
    public Text titleIncome;

    // Month
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
        String month = inputMonth.getText().toLowerCase();
        GetMonthAndIncome dataMonthAndIncome = new GetMonthAndIncome(month, freezeFixAmount);

        List<String> valuesAllCategory = collectData(
                dataMonthAndIncome.getIncome(), budgetFood, budgetHouse,
                budgetShopping, budgetTransport, budgetEntertainment, budgetOther);

        incomeFix = dataMonthAndIncome.getIncome();
        budgetByMonth.put(dataMonthAndIncome.getMonth(), valuesAllCategory);

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
            budgetFood = addMoney(priceForFood, budgetFood, income);
            income = calculateIncome(income, priceForFood);
            showButtonsAction(outputFix, outputFood, outputError, income, budgetFood);
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
            budgetHouse = addMoney(priceForHouse, budgetHouse, income);
            income = calculateIncome(income, priceForHouse);
            showButtonsAction(outputFix, outputHouse, outputError, income, budgetHouse);
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
            budgetShopping = addMoney(priceForShopping, budgetShopping, income);
            income = calculateIncome(income, priceForShopping);
            showButtonsAction(outputFix, outputShopping, outputError, income, budgetShopping);
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
            budgetTransport = addMoney(priceForTransport, budgetTransport, income);
            income = calculateIncome(income, priceForTransport);
            showButtonsAction(outputFix, outputTransport, outputError, income, budgetTransport);
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
            budgetEntertainment = addMoney(priceForEntertainment, budgetEntertainment, income);
            income = calculateIncome(income, priceForEntertainment);
            showButtonsAction(outputFix, outputEntertainment, outputError, income, budgetEntertainment);
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
            budgetOther = addMoney(priceForOther, budgetOther, income);
            income = calculateIncome(income, priceForOther);
            showButtonsAction(outputFix, outputOther, outputError, income, budgetOther);
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
            income = calculateIncomeReturn(income, priceForFoodReturn);
            showButtonsAction(outputFix, outputFood, outputError, income, budgetFood);
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
            income = calculateIncomeReturn(income, priceForHouseReturn);
            showButtonsAction(outputFix, outputHouse, outputError, income, budgetHouse);
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
            income = calculateIncomeReturn(income, priceForShoppingReturn);
            showButtonsAction(outputFix, outputShopping, outputError, income, budgetShopping);
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
            income = calculateIncomeReturn(income, priceForTransportReturn);
            showButtonsAction(outputFix, outputTransport, outputError, income, budgetTransport);
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
            income = calculateIncomeReturn(income, priceForEntertainmentReturn);
            showButtonsAction(outputFix, outputEntertainment, outputError, income, budgetEntertainment);
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
            income = calculateIncomeReturn(income, priceForOtherReturn);
            showButtonsAction(outputFix, outputOther, outputError, income, budgetOther);
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
    public void btnDecemberAction() {
        operationWithButtonsMonth(btnDecemberShow, btnDecember, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnDecember.getText(), earnDecember, spendDecember);
//        operationBtnShow(true,buttonsList);
    }

    @FXML
    public void btnDecemberShowAction() {
        currentMonth = btnDecember.getText();
        showButtonsMonth(btnDecember, sortText, btnSortUp, btnSortDown);
        showButtonsMonthAction(titleIncome, titleFood, titleHouse, titleShopping,
                titleTransport, titleEntertainment, titleOther, outputIncome,
                outputFood, outputHouse, outputShopping,
                outputTransport, outputEntertainment, outputOther, btnDecember.getText(), budgetByMonth);
    }

    @FXML
    public Button btnJanuary;
    @FXML
    public Button btnJanuaryShow;

    @FXML
    public void btnJanuaryAction() {
        operationWithButtonsMonth(btnJanuaryShow, btnJanuary, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnJanuary.getText(), earnJanuary, spendJanuary);
//        operationBtnShow(true,buttonsList);
    }

    @FXML
    public void btnJanuaryShowAction() {
        currentMonth = btnJanuary.getText();
        showButtonsMonth(btnJanuary, sortText, btnSortUp, btnSortDown);
        showButtonsMonthAction(titleIncome, titleFood, titleHouse, titleShopping,
                titleTransport, titleEntertainment, titleOther, outputIncome,
                outputFood, outputHouse, outputShopping,
                outputTransport, outputEntertainment, outputOther, btnJanuary.getText(), budgetByMonth);
    }

    @FXML
    public Button btnFebruary;
    @FXML
    public Button btnFebruaryShow;

    @FXML
    public void btnFebruaryAction() {
        operationWithButtonsMonth(btnFebruaryShow, btnFebruary, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnFebruary.getText(), earnFebruary, spendFebruary);
    }

    @FXML
    public void btnFebruaryShowAction() {
        currentMonth = btnFebruary.getText();
        showButtonsMonth(btnFebruary, sortText, btnSortUp, btnSortDown);
        showButtonsMonthAction(titleIncome, titleFood, titleHouse, titleShopping,
                titleTransport, titleEntertainment, titleOther, outputIncome,
                outputFood, outputHouse, outputShopping,
                outputTransport, outputEntertainment, outputOther, btnFebruary.getText(), budgetByMonth);
    }

    @FXML
    public Button btnMarch;
    @FXML
    public Button btnMarchShow;

    @FXML
    public void btnMarchAction() {
        operationWithButtonsMonth(btnMarchShow, btnMarch, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnMarch.getText(), earnMarch, spendMarch);
    }

    @FXML
    public void btnMarchShowAction() {
        currentMonth = btnMarch.getText();
        showButtonsMonth(btnMarch, sortText, btnSortUp, btnSortDown);
        showButtonsMonthAction(titleIncome, titleFood, titleHouse, titleShopping,
                titleTransport, titleEntertainment, titleOther, outputIncome,
                outputFood, outputHouse, outputShopping,
                outputTransport, outputEntertainment, outputOther, btnMarch.getText(), budgetByMonth);
    }

    @FXML
    public Button btnApril;
    @FXML
    public Button btnAprilShow;

    @FXML
    public void btnAprilAction() {
        operationWithButtonsMonth(btnAprilShow, btnApril, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnApril.getText(), earnApril, spendApril);
    }

    @FXML
    public void btnAprilShowAction() {
        currentMonth = btnApril.getText();
        showButtonsMonth(btnApril, sortText, btnSortUp, btnSortDown);
        showButtonsMonthAction(titleIncome, titleFood, titleHouse, titleShopping,
                titleTransport, titleEntertainment, titleOther, outputIncome,
                outputFood, outputHouse, outputShopping,
                outputTransport, outputEntertainment, outputOther, btnApril.getText(), budgetByMonth);
    }

    @FXML
    public Button btnMay;
    @FXML
    public Button btnMayShow;

    @FXML
    public void btnMayAction() {
        operationWithButtonsMonth(btnMayShow, btnMay, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnMay.getText(), earnMay, spendMay);
    }

    @FXML
    public void btnMayShowAction() {
        currentMonth = btnMay.getText();
        showButtonsMonth(btnMay, sortText, btnSortUp, btnSortDown);
        showButtonsMonthAction(titleIncome, titleFood, titleHouse, titleShopping,
                titleTransport, titleEntertainment, titleOther, outputIncome,
                outputFood, outputHouse, outputShopping,
                outputTransport, outputEntertainment, outputOther, btnMay.getText(), budgetByMonth);
    }

    @FXML
    public Button btnJune;
    @FXML
    public Button btnJuneShow;

    @FXML
    public void btnJuneAction() {
        operationWithButtonsMonth(btnJuneShow, btnJune, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnJune.getText(), earnJune, spendJune);
    }

    @FXML
    public void btnJuneShowAction() {
        currentMonth = btnJune.getText();
        showButtonsMonth(btnJune, sortText, btnSortUp, btnSortDown);
        showButtonsMonthAction(titleIncome, titleFood, titleHouse, titleShopping,
                titleTransport, titleEntertainment, titleOther, outputIncome,
                outputFood, outputHouse, outputShopping,
                outputTransport, outputEntertainment, outputOther, btnJune.getText(), budgetByMonth);
    }

    @FXML
    public Button btnJuly;
    @FXML
    public Button btnJulyShow;

    @FXML
    public void btnJulyAction() {
        operationWithButtonsMonth(btnJulyShow, btnJuly, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnJuly.getText(), earnJuly, spendJuly);
    }

    @FXML
    public void btnJulyShowAction() {
        currentMonth = btnJuly.getText();
        showButtonsMonth(btnJuly, sortText, btnSortUp, btnSortDown);
        showButtonsMonthAction(titleIncome, titleFood, titleHouse, titleShopping,
                titleTransport, titleEntertainment, titleOther, outputIncome,
                outputFood, outputHouse, outputShopping,
                outputTransport, outputEntertainment, outputOther, btnJuly.getText(), budgetByMonth);
    }

    @FXML
    public Button btnAugust;
    @FXML
    public Button btnAugustShow;

    @FXML
    public void btnAugustAction() {
        operationWithButtonsMonth(btnAugustShow, btnAugust, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnAugust.getText(), earnAugust, spendAugust);
    }

    @FXML
    public void btnAugustShowAction() {
        currentMonth = btnAugust.getText();
        showButtonsMonth(btnAugust, sortText, btnSortUp, btnSortDown);
        showButtonsMonthAction(titleIncome, titleFood, titleHouse, titleShopping,
                titleTransport, titleEntertainment, titleOther, outputIncome,
                outputFood, outputHouse, outputShopping,
                outputTransport, outputEntertainment, outputOther, btnAugust.getText(), budgetByMonth);
    }

    @FXML
    public Button btnSeptember;
    @FXML
    public Button btnSeptemberShow;

    @FXML
    public void btnSeptemberAction() {
        operationWithButtonsMonth(btnSeptemberShow, btnSeptember, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnSeptember.getText(), earnSeptember, spendSeptember);
    }

    @FXML
    public void btnSeptemberShowAction() {
        currentMonth = btnSeptember.getText();
        showButtonsMonth(btnSeptember, sortText, btnSortUp, btnSortDown);
        showButtonsMonthAction(titleIncome, titleFood, titleHouse, titleShopping,
                titleTransport, titleEntertainment, titleOther, outputIncome,
                outputFood, outputHouse, outputShopping,
                outputTransport, outputEntertainment, outputOther, btnSeptember.getText(), budgetByMonth);
    }

    @FXML
    public Button btnOctober;
    @FXML
    public Button btnOctoberShow;

    @FXML
    public void btnOctoberAction() {
        operationWithButtonsMonth(btnOctoberShow, btnOctober, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnOctober.getText(), earnOctober, spendOctober);
    }

    @FXML
    public void btnOctoberShowAction() {
        currentMonth = btnOctober.getText();
        showButtonsMonth(btnOctober, sortText, btnSortUp, btnSortDown);
        showButtonsMonthAction(titleIncome, titleFood, titleHouse, titleShopping,
                titleTransport, titleEntertainment, titleOther, outputIncome,
                outputFood, outputHouse, outputShopping,
                outputTransport, outputEntertainment, outputOther, btnOctober.getText(), budgetByMonth);
    }

    @FXML
    public Button btnNovember;
    @FXML
    public Button btnNovemberShow;

    @FXML
    public void btnNovemberAction() {
        operationWithButtonsMonth(btnNovemberShow, btnNovember, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnNovember.getText(), earnNovember, spendNovember);
    }

    @FXML
    public void btnNovemberShowAction() {
        currentMonth = btnNovember.getText();
        showButtonsMonth(btnNovember, sortText, btnSortUp, btnSortDown);
        showButtonsMonthAction(titleIncome, titleFood, titleHouse, titleShopping,
                titleTransport, titleEntertainment, titleOther, outputIncome,
                outputFood, outputHouse, outputShopping,
                outputTransport, outputEntertainment, outputOther, btnNovember.getText(), budgetByMonth);
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
        sortText.setVisible(false);
        btnSortUp.setVisible(false);
        btnSortDown.setVisible(false);
        titleFood.setText("FOOD");
        titleHouse.setText("HOUSE");
        titleShopping.setText("SHOPPING");
        titleTransport.setText("TRANSPORT");
        titleEntertainment.setText("ENTERTAINMENT");
        titleOther.setText("OTHER");
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
            default -> throw new CustomException("Месяц введен некорректно");
        }
    }

    @FXML
    public Text sortText;
    @FXML
    public Button btnSortUp;
    @FXML
    public Button btnSortDown;
    @FXML
    public Text titleFood;
    @FXML
    public Text titleHouse;
    @FXML
    public Text titleShopping;
    @FXML
    public Text titleTransport;
    @FXML
    public Text titleEntertainment;
    @FXML
    public Text titleOther;

    @FXML
    public void btnSortUpAction() {
        List<String> sortedUpList = convertMap(budgetByMonth, currentMonth, true);

        System.out.println(" btnSortUpAction " + sortedUpList);
        int idx = 0;
        assert sortedUpList != null;
        for (String category : sortedUpList) {
            addToField(idx++, category,
                    titleFood, titleHouse, titleShopping,
                    titleTransport, titleEntertainment, titleOther,
                    outputFood, outputHouse, outputShopping,
                    outputTransport, outputEntertainment, outputOther);
        }
    }

    @FXML
    public void btnSortDownAction() {
        List<String> sortedDownList = convertMap(budgetByMonth, currentMonth, false);

        int idx = 0;
        assert sortedDownList != null;
        for (String category : sortedDownList) {
            addToField(idx++, category,
                    titleFood, titleHouse, titleShopping,
                    titleTransport, titleEntertainment, titleOther,
                    outputFood, outputHouse, outputShopping,
                    outputTransport, outputEntertainment, outputOther);
        }
    }
}
