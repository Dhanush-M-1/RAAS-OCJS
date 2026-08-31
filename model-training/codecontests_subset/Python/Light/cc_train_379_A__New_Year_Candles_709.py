a,b=map(int,input().split())
cnt=a
while a>=b:
	baqimande=a%b
	a=a//b
	cnt+=a
	a+=baqimande
print(cnt)