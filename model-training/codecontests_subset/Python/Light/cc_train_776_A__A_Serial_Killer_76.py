# import sys 
# sys.stdin=open("input.in",'r')
# sys.stdout=open("out.out",'w')
a,b=input().split()
n=int(input())
for i in range(n):
	print(a,b)
	x,y=input().split()
	if a==x:
		a=y
	elif b==x:
		b=y

print(a,b)			