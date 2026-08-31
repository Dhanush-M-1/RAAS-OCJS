n_buckets, garden_len = map(int, input().split())
buckets = list(map(int, input().split()))

choice = max(b for b in buckets if garden_len % b == 0)
print(garden_len // choice)
   	   						  	 	 	 			 	 		 	