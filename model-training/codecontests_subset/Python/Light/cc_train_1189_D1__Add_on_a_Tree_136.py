n = int(input())
adj = [0 for i in range(n)]
for i in range(n-1):
	iarr = list(map(int,input().split()))
	u = iarr[0]-1
	v = iarr[1]-1
	adj[u]+=1
	adj[v]+=1
flag = 0
for i in adj:
	if i==2:
		flag=1
		break
if flag==1:
	print("NO")
else:
	print("YES")
