
n,m=map(int,input().split())
a=set()
for i in range(n):
	x=list(map(int,input().split()))[1:]
	for i in x:
		a.add(i)

# print(a)
if len(a)==m:
	print("YES")
else:
	print("NO")