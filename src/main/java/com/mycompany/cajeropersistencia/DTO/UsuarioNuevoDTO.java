package com.mycompany.cajeropersistencia.DTO;

/**
 *
 * @author TeLesheo
 */
public class UsuarioNuevoDTO {

    private String passcode_usuario;
    private String email;

    public UsuarioNuevoDTO() {
    }

    public UsuarioNuevoDTO(String passcode_usuario, String email) {
        this.passcode_usuario = passcode_usuario;
        this.email = email;
    }

    public String getPasscode_usuario() {
        return passcode_usuario;
    }

    public void setPasscode_usuario(String passcode_usuario) {
        this.passcode_usuario = passcode_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
