n=int(input())

l1=list(map(int,input().split()))
l2=list(map(int,input().split()))
l3=list(map(int,input().split()))
l1.sort()
l2.sort()
l3.sort()
for x in range(n):
	try:
		if l1[x]!=l2[x]:
			k=l1[x]
			break
	except:
		k=l1[x]
		break
for x in range(n-1):
	try:
		if l2[x]!=l3[x]:
			q=l2[x]
			break
	except:
		q=l2[x]
		break
print(k)
print(q)