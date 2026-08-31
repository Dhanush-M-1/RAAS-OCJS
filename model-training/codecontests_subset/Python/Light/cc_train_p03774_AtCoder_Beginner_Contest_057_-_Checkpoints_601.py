N,M = map(int,input().split())

Seito = [tuple(map(int,input().split())) for i in range(N)]

Check = [tuple(map(int,input().split())) for i in range(M)]

for a,b in Seito:
	dist = [abs(a-c)+abs(b-d) for c,d in Check]
	print(dist.index(min(dist))+1)
