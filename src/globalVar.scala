object globalVar {
	import countries._;
	var nuclear_states: List[country] = List( usa, sov, fra, bri, chi );
	var untargetable_states: List[country] = null; //Change based on what player nation is.
	val df = new java.text.DecimalFormat( "###" ); //For formatting numbers: 1,233,203.
	
	var enemy_states: List[country] = List();
	
	//Need to figure out a way to replace this eventually.
	val NATO: List[country] = List( usa, bri, fra,
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
		gre );
	val WAR: List[country] = List( sov,
		egr,
		bul,
		rom,
		cze,
		hun );
	
	def echo(msg:String) = print(msg+"\n");
};