def wizard():
	k = 3
	n, x, y = list(map(int,input().strip().split()))[:k]
	c = int((-1*((n*y)/100- x ))//1*-1) 
	if c > 0 :
	    return c
	else:
	    return 0

print(wizard())