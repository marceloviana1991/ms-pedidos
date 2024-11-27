package marceloviana1991.sergipefood.pedidos.http;

import marceloviana1991.sergipefood.pedidos.dto.PagamentoRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("pagamentos-ms")
public interface PagamentoClient {

    @RequestMapping(method = RequestMethod.POST, value = "/pagamentos", consumes = "application/json")
    void savePagamento(PagamentoRequestDto requestDto);
}
