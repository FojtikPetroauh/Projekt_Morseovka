import javax.sound.sampled.*;
import java.util.HashMap;

public class KontrolerMorseovky {

    private HashMap<Character, String> Morseovka_Mapa;

    public KontrolerMorseovky(){
        Morseovka_Mapa = new HashMap<>();

        // Velká písmena
        Morseovka_Mapa.put('A', ".-");
        Morseovka_Mapa.put('Á', ".-");
        Morseovka_Mapa.put('B', "-...");
        Morseovka_Mapa.put('Č', "-.-.");
        Morseovka_Mapa.put('C', "-.-.");
        Morseovka_Mapa.put('D', "-..");
        Morseovka_Mapa.put('Ď', "-..");
        Morseovka_Mapa.put('E', ".");
        Morseovka_Mapa.put('É', ".");
        Morseovka_Mapa.put('Ě', ".");
        Morseovka_Mapa.put('F', "..-.");
        Morseovka_Mapa.put('G', "--.");
        Morseovka_Mapa.put('H', "....");
        Morseovka_Mapa.put('I', "..");
        Morseovka_Mapa.put('Í', "..");
        Morseovka_Mapa.put('J', ".---");
        Morseovka_Mapa.put('K', "-.-");
        Morseovka_Mapa.put('L', ".-..");
        Morseovka_Mapa.put('M', "--");
        Morseovka_Mapa.put('N', "-.");
        Morseovka_Mapa.put('Ň', "-.");
        Morseovka_Mapa.put('O', "---");
        Morseovka_Mapa.put('Ó', "---");
        Morseovka_Mapa.put('P', ".--.");
        Morseovka_Mapa.put('Q', "--.-");
        Morseovka_Mapa.put('R', ".-.");
        Morseovka_Mapa.put('Ř', ".-.");
        Morseovka_Mapa.put('S', "...");
        Morseovka_Mapa.put('Š', "...");
        Morseovka_Mapa.put('T', "-");
        Morseovka_Mapa.put('Ť', "-");
        Morseovka_Mapa.put('U', "..-");
        Morseovka_Mapa.put('Ú', "..-");
        Morseovka_Mapa.put('Ů', "..-");
        Morseovka_Mapa.put('V', "...-");
        Morseovka_Mapa.put('W', ".--");
        Morseovka_Mapa.put('X', "-..-");
        Morseovka_Mapa.put('Y', "-.--");
        Morseovka_Mapa.put('Ý', "-.--");
        Morseovka_Mapa.put('Z', "--..");
        Morseovka_Mapa.put('Ž', "--..");

        // Malá písmena
        Morseovka_Mapa.put('a', ".-");
        Morseovka_Mapa.put('á', ".-");
        Morseovka_Mapa.put('b', "-...");
        Morseovka_Mapa.put('c', "-.-.");
        Morseovka_Mapa.put('č', "-.-.");
        Morseovka_Mapa.put('d', "-..");
        Morseovka_Mapa.put('ď', "-..");
        Morseovka_Mapa.put('e', ".");
        Morseovka_Mapa.put('é', ".");
        Morseovka_Mapa.put('ě', ".");
        Morseovka_Mapa.put('f', "..-.");
        Morseovka_Mapa.put('g', "--.");
        Morseovka_Mapa.put('h', "....");
        Morseovka_Mapa.put('i', "..");
        Morseovka_Mapa.put('í', "..");
        Morseovka_Mapa.put('j', ".---");
        Morseovka_Mapa.put('k', "-.-");
        Morseovka_Mapa.put('l', ".-..");
        Morseovka_Mapa.put('m', "--");
        Morseovka_Mapa.put('n', "-.");
        Morseovka_Mapa.put('ň', "-.");
        Morseovka_Mapa.put('o', "---");
        Morseovka_Mapa.put('ó', "---");
        Morseovka_Mapa.put('p', ".--.");
        Morseovka_Mapa.put('q', "--.-");
        Morseovka_Mapa.put('r', ".-.");
        Morseovka_Mapa.put('ř', ".-.");
        Morseovka_Mapa.put('s', "...");
        Morseovka_Mapa.put('š', "...");
        Morseovka_Mapa.put('t', "-");
        Morseovka_Mapa.put('ť', "-");
        Morseovka_Mapa.put('u', "..-");
        Morseovka_Mapa.put('ú', "..-");
        Morseovka_Mapa.put('ů', "..-");
        Morseovka_Mapa.put('v', "...-");
        Morseovka_Mapa.put('w', ".--");
        Morseovka_Mapa.put('x', "-..-");
        Morseovka_Mapa.put('y', "-.--");
        Morseovka_Mapa.put('ý', "-.--");
        Morseovka_Mapa.put('z', "--..");
        Morseovka_Mapa.put('ž', "--..");

        // čísla
        Morseovka_Mapa.put('0', "-----");
        Morseovka_Mapa.put('1', ".----");
        Morseovka_Mapa.put('2', "..---");
        Morseovka_Mapa.put('3', "...--");
        Morseovka_Mapa.put('4', "....-");
        Morseovka_Mapa.put('5', ".....");
        Morseovka_Mapa.put('6', "-....");
        Morseovka_Mapa.put('7', "--...");
        Morseovka_Mapa.put('8', "---..");
        Morseovka_Mapa.put('9', "----.");

        // speciální znaky
        Morseovka_Mapa.put(' ', "/");
        Morseovka_Mapa.put(',', "--..--");
        Morseovka_Mapa.put('.', ".-.-.-");
        Morseovka_Mapa.put('?', "..--..");
        Morseovka_Mapa.put(';', "-.-.-.");
        Morseovka_Mapa.put(':', "---...");
        Morseovka_Mapa.put('(', "-.--.");
        Morseovka_Mapa.put(')', "-.--.-");
        Morseovka_Mapa.put('[', "-.--.");
        Morseovka_Mapa.put(']', "-.--.-");
        Morseovka_Mapa.put('{', "-.--.");
        Morseovka_Mapa.put('}', "-.--.-");
        Morseovka_Mapa.put('+', ".-.-.");
        Morseovka_Mapa.put('-', "-....-");
        Morseovka_Mapa.put('_', "..--.-");
        Morseovka_Mapa.put('"', ".-..-.");
        Morseovka_Mapa.put('\'', ".----.");
        Morseovka_Mapa.put('/', "-..-.");
        Morseovka_Mapa.put('\\', "-..-.");
        Morseovka_Mapa.put('@', ".--.-.");
        Morseovka_Mapa.put('=', "-...-");
        Morseovka_Mapa.put('!', "-.-.--");
    }

    public String prelozDoMorseovky(String textNaPrelozeni){
        StringBuilder prelozenyText = new StringBuilder();
        for(Character letter : textNaPrelozeni.toCharArray()){
            prelozenyText.append(Morseovka_Mapa.get(letter) + " ");
        }
        return prelozenyText.toString();
    }

    public void prehrajZvuk(String[] morseZprava) throws LineUnavailableException, InterruptedException {
        AudioFormat audioFormat = new AudioFormat(44100, 16, 1, true, false);

        DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
        SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
        sourceDataLine.open(audioFormat);
        sourceDataLine.start();

        int dobaTecky = 200;
        int dobaPomlcky = (int) (1.5 * dobaTecky);
        int dobaLomitka = 2 * dobaPomlcky;

        for(String vzor : morseZprava){
            System.out.println(vzor);

            // spustit zvuk písmene
            for(char c : vzor.toCharArray()){
                if(c == '.'){
                    prehrajPipani(sourceDataLine, dobaTecky);
                    Thread.sleep(dobaTecky);
                }else if(c == '-'){
                    prehrajPipani(sourceDataLine, dobaPomlcky);
                    Thread.sleep(dobaTecky);
                }else if(c == '/'){
                    Thread.sleep(dobaLomitka);
                }
            }

            // chvíli počkat po každém písmenu
            Thread.sleep(dobaTecky);
        }

        // čekat na dokončení přehrávání zvuku
        sourceDataLine.drain();
        sourceDataLine.stop();
        sourceDataLine.close();
    }

    private void prehrajPipani(SourceDataLine line, int doba){
        // vytvoření audio data
        byte[] data = new byte[doba * 44100 / 1000];

        for(int i = 0; i < data.length; i++){
            // vypočítá úhel pro aktuální bod v čase
            double uhel = i / (44100.0/440) * 2.0 * Math.PI;
            // vypočítá hodnotu signálu v daném bodě
            data[i] = (byte) (Math.sin(uhel) * 127.0);
        }

        // zapiš data do audio line
        line.write(data, 0, data.length);
    }
}


















