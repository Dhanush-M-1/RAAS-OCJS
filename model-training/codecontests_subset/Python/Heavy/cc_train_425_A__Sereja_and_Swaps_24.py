def f(a,k):
    ans=-float("inf")
    for i in range(len(a)+1):
        for j in range(i):
            mid=a[j:i]
            l=a[:j]+a[i:]
            # print(mid,l)
            l=sorted(l,reverse=True)
            mid=sorted(mid)
            s=sum(mid)
            ans=max(ans,s)
            kk=k
            while kk:
                if l and mid and s-mid[0]+l[0]>s :
                    s= s-mid[0]+l[0]
                    l.pop(0)
                    mid.pop(0)
                    kk-=1
                    ans=max(ans,s)
                else:
                    break
    return ans


n,k=map(int,input().strip().split())
a=list(map(int,input().strip().split()))
print(f(a,k))