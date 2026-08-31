
n, k = list(map(int,input().split()))
buckets = list(map(int,input().split()))

buckets.sort()
min_time = 0
for b in buckets:
    if k%b == 0:
        min_time = k//b

print(min_time)
		   		 	  		 		 		  	 		 	 	 	