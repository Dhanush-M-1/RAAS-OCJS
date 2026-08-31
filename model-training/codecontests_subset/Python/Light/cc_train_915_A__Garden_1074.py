n,k = [int(i) for i in input().split()]
a = [int(i) for i in input().split()]

a = sorted(a)
a = a[::-1]

for i in a:
	if k % i == 0:
		print(int(k/i))
		break
   		   	  	   				 		 	 			 		