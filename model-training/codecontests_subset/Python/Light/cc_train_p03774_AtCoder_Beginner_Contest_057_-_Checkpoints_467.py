def mht(a,b):
	return abs(a[0]-b[0])+abs(a[1]-b[1])
n,m=map(int,input().split())
p=[list(map(int,input().split())) for _ in range(n)]
c=[list(map(int,input().split())) for _ in range(m)]
for i in p:
	a=[10**9,0]
	for j in range(m):
		if mht(i,c[j])<a[0]:
			a=[mht(i,c[j]),j+1]
	print(a[1])