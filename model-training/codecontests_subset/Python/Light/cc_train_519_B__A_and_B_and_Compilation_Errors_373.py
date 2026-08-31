n = str(input())
n.split()
n = int(n[0])
a = str(input())
a = a.split()
for i in range(len(a)):
	a[i]=int(a[i])
b = str(input())
b = b.split()
for i in range(len(b)):
	b[i]=int(b[i])
c = str(input())
c = c.split()
for i in range(len(c)):
	c[i]=int(c[i])
def f(l,k):
	l.sort()
	k.sort()
	for h in range(len(l)):
		if(l[h]!=k[h]):
			print(k[h])
			break
	else:
		print(k[((len(k))-1)])
f(b,a)
f(c,b)


