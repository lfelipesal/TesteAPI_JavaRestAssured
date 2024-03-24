package PetStore.API.body;

public class BodyPetstore {

    public static String novoPet(int ID, String nomePet, int IDpet,String tipoPet, int IDtag , String tagPet, String statusPet ){
        return "{\n" +
                "  \"id\": \"" + ID + "\",\n"+
                "  \"category\": {\n" +
                "    \"id\": " + IDpet + ",\n" +
                "    \"name\": \""+nomePet+"\"\n" +
                "  },\n" +
                "  \"name\": \""+tipoPet+"\",\n" +
                "  \"photoUrls\": [\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": " + IDtag + ",\n" +
                "      \"name\": \"" + tagPet + "\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"" + statusPet + "\"\n" +
                "}";
    }
    public static String pedidoPet(int ID, int IDpet, int quantidade , String statusPedido ){
        return "{\n" +
                "  \"id\": \"" + ID + "\",\n"+
                "  \"petId\": \"" + IDpet + "\",\n"+
                "  \"quantity\": \"" + quantidade + "\",\n"+
                "  \"status\": \"" + statusPedido + "\",\n"+
                "  \"complete\": " + true + "\n"+
                "}";
    }
}

