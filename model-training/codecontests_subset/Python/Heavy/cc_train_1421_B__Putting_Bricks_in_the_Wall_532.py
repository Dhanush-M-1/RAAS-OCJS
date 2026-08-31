t=int(input())
while t:
    t-=1
    n=int(input())
    g=[]
    for i in range (n):
        l=list(map(str,input()))
        ln=len(l)
        g.append(l)
    s=[int(g[0][1]),int(g[1][0])]
    s1=s[0]
    s2=s[1]
    f=[int(g[n-1][ln-2]),int(g[n-2][ln-1])]
    f1=f[0]
    f2=f[1]
    if len(set(s))==1:
        if s1==1:
            if f1==f2==1:
                print(2)
                print(n,ln-1)
                print(n-1,ln)
            elif f1==f2==0:
                print(0)
            else:
                if f2==1:
                    print(1)
                    print(n-1,ln)
                else:
                    print(1)
                    print(n,ln-1)
        else:
            if f1==f2==0:
                print(2)
                print(n,ln-1)
                print(n-1,ln)
            elif f1==f2==1:
                print(0)
            else:
                if f2==0:
                    print(1)
                    print(n-1,ln)
                else:
                    print(1)
                    print(n,ln-1)
    else:
        if s1==0 and s2==1:
            
            if f1==f2==1:
                print(1)
                print(2,1)
            elif f1==f2==0:
                print(1)
                print(1,2)
            else:
                if f2==1:
                    print(2)
                    print(1,2)
                    print(n-1,ln)
                else:
                    print(2)
                    print(1,2)
                    print(n,ln-1)
        else:
            if f1==f2==1:
                print(1)
                print(1,2)
            elif f1==f2==0:
                print(1)
                print(2,1)
            else:
                if f2==1:
                    print(2)
                    print(2,1)
                    print(n-1,ln)
                else:
                    print(2)
                    print(2,1)
                    print(n,ln-1)
            
             