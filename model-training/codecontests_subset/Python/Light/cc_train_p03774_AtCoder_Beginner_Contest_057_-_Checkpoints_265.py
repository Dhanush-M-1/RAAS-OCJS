N,M=map(int,input().split())
S=[list(map(int,input().split())) for _ in range(N)]
C=[list(map(int,input().split())) for _ in range(M)]
for a,b in S:
	m=10**9
	cnt=0
	for c,d in C:
		l=abs(c-a)+abs(d-b)
		cnt+=1
		if m>l:
			m=min(m,l)
			ans=cnt
	print(ans)