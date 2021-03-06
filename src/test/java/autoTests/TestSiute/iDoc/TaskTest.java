/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoTests.TestSiute.iDoc;

import autoTests.CustomMethods;

import autoTests.TestSiute.iDoc.HistoryEnums.HistoryFilterType;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static autoTests.TestSiute.iDoc.HistoryEnums.HistoryRoleType.*;
import static autoTests.TestSiute.iDoc.HistoryEnums.HistoryStatusType.*;

/**
 * На тестах, находящихся тут, я тестирую работоспособность методов, файл перманентный
 *
 * @author Oleksandr Belichenko
 */
public class TaskTest extends CustomMethods {

    @Test
    public void SZ() throws Exception {
        String sBP = "_doc_btsol_vertical_sz";
        openURLdashboard(getRegionUrl());

        AuthorizationBySetLoginPassword("IGOV_270907SVK", " ");
        clickButton("Увійти");
        navigateToggleMenu();
        //setRegionFindOrder("5-275013");
        createDocumentOrTask("Службова записка");
        clickButton("Далi");
        pause(10000);

        setDocTitle("Autotest is back");
        setDocContent("Back! Back! Back!");

        /*Таблица Узгоджуючі*/
//        setRegionTableCellsInputTypeEnumInput(driver, sBP, "sTableAgree", "sName_Approver", "0", "Замдиректора Потапченко Василь");
        setAcceptor(sBP, "sTableAccept", "sName_Acceptor", "0", "Туренко Ольга Володимирівна");

        /*Таблица Затверджуючий*/
        setApprover(sBP, "sTableAgree", "sName_Approver", "0", "Павленко Юлія Юріївна");

        /*Таблица Адресат*/
        setDirect(sBP, "sTableDirect", "sName_Direct", "0", "Смоктій Вікторія Кирилівна");

        addTask();
        setController("Туренко Ольга Володимирівна");
        setExecutor("Павленко Юлія Юріївна");
        //setTaskForm("Документ");
        //setTaskForm("Файл");
        setTaskForm("Текстове повiдомлення");
        setTaskTerm("Кiлькiсть днiв пiсля", "10");
        setTaskName("Theme1");
        setTaskContent("Content1");
        addNewExecutor("Смоктій Вікторія Кирилівна");
        //setMainExecutor("Смоктій Вікторія Кирилівна");


        addTask();
        setController("Туренко Ольга Володимирівна");
        setExecutor("Гуков Юрій Олександрович");
        setTaskForm("Документ");
        //setTaskForm("Файл");
        //setTaskForm("Текстове повiдомлення");
        setTaskTerm("Календарна дата", "30/05/2018");
        setTaskName("Theme2");
        setTaskContent("Content2");
        addNewExecutor("Грек Одарка Олексіївна");
        //setMainExecutor("Смоктій Вікторія Кирилівна");

        clickButtonCreate();
        clickButton("Ok");
    }

    @Test
    public void SZ2() throws Exception {
        String sBP = "_doc_btsol_vertical_sz";
        openURLdashboard(getRegionUrl());

        AuthorizationBySetLoginPassword("IGOV_200687TOV", " ");
        clickButton("Увійти");
        navigateToggleMenu();
        createTask("Завдання");
        clickButton("Далi");
        //setRegionFindOrder("5-875451");
        pause(10000);
        setExecutor("Павленко Юлія Юріївна");
        addNewExecutor("Смоктій Вікторія Кирилівна");
        setTaskTerm("30/05/2018");
        setTaskName("Theme2");
        setTaskContent("Content2");
        setTaskForm("Документ");
        getOrderFromUrlCurrentPage();
        clickButtonCreateTask();
        pause(5000);
        clickButton("Ok");
        clickLink("Туренко Ольга Володимирівна");
        clickLink("Вийти");

        AuthorizationBySetLoginPassword("IGOV_270907SVK", " ");
        clickButton("Увійти");
        pause(5000);
        setRegionFindOrderByNumberDocument();
        delegateTask("Грек Одарка Олексіївна", "30/05/2018", "Без спільного виконання");


        //clickButton("Інші дії");
        //clickButton("Делегувати");
        // addDelegate("");
        //clickButtonSign();

    }

    @Test
    public void SZ3() throws Exception {
        openURLdashboard(getRegionUrl());
        AuthorizationBySetLoginPassword("IGOV_260185SAU", " ");
        clickButton("Увійти");
        /*setRegionFindOrder("5-1752592");
        addTask();
        setController("Туренко Ольга Володимирівна");
        setExecutor("Павленко Юлія Юріївна");
        //setTaskForm("Документ");
        //setTaskForm("Файл");
        setTaskForm("Текстове повiдомлення");
        setTaskTerm("Кiлькiсть днiв пiсля", "10");
        setTaskName("Theme1");
        setTaskContent("Content1");*/
        ;
        navigateToggleMenu();
        snapDrawerButtonMenuTabs("Завдання");
        clickLink("На виконанні");

        clickButton("Додати звіт");
        SetRegionFieldInputTypeEnum("Виконано");

    }

    @Test
    public void Test() throws Exception {
        openURLdashboard("https://alpha.test.idoc.com.ua");
        AuthorizationBySetLoginPassword("IGOV_270907SVK", " ");
        clickButton("Увійти");
        pause(5000);
        navigateToggleMenu();
        snapDrawerButtonMenuTabs("Завдання");
        searchTaskByText("проверка связи");
        addReport("Виконане", "Завдання виконане");

        pause(5000);
    }

    @Test
    public void test() throws Exception {
        openURLdashboard("https://beta.test.idoc.com.ua");
        AuthorizationBySetLoginPassword("IGOV_301082BOY", " ");
        clickButton("Увійти");
        pause(5000);
        setRegionFindOrder("№ 15-7604458");
        pause(5000);

        addTask();
        setController("Туренко Ольга Володимирівна");
        setExecutor("Павленко Юлія Юріївна");
        //setTaskForm("Документ");
        //setTaskForm("Файл");
        setTaskForm("Текстове повiдомлення");
        setTaskTerm("Кiлькiсть днiв пiсля", "10");
        setTaskName("Theme1");
        setTaskContent("Content1");
        addNewExecutor("Смоктій Вікторія Кирилівна");
        //setMainExecutor("Смоктій Вікторія Кирилівна");


        addTask();
        setController("Туренко Ольга Володимирівна");
        setExecutor("Гуков Юрій Олександрович");
        setTaskForm("Документ");
        //setTaskForm("Файл");
        //setTaskForm("Текстове повiдомлення");
        setTaskTerm("Календарна дата", "30/05/2018");
        setTaskName("Theme2");
        setTaskContent("Content2");
        addNewExecutor("Грек Одарка Олексіївна");
        //setMainExecutor("Смоктій Вікторія Кирилівна");
        setLastExecutorAsMain();
        removeLastExecutor();

        pause(15000);

    }

    @Test
    public void test2() throws Exception {
        openURLdashboard("https://gamma.test.idoc.com.ua");
        AuthorizationBySetLoginPassword("IGOV_270907SVK", " ");
        clickButton("Увійти");
        pause(3000);
        navigateToggleMenu();
        snapDrawerButtonMenuTabs("Завдання");
        searchTaskByText("зЯАТ92нЯФМ");
        addReport("Виконане", "Завдання виконане");

        pause(5000);
    }

    @Test
    public void testHistory() throws Exception {
        openURLdashboard("https://alpha.test.idoc.com.ua");
        AuthorizationBySetLoginPassword("IGOV_200687TOV", " ");//IGOV_270907SVK  Смоктій Вікторія Кирилівна
        pause(3000);

        navigateToggleMenu();
        setRegionFindOrder("№ 15-4229401");
        enterInHistory();
        searchInHistory("DelegateDoc","Туренко Ольга Володимирівна" , "Туренко Ольга Володимирівна", "привет", "Грек О О",
                VISOR.getsRole(), "Белявцев В. В.", AGREE.getsStatus());
    }

    @Test
    public void testBool() {
        Map<String, Object> mBody = new HashMap<>();
        mBody.put("123", false);
        boolean boolean2 = (Boolean) mBody.get("123");

        System.out.println(boolean2);
    }

    @Test
    public void testUrgentButton() throws Exception {
        openURLdashboard(getRegionUrl());
        AuthorizationBySetLoginPassword("ZCPK_020379CDP", " ");
        pause(3000);
        navigateToggleMenu();
        setRegionFindOrder("14-36102817");
        pause(4000);
        // addAcceptor("Терентьєв Володимир Володимирович");
        setAcceptor("_doc_btsol_vertical_sz", "sTableAccept", "sName_Acceptor", "0", "Терентьєв Володимир Володимирович");
        pause(1000);
        setApprover("_doc_btsol_vertical_sz", "sTableAgree", "sName_Approver", "0", "Пітула Олександр Володимирович");
        pause(8000);
    }

    @Test
    public void testLoadfile() throws Exception {
        String sBP = "_doc_btsol_vertical_sz";
        String LoginCollective1 = "IGOV_160582SOD";
        String NameCollective1 = "Смоктій Оксана Данилівна";
        String LoginCollective2 = "IGOV_310780BVV";
        String NameCollective2 = "Белявцев Володимир Володимирович";
        String LoginCollective3 = "IGOV_301082BOY";
        String NameCollective3 = "Бондарь Ольга Євгенієвна";

        openURLdashboard(getRegionUrl());

        login("ZCPK_310767TVV", " ");
        navigateToggleMenu();
        createDocumentOrTask("Службова записка");
        clickButton("Далi");
        pause(5000);

        setDocTitle("Текст службової записки, проверка дублей");
        setDocContent("Дубля дубля где же ты");
        setAcceptor(sBP, "sTableAccept", "sName_Acceptor", "0", NameCollective1);
        addRegionsTableRow("sTableAccept");
        pause(1000);
        setAcceptor(sBP, "sTableAccept", "sName_Acceptor", "1", NameCollective1);
        setApprover(sBP, "sTableAgree", "sName_Approver", "0", NameCollective2);
        setDirect(sBP, "sTableDirect", "sName_Direct", "0", NameCollective3);
        clickButtonCreate();
        pause(2000);
        checkDuplicateInTheRow();
        pause(5000);

    }

    @Test
    public void testRemoveParticipant() throws Exception {
        openURLdashboard(getRegionUrl());
        login("ZCPK_310767TVV", " ");
        navigateToggleMenu();

        pause(2000);
        setRegionFindOrder("14-36306562");
        pause(1000);
        removeParticipant(2, true);
        pause(5000);
    }

    @Test
    public void testDeleteRowFromTable() throws Exception {
        String sBP = "_doc_btsol_vertical_sz";
        String LoginCollective1 = "IGOV_160582SOD";
        String NameCollective1 = "Смоктій Оксана Данилівна";
        String LoginCollective2 = "IGOV_310780BVV";
        String NameCollective2 = "Белявцев Володимир Володимирович";
        String LoginCollective3 = "IGOV_301082BOY";
        String NameCollective3 = "Бондарь Ольга Євгенієвна";

        openURLdashboard(getRegionUrl());
        login("ZCPK_310767TVV", " ");
        navigateToggleMenu();
        setRegionFindOrder("14-36318997");
        pause(2000);
        /*createDocumentOrTask("Службова записка");
        clickButton("Далi");
        pause(5000);

        setDocTitle("Текст службової записки, удаляем строки");
        setDocContent("Текст службової записки при удален");

        setAcceptor(sBP, "sTableAccept", "sName_Acceptor", "0", NameCollective1);
        setApprover(sBP, "sTableAgree", "sName_Approver", "0", NameCollective2);
        setDirect(sBP, "sTableDirect", "sName_Direct", "0", NameCollective3);

        getOrderFromUrlCurrentPage();
        clickButtonCreate();
        setRegionFindOrderByNumberDocument();*/
       // clickButton("Редагувати");
        removeRowFromTable("sTableAccept", 0, false);
        removeRowFromTable("sTableAgree", 0, true);
        removeRowFromTable("sTableDirect", 0, true);
        pause(5000);
    }
}
    /*String LoginAuthor = "ZCPK_310767TVV";
    String NameAuthor = "Терентьєв Володимир Володимирович";
    String Login1 = "ZCPK_020379CDP";
    String Name1 = "Чмихал Дмитро Павлович";
    String Login2 = "ZCPK_150960POV";
    String Name2 = "Пітула Олександр Володимирович";
    String Login3 = "ZCPK_050991BSO";
    String Name3 = "Будай Coломія Олексіївна";
    String Login4 = "ZCPK_280562DGI";
    String Name4 = "Долінська Галина Йосипівна";
    String Login5 = "ZCPK_220185NSV";
    String Name5 = "Норов Станіслав Валентинович";
    String Login6 = "ZCPK_230161DYR";
    String Name6 = "Давидчак Ярослав Романович";
    String Login7 = "ZCPK_031260SVM";
    String Name7 = "Стефанів Василь Михайлович";*/

