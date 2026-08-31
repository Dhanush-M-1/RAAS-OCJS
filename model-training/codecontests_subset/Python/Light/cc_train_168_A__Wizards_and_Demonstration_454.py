# import sys
# sys.stdin=open("input1.in","r")
# sys.stdout=open("OUTPUT3.out","w") 
n,x,y=map(int,input().split())
required=(y*n)//100+bool((y*n)%100)
if x>required:
	print(0)
else:
	print(required-x)
