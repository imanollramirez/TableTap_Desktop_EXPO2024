package Controlador;

import Vista.frmMenu;
import Vista.pnlRegistrarClientes;
import Controlador.ctrlClientesRegistrados;
import Controlador.ctrlReservacionMesas;
import Vista.pnlPerfil;
import Modelo.tbClientes;
import Modelo.tbMesas;
import Modelo.tbEmpleados;
import Vista.pnlClientesRegistrados;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ctrlMenu implements MouseListener{

    private frmMenu VISTA;
    private tbEmpleados INFO;
    public ctrlMenu (frmMenu vista, tbEmpleados info)
    {
        this.VISTA = vista;
        this.INFO = info;
      
        vista.btnMenuInicio.addMouseListener(this);
        vista.btnAgregarCliente.addMouseListener(this);
        vista.btnMesasOcupadas.addMouseListener(this);
        vista.btnPerfil.addMouseListener(this);
        vista.btnLogOut.addMouseListener(this);    
    }
    
    //Función para cambiar el color de los botones, según el que se seleccione.
    public void BotonSeleccionado(MouseEvent btn)
    {
        if(btn.getSource() == VISTA.btnMenuInicio)
        {
        VISTA.btnMenuInicio.setEnabled(false);
        VISTA.btnAgregarCliente.setEnabled(true);
        VISTA.btnMesasOcupadas.setEnabled(true);
        VISTA.btnPerfil.setEnabled(true);   
        }
        if(btn.getSource() == VISTA.btnAgregarCliente)
        {
        VISTA.btnMenuInicio.setEnabled(true);
        VISTA.btnAgregarCliente.setEnabled(false);
        VISTA.btnMesasOcupadas.setEnabled(true);
        VISTA.btnPerfil.setEnabled(true);   
        }
        if(btn.getSource() == VISTA.btnMesasOcupadas)
        {
        VISTA.btnMenuInicio.setEnabled(true);
        VISTA.btnAgregarCliente.setEnabled(true);
        VISTA.btnMesasOcupadas.setEnabled(false);
        VISTA.btnPerfil.setEnabled(true);   
        }
        if(btn.getSource() == VISTA.btnPerfil)
        {
        VISTA.btnMenuInicio.setEnabled(true);
        VISTA.btnAgregarCliente.setEnabled(true);
        VISTA.btnMesasOcupadas.setEnabled(true);
        VISTA.btnPerfil.setEnabled(false);   
        }
    }
    
    //Tuve que buscar como hacerlo porque acá creo que no está disponible el Glide, pero basicamente
    //esto lo que hace es que crea una nueva imagen, la cual tiene origen de la URL que está en la base de datos,
    //la cual es del empleado en sesión.
    public Image cargarImagen(String ImgUrl) {
    try {
        URL url = new URL(ImgUrl);
        BufferedImage img = ImageIO.read(url);
        return img;
    } catch (IOException ex) {
        ex.printStackTrace();
        return null;
    }
    
    }
    
    //Luego, cuando la URL ya se convierte en una Imagen, solo la asignamos al Jlabel, en este caso acá en JAVA.
    //Recibe 2 parámetros, el del JLabel y la URL, simplemente crea un icono y se lo asigna al JLlabel.
    public void AsignarImagen(JLabel imgFoto, String url) {
    Image img = cargarImagen(url);
    Image imgAjustada = img.getScaledInstance(360,390,Image.SCALE_SMOOTH);
    if (img != null) {
        ImageIcon icon = new ImageIcon(imgAjustada);
        imgFoto.setIcon(icon);
    } else {
    }
}
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == VISTA.btnMenuInicio)
        {
            BotonSeleccionado(e);
            VISTA.btnMenuInicio.enable(false);
            VISTA.pnlMainContainer.setVisible(false);
        }
        if(e.getSource() == VISTA.btnAgregarCliente)
        {
            BotonSeleccionado(e);
            pnlRegistrarClientes cl = new pnlRegistrarClientes();
            frmMenu menu = new frmMenu();
            tbMesas mesas = new tbMesas();
            ctrlReservacionMesas ctrlReservar = new ctrlReservacionMesas(cl,mesas,menu);
            mesas.EstadoMesa(cl);
            
            VISTA.pnlMainContainer.removeAll();
            VISTA.pnlMainContainer.add(cl);
            VISTA.pnlMainContainer.revalidate();
            VISTA.pnlMainContainer.repaint();
            VISTA.pnlMainContainer.setVisible(true);
        }
        if(e.getSource() == VISTA.btnMesasOcupadas)
        {
            BotonSeleccionado(e);
            
            tbClientes Clientes = new tbClientes();
            pnlClientesRegistrados pnlClRegistrados = new pnlClientesRegistrados();
            tbMesas Mesas = new tbMesas();
            ctrlClientesRegistrados ctrl = new ctrlClientesRegistrados(Mesas,Clientes,pnlClRegistrados);
            
            VISTA.pnlMainContainer.removeAll();
            VISTA.pnlMainContainer.add(pnlClRegistrados);
            VISTA.pnlMainContainer.revalidate();
            VISTA.pnlMainContainer.repaint();
            VISTA.pnlMainContainer.setVisible(true);
            
        }
        if(e.getSource() == VISTA.btnPerfil)
        {
            BotonSeleccionado(e);            
            pnlPerfil perfil = new pnlPerfil();
            perfil.txtCorreoPerfil.setText(INFO.Correo);
            perfil.txtDUIperfil.setText(INFO.DUI);
            perfil.txtTelefonoPerfil.setText(INFO.Telefono);
            perfil.lblNombreEmpleado.setText(INFO.Nombre);
            perfil.lblApellidosEmpleado.setText(INFO.Apellidos);
            perfil.lblCargoEmpleado.setText(INFO.Cargo);
            String imageUrl = INFO.Foto;
            AsignarImagen(perfil.imgFotoPerfil, imageUrl);

            
            VISTA.pnlMainContainer.removeAll();
            VISTA.pnlMainContainer.add(perfil);
            VISTA.pnlMainContainer.revalidate();
            VISTA.pnlMainContainer.repaint();
            VISTA.pnlMainContainer.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {    }

    @Override
    public void mouseReleased(MouseEvent e) {    }

    @Override
    public void mouseEntered(MouseEvent e) {    }

    @Override
    public void mouseExited(MouseEvent e) {    }
    
}
