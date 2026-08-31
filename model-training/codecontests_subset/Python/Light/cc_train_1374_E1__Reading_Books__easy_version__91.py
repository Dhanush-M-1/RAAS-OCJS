import sys
input = sys.stdin.readline
I = lambda : list(map(int,input().split()))

n,k =I()
a=[];b=[]
ab=[]
for _ in range(n):
	x,y,z=I()
	if y and z:
		ab.append(x)
	elif y:
		a.append(x)
	elif z:
		b.append(x)
a.sort()
b.sort()
ab.sort()
x,y,z=len(a),len(b),len(ab)
i=j=l=t=an=0
if x+z <k or y+z<k:
	print(-1)
else:
	while t!=k:
		if i>=x or j>=y:
			an+=ab[l];l+=1
		elif l>=z:
			an+=a[i]+b[j]
			i+=1;j+=1
		else:
			if a[i]+b[j]<ab[l]:
				an+=a[i]+b[j]
				i+=1;j+=1
			else:
				an+=ab[l];l+=1
		t+=1
	print(an)
