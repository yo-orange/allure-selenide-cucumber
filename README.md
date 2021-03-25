# allure-selenide-cucumber

## link
- [allure](https://docs.qameta.io/allure/)
- [selenide](https://selenide.org/documentation.html)
- [cucumber](https://docs.cucumber.io/)
- https://github.com/allure-framework/allure-java/commit/0492bf543b6d8e6c7ec7b8278210776e83e74ed0

## steps
- Given open "{url}"
- When "{pageName}":input
- Then "{pageName}":assert

## exec

### chrome
- docker-compose build
- docker-compose up -d
- docker exec -it chrome /bin/bash
- docker exec -it chrome sh ./mvnw clean install -Pdocker,chrome
- docker run -v "%cd%:/app" --workdir=/app -it --rm chrome sh ./mvnw clean install -Pdocker,chrome
- mvnw.cmd clean install -Dselenide.remote=http://localhost:4444 -Pchrome_standalone

### firefox
- docker exec -it firefox /bin/bash
- docker run -v "%cd%:/app" --workdir=/app -it --rm chrome sh ./mvnw clean install -Pdocker,firefox

### edge
- docker exec -it edge /bin/bash
- ./mvnw clean install -Pdocker,edge
