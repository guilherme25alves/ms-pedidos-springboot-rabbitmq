package br.com.guilherme25alves.processamento.consumer;

import br.com.guilherme25alves.processamento.dto.PedidoDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProcessamentoConsumer {

    // Versão que recebe uma String simples como payload
//    @RabbitListener(queues = "${broker.queue.processamento.name}")
//    public void listenerProcessamentoQueue(@Payload String descricao) {
//        System.out.println("Processando mensagem: " + descricao);
//    }

    // Versão que recebe um objeto (classe) como payload
    @RabbitListener(queues = "${broker.queue.processamento.name}")
    public void listenerProcessamentoQueue(PedidoDTO pedidoDTO) {
        System.out.println("Processando mensagem: ");
        System.out.println("ID pedido recebido: " + pedidoDTO.getId());
        System.out.println("Descrição pedido recebido: " + pedidoDTO.getDescricao());
    }
}
