n,l=[int(s) for s in input().split()]
a=[int(s) for s in input().split()]
x=[]
for i in a:
	if (l%i==0):
		x.append(l//i)
print(min(x))