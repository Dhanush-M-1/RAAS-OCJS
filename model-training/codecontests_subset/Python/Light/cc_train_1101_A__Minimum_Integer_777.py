q = int(input())

for i in range(q):
	l, r, d = [int(x) for x in input().split()]
	
	if d < l:
		print(d)
	elif d >= l:
		aux = ((r // d) + 1) * d
		print(aux)
	
	
	

		 		   	 					    	 		 			 	