package oitobits.view;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Teste extends JFrame {
	public Teste() {
		super("Teste");
		Container container = this.getContentPane();
		container.setLayout(new FlowLayout());
		container.add(new CapturaFoto());
		this.setVisible(true);

	}
}

public class CapturaFoto extends JPanel {
	/**
	 * @TODO Paulo upgrade this code to java 1.8
	 * 
	 * 
	 *       public static Player player = null; public CaptureDeviceInfo di =
	 *       null; // @jve:decl-index=0: public MediaLocator ml = null; //
	 * 
	 * @jve:decl-index=0: public JButton capture = null; public Buffer buf =
	 *                    null; public Image img = null; public VideoFormat vf =
	 *                    null; public BufferToImage btoi = null; public
	 *                    ImagePanel imgpanel = null;
	 * 
	 *                    private static final long serialVersionUID = 1L;
	 *                    private JButton captura = null;
	 * 
	 *                    public CapturaFoto() { super(); initialize(); }
	 * 
	 *                    private void initialize() { this.setLayout(new
	 *                    BorderLayout()); this.setSize(327, 259);
	 *                    this.add(getCaptura(), BorderLayout.SOUTH);
	 *                    this.setVisible(true);
	 * 
	 *                    String str2 = "vfw//1"; di =
	 *                    CaptureDeviceManager.getDevice(str2); ml = new
	 *                    MediaLocator("vfw://0"); try { player =
	 *                    Manager.createRealizedPlayer(ml); player.start();
	 *                    Component comp; if ((comp =
	 *                    player.getVisualComponent()) != null) { add(comp,
	 *                    BorderLayout.NORTH); } add(captura,
	 *                    BorderLayout.SOUTH); } catch (Exception e) {
	 *                    e.printStackTrace(); }
	 * 
	 *                    }
	 * 
	 *                    public static void main(String[] args) { //
	 *                    CapturaFoto cp = new CapturaFoto(); Teste teste = new
	 *                    Teste(); }
	 * 
	 *                    public void gravaImg(Image imagem) { String caminho =
	 *                    "C:\\teste\\teste.JPG"; try {
	 *                    ImageIO.write((RenderedImage) imagem, "jpg", new
	 *                    File(caminho)); JOptionPane.showMessageDialog(this,
	 *                    "Imagem Capturada!"); } catch (IOException e) {
	 *                    JOptionPane.showMessageDialog(null,
	 *                    "não foi possivel encontrar " +
	 *                    "o dispositivo para a captura da imagem.");
	 *                    e.printStackTrace(); }
	 * 
	 *                    }
	 * 
	 *                    private JButton getCaptura() { if (captura == null) {
	 *                    captura = new JButton("Captura");
	 *                    captura.setBounds(50, 50, 50, 50);
	 *                    captura.addActionListener(new
	 *                    java.awt.event.ActionListener() { public void
	 *                    actionPerformed(java.awt.event.ActionEvent e) {
	 *                    FrameGrabbingControl fgc = (FrameGrabbingControl)
	 *                    player.getControl(
	 *                    "javax.media.control.FrameGrabbingControl"); buf =
	 *                    fgc.grabFrame(); btoi = new
	 *                    BufferToImage((VideoFormat) buf.getFormat()); img =
	 *                    btoi.createImage(buf); gravaImg(img); } }); } return
	 *                    captura; }
	 * 
	 *                    class ImagePanel extends Panel {
	 * 
	 *                    private static final long serialVersionUID = 1L;
	 *                    public Image myimg = null;
	 * 
	 *                    public ImagePanel() {
	 *                    JOptionPane.showMessageDialog(null,
	 *                    "setando a classe"); setLayout(null); setSize(320,
	 *                    240); }
	 * 
	 *                    public void setImage(Image img) { this.myimg = img;
	 *                    repaint(); }
	 * 
	 *                    public void paint(Graphics g) { if (myimg != null) {
	 *                    g.drawImage(myimg, 0, 0, this); } }
	 * 
	 *                    }
	 */

}