n, k = [int(t) for t in input().split()]
a = [-int(t) for t in input().split()]
a.sort()
i = 0
while k % a[i]:
	i += 1
print(-k // a[i])
