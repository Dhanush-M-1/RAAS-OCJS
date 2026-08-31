# import sys 
# sys.stdin=open("input1.in","r")
# sys.stdout=open("output2.out","w")
N,K=map(int,input().split())
L=list(map(int,input().split()))
L.sort(reverse=True)
for i in range(N):
	if K%L[i]==0:
		print(int(K/L[i]))
		break