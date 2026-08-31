n, k = list(map(int, input().split(" ")))

buckets = list(map(int, input().split(" ")))
buckets.sort(reverse = True)

for i in range(n):
    if k % buckets[i] == 0:
        print(int(k/buckets[i]))
        break
   						 					 			  				    		