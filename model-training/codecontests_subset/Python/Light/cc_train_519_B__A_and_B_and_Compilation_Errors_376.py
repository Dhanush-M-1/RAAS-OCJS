n=int(input())
l1=list(map(int,input().split()))
l2=list(map(int,input().split()))
l3=list(map(int,input().split()))

l1.sort()
l2.sort()
l3.sort()

a,b=0,0

for i in range(n-1):
	if l1[i]!=l2[i]:
		a=l1[i]
		break
	a=l1[n-1]
for i in range(n-2):
	if l2[i]!=l3[i]:
		b=l2[i]
		break
	b=l2[n-2]
print(a)
print(b)