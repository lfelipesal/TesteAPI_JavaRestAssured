package PetStore.API.request;

import PetStore.API.body.BodyPetstore;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class PetStoreTestResquest {

    public static void setup() {
        baseURI = "https://petstore.swagger.io/v2";
    }

    public static long criandoPet(int ID, String nomePet, int IDpet,String tipoPet, int IDtag , String tagPet, String statusPet ) {
        return given()
                .body(BodyPetstore.novoPet(ID,nomePet,IDpet,tipoPet,IDtag,tagPet,statusPet))
                .contentType(ContentType.JSON)
                .post("/pet")
                .then()
                .extract()
                .path("id");
    }

    public static int pedidoPet(int ID, int IDpet, int quantidade , String statusPedido ){
        return given()
                .body(BodyPetstore.pedidoPet(ID,IDpet,quantidade , statusPedido))
                .contentType(ContentType.JSON)
                .post("/pet")
                .getStatusCode();
    }

    public static  int deletandoPet(long ID){
        return given()
                .when()
                .delete("/pet/"+ID)
                .getStatusCode();
    }

    public static int pesquisaIDPet(long ID){
        return given()
                .when()
                .get("/pet/"+ID)
                .getStatusCode();
    }

    public static int atualizaPet(int ID, String nomePet, int IDpet,String tipoPet, int IDtag , String tagPet, String statusPet){
        return given()
                .body(BodyPetstore.novoPet(
                        ID,
                        nomePet,
                        IDpet,
                        tipoPet,
                        IDtag,
                        tagPet,
                        statusPet
                ))
                .contentType(ContentType.JSON)
                .when().put("/pet")
                .getStatusCode();
    }
    public static int pesquisaStatusPet(String Status){
        return given()
                .when()
                .get("/pet/findByStatus?status="+Status)
                .getStatusCode();
    }

}
