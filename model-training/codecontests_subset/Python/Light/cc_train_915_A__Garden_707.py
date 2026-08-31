
n, k = map(int, input().split(' '))
buckets = list(map(int, input().split(' ')))

best_bucket = -1
for bucket in buckets:
    if (k % bucket == 0 and bucket > best_bucket):
        best_bucket = bucket


print(int(k / best_bucket))
  		     		 	 	   				  		 				