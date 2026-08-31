import collections as cc
import math as mt
import sys
input=sys.stdin.readline
I=lambda:list(map(int,input().split()))
n,k=I()
a=[]
for i in range(n):
	a.append(I())
a.sort()
both=[]
bs=0
f=0
for i in range(n):
	if a[i][1] and a[i][2]:
		both.append(a[i][0])


al=[]
bo=[]
for i in range(n):
	if a[i][1] and not a[i][2]:
		al.append(a[i][0])
	elif a[i][2] and not a[i][1]:
		bo.append(a[i][0])
su=[]
for i in range(min(len(al),len(bo))):
	su.append(al[i]+bo[i])

xx=len(both)
yy=len(su)
if xx+yy<k:
	print(-1)
elif both and not su:
	if xx>=k:
		print(sum(both[:k]))
	else:
		print(-1)
elif su and not both:
	if yy>=k:
		print(sum(su[:k]))
	else:
		print(-1)
else:
	i=0
	j=0
	cn=0
	ans=0
	while i<xx and j<yy:
		if both[i]<su[j]:
			ans+=both[i]
			i+=1
			cn+=1
		else:
			ans+=su[j]
			j+=1
			cn+=1
		if cn==k:
			break
	if cn<k:
		while i<xx:
			ans+=both[i]
			cn+=1
			i+=1
			if cn==k:
				break
	if cn<k:
		while j<yy:
			ans+=su[j]
			cn+=1
			j+=1
			if cn==k:
				break
	print(ans)

	