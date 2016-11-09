package PhotoRenamer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class GUI {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmOpen;
	private JMenuItem mntmClose;
//	private ArrayList<String> imgPaths;
//	private String focusedImgPath;
	private ArrayList<ImageNode> imgs;
//	private File focusedFile;
	private ImageNode focusedImage;
	private JTextField tagTxtField;
	private FileHandler fh;
	private FileImageDecoder fid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Photo Renamer");
		frame.setBounds(100, 100, 700, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(getMenuBar_1());
		frame.getContentPane().setLayout(null);
		
		
		
		JLabel labelImg = new JLabel();
		
		labelImg.setBounds(82, 0, 518, 303);
		frame.getContentPane().add(labelImg);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("1 File?");
		chckbxNewCheckBox.setBounds(6, 406, 70, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JButton btnAddImage = new JButton("Add Image");
		btnAddImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				fh = new FileHandler(chckbxNewCheckBox.isSelected());
				fid = new FileImageDecoder(fh.getFiles());
				imgs = fid.toImageNodes();
				if (imgs.size() > 0) {
					focusedImage = imgs.get(0);
//					focusedFile = imgs.get(0);
				}
				setIconImage(focusedImage.getPathName(), labelImg);
//				focusedImgPath = imgPaths.get(0);
//				ImageIcon imgThisImg = new ImageIcon(focusedImgPath);
//				labelImg.setIcon(imgThisImg);
			}
		});
		btnAddImage.setBounds(82, 406, 99, 23);
		frame.getContentPane().add(btnAddImage);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (imgs.indexOf(focusedImage) < imgs.size()-1) {
					focusedImage = imgs.get(imgs.indexOf(focusedImage)+1);
					setIconImage(focusedImage.getPathName(), labelImg);
				} else {
					System.out.println("Could not do it!");
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(360, 319, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (imgs.indexOf(focusedImage) > 0) {
					focusedImage = imgs.get(imgs.indexOf(focusedImage)-1);
					setIconImage(focusedImage.getPathName(), labelImg);
				} else {
					System.out.println("Could not do it!");
				}
			}
		});
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPrevious.setBounds(207, 319, 115, 29);
		frame.getContentPane().add(btnPrevious);
		
		JButton btnAddTag = new JButton("Add Tag");
		btnAddTag.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (!tagTxtField.getText().equals("")) {
					focusedImage.addTag(new Tag(tagTxtField.getText()));
				}
			}
		});
		btnAddTag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddTag.setBounds(328, 403, 115, 29);
		frame.getContentPane().add(btnAddTag);
		
		tagTxtField = new JTextField();
		tagTxtField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				tagTxtField.setText("Please enter tag name");
			}
		});
		tagTxtField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (tagTxtField.getText().equals("Please enter tag name")) {
					tagTxtField.setText("");
				}
				
//				tagTxtField.set
			}
		});
		tagTxtField.setText("Please enter tag name");
		tagTxtField.setBounds(454, 404, 190, 26);
		frame.getContentPane().add(tagTxtField);
		tagTxtField.setColumns(10);
		
		
	}
	
	private void setIconImage(String path, JLabel label) {
		ImageIcon thisImg = new ImageIcon(path);
		label.setIcon(thisImg);
	}
	
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
		}
		return menuBar;
	}
	
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmClose());
		}
		return mnFile;
	}
	
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
		}
		return mntmOpen;
	}
	
	private JMenuItem getMntmClose() {
		if (mntmClose == null) {
			mntmClose = new JMenuItem("Close");
			mntmClose.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					frame.dispose();
				}
			});
		}
		return mntmClose;
	}
}
