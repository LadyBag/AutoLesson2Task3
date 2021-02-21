package ru.netology.rest;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class PostmanEchoTest {
    @Test
    void shouldReturnBookCount() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body("{\"store\":{\"book\":[{\"author\":\"Nigel Rees\",\"category\":\"reference\",\"price\":8.95,\"title\":\"Sayings of the Century\"},{\"author\":\"Evelyn Waugh\",\"category\":\"fiction\",\"price\":12.99,\"title\":\"Sword of Honour\"},{\"author\":\"Herman Melville\",\"category\":\"fiction\",\"isbn\":\"0-553-21311-3\",\"price\":8.99,\"title\":\"Moby Dick\"},{\"author\":\"J. R. R. Tolkien\",\"category\":\"fiction\",\"isbn\":\"0-395-19395-8\",\"price\":22.99,\"title\":\"The Lord of the Rings\"}]}}") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data.store.book.size()", Matchers.equalTo(4))
        ;
    }
}
