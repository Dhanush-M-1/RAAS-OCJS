a,b=map(int,input().split())
t=a
while a>=b:
		t+=(a//b)
		a=((a//b)+(a%b))
print(t)