t=0;
n=0;
while (c=readline(),c!=null) {
	if (c[0]==="+") n++;
	else if (c[0]==="-") n--;
	else {
		t+=(c.length-c.search(":")-1)*n;
	}
}
print(t);
