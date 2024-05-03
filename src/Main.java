public class Main {
    public static void main(String[] args) {
        // Ejemplo de uso - Llama a la función reverseWords y muestra el resultado
        System.out.println(reverseWords("mundo hola 123456"));
        //System.out.println(reverseWords("Holaaaa"));
    }

    public static String reverseWords(String sentence) {
        // Crear un StringBuilder para armar la cadena con las palabras invertidas
        StringBuilder reverse = new StringBuilder();

        // Crear un StringBuilder temporal para ir acumulando cada palabra
        StringBuilder word = new StringBuilder();

        // Contador para saber la longitud de la palabra actual
        int cont = 0;

        // Flag para indicar si en la iteración no se ha encontrado ninguna letra
        boolean cantLetters = false;

        // Iterar sobre cada caracter de la frase (sentence)
        for (int i = 0; i < sentence.length(); i++) {
            char letter = sentence.charAt(i);

            // Si el caracter es un espacio, significa el fin de una palabra
            if (letter == ' ') {
                // (Línea comentada) Imprimir la longitud de la palabra, usado para depuración
                // System.out.println(cont);

                // Invertir la palabra acumulada y añadirla al resultado (reverse)
                reverse.append(word.reverse().append(' '));

                // Vaciar el StringBuilder 'word' para iniciar la siguiente palabra
                word.setLength(0);

                // Restablecer el contador a cero
                cont = 0;

                // Indicar que en esta iteración no se han procesado letras
                cantLetters = true;
            } else {
                // Si no es un espacio, se agrega el caracter a la palabra actual
                word.append(letter);
            }

            // Incrementar el contador de la longitud de la palabra
            cont++;
        }

        // (Línea comentada) Imprimir la última longitud de palabra, usado para depuración
        // System.out.println(cont);

        // Procesar la última palabra
        if (word.length() > 0 && cont >= 5) {
            // Si la palabra tiene al menos una letra y una longitud mayor o igual a 5, también se invierte
            reverse.append(word.reverse());
            cantLetters = true;
        } else {
            // De lo contrario, se agrega la última palabra original
            reverse.append(word);
        }

        // Se devuelve la cadena de palabras invertidas o la original si no hubo cambios
        return cantLetters ? reverse.toString() : sentence;
    }
}
