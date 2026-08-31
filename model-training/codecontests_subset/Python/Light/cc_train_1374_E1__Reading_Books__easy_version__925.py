n, k = map(int,input().split())
sam = []; alic =[]; bob =[]
for i in range(n):
	a = list(map(int,input().split()))
	if a[1] and a[2]:
		sam.append(a[0])
	elif a[1]:
		alic.append(a[0])
	elif a[2]:
		bob.append(a[0])
sam.sort()
alic.sort()
bob.sort()
q = min(len(alic), len(bob))
for i in range(q):
	sam.append(alic[i] + bob[i])
sam.sort()
ans = 0
i = 0
if k > len(sam):
	print(-1)
else:
	while i <k:
		ans+= sam[i]
		i+=1
	print(ans)