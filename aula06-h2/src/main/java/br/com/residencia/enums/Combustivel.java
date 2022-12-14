package br.com.residencia.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.residencia.exception.EnumValidationException;

public enum Combustivel {
    ALCOOL(1, "ALCOOL"), GASOLINA(2, "GASOLINA"), DIESEL(3, "DIESEL"), FLEX(4, "FLEX");

    private Integer codigo;
    private String tipo;

    private Combustivel(Integer codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @JsonCreator
    public static Combustivel verifica(Integer valor) throws EnumValidationException {
        for (Combustivel combustivel: Combustivel.values()) {
            if(valor.equals(combustivel.getCodigo())) {
                return combustivel;
            }
        }
        throw new EnumValidationException("Preencha o combustível corretamente");
    }

}
