/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoTests.TestSiute.iDoc;

import autoTests.CustomMethods;
import autoTests.pages.main.TemplatePage;
import org.junit.Test;

/**
 * _step("8. Вход по прямому URL на дашборд"); openURLdashboard(driver, sBP);
 *
 * _step("9. Авторизация login/BankID на дашборде. login/pass:
 * (tester/tester)"); AuthorizationBySetLoginPassword(driver, sBP, "tester",
 * "tester"); clickButton(driver, sBP, "Увійти");
 *
 * @author User
 */
public class TestNewDashboard extends CustomMethods {
//<editor-fold desc="Тестовый пример загрузки файла">

    @Test
    public void Test_test_autotest_dashboard() throws Exception {
        TemplatePage o = new TemplatePage();
        String sBP = "_test_autotest_dashboard";
        String email = "autotestbeta@gmail.com";
//        _step("1. Работа с сервисом + авторизация для работы с сервисом system/system");
//        openServiceByUrl(driver, sBP, "gamma", "405102182");

        openURLdashboard(getBaseUrl());

        AuthorizationBySetLoginPassword("iTest_User_0007", "iTest_User_0007");
        clickButton("Увійти");

        pause(6000);
        navigateToggleMenu();
//        clickLink(driver, sBP, "Завдання");
        clickLink("Очiкують мого ЕЦП ");
        clickLink("Нерозглянутi ");

        setRegionFindOrder("5454");
        pause(6000);
//        choiceMenuList("В роботі");
//        setRegionTask(driver, sBP);
//        pause(10000);
    }
}
