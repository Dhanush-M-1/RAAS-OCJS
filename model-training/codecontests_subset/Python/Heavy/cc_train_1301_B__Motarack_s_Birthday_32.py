for _ in range(int(input())):
    n=int(input())
    ls=[int(x) for x in input().split()]
    if ls.count(-1)==n: print(0,0)
    else:
        m1=1e9
        m2=-10
        for i in range(n):
            if i!=n-1 and ls[i+1]==-1 and ls[i]!=-1:
                m1=min(m1,ls[i])
                m2=max(ls[i],m2);
            if i!=0 and ls[i-1]==-1 and ls[i]!=-1:
                m1=min(m1,ls[i])
                m2=max(m2,ls[i]);
        rep=(m1+m2)//2
        for i in range(n):
            if ls[i]==-1: ls[i]=rep
        ans=-1e9
        for i in range(n-1):
            ans=max(ans,abs(ls[i+1]-ls[i]))
#             print(ans)
        print(ans,rep)