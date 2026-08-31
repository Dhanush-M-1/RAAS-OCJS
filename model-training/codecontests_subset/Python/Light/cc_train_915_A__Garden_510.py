n, k = [int(f) for f in input().split(' ') if f]
d = [int(f) for f in input().split(' ') if f]
result = k + 1
for i in range(len(d)):
	if k % d[i] == 0:
		result = min(result, k // d[i])
print(result)