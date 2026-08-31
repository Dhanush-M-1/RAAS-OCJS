n = int(input())
data = [int(s) for s in input().split()]

change = 0
new = []
for idx in range(n):
	idx_min = data[idx:].index(min(data[idx:])) + idx
	if idx_min > idx:
		data[idx],data[idx_min] = data[idx_min],data[idx]
		change += 1

print(' '.join([str(d) for d in data]))
print(change)