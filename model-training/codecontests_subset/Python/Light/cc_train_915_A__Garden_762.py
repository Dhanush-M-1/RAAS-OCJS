def garden(buckets,k):
    hours = 1000
    for item in buckets:
        if k % item == 0:
            if k / item < hours:
                hours = int(k / item)

    print(hours)


inp = list(map(int,input().split()))
n = inp[0]
k = inp[1]
buckets = list(map(int,input().split()))
garden(buckets, k)
  	    		        	  	 				 	  	