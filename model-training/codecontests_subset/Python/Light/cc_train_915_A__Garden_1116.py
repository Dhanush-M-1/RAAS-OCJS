i = list(map(int, input().split()))
buckets = list(map(int, input().split()))
n = i[0]
k = i[1]
min = 99999999999999999999999999999
for bucket in buckets:
	if k / bucket < min:
		if k % bucket == 0:
			min = k / bucket
	else:
		pass
print(int(min))