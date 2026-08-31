# import sys
# sys.stdin = open("test.in","r")
# sys.stdout = open("test.out.py","w")
for _ in range(int(input())):
	l,r,d=map(int,input().split())
	if d<l:
		print(d)
	else:
		x=r//d
		print((x+1)*d)