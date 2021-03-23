package com.goott.eco.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * api 사용법 테스트 클래스입니다
 */
public class SeleniumTest {
	public static void main(String[] args) {
		WebDriver driver = null;
		try {
			// drvier 설정 - 저는 d드라이브 work 폴더에 있습니다.
			System.setProperty("webdriver.chrome.driver", "C:\\dev\\lib\\chromedriver_win32\\chromedriver.exe");
			
			// Chrome 드라이버 인스턴스 설정
			driver = new ChromeDriver();
			
			// 스크립트를 사용하기 위한 캐스팅
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			// 블로그 URL로 접속
			driver.get("https://nowonbun.tistory.com");
			
			// 대기 설정
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			// xpath로 element를 찾는다. 이 xpath는 명월 일지 블로그의 왼쪽 메뉴의 Dev note의 Javascript, Jquery, Css 카테고리다.
			WebElement element = driver.findElement(By.xpath("//*[@id='leftside']/div[2]/ul/li/ul/li[1]/ul/li[6]/a"));
			
			// 클릭한다. 사실 element.click()로도 클릭이 가능한데 가끔 호환성 에러가 발생하는 경우가 있다.
			js.executeScript("arguments[0].click();", element);
			while (true) {
			try {
			
				// css selector로 element를 찾는다.
				element = driver.findElement(By.cssSelector("[href^='/626']"));
			
				// 클릭
				js.executeScript("arguments[0].click();", element);
				
				// 루프 정지
				break;
			
			} catch (Throwable e) {
				// 해당 element가 없으면 아래의 다음 페이지 element를 찾는다.
				element = driver.findElement(By.cssSelector(".paging li.active+li > a"));
				
				// 클릭
				js.executeScript("arguments[0].click();", element);
				}
			}
			
			// id가 promptEx인 데이터를 찾는다.
			element = driver.findElement(By.xpath("//*[@id='promptEx']"));
			
			// 버튼은 클릭이 되는데 link 계열은 script로 클릭해야 한다.
			element.click();
			
			// xpath로 팝업의 dom를 찾는다.
			element = driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/form/input"));
			
			// input text에 test의 값을 넣는다.
			element.sendKeys("test");
			
			// 5초 기다린다.
			Thread.sleep(5000);
			
			// xpath로 팝업의 dom를 찾는다.
			element = driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div/form/input"));
			
			// 속성 value를 출력한다.
			System.out.println(element.getAttribute("value"));
			
			// .article의 글에 p 태그의 속성을 전부 가져온다.
			List<WebElement> elements = driver.findElements(By.cssSelector(".article p"));
			for (WebElement ele : elements) {
				// 속성의 NodeText를 전부 출력한다.
				System.out.println(ele.getText());
			}
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}

		
	}
}
