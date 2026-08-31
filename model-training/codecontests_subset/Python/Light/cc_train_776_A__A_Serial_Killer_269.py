m = set([i for i in input().split()])
n = int(input())
l = [set([i for i in input().split()]) for i in range(n)]
print(*m)
for i in l:
	m ^= i
	print(*m)


