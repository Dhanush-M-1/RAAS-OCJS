
        
    
    
    
for tc in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    if l.count(-1)==n:
        print(0,1)
        continue
    mi=10**9+7
    ma=-100
    for i in range(n-1):
        if l[i]==-1:
            if l[i+1]!=-1:
                if mi>l[i+1]:
                    mi=l[i+1]
                if ma<l[i+1]:
                    ma=l[i+1]
        else:
            if l[i+1]==-1:
                if mi>l[i]:
                    mi=l[i]
                if ma<l[i]:
                    ma=l[i]
    di=(ma+mi)//2
    for i in range(n):
        if l[i]==-1:
            l[i]=di
    ans=-100
    for i in range(n-1):
        if abs(l[i]-l[i+1])>ans:
            ans=abs(l[i]-l[i+1])
    print(ans,di)
        
        
        