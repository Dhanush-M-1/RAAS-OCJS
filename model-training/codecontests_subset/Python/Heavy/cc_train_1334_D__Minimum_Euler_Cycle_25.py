import math
import sys
# input = sys.stdin.readline

T=int(input())
for _ in range(T):
	n,l,r=map(int,input().split())
	size=r-l+1
	run=0
	ans=[]
	for i in range(1,n):
		run+=2*(n-i)
		# print(run)
		if l<=run:
			prev=run-2*(n-i)
			gone=l-prev-1
			size+=gone
			# print(gone)
			cur=0
			now=i
			nex=i+1
			flag=True
			while cur<size:
				if flag:
					if gone>0:
						gone-=1
					else:
						ans.append(now)
					flag=False
				else:
					if gone>0:
						gone-=1
					else:
						ans.append(nex)

					nex+=1
					if nex>n:
						now+=1
						nex=now+1
					flag=True
				cur+=1
			break

	if len(ans)==0:
		ans.append(1)

	if r==n*(n-1)+1:
		ans[-1]=1

	print(*ans)