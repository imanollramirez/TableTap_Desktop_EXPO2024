package Controlador;

import Modelo.tbUsuarios;
import Modelo.EnviarCorreo;
import Vista.frmCambiarContrasena;
import Vista.frmRecuperarContrasena;
import static Vista.frmRecuperarContrasena.initFrmRecuperarContrasena;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JOptionPane;

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
            Random random = new Random();
        
            // Genera un número aleatorio de 8 dígitos 
            codigo = 10000000 + random.nextInt(90000000);
            String receptor = VISTA.txtCorreoRecu.getText();
            String asunto = "Código de recuperación";
            int Code = codigo;
            
            EnviarCorreo.enviarCorreo(receptor, asunto, Code);
            JOptionPane.showMessageDialog(null, "Se envió el código de recuperación su correo.");    
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
