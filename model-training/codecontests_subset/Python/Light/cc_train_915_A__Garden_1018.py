# import sys
# sys.stdin=open("input.in",'r')
# sys.stdout=open("output4.out",'w')
n,k=map(int,input().split())
a=list(map(int,input().split()))
m=0
for i in a:
	if k%i==0:
		m=max(m,i)
print(int(k/m))		