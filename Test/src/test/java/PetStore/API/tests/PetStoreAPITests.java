package PetStore.API.tests;


import PetStore.API.request.PetStoreTestResquest;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PetStoreAPITests {

    @BeforeClass
    public static void setUp() {
        PetStoreTestResquest.setup();
    }
    @Test
    //Caso de teste para criação de um novo pedido de pet
    public void Test_novo_Pedido(){
        assertEquals(
                200,
                PetStoreTestResquest.pedidoPet(
                        0,
                        12,
                        1,
                        "placed"
                )
        );
    }

    @Test
    //Testando caso de pet inexistente
    public void Test_pet_Inexistente(){
        //Criando um pet para poder excluir
        long id = PetStoreTestResquest.criandoPet(
                0,
                "PetTeste",
                1,
                "Pitbull",
                0,
                "",
                "available"
        );

        //Excluindo o pet que criei
        assertEquals(
                200,
                PetStoreTestResquest.deletandoPet(id)
        );
        //Verificando se retorna pet inexistente
        assertEquals(
                404,
                PetStoreTestResquest.pesquisaIDPet(id)
        );

    }

    @Test
    //Atualizando dados de um pet existente
    public void Test_atualiza_Pet(){

        //Criando um Pet para poder atualizar
        PetStoreTestResquest.criandoPet(
                0,
                "PetTeste",
                1,
                "Pitbull",
                0,
                "",
                "available"
        );

        //Validando atualização do pet, atualizei o status do pet
        String NewStatus = "pending";

        assertEquals(200,
                PetStoreTestResquest.atualizaPet(
                        0,
                        "PetTeste",
                        1,
                        "Pitbull",
                        0,
                        "",
                        NewStatus)
        );
    }

    @Test
    //Pesquisando o status do Pet
    public void Test_Busca_pet_por_status(){
        //Passado o status que quero procurar
        String status = "pending";

        //Fazendo a validação da pesquisa de status
        assertEquals(
                200,
                PetStoreTestResquest.pesquisaStatusPet(status)
        );
    }
}
