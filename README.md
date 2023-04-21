# Btracker

Проект подготовлен: @Maxoverking @MarynaPogrebniak @melondina в рамках курса "Базовое программирование"

Руководитель: Кирилл Шнырёв
### Функционал приложения:
- Записывает расходы, доходы, бюджет по месяцам;
- Выводит результаты подсчетов на экран;
- Ведется статистика за каждый месяц;
- Сортировка расходов по конкретному месяцу.
### Точка входа:
Запустить приложение можно через [Main.java](Main.java)
### Руководство пользователя:
- В поле Month введите месяц;
- Заполните поля по категориям и нажмите кнопку Add:
  - Введенная сумма отображается на экране рядом с этой кнопкой; 
  - В поле budget выводится разница между доходами и расходами по выбранному месяцу.
- Для удаления необходимой суммы из категории расходов:
  - Введите сумму, которую хотите удалить, и нажмите кнопку Return money.
- Для очищения категории доходов нажмите кнопку со знаком " - ".
- После введения всех данных нажмите Save changes:
  - В верхней части приложения выведется сумма доходов и расходов по этому месяцу;
  - Появится кнопка Show.
- Для вывода расходов по категориям за этот месяц нажмите на кнопку Show.
- Для сортировки расходов по возрастанию или убыванию нажмите кнопку Sort.
- Чтобы перейти к заполнению данных для нового месяца нажмите кнопку Clear all notes.
### Техническая документация:
Для разработки приложения использована платформа JavaFX
#### Схема работы приложения:
![Схема работы приложения](../../../../resources/scheme.jpg)
#### Архитектура приложения - классы и методы (краткое описание):
- [Main.java](Main.java) - запуск приложения;
- [MainController.java](MainController.java) - взаимодействие всех элементов приложения;
- [Calculation.java](allClasses/Calculation.java) - методы для подсчета расходов, общего бюджета:
  - calculateBudget - подсчет общего бюджета;
  - calculateBudgeReturn - подсчет общего бюджета после удаления суммы из категории;
  - addMoney - подсчет расходов по одной категории;
  - returnMoney - подсчет расходов по одной категории после удаления суммы из этой категории;
  - calcEarnAndSpendForMonth - подсчет доходов и расходов за весь месяц и вывод на экран.
- [GetMonthAndIncome.java](allClasses/GetMonthAndIncome.java) - конструктор для дохода и месяца;
- [NewAmountIncome.java](allClasses/NewAmountIncome.java) - конструктор для дохода;
- [CollectData.java](collectData/CollectData.java) - сбор данных по расходам и доходам за выбранный месяц;
- [CorrectMonth.java](correctMonth/CorrectMonth.java) - проверка корректности ввода месяца;
- [CustomException.java](exception/CustomException.java) - ошибки неправильного ввода;
- [OperationBtnAction.java](sameOperation/OperationBtnAction.java) - методы, выводящие на экран информацию:
    - showButtonsAction - вывод расходов по категории;
    - showButtonsMonthAction - вывод расходов и доходов за выбранный месяц.
- [StyleBtns.java](sameOperation/StyleBtns.java) - стиль кнопок;
- [AddToField.java](sortingData/AddToField.java) - вывод данный после сортировки;
- [SortingData.java](sortingData/SortingData.java) - сортировка расходов.
- [Tests](Tests) - Юнит-тесты для методов:
  - Тесты на проверку правильности вычислений и выброса ошибок:
    - [AddMoneyTests.java](Tests/AddMoneyTests.java);
    - [CalculateBudgetReturnTests.java](Tests/CalculateBudgetReturnTests.java);
    - [CalculateBudgetTests.java](Tests/CalculateBudgetTests.java);
    - [ReturnMoneyTests.java](Tests/ReturnMoneyTests.java);
  - Тест на корректность ввода месяца: 
    - [CorrectMonthTests.java](Tests/CorrectMonthTests.java).
  - Тест на заполнение данных:
    - [CollectDataTests.java](Tests/CollectDataTests.java).
  - Тест на сортировку:
    - [SortingDataTests.java](Tests/SortingDataTests.java).
- [my-budget.fxml](..%2F..%2F..%2F..%2Fresources%2Fcom%2Fexample%2Fbtracker%2Fmy-budget.fxml) - разметка приложения.
