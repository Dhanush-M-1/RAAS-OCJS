# import sys 
# sys.stdin = open('input.txt', 'r')  
# sys.stdout = open('output.txt', 'w')


def getPar(x):
	while (a[x] != x):
		x = a[x]
	return x

def union(x,y):
	p1 = getPar(x)
	p2 = getPar(y)
	a[p2] = p1

n = int(input())
a = [i for i in range(n+1)]
e = []

for _ in range(n-1):
	u,v = map(int,input().split())
	p1 = getPar(u)
	p2 = getPar(v)
	if (p1 == p2):
		e.append([u,v])
	else:
		union(u,v)

s = []
for i in a[1:]:
    s.append(getPar(i))
s=list(set(s))
print(len(e))
for i in range(len(e)):
	print(e[i][0],e[i][1],s[i],s[i+1])