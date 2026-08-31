n,m = map(int,input().split())
c =[]
for i in range(n):
	a,*b = list(map(int,input().split()))
	z = b.copy()
	c = c +z
if m == len(set(c)):
	print("YES")
else:
	print("NO")