package Controlador;

import Modelo.tbUsuarios;
import Modelo.EnviarCorreo;
import Vista.frmVerificarCodRecuperacion;
import Vista.frmRecuperarContrasena;
import Controlador.ctrlVerificarCodigo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JOptionPane;

/*
Este controlador, pide al usuario ingresar su correo eletrónico, para enviar el COD
de recu y asi poder seguir con el proceso común de Recu de Contra.
*/

public class ctrlRecuperacionContrasena implements MouseListener{

    public int codigo;
    
    private frmRecuperarContrasena VISTA;
    private tbUsuarios MODELO;
    
    public ctrlRecuperacionContrasena(frmRecuperarContrasena vista, tbUsuarios modelo)
    {
        this.VISTA = vista;
        this.MODELO = modelo;
        
        vista.btnEnviarCod.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == VISTA.btnEnviarCod)
        {
            if(VISTA.txtCorreoRecu.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Escriba su correo eletrónico.");    
            }
            else
            {    
            Random random = new Random();
        
            // Genera un número aleatorio de 8 dígitos 
            codigo = 100000 + random.nextInt(900000);
            String receptor = VISTA.txtCorreoRecu.getText();
            String asunto = "Código de recuperación";
            int Code = codigo;
            
            EnviarCorreo.enviarCorreo(receptor, asunto, Code);
            JOptionPane.showMessageDialog(null, "Se envió el código de recuperación su correo.");    
            frmVerificarCodRecuperacion frm = new frmVerificarCodRecuperacion();
            ctrlVerificarCodigo ctrl = new ctrlVerificarCodigo(frm,codigo);
            frm.setVisible(true);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
