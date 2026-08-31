n,k=map(int,input().split())
at=[]
bt=[]
both=[]
f=0
for x in range(n):
	t,a,b=map(int,input().split())
	if a==1 and b==1:
		both.append(t)
	elif a==1:
		at.append(t)
	elif b==1:
		bt.append(t)
at.sort()
bt.sort()
both.sort()
i=0
j=0
if len(at)+len(both)<k or len(bt)+len(both)<k:
	f=-1
else:
	for x in range(k):
		if i>=len(at) or i>=len(bt):
			i=-1
		if j>=len(both):
			j=-1
		if i==-1:
			f+=both[j]
			j+=1
		elif j==-1:
			f+=at[i]+bt[i]
			i+=1
		else:
			if at[i]+bt[i]<both[j]:
				f+=at[i]+bt[i]
				i+=1
			else:
				f+=both[j]
				j+=1
print(f)		
