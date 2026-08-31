def getPar(x):
	while (p[x] != x):
		x = p[x]
	return x
 
def union(x,y):
	p1 = getPar(x)
	p2 = getPar(y)
	p[p2] = p1
 
n = int(input())
p = [i for i in range(n+1)]  
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
for i in p[1:]:
    s.append(getPar(i))   # To get representative of every component
    
s=list(set(s))
print(len(e))
for i in range(len(e)):
	print(e[i][0],e[i][1],s[i],s[i+1])
	
