package ui;

import model.Bacon;
import model.Ingredients;
import model.Pickle;
import model.Sandwich;
import persistence.*;

import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;



// A sandwich game that allows the player to make and serve sandwiches to customers
public class SandwichGameGui extends JFrame {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    private Sandwich sandwich;
    List<String> ingredList;
    List<String> imageList;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JPanel panel;
    private JPanel breadPanel;
    private static final String JSON_STORE = "./data/Sandwich.json";



    // EFFECTS: Creates an instance of the sandwich game in the terminal console
    // Attribution: code structure based on the Flashcards lab
    public SandwichGameGui() {
        inital();
    }

    // MODIFIES: this
    // EFFECTS: initializes the game with the starting values
    // Attribution: code structure based on the Flashcards lab and the AlarmSystem Lecture Lab
    public void inital() {
        sandwich = new Sandwich();
        ingredList = new ArrayList<>();
        imageList = new ArrayList<>();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        setTitle("CPSC 210: Sandwich Maker Game");

        breadPanel = new JPanel();
        ImageIcon topBread = new ImageIcon("image/TopBread.png");
        Image scaleTopBread = topBread.getImage().getScaledInstance(WIDTH / 4, HEIGHT / 8, Image.SCALE_SMOOTH);
        JLabel topBreadLabel = new JLabel(new ImageIcon(scaleTopBread));
        breadPanel.add(topBreadLabel);
        breadPanel.setBackground(Color.yellow);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setBackground(Color.orange);
        
        add(breadPanel, BorderLayout.NORTH);
        add(new JScrollPane(panel));
        add(addButtonPanel(), BorderLayout.SOUTH);
        //topBreadAdder();
        bottomBreadAdder();
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();    
        setVisible(true);

    }
    
    // MODIFIES: panel
    // EFFECTS: adds a bottom bun to the sandwich
    public void bottomBreadAdder() {
        panel.removeAll();
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.anchor = GridBagConstraints.CENTER;
        ImageIcon bottomBread = new ImageIcon("image/BreadBottom.png");
        Image scaleBottomBread = bottomBread.getImage().getScaledInstance(WIDTH / 4, HEIGHT / 8, Image.SCALE_SMOOTH);
        JLabel bottomBreadLabel = new JLabel(new ImageIcon(scaleBottomBread));
        c.gridy = imageList.size() + 100000; 
        panel.add(bottomBreadLabel, c);
    }


    // MODIFIES: panel
    // EFFECTS: prints out the list of ingredients as images
    public JPanel imagePrinter() {
        panel.removeAll();
        bottomBreadAdder();
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.anchor = GridBagConstraints.CENTER;

        for (int i = 0; i < imageList.size(); i++) {
            ImageIcon image = new ImageIcon(imageList.get(i));
            Image scaleImage = image.getImage().getScaledInstance(WIDTH / 6, HEIGHT / 12, Image.SCALE_SMOOTH);
            ImageIcon postScaleImage = new ImageIcon(scaleImage);
            JLabel imageAsLabel = new JLabel(postScaleImage);
            imageAsLabel.setVisible(true);
            c.gridy = imageList.size() - 1 - i; 
            panel.add(imageAsLabel, c);
        }
        panel.revalidate();
        panel.repaint();
        return panel;
    } 

    // EFFECTS: adds the bacon button 
    // Attribution: code structure based on the AlarmSystem lecture lab
    public JButton baconButtonAdd() {
        JButton baconButton = new JButton("Add a Bacon");
        baconButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addBacon();
            }
		});
        return baconButton;
    }

    
    // EFFECTS: adds the pickle button 
    // Attribution: code structure based on the AlarmSystem lecture lab
    public JButton pickleButtonAdd() {
        JButton pickleButton = new JButton("Add a Pickle");
        pickleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPickle();
            }
		});
        return pickleButton;
    }

    // EFFECTS: adds the remove button 
    // Attribution: code structure based on the AlarmSystem lecture lab
    public JButton removeButtonAdd() {
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeIngredient();
            }
		});
        return removeButton;
    }

    // EFFECTS: adds the load button 
    // Attribution: code structure based on the AlarmSystem lecture lab
    public JButton loadButtonAdd() {
        JButton loadButton = new JButton("Load Sandwich");
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadSandwich();
            }
		});
        return loadButton;
    }
    
    // EFFECTS: adds the save button 
    // Attribution: code structure based on the AlarmSystem lecture lab
    public JButton saveButtonAdd() {
        JButton saveButton = new JButton("Save sandwich");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveSandwich();
		    }
		});
        return saveButton;
    }

    // EFFECTS: adds the exit game button 
    // Attribution: code structure based on the AlarmSystem lecture lab
    public JButton exitButtonAdd() {
        JButton endButton = new JButton("Exit the game");
        endButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
		});
        return endButton;
    }

    // EFFECTS: adds the exit game button 
    // Attribution: code structure based on the AlarmSystem lecture lab
    public JButton showAllButtonAdd() {
        return null; //stub
    }


    // MODIFIES: buttonPanel
    // EFFECTS: adds the buttons to the gui panel
    // Attribution: code structure based on the AlarmSystem Lab
    public JPanel addButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,4));
        buttonPanel.add(baconButtonAdd());
        buttonPanel.add(pickleButtonAdd());
        buttonPanel.add(showAllButtonAdd());
        buttonPanel.add(removeButtonAdd());
        buttonPanel.add(saveButtonAdd());
        buttonPanel.add(loadButtonAdd());
        buttonPanel.add(exitButtonAdd());
        buttonPanel.setBackground(Color.MAGENTA);

        return buttonPanel;
    }

    // MODIFIES: this
    // EFFECTS: displays all the ingredients inside the sandwich
    public void viewSandwich() {
        // stub
    }
   
    // MODIFIES: this
    // EFFECTS: adds a new bacon to the sandwich
    public void addBacon() throws NumberFormatException {
        try {
            String input = JOptionPane.showInputDialog("Should this bacon be raw(enter 1), or cooked(enter 2):");
            int baconProperty = Integer.parseInt(input);
            if (baconProperty == 1) {
                Bacon bacon = new Bacon(baconProperty);
                this.sandwich.addIngredient(bacon);
                ingredList.add("Raw Bacon");
                imageList.add("image\\RawBacon.png");
                imagePrinter();
                JOptionPane.showMessageDialog(this, "A raw bacon is added to the sandwich!");
            } else if (baconProperty == 2) {
                Bacon bacon = new Bacon(baconProperty);            
                this.sandwich.addIngredient(bacon);
                ingredList.add("Cooked Bacon");
                imageList.add("image\\CookedBacon.png");
                imagePrinter();
                JOptionPane.showMessageDialog(this, "A cooked bacon is added to the sandwich!");
            } else {
                JOptionPane.showMessageDialog(this,"This is not a valid input, try again.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "No Bacon is added");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a new pickle to the sandwich
    public void addPickle() {
        try {
            String input = JOptionPane.showInputDialog("Should this pickle be dill(enter 1), or sweet(enter 2):");
            int pickleProperty = Integer.parseInt(input);        
            if (pickleProperty == 1) {
                Pickle pickle = new Pickle(pickleProperty);
                this.sandwich.addIngredient(pickle);
                ingredList.add("Dill Pickle");
                imageList.add("image\\DillPickle.png");
                imagePrinter();
                JOptionPane.showMessageDialog(this, "A dill pickle is added to the sandwich!");
            } else if (pickleProperty == 2) {
                Pickle pickle = new Pickle(pickleProperty);            
                this.sandwich.addIngredient(pickle);
                ingredList.add("Sweet Pickle");
                imageList.add("image\\SweetPickle.png");
                imagePrinter();
                JOptionPane.showMessageDialog(this, "A sweet pickle is added to the sandwich!");
            } else {
                JOptionPane.showMessageDialog(this, pickleProperty + " is not a valid input, try again.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "No Pickle is added");

        }
    }
     
    // MODIFIES: this
    // EFFECTS: remove the last ingredient added from the sandwich, print a message if there is no ingredients
    public void removeIngredient() {
        if (sandwich.viewIngredients().isEmpty()) {
            JOptionPane.showMessageDialog(this, "This sandwich is empty! No ingredient to remove!");
        } else {
            int last = ingredList.size() - 1;
            String removed = ingredList.get(last);
            JOptionPane.showMessageDialog(this, "This " + removed + " will be removed from the sandwich!");
            sandwich.removeIngredients();
            ingredList.remove(last);
            imageList.remove(last);
            imagePrinter();
        }
    }


    // EFFECTS: saves the workroom to file
    // Attribution: this code structure is based on the JsonSerializationDemo
    private void saveSandwich() {
        try {
            jsonWriter.open();
            jsonWriter.write(sandwich);
            jsonWriter.close();
            JOptionPane.showMessageDialog(this, "Saved current sandwich to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Unable to write to file: " + JSON_STORE);
        }
    }
    
    // MODIFIES: this
    // EFFECTS: loads sandwich from file
    // Attribution: this code structure is based on the JsonSerializationDemo
    private void loadSandwich() {
        ingredList.clear();
        imageList.clear();
        try {
            sandwich = jsonReader.read();
            for (Ingredients i : sandwich.viewIngredients()) {
                String ing = i.getQuality() + " " + i.getName();
                ingredList.add(ing);
                //updateIngredientList();
            }
            updateIngredientList();
            JOptionPane.showMessageDialog(this, "Loaded sandwich from " + JSON_STORE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Unable to read from file: " + JSON_STORE);
        }        
    }

    // EFFECTS: turns the sandwich into images
    // Attributions: replaceAll is from https://stackoverflow.com/questions/5455794/removing-whitespace-from-strings-in-java
    private void updateIngredientList() {
        panel.removeAll();
        bottomBreadAdder();
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.anchor = GridBagConstraints.CENTER;
        for (int i = 0; i < ingredList.size(); i++) {
            String img = "image\\" + ingredList.get(i).replaceAll(" ","") + ".png";
            imageList.add(img);
            ImageIcon image = new ImageIcon(img);
            Image scaleImage = image.getImage().getScaledInstance(WIDTH / 6, HEIGHT / 12, Image.SCALE_SMOOTH);
            ImageIcon postScaleImage = new ImageIcon(scaleImage);
            JLabel label = new JLabel(postScaleImage);
            label.setVisible(true);
            c.gridy = ingredList.size() - 1 - i; 
            panel.add(label, c);
        }
        panel.revalidate();
        panel.repaint();
    }

        
    // EFFECTS: centers the gui panel on the screen
    // Attributions: code structure based on the AlarmSystem LectureLab
    public void centreOnScreen() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((width - getWidth()) / 2, (height - getHeight()) / 2);
    }
}

