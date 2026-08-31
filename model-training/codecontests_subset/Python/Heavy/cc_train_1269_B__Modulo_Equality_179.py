def check(a,b,n,diff):
    flag=list()
    for i in range(n):
        flag.append((a[i]+diff)%m)
    flag.sort()
    for i in range(n):
        if(flag[i]!=b[i]):
            return False
    return True
    
n,m=map(int,input().split())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
a.sort()
b.sort()
if(n==1):
    print((b[0]-a[0])%m)
else:
    mini=1000000006
    for i in range(n):
        diff=(b[i]-a[0])%m
        if(check(a,b,n,diff)):
            if(diff<mini):
                mini=diff
    print(mini)
            
            