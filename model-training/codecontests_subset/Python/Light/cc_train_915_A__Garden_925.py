n, k = input().split(' ')
buckets = [int(a) for a in input().split(' ')]

k = int(k)
buckets = reversed(sorted(buckets))
for bucket in buckets:
    if k%bucket == 0:
        print(k//bucket)
        break

 		    	   			  	    	     			