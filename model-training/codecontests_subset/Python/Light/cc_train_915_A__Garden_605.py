#http://codeforces.com/problemset/problem/915/A
numBuckets, garLen = map(int, input().split())
buckets = list(map(int,input().split()))
biggest = 0

for x in buckets:
	if(garLen%x == 0 and x > biggest):
		biggest = x
	else:
		pass

print(int(garLen/biggest))