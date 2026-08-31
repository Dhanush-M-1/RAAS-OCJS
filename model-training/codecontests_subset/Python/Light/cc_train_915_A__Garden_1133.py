n,k = map(int,input().split())
buckets = [int(i) for i in input().split()]

possibleBuckets = []
for i in buckets:
	if i <= k and k % i ==0:
		possibleBuckets.append(i)
		
ans = k / max(possibleBuckets) 
print(int(ans))
		