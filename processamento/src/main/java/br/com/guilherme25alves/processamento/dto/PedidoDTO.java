package br.com.guilherme25alves.processamento.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// se quisermos ignorar os itens e trabalhar apenas com id e descrição, usar annotation abaixo:
@JsonIgnoreProperties(ignoreUnknown = true)
public class PedidoDTO {

    private Long id;
    private String descricao;

    // se quisermos trabalhar normalmente com itens, declarar a lista e montar um DTO para o item
    // private List<ItemDTO> itens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

