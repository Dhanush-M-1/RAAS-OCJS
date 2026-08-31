n=int(input())
a=sorted(list(map(int,input().split())))
b=sorted(list(map(int,input().split())))
c=sorted(list(map(int,input().split())))
f=0
for x in range(n-1):
	if a[x]!=b[x]:print(a[x]);f=1;break
if f==0:print(a[-1])
f=0
for x in range(n-2):
	if b[x]!=c[x]:print(b[x]);f=1;break
if f==0:print(b[-1])