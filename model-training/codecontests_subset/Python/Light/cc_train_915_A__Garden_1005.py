s=input().split()
n=int(s[0])
k=int(s[1])
ss=list(map(int,input().split()))
y=0
for x in ss:
	if k%x==0 and x>y:
		y=x
print(k//y)
