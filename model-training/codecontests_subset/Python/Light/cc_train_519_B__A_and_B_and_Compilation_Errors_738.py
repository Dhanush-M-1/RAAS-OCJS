from collections import Counter
n = input()

l1 = list(input().split())
l2 = list(input().split())
l3 = list(input().split())
res_1 = list((Counter(l1) - Counter(l2)).elements())
res_2 = list((Counter(l2) - Counter(l3)).elements())

for i in res_1 :
   print(int(i))
for i in res_2 :
   print(int(i))
 	 	 		 		  	 		  				 			   		