import math
for i in range(int(input())):
    n=int(input())
    a=list(map(int,input().split())) 
    d={}
    for i in a:
        d[i]=d.get(i,0)+1
    b=list(d.keys())
    b.sort(reverse=True)
    low=0
    # print(b)
    high=len(b)
    l=len(b)
    # print(d)
    while low<high:
        mid=math.ceil((low+high)/2)
        # print("low ",mid,low,high)
        
        i=0
        ans0=0
        while i<mid:
            ans0+=d[b[i]]
            i+=1
        ans1=0
        while i<l:
            ans1+=d[b[i]]
            i+=1
            if ans1>ans0:
                # print(ans1,ans0)
                break
        ans2=0
        while i<l:
            ans2+=d[b[i]]
            i+=1
            if ans2>ans0:
                break
        # print(" ",ans0,ans1,ans2," ",mid,low,high)
        if (ans0 + ans1+ans2)<=n//2:
            low=mid
        else:
            high=mid-1
        # print(low,high)
    if low==0:
        print(0,0,0)
    else:
        # print(low,high)
        mid=low
        i=0
        ans0=0
        while i<mid:
            ans0+=d[b[i]]
            i+=1
        ans1=0
        while i<l:
            ans1+=d[b[i]]
            i+=1
            if ans1>ans0:
                break
            
        ans2=0
        while i<l:
            ans2+=d[b[i]]
            i+=1
            if ans2>ans0:
                break
        # print(" ",ans0,ans1,ans2," ",mid,low,high)
        
        while i<l:
            if ans2 + ans0 +  ans1 +d[b[i]]<=n//2:
                ans2+=d[b[i]]
                i+=1
            else:
                break
        print(ans0,ans1,ans2)
    # print(low)        