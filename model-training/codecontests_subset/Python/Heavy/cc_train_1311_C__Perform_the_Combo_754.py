from collections import defaultdict
for _ in range(int(input())):
    N,K=map(int,input().split())
    L=list(input())
    M=list(map(int,input().split()))
    Hash=defaultdict(lambda:0)
    for i in range(K):
        M[i]=M[i]-1
        Hash[M[i]]+=1
    PrefixSum=defaultdict(lambda:0)
    X="abcdefghijklmnopqrstuvwxyz"
    Ans=defaultdict(lambda:0)
    for i in X:
        Ans[i]=0
    for i in X:
        PrefixSum[i]=0
    for i in range(N):
        PrefixSum[L[i]]+=1
        Ans[L[i]]=Ans[L[i]]+1
        if Hash[i]>0:
            for j in X:
                Ans[j]=Ans[j]+(PrefixSum[j])*Hash[i]
    for i in Ans.values():
        print(i,end=" ")
    print()

    
