n,m=[int(x) for x in input().split()]
a=[]
for i in range(n):
	b=[int(x) for x in input().split()]
	b.pop(0)
	a=a+b
c={x for x in range(1,m+1)}
if set(a)==c:
	print("YES")
else:
	print("NO")