def answer(a,b,k):
	i = 0
	j = 0
	c = []
	f = True
	while i < len(a) or j < len(b):
		if i < len(a) and a[i] == 0:
			c.append(a[i])
			i += 1
			k += 1
		elif i < len(a) and a[i] <= k:
			c.append(a[i])
			i += 1
		elif j < len(b) and b[j] == 0:
			c.append(b[j])
			j += 1
			k += 1
		elif j < len(b) and b[j] <= k:
			c.append(b[j])
			j += 1
		else:
			f = False
			break
	if f:
		return c
	return [-1]


t = int(input())
for i in range(t):
	s = input()
	k,n,m = map(int,input().split())
	a = list(map(int,input().split()))
	b = list(map(int,input().split()))
	c = answer(a,b,k)
	if c[0] == -1:
		print(-1)
	else:
		print(*c)
