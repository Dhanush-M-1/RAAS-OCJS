n,m = map(int,input().split())
l = {i for i in range(1,m+1)}
for i in range(n):
	k =set(map(int,input().split()[1:]))
	l = l-k
if len(l)==0:
	print("YES")
else:
	print("NO")