object countries {
	class country( _Name: String, _Population: Long, _Nukes: Int ) { //Nuclear countries.
		var Name = _Name;
		var Pop = _Population;
		var Nukes = _Nukes;
		var max_nukes = 0; //Determined by Defcon level.
		var Defcon = 5; //Lowest level of readiness.
		var Nicks: List[String] = null;

		def attack( enemy: country, nukes: Int ) = {

		};
		def setNicks( names: List[String] ) = Nicks = names;
		def update_max_nukes( max: Int ) = this.max_nukes = max;
		def give_nukes( nukes: Int ) = this.Nukes += nukes;
		def set_nukes( nukes: Int ) = this.Nukes = nukes;
	};

	var usa = new country( "The United States of America", 237000000, 23368 );
	var sov = new country( "The Soviet Union", 277700000, 39197 );
	var fra = new country( "France", 56830000, 360 );
	var bri = new country( "The United Kingdom", 56550000, 422 );
	var chi = new country( "China", 1051000000, 243 );
	//Add more.

	//NICKS IN LOWER CASE: CHANGE USERINPUT TO LOWERCASE BEFORE CHECKING FOR NICKS.
	private val usaNicks = List( "usa", "united states", "us", "america", "the united states of america", "united states of america" );
	private val sovNicks = List( "sov", "rus", "russia", "soviets", "soviet union", "russian federation", "the soviet union" );
	private val fraNicks = List( "fra", "france", "frogs", "retreaters" );
	private val briNicks = List( "bri", "britain", "united kingdom", "england", "scotland", "north ireland", "wales", "the united kingdom" );
	private val chiNicks = List( "chi", "china", "communist china" );
	usa.setNicks( usaNicks );
	sov.setNicks( sovNicks );
	fra.setNicks( fraNicks );
	bri.setNicks( briNicks );
	chi.setNicks( chiNicks );

	//DEPRECATED:
	/*
	class non_nuke_country(_Name:String, _Population:Long)	{
		var Name = _Name;
		var Pop = _Population;
		var Nicks:List[String] = null;
		def setNicks(_Nicks:List[String])	=	{
			Nicks = _Nicks;
		}
	};
	*/

	//NON NUCLEAR COUNTRIES BELOW:
	var wgr = new country( "West Germany", 61020000, 0 ); //Check this for validity.
	var egr = new country( "East Germany", 16568000, 0 ); //Population estimate.
	//add nicks for all below
	var bel = new country( "Belgium", 0, 0 ); //All these have placeholder populations.
	var hol = new country( "The Netherlands", 0, 0 );
	var pol = new country( "Poland", 0, 0 );
	var swi = new country( "Switzerland", 0, 0 );
	var ita = new country( "Italy", 0, 0 );
	var yug = new country( "Yugoslavia", 0, 0 );
	var aus = new country( "Austria", 0, 0 );
	var lux = new country( "Luxembourg", 0, 0 );
	var spa = new country( "Spain", 0, 0 );
	var por = new country( "Portugal", 0, 0 );
	var alb = new country( "Albania", 0, 0 );
	var bul = new country( "Bulgaria", 0, 0 );
	var rom = new country( "Romania", 0, 0 );
	var cze = new country( "Czechoslovakia", 0, 0 );
	var hun = new country( "Hungary", 0, 0 );
	var tur = new country( "Turkey", 0, 0 );
	var nor = new country( "Norway", 0, 0 );
	var den = new country( "Denmark", 0, 0 );
	var swe = new country( "Sweden", 0, 0 );
	var fin = new country( "Finland", 0, 0 );
	var ire = new country( "Ireland", 0, 0 );
	var ice = new country( "Iceland", 0, 0 );
	var mor = new country( "Morocco", 0, 0 );
	var alg = new country( "Algeria", 0, 0 );
	var tun = new country( "Tunisia", 0, 0 );
	var lib = new country( "Libya", 0, 0 );
	var gre = new country( "Greece", 0, 0 );
	var per = new country( "Iran", 0, 0 );
	var irq = new country( "Iraq", 0, 0 );
	var syr = new country( "Syria", 0, 0 );
	var isr = new country( "Israel", 0, 0 );
	var pal = new country( "Palestine", 0, 0 );
	var jor = new country( "Jordan", 0, 0 );
	var afg = new country( "Afghanistan", 0, 0 );
	var pak = new country( "Pakistan", 0, 0 );
	var ind = new country( "India", 0, 0 );

	private val nonNukeNicks: List[List[String]] = List(
		List( "west germany", "west germans", "wger" ), //West germany.
		List( "east germany", "east germans", "eger" ) //East germany.
	);
	private val nonNukeCountries: List[country] = List();
};