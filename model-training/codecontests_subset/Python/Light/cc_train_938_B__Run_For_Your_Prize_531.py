n=int(input())
a=list(map(int,input().split(" ")))
mid=(1+10**6)/2
lis1=[]
lis2=[]

for i in a:
	if i>mid:
		lis2.append(i)
	else:
		lis1.append(i)
if len(lis1)!=0:
	aa=max(lis1)
else:
	aa=1
if len(lis2)!=0:
	bb=min(lis2)
else:
	bb=10**6

a1=abs(aa-1)
a2=abs(10**6-bb)

print(max(a1,a2))