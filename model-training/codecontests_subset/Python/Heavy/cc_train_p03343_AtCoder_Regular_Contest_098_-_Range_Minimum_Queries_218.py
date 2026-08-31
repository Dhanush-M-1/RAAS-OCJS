N,K,Q=map(int,input().split())
A=list(map(int,input().split()))
a=list(set(A))
a.sort()
ans=float("inf")
def condition(i,num):
    if i>a[num]:
        return False
    X=a[num]
    Y=A[i]
    check=0
    stack=0
    count=0
    for k in range(0,N):
        if A[k]>X:
            stack+=1
        elif A[k]>=Y:
            stack+=1
            count+=1
        else:
            t=stack+1-K
            check+=max(min(t,count),0)
            stack=0
            count=0
    t=stack+1-K
    check+=max(min(t,count),0)
    return check>=Q

for i in range(0,N):
    start=0
    end=len(a)-1
    while end-start>1:
        test=(end+start)//2
        if condition(i,test):
            end=test
        else:
            start=test
    if condition(i,start):
        ans=min(ans,a[start]-A[i])
    elif condition(i,end):
        ans=min(ans,a[end]-A[i])
print(ans)
