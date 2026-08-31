import sys

[n,m]=[int(i) for i in sys.stdin.readline().split()]

a=[int(j) for j in sys.stdin.readline().split()]

b=[int(k) for k in sys.stdin.readline().split()]

# b.sort()

ans=-2

for i in range(n):
	
	d={}

	for h in range(n):
		if(b[h] in d):
			d[b[h]]+=1
		else:
			d[b[h]]=1

	x=(b[i]-a[0])%m

	# darr={}

	done=1
	for j in range(n):
		# arr.append((a[j]+x)%m)	
		val=(a[j]+x)%m
		if(val in d and d[val]>0):
			d[val]-=1
		else:
			done=0
			break

	if(done==1):
		if(ans==-2):
			ans=x
		else:
			ans=min(ans,x)

print(ans)


	


