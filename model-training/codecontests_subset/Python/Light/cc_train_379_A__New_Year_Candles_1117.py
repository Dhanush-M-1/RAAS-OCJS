# import sys
# sys.stdin = open("test.in","r")
# sys.stdout = open("test.out.py","w")
n,k=map(int,input().split())
a=n
while n>=k:
	a+=n//k
	n=n//k+n%k
print(a)	
