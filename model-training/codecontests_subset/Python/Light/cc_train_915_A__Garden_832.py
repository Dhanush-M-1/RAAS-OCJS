# https://vjudge.net/contest/364837#problem/B
n, k = map(lambda x: int(x), input().split(' '))
buckets = list(map(lambda x: int(x), input().split(' ')))

buckets = sorted(buckets, reverse=True)
for b in buckets:
    if k % b == 0:
        print(int(k/b))
        break

 	 	 		  		 		 	 								 	 	