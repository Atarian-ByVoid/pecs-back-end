package com.pecs.representation.external.email;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CadastroUsuarioDTO extends AbstractMailDTO {

    private String nomeUsuario;

}
