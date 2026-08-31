n, k = list(map(int, input().split(' ')))
buckets = list(map(int, input().split(' ')))

buckets.sort(reverse=True)

for a in buckets:
    if not k%a:
        print(k//a)
        break

 		  					 		  	 			   	  	