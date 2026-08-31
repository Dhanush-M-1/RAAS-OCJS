n = int(input())

a = list(map(int,input().split()))
b = list(map(int,input().split()))
c = list(map(int,input().split()))

a.sort()
b.sort()
c.sort()

flagb = False
for i in range(0,len(b)):
	if(a[i]!=b[i]):	
		print(a[i])
		flagb=True
		break
if flagb==False:
	print(a[-1])

flagc = False
for i in range(0,len(c)):
	if(b[i]!=c[i]):
		print(b[i])
		flagc=True
		break
if(flagc==False):
	print(b[-1])
