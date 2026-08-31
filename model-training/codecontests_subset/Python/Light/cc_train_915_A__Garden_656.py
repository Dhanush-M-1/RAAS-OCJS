a,b = map(int,input().split())
c = list(map(int,input().split()))
c.sort()
c.reverse()
for i in c:
	if b%i==0:
		print(b//i)
		break
