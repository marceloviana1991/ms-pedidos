package marceloviana1991.sergipefood.pedidos.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import marceloviana1991.sergipefood.pedidos.dto.PagamentoRequestDto;
import marceloviana1991.sergipefood.pedidos.dto.PedidoRequestDto;
import marceloviana1991.sergipefood.pedidos.dto.PedidoResponseDto;
import marceloviana1991.sergipefood.pedidos.service.PedidoService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping
    public List<PedidoResponseDto> getPagePedidos(@PageableDefault(size = 10) Pageable pageable) {
        return service.getAllPedidos(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> getPedido(@PathVariable @NotNull Long id) {
        PedidoResponseDto responseDto = service.getPedido(id);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDto> savePedido(@RequestBody @Valid PedidoRequestDto requestDto,
                                                           UriComponentsBuilder uriComponentsBuilder) {
        PedidoResponseDto responseDto = service.savePedido(requestDto);
        URI uri = uriComponentsBuilder.path("/pedidos/{id}").buildAndExpand(responseDto.id()).toUri();
        PagamentoRequestDto pagamentoRequestDto = new PagamentoRequestDto(
                requestDto.valor(), requestDto.nome() ,responseDto.id());
        rabbitTemplate.convertAndSend("pedido.registrado", pagamentoRequestDto);
        return ResponseEntity.created(uri).body(responseDto);
    }

    @PutMapping("/{id}/pago")
    public void aprovaPagamento(@PathVariable Long id) {
        service.aprovaPagamento(id);
    }

    @GetMapping("/porta")
    public String retornaPorta(@Value("${local.server.port}") String porta){
        return String.format("Requisição respondida pela instância executando na porta %s", porta);
    }
}
