package com.ipartek.ejemplos.alvaromartinez;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EjemploEscritorio {

	public static void main(String[] args) {
		final JTextField jtf;
		final JButton jb;
		final JLabel jl;

		JFrame jf = new JFrame("Prueba");

		JPanel p = new JPanel();

		jf.add(p);

		p.add(jtf = new JTextField(10));
		p.add(jb = new JButton("Saludar"));
		p.add(jl = new JLabel("Resultado"));

		// jf.pack();
		jf.setSize(300, 300);

		jf.setVisible(true);

		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				jl.setText("Hola " + jtf.getText());
			}
		});

		// jb.addActionListener(new EventoBoton(jl, jtf));
	}

}

// class EventoBoton implements ActionListener {
//
// private JLabel label;
// private JTextField cuadroTexto;
//
// public EventoBoton(JLabel label, JTextField cuadroTexto) {
// this.label = label;
// this.cuadroTexto = cuadroTexto;
// }
//
// @Override
// public void actionPerformed(ActionEvent ae) {
// label.setText("HOLA" + cuadroTexto.getText());
//
// }
// }