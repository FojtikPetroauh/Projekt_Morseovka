import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PrekladMorseovkyGUI extends JFrame implements KeyListener {
    private KontrolerMorseovky kontrolerMorseovky;

    // textInputArea - text uživatele na přeložení
    // morseCodeArea - přeložený text do Morseovky
    private JTextArea textInputArea, morseCodeArea;

    public PrekladMorseovkyGUI(){
        super("Překladač Morseovy abecedy");
        setSize(new Dimension(540, 760));
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#000000"));
        setLocationRelativeTo(null);

        kontrolerMorseovky = new KontrolerMorseovky();
        initGui();
    }

    private void initGui(){
        JLabel nadpisLabel = new JLabel("Prekladač Morseovy abecedy");

        nadpisLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        nadpisLabel.setForeground(Color.WHITE);
        nadpisLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nadpisLabel.setBounds(0, 0, 540, 100);

        JLabel textInputLabel = new JLabel("Text:");
        textInputLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        textInputLabel.setForeground(Color.WHITE);
        textInputLabel.setBounds(20, 100, 200, 30);

        textInputArea = new JTextArea();
        textInputArea.setFont(new Font("Dialog", Font.PLAIN, 18));

        textInputArea.addKeyListener(this);
        textInputArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        textInputArea.setLineWrap(true);
        textInputArea.setWrapStyleWord(true);
        JScrollPane textInputScroll = new JScrollPane(textInputArea);
        textInputScroll.setBounds(20, 132, 484, 236);

        // input morseovky
        JLabel morseCodeInputLabel = new JLabel("Morseova abeceda:");
        morseCodeInputLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        morseCodeInputLabel.setForeground(Color.WHITE);
        morseCodeInputLabel.setBounds(20, 390, 200, 30);

        morseCodeArea = new JTextArea();
        morseCodeArea.setFont(new Font("Dialog", Font.PLAIN, 18));
        morseCodeArea.setEditable(false);
        morseCodeArea.setLineWrap(true);
        morseCodeArea.setWrapStyleWord(true);
        morseCodeArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // scrollpany
        JScrollPane morseCodeScroll = new JScrollPane(morseCodeArea);
        morseCodeScroll.setBounds(20, 430, 484, 236);

        // tlačítko na opačný překlad
        JButton prelozitZpetButton = new JButton("Přeložit zpět");
        prelozitZpetButton.setBounds(50, 680, 150, 30);
        prelozitZpetButton.setEnabled(true);

        prelozitZpetButton.addActionListener(e -> new PrekladZMorseovkyGUI().setVisible(true));

        // tlačítko pro přehrání zvuku
        JButton playSoundButton = new JButton("Spusť morseovku");
        playSoundButton.setBounds(210, 680, 150, 30);
        playSoundButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // vypnutí tlačítka pro přehrání zvuku
                playSoundButton.setEnabled(false);

                Thread playMorseCodeThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            String[] MorseovaZprava = morseCodeArea.getText().split(" ");
                            kontrolerMorseovky.prehrajZvuk(MorseovaZprava);
                        }catch(LineUnavailableException lineUnavailableException){
                            lineUnavailableException.printStackTrace();
                        }catch(InterruptedException interruptedException){
                            interruptedException.printStackTrace();
                        }finally{
                            // povolit tlačítko pro přehrání zvuku
                            playSoundButton.setEnabled(true);
                        }
                    }
                });
                playMorseCodeThread.start();
            }
        });

        add(nadpisLabel);
        add(textInputLabel);
        add(textInputScroll);
        add(morseCodeInputLabel);
        add(morseCodeScroll);
        add(playSoundButton);
        add(prelozitZpetButton);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // ignoruj shift
        if(e.getKeyCode() != KeyEvent.VK_SHIFT){
            String inputText = textInputArea.getText();
            morseCodeArea.setText(kontrolerMorseovky.prelozDoMorseovky(inputText));
        }
    }
}


























