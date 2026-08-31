t=1
while t>0 :
    n,k=map(int,input().split())
    a=[]
    b=[]
    c=[]
    ans=0
    for i in range(n) :
        ti,al,bo=map(int,input().split())
        if al==1 and bo==1 :
            c.append(ti)
        elif al==1 :
            a.append(ti)
        elif bo==1 :
            b.append(ti)
    a.sort()
    b.sort()
    for i in range(min(len(a),len(b))) :
        c.append(a[i]+b[i])
    c.sort()
    if len(c)<k :
        print(-1)
    else :
        print(sum(c[:k]))
   # print(a,b,c)
    # if len(c)+min(len(a),len(b))<k :
    #     print(-1)
    # else :
    #     for i in range(k) :
    #         if len(a)>0 and len(b)>0 :
    #             if len(c)>0 :
    #                 if a[0]+b[0]>c[0] :
    #                     ans +=c[0]
    #                     del c[0]
    #                 else :
    #                     ans+=a[0]+b[0]
    #                     del a[0]
    #                     del b[0]
    #             else :
    #                 ans+=sum(a[:k-i])+sum(b[:k-i])
    #                 break
    #         else :
    #             ans+=sum(c[:k-i])
    #             break
    #         #print(a,b,c,ans)
    #     print(ans)
    t-=1