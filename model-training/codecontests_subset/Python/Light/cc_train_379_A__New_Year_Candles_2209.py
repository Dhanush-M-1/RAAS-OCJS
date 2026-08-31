a,b = list(map(int,input().split()));

burnt = a;
partially_burnt = 0;
hours = a;

while ( burnt > b - 1 ):

#	temp = partially_burnt;
	partially_burnt = (burnt%b) ;
	hours += burnt//b;
	#print ( "burnt" + " " + str(burnt) )  ;
	#print ( "partially_burnt" + " " + str(partially_burnt) );
	burnt = burnt//b + partially_burnt;
	#partially_burnt = partially_burnt%b;
	

print ( int(hours) );
