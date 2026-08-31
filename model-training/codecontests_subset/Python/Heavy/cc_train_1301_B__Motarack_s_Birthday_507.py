for _ in range(int(input())):
    n=int(input())
    lst=list(map(int,input().split()))
    if lst[0]!=-1 and lst[1]==-1:
        low=lst[0]
        high=lst[0]
    else:
        low=max(lst)
        high=0
    for i in range(1,n-1):
        if lst[i]!=-1 and (lst[i-1]==-1 or lst[i+1]==-1):
            if lst[i]<low:
                low=lst[i]
            if lst[i]>high:
                high=lst[i]
    if lst[n-1]!=-1 and lst[n-2]==-1:
        if lst[n-1]>high:
            high=lst[n-1]
        if lst[n-1]<low:
            low=lst[n-1]
    ans=int((low+high)/2)
    poss=high-ans
    for i in range(n-1):
        if lst[i]!=-1 and lst[i+1]!=-1:
            temp=abs(lst[i]-lst[i+1])
            if temp>poss:
                poss=temp
    print(poss,ans)
