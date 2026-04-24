package br.com.christianfelps.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

/*
 Classe utilitária responsável por converter objetos entre diferentes tipos.

 Exemplo comum em APIs:
 Entity -> DTO
 DTO -> Entity

 A biblioteca Dozer faz o mapeamento automático entre campos
 que possuem o mesmo nome.
*/
public class ObjectMapper {

    // Instância única do mapper do Dozer
    // static evita criar várias instâncias na aplicação
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    /*
     Converte um único objeto para outro tipo.

     O = tipo de origem
     D = tipo de destino

     Exemplo:
     PersonDTO dto = ObjectMapper.parseObject(personEntity, PersonDTO.class);
    */
    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    /*
     Converte uma lista de objetos para outro tipo.

     Exemplo:
     List<PersonDTO> dtos = ObjectMapper.parseListObjects(persons, PersonDTO.class);

     Fluxo:
     List<Entity> -> List<DTO>
    */
    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {

        // Lista que receberá os objetos convertidos
        List<D> destinationObjects = new ArrayList<D>();

        // Percorre cada objeto da lista de origem
        for (Object o : origin) {

            // Converte o objeto e adiciona na lista destino
            destinationObjects.add(mapper.map(o, destination));
        }

        // Retorna a lista convertida
        return destinationObjects;
    }
}
