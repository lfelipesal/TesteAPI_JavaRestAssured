package casos.test;

import io.restassured.http.ContentType;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class petstoreTest {
    public static int id;

    @Test
    //Caso de teste para criação de um novo pedido de pet
    public void Test_de_novo_Pedido(){
        //Configurando o caminho pra API
        baseURI = "https://petstore.swagger.io/v2";

        given()
                //Criando o corpo do novo pedido
                .body("{\n" +
                        "\"id\": \"4444\",\n"+
                        "\"petId\": \"333\",\n" +
                        "\"quantity\": \"2222\",\n" +
                        "\"shipDate\": \"2022-10-28T02:01:42.740Z\",\n" +
                        "\"status\": \"placed\",\n" +
                        "\"complete\": \"true\"\n" +
                        "}")
                    .contentType(ContentType.JSON)
            .when()
                    .post("/store/order")
            .then()
                //Validando requisição
                    .assertThat()
                        .statusCode(200);
    }

    @Test
    //Testando caso de pet inexistente
    public void Test_de_pet_Inexistente(){

        baseURI = "https://petstore.swagger.io/v2";
        //Criando um pet para poder excluir
        id = given()
                .body( "{\n" +
                        "  \"id\": 5852,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 563,\n" +
                        "    \"name\": \"dogLuiz\"\n" +
                        "  },\n" +
                        "  \"name\": \"pitbull\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"semfoto\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 52,\n" +
                        "      \"name\": \"semTag\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}" )
                .contentType(ContentType.JSON)
                .when()
                .post("/pet")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("id");

        //Excluindo o pet que criei
        given()
                .when().delete("/pet/"+id)
                .then()
                .assertThat()
                .statusCode(200);
        //Verificando se retorna pet inexistente
        given()
                .when()
                .get("/pet/"+id)
                .then()
                .assertThat()
                .statusCode(404);

    }

    @Test
    //Atualizando dados de um pet existente
    public void Teste_de_atualiza_Pet(){
        baseURI = "https://petstore.swagger.io/v2";

        //Criando um Pet para poder atualizar
        given()
                .body( "{\n" +
                        "  \"id\": 582,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 563,\n" +
                        "    \"name\": \"dogLuiz\"\n" +
                        "  },\n" +
                        "  \"name\": \"pitbull\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"semfoto\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 52,\n" +
                        "      \"name\": \"semTag\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}" )
                .contentType(ContentType.JSON)
                .when()
                .post("/pet")
                .then()
                .assertThat()
                .statusCode(200);

        //Validando atualização do pet, atualizei o status do pet
        given()
                .body("{\n" +
                        "  \"id\": 582,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 563,\n" +
                        "    \"name\": \"dogLuiz\"\n" +
                        "  },\n" +
                        "  \"name\": \"pitbull\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"semfoto\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 52,\n" +
                        "      \"name\": \"semTag\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"pending\"\n" +
                        "}")
                .contentType(ContentType.JSON)
                .when().put("/pet")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    //Pesquisando o status do Pet
    public void Teste_de_Busca_pet_por_status(){
        baseURI = "https://petstore.swagger.io/v2";
        //Passado o status que quero procurar
        String status = "pending";

        //Fazendo a validação da pesquisa de status
        given()
                .when()
                .get("/pet/findByStatus?status="+status)
                .then().assertThat().statusCode(200);

    }

}
