# import sys 
# sys.stdin=open("input1.in","r")
# sys.stdout=open("output2.out","w")
X,Y=input().split()
print(X,Y)
N=int(input())
for i in range(N):
	Z,M=input().split()
	if X==Z:
		X=M
	else:
		Y=M
	print(X,Y)

