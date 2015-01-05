object globalVar	{
	import countries._;
	var nuclear_states:List[country] = List(usa, sov, fra, bri, chi);
	var untargetable_states:List[country] = null; //Change based on what player nation is.
	val df = new java.text.DecimalFormat("###"); //For formatting numbers: 1,233,203.
	//Obsolete: val playableNations:List[country] = nuclear_states; //Using a different value because nuclear_states may change based on date of game.
	var player = new country("",0,0);
	var enemy_states_nuclear:List[country] = List();
	var enemy_states_non_nuke:List[non_nuke_country] = List();

	//This is rather dumb. Only set up this way due to the way I have set up the difference between nuclear states and non nuclear states. Should revise it.
	val NATOh:List[country] = List( usa, bri, fra );	//NATO head( nuclear )
	val NATOb:List[non_nuke_country] = List(			//NATO body( non nuclear )
		wgr,
		hol,
		bel,
		lux,
		nor,
		ita,
		spa,
		por,
		ice,
		tur,
		gre
	);
	val NATO:List[List[Any]] = List(	//Combined List
		NATOh,
		NATOb
	);

	val WARh:List[country] = List( sov );		//WARSAW head ( nuclear )
	val WARb:List[non_nuke_country] = List(		//WARSAW body ( non nuclear )
		egr,
		bul,
		rom,
		cze,
		hun

	);
	val WAR:List[List[Any]] = List(		//Combined List
		WARh,
		WARb
	);
};
