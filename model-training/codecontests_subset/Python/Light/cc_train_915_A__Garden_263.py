n, k = map(int, input().split())
buckets = list(map(int, input().split()))

buckets.sort(reverse=True)

for b in buckets:
    if k%b == 0:
        print(int(k/b))
        break
  		 	    						 			 	 	  	 			