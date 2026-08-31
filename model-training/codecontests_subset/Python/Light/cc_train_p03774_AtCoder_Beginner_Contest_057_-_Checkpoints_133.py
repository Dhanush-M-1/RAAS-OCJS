n , m = map(int , input().split())
a =[]
b=[]
for i in range(n):
	a.append(list(map(int , input().split())))
for i in range(m):
	b.append(list(map(int, input().split())))
for i in range(n):
	now =10**9+90000
	idx=0
	for j in range(m):
		d=abs(a[i][0]-b[j][0])+abs(a[i][1]-b[j][1])
		if(d<now):
			now=d
			idx=j+1
	print(idx)