def solve():
	x1,y1,x2,y2,x3,y3 = map(int,input().split());
	a = [x1,y1];
	b = [x2,y2];
	c = [x3,y3];
	if(x1-x2>=0):
		angular1 = (y1-y2)/((x1-x2)+0.000001);
	elif(x1-x2<0):
		angular1 = (y1-y2)/((x1-x2)-0.000001);
	if(x2-x3>=0):
		angular2 = (y2-y3)/((x2-x3)+0.000001);
	elif(x2-x3<0):
		angular2 = (y2-y3)/((x2-x3)-0.000001);
	#print(angular1,angular2);
	res = False;
	alinhado = False;
	if angular1==angular2:
		alinhado = True;
	dAB = (a[0]-b[0])**2 + (a[1]-b[1])**2
	dAC = (a[0]-c[0])**2 + (a[1]-c[1])**2
	dBC = (c[0]-b[0])**2 + (c[1]-b[1])**2
	if(dAB==dBC):
		res = True;
	if(res and not alinhado):
		print("Yes")
	else:
		print("No")
solve()