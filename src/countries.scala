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
	private val usaNicks = List("usa", "united states", "us", "america", "the united states of america");
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
	var wger = new non_nuke_country("West Germany", 61020000); //Check this for validity.
	var eger = new non_nuke_country("East Germany", 16568000); //Population estimate.
	var bel = new non_nuke_country("Belgium", 0);			   //All these have placeholder populations.
	var hol = new non_nuke_country("The Netherlands", 0);
	var pol = new non_nuke_country("Poland", 0);
	
	
	private val nonNukeNicks:List[List[String]] = List(
	List("west germany", "west germans", "wger"),	//West germany.
	List("east germany", "east germans", "eger")	//East germany.
	);
}