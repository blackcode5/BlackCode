/* DON-CODE */
package blackcode.ui;

import static blackcode.BlackCode.cons;
import static blackcode.ui.MainAppWindow.jtable;
import static blackcode.ui.MainAppWindow.model;
import static blackcode.ui.MainAppWindow.userId;
import blackcode.uiclass.Database;
import blackcode.uiclass.ScrollBarWin11UI;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import org.json.JSONArray;
import org.json.JSONObject;

public class NoteAppWindow extends javax.swing.JFrame {

    private int xx, yy;
    private boolean isBoldSelected = false;
    private boolean isItalicSelected = false;
    private boolean isUnderlineSelected = false;
    private boolean isStrikethroughSelected = false;
    private int noteId;
    private int row;

    public NoteAppWindow(int noteId, int row) {
        initComponents();
        this.show();
        this.setLocationRelativeTo(null); // Set location to center
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(cons.getSTICKYNOTE_IMG()))); // Set app icon
        setBackground(new Color(0, 0, 0, 0)); // Transparent background color
        this.noteId = noteId;
        this.row = row;
        setNote();
    }

    private void setNote() {
        Map<String, Object> noteData = new Database().getFullNote(noteId);

        if (noteData != null) {
            JTextPane textPane = new JTextPane();
            String plainText = (String) noteData.get("plainText");
            byte[] noteBlob = (byte[]) noteData.get("note_blob");
            String jsonText = new String(noteBlob, StandardCharsets.UTF_8);
            if (!(jsonText.equals("�� p"))) {
                JSONArray jsonArray = new JSONArray(jsonText);
                StyledDocument styledDocument = new DefaultStyledDocument();
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        JSONObject element = jsonArray.getJSONObject(i);

                        String text = element.getString("text");
                        int fontSize = element.getInt("fontSize");
                        boolean bold = element.getBoolean("bold");
                        boolean italic = element.getBoolean("italic");
                        boolean underline = element.getBoolean("underline");
                        boolean strikethrough = element.getBoolean("strikethrough");

                        SimpleAttributeSet attributes = new SimpleAttributeSet();

                        attributes.addAttribute(StyleConstants.FontSize, fontSize);
                        attributes.addAttribute(StyleConstants.Bold, bold);
                        attributes.addAttribute(StyleConstants.Italic, italic);
                        attributes.addAttribute(StyleConstants.Underline, underline);
                        attributes.addAttribute(StyleConstants.StrikeThrough, strikethrough);

                        styledDocument.insertString(styledDocument.getLength(), text, attributes);
                    } catch (BadLocationException ex) {
                        Logger.getLogger(NoteAppWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                this.note.setStyledDocument(styledDocument);

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainShadowPanel = new blackcode.uiclass.PanelShadow();
        topNavigationPanel = new javax.swing.JPanel();
        topNavigationFocus = new javax.swing.JPanel();
        plusPanel = new javax.swing.JPanel();
        plusLabel = new javax.swing.JLabel();
        closePanel = new javax.swing.JPanel();
        closeLabel = new javax.swing.JLabel();
        topNavigationFocusLost = new javax.swing.JPanel();
        colorBar = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        boldPanel = new javax.swing.JPanel();
        boldLabel = new javax.swing.JLabel();
        italicPanel = new javax.swing.JPanel();
        italicLabel = new javax.swing.JLabel();
        underlinePanel = new javax.swing.JPanel();
        underlineLabel = new javax.swing.JLabel();
        strikethroughPanel = new javax.swing.JPanel();
        strikethroughLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        increaseLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        note = new javax.swing.JTextPane();
        jPanel13 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Note++");
        setUndecorated(true);

        topNavigationPanel.setBackground(new java.awt.Color(51, 51, 51));
        topNavigationPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                topNavigationPanelMouseDragged(evt);
            }
        });
        topNavigationPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                topNavigationPanelMousePressed(evt);
            }
        });
        topNavigationPanel.setLayout(new java.awt.CardLayout());

        topNavigationFocus.setBackground(new java.awt.Color(44, 51, 51));

        plusPanel.setBackground(new java.awt.Color(44, 51, 51));

        plusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        plusLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackcode/img/plus_20px.png"))); // NOI18N
        plusLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                plusLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                plusLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                plusLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout plusPanelLayout = new javax.swing.GroupLayout(plusPanel);
        plusPanel.setLayout(plusPanelLayout);
        plusPanelLayout.setHorizontalGroup(
            plusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        plusPanelLayout.setVerticalGroup(
            plusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plusPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(plusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        closePanel.setBackground(new java.awt.Color(51, 51, 51));

        closeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackcode/img/Close_20px.png"))); // NOI18N
        closeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout closePanelLayout = new javax.swing.GroupLayout(closePanel);
        closePanel.setLayout(closePanelLayout);
        closePanelLayout.setHorizontalGroup(
            closePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(closeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        closePanelLayout.setVerticalGroup(
            closePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, closePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout topNavigationFocusLayout = new javax.swing.GroupLayout(topNavigationFocus);
        topNavigationFocus.setLayout(topNavigationFocusLayout);
        topNavigationFocusLayout.setHorizontalGroup(
            topNavigationFocusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topNavigationFocusLayout.createSequentialGroup()
                .addComponent(plusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                .addComponent(closePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        topNavigationFocusLayout.setVerticalGroup(
            topNavigationFocusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topNavigationFocusLayout.createSequentialGroup()
                .addGroup(topNavigationFocusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(plusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        topNavigationPanel.add(topNavigationFocus, "card3");

        topNavigationFocusLost.setBackground(new java.awt.Color(51, 204, 0));

        colorBar.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout colorBarLayout = new javax.swing.GroupLayout(colorBar);
        colorBar.setLayout(colorBarLayout);
        colorBarLayout.setHorizontalGroup(
            colorBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );
        colorBarLayout.setVerticalGroup(
            colorBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout topNavigationFocusLostLayout = new javax.swing.GroupLayout(topNavigationFocusLost);
        topNavigationFocusLost.setLayout(topNavigationFocusLostLayout);
        topNavigationFocusLostLayout.setHorizontalGroup(
            topNavigationFocusLostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(colorBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        topNavigationFocusLostLayout.setVerticalGroup(
            topNavigationFocusLostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topNavigationFocusLostLayout.createSequentialGroup()
                .addComponent(colorBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        topNavigationPanel.add(topNavigationFocusLost, "card2");

        jPanel12.setLayout(new java.awt.CardLayout());

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));

        boldPanel.setBackground(new java.awt.Color(51, 51, 51));

        boldLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        boldLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackcode/img/Bold_15px.png"))); // NOI18N
        boldLabel.setToolTipText("Bold");
        boldLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boldLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boldLabelMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                boldLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                boldLabelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout boldPanelLayout = new javax.swing.GroupLayout(boldPanel);
        boldPanel.setLayout(boldPanelLayout);
        boldPanelLayout.setHorizontalGroup(
            boldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boldPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(boldLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        boldPanelLayout.setVerticalGroup(
            boldPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boldPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(boldLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        italicPanel.setBackground(new java.awt.Color(51, 51, 51));

        italicLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        italicLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackcode/img/Italic_15px.png"))); // NOI18N
        italicLabel.setToolTipText("Italic");
        italicLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                italicLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                italicLabelMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                italicLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                italicLabelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout italicPanelLayout = new javax.swing.GroupLayout(italicPanel);
        italicPanel.setLayout(italicPanelLayout);
        italicPanelLayout.setHorizontalGroup(
            italicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, italicPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(italicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        italicPanelLayout.setVerticalGroup(
            italicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, italicPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(italicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        underlinePanel.setBackground(new java.awt.Color(51, 51, 51));

        underlineLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        underlineLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackcode/img/Underline_15px.png"))); // NOI18N
        underlineLabel.setToolTipText("Underline");
        underlineLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                underlineLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                underlineLabelMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                underlineLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                underlineLabelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout underlinePanelLayout = new javax.swing.GroupLayout(underlinePanel);
        underlinePanel.setLayout(underlinePanelLayout);
        underlinePanelLayout.setHorizontalGroup(
            underlinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, underlinePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(underlineLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        underlinePanelLayout.setVerticalGroup(
            underlinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, underlinePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(underlineLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        strikethroughPanel.setBackground(new java.awt.Color(51, 51, 51));

        strikethroughLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        strikethroughLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackcode/img/Strikethrough_15px.png"))); // NOI18N
        strikethroughLabel.setToolTipText("Strikethrough");
        strikethroughLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                strikethroughLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                strikethroughLabelMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                strikethroughLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                strikethroughLabelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout strikethroughPanelLayout = new javax.swing.GroupLayout(strikethroughPanel);
        strikethroughPanel.setLayout(strikethroughPanelLayout);
        strikethroughPanelLayout.setHorizontalGroup(
            strikethroughPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, strikethroughPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(strikethroughLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        strikethroughPanelLayout.setVerticalGroup(
            strikethroughPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, strikethroughPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(strikethroughLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackcode/img/icons8_subtract_15px.png"))); // NOI18N
        jLabel1.setToolTipText("Decrease Size");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        increaseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        increaseLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blackcode/img/plus_20px.png"))); // NOI18N
        increaseLabel.setToolTipText("Increase Size");
        increaseLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                increaseLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                increaseLabelMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                increaseLabelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                increaseLabelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(increaseLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(increaseLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(boldPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(italicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(underlinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(strikethroughPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boldPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(italicPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(underlinePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strikethroughPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        note.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                noteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                noteKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(note);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel12.add(jPanel14, "card3");

        jPanel13.setBackground(new java.awt.Color(102, 0, 204));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel13, "card2");

        javax.swing.GroupLayout mainShadowPanelLayout = new javax.swing.GroupLayout(mainShadowPanel);
        mainShadowPanel.setLayout(mainShadowPanelLayout);
        mainShadowPanelLayout.setHorizontalGroup(
            mainShadowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainShadowPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainShadowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topNavigationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainShadowPanelLayout.setVerticalGroup(
            mainShadowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainShadowPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topNavigationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainShadowPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainShadowPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void topNavigationPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topNavigationPanelMousePressed
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_topNavigationPanelMousePressed

    private void topNavigationPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topNavigationPanelMouseDragged
        if ((this.getExtendedState() & JFrame.MAXIMIZED_BOTH) == JFrame.MAXIMIZED_BOTH) {
            this.setExtendedState(JFrame.NORMAL);
//            this.setLocation(0, 0);
        } else {
            this.setLocation(evt.getXOnScreen() - xx - 6, evt.getYOnScreen() - yy - 6);
        }
    }//GEN-LAST:event_topNavigationPanelMouseDragged

    private void closeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseClicked
        try {
            if (new Database().doesNoteExist((int) model.getValueAt(row, 2))) {
                model.setValueAt(note.getText(), row, 0);
                new Database().updateNote(noteId, null, this.note);
            }
        } catch (Exception ex) {
            this.dispose();
        }
        this.dispose();
    }//GEN-LAST:event_closeLabelMouseClicked

    private void closeLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseEntered
        closePanel.setBackground(new Color(255, 0, 0));
        closeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_closeLabelMouseEntered

    private void closeLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabelMouseExited
        closePanel.setBackground(new Color(44, 51, 51));
    }//GEN-LAST:event_closeLabelMouseExited

    private void boldLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boldLabelMouseClicked
        // Get the selected text from the JTextPane
        String selectedText = note.getSelectedText();

        if (selectedText != null && !selectedText.isEmpty()) {
            // Get the StyledDocument
            StyledDocument doc = note.getStyledDocument();
            if (isBoldSelected) {
                // Create a Style to remove the bold
                Style normalStyle = doc.addStyle("NormalStyle", null);
                StyleConstants.setBold(normalStyle, false);

                // Apply the normal style to the selected text
                doc.setCharacterAttributes(
                        note.getSelectionStart(),
                        note.getSelectionEnd() - note.getSelectionStart(),
                        normalStyle,
                        false
                );
            } else {
                // Create a Style for bold
                Style boldStyle = doc.addStyle("BoldStyle", null);
                StyleConstants.setBold(boldStyle, true);

                // Apply the bold style to the selected text
                doc.setCharacterAttributes(
                        note.getSelectionStart(),
                        note.getSelectionEnd() - note.getSelectionStart(),
                        boldStyle,
                        false
                );
            }
            // Toggle the isBoldSelected variable
            isBoldSelected = !isBoldSelected;
        }
    }//GEN-LAST:event_boldLabelMouseClicked

    private void italicLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_italicLabelMouseClicked
        // Get the selected text from the JTextPane
        String selectedText = note.getSelectedText();
        if (selectedText != null && !selectedText.isEmpty()) {
            // Get the StyledDocument
            StyledDocument doc = note.getStyledDocument();

            if (isItalicSelected) {
                // Create a Style to remove the italic
                Style normalStyle = doc.addStyle("NormalStyle", null);
                StyleConstants.setItalic(normalStyle, false);

                // Apply the normal style to the selected text
                doc.setCharacterAttributes(
                        note.getSelectionStart(),
                        note.getSelectionEnd() - note.getSelectionStart(),
                        normalStyle,
                        false
                );
            } else {
                // Create a Style for italic
                Style italicStyle = doc.addStyle("ItalicStyle", null);
                StyleConstants.setItalic(italicStyle, true);

                // Apply the italic style to the selected text
                doc.setCharacterAttributes(
                        note.getSelectionStart(),
                        note.getSelectionEnd() - note.getSelectionStart(),
                        italicStyle,
                        false
                );
            }
            // Toggle the isItalicSelected variable
            isItalicSelected = !isItalicSelected;
        }
    }//GEN-LAST:event_italicLabelMouseClicked

    private void underlineLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_underlineLabelMouseClicked
        // Get the selected text from the JTextPane
        String selectedText = note.getSelectedText();

        if (selectedText != null && !selectedText.isEmpty()) {
            // Get the StyledDocument
            StyledDocument doc = note.getStyledDocument();

            if (isUnderlineSelected) {
                // Create a Style to remove the underline
                Style normalStyle = doc.addStyle("NormalStyle", null);
                StyleConstants.setUnderline(normalStyle, false);

                // Apply the normal style to the selected text
                doc.setCharacterAttributes(
                        note.getSelectionStart(),
                        note.getSelectionEnd() - note.getSelectionStart(),
                        normalStyle,
                        false
                );
            } else {
                // Create a Style for underline
                Style underlineStyle = doc.addStyle("UnderlineStyle", null);
                StyleConstants.setUnderline(underlineStyle, true);

                // Apply the underline style to the selected text
                doc.setCharacterAttributes(
                        note.getSelectionStart(),
                        note.getSelectionEnd() - note.getSelectionStart(),
                        underlineStyle,
                        false
                );
            }

            // Toggle the isUnderlineSelected variable
            isUnderlineSelected = !isUnderlineSelected;
        }
    }//GEN-LAST:event_underlineLabelMouseClicked

    private void strikethroughLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_strikethroughLabelMouseClicked
        // Get the selected text from the JTextPane
        String selectedText = note.getSelectedText();

        if (selectedText != null && !selectedText.isEmpty()) {
            // Get the StyledDocument
            StyledDocument doc = note.getStyledDocument();

            if (isStrikethroughSelected) {
                // Create a Style to remove the strikethrough
                Style normalStyle = doc.addStyle("NormalStyle", null);
                StyleConstants.setStrikeThrough(normalStyle, false);

                // Apply the normal style to the selected text
                doc.setCharacterAttributes(
                        note.getSelectionStart(),
                        note.getSelectionEnd() - note.getSelectionStart(),
                        normalStyle,
                        false
                );
            } else {
                // Create a Style for strikethrough
                Style strikethroughStyle = doc.addStyle("StrikethroughStyle", null);
                StyleConstants.setStrikeThrough(strikethroughStyle, true);

                // Apply the strikethrough style to the selected text
                doc.setCharacterAttributes(
                        note.getSelectionStart(),
                        note.getSelectionEnd() - note.getSelectionStart(),
                        strikethroughStyle,
                        false
                );
            }

            // Toggle the isStrikethroughSelected variable
            isStrikethroughSelected = !isStrikethroughSelected;
        }
    }//GEN-LAST:event_strikethroughLabelMouseClicked

    private void increaseLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseLabelMouseClicked
// Get the selected text from the JTextPane
        String selectedText = note.getSelectedText();

        if (selectedText != null && !selectedText.isEmpty()) {
            // Get the current font size of the selected text
            int currentFontSize = -1;
            int selectionStart = note.getSelectionStart();
            int selectionEnd = note.getSelectionEnd();
            StyledDocument doc = note.getStyledDocument();
            Element element = doc.getCharacterElement(selectionStart);
            AttributeSet attrSet = element.getAttributes();

            if (StyleConstants.getFontSize(attrSet) != -1) {
                currentFontSize = StyleConstants.getFontSize(attrSet);
            }

            // Create a Style to apply the new font size
            Style style = doc.addStyle("FontSizeStyle", null);

            // Calculate the new font size (e.g., increase it by 2)
            int newFontSize = (currentFontSize != -1) ? currentFontSize + 2 : 12; // Default to 12 if font size not set

            // Apply the new font size to the style
            StyleConstants.setFontSize(style, newFontSize);

            // Apply the style to the selected text
            doc.setCharacterAttributes(
                    selectionStart,
                    selectionEnd - selectionStart,
                    style,
                    false
            );
        }

    }//GEN-LAST:event_increaseLabelMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // Get the selected text from the JTextPane
        String selectedText = note.getSelectedText();

        if (selectedText != null && !selectedText.isEmpty()) {
            // Get the current font size of the selected text
            int currentFontSize = -1;
            int selectionStart = note.getSelectionStart();
            int selectionEnd = note.getSelectionEnd();
            StyledDocument doc = note.getStyledDocument();
            Element element = doc.getCharacterElement(selectionStart);
            AttributeSet attrSet = element.getAttributes();

            if (StyleConstants.getFontSize(attrSet) != -1) {
                currentFontSize = StyleConstants.getFontSize(attrSet);
            }

            // Create a Style to apply the new font size
            Style style = doc.addStyle("FontSizeStyle", null);

            // Calculate the new font size (e.g., decrease it by 2)
            int newFontSize = (currentFontSize != -1) ? currentFontSize - 2 : 12; // Default to 12 if font size not set
            if (newFontSize < 1) {
                newFontSize = 1; // Ensure the font size doesn't go below 1
            }

            // Apply the new font size to the style
            StyleConstants.setFontSize(style, newFontSize);

            // Apply the style to the selected text
            doc.setCharacterAttributes(
                    selectionStart,
                    selectionEnd - selectionStart,
                    style,
                    false
            );
        }

    }//GEN-LAST:event_jLabel1MouseClicked

    private void noteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noteKeyPressed

    }//GEN-LAST:event_noteKeyPressed

    private void noteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noteKeyTyped
        try {
            if (new Database().doesNoteExist((int) model.getValueAt(row, 2))) {
                if ((int) model.getValueAt(row, 2) == noteId) {
                    model.setValueAt(this.note.getText(), row, 0);
                } else {
                    if (!(row == 0)) {
                        model.setValueAt(this.note.getText(), row - 1, 0);
                    } else {
                        model.setValueAt(this.note.getText(), row, 0);
                    }
                }
            }
        } catch (Exception ex) {
            this.dispose();
        }
    }//GEN-LAST:event_noteKeyTyped

    private void plusLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plusLabelMouseClicked
        int noteID = new Database().saveNote(userId, null, null, null);
        model.addRow(new Object[]{null, null, noteID});
        new NoteAppWindow(noteID, jtable.getRowCount() - 1);
    }//GEN-LAST:event_plusLabelMouseClicked

    private void plusLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plusLabelMouseEntered
        plusPanel.setBackground(new Color(255, 255, 0));
        plusLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(cons.getPLUSMATHBLACK()))));
        plusLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_plusLabelMouseEntered

    private void boldLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boldLabelMouseEntered
        boldLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_boldLabelMouseEntered

    private void italicLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_italicLabelMouseEntered
        italicLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_italicLabelMouseEntered

    private void underlineLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_underlineLabelMouseEntered
        underlineLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_underlineLabelMouseEntered

    private void strikethroughLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_strikethroughLabelMouseEntered
        strikethroughLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_strikethroughLabelMouseEntered

    private void increaseLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseLabelMouseEntered
        increaseLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_increaseLabelMouseEntered

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        jLabel1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void boldLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boldLabelMousePressed
        boldPanel.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_boldLabelMousePressed

    private void boldLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boldLabelMouseReleased
        boldPanel.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_boldLabelMouseReleased

    private void italicLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_italicLabelMousePressed
        italicPanel.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_italicLabelMousePressed

    private void italicLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_italicLabelMouseReleased
        italicPanel.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_italicLabelMouseReleased

    private void underlineLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_underlineLabelMousePressed
        underlinePanel.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_underlineLabelMousePressed

    private void underlineLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_underlineLabelMouseReleased
        underlinePanel.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_underlineLabelMouseReleased

    private void strikethroughLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_strikethroughLabelMousePressed
        strikethroughPanel.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_strikethroughLabelMousePressed

    private void strikethroughLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_strikethroughLabelMouseReleased
        strikethroughPanel.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_strikethroughLabelMouseReleased

    private void increaseLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseLabelMousePressed
        jPanel2.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_increaseLabelMousePressed

    private void increaseLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_increaseLabelMouseReleased
        jPanel2.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_increaseLabelMouseReleased

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        jPanel1.setBackground(new Color(102, 102, 102));
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseReleased
        jPanel1.setBackground(new Color(51, 51, 51));
    }//GEN-LAST:event_jLabel1MouseReleased

    private void plusLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_plusLabelMouseExited
        plusPanel.setBackground(new Color(51, 51, 51));
        plusLabel.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/blackcode/img/plus_20px.png"))));
    }//GEN-LAST:event_plusLabelMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatDarkLaf.setup(); // Set FlatLf Dark theme for that application
        UIDefaults ui = UIManager.getDefaults();
        ui.put("ScrollBarUI", ScrollBarWin11UI.class.getCanonicalName());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel boldLabel;
    private javax.swing.JPanel boldPanel;
    private javax.swing.JLabel closeLabel;
    private javax.swing.JPanel closePanel;
    private javax.swing.JPanel colorBar;
    private javax.swing.JLabel increaseLabel;
    private javax.swing.JLabel italicLabel;
    private javax.swing.JPanel italicPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private blackcode.uiclass.PanelShadow mainShadowPanel;
    public javax.swing.JTextPane note;
    private javax.swing.JLabel plusLabel;
    private javax.swing.JPanel plusPanel;
    private javax.swing.JLabel strikethroughLabel;
    private javax.swing.JPanel strikethroughPanel;
    private javax.swing.JPanel topNavigationFocus;
    private javax.swing.JPanel topNavigationFocusLost;
    private javax.swing.JPanel topNavigationPanel;
    private javax.swing.JLabel underlineLabel;
    private javax.swing.JPanel underlinePanel;
    // End of variables declaration//GEN-END:variables
}
