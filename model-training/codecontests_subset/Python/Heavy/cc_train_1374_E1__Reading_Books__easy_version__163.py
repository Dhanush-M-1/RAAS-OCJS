n, k = map(int, input().split())
a, b, c = [], [], []
for i in range(n):
	t, x, y = map(int, input().split())
	if x==1 and y==1:
		a.append(t)
	if x==1 and y==0:
		b.append(t)
	if x==0 and y==1:
		c.append(t)

a.sort()
b.sort()
c.sort()

prea, preb, prec = 0, 0, 0
cnt = min(len(b), len(c), k)
for i in range(cnt):
	preb += b[i]
	prec += c[i]

bestans = int(2e9 + 5)
if cnt==k:
	bestans = preb + prec
for both in range(min(len(a), k)):
	prea += a[both]
	idx = k - both - 1
	#print(idx, cnt)
	if idx<cnt:
		preb -= b[idx]
		prec -= c[idx]
	if idx-1<cnt and prea+preb+prec < bestans:
		bestans = prea+preb+prec

print(bestans) if bestans<=int(2e9) else print(-1)


