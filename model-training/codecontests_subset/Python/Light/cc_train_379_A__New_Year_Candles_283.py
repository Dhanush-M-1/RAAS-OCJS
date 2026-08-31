a,b=map(int,input().split())
h=a
while a//b>0:
	h+=a//b
	a-=a//b*(b-1)
print(h)