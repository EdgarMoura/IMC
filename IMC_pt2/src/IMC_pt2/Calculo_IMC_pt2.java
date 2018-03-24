package IMC_pt2;

import java.text.DecimalFormat;
import javax.swing.*; // classe JOptionPane

/**
 *
 * @author Edgar Moura
 */
public class Calculo_IMC_pt2 {

    public static boolean matchesOnlyNumber(String text) {
        return text.matches("[a-zA-Z]+"); //Passa para o método matches a regex
        //Se tiver número na string irá retornar falso
        //Note o uso de duas \\, uma sendo obrigatória para servir de caracter de escape
    }

    public static void main(String args[]) {
        String entrada;
        double peso, altura, IMC;
        double h_imc[] = {20.7, 26.4, 32, 3};
        double m_imc[] = {19.1, 25.8, 31.1};

        JOptionPane.showMessageDialog(null, "Bem vindo ao programa para Calcúlo de IMC! \n (Versão 1.2) \n\n");

        String[] sexo = {"Masculino", "Feminino"};
        int nome_sexo = JOptionPane.showOptionDialog(null, "Escoha o seu sexo", "Click no Botão", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, sexo, null);

        if (nome_sexo == 0) {
            JOptionPane.showMessageDialog(null, "O seu sexo é: masculino!");
        }
        if (nome_sexo == 1) {
            JOptionPane.showMessageDialog(null, "O seu sexo é: feminino!");
        }

        do {
            entrada = JOptionPane.showInputDialog(null, "\n\n Qual é o seu peso [Exemplo: 60.5]?\n");

            if (matchesOnlyNumber(entrada)) {
                JOptionPane.showMessageDialog(null, "Você não pode inserir letras.");
            }

            for (int i = 0; i < entrada.length() - 1; i++) {
                if (entrada.charAt(i) == ',') {
                    entrada = entrada.replaceAll(",", ".");
                }
            }
            peso = Double.parseDouble(entrada); // salva na váriavel peso.

            if (peso < 1 || peso > 399) {
                JOptionPane.showMessageDialog(null, "Digite peso maior que 1 ou peso menor que 399");
            }

        } while (peso < 1 || peso > 399); //Se o usuario digitar numero menor que 1 ou maior 399

        do {

            entrada = JOptionPane.showInputDialog(null, "\n\n Qual é a sua altura [Exemplo: 1.70]?\n");

            if (matchesOnlyNumber(entrada)) {
                JOptionPane.showMessageDialog(null, "Você não pode inserir letras.");
            }

            for (int i = 0; i < entrada.length() - 1; i++) {
                if (entrada.charAt(i) == ',') {
                    entrada = entrada.replaceAll(",", ".");
                }
            }
            altura = Double.parseDouble(entrada); // salva na váriavel altura.

            if (altura < 1 || altura > 2.99) {
                JOptionPane.showMessageDialog(null, "Digite uma altura maior que 1 ou altura menor que 2,99");
            }
        } while (altura < 1 || altura > 2.99); //Se o usuario digitar numero menor que 1 ou maior 2.99

        IMC = peso / ((altura) * (altura)); // calcula o valor do IMC
        DecimalFormat df = new DecimalFormat("0.##");
        String df_imc = df.format(IMC);
        switch (nome_sexo) {
            case 0:

                if (IMC < h_imc[0]) {
                    JOptionPane.showMessageDialog(null, "\n- Masculino -->Abaixo do peso: \nVocê está abaixo do peso! " + df_imc);

                } else if (IMC < h_imc[1]) {
                    JOptionPane.showMessageDialog(null, "\n- Masculino -->No peso normal: \nVocê está com peso ideal! " + df_imc);

                } else if (IMC < h_imc[2]) {
                    JOptionPane.showMessageDialog(null, "\n- Masculino -->Acima do peso: \nVocê está acima do peso recomendado. \nCuidado! " + df_imc);
                } else {
                    JOptionPane.showMessageDialog(null, "\n- Masculino -->Obeso: \nVocê está Obeso. \nProcure o acompanhamento de um nutricionista e realizar mais atividades físicas! " + df_imc);
                }
                break;
            case 1:
                if (IMC < m_imc[0]) {
                    JOptionPane.showMessageDialog(null, "\n- Feminino -->Abaixo do peso: \nVocê está abaixo do peso! " + df_imc);

                } else if (IMC < m_imc[1]) {
                    JOptionPane.showMessageDialog(null, "\n- Feminino -->No peso normal: \nVocê está com peso ideal! " + df_imc);

                } else if (IMC < m_imc[2]) {
                    JOptionPane.showMessageDialog(null, "\n- Feminino -->Acima do peso: \nVocê está acima do peso recomendado. \nCuidado! " + df_imc);

                } else {
                    JOptionPane.showMessageDialog(null, "\n- Feminino -->Obeso: \nVocê está Obeso. \nProcure o acompanhamento de um nutricionista e realizar mais atividades físicas! " + df_imc);
                }
                break;
        }
    }

}
