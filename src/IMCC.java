import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Double;

public class IMCC extends JFrame {
    private JTextField Txt_peso;
    private JTextField Txt_Altura;
    private JButton limparButton;
    private JButton calcularButton;
    private JPanel Pn_Class;
    private JPanel Pn_Ress;
    private JPanel Pn_Main;
    private JLabel Resultado;
    private JLabel Lbl_Class;

    public IMCC() {
        setContentPane(Pn_Main);
        setTitle("Calcular IMC");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300, 250);
        setVisible(true);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (Txt_peso.getText().isEmpty() || Txt_Altura.getText().isEmpty()){
                    Resultado.setText("Preencha todos os campos!");
                    return;
                }

                double peso = Double.parseDouble(Txt_peso.getText());
                double alturacm = Double.parseDouble(Txt_Altura.getText());
                double altura = alturacm / 100.0;

                double imc = peso / (altura * altura);

                Resultado.setText(String.format("%.2f", imc));

                String res = "";
                if (imc < 16) {
                    res = "Baixo peso grave!";
                } else if (imc >= 16 && imc <= 16.99) {
                    res = "Abaixo do peso!";
                } else if (imc >= 17 && imc <= 18.5) {
                    res = "Baixo peso leve!";
                } else if (imc >= 18.6 && imc <= 24.99) {
                    res = "Peso ideal!";
                } else if (imc >= 25 && imc <= 29.99) {
                    res = "Sobrepeso!";
                } else if (imc >= 30 && imc <= 34.99) {
                    res = "Obesidade I";
                } else if (imc >= 35 && imc <= 39.99) {
                    res = "Obesidade II";
                } else if (imc > 40) {
                    res = "Obesidade III";
                }

                Lbl_Class.setText(res);

                ;
                limparButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        Txt_peso.setText("");
                        Txt_Altura.setText("");
                        Lbl_Class.setText("");
                        Resultado.setText("");

                    }
                });
            }

            ;
        });
    }
    }