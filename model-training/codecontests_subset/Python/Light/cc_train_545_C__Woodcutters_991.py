n=int(input())
l=[]
d=[]
for i in range(n):
	t1,t2=map(int,input().split())
	l.append(t1)
	d.append(t2)
if n>=2:
	out=2
elif n<2:
	out=n
for i in range(1,n-1):
	if d[i]<l[i]-l[i-1]:
		out+=1
	elif d[i]<l[i+1]-l[i]:
		out+=1
		l[i]+=d[i]
print(out)