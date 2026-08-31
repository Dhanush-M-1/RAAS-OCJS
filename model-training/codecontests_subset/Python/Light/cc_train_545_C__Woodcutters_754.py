n=int(input())
p=[]
h=[]
for i in range(n):
	a,b=map(int,input().split())
	p.append(a)
	h.append(b)
s=2

for i in range(1,n-1):
	if p[i]-p[i-1]>h[i]:
		s+=1 
	elif p[i+1]-p[i]>h[i]:
		p[i]+=h[i]
		s+=1
if n==1:
	print(1)
else:
	print(s)
