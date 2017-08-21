/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binomionewton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.util.Scanner;

/**
 *
 * @author AlmaGómez
 */
public class Binomio extends JFrame{
    JTextField pantalla;
    JTextField pantalla2;
    JTextField pantalla3;
    JPanel panelOperaciones;
    String operacion;
    int num1;
    int num2;
    String resultado;
    boolean nuevaOperacion = true;
    public Binomio() {
		super();
		setSize(350, 150);
		setTitle("Calculadora de Binomios");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		//Crea el panel
		JPanel panel = (JPanel) this.getContentPane();
		panel.setLayout(new BorderLayout());
                
                
		pantalla = new JTextField("Coeficiente x", 20);
		pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
		pantalla.setFont(new Font("Arial", Font.BOLD, 25));
		pantalla.setHorizontalAlignment(JTextField.RIGHT);
		pantalla.setEditable(true);
		pantalla.setBackground(Color.WHITE);
		panel.add("North", pantalla);
                
                pantalla2 = new JTextField("Coeficiente y", 20);
		pantalla2.setBorder(new EmptyBorder(4, 4, 4, 4));
		pantalla2.setFont(new Font("Arial", Font.BOLD, 25));
		pantalla2.setHorizontalAlignment(JTextField.RIGHT);
		pantalla2.setEditable(true);
		pantalla2.setBackground(Color.WHITE);
		panel.add("Center",pantalla2);
                
                pantalla3 = new JTextField("0", 20);
		pantalla3.setBorder(new EmptyBorder(4, 4, 4, 4));
		pantalla3.setFont(new Font("Arial", Font.BOLD, 25));
		pantalla3.setHorizontalAlignment(JTextField.RIGHT);
		pantalla3.setEditable(false);
		pantalla3.setBackground(Color.WHITE);
		panel.add("South", pantalla3);
                
		
                
                //inserta botones de operaciones
                
		panelOperaciones = new JPanel();
		panelOperaciones.setLayout(new GridLayout(0, 2));
		panelOperaciones.setBorder(new EmptyBorder(4, 4, 4, 4));

		nuevoBotonOperacion("Calcular");
                nuevoBotonOperacion("CE");

		panel.add("East", panelOperaciones);

		validate();
	}
//define las caracteristicas de los botones
    private void nuevoBotonOperacion(String operacion) {
		JButton btn = new JButton(operacion);
		btn.setForeground(Color.RED);

		btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evt) {
				JButton btn = (JButton) evt.getSource();
				operacionPulsado(btn.getText());
			}
		});

		panelOperaciones.add(btn);
	}
    //Pone en pantalla los numeros que sean pulsados
    private void numeroPulsado(String digito) {
		if (pantalla.getText().equals("0") || nuevaOperacion) {
			pantalla.setText(digito);
		} else {
			pantalla.setText(pantalla.getText() + digito);
		}
		nuevaOperacion = false;
	}

	//Selecciona que hacer en base a los numero tecleados
	private void operacionPulsado(String tecla) {
		if (tecla.equals("Calcular")) {
			calcularResultado();
		} else if (tecla.equals("CE")) {
			num1 = 0;
                        num2=0;
			pantalla.setText("");
                        pantalla2.setText("");
			nuevaOperacion = true;
		} else {
			operacion = tecla;
			if ((num1 > 0 && num2>0) && !nuevaOperacion) {
				calcularResultado();
			} else {
				num1 = new Integer(pantalla.getText());
                                num2 = new Integer(pantalla2.getText());

			}
		}

		nuevaOperacion = true;
	}
    public void calcularResultado(){
        
        Scanner Leer = new Scanner(System.in);
        num1=Integer.parseInt(pantalla.getText());
        
        num2=Integer.parseInt(pantalla2.getText());
        //Eleva al cuadrado el primer numero, publica la multiplicación de ambos y eleva el segundo numero
        resultado=Math.round(Math.pow(num1,2))+"x^2+"+2*num1*num2+"xy"+"+"+Math.round(Math.pow(num2,2))+"y^2";
        pantalla3.setText(resultado);
    }
}

