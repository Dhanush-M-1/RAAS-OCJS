n_k = input().split(' ')
n = int(n_k[0])
k = int(n_k[1])
buckets = input().split(' ')
buckets = [int(x) for x in buckets]
buckets.sort(reverse=True)
for bucket in buckets:
    if k%bucket == 0:
        print(k//bucket)
        break

	   	 		 	   		 		    	 		 	 		