from collections import Counter


input()

l1 = list(map(int, input().split()))
c1 = Counter(l1)

l2 = list(map(int, input().split()))
c2 = Counter(l2)
print(list(c1 - c2)[0])

l3 = list(map(int, input().split()))
c3 = Counter(l3)
print(list(c2 - c3)[0])
 	  	  	 			 			 	 		    	   	