n1, k1 = input().split()
k = int(k1)
n = int(n1)
arr = list(map(int, input().split()))
for i in range(n):
	if(k % max(arr) == 0):
		print(k // max(arr))
		break
	arr.remove(max(arr))
 		   	     	    		    						 	