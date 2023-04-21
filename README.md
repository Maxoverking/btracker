# Btracker

Проект подготовлен: @Maxoverking @MarynaPogrebniak @melondina в рамках курса "Базовое программирование"

Руководитель: Кирилл Шнырёв
### Функционал приложения:
- Записывает расходы, доходы, бюджет по месяцам;
- Выводит результаты подсчетов на экран;
- Ведется статистика за каждый месяц;
- Сортировка расходов по конкретному месяцу.
### Точка входа:
Запустить приложение можно через [Main.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2FMain.java)
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
![Схема работы приложения](src%2Fmain%2Fresources%2Fscheme.jpg)
#### Архитектура приложения - классы и методы (краткое описание):
- [Main.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2FMain.java)- запуск приложения;
- [MainController.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2FMainController.java) - взаимодействие всех элементов приложения;
- [Calculation.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2FallClasses%2FCalculation.java) - методы для подсчета расходов, общего бюджета:
  - calculateBudget - подсчет общего бюджета;
  - calculateBudgeReturn - подсчет общего бюджета после удаления суммы из категории;
  - addMoney - подсчет расходов по одной категории;
  - returnMoney - подсчет расходов по одной категории после удаления суммы из этой категории;
  - calcEarnAndSpendForMonth - подсчет доходов и расходов за весь месяц и вывод на экран.
- [GetMonthAndIncome.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2FallClasses%2FGetMonthAndIncome.java) - конструктор для дохода и месяца;
- [NewAmountIncome.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2FallClasses%2FNewAmountIncome.java) - конструктор для дохода;
- [CollectData.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2FcollectData%2FCollectData.java) - сбор данных по расходам и доходам за выбранный месяц;
- [CorrectMonth.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2FcorrectMonth%2FCorrectMonth.java) - проверка корректности ввода месяца;
- [CustomException.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2Fexception%2FCustomException.java) - ошибки неправильного ввода;
- [OperationBtnAction.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2FsameOperation%2FOperationBtnAction.java) - методы, выводящие на экран информацию:
    - showButtonsAction - вывод расходов по категории;
    - showButtonsMonthAction - вывод расходов и доходов за выбранный месяц.
- [StyleBtns.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2FsameOperation%2FStyleBtns.java) - стиль кнопок;
- [AddToField.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2FsortingData%2FAddToField.java) - вывод данный после сортировки;
- [Theme.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2Ftheme%2FTheme.java) - изменение цвета окна приложения;
- [SortingData.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2FsortingData%2FSortingData.java) - сортировка расходов;
- [tests](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2Ftests) - Юнит-тесты для методов:
  - Тесты на проверку правильности вычислений и выброса ошибок:
    - [AddMoneyTests.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2Ftests%2FAddMoneyTests.java);
    - [CalculateBudgetReturnTests.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2Ftests%2FCalculateBudgetReturnTests.java);
    - [CalculateBudgetTests.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2Ftests%2FCalculateBudgetTests.java);
    - [ReturnMoneyTests.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2Ftests%2FReturnMoneyTests.java);
  - Тест на корректность ввода месяца: 
    - [CorrectMonthTests.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2Ftests%2FCorrectMonthTests.java).
  - Тест на заполнение данных:
    - [CollectDataTests.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2Ftests%2FCollectDataTests.java).
  - Тест на сортировку:
    - [SortingDataTests.java](src%2Fmain%2Fjava%2Fcom%2Fexample%2Fbtracker%2Ftests%2FSortingDataTests.java).
- [my-budget.fxml](src%2Fmain%2Fresources%2Fcom%2Fexample%2Fbtracker%2Fmy-budget.fxml) - разметка приложения.
