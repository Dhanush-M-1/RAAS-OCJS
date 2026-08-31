import heapq as hq
from heapq import heappop,heappush
from collections import deque,defaultdict,Counter
from sys import stdin,stdout


def inp():
	return int(stdin.readline())


def inlt():
	return list(map(int,stdin.readline().split()))


def insr():
	return list(stdin.readline().strip())


def invr():
	return map(int,stdin.readline().split())


def pr(n):
	stdout.write(str(n)+"\n")


def subset_sum_count(arr,n,sum):
	dp=[[0 for _ in range(sum+1)] for _ in range(n+1)]
	for i in range(n+1):
		for j in range(sum+1):
			if j==0:
				dp[i][j]=1
			elif arr[i-1]<=j:
				dp[i][j]=dp[i-1][j-arr[i-1]]+dp[i-1][j]
			else:
				dp[i][j]=dp[i-1][j]
	return dp[n][sum]


def prefix(a):
	pre=[]
	pre.append(a[0])
	for i in range(1,len(a)):
		pre.append(pre[i-1]+a[i])
	return pre


def binary_search(func,lo,hi,abs_prec=1e-7):
	""" Locate the first value x s.t. func(x) = True within [lo, hi] """
	while abs(hi-lo)>abs_prec:
		mi=lo+(hi-lo)/2
		if func(mi):
			hi=mi
		else:
			lo=mi
	
	return (lo+hi)/2


def ternary_search(func,lo,hi,abs_prec=1e-7):
	""" Find maximum of unimodal function func() within [lo, hi] """
	while abs(hi-lo)>abs_prec:
		lo_third=lo+(hi-lo)/3
		hi_third=hi-(hi-lo)/3
		
		if func(lo_third)<func(hi_third):
			lo=lo_third
		else:
			hi=hi_third
	
	return (lo+hi)/2


def discrete_binary_search(func,lo,hi):
	""" Locate the first value x s.t. func(x) = True within [lo, hi] """
	while lo<hi:
		mi=lo+(hi-lo)//2
		if func(mi):
			hi=mi
		else:
			lo=mi+1
	
	return lo


def discrete_ternary_search(func,lo,hi):
	""" Find the first maximum of unimodal function func() within [lo, hi] """
	while lo<=hi:
		lo_third=lo+(hi-lo)//3
		hi_third=lo+(hi-lo)//3+(1 if 0<hi-lo<3 else (hi-lo)//3)
		
		if func(lo_third)<func(hi_third):
			lo=lo_third+1
		else:
			hi=hi_third-1
	
	return lo
	
	return -1


def right_rotate(a,s):
	return a[s:]+a[:s]


def dec_to_bin(x):
	return int(bin(x)[2:])


def str_to_integer_list(n):
	a=[]
	for i in range(len(n)):
		a.append(int(n[i]))
	return a


def list_to_str(l):
	s=""
	for i in l:
		s+=str(i)
	return s


def dijkstra(s,N,E):
	visited=set()
	dist={}
	for i in range(1,N+1):
		dist[i]=1<<29
	queue=[(dist[i],i) for i in range(1,N+1)]
	hq.heappush(queue,(0,s))
	dist[s]=0
	while queue:
		d,u=hq.heappop(queue)
		if u in visited:
			continue
		#Relax all the neighbours of u
		for t in E[u]:
			v,r=t
			if dist[v]>d+r:
				dist[v]=d+r
				hq.heappush(queue,(dist[v],v))
		#Node u has been processed
		visited.add(u)
	return dist


def prime_sieve(n):
	"""returns a sieve of primes >= 5 and < n"""
	flag=n%6==2
	sieve=bytearray((n//3+flag>>3)+1)
	for i in range(1,int(n**0.5)//3+1):
		if not (sieve[i>>3]>>(i&7))&1:
			k=(3*i+1)|1
			for j in range(k*k//3,n//3+flag,2*k):
				sieve[j>>3]|=1<<(j&7)
			for j in range(k*(k-2*(i&1)+4)//3,n//3+flag,2*k):
				sieve[j>>3]|=1<<(j&7)
	return sieve


def prime_list(n):
	"""returns a list of primes <= n"""
	res=[]
	if n>1:
		res.append(2)
	if n>2:
		res.append(3)
	if n>4:
		sieve=prime_sieve(n+1)
		res.extend(3*i+1|1 for i in range(1,(n+1)//3+(n%6==1)) if not (sieve[i>>3]>>(i&7))&1)
	return res


def dijkstra(n,graph,start):
	""" Uses Dijkstra's algortihm to find the shortest path between in a graph. """
	dist,parents=[float("inf")]*n,[-1]*n
	dist[start]=0
	
	queue=[(0,start)]
	while queue:
		path_len,v=heappop(queue)
		if path_len==dist[v]:
			for w,edge_len in graph[v]:
				if edge_len+path_len<dist[w]:
					dist[w],parents[w]=edge_len+path_len,v
					heappush(queue,(edge_len+path_len,w))
	
	return dist,parents


def path(start,end,parent):
	path=[end]
	while path[-1]!=start:
		path.append(parent[path[-1]])
	path.reverse()
	return path


def bfs(graph,start,end):
	parent={}
	queue=[]
	queue.append(start)
	while queue:
		node=queue.pop(0)
		if node==end:
			return path(start,end,parent)
		for next in graph.get(node,[]):
			if node not in queue:
				parent[next]=node
				queue.append(next)


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
def most_frequent(List):
    return max(set(List), key = List.count)


def subarray(arr,n):
	ans,temp=1,1
	
	# Traverse the array
	for i in range(1,n):
		
		# If element is same as previous
		# increment temp value
		if arr[i]==arr[i-1]:
			temp=temp+1
		else:
			ans=max(ans,temp)
			temp=1
	
	ans=max(ans,temp)
	
	# Return the required answer
	return ans
s=input()
l=[]
for i in range(0,len(s),2):
	l.append(int(s[i]))
l.sort()
s=""
for i in l:
	if i==1:
		s+="1+"
	elif i==2:
		s+="2+"
	else:
		s+="3+"
print(s[:len(s)-1])



