# Btracker
Проект подготовлен @MarynaPogrebniak @melondina @Maxoverking
melondina
MarynaPogrebniak

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
![Схема работы приложения](..%2F..%2F..%2F..%2Fresources%2Fscheme.jpg)
#### Архитектура приложения - классы и методы (краткое описание):
- [Main.java](Main.java) - запуск приложения;
- [MainController.java](MainController.java) - взаимодействие всех элементов приложения;
- [Calculation.java](allClasses%2FCalculation.java) - методы для подсчета расходов, общего бюджета:
  - calculateBudget - подсчет общего бюджета;
  - calculateBudgeReturn - подсчет общего бюджета после удаления суммы из категории;
  - addMoney - подсчет расходов по одной категории;
  - returnMoney - подсчет расходов по одной категории после удаления суммы из этой категории;
  - calcEarnAndSpendForMonth - подсчет доходов и расходов за весь месяц и вывод на экран.
- [GetMonthAndIncome.java](allClasses%2FGetMonthAndIncome.java) - конструктор для дохода и месяца;
- [NewAmountIncome.java](allClasses%2FNewAmountIncome.java) - конструктор для дохода;
- [CollectData.java](collectData%2FCollectData.java) - сбор данных по расходам и доходам за выбранный месяц;
- [CorrectMonth.java](correctMonth%2FCorrectMonth.java) - проверка корректности ввода месяца;
- [CustomException.java](exception%2FCustomException.java) - ошибки неправильного ввода;
- [OperationBtnAction.java](sameOperation%2FOperationBtnAction.java) - методы, выводящие на экран информацию:
    - showButtonsAction - вывод расходов по категории;
    - showButtonsMonthAction - вывод расходов и доходов за выбранный месяц.
- [StyleBtns.java](sameOperation%2FStyleBtns.java) - стиль кнопок;
- [AddToField.java](sortingData%2FAddToField.java) - вывод данный после сортировки;
- [SortingData.java](sortingData%2FSortingData.java) - сортировка расходов.
- [Tests](Tests) - Юнит-тесты для методов из классов:
  - Calculation;
  - CollectData;
  - CorrectMonth;
  - SortingData.
- [my-budget.fxml](..%2F..%2F..%2F..%2Fresources%2Fcom%2Fexample%2Fbtracker%2Fmy-budget.fxml) - разметка приложения.








