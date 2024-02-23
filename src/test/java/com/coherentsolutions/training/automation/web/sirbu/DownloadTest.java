package com.coherentsolutions.training.automation.web.sirbu;

import com.coherentsolutions.training.automation.web.sirbu.pageobjects.DownloadPage;
import com.coherentsolutions.training.automation.web.sirbu.utilities.ConfigReader;
import com.coherentsolutions.training.automation.web.sirbu.utilities.FileDownloadHelper;
import com.coherentsolutions.training.automation.web.sirbu.utilities.WaitUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class DownloadTest extends BaseTest {

    private DownloadPage downloadPage;

    ConfigReader configReader = ConfigReader.getInstance("config.properties");

    @BeforeMethod
    @Parameters({"platform", "browserName", "browserVersion"})
    @Override
    public void setUp(@Optional String platform, @Optional String browserName, @Optional String browserVersion) throws MalformedURLException {
        super.setUp(platform, browserName, browserVersion);
        downloadPage = new DownloadPage(driver);
    }

    @Test
    public void testDownload() throws InterruptedException{
        Assert.assertTrue(downloadPage.isOpened(), "Download page is not opened");
        String downloadPath = configReader.getProperty("download.path");
        File dir = new File(downloadPath);
        for(File file: dir.listFiles()) {
            if (!file.isDirectory()) {
                file.delete();
            }
        }
        downloadPage.downloadFile();
        WaitUtils.staticWait(5000);
        String fileName = "demo.txt";
        Assert.assertTrue(FileDownloadHelper.isFileDownloaded(downloadPath, fileName), "File was not downloaded");

    }

    @Test
    public void ableToDownloadFileTest() throws Exception {

        String link = downloadPage.getDownloadFileHref();

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpHead request = new HttpHead(link);
        HttpResponse response = httpClient.execute(request);
        String contentType = response.getFirstHeader("Content-Type").getValue();

        int contentLength = Integer.parseInt(response.getFirstHeader("Content-Length").getValue());

        assertThat(contentType, is("application/octet-stream"));
        assertThat(contentLength, is(not(0)));
    }
    @AfterMethod
    public void tearDown(){driver.quit();}

}
