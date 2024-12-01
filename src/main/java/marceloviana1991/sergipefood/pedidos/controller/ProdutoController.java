package marceloviana1991.sergipefood.pedidos.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import marceloviana1991.sergipefood.pedidos.dto.ProdutoRequestDto;
import marceloviana1991.sergipefood.pedidos.dto.ProdutoResponseDto;
import marceloviana1991.sergipefood.pedidos.service.ProdutoServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoServie service;

    @PostMapping
    public ResponseEntity<ProdutoResponseDto> saveProduto(@RequestBody @Valid ProdutoRequestDto requestDto,
                                          UriComponentsBuilder uriComponentsBuilder) {
        ProdutoResponseDto responseDto = service.saveProduto(requestDto);
        URI uri = uriComponentsBuilder.path("/produtos/{id}").buildAndExpand(responseDto.id()).toUri();
        return ResponseEntity.created(uri).body(responseDto);
    }

    @GetMapping
    public List<ProdutoResponseDto> getPageProdutos(@PageableDefault(size = 10) Pageable pageable) {
        return service.getAllProdutos(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDto> getProduto(@PathVariable @NotNull Long id) {
        ProdutoResponseDto responseDto = service.getProduto(id);
        return ResponseEntity.ok(responseDto);
    }
}
