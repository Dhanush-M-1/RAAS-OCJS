n=int(input())
for _ in range(n):
    a,b=map(int,input().split())
    ar=sorted(map(int,input().split()))
    ar1=sorted(map(int,input().split()))
    t=min(len(ar),len(ar1))
    ans=0;count=0
    for i in range(t):
        if len(ar)<=len(ar1):
            if ar[i] in ar1:
                ans=ar[i]
                count=1
                break
        else:
            if ar1[i] in ar:
                ans=ar1[i]
                count=1
                break
    if count==1:
        print("YES")
        print(1,ans)
    else:
        print("NO")