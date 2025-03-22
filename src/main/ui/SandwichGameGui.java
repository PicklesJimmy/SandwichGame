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
        panel = new JPanel();

        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(new JScrollPane(panel), BorderLayout.CENTER);
        add(addButtonPanel(), BorderLayout.SOUTH);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();    
        setVisible(true);

    }

    // MODIFIES: this
    // EFFECTS: prints out the list of ingredients as images
    public JPanel imagePrinter() {
        panel.removeAll();
        for (String s: imageList) {
            ImageIcon image = new ImageIcon(s);
            Image scaleImage = image.getImage().getScaledInstance(WIDTH / 3, HEIGHT / 6, Image.SCALE_SMOOTH);
            ImageIcon postScaleImage = new ImageIcon(scaleImage);
            JLabel imageAsLabel = new JLabel(postScaleImage);
            panel.add(imageAsLabel);
            imageAsLabel.setVisible(true);
        }
        // add(panel,BorderLayout.CENTER);
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


    

    // EFFECTS: adds the buttons to the gui panel
    // Attribution: code structure based on the AlarmSystem Lab
    public JPanel addButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,3));
        buttonPanel.add(baconButtonAdd());
        buttonPanel.add(pickleButtonAdd());
        buttonPanel.add(removeButtonAdd());
        buttonPanel.add(saveButtonAdd());
        buttonPanel.add(loadButtonAdd());
        buttonPanel.add(exitButtonAdd());

        return buttonPanel;

		
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
            // JLabel jlabel = new JLabel("hello");
            // panel.add(jlabel);
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
        panel.removeAll();
        try {
            sandwich = jsonReader.read();
            for (Ingredients i : sandwich.viewIngredients()) {
                String ing = i.getQuality() + " " + i.getName();
                ingredList.add(ing);
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
        for (String ingredient : ingredList) {
            String img = "image\\" + ingredient.replaceAll(" ","") + ".png";
            imageList.add(img);
            ImageIcon image = new ImageIcon(img);
            Image scaleImage = image.getImage().getScaledInstance(WIDTH / 3, HEIGHT / 6, Image.SCALE_SMOOTH);
            ImageIcon postScaleImage = new ImageIcon(scaleImage);
            JLabel label = new JLabel(postScaleImage);
            label.setBounds(WIDTH / 3, HEIGHT/2 - (ingredList.size() * (HEIGHT / 30)), WIDTH / 3, HEIGHT / 6);
            label.setVisible(true);
            panel.add(label);
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

