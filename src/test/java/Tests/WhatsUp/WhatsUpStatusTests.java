package Tests.WhatsUp;

import Pages.BaseTest;
import Pages.whatsappPages.WhatsUpCallPage;
import Pages.whatsappPages.WhatsUpStatusPage;
import Pages.whatsappPages.WhatsUpWellcomPage;
import org.testng.annotations.BeforeClass;

public class WhatsUpStatusTests extends BaseTest {


    WhatsUpStatusPage statusPage;
    WhatsUpWellcomPage wellcomePage;
    WhatsUpCallPage callsPage;
    @BeforeClass
    public void setUpVlad()
    {
        wellcomePage= new WhatsUpWellcomPage(getDriver(), log);

    }










}
