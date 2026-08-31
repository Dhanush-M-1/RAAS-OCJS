n,m= input().split()
print(n,m)
num = int(input())
for i in range(num):
	a,b=input().split()
	if(a==n):
		print(b,m)
		n=b
	else:
		print(b,n)
		m=b
	