n = int(input())
string = input()
t = string[0]
countTemp = 0
count = 0
stringFinal = ""

for i in range(1,n):
	t += string[i];
	t = t[-2] + t[-1]
	temp = string[i-1]
	#if ( t == "ab"):
	#	print ("t :" +t)
	#	print("i :" + str(i))
	for j in range(i,n):
		temp += string[j]
		temp = temp[-2] + temp[-1]
		#if ( i == 1):
			#print ( "temp :" + temp )
			#print ( "i : " + str(i), "j :" + str(j))
		#	print (temp)
		if ( temp == t ):
			countTemp += 1
	if ( countTemp > count ):
		count = countTemp
		stringFinal = t;
	countTemp = 0
print (stringFinal)