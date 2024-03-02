package com.pecs.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Enum {

    @AllArgsConstructor
    public enum TipoClinica {
        POSTO_DE_SAUDE("Posto de Saúde"),
        CENTRO_SAUDE("Centro de Saúde/Unidade Básica de Saúde"),
        POLICLINICA("Policlínica"),
        HOSPITAL_GERAL("Hospital Geral"),
        HOSPITAL_ESPECIALIZADO("Hospital Especializado"),
        UNIDADE_MISTA("Unidade Mista"),
        PRONTO_SOCORRO_GERAL("Pronto Socorro Geral"),
        PRONTO_SOCORRO_ESPECIALIZADO("Pronto Socorro Especializado"),
        CONSULTORIO_ISOLADO("Consultório Isolado"),
        UNIDADE_MOVEL_FLUVIAL("Unidade Móvel Fluvial"),
        CLINICA_ESPECIALIZADA("Clínica Especializada/Amb. Especializado"),
        UNIDADE_APOIO_DIAGNOSE_TERAPIA("Unidade de Serviço de Apoio de Diagnose e Terapia"),
        UNIDADE_MOVEL_TERRESTRE("Unidade Móvel Terrestre"),
        UNIDADE_MOVEL_PRE_HOSPITALAR("Unidade Móvel de Nível Pré-hospitalar na Área de Urgência e Emergência"),
        FARMACIA("Farmácia"),
        UNIDADE_VIGILANCIA_SAUDE("Unidade de Vigilância em Saúde"),
        COOPERATIVA("Cooperativa"),
        CENTRO_PARTO_NORMAL("Centro de Parto Normal Isolado"),
        HOSPITAL_DIA("Hospital /Dia- Isolado"),
        CENTRAL_REGULACAO_SERVICOS_SAUDE("Central de Regulação de Serviços de Saúde"),
        LABORATORIO_SAUDE_PUBLICA("Laboratório Central de Saúde Pública - LACEN"),
        SECRETARIA_SAUDE("Secretaria de Saúde");

        public String texto;
    }

    public enum TipoTelefone {
        CELULAR("Celular"),
        COMERCIAL("Comercial"),
        RESIDENCIAL("Residencial");

        public String texto;

        TipoTelefone(String tipoTelefone) {
            texto = tipoTelefone;
        }
    }

    public enum Genero {
        MASCULINO("Masculino"),
        FEMININO("Feminino"),
        OUTRO("Outro"),
        NAO_INFORMAR("Não Informar");

        public String texto;

        Genero(String genero) {
            texto = genero;
        }
    }

    public enum EstadoCivil {
        SOLTEIRO("Solteiro"),
        CASADO("Casado"),
        VIUVO("Viúvo"),
        SEPARADO_JUDICIALMENTE("Separado Judicialmente"),
        DIVORCIADO("Divorciado");

        public String texto;

        EstadoCivil(String estadoCivil) {
            texto = estadoCivil;
        }
    }

    public enum Especialidade {
        CARDIOLOGIA("Cardiologia"),
        DERMATOLOGIA("Dermatologia"),
        GASTROENTEROLOGIA("Gastroenterologia"),
        GINECOLOGIA("Ginecologia"),
        NEUROLOGIA("Neurologia"),
        OFTALMOLOGIA("Oftalmologia"),
        ORTOPEDIA("Ortopedia"),
        PEDIATRIA("Pediatria"),
        PSIQUIATRIA("Psiquiatria"),
        UROLOGIA("Urologia");

        private String descricao;

        Especialidade(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public enum AreaAtuacao {
        CLINICA("Clínica"),
        EDUCACIONAL("Educacional"),
        ORGANIZACIONAL("Organizacional"),
        SOCIAL("Social"),
        ESPORTIVA("Esportiva"),
        SAUDE_PUBLICA("Saúde Pública"),
        FORENSE("Forense");

        private String descricao;

        AreaAtuacao(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public enum TipoAtividade {
        CONSULTA("Consulta"),
        EXAME("Exame"),
        MEDICACAO("Medicação"),
        TERAPIA("Terapia"),
        OUTRO("Outro");

        private String descricao;

        TipoAtividade(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

}
