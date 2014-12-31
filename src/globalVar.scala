object globalVar	{
	import countries._;
	var nuclear_states:List[country] = List(usa, sov, fra, bri, chi);
	var untargetable_states:List[country] = null; //Change based on what player nation is.
	val df = new java.text.DecimalFormat("###"); //For formatting numbers: 1,233,203.
	//Obsolete: val playableNations:List[country] = nuclear_states; //Using a different value because nuclear_states may change based on date of game.
	var player = new country("",0,0);	
}