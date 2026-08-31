def find(A,K):
    counting=[[] for i in range(max(A)+1)]
    okay=[0]*(max(A)+1)
    for i in range(len(A)):
        count=0
        temp=A[i]
        
        while temp>0:
            counting[temp]+=[count]
            okay[temp]+=1
            temp=temp//2
            count+=1
        counting[temp]+=[count]
        okay[temp]+=1

    MIN=float("inf")
    for i in range(len(okay)):
        if okay[i]>=K:
            counting[i]=sorted(counting[i])
            MIN=min(MIN,sum(counting[i][:K]))
    #print(counting)
    #print(okay)
    return MIN
    
n,K=list(map(int,input().strip().split(" ")))
A=list(map(int,input().strip().split(" ")))
print(find(A,K))
    