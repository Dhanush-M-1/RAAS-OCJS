n, k = [int(x) for x in input().split()]
b = sorted([int(x) for x in input().split()])

for i in b[::-1]:
    if k % i == 0:
        print(int(k/i))
        break

	  	 	     		 		 	 			   	 	 	