# Demo UI automation testing

## **Tech stack**
![Java Logo](src/test/resources/img/stack_icons/Java.png) 
![Gradle Logo](src/test/resources/img/stack_icons/Gradle.png)
![JUnit5 Logo](src/test/resources/img/stack_icons/JUnit5.png)
![Selenide Logo](src/test/resources/img/stack_icons/Selenide.png)
![Selenoid Logo](src/test/resources/img/stack_icons/Selenoid.png)
![Docker Logo](src/test/resources/img/stack_icons/Docker.png)
![Allure Logo](src/test/resources/img/stack_icons/Allure.png)
![Jenkins Logo](src/test/resources/img/stack_icons/Jenkins.png)
![Github Logo](src/test/resources/img/stack_icons/Github.png)
![Telegram Logo](src/test/resources/img/stack_icons/Telegram.png)
- Java
- Gradle
- Junit5
- Selenide
- Selenoid
- Docker
- Allure Report
- Jenkins
- Telegram-notifications
## **Description**
Demo testing UI of specific site

- It built in Jenkins CI. The tests have been executed in Docker containers using Selenoid. 
- The report generated automatically by Allure framework. It contains scenarios of tests, logs, screenshots and video.
- The result of build send to telegram with Telegram-notifications 
application.
## Allure reports
### *Overview of suit*
![Allure](src/test/resources/img/tests/Allure-report_overview.png)
### *Details view*
![Allure](src/test/resources/img/tests/Allure-suites_example_view.png)
### *Video from specific test*
Test "Change language on main page"
![Video](src/test/resources/img/tests/Allure-report_video_example.gif)
## Telegram notification
### Telegram notifications
![Telegram](src/test/resources/img/tests/telegram_notification_screenshot.png)
## Links
[***Jenkins job***](https://jenkins.autotests.cloud/job/c5-jul112-11-job) 
[***Jenkins Allure report***](https://jenkins.autotests.cloud/job/c5-jul112-11-job/allure/) 
