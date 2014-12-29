object countries	{
	class country(_Name:String, _Population:Long, _Nukes:Int)	{
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
	private val usaNicks = List("usa", "united states", "us", "america");
	private val sovNicks = List("rus", "russia", "soviets", "soviet union", "russian federation");
	private val fraNicks = List("france", "frogs", "retreaters");
	private val briNicks = List("britain", "united kingdom", "england", "scotland", "north ireland", "wales");
	private val chiNicks = List("china", "communist china");
	usa.setNicks(usaNicks);
	sov.setNicks(sovNicks);
	fra.setNicks(fraNicks);
	bri.setNicks(briNicks);
	chi.setNicks(chiNicks);
}