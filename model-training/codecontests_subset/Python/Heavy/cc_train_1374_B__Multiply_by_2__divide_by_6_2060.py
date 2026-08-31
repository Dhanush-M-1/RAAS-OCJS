def inp():
	return (int(input()))


def inlt():
	return (list(map(int,input().split())))


def insr():
	s=input()
	return (list(s[:len(s)]))


def invr():
	return (map(int,input().split()))


'''for _ in range(int(input())):
	n,m=list(map(int,input().split()))
	graph=defaultdict(list)
	distance=[-1]*(n+1)
	visited=[False]*(n+1)
	for _ in range(m):
		x,y=list(map(int,input().split()))
		graph[x].append(y)
		graph[y].append(x)'''

'''for _ in range(int(input())):
	n,m=list(map(int,input().split()))
	graph=[[]for _ in range(n+1)]
	distance=[-1]*(n+1)
	visited=[False]*(n+1)
	for _ in range(m):
		x,y,w=list(map(int,input().split()))
		graph[x].append([y,w])
		graph[y].append([x,w])'''

for _ in range(inp()):
	n=inp()
	c=0
	while n%6==0:
		c+=1
		n//=6
	while n%3==0:
		c+=2
		n//=3
	if n==1:
		print(c)
	else:
		print(-1)
		
		