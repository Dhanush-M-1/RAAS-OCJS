inp = str(input()).split(" ")
n = int(inp[0])
m = int(inp[1])


bulbs = list(range(1,m+1))
for i in range(n):
	inp = str(input()).split(" ")
	num = int(inp[0])
	for i in range(1,num+1):
		bulb = int(inp[i])
		if bulb in bulbs:
			bulbs.remove(bulb)
		else:
			continue

if len(bulbs) == 0:
	print("YES")
else:
	print("NO")

	     		  		 	 	  		 		 			  		