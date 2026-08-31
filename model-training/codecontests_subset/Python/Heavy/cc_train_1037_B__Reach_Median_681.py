n,s=map(int,input().split())
l=list(map(int,input().split()))
l.sort()
if s<=l[0]:
    ans=0
    ans2=0
    for i in range(n//2):
        ans+=abs(s-l[i])
    ans+=abs(l[(n//2)]-s)
    print(ans)
elif s>l[-1]:
    ans=0
    ans2=0
    for i in range(n//2+1,n):
        ans+=abs(s-l[i])
    ans+=abs(l[(n//2)]-s)
    print(ans)
else:
    ans1=0
    ans2=0
    for i in range(n//2):
        if s<l[i]:
            ans1+=abs(s-l[i])
    for i in range(n//2+1,n):
        if s>l[i]:
            ans1+=abs(s-l[i])
    ans1+=abs(s-l[n//2])
    print(ans1)
    
