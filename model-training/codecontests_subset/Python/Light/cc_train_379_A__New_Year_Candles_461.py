a,b=map(int,input().split())
k=a
t=a
h=0
while(t>=b):
	k+=int(t/b)
	h=int(t%b)
	t=int(t/b)
	#print(t)
	t+=h

print(k)