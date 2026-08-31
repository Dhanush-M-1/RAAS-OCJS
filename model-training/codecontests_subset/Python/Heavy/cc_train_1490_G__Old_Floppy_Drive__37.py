import sys

zz=1
 
sys.setrecursionlimit(10**5)
if zz:
	input=sys.stdin.readline
else:	
	sys.stdin=open('input.txt', 'r')
	sys.stdout=open('all.txt','w')
di=[[-1,0],[1,0],[0,1],[0,-1]]

def fori(n):
	return [fi() for i in range(n)]	
def inc(d,c,x=1):
	d[c]=d[c]+x if c in d else x
def ii():
	return input().rstrip()	
def li():
	return [int(xx) for xx in input().split()]
def fli():
	return [float(x) for x in input().split()]	
def dadd(d,p,val):
	if p in d:
		d[p].append(val)
	else:
		d[p]=[val]		
def gi():	
	return [xx for xx in input().split()]
def gtc(tc,ans):
	print("Case #"+str(tc)+":",ans)	
def cil(n,m):
	return n//m+int(n%m>0)	
def fi():
	return int(input())
def pro(a): 
	return reduce(lambda a,b:a*b,a)		
def swap(a,i,j): 
	a[i],a[j]=a[j],a[i]	
def si():
	return list(input().rstrip())	
def mi():
	return 	map(int,input().split())			
def gh():
	sys.stdout.flush()
def isvalid(i,j,n,m):
	return 0<=i<n and 0<=j<m 
def bo(i):
	return ord(i)-ord('a')	
def graph(n,m):
	for i in range(m):
		x,y=mi()
		a[x].append(y)
		a[y].append(x)


t=fi()
uu=t




while t>0:
	t-=1
	n,q=mi()
	a=li()
	pre=[0]
	m=[]
	for i in a:
		pre.append(pre[-1]+i)
	pre.pop(0)
	m=[pre[0]]
	for i in range(1,n):
		m.append(max(m[-1],pre[i]))
	p=li()	
	for i in range(q):	
		c=pre[-1]
		x=p[i]
		if c<=0 and m[-1]<x:
			print(-1,end=" ")
			continue
		l=cur=0
		r=x
		#print(x)
		while l<=r:
			mid=(l+r)//2
			if mid*c<x-m[-1]:
				l=mid+1
			else:
				cur=mid
				r=mid-1		
		ans=cur*n
		x-=cur*c
		l=cur=0
		r=n-1
		while l<=r:
			mid=(l+r)//2
			if m[mid]<x:
				l=mid+1
			else:
				cur=mid
				r=mid-1
		ans+=cur+1

		print(ans-1,end=" ")
	print()	