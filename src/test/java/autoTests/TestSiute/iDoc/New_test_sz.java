/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoTests.TestSiute.iDoc;

import autoTests.CustomMethods;

import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;
/**
 *
 * @author User
 */
public class New_test_sz extends CustomMethods {
    @Test
    public void Test_doc_btsol_vertical_sz() throws Exception {
        String sBP = "_doc_btsol_vertical_sz";
        String email = "autotestbeta@gmail.com";
        
        //Используемые в документе логины для Альфы/Гаммы
        /*String LoginAuthor = "IGOV_270907SVK";
        String NameAuthor = "Смоктій Вікторія Кирилівна";
        String Login1 = "IGOV_200687TOV";
        String Name1 = "Туренко Ольга Володимирівна";
        String Login2 = "IGOV_220290PUU";
        String Name2 = "Павленко Юлія Юріївна";
        String Login3 = "IGOV_130384GOA";
        String Name3 = "Грек Одарка Олексіївна";
        String Login4 = "IGOV_110771GAV";
        String Name4 = "Герман Август Васильович";
        String Login5 = "IGOV_260185SAU";
        String Name5 = "Столбова Анна Юріївна";
        String Login6 = "IGOV_230878LIV";
        String Name6 = "Літовченко Інна Вадимівна";
        String Login7 = "IGOV_151071GUO";
        String Name7 = "Гуков Юрій Олександрович";
        String Login8 = "IGOV_301082BOY";
        String Name8 = "Бондарь Ольга Євгенієвна";
        String Login9 = "IGOV_310780BVV";
        String Name9 = "Белявцев Володимир Володимирович";*/
        
        //Используемые в документе логины для Беты
        String LoginAuthor = "IGOV_310780BVV";
        String NameAuthor = "Белявцев Володимир Володимирович";
        String Login1 = "IGOV_160582SOD";
        String Name1 = "Смоктій Оксана Данилівна";
        String Login2 = "IGOV_301082BOY";
        String Name2 = "Бондарь Ольга Євгенієвна";
        String Login3 = "IGOV_180488PUG";
        String Name3 = "Продан Юлія Георгіївна";
        String Login4 = "IGOV_100982SOV";
        String Name4 = "Смірнова Олена Володимирівна";
        String Login5 = "IGOV_210961SMU";
        String Name5 = "Соколова Марина Юріївна";
        String Login6 = "IGOV_311288BUD";
        String Name6 = "Біла Юлія Данилівна";
        String Login7 = "IGOV_180277SMV";
        String Name7 = "Свідрань Максим Володимирович";
        String Login8 = "IGOV_200687TOV";
        String Name8 = "Туренко Ольга Володимирівна";
        String Login9 = "IGOV_220290PUU";
        String Name9 = "Павленко Юлія Юріївна";
        

        openURLdashboard(getRegionUrl());

        login(LoginAuthor, " ");
        navigateToggleMenu();
        counterBefore();
        createDocumentOrTask("Службова записка");
        clickButton("Далi");
        pause(5000);
        counterAfter("createDoc");
        
        setDocContent("Текст службової записки");

        setRegionTableCellsInputTypeString("sNumber", "0", "1");
        setRegionTableCellsInputTypeString("sNameFile", "0", "Тестовий додаток");
        setRegionTableCellsInputTypeFile(sBP,"sTableFile", "sFile", "0", "src/test/resources/files/test.jpg");

        /*Таблица Узгоджуючі*/
        setAcceptor(sBP, "sTableAccept", "sName_Acceptor", "0", Name1);
        addRegionsTableRow("sTableAccept");
        setAcceptor(sBP, "sTableAccept", "sName_Acceptor", "1", Name3);
        addRegionsTableRow("sTableAccept");
        setAcceptor(sBP, "sTableAccept", "sName_Acceptor", "2", Name2);

        /*Таблица Затверджуючий*/
        setApprover(sBP, "sTableAgree", "sName_Approver", "0", Name4);

        /*Таблица Адресат*/
        setDirect(sBP, "sTableDirect", "sName_Direct", "0", Name5);
        addRegionsTableRow("sTableDirect");
        setDirect(sBP, "sTableDirect", "sName_Direct", "1", Name6);
        
        getOrderFromUrlCurrentPage();
        clickButtonCreate();
        isError();
        logout();
        
        /*2 Делегируем согласование первым подписантом на другого сотрудника*/
        login(Login1, " ");
        setRegionFindOrderByNumberDocument();
        counterBefore();
        pause(2000);
        clickButton("Інші дії");
        clickButton("Делегувати");
        pause(2000);
        addDelegate(Name7);
        pause(2000);
        isError();
        //counterAfter("sign");
        pause(2000);
        logout();

        /*3. Работа на этапе согласования (1 пользователь). Подписываем*/
        login(Login7, " ");
        setRegionFindOrderByNumberDocument();
        counterBefore();
        pause(2000);
        /*Наличие кнопок*/
        clickButton("Інші дії");
        isExistButton("Пiдписати",true);
        isExistButton("Зберегти",true);
        isExistButton("Роздрукувати",true);
        isExistButton("Зауваження",true);
        isExistButton("Додати на перегляд",true);
        isExistButton("Ознайомити",true);
        isExistButton("Додати підписанта",true);
        isExistButton("Делегувати",true);
        isExistButton("Відмовити",true);
        isExistButton("Підпис не потрібен",true);
        isExistButton("Коментар",true);
        /*Отсутствие кнопок*/
        isExistButton("Ознайомлен",false);
        isExistButton("Додати завдання",false);
        isExistButton("Редагувати завдання",false);
        isExistButton("Видалити",false);
        clickButtonSign();
        isError();
        pause(2000);
        counterAfter("sign");
        logout();
        
        /*4 Подписываем и снимаем подпись*/
        login(Login2, " ");
        setRegionFindOrderByNumberDocument();
        //counterBefore();
        pause(2000);
        clickButtonSign();
        pause(2000);
        //counterAfter("sign");
        //counterBefore();
        setRegionFindOrderByNumberDocument();
        cancelSign("Перевірка зняття підпису");
        isError();
        pause(2000);
        //counterAfter("backToWork");
        logout();
        
        /*5. Работа на этапе согласования (2 пользователь). Добавляем подписанта и вібираем “Підпис не потрібен”*/
        login(Login3, " ");
        setRegionFindOrderByNumberDocument();
        //counterBefore();
        pause(2000);
        clickButton("Інші дії");
        addAcceptor(Name5);
        clickButtonSignNotNeed(sBP, "коментар 1");
        isError();
        pause(2000);
        //counterAfter("sign");
        logout();
        
        /*6. Работа на этапе согласования (3 пользователь). Подписываем*/
        login(Login5, " ");

        setRegionFindOrderByNumberDocument();
        //counterBefore();
        pause(2000);
        clickButtonSign();
        isError();
        pause(2000);
        //counterAfter("sign");
        logout();

        /*7 Подписываем*/
        login(Login2, " ");
        setRegionFindOrderByNumberDocument();
        //counterBefore();
        pause(2000);
        clickButtonSign();
        isError();
        pause(2000);
        //counterAfter("sign");
        logout();

        /*8. Работа на этапе утверждения. Добавляем замечания и нового подписанта*/
        login(Login4, " ");
        setRegionFindOrderByNumberDocument();
        //counterBefore();
        pause(2000);
        clickButton("Інші дії");
        addAcceptor(Name3);
        addComment("Тестове зауваження");
        //clickButtonSign();
        isError();
        pause(2000);
        //counterAfter("sign");
        logout();

        /*9. Отвечаем на зауваження, снимаем подписи и возвращаем на согласование*/
        login(LoginAuthor, " ");
        setRegionFindOrderByNumberDocument();
        //counterBefore();
        pause(2000);
        clickButton("Редагувати");
        clickButton("Інші дії");
        /*Наличие кнопок*/
        isExistButton("Пiдписати",true);
        isExistButton("Зберегти",true);
        isExistButton("Роздрукувати",true);
        isExistButton("Коментар",true);
        isExistButton("Видалити",true);
        isExistButton("Додати на перегляд",true);
        isExistButton("Додати завдання",true);
        /*Отсутствие кнопок*/
        isExistButton("Зауваження",false);
        isExistButton("Ознайомити",false);
        isExistButton("Додати підписанта",false);
        isExistButton("Делегувати",false);
        isExistButton("Відмовити",false);
        isExistButton("Підпис не потрібен",false);
        isExistButton("Ознайомлен",false);
        isExistButton("Редагувати завдання",false);
        removeAllSigns();
        setFieldCheckBox("eReturnDocument");
        //answerComment("Відповідь на зауваження");
        //clickButton("Ok");
        clickButtonSign();
        isError();
        pause(2000);
        //counterAfter("editDoc");
        logout();

        /*10. Работа на этапе согласования (1 пользователь). Подписываем”*/
        login(Login2, " ");
        setRegionFindOrderByNumberDocument();
        //counterBefore();
        pause(2000);
        clickButtonSign();
        isError();
        pause(2000);
        //counterAfter("sign");
        logout();
        
        /*11. Работа на этапе согласования (2 пользователь). Подписываем”
        login("Login3", " ");
        setRegionFindOrderByNumberDocument();
        pause(2000);
        clickButtonSign();
        isError();
        pause(2000);
        clickLink("Name3");
        clickLink("Вийти");*/

        /*12. Работа на этапе утверждения (1 пользователь. Подписываем*/
        login(Login4, " ");
        setRegionFindOrderByNumberDocument();
        pause(2000);
        //counterBefore();
        clickButton("Інші дії");
        /*Наличие кнопок*/
        isExistButton("Пiдписати",true);
        isExistButton("Зберегти",true);
        isExistButton("Роздрукувати",true);
        isExistButton("Зауваження",true);
        isExistButton("Додати на перегляд",true);
        isExistButton("Ознайомити",true);
        isExistButton("Додати підписанта",true);
        isExistButton("Делегувати",true);
        isExistButton("Відмовити",true);
        isExistButton("Коментар",true);
        /*Отсутствие кнопок*/
        isExistButton("Ознайомлен",false);
        isExistButton("Підпис не потрібен",false);
        isExistButton("Додати завдання",false);
        isExistButton("Редагувати завдання",false);
        isExistButton("Видалити",false);
        clickButtonSign();
        pause(2000);
        isError();
        pause(2000);
        //counterAfter("sign");
        logout();

        /*13. Подписываем дополнительнымм утверждающим (2 пользователь). Подписываем*/
        login(Login3, " ");
        setRegionFindOrderByNumberDocument();
        pause(2000);
        //counterBefore();
        clickButtonSign();
        isError();
        pause(2000);
        //counterAfter("sign");
        logout();

        /*14. Заходим адресатом 1. Добавляем задание 1*/
        login(Login5, " ");
        setRegionFindOrderByNumberDocument();
        pause(2000);
        //counterBefore();
        addTask();
        setTaskName(generateText(10));
        setTaskTerm("Кiлькiсть днiв пiсля", "5");
        setTaskForm("Текстове повiдомлення");
        //setTaskForm("Документ");
        //setTaskForm("Файл");
        setController(Name5);
        setExecutor(NameAuthor);
        addNewExecutor(Name4);
        setTaskContent("Перевірка завдання автотестом");
        clickButtonSign();
        isError();
        pause(2000);
        //counterAfter("sign");
        logout();

        /*15. Заходим адресатом 2.*/
        login(Login6, " ");
        setRegionFindOrderByNumberDocument();
        pause(2000);
        //counterBefore();
        clickButton("Інші дії");
        /*Наличие кнопок*/
        isExistButton("Пiдписати",true);
        isExistButton("Зберегти",true);
        isExistButton("Роздрукувати",true);
        isExistButton("Зауваження",true);
        isExistButton("Додати на перегляд",true);
        isExistButton("Ознайомити",true);
        isExistButton("Ознайомлен",true);
        isExistButton("Делегувати",true);
        isExistButton("Відмовити",true);
        isExistButton("Коментар",true);
        isExistButton("Підпис не потрібен",true);
        isExistButton("Додати завдання",true);
        /*Отсутствие кнопок*/
        isExistButton("Додати підписанта",false);
        isExistButton("Редагувати завдання",false);
        isExistButton("Видалити",false);
        clickButtonSign();
        isError();
        pause(2000);
        //counterAfter("sign");
        logout();

        /*16. Заходим исполнителем 1. Обработка задания. Добавляем отчет 1*/
        login(LoginAuthor, " ");
        snapDrawerButtonMenuTabs("Завдання");
        //counterBefore();
        clickLink("На виконанні");
        searchTaskByText(generateText);
        /*Наличие кнопок*/
        clickButton("Інші дії");
        isExistButton("Відкрити документ",true);
        isExistButton("Перенести",true);
        isExistButton("Додати звiт",true);
        isExistButton("Делегувати",true);
        isExistButton("Коментар",true);
        isExistButton("Редагувати завдання",false);
        addReport("Виконане", "Завдання виконане");
        isError();
        pause(2000);
        //counterAfter("reportTask");
        logout();

        /*17. Заходим исполнителем 2. Обработка задания. Добавляем отчет 2*/
        login(Login4, " ");
        snapDrawerButtonMenuTabs("Завдання");
        //counterBefore();
        clickLink("На виконанні");
        searchTaskByText(generateText);
        addReport("Не актуальне", "Не хочу це робити");
        isError();
        pause(2000);
        //counterAfter("reportTask");
        logout();

        /*18. Заходим контролирующим. Подтверждаем отчет*/
        login(Login5, " ");
        snapDrawerButtonMenuTabs("Завдання");
        //counterBefore();
        clickLink("На контролі");
        searchTaskByText(generateText);
        clickButton("Прийняти завдання");
        isError();
        pause(2000);
        //counterAfter("finishTask");
        logout();

        /*19. Заходим автором. Подписываем*/
        login(LoginAuthor, " ");
        setRegionFindOrderByNumberDocument();
        //counterBefore();
        clickButton("Ознайомлений");
        pause(2000);
        //counterAfter("deleteDoc");
        setRegionFindOrderByNumberDocument();
        clickButton("Інші дії");
        addViewer(Name8);
        clickButton("Інші дії");
        addViewer(Name9);
        removeParticipant(2,true);
        isError();
        pause(2000);
        logout();
    }
    
    
}
