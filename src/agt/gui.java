package agt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
//import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageProducer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

@SuppressWarnings("serial")
class gui extends JFrame implements ActionListener {
	Dimension size = new Dimension(900, 500);
	final int rows = 50, cols = 150;
	Color c = Color.WHITE;
	
	JTabbedPane tabs = new JTabbedPane(), newsTabs = new JTabbedPane();

	// data panel on top
	JPanel gdata = new JPanel();
	JLabel ldata = new JLabel();
	JButton endb = new JButton("סיים תור");

	// tabs: news, war, diplomacy, research, recruiting, economy, special
	// projects & view
	JPanel news = new JPanel(), war = new JPanel(), diplomacy = new JPanel(), research = new JPanel(),
			recruiting = new JPanel(), economy = new JPanel(),
			specialProjects = new JPanel()/* , view = new JPanel() */;
	JScrollPane snews = new JScrollPane(news), swar = new JScrollPane(war), sdiplomacy = new JScrollPane(diplomacy),
			sresearch = new JScrollPane(research), srecruiting = new JScrollPane(recruiting),
			seconomy = new JScrollPane(economy), sspecialProjects = new JScrollPane(
					specialProjects);

	// news: war, diplomacy, research, specialProjects, recruiting, economy
	JTextArea nwo = new JTextArea(rows, cols), ndo = new JTextArea(rows, cols), nrso = new JTextArea(rows, cols),
			nspo = new JTextArea(rows, cols), nrco = new JTextArea(rows, cols), neo = new JTextArea(rows, cols);
	JScrollPane snw = new JScrollPane(nwo), snd = new JScrollPane(ndo), snrs = new JScrollPane(nrso),
			snsp = new JScrollPane(nspo), snrc = new JScrollPane(nrco), sne = new JScrollPane(neo);

	// view panel
	JTextArea viewo = new JTextArea(rows, cols);
	JScrollPane sviewo = new JScrollPane(viewo);

	// special projects panel
	JLabel atomicResearchl = new JLabel(""), nuclearWarheadl = new JLabel(""), atomicEnergyl = new JLabel(""),
			bioWarheadl = new JLabel(""), chimicWarheadl = new JLabel(""), accurateMissilesl = new JLabel("");
	JButton atomicResearchb = new JButton("חקירה"), nuclearWarheadb = new JButton("חקירה"),
			atomicEnergyb = new JButton("חקירה"), bioWarheadb = new JButton("חקירה"),
			chimicWarheadb = new JButton("חקירה"), accurateMissilesb = new JButton("חקירה");

	// economy panel
	JLabel growingl = new JLabel(""), educationl = new JLabel(""), industryl = new JLabel(""),
			millitaryIndustryl = new JLabel(""), sciencel = new JLabel(""), cyberl = new JLabel(""),
			missilesProductionl = new JLabel(""), mamProductionl = new JLabel(""), mofetl = new JLabel("");
	JButton growingb = new JButton("שדרוג"), educationb = new JButton("שדרוג"), industryb = new JButton("שדרוג"),
			millitaryIndustryb = new JButton("שדרוג"), scienceb = new JButton("שדרוג"), cyberb = new JButton("שדרוג"),
			missilesProductionb = new JButton("שדרוג"), mamProductionb = new JButton("שדרוג"),
			mofetb = new JButton("שדרוג");

	// recruiting panel
	JLabel tankl = new JLabel("גייס טנקים. מחיר ליחידה: " + Game.nameNumber100(Empire.TANK_COST)),
			artilleryl = new JLabel("גייס ארטילריה. מחיר ליחידה: " + Game.nameNumber100(Empire.ARTILLERY_COST)),
			aaSysteml = new JLabel("גייס מערכות הגנה אוירית. מחיר ליחידה: " + Game.nameNumber100(Empire.AASYSTEM_COST)),
			planel = new JLabel("גייס מטוסים. מחיר ליחידה: " + Game.nameNumber100(Empire.PLANE_COST)),
			helicopterl = new JLabel("גייס מסוקים. מחיר ליחידה: " + Game.nameNumber100(Empire.HELICOPTER_COST)),
			shipl = new JLabel("גייס ספינות. מחיר ליחידה: " + Game.nameNumber100(Empire.SHIP_COST)),
			submarinel = new JLabel("גייס צוללות. מחיר ליחידה: " + Game.nameNumber100(Empire.SUBMARINE_COST)),
			rocketl = new JLabel("גייס רקטות. מחיר ליחידה: " + Game.nameNumber100(Empire.ROCKET_COST)),
			kipatBarzell = new JLabel(
					"גייס מערכות כיפת ברזל. מחיר ליחידה: " + Game.nameNumber100(Empire.KIPAT_BARZEL_COST)),
			flyerl = new JLabel("גייס רחפני תקיפה. מחיר ליחידה: " + Game.nameNumber100(Empire.FLYERS_COST)),
			kelaDavidl = new JLabel("גייס מערכות קלע דוד. מחיר ליחידה: " + Game.nameNumber100(Empire.KELA_DAVID_COST)),
			commandol = new JLabel("גייס יחידות עילית. מחיר ליחידה: " + Game.nameNumber100(Empire.COMMANDO_UNIT_COST));
	JTextField tanktf = new JTextField(), artillerytf = new JTextField(), aaSystemtf = new JTextField(),
			planetf = new JTextField(), helicoptertf = new JTextField(), shiptf = new JTextField(),
			submarinetf = new JTextField(), rockettf = new JTextField(), kipatBarzeltf = new JTextField(),
			flyertf = new JTextField(), kelaDavidtf = new JTextField(), commandotf = new JTextField();
	JButton tankb = new JButton("גייס"), artilleryb = new JButton("גייס"), aaSystemb = new JButton("גייס"),
			planeb = new JButton("גייס"), helicopterb = new JButton("גייס"), shipb = new JButton("גייס"),
			submarineb = new JButton("גייס"), rocketb = new JButton("גייס"), kipatBarzelb = new JButton("גייס"),
			flyerb = new JButton("גייס"), kelaDavidb = new JButton("גייס"), commandob = new JButton("גייס");

	// research panel
	JLabel soldierrl = new JLabel(), tankrl = new JLabel(), artilleryrl = new JLabel(), aaSystemrl = new JLabel(),
			planerl = new JLabel(), helicopterrl = new JLabel(), shiprl = new JLabel(), submarinerl = new JLabel(),
			rocketrl = new JLabel(), kipatBarzelrl = new JLabel(), missilesrl = new JLabel(), mamrl = new JLabel(),
			flyerrl = new JLabel(), kelaDavidrl = new JLabel(), commandorl = new JLabel();
	JButton soldierrb = new JButton("פתח"), tankrb = new JButton("פתח"), artilleryrb = new JButton("פתח"),
			aaSystemrb = new JButton("פתח"), planerb = new JButton("פתח"), helicopterrb = new JButton("פתח"),
			shiprb = new JButton("פתח"), submarinerb = new JButton("פתח"), rocketrb = new JButton("פתח"),
			kipatBarzelrb = new JButton("פתח"), missilesrb = new JButton("פתח"), mamrb = new JButton("פתח"),
			flyerrb = new JButton("פתח"), kelaDavidrb = new JButton("פתח"), commandorb = new JButton("פתח");

	// diplomacy panel
	JComboBox<String> empList = new JComboBox<String>();
	DefaultComboBoxModel<String> elModel = new DefaultComboBoxModel<String>();
	JButton improve = new JButton("שפר יחסים"), outprove = new JButton("הרע יחסים"), atkb = new JButton("הכרז מלחמה!");

	// war panel
	JComboBox<String> empb = new JComboBox<String>();
	DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
	JButton fatkb = new JButton("התקפת רחפנים"), matkb = new JButton("שגר טילים");

	/*
	 * outdated code
	 */
	/*
	 * JLabel gtl = new JLabel(), ttl = new JLabel(), atl = new JLabel(), mil =
	 * new JLabel(); JButton gtb = new JButton("חקור"), ttb = new
	 * JButton("חקור"), atb = new JButton("חקור"), mib = new JButton("פתח");
	 * JLabel al = new JLabel(), fl = new JLabel(), kdl = new JLabel(), ml = new
	 * JLabel(), kbl = new JLabel(); JTextField rectf = new JTextField(10);
	 * JButton recb = new JButton("גייס"); JTextField ftf = new JTextField(10),
	 * kdtf = new JTextField(10); JButton fb = new JButton("בנה רחפני תקיפה"),
	 * kdb = new JButton("ייצר מערכות קלע דוד"), fatkb = new JButton(
	 * "התקפת רחפנים"); JTextField mtf = new JTextField(10), kbtf = new
	 * JTextField(10); JButton mb = new JButton("ייצר טילים"), kbb = new
	 * JButton("ייצר מערכות כיפת ברזל"), matkb = new JButton("שגר טילים"); /* //
	 * projects JPanel projects = new JPanel(); JLabel acml = new JLabel();
	 * JButton acmb = new JButton("קדם!"); // diplomacy
	 */

	public gui() {
		Graphics("Windows");
		// adding data panel on top
		gdata.add(ldata);
		endb.addActionListener(this);
		gdata.add(endb);
		gdata.setMinimumSize(new Dimension(900, 50));
		add(gdata, BorderLayout.PAGE_START);

		// adding news tabs
		nwo.setBackground(c);
		nwo.setEditable(false);
		// snw.add(nwo);
		ndo.setBackground(c);
		ndo.setEditable(false);
		// snd.add(ndo);
		nrso.setBackground(c);
		nrso.setEditable(false);
		// snrs.add(nrso);
		nspo.setBackground(c);
		nspo.setEditable(false);
		// snsp.add(nspo);
		nrco.setBackground(c);
		nrco.setEditable(false);
		// snrc.add(nrco);
		neo.setBackground(c);
		neo.setEditable(false);
		// sne.add(neo);

		newsTabs.addTab("חדשות כלכלה", sne);
		newsTabs.addTab("חדשות מחקר", snrs);
		newsTabs.addTab("חדשות גיוס וייצור נשק", snrc);
		newsTabs.addTab("חדשות פרויקטים מיוחדים", snsp);
		newsTabs.addTab("חדשות דיפלומטיה", snd);
		newsTabs.addTab("חדשות מלחמה", snw);
		newsTabs.setPreferredSize(size);
		news.add(newsTabs);
		/*
		 * neo.setBackground(this.getBackground()); neo.setEditable(false);
		 * ne.add(sneo); nao.setBackground(this.getBackground());
		 * nao.setEditable(false); na.add(snao);
		 * nro.setBackground(this.getBackground()); nro.setEditable(false);
		 * nr.add(snro); ndo.setBackground(this.getBackground());
		 * ndo.setEditable(false); nd.add(sndo);
		 * 
		 * newsTabs.addTab("חדשות כלכלה", ne); newsTabs.addTab("חדשות מלחמה",
		 * na); newsTabs.addTab("גיוס וייצור נשק", nr);
		 * newsTabs.addTab("דיפלומטיה", nd); news.add(newsTabs);
		 */

		// view panel
		//viewo.setBackground(Color.GRAY);
		viewo.setBackground(c);
		viewo.setOpaque(true);
		viewo.setEditable(false);
		// view.add(sviewo);

		// special projects panel
		specialProjects.add(atomicResearchl);
		atomicResearchb.addActionListener(this);
		specialProjects.add(atomicResearchb);
		specialProjects.add(nuclearWarheadl);
		nuclearWarheadb.addActionListener(this);
		specialProjects.add(nuclearWarheadb);
		specialProjects.add(atomicEnergyl);
		atomicEnergyb.addActionListener(this);
		specialProjects.add(atomicEnergyb);
		specialProjects.add(bioWarheadl);
		bioWarheadb.addActionListener(this);
		specialProjects.add(bioWarheadb);
		specialProjects.add(chimicWarheadl);
		chimicWarheadb.addActionListener(this);
		specialProjects.add(chimicWarheadb);
		specialProjects.add(accurateMissilesl);
		accurateMissilesb.addActionListener(this);
		specialProjects.add(accurateMissilesb);
		specialProjects.setLayout(new GridLayout(6, 2));

		// economy panel
		economy.add(growingl);
		growingb.addActionListener(this);
		economy.add(growingb);
		economy.add(educationl);
		educationb.addActionListener(this);
		economy.add(educationb);
		economy.add(industryl);
		industryb.addActionListener(this);
		economy.add(industryb);
		economy.add(millitaryIndustryl);
		millitaryIndustryb.addActionListener(this);
		economy.add(millitaryIndustryb);
		economy.add(sciencel);
		scienceb.addActionListener(this);
		economy.add(scienceb);
		economy.add(cyberl);
		cyberb.addActionListener(this);
		economy.add(cyberb);
		economy.add(missilesProductionl);
		missilesProductionb.addActionListener(this);
		economy.add(missilesProductionb);
		economy.add(mamProductionl);
		mamProductionb.addActionListener(this);
		economy.add(mamProductionb);
		economy.add(mofetl);
		mofetb.addActionListener(this);
		economy.add(mofetb);
		economy.setLayout(new GridLayout(9, 2));

		// recruiting panel
		recruiting.add(tankl);
		recruiting.add(tanktf);
		tankb.addActionListener(this);
		recruiting.add(tankb);
		recruiting.add(artilleryl);
		recruiting.add(artillerytf);
		artilleryb.addActionListener(this);
		recruiting.add(artilleryb);
		recruiting.add(aaSysteml);
		recruiting.add(aaSystemtf);
		aaSystemb.addActionListener(this);
		recruiting.add(aaSystemb);
		recruiting.add(planel);
		recruiting.add(planetf);
		planeb.addActionListener(this);
		recruiting.add(planeb);
		recruiting.add(helicopterl);
		recruiting.add(helicoptertf);
		helicopterb.addActionListener(this);
		recruiting.add(helicopterb);
		recruiting.add(shipl);
		recruiting.add(shiptf);
		shipb.addActionListener(this);
		recruiting.add(shipb);
		recruiting.add(submarinel);
		recruiting.add(submarinetf);
		submarineb.addActionListener(this);
		recruiting.add(submarineb);
		recruiting.add(kipatBarzell);
		recruiting.add(kipatBarzeltf);
		kipatBarzelb.addActionListener(this);
		recruiting.add(kipatBarzelb);
		recruiting.add(flyerl);
		recruiting.add(flyertf);
		flyerb.addActionListener(this);
		recruiting.add(flyerb);
		recruiting.add(kelaDavidl);
		recruiting.add(kelaDavidtf);
		kelaDavidb.addActionListener(this);
		recruiting.add(kelaDavidb);
		recruiting.add(commandol);
		recruiting.add(commandotf);
		commandob.addActionListener(this);
		recruiting.add(commandob);
		recruiting.setLayout(new GridLayout(11, 3));

		// research panel
		research.add(soldierrl);
		soldierrb.addActionListener(this);
		research.add(soldierrb);
		research.add(tankrl);
		tankrb.addActionListener(this);
		research.add(tankrb);
		research.add(artilleryrl);
		artilleryrb.addActionListener(this);
		research.add(artilleryrb);
		research.add(aaSystemrl);
		aaSystemrb.addActionListener(this);
		research.add(aaSystemrb);
		research.add(planerl);
		planerb.addActionListener(this);
		research.add(planerb);
		research.add(helicopterrl);
		helicopterrb.addActionListener(this);
		research.add(helicopterrb);
		research.add(shiprl);
		shiprb.addActionListener(this);
		research.add(shiprb);
		research.add(submarinerl);
		submarinerb.addActionListener(this);
		research.add(submarinerb);
		research.add(kipatBarzelrl);
		kipatBarzelrb.addActionListener(this);
		research.add(kipatBarzelrb);
		research.add(missilesrl);
		missilesrb.addActionListener(this);
		research.add(missilesrb);
		research.add(mamrl);
		mamrb.addActionListener(this);
		research.add(mamrb);
		research.add(flyerrl);
		flyerrb.addActionListener(this);
		research.add(flyerrb);
		research.add(kelaDavidrl);
		kelaDavidrb.addActionListener(this);
		research.add(kelaDavidrb);
		research.add(commandorl);
		commandorb.addActionListener(this);
		research.add(commandorb);
		research.setLayout(new GridLayout(14, 2));

		// diplomacy panel
		empList.setModel(elModel);
		diplomacy.add(empList);
		improve.addActionListener(this);
		diplomacy.add(improve);
		outprove.addActionListener(this);
		diplomacy.add(outprove);
		atkb.addActionListener(this);
		diplomacy.add(atkb);
		diplomacy.setLayout(new GridLayout(1, 4));

		// war panel
		empb.setModel(model);
		war.add(empb);
		matkb.addActionListener(this);
		war.add(matkb);
		fatkb.addActionListener(this);
		war.add(fatkb);
		war.setLayout(new GridLayout(1, 3));

		/*
		 * gtb.addActionListener(this); ttb.addActionListener(this);
		 * atb.addActionListener(this); mib.addActionListener(this);
		 * tech.add(gtl); tech.add(gtb); tech.add(ttl); tech.add(ttb);
		 * tech.add(atl); tech.add(atb); tech.add(mil); tech.add(mib);
		 * tech.setLayout(new GridLayout(4, 2));
		 * 
		 * 
		 * war.add(al); war.add(rectf); recb.addActionListener(this);
		 * war.add(recb); // -----------
		 * 
		 * ml.setEnabled(false); kbl.setEnabled(false); mtf.setEnabled(false);
		 * mb.setEnabled(false); kbtf.setEnabled(false); kbb.setEnabled(false);
		 * matkb.setEnabled(false);
		 * 
		 * fl.setEnabled(false); kdl.setEnabled(false); ftf.setEnabled(false);
		 * fb.setEnabled(false); kdtf.setEnabled(false); kdb.setEnabled(false);
		 * fatkb.setEnabled(false);
		 * 
		 * war.add(ml); war.add(mtf); mb.addActionListener(this); war.add(mb);
		 * war.add(kbl); war.add(kbtf); kbb.addActionListener(this);
		 * war.add(kbb);
		 * 
		 * war.add(fl); war.add(ftf); fb.addActionListener(this); war.add(fb);
		 * war.add(kdl); war.add(kdtf); kdb.addActionListener(this);
		 * war.add(kdb); // ------------ empb.setModel(model); war.add(empb);
		 * matkb.addActionListener(this); war.add(matkb);
		 * fatkb.addActionListener(this); war.add(fatkb); // war.add(atkb);
		 * war.setLayout(new GridLayout(6, 3));
		 * 
		 * acml.setEnabled(false); acmb.setEnabled(false); projects.add(acml);
		 * acmb.addActionListener(this); projects.add(acmb);
		 */

		// tabbed pane of all
		news.setPreferredSize(size);
		diplomacy.setPreferredSize(size);
		war.setPreferredSize(size);
		research.setPreferredSize(size);
		recruiting.setPreferredSize(size);
		economy.setPreferredSize(size);
		specialProjects.setPreferredSize(size);
		// view.setPreferredSize(size);

		tabs.addTab("כלכלה", seconomy);
		tabs.addTab("מחקר", sresearch);
		tabs.addTab("גיוס", srecruiting);
		tabs.addTab("פרויקטים מיוחדים", sspecialProjects);
		tabs.addTab("יחסי חוץ", sdiplomacy);
		tabs.addTab("מלחמה", swar);
		tabs.addTab("חדשות", snews);
		tabs.addTab("מדינות", sviewo);

		add(tabs, BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(c);
		tabs.setBackground(c);
		newsTabs.setBackground(c);
		
		this.pack();
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		this.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		/*
		 * na.setFont(new Font("Arial", 0, 16)); ne.setFont(new Font("Arial", 0,
		 * 16)); nr.setFont(new Font("Arial", 0, 16)); nd.setFont(new
		 * Font("Arial", 0, 16));
		 */
		//this.Graphics("Windows"); // Nimbus
		/*
		 * na.setFont(new Font("Arial", 0, 16)); ne.setFont(new Font("Arial", 0,
		 * 16)); nr.setFont(new Font("Arial", 0, 16)); nd.setFont(new
		 * Font("Arial", 0, 16)); /* neo.setBackground(this.getBackground());
		 * neo.setEditable(false); ne.add(sneo);
		 * nao.setBackground(this.getBackground()); nao.setEditable(false);
		 * na.add(snao); nro.setBackground(this.getBackground());
		 * nro.setEditable(false); nr.add(snro);
		 * ndo.setBackground(this.getBackground()); ndo.setEditable(false);
		 * nd.add(sndo);
		 */
		SwingUtilities.updateComponentTreeUI(this);
		// this.pack();
		this.setTitle("משחק");
		this.setVisible(true);
	}

	String msg(String msg) {
		return JOptionPane.showInputDialog(msg);
	}

	void Graphics(String LAF) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
				if (LAF.equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					SwingUtilities.updateComponentTreeUI(this);
					break;
				}
		} catch (Exception localException) {
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//end turn
		if (e.getSource().equals(endb)) {
			// JOptionPane.showMessageDialog(this, "cash = "+Game.player.cash);
			Game.player.passTurn();
			// JOptionPane.showMessageDialog(this, "cash = "+Game.player.cash);
			Game.gameTurn();
			// Game.flyerAttacked.clear();
			// Game.missilesAttacked.clear();
		}
		
		//economy
		if (e.getSource().equals(growingb)) {
			Game.player.upgradeGrowing();
		}
		if (e.getSource().equals(educationb)) {
			Game.player.upgradeEducation();
		}
		if (e.getSource().equals(industryb)) {
			Game.player.upgradeIndustry();
		}
		if (e.getSource().equals(millitaryIndustryb)) {
			Game.player.upgradeMillitaryIndustry();
		}
		if (e.getSource().equals(scienceb)) {
			Game.player.upgradeScience();
		}
		if (e.getSource().equals(cyberb)) {
			Game.player.upgradeCyber();
		}
		if (e.getSource().equals(missilesProductionb)) {
			Game.player.upgradeMissilesProduction();
		}
		if (e.getSource().equals(mamProductionb)) {
			Game.player.upgradeMamProduction();
		}
		if (e.getSource().equals(mofetb)) {
			Game.player.upgradeMofet();
		}
		
		//special projects
		if (e.getSource().equals(atomicResearchb)) {
			Game.player.researchAtomicResearch();
		}
		if (e.getSource().equals(nuclearWarheadb)) {
			Game.player.researchNuclearWarhead();
		}
		if (e.getSource().equals(atomicEnergyb)) {
			Game.player.researchAtomicEnergy();
		}
		if (e.getSource().equals(bioWarheadb)) {
			Game.player.researchBioWarhead();
		}
		if (e.getSource().equals(chimicWarheadb)) {
			Game.player.researchChimicWarhead();
		}
		if (e.getSource().equals(accurateMissilesb)) {
			Game.player.researchAccurateMissiles();
		}
		
		//recruiting
		if (e.getSource().equals(tankb)) {
			Game.player.recruitTanks(Integer.parseInt(tanktf.getText()));
		}
		if (e.getSource().equals(artilleryb)) {
			Game.player.recruitArtillery(Integer.parseInt(artillerytf.getText()));
		}
		if (e.getSource().equals(aaSystemb)) {
			Game.player.recruitAASystems(Integer.parseInt(aaSystemtf.getText()));
		}
		if (e.getSource().equals(planeb)) {
			Game.player.recruitPlanes(Integer.parseInt(planetf.getText()));
		}
		if (e.getSource().equals(helicopterb)) {
			Game.player.recruitHelicopters(Integer.parseInt(helicoptertf.getText()));
		}
		if (e.getSource().equals(shipb)) {
			Game.player.recruitShips(Integer.parseInt(shiptf.getText()));
		}
		if (e.getSource().equals(submarineb)) {
			Game.player.recruitSubmarines(Integer.parseInt(submarinetf.getText()));
		}
		if (e.getSource().equals(rocketb)) {
			Game.player.recruitRockets(Integer.parseInt(rockettf.getText()));
		}
		if (e.getSource().equals(kipatBarzelb)) {
			Game.player.recruitKipatBarzel(Integer.parseInt(kipatBarzeltf.getText()));
		}
		if (e.getSource().equals(flyerb)) {
			Game.player.recruitFlyers(Integer.parseInt(flyertf.getText()));
		}
		if (e.getSource().equals(kelaDavidb)) {
			Game.player.recruitKelaDavid(Integer.parseInt(kelaDavidtf.getText()));
		}
		if (e.getSource().equals(commandob)) {
			Game.player.recruitCommandoUnits(Integer.parseInt(commandotf.getText()));
		}
		
		//diplomacy
		if (e.getSource().equals(improve)) {
			Empire emp = null;
			for (int i = 0; i < Game.empires.size(); i++) {
				if (Game.empires.get(i).name.equals(empList.getSelectedItem())) {
					emp = Game.empires.get(i);
					break;
				}
			}

			if (Matrix.getRelations(Game.player.name, emp.name) != 6) {
				Game.player.warmRelationsWith(emp);
				tabs.setSelectedComponent(snews);
				newsTabs.setSelectedComponent(snd);
			} else {
				JOptionPane.showMessageDialog(this, "אתה כבר בהסכם שלום עם מדינה זו!");
			}
		}
		if (e.getSource().equals(outprove)) {
			Empire emp = null;
			for (int i = 0; i < Game.empires.size(); i++) {
				if (Game.empires.get(i).name.equals(empList.getSelectedItem())) {
					emp = Game.empires.get(i);
					break;
				}
			}

			if (Matrix.getRelations(Game.player.name, emp.name) > 0) {
				Game.player.coldRelationsWith(emp);
				tabs.setSelectedComponent(snews);
				newsTabs.setSelectedComponent(snd);
			} else {
				JOptionPane.showMessageDialog(this, "אתה כבר במלחמה עם מדינה זו!");
			}
		}
		if (e.getSource().equals(atkb)) {
			Empire emp = null;
			for (int i = 0; i < Game.empires.size(); i++) {
				if (Game.empires.get(i).name.equals(empList.getSelectedItem())) {
					emp = Game.empires.get(i);
					break;
				}
			}

			if (!Game.player.borders.contains(emp.name)) {
				JOptionPane.showMessageDialog(this, "אין לך גבול עם מדינה זו!");
				return;
			}
			if (!Game.player.inWarWith(emp)) {
				Game.player.declareWar(emp);
				tabs.setSelectedComponent(snews);
				newsTabs.setSelectedComponent(snw);
			} else {
				JOptionPane.showMessageDialog(this, "אתה כבר במלחמה עם מדינה זו!");
			}
		}
		Game.update();
		
		/*
		 * if (e.getSource().equals(gtb)) { Game.player.advanceGrow(); } if
		 * (e.getSource().equals(ttb)) { Game.player.advanceTax(); } if
		 * (e.getSource().equals(mib)) { Game.player.produceMillitary(); } if
		 * (e.getSource().equals(acmb)) { if (Game.player.getTechA() < 3) {
		 * JOptionPane.showMessageDialog(this,
		 * "הטכנולוגיה הצבאית שלך לא מספיק מפותחת!"); return; }
		 * Game.player.researchAccurateMissiles(); } if
		 * (e.getSource().equals(atb)) { Game.player.advanceArmy();
		 * 
		 * if (Game.player.getTechA() == 3) { /* ml.setEnabled(true);
		 * mtf.setEnabled(true); mb.setEnabled(true); matkb.setEnabled(true);
		 */
		/*
		 * tabs.setSelectedComponent(war); } if (Game.player.getTechA() == 4) {
		 * /* kbl.setEnabled(true); kbtf.setEnabled(true); kbb.setEnabled(true);
		 */
		/*
		 * tabs.setSelectedComponent(war); } if (Game.player.getTechA() == 5) {
		 * /* fl.setEnabled(true); ftf.setEnabled(true); fb.setEnabled(true);
		 * fatkb.setEnabled(true);
		 */
		/*
		 * tabs.setSelectedComponent(war); } if (Game.player.getTechA() == 6) {
		 * /* kdl.setEnabled(true); kdtf.setEnabled(true); kdb.setEnabled(true);
		 */
		/*
		 * tabs.setSelectedComponent(war); } } if (e.getSource().equals(recb)) {
		 * Game.player.recruit(Integer.parseInt(rectf.getText()));
		 * rectf.setText(""); } if (e.getSource().equals(fb)) {
		 * Game.player.recruitFlyers(Integer.parseInt(ftf.getText()));
		 * ftf.setText(""); } if (e.getSource().equals(kdb)) {
		 * Game.player.recruitKelaDavid(Integer.parseInt(kdtf.getText()));
		 * kdtf.setText(""); } if (e.getSource().equals(mb)) {
		 * Game.player.buildMissiles(Integer.parseInt(mtf.getText()));
		 * mtf.setText(""); } if (e.getSource().equals(kbb)) {
		 * Game.player.buildKipatBarzel(Integer.parseInt(kbtf.getText()));
		 * kbtf.setText(""); } if (e.getSource().equals(improve)) { Empire emp =
		 * null; for (int i = 0; i < Game.empires.size(); i++) { if
		 * (Game.empires.get(i).name.equals(empList.getSelectedItem())) { emp =
		 * Game.empires.get(i); break; } }
		 * 
		 * if(Matrix.getRelations(Game.player.name, emp.name) != 6) {
		 * Game.player.warmRelationsWith(emp); tabs.setSelectedComponent(news);
		 * newsTabs.setSelectedComponent(nd); } else {
		 * JOptionPane.showMessageDialog(this, "אתה כבר בהסכם שלום עם מדינה זו!"
		 * ); } } if (e.getSource().equals(outprove)) { Empire emp = null; for
		 * (int i = 0; i < Game.empires.size(); i++) { if
		 * (Game.empires.get(i).name.equals(empList.getSelectedItem())) { emp =
		 * Game.empires.get(i); break; } }
		 * 
		 * if(Matrix.getRelations(Game.player.name, emp.name) > 0) {
		 * Game.player.coldRelationsWith(emp); tabs.setSelectedComponent(news);
		 * newsTabs.setSelectedComponent(nd); } else {
		 * JOptionPane.showMessageDialog(this, "אתה כבר במלחמה עם מדינה זו!"); }
		 * } if (e.getSource().equals(atkb)) { Empire emp = null; for (int i =
		 * 0; i < Game.empires.size(); i++) { if
		 * (Game.empires.get(i).name.equals(empList.getSelectedItem())) { emp =
		 * Game.empires.get(i); break; } }
		 * 
		 * if (!Game.player.borders.contains(emp.name)) {
		 * JOptionPane.showMessageDialog(this, "אין לך גבול עם מדינה זו!");
		 * return; } if(!Game.player.inWarWith(emp)) {
		 * Game.player.declareWar(emp); tabs.setSelectedComponent(news);
		 * newsTabs.setSelectedComponent(na); } else {
		 * JOptionPane.showMessageDialog(this, "אתה כבר במלחמה עם מדינה זו!"); }
		 * } if (e.getSource().equals(fatkb)) { Empire emp = null; for (int i =
		 * 0; i < Game.empires.size(); i++) { if
		 * (Game.empires.get(i).name.equals(empb.getSelectedItem())) { emp =
		 * Game.empires.get(i); break; } }
		 * if(Game.flyerAttacked.contains(emp.name) ||
		 * Game.player.inWarWith(emp)) JOptionPane.showMessageDialog(null,
		 * "כבר תקפת באמצעות רחפנים את השדרוגים של מדינה זו!"); else {
		 * Game.player.flyersAttack(emp); Game.flyerAttacked.add(emp.name);
		 * tabs.setSelectedComponent(news); newsTabs.setSelectedComponent(na); }
		 * } if (e.getSource().equals(matkb)) { Empire emp = null; for (int i =
		 * 0; i < Game.empires.size(); i++) { if
		 * (Game.empires.get(i).name.equals(empb.getSelectedItem())) { emp =
		 * Game.empires.get(i); break; } } Game.player.missilesAttack(emp);
		 * Game.missilesAttacked.add(emp.name); tabs.setSelectedComponent(news);
		 * newsTabs.setSelectedComponent(na); } Game.update(); if
		 * (e.getSource().equals(endb)) { Game.player.passTurn();
		 * Game.gameTurn(); Game.flyerAttacked.clear();
		 * Game.missilesAttacked.clear(); }
		 */
	}
}