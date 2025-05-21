package com.marcos.gestionTareas.dto.req;

public class TareaRequestDto {

    private Long id;
    private String title;
    private String estado;
    private Long estadoId;
    private Long usuarioId;

    public TareaRequestDto() {
    }

    public TareaRequestDto(Long id, String title, String estado, Long estadoId, Long usuarioId) {
        this.id = id;
        this.title = title;
        this.estado = estado;
        this.estadoId = estadoId;
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
