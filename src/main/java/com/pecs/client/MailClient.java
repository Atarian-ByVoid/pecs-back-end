package com.pecs.client;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.pecs.errors.ErrorException;
import com.pecs.representation.external.ErrorDTO;
import com.pecs.representation.external.email.CadastroUsuarioDTO;

import reactor.core.publisher.Mono;

@Service
@SuppressWarnings("null")
public class MailClient {

    String baseUrl;
    WebClient webClient;

    public MailClient() {

        this.baseUrl = new StringBuilder()
                .append("http://")
                .append("localhost")
                .append(":")
                .append("3000")
                .append("/email")
                .toString();

        this.webClient = WebClient.create(baseUrl);
    }

    public Mono<Void> sendEmailCadastroUsuario(CadastroUsuarioDTO cadastroUsuarioDTO) {
        return webClient
                .post()
                .uri("/sender/cadastro")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(cadastroUsuarioDTO))
                .retrieve()
                .onStatus(HttpStatusCode::isError, response -> response
                        .bodyToMono(ErrorDTO.class)
                        .map(ErrorException::new))
                .bodyToMono(Void.class);
    }

}
