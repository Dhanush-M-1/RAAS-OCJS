a,b=map(int,input().split())
cnt=0
cnt=cnt+a
while(a>=b):
	cnt=cnt+a//b
	a=a//b+a%b
print(cnt)