t=int(input())
while(t):
    t=t-1
    n=int(input())
    pp=[]
    kk=[]
    cc=n
    c=0
    while(n):
        n=n-1
        p,k=map(int,input().split(' '))
        pp.append(p)
        kk.append(k)
    #print(pp,kk)
    if(sorted(pp)!=pp or sorted(kk)!=kk):
        print("NO")
        #break;
    else:
        for i in range(len(pp)):
            if(pp[i]>=kk[i]):
                c=c+1
        for i in range(len(pp)-1):
            if(pp[i+1]-pp[i]<kk[i+1]-kk[i]):
                c=c-1
        #print(c,cc)
        if(c==cc):
            print("YES")
        else:
            print("NO")