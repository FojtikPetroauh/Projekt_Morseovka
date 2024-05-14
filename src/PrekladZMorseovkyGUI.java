import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class PrekladZMorseovkyGUI extends JFrame implements KeyListener {
    private KontrolerPrekladuZMorseovky kontrolerPrekladuZMorseovky;
    private JTextArea textInputArea, morseCodeArea;

    public PrekladZMorseovkyGUI(){
        super("Překladač z Morseovy abecedy");
        setSize(540, 760);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#000000"));
        setLocationRelativeTo(null);

        kontrolerPrekladuZMorseovky = new KontrolerPrekladuZMorseovky();
        initGui();
    }
    public void initGui(){
        JLabel nadpisLabel = new JLabel("Prekladač z Morseovy abecedy");

        nadpisLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        nadpisLabel.setForeground(Color.WHITE);
        nadpisLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nadpisLabel.setBounds(0, 0, 540, 100);

        JLabel textInputLabel = new JLabel("Morseova abeceda:");
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
        JLabel morseCodeInputLabel = new JLabel("Text:");
        morseCodeInputLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        morseCodeInputLabel.setForeground(Color.WHITE);
        morseCodeInputLabel.setBounds(20, 390, 200, 30);

        morseCodeArea = new JTextArea();
        morseCodeArea.setFont(new Font("Dialog", Font.PLAIN, 18));
        morseCodeArea.setEditable(false);
        morseCodeArea.setLineWrap(true);
        morseCodeArea.setWrapStyleWord(true);
        morseCodeArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //scrollpany
        JScrollPane morseCodeScroll = new JScrollPane(morseCodeArea);
        morseCodeScroll.setBounds(20, 430, 484, 236);

        add(nadpisLabel);
        add(textInputLabel);
        add(textInputScroll);
        add(morseCodeInputLabel);
        add(morseCodeScroll);
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
            morseCodeArea.setText(kontrolerPrekladuZMorseovky.prelozZMorseovky(inputText));
        }
    }
}
