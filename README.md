# Btracker - Budget tracker

The project was worked on: [Максим Аверкин](https://github.com/Maxoverking), [Марина Погребняк](https://github.com/MarynaPogrebniak), [Дина Мигунова](https://github.com/melondina) in the "Basic Java programming" course

Leader: Kirill Shnyrev
### Functionality of the app:
- Records expenses, income, budget by month;
- Outputs the results of the calculations to the screen;
- Statistics are kept for each month;
- Sort the expenses by specific month.
### Point of entry:
You can start the application by [Main.java](src/main/java/com/example/btracker/Main.java)
### User manual:
- In the Month field, enter the month;
- Fill in the fields by category and click Add:
  - The amount entered is shown on the screen next to this button; 
  - The budget field shows the difference between income and expenditure for the selected month.
- To remove the required amount from the expenditure category:
  - Enter the amount you wish to delete and press Return money.
- To clear the income category, press the button with the " - " sign.
- When you have entered all the data, press Save changes:
  - At the top of the app, the amount of income and expenses for that month will be displayed;
  - The Show button will appear.
- Click on the Show button to display the expenditure by category for that month.
- Press the Sort button to sort the costs in ascending or descending order.
- Press the Clear all notes button to go on to fill in the data for the new month.
### Technical documentation:
The JavaFX platform was used to develop the application
#### The scheme of how the application works:
![Application flowchart](src/main/resources/scheme.jpg)
#### Application architecture - classes and methods (brief description):
- [Main.java](src/main/java/com/example/btracker/Main.java)- application start-up;
- [MainController.java](src/main/java/com/example/btracker/MainController.java) - the interaction of all elements of the application;
- [Calculation.java](src/main/java/com/example/btracker/allClasses/Calculation.java) - methods for calculating costs, the overall budget:
  - calculateBudget - calculating the total budget;
  - calculateBudgeReturn - calculation of the total budget after removing the amount from the category;
  - addMoney - counting costs per category;
  - returnMoney - counting the expenditure for one category after the amount has been deleted from that category;
  - calcEarnAndSpendForMonth - calculating the whole month's income and expenses and displaying them on the screen.
- [GetMonthAndIncome.java](src/main/java/com/example/btracker/allClasses/GetMonthAndIncome.java) - constructor for income and month;
- [NewAmountIncome.java](src/main/java/com/example/btracker/allClasses/NewAmountIncome.java) - constructor for income;
- [CollectData.java](src/main/java/com/example/btracker/collectData/CollectData.java) - collection of expenditure and income data for the selected month;
- [CorrectMonth.java](src/main/java/com/example/btracker/correctMonth/CorrectMonth.java) - check that the month has been entered correctly;
- [CustomException.java](src/main/java/com/example/btracker/exception/CustomException.java) - incorrect input errors;
- [OperationBtnAction.java](src/main/java/com/example/btracker/sameOperation/OperationBtnAction.java) - methods that display information on the screen:
    - showButtonsAction - the output of costs by category;
    - showButtonsMonthAction - display of expenses and income for the selected month.
- [StyleBtns.java](src/main/java/com/example/btracker/sameOperation/StyleBtns.java) - button style;
- [AddToField.java](src/main/java/com/example/btracker/sortingData/AddToField.java) - the output after sorting;
- [Theme.java](src/main/java/com/example/btracker/theme/Theme.java) - theme;
- [SortingData.java](src/main/java/com/example/btracker/sortingData/SortingData.java) - cost sorting;
- [tests](src/main/java/com/example/btracker/tests) - Unit tests for methods:
  - Tests to check that calculations are correct and that errors are thrown out:
    - [AddMoneyTests.java](src/main/java/com/example/btracker/tests/AddMoneyTests.java);
    - [CalculateBudgetReturnTests.java](src/main/java/com/example/btracker/tests/CalculateBudgetReturnTests.java);
    - [CalculateBudgetTests.java](src/main/java/com/example/btracker/tests/CalculateBudgetTests.java);
    - [ReturnMoneyTests.java](src/main/java/com/example/btracker/tests/ReturnMoneyTests.java);
  - A test to ensure that the month is entered correctly: 
    - [CorrectMonthTests.java](src/main/java/com/example/btracker/tests/CorrectMonthTests.java).
  - Data completion test:
    - [CollectDataTests.java](src/main/java/com/example/btracker/tests/CollectDataTests.java).
  - Sorting test:
    - [SortingDataTests.java](src/main/java/com/example/btracker/tests/SortingDataTests.java).
- [my-budget.fxml](src/main/resources/com/example/btracker/my-budget.fxml) - application markup.
