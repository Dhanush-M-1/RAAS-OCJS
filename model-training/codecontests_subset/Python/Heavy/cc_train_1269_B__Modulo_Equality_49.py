# import sys
# sys.stdin=open("input1.in","r")
# sys.stdout=open("outpul.out","w")
N,K=map(int,input().split())
L1=list(map(int,input().split()))
L2=list(map(int,input().split()))
L1.sort()
L2.sort()
if L1==L2:
    print(0)
else:
    mini=float("inf")
    for i in range(N):
        X=L1.copy()
        diff=(L2[i]-L1[0])%K
        if diff<=0:
            diff=diff+K
        for j in range(N):
            X[j]=(X[j]+diff)%K
        X.sort()
        if X==L2:
            if diff<mini:
                mini=diff
    print(mini)

