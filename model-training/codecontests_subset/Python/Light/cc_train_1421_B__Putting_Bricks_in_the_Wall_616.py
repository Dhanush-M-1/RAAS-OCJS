import sys
input = sys.stdin.readline
I = lambda : list(map(int,input().split()))

t,=I()
for _ in range(t):
	n,=I()
	l=[input().strip() for i in range(n)]
	an=[]
	le=[0,0,1,1,1];p=[1,1,0,0,0]
	rq=[l[0][1],l[1][0],l[1][1],l[2][0],l[0][2]]
	pos=[[1,2],[2,1],[2,2],[3,1],[1,3]]
	ct=cp=0;a1=[]
	for i in range(5):
		if le[i]!=int(rq[i]):
			ct+=1
			a1.append(pos[i])
	for i in range(5):
		if p[i]!=int(rq[i]):
			cp+=1
			an.append(pos[i])
	if ct<=cp:
		an=a1
	print(len(an))
	for i in an:
		print(*i)