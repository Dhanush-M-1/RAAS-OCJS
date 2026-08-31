import math as mt
I=lambda:list(map(int,input().split()))
mod=10**9
n,=I()
l=I()
x=0
y=0
temp=l[0]
for i in range(1,n):
	temp=mt.gcd(temp,l[i])
N=10**6+3
ss=[0]*(N)
ss[0]=1
for i in range(2,N):
	if ss[i]==0:
		ss[i]=i
		for j in range(2*i,N,i):
			ss[j]=i
if temp!=1:
	print("not coprime")
else:
	pos=1
	visi=[0]*N
	for i in range(n):
		now=l[i]
		while now>1:
			te=ss[now]
			if visi[te]:
				pos=0
				break
			while now%te==0:
				now//=te
			visi[te]=1
		if not pos:
			break
	if pos:
		print("pairwise coprime")
	else:
		print("setwise coprime")
