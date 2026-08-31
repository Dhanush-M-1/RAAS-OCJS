n,k=map(int,input().split())
l1=[] #(0,1)
l2=[] #(1,0)
l3=[] #(1,1)
for i in range(n):
	t,a,b=map(int,input().split())
	if (a,b)==(1,1):
		l3.append(t)
	elif (a,b)==(0,1):
		l1.append(t)
	elif (a,b)==(1,0):
		l2.append(t)
s=0
l1.sort()
l2.sort()
l3.sort()
if len(l3)>=k:
	s=sum(l3[:k])
	p=0
	p1=k-1
else:
	s=sum(l3)
	v=k-len(l3)
	if len(l1)>=v and len(l2)>=v:
		s+=sum(l1[:v])+sum(l2[:v])
	else:
		print(-1)
		exit()
	p=v
	p1=len(l3)-1
while(p<len(l1) and p<len(l2) and p1>=0):
	if l1[p]+l2[p]<=l3[p1]:
		s=s-l3[p1]+l1[p]+l2[p]
		p1-=1
		p+=1
	else:
		break
print(s)