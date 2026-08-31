line = input().split()
num_buckets = int(line[0])
length = int(line[1])

ans = 0
line = input().split()
for bucket in line:
    bucket_size = int(bucket)
    if length % bucket_size == 0:
        ans = max(ans, bucket_size)

print(length // ans)
	 		     	 		 	  	 					 	  		