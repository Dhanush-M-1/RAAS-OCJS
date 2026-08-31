n,m=map(int,input().split())
ans=[]
for i in range(n):
	t=[]
	t+=map(int,input().split())
	for j in range(1,len(t)):
		if  t[j] not in ans:
			ans.append(t[j])
if  len(ans)==m:
	print('YES')
else:
	print("NO")
	