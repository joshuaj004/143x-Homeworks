import java.awt.*;

public class awfulTest{
	public static void main(String[] args){
		/*
		X Must be at least 100x100
		X Contain at least 3 shapes
		X Must use at least 2 distinct colors
		X May not have any infinite loops
		X May not read any user input
		*/
		DrawingPanel panel = new DrawingPanel(100, 138);
		Graphics g = panel.getGraphics();
      g.fillOval(0,1,2,3);
      g.fillRect(4,5,6,7);
      g.fillArc(8,7,10,11,12,13);
      int count = 0;
		String StringLine1, StringLine2, StringLine3, StringLine4, StringLine5, StringLine6, StringLine7, StringLine8, StringLine9, StringLine10, StringLine11, StringLine12, StringLine13, StringLine14, StringLine15, StringLine16, StringLine17, StringLine18, StringLine19, StringLine20, StringLine21, StringLine22, StringLine23, StringLine24, StringLine25, StringLine26, StringLine27, StringLine28, StringLine29, StringLine30, StringLine31, StringLine32, StringLine33, StringLine34, StringLine35, StringLine36, StringLine37, StringLine38, StringLine39, StringLine40, StringLine41, StringLine42, StringLine43, StringLine44, StringLine45, StringLine46, StringLine47, StringLine48, StringLine49, StringLine50, StringLine51, StringLine52, StringLine53, StringLine54, StringLine55, StringLine56, StringLine57, StringLine58, StringLine59, StringLine60, StringLine61, StringLine62, StringLine63, StringLine64, StringLine65, StringLine66, StringLine67, StringLine68, StringLine69, StringLine70, StringLine71, StringLine72, StringLine73, StringLine74, StringLine75, StringLine76, StringLine77, StringLine78, StringLine79, StringLine80, StringLine81, StringLine82, StringLine83, StringLine84, StringLine85, StringLine86, StringLine87, StringLine88, StringLine89, StringLine90, StringLine91, StringLine92, StringLine93, StringLine94, StringLine95, StringLine96, StringLine97, StringLine98, StringLine99, StringLine100;
		StringLine1		 = "999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
		StringLine2		 = "999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
		StringLine3		 = "999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
		StringLine4		 = "999999999999999999999999999999999999999955555555559999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
		StringLine5		 = "999999999999999999999999999999999955555555555555555555555555999999999999999936666888888899999999999999999999999999999999999999999999999999";
		StringLine6		 = "999999999999999999999999999999955555555555555555555555555555555555549996336747663368666668999999999999999999999999999999999999999999999999";
		StringLine7		 = "999999999999999999999999999995555555555555555555555555555555555555151736641446333367886366889999999999999999999999999999999999999999999999";
		StringLine8		 = "999999999999999999999999999555555555555555555555555555555555555555555178411517686368444788887899999999999999999999999999999999999999999999";
		StringLine9		 = "999999999999999999999999995555555555555555555555555555555555555555555551555511448336477887663689999999999999999999999999999999999999999999";
		StringLine10	 = "999999999999999999999999955555555555555555555555555555555555555555555555555555511144783636868887999999999999999999999999999999999999999999";
		StringLine11	 = "999999999999999999999995555555555555555555555555555555555555555555555555555555555551144686366667899999999999999999999999999999999999999999";
		StringLine12	 = "999999999999999999999955555555555555555555555555555555555555555555551111111111111111111114444686699999999999999999999999999999999999999999";
		StringLine13	 = "999999999999999999999555555555555555555555555555555555551555555111414444411111111111111111111111499999999999999999999999999999999999999999";
		StringLine14	 = "999999999999999999995555555555555555555551555111111111151111111414444444444411111111111111111111111199999999999999999999999999999999999999";
		StringLine15	 = "999999999999999999955555555555555555555515511511111111111111114144444444444444411111111111111111111111119999999999999999999999999999999999";
		StringLine16	 = "999999999999999995555555555555555555551111111111111111141111411111444477777777477444111111111111111111111111999999999999999999999999999999";
		StringLine17	 = "999999999999999955555555555555555555115111111414441441411114111144447777787777777777774414444444111111111111119999999999999999999999999999";
		StringLine18	 = "999999999999999555555555555555555511111111111144444444114411111114747777888878888888777444444444444111111111111199999999999999999999999999";
		StringLine19	 = "999999999999995555555555555555551111114141414414144141441111441147477878888888868888888774444444444444441414111119999999999999999999999999";
		StringLine20	 = "999999999999955555555555555511111114441447474444441441111144411477744777778886688688888777444444444474444444444411199999999999999999999999";
		StringLine21	 = "999999999999555555555555555515111414444774747477444444444474411444444174777888866686888877777747747774774744447441119999999999999999999999";
		StringLine22	 = "999999999999555555555555551111114177474477477774777444417774111441444414778888666666688888887777777777777774444744411199999999999999999999";
		StringLine23	 = "999999999995555555555555551511144441447777777777777777477774111744111147787888666666888888888888877778778777774444441119999999999999999999";
		StringLine24	 = "999999999955555555555555515114171144774777777777777777777841114444111177888868686666668688868888888888888888877444414411499999999999999999";
		StringLine25	 = "999999999955555555555555151111117474477777777777777777788841114841111177886666686363666688888686868886888888777747441111149999999999999999";
		StringLine26	 = "999999999555555555555555151114174447747777777777777777886811116641114117866666666336663666686666666666868888888877744441111999999999999999";
		StringLine27	 = "999999999555555555555551511111774777777777777777777888886411446711436477866663663333336366666666666666668888888888877444411199999999999999";
		StringLine28	 = "999999995555555555555511111144417477777777777777787878868411148711333447866633336333333336363636666366668686666666688777441119999999999999";
		StringLine29	 = "999999995555555555555511111471447777777877777777788888668411118641113648666363333333333333336666333366666333633366636888848411999999999999";
		StringLine30	 = "999999955555555555555115111147477777778778777778878888668411117611441447636333333333333333333333333363633666666636666687887441199999999999";
		StringLine31	 = "999999955555555555551111111474777777788887887778787888667411118711111437333663333333333333333333333666668688866666666866888774119999999999";
		StringLine32	 = "999999555555555555551151141747477777888888887878888888687711118411153448333363333333333333333333666866888666668886668868688777441999999999";
		StringLine33	 = "999999555555555555511111417747777777888888888888888886888411118611114346663633333333333333333363688888666636684786888886868884844499999999";
		StringLine34	 = "999995555555555555555111444477777777886888888888888686687411118711444446663333333333336333333668888868666666644877888778868887774449999999";
		StringLine35	 = "999995555555555555551114447777777788888888888888888666667411118711333486886333333333386333666888688686666666847777788878888888776744999999";
		StringLine36	 = "999995555555555555551144474777777878886688888886866886668741117471633488863333333336886366868666668866686636417777488878888886687744999999";
		StringLine37	 = "999955555555555555551744777777778888866666686888666666688874117474167877886333333688866687747786668666866668444777447888888888888884499999";
		StringLine38	 = "999955555555555555554444777777787888666666666666668666666674117747417888863336666877887744444447886886666668444777747888788668688887449999";
		StringLine39	 = "999955555555555555551447777777878886666666666668866666633374417677844788663668888777744477787744868888666667744777744478888688888877749999";
		StringLine40	 = "999955555555555555551777777777788866666663666366666633333384114687837783368888777777778788887474766668663667744777777478888668886888844999";
		StringLine41	 = "999955555555555555551477778777788888666366663366866633333641114867866636688887777777778788867187788786633667711777777447888688886868784999";
		StringLine42	 = "999955555555555555554777787787888886666666666366666333333644411768787887777777477747777787784186788886666687711777777744888688886686884499";
		StringLine43	 = "999555555555555555554777878888788866663666363666663333333374414777777774444447774474444477444173888686668667744777788774788888866668674499";
		StringLine44	 = "999555555555555555555787788878888866666663633663666633333381144777777444444447444447444447777116686888663667744478866744786886666666884499";
		StringLine45	 = "999555555555555555551778878888888666633366333663666633333387788777774447474747774777777777887411887866333337446478766847786666663666688499";
		StringLine46	 = "999555555555555555554778888888886666633633633663666633333366666887888877777777877788878888638871166663666336744778863874776666333363687499";
		StringLine47	 = "999555555555555555551478788888866666636666333633666663333333666666668888888866888888888686336674176666636633744477866844776666366336687499";
		StringLine48	 = "999955555555555555555177778888666666663663333663666663333333333333366688888866666666666633336884443646664333871478866874788666663366684499";
		StringLine49	 = "999955555555555555555177888868686666663663633663366833333333333333336888888888668666666668636874463666666633774178863744788666633366684449";
		StringLine50	 = "999955555555555555555147888888666666666666333633638633333336666636666888877868866888888888888771466633636338771478866747886666366336687439";
		StringLine51	 = "999995555555555555555577887786686866636363636633366863333666666663668877777787777778887888887711888866633368741778888747766666633366684499";
		StringLine52	 = "999995555555555555555177777886866666663663336633366633336666636668744474444444447477778877874118888766866668741487868447886666663333687499";
		StringLine53	 = "999995555555555555555177878888666666633636366633636633333367863847777744744477447444777777774186747866666668711787787448886666663636684499";
		StringLine54	 = "999995555555555555551147888888886666663636638666336633333384467448888774777777774774444777764168777888868668744777884478886686666368684499";
		StringLine55	 = "999995555555555555515147788788868666666666666863666333336874474488887668777777777777444478867188487778888668714777777486866666666666674499";
		StringLine56	 = "999955555555555555555577778878888686666636666666663633333874444688866333668888777777777777887474487788666668414777774868686666866668744999";
		StringLine57	 = "999955555555555555555517788888888888866663666666666633333811117688867766336666688777744447777744788888866666411777747668666668688688744999";
		StringLine58	 = "999955555555555555555117777888878888666636666866666633633711118687774788863333366877777774744147688886886688411777476688866666886684749999";
		StringLine59	 = "999955555555555555555117777878888888666636668668666663333441118844747788786333333368886666887633688886688886417777886888886686886888449999";
		StringLine60	 = "999955555555555555555517777788888888866666666886666666663711118747187787788363333333666633333333667886668666418777866686666666686887499999";
		StringLine61	 = "999955555555555555555514777777878888688866888888866666683411118771433447876636333333336666333333336886666666747778868868868868868874999999";
		StringLine62	 = "999955555555555555555514477777778888886866888788888866683711118471433846886636666333333333333333333688886636344888688886866888664469999999";
		StringLine63	 = "999955555555555555555514747778788888888888888878888866636411118741444667666363363333333333333333333368886636384766688888688668444499999999";
		StringLine64	 = "999995555555555555555554447777778788888888887788788866368411118741114444633333633333333333333333333336888886668666668868686884644999999999";
		StringLine65	 = "999995555555555555555554447777777778887888878778788888668711116411111344663333633333333333333333366666366888686666668866888646449999999999";
		StringLine66	 = "999995555555555555555511144477777788788878887777788886666411118841151464666333333333333333333663333666866688686336686888876444499999999999";
		StringLine67	 = "999999555555555555555511114477777777877787877777778888666411116771111444766636333333333333336636666888888886666366868786444441999999999999";
		StringLine68	 = "999999555555555555555511114444747777777777777777777888668411116771111344766636336333333333366366666668688888888888887744441419999999999999";
		StringLine69	 = "999999555555555555555551511444477777777777777777777888688411118441133674786666663333333333666666666686888777888777874444411119999999999999";
		StringLine70	 = "999999955555555555555551151144447777777777777777778778888111116744163444768666666633333336366666866688888878777777444444441499999999999999";
		StringLine71	 = "999999955555555555555555115114444447777777777777777878868114446844114814768866663636636366668666888888887887787747444444444999999999999999";
		StringLine72	 = "999999995555555555555555511111444477777777777777777778788114447841411114888886866666666666668688888887888777777444444444449999999999999999";
		StringLine73	 = "999999995555555555555555555111444444447777777777777777776411417874111114887888686666366668888888888887877877444474746444499999999999999999";
		StringLine74	 = "999999999555555555555555555511414444774777777777777777778811117844411144778788866666668688888888788787778774778874484449999999999999999999";
		StringLine75	 = "999999999555555555555555555551144444477747777777777777777811111444444444477788866666888888877777777777777777787747744499999999999999999999";
		StringLine76	 = "999999999955555555555555555555111414477774777777777777777771111174444444777888868666688888877777777777874477444444449999999999999999999999";
		StringLine77	 = "999999999955555555555555555555511144444777777777777777474774111148787777788878888888888877777777777744444444444444999999999999999999999999";
		StringLine78	 = "999999999995555555555555555555555111444747777477744444444447411117447778788888888888887777747444444444444444444499999999999999999999999999";
		StringLine79	 = "999999999999555555555555555555555551144144744444444444444444444144777778888878888887877744444444444444444444149999999999999999999999999999";
		StringLine80	 = "999999999999955555555555555555555555511144144414444444444414444444447788787877777777444444414444411414114149999999999999999999999999999999";
		StringLine81	 = "999999999999995555555555555555555555555511414444474474444444144444474777777777747444444444441111144441444999999999999999999999999999999999";
		StringLine82	 = "999999999999999555555555555555555555555551511141744444444444444444777777777744444444414114114444441144999999999999999999999999999999999999";
		StringLine83	 = "999999999999999955555555555555555555555555551111414144444444444477474774744444444441441141441111114999999999999999999999999999999999999999";
		StringLine84	 = "999999999999999995555555555555555555555555555551111411411444444444444444444444444114144414111414643999999999999999999999999999999999999999";
		StringLine85	 = "999999999999999999555555555555555555555555555555555511511111111414444444444444444444111111114786336999999999999999999999999999999999999999";
		StringLine86	 = "999999999999999999955555555555555555555555555555555555555555555155555111111515555555111146488777888899999999999999999999999999999999999999";
		StringLine87	 = "999999999999999999999555555555555555555555555555555555555555555555555555555555555551114444887777778999999999999999999999999999999999999999";
		StringLine88	 = "999999999999999999999955555555555555555555555555555555555555555555555555555555551833688778888888889999999999999999999999999999999999999999";
		StringLine89	 = "999999999999999999999995555555555555555555555555555555555555555555555555555555144763336447448688699999999999999999999999999999999999999999";
		StringLine90	 = "999999999999999999999999555555555555555555555555555555555555555555555555517777866666368747778876999999999999999999999999999999999999999999";
		StringLine91	 = "999999999999999999999999995555555555555555555555555555555555555555555555547778863333338868868799999999999999999999999999999999999999999999";
		StringLine92	 = "999999999999999999999999999555555555555555555555555555555555555555555555173868888633338888766999999999999999999999999999999999999999999999";
		StringLine93	 = "999999999999999999999999999995555555555555555555555555555555555555555544414663688886878886999999999999999999999999999999999999999999999999";
		StringLine95	 = "999999999999999999999999999999999555555555555555555555555555555555555555559999999999999999999999999999999999999999999999999999999999999999";
		StringLine94	 = "999999999999999999999999999999955555555555555555555555555555555555555555555549999999999999999999999999999999999999999999999999999999999999";
		StringLine96	 = "999999999999999999999999999999999999555555555555555555555555555555555555999999999999999999999999999999999999999999999999999999999999999999";
		StringLine97	 = "999999999999999999999999999999999999999555555555555555555555555555555999999999999999999999999999999999999999999999999999999999999999999999";
		StringLine98	 = "999999999999999999999999999999999999999999999555555555555555555559999999999999999999999999999999999999999999999999999999999999999999999999";
		StringLine99	 = "999999999999999999999999999999999999999999999999990555555555559999999999999999999999999999999999999999999999999999999999999999999999999999";
		StringLine100	 = "999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
		stringIntaker(g, StringLine1, count); count++;   stringIntaker(g, StringLine2, count); count++;   stringIntaker(g, StringLine3, count); count++;   stringIntaker(g, StringLine4, count); count++;   stringIntaker(g, StringLine5, count); count++;   stringIntaker(g, StringLine6, count); count++;   stringIntaker(g, StringLine7, count); count++;   stringIntaker(g, StringLine8, count); count++;   stringIntaker(g, StringLine9, count); count++;   stringIntaker(g, StringLine10, count); count++;   stringIntaker(g, StringLine11, count); count++;   stringIntaker(g, StringLine12, count); count++;   stringIntaker(g, StringLine13, count); count++;   stringIntaker(g, StringLine14, count); count++;   stringIntaker(g, StringLine15, count); count++;   stringIntaker(g, StringLine16, count); count++;   stringIntaker(g, StringLine17, count); count++;   stringIntaker(g, StringLine18, count); count++;   stringIntaker(g, StringLine19, count); count++;   stringIntaker(g, StringLine20, count); count++;   stringIntaker(g, StringLine21, count); count++;   stringIntaker(g, StringLine22, count); count++;   stringIntaker(g, StringLine23, count); count++;   stringIntaker(g, StringLine24, count); count++;   stringIntaker(g, StringLine25, count); count++;   stringIntaker(g, StringLine26, count); count++;   stringIntaker(g, StringLine27, count); count++;   stringIntaker(g, StringLine28, count); count++;   stringIntaker(g, StringLine29, count); count++;   stringIntaker(g, StringLine30, count); count++;   stringIntaker(g, StringLine31, count); count++;   stringIntaker(g, StringLine32, count); count++;   stringIntaker(g, StringLine33, count); count++;   stringIntaker(g, StringLine34, count); count++;   stringIntaker(g, StringLine35, count); count++;   stringIntaker(g, StringLine36, count); count++;   stringIntaker(g, StringLine37, count); count++;   stringIntaker(g, StringLine38, count); count++;   stringIntaker(g, StringLine39, count); count++;   stringIntaker(g, StringLine40, count); count++;   stringIntaker(g, StringLine41, count); count++;   stringIntaker(g, StringLine42, count); count++;   stringIntaker(g, StringLine43, count); count++;   stringIntaker(g, StringLine44, count); count++;   stringIntaker(g, StringLine45, count); count++;   stringIntaker(g, StringLine46, count); count++;   stringIntaker(g, StringLine47, count); count++;   stringIntaker(g, StringLine48, count); count++;   stringIntaker(g, StringLine49, count); count++;   stringIntaker(g, StringLine50, count); count++;   stringIntaker(g, StringLine51, count); count++;   stringIntaker(g, StringLine52, count); count++;   stringIntaker(g, StringLine53, count); count++;   stringIntaker(g, StringLine54, count); count++;   stringIntaker(g, StringLine55, count); count++;   stringIntaker(g, StringLine56, count); count++;   stringIntaker(g, StringLine57, count); count++;   stringIntaker(g, StringLine58, count); count++;   stringIntaker(g, StringLine59, count); count++;   stringIntaker(g, StringLine60, count); count++;   stringIntaker(g, StringLine61, count); count++;   stringIntaker(g, StringLine62, count); count++;   stringIntaker(g, StringLine63, count); count++;   stringIntaker(g, StringLine64, count); count++;   stringIntaker(g, StringLine65, count); count++;   stringIntaker(g, StringLine66, count); count++;   stringIntaker(g, StringLine67, count); count++;   stringIntaker(g, StringLine68, count); count++;   stringIntaker(g, StringLine69, count); count++;   stringIntaker(g, StringLine70, count); count++;   stringIntaker(g, StringLine71, count); count++;   stringIntaker(g, StringLine72, count); count++;   stringIntaker(g, StringLine73, count); count++;   stringIntaker(g, StringLine74, count); count++;   stringIntaker(g, StringLine75, count); count++;   stringIntaker(g, StringLine76, count); count++;   stringIntaker(g, StringLine77, count); count++;   stringIntaker(g, StringLine78, count); count++;   stringIntaker(g, StringLine79, count); count++;   stringIntaker(g, StringLine80, count); count++;   stringIntaker(g, StringLine81, count); count++;   stringIntaker(g, StringLine82, count); count++;   stringIntaker(g, StringLine83, count); count++;   stringIntaker(g, StringLine84, count); count++;   stringIntaker(g, StringLine85, count); count++;   stringIntaker(g, StringLine86, count); count++;   stringIntaker(g, StringLine87, count); count++;   stringIntaker(g, StringLine88, count); count++;   stringIntaker(g, StringLine89, count); count++;   stringIntaker(g, StringLine90, count); count++;   stringIntaker(g, StringLine91, count); count++;   stringIntaker(g, StringLine92, count); count++;   stringIntaker(g, StringLine93, count); count++;   stringIntaker(g, StringLine94, count); count++;   stringIntaker(g, StringLine95, count); count++;   stringIntaker(g, StringLine96, count); count++;   stringIntaker(g, StringLine97, count); count++;   stringIntaker(g, StringLine98, count); count++;   stringIntaker(g, StringLine99, count); count++;   stringIntaker(g, StringLine100, count); 
	}
	
	public static void stringIntaker(Graphics g, String str, int count){
		for (int i = 0; i < 138; i++){
			char c = str.charAt(i);
			colorMaker(g, c, count, i);
		}       
	}
	
	public static void colorMaker(Graphics g, char c, int xCoordinate, int yCoordinate){
		if (c == '1'){
			Color a57056 = new Color(165, 112, 86);
			g.setColor(a57056);
			g.drawLine(xCoordinate, yCoordinate, xCoordinate, yCoordinate);
		} else if (c == '7'){
			Color e69777 = new Color(230, 151, 119);
			g.setColor(e69777);
			g.drawLine(xCoordinate, yCoordinate, xCoordinate, yCoordinate);
		} else if (c == '2'){
			Color FAKE = new Color(255, 0, 0);
			g.setColor(FAKE);
			g.drawLine(xCoordinate, yCoordinate, xCoordinate, yCoordinate);
		} else if (c == '6'){
			Color f9ba9e = new Color(249, 186, 158);
			g.setColor(f9ba9e);
			g.drawLine(xCoordinate, yCoordinate, xCoordinate, yCoordinate);
		} else if (c == '5'){
			Color newBlack = new Color(29, 20, 16);
			g.setColor(newBlack);
			g.drawLine(xCoordinate, yCoordinate, xCoordinate, yCoordinate);
		} else if (c == '4'){
			Color c5886d = new Color(197, 136, 109);
			g.setColor(c5886d);
			g.drawLine(xCoordinate, yCoordinate, xCoordinate, yCoordinate);
		} else if (c == '3'){
			Color fccdb5 = new Color(252, 205, 181);
			g.setColor(fccdb5);
			g.drawLine(xCoordinate, yCoordinate, xCoordinate, yCoordinate);
		} else if (c == '8'){
			Color f5a88a = new Color(245, 168, 138);
			g.setColor(f5a88a);
			g.drawLine(xCoordinate, yCoordinate, xCoordinate, yCoordinate);
		} else if (c == '9'){
			g.setColor(Color.WHITE);
			g.drawLine(xCoordinate, yCoordinate, xCoordinate, yCoordinate);
		} else {
			System.out.print("");
		}			
	}
}