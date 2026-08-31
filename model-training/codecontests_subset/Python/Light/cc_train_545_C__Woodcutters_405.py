a=2
n=int(input())
l=[]
for _ in range(n):
	x,h=map(int,input().split())
	l.append([x,h])
if n<3:print(n);exit()
t=l[0][0]
for i in range(1,n-1):
	x,h=l[i][0],l[i][1]
	if x-h>t:
		a+=1;t=x
	elif x+h<l[i+1][0]:
		a+=1;t=x+h
	else:
		t=x
print(a)