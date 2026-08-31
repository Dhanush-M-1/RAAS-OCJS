n=int(input())
a=[int(x) for x in input().split()]
b=[int(x) for x in input().split()]
c=[int(x) for x in input().split()]
i=j=0;
a.sort()
b.sort()
c.sort()
deleted=0
while i<len(a) and j<len(b):
	if a[i]==b[j]:
		i+=1
		j+=1
	elif a[i]<b[j]:
		deleted=1
		print(a[i])
		break
if not deleted:
	print(a[n-1])
deleted=0
i=j=0
while i<len(b) and j<len(c):
	if b[i]==c[j]:
		i+=1
		j+=1
	elif b[i]<c[j]:
		deleted=1
		print(b[i])
		break
if not deleted:
	print(b[n-2])