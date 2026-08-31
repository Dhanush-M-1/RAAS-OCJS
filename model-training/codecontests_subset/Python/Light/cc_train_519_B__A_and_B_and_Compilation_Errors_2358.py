a = int(input())
b = sum(list(map(int, input().split(" "))))
#print(b)
for i in range(0, 2):
 c = sum(list(map(int, input().split(" "))))
 aux = b - c
 print(aux)
 b = c
	   		 					  				 	 			 			