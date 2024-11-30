package marceloviana1991.sergipefood.pedidos.amqp;

import marceloviana1991.sergipefood.pedidos.dto.PedidoResponseDto;
import marceloviana1991.sergipefood.pedidos.service.PedidoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoListener {

    @Autowired
    private PedidoService service;

    @RabbitListener(queues = "pagamento.concluido")
    public void recebeMensagem(Long id) {
        PedidoResponseDto responseDto = service.aprovaPagamento(id);
        System.out.println(id);
    }
}
