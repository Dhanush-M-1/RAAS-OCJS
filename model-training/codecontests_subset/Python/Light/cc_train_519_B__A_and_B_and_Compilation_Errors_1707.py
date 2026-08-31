from collections import Counter

n = int(input())

errors0 = list(map(int, input().split(" ")))
errors1 = list(map(int, input().split(" ")))
errors2 = list(map(int, input().split(" ")))

errors0 = list((Counter(errors0) - Counter(errors1)).elements())
errors1 = list((Counter(errors1) - Counter(errors2)).elements())

print(errors0[0])
print(errors1[0])
  		 	      			  	    	 	 	  	