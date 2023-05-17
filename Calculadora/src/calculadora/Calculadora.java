package Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora implements ActionListener {

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
    }

    JFrame frame;
    JTextField txtResultado;

    // Array de botões 
    JButton[] btnNumeros = new JButton[12];
    JButton[] btnFuncoes = new JButton[11];

    JButton btnAdicionar, btnSubctrair, btnMultiplicar, btnDividir;
    JButton btnPonto, btnIgual, btnApagar, btnLimpar, btnMenos, btnFactorial, btnExponencial;
    JPanel panel;

    Font myFont = new Font("Arial", Font.PLAIN, 23);

    double num1 = 0, num2 = 0, result = 0;
    String operacao;

    Calculadora() {

        // Cria uma nova Janela 
        frame = new JFrame("Calculadora");
        // Fechar a janela ao clicar no botão de fechar
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Define o tamanho da janela(largura, altura)
        frame.setSize(420, 550);
        // Define o Layout como nulo
        frame.setLayout(null);
        // Centralizar a janela
        frame.setLocationRelativeTo(null);

        // Criar um campo de texto
        txtResultado = new JTextField();
        // Define a cor do fundo do campo de texto
        txtResultado.setBackground(Color.white);
        // Posiciona o campo de texto na janela(eixo x, eixo y, largura, altura)
        txtResultado.setBounds(50, 25, 300, 50);
        // Define a a fonte do campo de texto
        txtResultado.setFont(myFont);
        // Não permite editar o valor do campo de texto
        txtResultado.setEditable(false);

        // Criar os botões 
        btnAdicionar = new JButton("+");
        btnSubctrair = new JButton("-");
        btnMultiplicar = new JButton("*");
        btnDividir = new JButton("/");
        btnPonto = new JButton(".");
        btnIgual = new JButton("=");
        btnApagar = new JButton("Del");
        btnLimpar = new JButton("C");
        btnMenos = new JButton("+/-");
        btnFactorial = new JButton("Fact");
        btnExponencial = new JButton("Exp");

        btnFuncoes[2] = btnMultiplicar;
        btnFuncoes[3] = btnDividir;
        btnFuncoes[0] = btnAdicionar;
        btnFuncoes[1] = btnSubctrair;
        btnFuncoes[4] = btnPonto;
        btnFuncoes[5] = btnIgual;
        btnFuncoes[6] = btnApagar;
        btnFuncoes[7] = btnLimpar;
        btnFuncoes[8] = btnMenos;
        btnFuncoes[9] = btnFactorial;
        btnFuncoes[10] = btnExponencial;

        for (int i = 0; i < 11; i++) {
            // Adiciona o evento
            btnFuncoes[i].addActionListener(this);
            // Define a fonte dos botões
            btnFuncoes[i].setFont(myFont);
            // Tirar o foco ao clicar nos botões 
            btnFuncoes[i].setFocusable(false);
        }

        for (int i = 0; i < 12; i++) {
            btnNumeros[i] = new JButton(String.valueOf(i));
            // Adiciona o evento
            btnNumeros[i].addActionListener(this);
            // Define a fonte dos botões
            btnNumeros[i].setFont(myFont);
            // Tirar o foco ao clicar nos botões 
            btnNumeros[i].setFocusable(false);
        }

        // Posiciona os botões na janela (eixo x, eixo y, largura, altura)
        btnMenos.setBounds(50, 430, 100, 50);
        btnApagar.setBounds(150, 430, 100, 50);
        btnLimpar.setBounds(250, 430, 100, 50);

        // Criar o painel
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 360);
        // Define o Layout do painel (linha, coluna, espaçamento horizontal, espaçamento vertical)
        panel.setLayout(new GridLayout(7, 3, 5, 5));

        // Adiciona os botões ao painel
        panel.add(btnExponencial);
        panel.add(btnFactorial);

        panel.add(btnLimpar);
        panel.add(btnNumeros[7]);
        panel.add(btnNumeros[8]);
        panel.add(btnNumeros[9]);
        panel.add(btnNumeros[4]);
        panel.add(btnNumeros[5]);
        panel.add(btnNumeros[6]);
        panel.add(btnNumeros[1]);
        panel.add(btnNumeros[2]);
        panel.add(btnNumeros[3]);

        panel.add(btnMenos);
        panel.add(btnNumeros[0]);

        panel.add(btnPonto);
        panel.add(btnMultiplicar);
        panel.add(btnDividir);
        panel.add(btnApagar);
        panel.add(btnAdicionar);
        panel.add(btnSubctrair);

        panel.add(btnIgual);

        // Adiciona o painel à janela
        frame.add(panel);

        frame.add(txtResultado);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        try {
            for (int i = 0; i < 12; i++) {
                if (event.getSource() == btnNumeros[i]) {
                    txtResultado.setText(txtResultado.getText().concat(String.valueOf(i)));

                }
            }

            if (event.getSource() == btnPonto) {
                txtResultado.setText(txtResultado.getText().concat("."));
            }

            if (event.getSource() == btnAdicionar) {
                num1 = Double.parseDouble(txtResultado.getText());
                operacao = "+";
                txtResultado.setText("");
            }

            if (event.getSource() == btnSubctrair) {
                num1 = Double.parseDouble(txtResultado.getText());
                operacao = "-";
                txtResultado.setText("");
            }

            if (event.getSource() == btnMultiplicar) {
                num1 = Double.parseDouble(txtResultado.getText());
                operacao = "*";
                txtResultado.setText("");
            }

            if (event.getSource() == btnDividir) {
                num1 = Double.parseDouble(txtResultado.getText());
                operacao = "/";
                txtResultado.setText("");
            }

            if (event.getSource() == btnFactorial) {
                num1 = Double.parseDouble(txtResultado.getText());
                int factorial = 1;
                for (int i = 1; i <= num1; i++) {
                    factorial = factorial * i;
                }
                operacao = "fact";
                txtResultado.setText(String.valueOf(factorial));
            }

            if (event.getSource() == btnExponencial) {
                num1 = Double.parseDouble(txtResultado.getText());
                operacao = "exp";
                txtResultado.setText("");
            }

            if (event.getSource() == btnIgual) {
                num2 = Double.parseDouble(txtResultado.getText());
                switch (operacao) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;

                    case "exp":
                        result = Math.pow(num1, num2);
                        break;

                }

                txtResultado.setText(String.valueOf(result));
                num1 = result;

            }

            if (event.getSource() == btnLimpar) {
                txtResultado.setText("");
            }

            if (event.getSource() == btnApagar) {
                String string = txtResultado.getText();
                txtResultado.setText("");
                for (int i = 0; i < string.length() - 1; i++) {
                    txtResultado.setText(txtResultado.getText() + string.charAt(i));
                    // (0 < 4) ? -> " " + 1
                    // (1 < 4) ? -> 1 + 2
                    // (2 < 4) ? -> 12 + 3
                    // (3 < 4) ? -> 123 + 4
                    // (4 < 4) 

                }
            }

            if (event.getSource() == btnMenos) {
                double temp = Double.parseDouble(txtResultado.getText());
                temp *= -1;
                txtResultado.setText(String.valueOf(temp));
            }
        } catch (Exception e) {
        }

    }

}
