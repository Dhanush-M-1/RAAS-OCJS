# import sys 
# sys.stdin=open("input.in",'r')
# sys.stdout=open("out.out",'w')
for i in range(int(input())):
	l,r,d=map(int,input().split())
	if d<l:
		print(d)
	else:
		x=r//d
		print((x+1)*d)
