# import sys
# sys.stdin = open("test.in","r")
# sys.stdout = open("test.out","w")
n,k=map(int,input().split())
a=list(map(int,input().split()))
l=[]
for i in range(len(a)):
	if k%a[i]==0:
		l.append(int(k/a[i]))
print(min(l))		