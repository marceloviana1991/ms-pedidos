package marceloviana1991.sergipefood.pedidos.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import marceloviana1991.sergipefood.pedidos.dto.ProdutoRequestDto;
import marceloviana1991.sergipefood.pedidos.dto.ProdutoResponseDto;
import marceloviana1991.sergipefood.pedidos.model.Produto;
import marceloviana1991.sergipefood.pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServie {

    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public ProdutoResponseDto saveProduto(ProdutoRequestDto requestDto) {
        Produto produto = new Produto(requestDto);
        repository.save(produto);
        return new ProdutoResponseDto(produto);
    }

    public ProdutoResponseDto getProduto(Long id) {
        return new ProdutoResponseDto(repository.getReferenceById(id));
    }

    public List<ProdutoResponseDto> getAllProdutos(Pageable pageable) {
        return repository.findAll(pageable).stream().map(ProdutoResponseDto::new).toList();
    }

}
