if __name__ == '__main__':
    n_buckets, length = [int(i) for i in input().split()]
    buckets = [int(i) for i in input().split()]
    buckets.sort()
    for i in range(len(buckets)-1, -1, -1):
        if length % buckets[i] == 0:
            print(int(length / buckets[i]))
            break

				 		       	 	 	 		  	  				