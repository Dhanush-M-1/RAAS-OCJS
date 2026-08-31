def func(x):
	return abs(x[0]-k[0])+abs(x[1]-k[1])


N,M=map(int,input().split())
s = []
for i in range(N):
	a,b=map(int,input().split())
	s.append((a,b))

t=[]
for i in range(M):
	a,b=map(int,input().split())
	t.append((a,b))

for k in s:
	print(1+t.index(min(t, key=func)))
