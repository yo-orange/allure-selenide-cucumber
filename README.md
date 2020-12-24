# allure-selenide-cucumber

## link
- [allure](https://docs.qameta.io/allure/)
- [selenide](https://selenide.org/documentation.html)
- [cucumber](https://docs.cucumber.io/)

## steps
- Given open "{url}"
- When "{pageName}":input
- Then "{pageName}":assert

## exec
- docker-compose build
- docker-compose up -d
- docker exec -it chrome /bin/bash
- docker run -v "%cd%:/app" --workdir=/app -it --rm chrome sh ./mvnw clean install -Pdocker,chrome
