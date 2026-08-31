n=int(input())
a=list(map(int,input().split()))
a.sort()
c=0
r=[]
for i in range(n):
	r.append(min(a[i]-1,1000000-a[i]))

print(max(r))