		var q=parseInt(readline());
	var s="",y=0,l,r,d;
	for(var i=0;i<q;i++){
		s=readline().split(" ");
		l=parseInt(s[0]);r=parseInt(s[1]);d=parseInt(s[2]);
		if(l>d){print(d);}
		else{r++;print(Math.ceil(r/d)*d);}
	}
