object countries	{
	class country(_Name:String, _Population:Long, _Nukes:Int)	{	//Nuclear countries.
		var Name = _Name;
		var Pop = _Population;
		var Nukes = _Nukes;
		var Nicks:List[String] = null;

		def attack(enemy:country, nukes:Int) =	{

		};
		def setNicks(names:List[String])	{
			Nicks = names;
		}

	};

	var usa = new country("The United States of America", 237000000, 23368);
	var sov = new country("The Soviet Union", 277700000, 39197);
	var fra = new country("France", 56830000, 360);
	var bri = new country("The United Kingdom", 56550000, 422);
	var chi = new country("China", 1051000000, 243);
	//Add more.

	//NICKS IN LOWER CASE: CHANGE USERINPUT TO LOWERCASE BEFORE CHECKING FOR NICKS.
	private val usaNicks = List("usa", "united states", "us", "america", "the united states of america", "united states of america");
	private val sovNicks = List("sov", "rus", "russia", "soviets", "soviet union", "russian federation", "the soviet union");
	private val fraNicks = List("fra", "france", "frogs", "retreaters");
	private val briNicks = List("bri", "britain", "united kingdom", "england", "scotland", "north ireland", "wales", "the united kingdom");
	private val chiNicks = List("chi", "china", "communist china");
	usa.setNicks(usaNicks);
	sov.setNicks(sovNicks);
	fra.setNicks(fraNicks);
	bri.setNicks(briNicks);
	chi.setNicks(chiNicks);

	class non_nuke_country(_Name:String, _Population:Long)	{
		var Name = _Name;
		var Pop = _Population;
		var Nicks:List[String] = null;
		def setNicks(_Nicks:List[String])	=	{
			Nicks = _Nicks;
		}
	};
	//Reorganize these into west aligned vs east aligned or region by region basis.
	var wgr = new non_nuke_country("West Germany", 61020000); //Check this for validity.
	var egr = new non_nuke_country("East Germany", 16568000); //Population estimate.
	//add nicks for all below
	var bel = new non_nuke_country("Belgium", 0);			   //All these have placeholder populations.
	var hol = new non_nuke_country("The Netherlands", 0);
	var pol = new non_nuke_country("Poland", 0);
	//new
	var swi = new non_nuke_country("Switzerland", 0);
	var ita = new non_nuke_country("Italy", 0);
	var yug = new non_nuke_country("Yugoslavia", 0);
	var aus = new non_nuke_country("Austria", 0);
	var lux = new non_nuke_country("Luxembourg", 0);
	var spa = new non_nuke_country("Spain", 0);
	var por = new non_nuke_country("Portugal", 0);
	var alb = new non_nuke_country("Albania", 0);
	var bul = new non_nuke_country("Bulgaria", 0);
	var rom = new non_nuke_country("Romania", 0);
	var cze = new non_nuke_country("Czechoslovakia", 0);
	var hun = new non_nuke_country("Hungary", 0);
	var tur = new non_nuke_country("Turkey", 0);
	var nor = new non_nuke_country("Norway", 0);
	var den = new non_nuke_country("Denmark", 0);
	var swe = new non_nuke_country("Sweden", 0);
	var fin = new non_nuke_country("Finland", 0);
	var ire = new non_nuke_country("Ireland", 0);
	var ice = new non_nuke_country("Iceland", 0);
	var mor = new non_nuke_country("Morocco", 0);
	var alg = new non_nuke_country("Algeria", 0);
	var tun = new non_nuke_country("Tunisia", 0);
	var lib = new non_nuke_country("Libya", 0);
	var gre = new non_nuke_country("Greece", 0);
	//New 2015-01-05
	var per = new non_nuke_country("Iran", 0);
	var irq = new non_nuke_country("Iraq", 0);
	var syr = new non_nuke_country("Syria", 0);
	var isr = new non_nuke_country("Israel", 0);
	var pal = new non_nuke_country("Palestine", 0);
	var jor = new non_nuke_country("Jordan", 0);
	var afg = new non_nuke_country("Afghanistan", 0);
	var pak = new non_nuke_country("Pakistan", 0);
	var ind = new non_nuke_country("India", 0);


	private val nonNukeNicks:List[List[String]] = List(
	List("west germany", "west germans", "wger"),	//West germany.
	List("east germany", "east germans", "eger")	//East germany.
	);
	private val nonNukeCountries:List[non_nuke_country] = List();
};
