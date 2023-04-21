package com.example.btracker;

import com.example.btracker.allClasses.GetMonthAndIncome;
import com.example.btracker.allClasses.NewAmountIncome;
import com.example.btracker.exception.CustomException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.btracker.allClasses.Calculation.*;
import static com.example.btracker.collectData.CollectData.collectData;
import static com.example.btracker.correctMonth.CorrectMonth.correctMonth;
import static com.example.btracker.sameOperation.OperationBtnAction.showButtonsAction;
import static com.example.btracker.sameOperation.OperationBtnAction.showButtonsMonthAction;
import static com.example.btracker.sameOperation.StyleBtns.styleButtonsMonthAndShow;
import static com.example.btracker.sameOperation.StyleBtns.styleButtonsMonthAndSort;
import static com.example.btracker.sortingData.AddToField.addToField;
import static com.example.btracker.sortingData.SortingData.convertMap;
import static com.example.btracker.theme.Theme.theme;

public class MainController {


  private String currentMonth = "";
    public static Map<String, List<String>> budgetByMonth = new HashMap<>();// Сохранение всех данных по месяцам
    public static final String errorIfMinus = "Negative income!";
    private static final String errorIfString = "Error: You didn't enter a number";

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

    private void saveChangesAction() {
        String month = inputMonth.getText().toLowerCase();
        GetMonthAndIncome dataMonthAndIncome = new GetMonthAndIncome(month, freezeFixAmount);

        List<String> valuesAllCategory = collectData(
                dataMonthAndIncome.income(), budgetFood, budgetHouse,
                budgetShopping, budgetTransport, budgetEntertainment, budgetOther);

        incomeFix = dataMonthAndIncome.income();
        budgetByMonth.put(dataMonthAndIncome.month(), valuesAllCategory);

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

    @FXML
    private Text titleFix;
    private int budget = 0;
    private int freezeFixAmount = 0;

    @FXML
    private void btnIncomeAction() {
        try {
            correctMonth(inputMonth.getText().toLowerCase()); //  преобразовать введенную строку в число

            int newAmountIncome = Integer.parseInt(inputIncomeField.getText());

            if (newAmountIncome < 0) {
                throw new CustomException(errorIfMinus);
            } else {
                freezeFixAmount += newAmountIncome;
                budget += new NewAmountIncome(newAmountIncome).income();
                outputFix.setText("BUDGET  "+budget + " € ");
                outputError.setText("");
                outputIncome.setText(freezeFixAmount + " € ");
                fixAmount.setDisable(false);
                inputIncomeField.clear();
            }
        } catch (NumberFormatException e) {
            outputError.setText(errorIfString); // вывод сообщения об ошибке, если введенная строка не является числом
        } catch (CustomException e) {
            outputError.setText(e.getMessage());
        }
    }

    @FXML
    private void minusIncomeFieldAction() {
        budget = 0;
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
            int priceForFood = Integer.parseInt(inputFood.getText()); // преобразование введенной строки в число
            budgetFood = addMoney(priceForFood, budgetFood, budget);
            budget = calculateBudget(budget, priceForFood);
            showButtonsAction(outputFix, outputFood, outputError, budget, budgetFood);
        } catch (NumberFormatException e) {
            outputError.setText(errorIfString); // вывод сообщения об ошибке, если введенная строка не является числом
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
            int priceForHouse = Integer.parseInt(inputHouse.getText());
            budgetHouse = addMoney(priceForHouse, budgetHouse, budget);
            budget = calculateBudget(budget, priceForHouse);
            showButtonsAction(outputFix, outputHouse, outputError, budget, budgetHouse);
        } catch (NumberFormatException e) {
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
            int priceForShopping = Integer.parseInt(inputShopping.getText());
            budgetShopping = addMoney(priceForShopping, budgetShopping, budget);
            budget = calculateBudget(budget, priceForShopping);
            showButtonsAction(outputFix, outputShopping, outputError, budget, budgetShopping);
        } catch (NumberFormatException e) {
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
            int priceForTransport = Integer.parseInt(inputTransport.getText());
            budgetTransport = addMoney(priceForTransport, budgetTransport, budget);
            budget = calculateBudget(budget, priceForTransport);
            showButtonsAction(outputFix, outputTransport, outputError, budget, budgetTransport);
        } catch (NumberFormatException e) {
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
            int priceForEntertainment = Integer.parseInt(inputEntertainment.getText());
            budgetEntertainment = addMoney(priceForEntertainment, budgetEntertainment, budget);
            budget = calculateBudget(budget, priceForEntertainment);
            showButtonsAction(outputFix, outputEntertainment, outputError, budget, budgetEntertainment);
        } catch (NumberFormatException e) {
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
            int priceForOther = Integer.parseInt(inputOther.getText());
            budgetOther = addMoney(priceForOther, budgetOther, budget);
            budget = calculateBudget(budget, priceForOther);
            showButtonsAction(outputFix, outputOther, outputError, budget, budgetOther);
        } catch (NumberFormatException e) {
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
            budget = calculateBudgetReturn(budget, priceForFoodReturn);
            showButtonsAction(outputFix, outputFood, outputError, budget, budgetFood);
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
            budget = calculateBudgetReturn(budget, priceForHouseReturn);
            showButtonsAction(outputFix, outputHouse, outputError, budget, budgetHouse);
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
            budget = calculateBudgetReturn(budget, priceForShoppingReturn);
            showButtonsAction(outputFix, outputShopping, outputError, budget, budgetShopping);
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
            budget = calculateBudgetReturn(budget, priceForTransportReturn);
            showButtonsAction(outputFix, outputTransport, outputError, budget, budgetTransport);
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
            budget = calculateBudgetReturn(budget, priceForEntertainmentReturn);
            showButtonsAction(outputFix, outputEntertainment, outputError, budget, budgetEntertainment);
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
            budget = calculateBudgetReturn(budget, priceForOtherReturn);
            showButtonsAction(outputFix, outputOther, outputError, budget, budgetOther);
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
        styleButtonsMonthAndShow(btnDecemberShow, btnDecember, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnDecember.getText(), earnDecember, spendDecember);
    }

    @FXML
    public void btnDecemberShowAction() {
        currentMonth = btnDecember.getText();
        styleButtonsMonthAndSort(btnDecember, sortText, btnSortUp, btnSortDown);
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
        styleButtonsMonthAndShow(btnJanuaryShow, btnJanuary, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnJanuary.getText(), earnJanuary, spendJanuary);
    }

    @FXML
    public void btnJanuaryShowAction() {
        currentMonth = btnJanuary.getText();
        styleButtonsMonthAndSort(btnJanuary, sortText, btnSortUp, btnSortDown);
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
        styleButtonsMonthAndShow(btnFebruaryShow, btnFebruary, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnFebruary.getText(), earnFebruary, spendFebruary);
    }

    @FXML
    public void btnFebruaryShowAction() {
        currentMonth = btnFebruary.getText();
        styleButtonsMonthAndSort(btnFebruary, sortText, btnSortUp, btnSortDown);
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
        styleButtonsMonthAndShow(btnMarchShow, btnMarch, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnMarch.getText(), earnMarch, spendMarch);
    }

    @FXML
    public void btnMarchShowAction() {
        currentMonth = btnMarch.getText();
        styleButtonsMonthAndSort(btnMarch, sortText, btnSortUp, btnSortDown);
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
        styleButtonsMonthAndShow(btnAprilShow, btnApril, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnApril.getText(), earnApril, spendApril);
    }

    @FXML
    public void btnAprilShowAction() {
        currentMonth = btnApril.getText();
        styleButtonsMonthAndSort(btnApril, sortText, btnSortUp, btnSortDown);
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
        styleButtonsMonthAndShow(btnMayShow, btnMay, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnMay.getText(), earnMay, spendMay);
    }

    @FXML
    public void btnMayShowAction() {
        currentMonth = btnMay.getText();
        styleButtonsMonthAndSort(btnMay, sortText, btnSortUp, btnSortDown);
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
        styleButtonsMonthAndShow(btnJuneShow, btnJune, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnJune.getText(), earnJune, spendJune);
    }

    @FXML
    public void btnJuneShowAction() {
        currentMonth = btnJune.getText();
        styleButtonsMonthAndSort(btnJune, sortText, btnSortUp, btnSortDown);
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
        styleButtonsMonthAndShow(btnJulyShow, btnJuly, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnJuly.getText(), earnJuly, spendJuly);
    }

    @FXML
    public void btnJulyShowAction() {
        currentMonth = btnJuly.getText();
        styleButtonsMonthAndSort(btnJuly, sortText, btnSortUp, btnSortDown);
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
        styleButtonsMonthAndShow(btnAugustShow, btnAugust, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnAugust.getText(), earnAugust, spendAugust);
    }

    @FXML
    public void btnAugustShowAction() {
        currentMonth = btnAugust.getText();
        styleButtonsMonthAndSort(btnAugust, sortText, btnSortUp, btnSortDown);
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
        styleButtonsMonthAndShow(btnSeptemberShow, btnSeptember, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnSeptember.getText(), earnSeptember, spendSeptember);
    }

    @FXML
    public void btnSeptemberShowAction() {
        currentMonth = btnSeptember.getText();
        styleButtonsMonthAndSort(btnSeptember, sortText, btnSortUp, btnSortDown);
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
        styleButtonsMonthAndShow(btnOctoberShow, btnOctober, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnOctober.getText(), earnOctober, spendOctober);
    }

    @FXML
    public void btnOctoberShowAction() {
        currentMonth = btnOctober.getText();
        styleButtonsMonthAndSort(btnOctober, sortText, btnSortUp, btnSortDown);
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
        styleButtonsMonthAndShow(btnNovemberShow, btnNovember, outputError, inputMonth);
        calcEarnAndSpendForMonth(budgetByMonth, btnNovember.getText(), earnNovember, spendNovember);
    }

    @FXML
    public void btnNovemberShowAction() {
        currentMonth = btnNovember.getText();
        styleButtonsMonthAndSort(btnNovember, sortText, btnSortUp, btnSortDown);
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
        budget = 0;
        freezeFixAmount = 0;
        budgetFood = 0;
        budgetHouse = 0;
        budgetShopping = 0;
        budgetTransport = 0;
        budgetEntertainment = 0;
        budgetOther = 0;
        outputError.setText("");
        titleFix.setText("");
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

        List<String> sortedUpList = convertMap(budgetByMonth, currentMonth, false);
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

        List<String> sortedDownList = convertMap(budgetByMonth, currentMonth, true);
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
  @FXML
  public VBox mainContainer;
  @FXML
  public CheckBox theme;
  List<Text>  outputs = new ArrayList<>();
  public void checkBoxThemeAction() {
    outputs.add(outputFix);
    outputs.add(titleIncome);
    outputs.add(outputFood);
    outputs.add(outputHouse);
    outputs.add(outputShopping);
    outputs.add(outputTransport);
    outputs.add(outputEntertainment);
    outputs.add(outputOther);
    theme(mainContainer,theme,outputs);
  }
}
